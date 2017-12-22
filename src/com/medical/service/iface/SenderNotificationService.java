/**  
* @Title: SenderNotificationService.java  
* @Package com.medical.service.iface  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月12日  
* @version V1.0  
*/  
package com.medical.service.iface;

import net.sf.json.JSONObject;

/**
 * @ClassName:     SenderNotificationService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月12日 下午10:00:14 
 */
public interface SenderNotificationService {
	
	/**
	 * @Title: createMsgUserToDoctor
	 * @Description: 用户发消息给医生
	 * @param userloginid 用户登录id
	 * @param docloginid 医生登录id
	 * @param title 标题
	 * @param msg 信息 
	 * @param jsonCustormCont 自定义数据
	 * @return
	 * @throws Exception
	 * @return: boolean
	 */
	boolean createMsgUserToDoctor(Integer userloginid,String name,Integer docloginid, String title, String msg, JSONObject jsonCustormCont) throws Exception;
	
	/**
	 * @Title: createMsgUserToHospital
	 * @Description: 用户发消息给医院
	 * @param userloginid  用户登录id
	 * @param hosploginid 医院登录id
	 * @param title 标题
	 * @param msg 信息
	 * @param jsonCustormCont 自定义数据
	 * @return
	 * @throws Exception
	 * @return: boolean
	 */
	boolean createMsgUserToHospital(Integer userloginid,String name, Integer hosploginid, String title, String msg, JSONObject jsonCustormCont) throws Exception;
	
	/**
	 * @Title: createMsgUserToAdmin
	 * @Description: 用户发送信息给管理员
	 * @param userloginid 用户登录id
	 * @param adminloginid 管理员登录id
	 * @param title 标题
	 * @param msg 信息 
	 * @param jsonCustormCont 自定义数据
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	boolean createMsgUserToAdmin(Integer userloginid,String name, Integer adminloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception;
	
	/**
	 * @Title: createMsgDoctorToUser
	 * @Description: 医生发消息给用户
	 * @param docloginid
	 * @param userloginid
	 * @param title
	 * @param msg
	 * @param jsonCustormCont
	 * @return
	 * @throws Exception
	 * @return: boolean
	 */
	boolean createMsgDoctorToUser(Integer docloginid, Integer userloginid, String title, String msg, JSONObject jsonCustormCont) throws Exception;
		
	/**
	 * @Title: createMsgDoctorToHospital
	 * @Description: 医生发消息给医院
	 * @param docloginid
	 * @param hosploginid
	 * @param title
	 * @param msg
	 * @param jsonCustormCont
	 * @return
	 * @throws Exception
	 * @return: boolean
	 */
	boolean createMsgDoctorToHospital(Integer docloginid, Integer hosploginid, String title, String msg, JSONObject jsonCustormCont)
			throws Exception;
	
	/**
	 * @Title: createMsgDoctorToAdmin
	 * @Description: 医生发消息给管理员
	 * @param docloginid
	 * @param adminloginid
	 * @param title
	 * @param msg
	 * @param jsonCustormCont
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	boolean createMsgDoctorToAdmin(Integer docloginid, Integer adminloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception;
	
	/**
	 * @Title: createMsgHospitalToDoctor
	 * @Description: 医院发消息给医生
	 * @param hosploginid
	 * @param docloginid
	 * @param title
	 * @param msg
	 * @param jsonCustormCont
	 * @return
	 * @throws Exception
	 * @return: boolean
	 */
	boolean createMsgHospitalToDoctor(Integer hosploginid, Integer docloginid, String title, String msg, JSONObject jsonCustormCont)
			throws Exception;
	
	/**
	 * @Title: createMsgHospitalToUser
	 * @Description: 医院发消息给用户
	 * @param hosploginid
	 * @param userloginid
	 * @param title
	 * @param msg
	 * @param jsonCustormCont
	 * @return
	 * @throws Exception
	 * @return: boolean
	 */
	boolean createMsgHospitalToUser(Integer hosploginid, Integer userloginid, String title, String msg, JSONObject jsonCustormCont) throws Exception;
	
	/**
	 * @Title: createMsgHospitalToAdmin
	 * @Description: 医院发信息给管理员
	 * @param hosploginid
	 * @param docloginid
	 * @param title
	 * @param msg
	 * @param jsonCustormCont
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	boolean createMsgHospitalToAdmin(Integer hosploginid, Integer adminloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception;

	/**
	 * @Title: createMsgAdminToUser
	 * @Description:管理员发消息给用户
	 * @param adminloginid
	 * @param userloginid
	 * @param title
	 * @param msg
	 * @param jsonCustormCont
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	boolean createMsgAdminToUser(Integer adminloginid, Integer userloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception;

	/**
	 * @Title: createMsgAdminToDoctor
	 * @Description: 管理员发消息给医生
	 * @param adminloginid
	 * @param docloginid
	 * @param title
	 * @param msg
	 * @param jsonCustormCont
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	boolean createMsgAdminToDoctor(Integer adminloginid, Integer docloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception;

	/**
	 * @Title: createMsgAdminToHospital
	 * @Description: 管理员发消息给医院
	 * @param adminloginid
	 * @param hosploginid
	 * @param title
	 * @param msg
	 * @param jsonCustormCont
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	boolean createMsgAdminToHospital(Integer adminloginid, Integer hosploginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception;
	
}
