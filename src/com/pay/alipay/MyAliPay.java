/**
 * 
 */
package com.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;

/**
 * @ClassName: WebGetSign.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xyh
 * @version V1.0
 * @Date 2017年11月28日 下午2:02:22
 */
public class MyAliPay {
	
	/**
	 * @Title: webGetSign
	 * @Description: web端支付获取签名
	 * @param body
	 * @param subject
	 * @param totalAmount
	 * @param out_trade_no
	 * @param notifyUrl
	 * @return
	 * @throws AlipayApiException
	 * @return: String
	 */
	public static String webGetSign(String body, String subject, String totalAmount, String out_trade_no,
			String notifyUrl) throws AlipayApiException {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAYURL, AlipayConfig.APP_ID,
				AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,
				AlipayConfig.SIGN_TYPE);

		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.RETURN_URL);
		alipayRequest.setNotifyUrl(notifyUrl);

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + totalAmount
				+ "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		String orderStr = "";
		try {
	        //这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradePagePayResponse response = alipayClient.pageExecute(alipayRequest);
			orderStr = response.getBody();
	        System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
	    } catch (AlipayApiException e) {
	        e.printStackTrace();
	    }
		return orderStr;
	}
	
	/**
	 * @Title: appGetSign
	 * @Description: app端支付获取签名
	 * @param boby
	 * @param subject
	 * @param totalAmount
	 * @param out_trade_no
	 * @param notifyUrl
	 * @return
	 * @return: String
	 */
	public static String appGetSign(String boby, String subject, String totalAmount, String out_trade_no,
			String notifyUrl) {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAYURL, AlipayConfig.APP_ID,
				AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,
				AlipayConfig.SIGN_TYPE);

		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();

		model.setBody(boby);
		model.setSubject(subject);
		model.setOutTradeNo(out_trade_no);
		model.setTimeoutExpress("30m");
		model.setTotalAmount(totalAmount);
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl(notifyUrl);
		String orderStr = "";
		try {
			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			orderStr = response.getBody();
			System.out.println(response.getBody());// 就是orderString 可以直接给客户端请求，无需再做处理。
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return orderStr;
	}
	
	public static AlipayFundTransToaccountTransferResponse doTransfer(String out_biz_no, String payee_account, String amount,String payer_show_name,
			String payee_real_name,String remark) {
		
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAYURL, AlipayConfig.APP_ID,
				AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);
		
		AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
	
		request.setBizContent("{" +
				"    \"out_biz_no\":\""+out_biz_no+"\"," +
				"    \"payee_type\":\"ALIPAY_LOGONID\"," +
				"    \"payee_account\":\""+payee_account+"\"," +
				"    \"amount\":\""+amount+"\"," +
				"    \"payer_show_name\":\""+payer_show_name+"\"," +
				"    \"payee_real_name\":\""+payee_real_name+"\"," +
				"    \"remark\":\""+remark+"\"," +
				"  }");
		AlipayFundTransToaccountTransferResponse response;
		try {
			response = alipayClient.execute(request);
			return response;
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
}
