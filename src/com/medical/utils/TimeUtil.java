/**
 * 
 */
package com.medical.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: TimeUtil.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xyh
 * @version V1.0
 * @Date 2017年12月7日 上午10:33:47
 */
public class TimeUtil {
	public static String dateToStrLong(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}
	
	public static Date strLongToDate(String str) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dt1 = null;
		try {
			dt1 = df.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt1;
	}
	public static String getDateSx() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (hour < 12) {
			return "上午";
		} else if (hour < 18) {
			return "下午";
		} else {
			return "晚上";
		}

	}

	public static String getCurrentDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String day = df.format(new Date());
		return day;
	}

	public static int compareDate(Date date1, Date date2) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd"); 
		String DATE1 = f.format(date1);
		String DATE2 = f.format(date2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
	public static void main(String[] args) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dt1 = df.parse("2017-12-27");
		
		System.out.println(compareDate(dt1, new Date()));;
	}
}
