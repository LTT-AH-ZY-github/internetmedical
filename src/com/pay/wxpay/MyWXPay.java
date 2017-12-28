package com.pay.wxpay;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.jdom.JDOMException;
import com.medical.utils.result.DataResult;


/**
 * @ClassName:     MyWXPay.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月27日 下午1:26:16 
 */
public class MyWXPay {
	
	public static void main(String[] args) {
		System.out.println(wxPrePay("测试", "测试", new BigDecimal(0.01), "http://test.letiantian.me/wxpay/notify", "201701017496748980290321", "123.12.12.123", "APP"));
	}
	/**
	 * 微信统一下单接口
	 * 
	 * @param request
	 * @param response
	 */
	public static String wxPrePay(String boby,String attach,BigDecimal price,String notify_url,String out_trade_no,String ip,String trade_type) {
		WXPayExample wxPayExample;
		try {
			wxPayExample = new WXPayExample();
			Map<String, String> map=  wxPayExample.doUnifiedOrder(boby, out_trade_no, price, ip, notify_url, trade_type);
			if ("FAIL".equals(map.get("return_code"))) {
				return DataResult.error("通信异常");
			}
			if ("FAIL".equals(map.get("result_code"))) {
				return DataResult.error(map.get("err_code_des"));
			}
			return DataResult.success("获取成功", map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DataResult.error("异常错误");
		
	}

	public static Map<String, String> wxNotify(HttpServletRequest request) throws IOException, JDOMException {
		WXPayExample wxPayExample;
		try {
			wxPayExample = new WXPayExample();

			Map<String, String> map=  wxPayExample.wxNotify(request);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

	}
}
