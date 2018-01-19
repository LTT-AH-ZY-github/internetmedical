/**
 * 
 */
package com.pay.alipay;

import org.apache.commons.lang3.StringUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;

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
	
	/**
	 * @Title: doTransfer
	 * @Description: 支付宝转账
	 * @param out_biz_no 本地生成单号
	 * @param payee_account 收款支付宝账号
	 * @param payee_real_name 收款者姓名 
	 * @param amount 收款金额
	 * @param payer_show_name 付款者姓名(显示给对方)
	 * @param remark 备注
	 * @return
	 * @return: AlipayFundTransToaccountTransferResponse
	 */
	public static AlipayFundTransToaccountTransferResponse doTransfer(String out_biz_no, String payee_account,String payee_real_name, String amount,
			String payer_show_name,String remark) {
		
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

	/**
	 * @Title: doReFund
	 * @Description: 退款操作
	 * @param out_trade_no 本地订单号
	 * @param trade_no 支付宝订单号
	 * @param refund_amount 退款金额
	 * @param refund_reason 退款理由 
	 * @param out_request_no 本地生成退款订单号
	 * @return
	 * @return: AlipayTradeRefundResponse
	 */
	public static AlipayTradeRefundResponse doReFund(String trade_no ,  String refund_amount,String refund_reason,
			String out_request_no) {
		
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAYURL, AlipayConfig.APP_ID,
				AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);
		
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
	
		request.setBizContent("{" +
				"\"trade_no\":\""+trade_no+"\"," +
				"\"refund_amount\":"+refund_amount+"," +
				"\"refund_reason\":\""+refund_reason+"\"," +
				"\"out_request_no\":\""+out_request_no+"\"," +
				"\"operator_id\":\"OP001\"," +
				"\"store_id\":\"NJ_S_001\"," +
				"\"terminal_id\":\"NJ_T_001\"" +
				"  }");
		AlipayTradeRefundResponse response = null;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	
	public static AlipayTradeFastpayRefundQueryResponse doReFundQuery(String trade_no , String out_trade_no,String out_request_no) {
		
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAYURL, AlipayConfig.APP_ID,
				AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);
		
		AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
		if (StringUtils.isNotBlank(trade_no)) {
			request.setBizContent("{" +
					"\"out_trade_no\":\""+out_trade_no+"\"," +
					"\"out_request_no\":\""+out_request_no+"\"" +
					"}");
		}else {
			request.setBizContent("{" +
					"\"trade_no\":\""+trade_no+"\"," +
					"\"out_request_no\":\""+out_request_no+"\"" +
					"}");
		}
		AlipayTradeFastpayRefundQueryResponse response = null;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	/**
	 * @return 
	 * @Title: doOrderQuery
	 * @Description: TODO
	 * @return: void
	 */
	public static AlipayTradeQueryResponse doOrderQuery(String out_trade_no ,String trade_no) {
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAYURL, AlipayConfig.APP_ID,
				AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		if (StringUtils.isNotBlank(out_trade_no)) {
			request.setBizContent("{" +
					"\"out_trade_no\":\""+out_trade_no+"\"" +
				"}");
		}else {
			request.setBizContent("{" +
					"\"trade_no\":\""+trade_no+"\"" +
					"}");
		}
		
		AlipayTradeQueryResponse response = null;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}
	/**
	 * @return 
	 * @Title: DownloadBill
	 * @Description: TODO
	 * @return: void
	 */
	public static AlipayDataDataserviceBillDownloadurlQueryResponse downloadBill(String bill_type,String bill_date ) {
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAYURL, AlipayConfig.APP_ID,
				AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);
		AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
		request.setBizContent("{" +
		"\"bill_type\":\""+bill_type+"\"," +
		"\"bill_date\":\""+bill_date+"\"" +
		"  }");
		AlipayDataDataserviceBillDownloadurlQueryResponse response = null;
		try {
			response = alipayClient.execute(request);
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}
	public static void main(String[] args) {
		System.out.println(doReFundQuery("2018011621001004420236384612","aud20180116104429399000",  "re20180116105100851001").getBody());
	}
	
}
