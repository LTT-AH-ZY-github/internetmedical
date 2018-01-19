package com.pay.wxpay;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

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
	
	/**
	 * @Title: doOrderQuery
	 * @Description: TODO
	 * @param out_trade_no 本地生成的订单号
	 * @return
	 * @return: Map<String,String>
	 */
	public Map<String, String> doOrderQuery(String out_trade_no,String trade_no) {
		Map<String, String> data = new HashMap<String, String>();
		if (StringUtils.isNotBlank(out_trade_no)) {
			data.put("out_trade_no", out_trade_no);
		}else {
			data.put("transaction_id", trade_no);
		}
		try {
			Map<String, String> resp = wxpay.orderQuery(data);
			System.out.println(resp);
			return resp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @Title: refunQuery
	 * @Description: TODO
	 * @return: void
	 */
	public  Map<String, String> refundQuery(String out_trade_no,String trade_no,String out_refund_no,String refund_id) {
		

        Map<String, String> data = new HashMap<String, String>();
        if (StringUtils.isNotBlank(refund_id)) {
        	data.put("refund_id", refund_id);
		}else if (StringUtils.isNotBlank(out_refund_no)) {
			data.put("out_refund_no", out_refund_no);
		}else if (StringUtils.isNotBlank(trade_no)) {
			data.put("transaction_id", trade_no);
		}else {
			data.put("out_trade_no", out_trade_no);
		}
        try {
            Map<String, String> resp = wxpay.refundQuery(data);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	public  Map<String, String> refund(String trade_no,String out_refund_no,BigDecimal total_fee,BigDecimal refund_fee,String refund_desc) {
		int total_fee100 = total_fee.multiply(new BigDecimal(100)).intValue();
		int refund_fee100 = refund_fee.multiply(new BigDecimal(100)).intValue();
        Map<String, String> data = new HashMap<String, String>();
        data.put("out_refund_no", out_refund_no);
		data.put("transaction_id", trade_no);
		data.put("total_fee", String.valueOf(total_fee100));
		data.put("refund_fee", String.valueOf(refund_fee100));
		data.put("refund_desc", refund_desc);
		try {
            Map<String, String> resp = wxpay.refund(data);
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
	/**
	 * @Title: downloadBill
	 * @Description: TODO
	 * @return: void
	 */
	public Map<String, String> downloadBill(String billdate,String billtype) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("bill_date", billdate);
		data.put("bill_type", billtype);
		try {
	         Map<String, String> resp = wxpay.downloadBill(data);
	         System.out.println(resp);
	         return resp;
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
		return null;
		

	}
	 
}
