package com.pay.wxpay;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.jdom.JDOMException;

import com.medical.utils.MD5Util;
import com.medical.utils.result.DataResult;

import net.sf.json.JSONObject;
import okio.Utf8;



/**
 * @ClassName:     MyWXPay.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月27日 下午1:26:16 
 */
public class MyWXPay {
	
public static void main(String[] args) {
		
		System.out.println(wxPrePay("测试", "测试", new BigDecimal("1"), "http://test.letiantian.me/wxpay/notify", "12305600122D", "123.12.12.123", "APP"));
	}
	
	/**
	 * @Title: wxPrePay
	 * @Description:微信统一下单接口
	 * @param boby 标题
	 * @param attach 补充 
	 * @param price 价格
	 * @param notify_url 通知地址
	 * @param out_trade_no 本地生成单号
	 * @param ip ip地址
	 * @param trade_type "APP"为app支付  "NATIVE"为扫码支付
	 * @return
	 * @return: String
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
			
			long currentTimeMillis = System.currentTimeMillis();//生成时间戳
			long second = currentTimeMillis / 1000L;//（转换成秒）
			String seconds = String.valueOf(second).substring(0, 10);//（截取前10位）
			System.out.println(map);
			SortedMap<Object,Object> data =  new TreeMap();  
			// 
			data.put("appid", "wxd97a67a007393b4e");  
			data.put("partnerid", "1497265642");
			data.put("prepayid",map.get("prepay_id")); 
			data.put("noncestr", map.get("nonce_str")); 
			data.put("timestamp", seconds);  
			data.put("package","Sign=WXPay");  
			String characterEncoding = "UTF-8";    
		    String mySign = createSign(characterEncoding,data);   
		    data.put("sign",mySign);  
		    System.out.println("我 的签名是："+mySign);   
		    //data.put("key", "q7uv1349nx0da2pto9cmo8gku3zs6nx9"); 
			return DataResult.success("获取成功", data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DataResult.error("异常错误");
		
	}
	  public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){    
	       StringBuffer sb = new StringBuffer();    
	       Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）    
	       Iterator it = es.iterator();    
	       while(it.hasNext()) {    
	           Map.Entry entry = (Map.Entry)it.next();    
	           String k = (String)entry.getKey();    
	           Object v = entry.getValue();    
	           if(null != v && !"".equals(v)     
	                   && !"sign".equals(k) && !"key".equals(k)) {    
	               sb.append(k + "=" + v + "&");    
	           }    
	       }    
	        
	       sb.append("key=" + "q7uv1349nx0da2pto9cmo8gku3zs6nx9");    
	       System.out.println("字符串:"+sb.toString());  
	       String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();    
	       return sign;    
	   }    
	
	/**
	 * @Title: wxNotify
	 * @Description: 通知接口
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws JDOMException
	 * @return: Map<String,String>
	 */
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
	
	/**
	 * @Title: getOrderQuery
	 * @Description: 获取微信交易记录
	 * @return: void
	 */
	public static Map<String, String> getOrderQuery(String out_trade_no,String trade_no) {
		WXPayExample wxPayExample;
		try {
			wxPayExample = new WXPayExample();
			Map<String, String> map=  wxPayExample.doOrderQuery(out_trade_no, trade_no);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	/**
	 * @Title: doRefund
	 * @Description: TODO
	 * @return: void
	 */
	public static Map<String, String> doRefund(String trade_no,String out_refund_no,BigDecimal total_fee,BigDecimal refund_fee,String refund_desc) {
		WXPayExample wxPayExample;
		try {
			wxPayExample = new WXPayExample();
			Map<String, String> map=  wxPayExample.refund( trade_no, out_refund_no, total_fee, refund_fee, refund_desc);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	/**
	 * @Title: getRefundQuery
	 * @Description:退款查询
	 * @param out_trade_no
	 * @param trade_no
	 * @param out_refund_no
	 * @param refund_id
	 * @return
	 * @return: Map<String,String>
	 */
	public static Map<String, String> getRefundQuery(String out_trade_no,String trade_no,String out_refund_no,String refund_id) {
		WXPayExample wxPayExample;
		try {
			wxPayExample = new WXPayExample();
			Map<String, String> map=  wxPayExample.refundQuery(out_trade_no, trade_no, out_refund_no, refund_id);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	public static Map<String, String> downloadBill(String billdate,String billtype) {
		WXPayExample wxPayExample;
		try {
			wxPayExample = new WXPayExample();

			Map<String, String> map=  wxPayExample.downloadBill(billdate, billtype);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
