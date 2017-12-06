/**
 * 
 */
package com.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

/**
 * @ClassName: WebGetSign.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xyh
 * @version V1.0
 * @Date 2017年11月28日 下午2:02:22
 */
public class GetSign {
	public static AlipayTradeAppPayResponse response;

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

		// 请求
		return alipayClient.pageExecute(alipayRequest).getBody();
	}

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
		/*
		 * model.setPassbackParams("我是测试数据");; //描述信息 添加附加数据
		 * model.setSubject("App支付测试Java"); //商品标题
		 * model.setOutTradeNo("100342312764512"); //商家订单编号
		 * model.setTimeoutExpress("30m"); //超时关闭该订单时间 model.setTotalAmount("0.01");
		 * //订单总金额 model.setProductCode("QUICK_MSECURITY_PAY");
		 * //销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
		 */ request.setBizModel(model);
		// request.setNotifyUrl("商户外网可以访问的异步地址");
		request.setNotifyUrl(notifyUrl);
		try {
			// 这里和普通的接口调用不同，使用的是sdkExecute
			response = alipayClient.sdkExecute(request);
			System.out.println(response.getBody());// 就是orderString 可以直接给客户端请求，无需再做处理。
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return response.getBody();
	}
}
