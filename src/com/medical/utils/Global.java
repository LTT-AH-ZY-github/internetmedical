package com.medical.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量字符串
 * @ClassName: Global 
 * @Description: TODO
 * @author: xyh
 * @date: 2017年11月2日 下午3:52:14
 */
public class Global {

	// 权限缓存
	public static final String CACHE_PERMISSION = "permissionCache";
	// 用户信息缓存
	public static final String CACHE_USER = "userCache";
	// 验证码缓存 
	public static final String CACHE_CODE = "codeCache";
	//des加密key
	public static final String ENCRYPT_KEY = "sudiyiyun";
	//token过期时间30天
	public static final long TOKEN_OUT_TIME = 2592000000L;
	//百度云key
	public static final String AndroidInUserApiKey = "02ctBmx6b14cLwT1N0c8Gx85qMyYbzbk";
	
	public static final String AndroidInUserSecretKey = "CKt3UsYSmYtkBcw5AHX7WRpbSPoKIdiz";
	//百度云key
	public static final String AndroidInDoctorApiKey = "xU6dBHm80gQbZ63hx01LwZdChu56ZRCG";
		
	public static final String AndroidInDoctorSecretKey = "zwxVyhFfMTUlSTsYWU6xXprTlfwyGtYr";
	
	public static Map<String , Object> globalToken =new HashMap<String, Object>();
}
