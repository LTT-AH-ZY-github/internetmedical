package com.medical.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class CommonUtils {

	/**
	 * 时间加随时数生成文件名
	 * @return String
	 */
	public static synchronized String randomFileName() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String temp = df.format(new Date())+new Random().nextInt(1000);
		return temp;
	}
}
