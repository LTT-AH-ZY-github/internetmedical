/**  
* @Title: IpUtils.java  
* @Package com.medical.utils  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月25日  
* @version V1.0  
*/  
package com.medical.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName:     IpUtils.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月25日 下午9:54:24 
 */
public class IpUtils {
	 public static String getIpAddr(HttpServletRequest request) {  
         String ip = request.getHeader("X-Forwarded-For");  
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
             ip = request.getHeader("Proxy-Client-IP");  
         }  
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
             ip = request.getHeader("WL-Proxy-Client-IP");  
         }  
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
             ip = request.getHeader("HTTP_CLIENT_IP");  
         }  
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
             ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
         }  
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
             ip = request.getRemoteAddr();  
         }  
         return ip;  
     }  
}
