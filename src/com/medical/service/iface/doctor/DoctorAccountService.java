package com.medical.service.iface.doctor;



import com.medical.exception.custom.MyException;
import com.medical.po.Doctorlogininfo;

public interface DoctorAccountService {

	

	/**
	 *  新增医生账号
	 * @Title: createDoctor 
	 * @Description: TODO
	 * @return: String
	 */
	String createDoctor(String docLoginPhone, String magCode, String docLoginPwd) throws Exception;
	
	/**
	 *  医生自动登录
	 * @Title: 
	 * @Description: TODO
	 * @return: String
	 */
	String updateDoctorToAutoLogin(Doctorlogininfo doctor) throws Exception;
	
	/**
	 *  医生普通登录
	 * @Title: 
	 * @Description: TODO
	 * @return: String
	 */
	String updateDoctorToNormalLogin(Doctorlogininfo doctor) throws Exception;
	
	/**
	 *  注册环信
	 * @Title: addHuanXinAccout 
	 * @Description: TODO
	 * @return: boolean
	 */
	boolean addHuanXinAccout(Integer docloginid, String password) throws Exception;
	
	/**
	 *  修改密码
	 * @Title:
	 * @Description: TODO
	 * @return: String
	 * 
	 */
	String updatePassword(String docloginphone, String docloginpwd, String msgCode) throws Exception;
	
	/**
	 *  退出登录
	 * @Title:
	 * @Description: TODO
	 * @return: 
	 * 
	 */
	String updateAccountToExit(Integer docloginid) throws Exception;
	
	
	/**
	 *  修改环信密码
	 * @Title:
	 * @Description: TODO
	 * @return: 
	 * 
	 */
	String editHuanXinPassword(Integer docloginid, String password) throws Exception;

	/**
	 * @Title: findAccountExit
	 * @Description: TODO
	 * @param phone
	 * @return
	 * @return: String
	 */
	String findAccountExit(String phone) throws Exception;

	

	

}
