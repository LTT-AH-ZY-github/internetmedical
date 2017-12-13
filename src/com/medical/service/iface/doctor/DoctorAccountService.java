package com.medical.service.iface.doctor;


import com.medical.po.Doctorlogininfo;

public interface DoctorAccountService {

	
	/**
	 * @Title: findAccountExit
	 * @Description: 查找账号是否注册
	 * @param phone 手机号码 
	 * @return
	 * @return: String
	 */
	String findAccountExit(String phone) throws Exception;
	
	/**
	 * @Title: createDoctor
	 * @Description: 新增医生账号
	 * @param docLoginPhone
	 * @param magCode
	 * @param docLoginPwd
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String createDoctor(String docloginphone, String magcode, String docloginpwd) throws Exception;
	
	/**
	 * @Title: updateDoctorToAutoLogin
	 * @Description: 医生自动登录
	 * @param doctor
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateDoctorToAutoLogin(Doctorlogininfo doctor) throws Exception;
	
	/**
	 * @Title: updateDoctorToNormalLogin
	 * @Description: 医生登录
	 * @param doctor
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateDoctorToNormalLogin(Doctorlogininfo doctor) throws Exception;
	
	/**
	 * @Title: addHuanXinAccout
	 * @Description: 注册环信
	 * @param docloginid
	 * @param password
	 * @return
	 * @throws Exception
	 * @return: boolean
	 */
	boolean addHuanXinAccout(Integer docloginid, String password) throws Exception;
	
	/**
	 * @Title: updatePassword
	 * @Description: 修改密码
	 * @param docloginphone
	 * @param docloginpwd
	 * @param msgCode
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updatePassword(String docloginphone, String docloginpwd, String msgCode) throws Exception;
	
	/**
	 * @Title: updateAccountToExit
	 * @Description: 退出登录
	 * @param docloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateAccountToExit(Integer docloginid) throws Exception;
	
	/**
	 * @Title: editHuanXinPassword
	 * @Description: 修改环信密码
	 * @param docloginid
	 * @param password
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String editHuanXinPassword(Integer docloginid, String password) throws Exception;

	

	

	

}
