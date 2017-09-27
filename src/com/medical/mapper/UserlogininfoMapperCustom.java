package com.medical.mapper;


import com.medical.po.Userlogininfo;
import com.medical.po.UserlogininfoCustom;



public interface UserlogininfoMapperCustom {
	
	//根据号码查找用户数量
	int findUserCountByPhone(String phone) throws Exception;
	
	// 根据手机号码和密码查询用户登录表
	public UserlogininfoCustom findUserLoginInfoByPP(String phone,String password)throws Exception;
	
	//插入数据到用户登录表
	public int insertUserLoginInfo(String phone,String password) throws Exception;
	
	//根据号码查找用户登录信息
	UserlogininfoCustom findUserLoginInfoByPhone(String phone) throws Exception;
	
	
	
	int insertSelectiveReturnId(Userlogininfo userlogininfo);
}