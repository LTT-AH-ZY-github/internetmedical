package com.medical.controller.converter;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


/**
 * 
 * <p>Title: CustomDateConverter</p>
 * <p>Description:日期转换器 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-13下午5:49:14
 * @version 1.0
 */

public class CustomDateConverter2 implements Converter<Date,Date>{

	@Override
	public Date convert(Date source) {
		System.out.println("执行了");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(source);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

}
