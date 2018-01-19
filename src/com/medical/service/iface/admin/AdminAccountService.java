/**
 * 
 */
package com.medical.service.iface.admin;

/**
 * @ClassName:     AdminAccountService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月1日 下午4:20:54 
 */
public interface AdminAccountService {

	

	/**
	 * @Title: updateAccountStateToLogin
	 * @Description: 管理登录
	 * @param adminloginname 登录名
	 * @param adminloginpwd 密码
	 * @return
	 * @return: String
	 */
	String updateAccountStateToLogin(String adminloginname, String adminloginpwd) throws Exception;

	/**
	 * @Title: addAdminAccount
	 * @Description: TODO
	 * @param adminloginid
	 * @param adminloginname
	 * @param adminloginpwd
	 * @return
	 * @return: String
	 */
	String addAdminAccount(Integer adminloginid, String adminloginname, String adminloginpwd)throws Exception;

	/**
	 * @Title: updateAdminAccountRole
	 * @Description: TODO
	 * @param adminloginid
	 * @param lowadminloginid
	 * @param roleid
	 * @return
	 * @return: String
	 */
	String updateAdminAccountRole(Integer adminloginid, Integer lowadminloginid, Integer roleid)throws Exception;

	/**
	 * @Title: getMenu
	 * @Description: TODO
	 * @param adminloginid
	 * @return
	 * @return: String
	 */
	String getMenu(Integer adminloginid) throws Exception;

	

	/**
	 * @Title: listAdminAccount
	 * @Description: TODO
	 * @param adminloginid
	 * @param limit
	 * @param offset
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listAdminAccount(Integer adminloginid, Integer limit, Integer offset) throws Exception;

}
