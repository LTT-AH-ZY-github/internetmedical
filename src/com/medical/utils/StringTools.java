/**  
* @Title: StringUtils.java  
* @Package com.medical.utils  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月14日  
* @version V1.0  
*/
package com.medical.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.medical.po.SickSearch;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 * @ClassName: StringUtils.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xyh
 * @version V1.0
 * @Date 2017年12月14日 下午4:00:18
 */
public class StringTools {
	public static void main(String[] args) {
		String s1 = "";
		String s2 = "12";
		String[] str1 = s1.split(",");
		String[] str2 = s2.split(",");

		System.out.println(getParamOneDifferent(str1, str2));
	}

	public static String getParamOneDifferent(String[] paramOne, String[] paramTwo) {
		List<String> a1 = Arrays.asList(paramOne);
		List<String> a2 = Arrays.asList(paramTwo);

		// 查询相同
		Set<String> a3 = new HashSet<String>();
		a3.addAll(a1);
		a3.addAll(a2);

		a3.removeAll(a2);
		// a1特有的
		StringBuilder sb = new StringBuilder();
		for (String str : a3) {
			sb.append(str).append(",");
		}
		return sb.substring(0, sb.length() - 1);
	}

	public static int strLength(String value) {
		if (StringUtils.isBlank(value)) {
			return 0;
		}
		int valueLength = 0;
		String chinese = "[\u0391-\uFFE5]";
		/* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
		for (int i = 0; i < value.length(); i++) {
			/* 获取一个字符 */
			String temp = value.substring(i, i + 1);
			/* 判断是否为中文字符 */
			if (temp.matches(chinese)) {
				/* 中文字符长度为2 */
				valueLength += 2;
			} else {
				/* 其他字符长度为1 */
				valueLength += 1;
			}
		}
		return valueLength;
	}
}
