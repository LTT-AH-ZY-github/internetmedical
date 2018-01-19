/**  
* @Title: AdminMenuService.java  
* @Package com.medical.service.iface.admin  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2018年1月15日  
* @version V1.0  
*/  
package com.medical.service.iface.admin;

/**
 * @ClassName:     AdminMenuService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2018年1月15日 下午9:32:41 
 */
public interface AdminMenuService {


	/**
	 * @Title: addAdminRole
	 * @Description: TODO
	 * @param adminloginid
	 * @param rolename
	 * @param roledescription
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String addAdminRole(Integer adminloginid, String rolename, String roledescription) throws Exception;

	/**
	 * @Title: deleteAdminRole
	 * @Description: TODO
	 * @param adminloginid
	 * @param roleid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String deleteAdminRole(Integer adminloginid, Integer roleid) throws Exception;

	/**
	 * @Title: updateAdminRole
	 * @Description: TODO
	 * @param adminloginid
	 * @param roleid
	 * @param rolename
	 * @param roledescription
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateAdminRole(Integer adminloginid, Integer roleid, String rolename, String roledescription)
			throws Exception;

	/**
	 * @Title: listAdminRole
	 * @Description: TODO
	 * @param adminloginid
	 * @param limit
	 * @param offset
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listAdminRole(Integer adminloginid, Integer limit, Integer offset) throws Exception;

	/**
	 * @Title: addAdminMenu
	 * @Description: TODO
	 * @param adminloginid
	 * @param menufatherid
	 * @param menuname
	 * @param menuurl
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String addAdminMenu(Integer adminloginid, Integer menufatherid, String menuname, String menuurl) throws Exception;

	/**
	 * @Title: deleteAdminMenu
	 * @Description: TODO
	 * @param adminloginid
	 * @param menuid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String deleteAdminMenu(Integer adminloginid, Integer menuid) throws Exception;

	/**
	 * @Title: updateAdminMenu
	 * @Description: TODO
	 * @param adminloginid
	 * @param menuid
	 * @param menufatherid
	 * @param menuname
	 * @param menuurl
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateAdminMenu(Integer adminloginid, Integer menuid, Integer menufatherid, String menuname, String menuurl)
			throws Exception;

	/**
	 * @Title: listAdminMenu
	 * @Description: TODO
	 * @param adminloginid
	 * @param limit
	 * @param offset
	 * @param type 
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listAdminMenu(Integer adminloginid, Integer limit, Integer offset, Integer type) throws Exception;

	/**
	 * @Title: addAdminRoleMenu
	 * @Description: TODO
	 * @param adminloginid
	 * @param menuid
	 * @param roleid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String addAdminRoleMenu(Integer adminloginid, Integer menuid, Integer roleid) throws Exception;

	/**
	 * @Title: getAdminMenu
	 * @Description: TODO
	 * @param adminloginid
	 * @param menufatherid
	 * @return
	 * @return: String
	 */
	String getAdminMenu(Integer adminloginid, Integer menufatherid) throws Exception;

	/**
	 * @Title: updateAdminRoleMenu
	 * @Description: TODO
	 * @param adminloginid
	 * @param rolemenuid
	 * @param menuid
	 * @param roleid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateAdminRoleMenu(Integer adminloginid, Integer rolemenuid, Integer menuid, Integer roleid)
			throws Exception;

	/**
	 * @Title: deleteAdminRoleMenu
	 * @Description: TODO
	 * @param adminloginid
	 * @param rolemenuid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String deleteAdminRoleMenu(Integer adminloginid, Integer rolemenuid) throws Exception;

	/**
	 * @Title: listAdminRoleMenu
	 * @Description: TODO
	 * @param adminloginid
	 * @param roleid
	 * @param limit
	 * @param offset
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listAdminRoleMenu(Integer adminloginid, Integer roleid, Integer limit, Integer offset) throws Exception;

	/**
	 * @Title: listAdminRole
	 * @Description: TODO
	 * @param adminloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listAdminRole(Integer adminloginid) throws Exception;

	/**
	 * @Title: listAllAdminRoleMenu
	 * @Description: TODO
	 * @param adminloginid
	 * @param roleid
	 * @return
	 * @return: String
	 */
	String listAdminRoleMenu(Integer adminloginid, Integer roleid)throws Exception;

}
