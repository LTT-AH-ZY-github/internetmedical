package com.pay.alipay;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

public class AliPayNotify {

	public static Map<String, String> aliPayNotify(Map<String, String[]> requestParams) {
		
		Map<String, String> map = new HashMap<>(16);
		System.out.println("支付宝支付结果通知"+requestParams.toString());
		//获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
          }
          //乱码解决，这段代码在出现乱码时使用。
          //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
          params.put(name, valueStr);
         }
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        try {
        	//验签
        	boolean flag = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGN_TYPE);
        	if (flag) {
        		return params;
        	}
		} catch (AlipayApiException e) {
			map.put("trade_status", "error");
			 // TODO Auto-generated catch block
            e.printStackTrace();
		}
        map.put("trade_status", "error");
		return map;
	      
	   
	}
}
