/**  
* @Title: DateUtil.java  
* @Package com.medical.utils  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月23日  
* @version V1.0  
*/  
package com.medical.utils;

import java.util.Calendar;

/**
 * @ClassName:     DateUtil.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月23日 上午10:19:37 
 */
public class DateUtil {
	
	public static String getDateSx(){
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (hour < 12) {
			return "上午";
		}else if (hour<18) {
			return "下午";
		}else {
			return "晚上";
		}
		
	}
}
