/**
 * 
 */
package com.pay.wxpay;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

import org.jdom.JDOMException;

import com.medical.utils.result.DataResult;

/**
 * @ClassName: GetSign.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xyh
 * @version V1.0
 * @Date 2017年12月4日 上午11:11:40
 */
public class WXPay {
	/**
	 * 微信统一下单接口
	 * 
	 * @param request
	 * @param response
	 */

	public static String wxPrePay(String boby,String attach,BigDecimal price,String notify_url,String out_trade_no,String ip) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int price100 = price.multiply(new BigDecimal(100)).intValue();
		if (price100 <= 0) {
			resultMap.put("msg", "付款金额错误");
			resultMap.put("code", "500");
			return DataResult.error( "付款金额错误");
		}
		// 设置回调地址-获取当前的地址拼接回调地址
		//String url = request.getRequestURL().toString();
		//String domain = url.substring(0, url.length() - 13);
		// 生产环境
		//String notify_url = domain + "wxNotify.html";
		// 测试环境
		// String notify_url = "http://1f504p5895.51mypc.cn/cia/app/wxNotify.html";

		SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
		parameters.put("appid", ConfigUtil.APPID);
		parameters.put("mch_id", ConfigUtil.MCH_ID);
		
		parameters.put("nonce_str", PayCommonUtil.CreateNoncestr());
		parameters.put("body", boby);
		parameters.put("attach", attach);
		parameters.put("out_trade_no", out_trade_no); // 订单id
		parameters.put("fee_type", "CNY");
		parameters.put("total_fee", String.valueOf(price100));
		parameters.put("spbill_create_ip", ip);
		parameters.put("notify_url", notify_url);
		parameters.put("trade_type", "APP");
		// 设置签名
		String sign = PayCommonUtil.createSign("UTF-8", parameters);
		parameters.put("sign", sign);
		// 封装请求参数结束
		String requestXML = PayCommonUtil.getRequestXml(parameters);
		// 调用统一下单接口
		String result = PayCommonUtil.httpsRequest(ConfigUtil.UNIFIED_ORDER_URL, "POST", requestXML);
		System.out.println("\n" + result);
		try {
			/**
			 * 统一下单接口返回正常的prepay_id，再按签名规范重新生成签名后，将数据传输给APP。参与签名的字段名为appId，partnerId，prepayId，nonceStr，timeStamp，package。注意：package的值格式为Sign=WXPay
			 **/
			Map<String, String> map = XMLUtil.doXMLParse(result);
			SortedMap<Object, Object> parameterMap2 = new TreeMap<Object, Object>();
			parameterMap2.put("appid", ConfigUtil.APPID);
			parameterMap2.put("partnerid", ConfigUtil.MCH_ID);
			parameterMap2.put("prepayid", map.get("prepay_id"));
			parameterMap2.put("package", "Sign=WXPay");
			parameterMap2.put("noncestr", PayCommonUtil.CreateNoncestr());
			// 本来生成的时间戳是13位，但是ios必须是10位，所以截取了一下
			parameterMap2.put("timestamp",
					Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0, 10)));
			return PayCommonUtil.createSign("UTF-8", parameterMap2);
//			parameterMap2.put("sign", sign2);
//			resultMap.put("code", "200");
//			resultMap.put("msg", parameterMap2);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static SortedMap<Object, Object> wxNotify(HttpServletRequest request) throws IOException, JDOMException {
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
		// 解析xml成map
		Map<String, String> m = new HashMap<String, String>();
		m = XMLUtil.doXMLParse(sb.toString());
		for (Object keyValue : m.keySet()) {
			System.out.println(keyValue + "=" + m.get(keyValue));
		}
		// 过滤空 设置 TreeMap
		SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
		Iterator it = m.keySet().iterator();
		while (it.hasNext()) {
			String parameter = (String) it.next();
			String parameterValue = m.get(parameter);

			String v = "";
			if (null != parameterValue) {
				v = parameterValue.trim();
			}
			packageParams.put(parameter, v);
		}

		// 判断签名是否正确
		String resXml = "";
		if (PayCommonUtil.isTenpaySign("UTF-8", packageParams)) {
			return packageParams;
		}else {
			return null;
		}
//			if ("SUCCESS".equals((String) packageParams.get("result_code"))) {
//				// 这里是支付成功
//				////////// 执行自己的业务逻辑////////////////
//				String mch_id = (String) packageParams.get("mch_id"); // 商户号
//				String openid = (String) packageParams.get("openid"); // 用户标识
//				String out_trade_no = (String) packageParams.get("out_trade_no"); // 商户订单号
//				String total_fee = (String) packageParams.get("total_fee");
//				String transaction_id = (String) packageParams.get("transaction_id"); // 微信支付订单号
//				GoodsTrade gt = new GoodsTrade();
//				gt.setTid(out_trade_no);
//				// 查询订单 根据订单号查询订单 GoodsTrade -订单实体类
//				GoodsTrade trade = 订单查询;
//
//				if (!ConfigUtil.MCH_ID.equals(mch_id) || trade == null || new BigDecimal(total_fee)
//						.compareTo(new BigDecimal(trade.getPrice()).multiply(new BigDecimal(100))) != 0) {
//					// logger.info("支付失败,错误信息：" + "参数错误");
//					resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
//							+ "<return_msg><![CDATA[参数错误]]></return_msg>" + "</xml> ";
//				} else {
//					if ("no_pay".equals(trade.getPayStatus()) && "wait_buyer_pay".equals(trade.getStatus())) {// 支付的价格
//						// 订单状态的修改。根据实际业务逻辑执行
//
//						resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
//								+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
//
//					} else {
//						resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
//								+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
//						// logger.info("订单已处理");
//					}
//				}
//
//			} else {
//				// logger.info("支付失败,错误信息：" + packageParams.get("err_code"));
//				resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
//						+ "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
//			}
//
//		} else {
//			resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
//					+ "<return_msg><![CDATA[通知签名验证失败]]></return_msg>" + "</xml> ";
//			// logger.info("通知签名验证失败");
//		}
//
//		// ------------------------------
//		// 处理业务完毕
//		// ------------------------------
//		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
//		out.write(resXml.getBytes());
//		out.flush();
//		out.close();

	}
}
