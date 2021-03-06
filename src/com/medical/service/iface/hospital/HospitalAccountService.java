package com.medical.service.iface.hospital;

public interface HospitalAccountService {

	/**
	 * @Title: findAccountExit
	 * @Description: TODO
	 * @param phone
	 * @return
	 * @return: String
	 * @throws Exception 
	 */
	String findAccountExit(String phone) throws Exception;

	/**
	 * @Title: createAccount
	 * @Description: TODO
	 * @param hosploginphone
	 * @param msgcode
	 * @param hosploginppwd
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String createAccount(String hosploginphone, String msgcode, String hosploginppwd) throws Exception;

	/**
	 * @Title: updateDoctorToNormalLogin
	 * @Description: TODO
	 * @param hosploginphone
	 * @param hosploginppwd
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateDoctorToNormalLogin(String hosploginphone, String hosploginppwd) throws Exception;

	/**
	 * @Title: creatHuanXinAccout
	 * @Description: TODO
	 * @param hosploginid
	 * @param password
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String creatHuanXinAccout(Integer hosploginid, String password) throws Exception;

	/**
	 * @Title: editHuanXinPassword
	 * @Description: TODO
	 * @param hosploginid
	 * @param password
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String editHuanXinPassword(Integer hosploginid, String password) throws Exception;

	/**
	 * @Title: updatePassword
	 * @Description: TODO
	 * @param hosploginphone
	 * @param hosploginpwd
	 * @param msgCode
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updatePassword(String hosploginphone, String hosploginpwd, String msgCode) throws Exception;

	/**
	 * @Title: updateAccountToExit
	 * @Description: TODO
	 * @param hosploginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateAccountToExit(Integer hosploginid) throws Exception;

}
