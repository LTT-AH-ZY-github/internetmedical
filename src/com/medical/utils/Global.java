package com.medical.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: Global 
 * @Description:常量字符串
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
	
	//图片上传本地路径
	public static final String uploadLocalPath="C:\\upload\\";
	
	
	//部署路径
	public static final String HTTP_URL="http://118.89.172.204:6221/";
	//public static final String HTTP_URL="http://1842719ny8.iok.la:14086/";
	public static final String DOC_HTTP_URL="http://118.89.172.204:80/";
	//app下载地址
	public static final String APP_DOWLOAD_URL="http://118.89.172.204:80/download/";
	//token 
	public static Map<String , Object> globalToken =new HashMap<String, Object>();
	
}
