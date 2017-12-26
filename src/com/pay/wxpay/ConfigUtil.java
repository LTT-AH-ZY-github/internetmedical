/**
 * 
 */
package com.pay.wxpay;

import com.medical.utils.Global;

/**
 * @ClassName:     ConfigUtil.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月4日 上午11:12:56 
 */
public class ConfigUtil {
    /**
     * 服务号相关信息
     */
     public final static String APPID = "***";//服务号的应用号
     public final static String MCH_ID = "***";//商户号
     public final static String API_KEY = "***";//API密钥
     public final static String SIGN_TYPE = "MD5";//签名加密方式
   //病人支付医生回调路径
 	public static String DOCTOR_NOTIFY_URL = Global.HTTP_URL+"internetmedical/user/paydoctorfinishbywxpay";
 	
 	//病人支付医院回调路径
 	public static String HSOP_NOTIFY_URL = Global.HTTP_URL+"internetmedical/user/payhospitalfinishbywxpay";
 	
 	//医院支付医生回调路径
 	public static String WEB_HSOP_NOTIFY_URL = Global.HTTP_URL+"internetmedical/hospital/paydoctorfinishbywxpay";

    public final static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
}
