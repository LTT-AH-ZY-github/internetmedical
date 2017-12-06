package com.medical.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CheckUtils {
	public static void main(String[] args) {
		System.out.println(isChineseNameLegal("拒绝流量了"));
	}
	/**
	 * 检查手机号码是否合法
	 * */
	public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {  
        String regExp = "^(1[34578][0-9])\\d{8}$";
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
	/**
	 * 检查姓名是否合法
	 * */
	public static boolean isChineseNameLegal(String str) throws PatternSyntaxException {  
        String regExp = "[\u4e00-\u9fa5]{2,7}";
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
	/**
	 * 检查性别是否合法
	 * */
	public static boolean isSexLegal(String str) throws PatternSyntaxException {  
        if ("男".equals(str) ||"女".equals(str)) {
			return true;
		} 
        return false;
    }
	/**
	 * 检查年龄是否合法
	 * */
	public static boolean isAgeLegal(int num) throws PatternSyntaxException {  
        if (num>0 && num<150) {
			return true;
		} 
        return false;
    } 
}
