package com.pay.wxpay;

import com.medical.utils.Global;

/**
 * @ClassName:     ConfigUtil.java
 * @Description:   微信支付回调连接
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月4日 上午11:12:56 
 */
public class ConfigUtil {
   
    /**  
 	* @Fields 病人支付医生回调路径 
 	*/ 
 	public static String DOCTOR_NOTIFY_URL = Global.HTTP_URL+"internetmedical/user/paydoctorfinishbywxpay";
 	
 	/**  
 	* @Fields 病人支付医院回调路径 
 	*/ 
 	public static String HSOP_NOTIFY_URL = Global.HTTP_URL+"internetmedical/user/payhospitalfinishbywxpay";
 	
 	
 	/**  
 	* @Fields 医院支付医生回调路径 
 	*/ 
 	public static String WEB_HSOP_NOTIFY_URL = Global.HTTP_URL+"internetmedical/hospital/paydoctorfinishbywxpay";

    
}
