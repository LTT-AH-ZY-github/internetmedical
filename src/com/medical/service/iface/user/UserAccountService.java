package com.medical.service.iface.user;



public interface UserAccountService {
	
	/**
	 * 新增账号
	 * @return
	 * @param
	 * */
	String createUserAccount(String phone, String password, String code) throws Exception;
	
	/**
	 * 普通登录
	 * @return
	 * @param
	 * */
	String updateUserToNormalLogin(String userloginphone, String userloginpwd, Integer userlogindev) throws Exception;
	
	/**
	 * 自动登录
	 * @param userlogindev 
	 * @return
	 * @param
	 * */
	String updateUserToAutoLogin(String userloginphone, String userloginpwd, String userlogintoken, Integer userlogindev) throws Exception;
	
	/**
	 * 退出登录
	 * @return
	 * @param
	 * */
	String updateUserToExit(Integer userloginid) throws Exception;
	
	/**
	 * 修改密码
	 * @return
	 * @param
	 * */
	String updatePassword(String phone, String password, String code) throws Exception;

	/**
	 * 注册环信账号
	 * @return
	 * @param
	 * */
	String addHuanXinAccout(Integer userloginid, String password) throws Exception;
	
	/**
	 * 修改环信密码
	 * @return
	 * @param
	 * */
	String editHuanXinPassword(Integer userloginid, String password) throws Exception;

	/**
	 * @Title: findAccountExit
	 * @Description: TODO
	 * @param phone
	 * @return
	 * @return: String
	 */
	String findAccountExit(String phone);
	
}
