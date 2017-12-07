/**
 * 
 */
package com.medical.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName:     TimeUtil.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月7日 上午10:33:47 
 */
public class TimeUtil {
	public static String dateToStrLong(Date dateDate) {
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		   String dateString = formatter.format(dateDate);
		   return dateString;
		}
}
