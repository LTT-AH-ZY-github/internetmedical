package com.pay.wxpay;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;

/**
 * @ClassName: WXPay.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xyh
 * @version V1.0
 * @Date 2017年12月27日 上午10:19:54
 */
public class WXPayExample {

	private WXPay wxpay;
	private MyConfig config;

	public WXPayExample() throws Exception {
		config = MyConfig.getInstance();
		wxpay = new WXPay(config);
	}

	public Map<String, String> doUnifiedOrder(String boby, String out_trade_no, BigDecimal price,
			String spbill_create_ip, String notify_url, String trade_type) {
		int price100 = price.multiply(new BigDecimal(100)).intValue();
		Map<String, String> data = new HashMap<String, String>();
		data.put("body", boby);
		data.put("out_trade_no", out_trade_no);
		// data.put("device_info", "");
		data.put("fee_type", "CNY");
		data.put("total_fee", String.valueOf(price100));
		data.put("spbill_create_ip", spbill_create_ip);
		data.put("notify_url", notify_url);
		data.put("trade_type", trade_type); // 此处指定为扫码支付
		// data.put("product_id", "12");

		try {
			Map<String, String> resp = wxpay.unifiedOrder(data);
			System.out.println(resp);
			return resp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, String> doOrderQuery() {
		Map<String, String> data = new HashMap<String, String>();
		data.put("out_trade_no", "2016090910595900000012");

		try {
			Map<String, String> resp = wxpay.orderQuery(data);
			System.out.println(resp);
			return resp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, String> wxNotify(HttpServletRequest request) throws Exception {
		// 读取参数
		InputStream inputStream;
		StringBuffer sb = new StringBuffer();
		inputStream = request.getInputStream();
		String s;
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		while ((s = in.readLine()) != null) {
			sb.append(s);
		}
		in.close();
		inputStream.close();
		String notifyData = sb.toString(); // 支付结果通知的xml格式数据
		try {
			Map<String, String> notifyMap = WXPayUtil.xmlToMap(notifyData); // 转换成map
			if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {
				// 签名正确
				// 进行处理。
				// 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户侧订单状态从退款改成支付成功
				return notifyMap;
			} else {
				return null;
				// 签名错误，如果数据里没有sign字段，也认为是签名错误
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
