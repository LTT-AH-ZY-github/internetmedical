package com.medical.service.iface.user;

/**
 * @ClassName: UserAccountService.java
 * @Description: 用户账号管理
 * @author xyh
 * @version V1.0
 * @Date 2017年12月7日 下午8:54:36
 */
public interface UserAccountService {

	/**
	 * @Title: findAccountExit
	 * @Description: 判断手机号码是否注册
	 * @param phone 手机号码
	 * @return: String
	 */
	String findAccountExit(String phone) throws Exception;;

	/**
	 * @Title: createUserAccount
	 * @Description: 新增账号
	 * @param phone
	 *            手机号码
	 * @param password
	 *            密码
	 * @param code
	 *            短信验证码
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String createUserAccount(String phone, String password, String code) throws Exception;

	/**
	 * @Title: updateUserToNormalLogin
	 * @Description: 普通登录
	 * @param userloginphone
	 *            用户登录号码
	 * @param userloginpwd
	 *            密码
	 * @param userlogindev
	 *            登录设备1为安卓 2为IOS
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateUserToNormalLogin(String userloginphone, String userloginpwd, Integer userlogindev) throws Exception;

	/**
	 * @Title: updateUserToAutoLogin
	 * @Description: 自动登录
	 * @param userloginphone
	 *            手机号码
	 * @param userloginpwd
	 *            密码
	 * @param userlogintoken
	 *            token
	 * @param userlogindev
	 *            登录设备
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateUserToAutoLogin(String userloginphone, String userloginpwd, String userlogintoken,
			Integer userlogindev) throws Exception;

	/**
	 * @Title: updateUserToExit
	 * @Description: 退出登录
	 * @param userloginid
	 *            用户登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateUserToExit(Integer userloginid) throws Exception;

	/**
	 * @Title: updatePassword
	 * @Description: 修改密码
	 * @param phone
	 *            手机号码
	 * @param password
	 *            密码
	 * @param code
	 *            短信验证码
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updatePassword(String phone, String password, String code) throws Exception;

	/**
	 * @Title: createHuanXinAccout
	 * @Description: 注册环信账号
	 * @param userloginid
	 *            用户登录id
	 * @param password
	 *            密码
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String createHuanXinAccout(Integer userloginid, String password) throws Exception;

	/**
	 * @Title: updateHuanXinPassword
	 * @Description: 修改环信密码
	 * @param userloginid
	 *            用户登录id
	 * @param password
	 *            密码
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateHuanXinPassword(Integer userloginid, String password) throws Exception;

}
