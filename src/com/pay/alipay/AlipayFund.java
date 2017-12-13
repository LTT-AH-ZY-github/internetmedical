/**  
* @Title: AlipayFund.java  
* @Package com.pay.alipay  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月13日  
* @version V1.0  
*/
package com.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.medical.utils.result.DataResult;

/**
 * @ClassName: AlipayFund.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xyh
 * @version V1.0
 * @Date 2017年12月13日 上午11:09:54
 */
public class AlipayFund {
	
	public static AlipayFundTransToaccountTransferResponse doFund(String out_biz_no, String payee_account, String amount,String payer_show_name,
			String payee_real_name,String remark) throws AlipayApiException {
		
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
		AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);
		return response;
	}
	
}
