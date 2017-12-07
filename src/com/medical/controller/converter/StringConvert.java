/**
 * 
 */
package com.medical.controller.converter;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;

/**
 * @ClassName:     StringConvert.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月7日 下午2:19:27 
 */
public class StringConvert implements Converter<BigDecimal,String>
{

	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	

	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public String convert(BigDecimal arg0) {
		// TODO Auto-generated method stub
		return arg0+"";
	}

}
