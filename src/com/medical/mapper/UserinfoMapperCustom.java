package com.medical.mapper;


import java.util.Map;

import com.medical.po.Userinfo;


public interface UserinfoMapperCustom {
	
	// 根据外键查询用户信息表
    Map<String,Object>  findUserInfoByLoginId(int userloginid);
    Userinfo selectByLoginId(int userloginid) throws Exception;
}