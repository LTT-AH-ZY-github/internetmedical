package com.medical.service.iface.user;

import java.util.Map;

import com.medical.po.Userlogininfo;

public interface UserAccountService {
	
	//用户注册
	boolean createUserAccount(String phone, String password) throws Exception;
	
	//用户登录
	Map<String, Object> updateUserToLogin(String userloginphone, String userloginpwd, String userlogintoken) throws Exception;

	boolean updateUserToExit(Integer userloginid) throws Exception;

	boolean updatePassword(String phone, String password) throws Exception;

	
	boolean addHuanXinAccout(Integer userloginid, String password) throws Exception;

}
