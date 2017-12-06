package com.medical.service.iface;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.medical.exception.custom.MsgErrorException;

import net.sf.json.JSONObject;

public interface CommonService {

	Map<String, Object> listRecommendDoctors(String keyWord, String primaryDept, String secondDept) throws Exception;
	
	//手机号码是否注册
	String findAccountExit(String phone);
	
	//发送短信验证码
	String getMsgCode(String phone) throws  Exception;
	
	//验证短信验证证
	boolean getCodeValidity(String phone, String code) throws Exception;
	
	/**
	 * 医院根据接收者和信息类型查询消息
	 * @param 
     * @param 
     * @return 
     */
	String listReceiveNotification(Integer notificationreceiver, Integer notificationType,
			 Integer limit, Integer offset, Integer type) throws Exception;
	/**
	 * 根据接收者和信息类型查询消息
	 * @param 
     * @param 
     * @return 
     */
	PageInfo<Map<String, Object>> listReceiveNotification(Integer notificationreceiver, Integer notificationType,
			 Integer page, Integer type) throws Exception;
	/**
	 *医院 根据发送者者和信息类型查询消息
     * @param 
     * @return 
     */
	String listSenderNotification(Integer notificationsender, Integer notificationType,
			 Integer limit, Integer offset, Integer type) throws Exception;
	/**
	 * 根据发送者者和信息类型查询消息
     * @param 
     * @return 
     */
	PageInfo<Map<String, Object>> listSenderNotification(Integer notificationsender, Integer notificationType,
			 Integer page, Integer type) throws Exception;
	
	
	/**
	 * 将通知置为已读
     * @param 
     * @return 
     */
	boolean updateNotificationToRead(Integer notificationid, Integer notificationreceiverid) throws Exception;

	boolean deleteNotification(Integer notificationid, Integer hosploginid) throws Exception;
	/**
	 * 用户发消息给医生
     * @param 
     * @return 
     */
	boolean createMsgUserToDoctor(Integer userloginid, Integer docloginid, String title, String msg, JSONObject jsonCustormCont) throws Exception;
	/**
	 * 用户发消息给医院
     * @param 
     * @return 
     */
	boolean createMsgUserToHospital(Integer userloginid, Integer hosploginid, String title, String msg, JSONObject jsonCustormCont) throws Exception;
	/**
	 * 医生发消息给用户
	 * @param jsonCustormCont 
     * @param 
     * @return 
     */
	boolean createMsgDoctorToUser(Integer docloginid, Integer userloginid, String title, String msg, JSONObject jsonCustormCont) throws Exception;
	/**
	 * 医生发消息给医院
     * @param 
     * @return 
     */
	boolean createMsgDoctorToHospital(Integer docloginid, Integer hosploginid, String title, String msg, JSONObject jsonCustormCont)
			throws Exception;
	/**
	 * 医院发消息给用户
     * @param 
     * @return 
     */
	boolean createMsgHospitalToUser(Integer hosploginid, Integer userloginid, String title, String msg, JSONObject jsonCustormCont) throws Exception;
	/**
	 * 医院发消息给医生
     * @param 
     * @return 
     */
	boolean createMsgHospitalToDoctor(Integer hosploginid, Integer docloginid, String title, String msg, JSONObject jsonCustormCont)
			throws Exception;
	/**
	 * 获取所有部门
     * @param 
     * @return 
     */
	String getDept() throws Exception;
	/**
	 * 根据接受者id和接受者类型将所有消息置为已读
     * @param notificationreceiverid 接收者id
     * @param notificationtype 消息类型1为医院接收的消息 2为医生接收的消息 3为用户接收的消息
     * @return 
     */
	String updateAllNotificationToRead(Integer notificationreceiverid,Integer notificationtype ) throws Exception;
	/**
	 * 根据接受者id和接受者类型将所有消息删除
     * @param notificationreceiverid 接收者id
     * @param notificationtype 消息类型1为医院接收的消息 2为医生接收的消息 3为用户接收的消息
     * @return 
     */
	String deleteAllNotification(Integer notificationreceiverid, Integer notificationtype) throws Exception;
	/**
	 * 新增部门
	 * */
	String addDept(Integer docloginid, String primarydept, String seconddept);
	/**
	 * 新增二级部门
	 * */
	String addSecondDept(Integer docloginid, String seconddept);

	/**
	 * @Title: createMsgUserToAdmin
	 * @Description: TODO
	 * @param userloginid
	 * @param adminloginid
	 * @param title
	 * @param msg
	 * @param jsonCustormCont
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	boolean createMsgUserToAdmin(Integer userloginid, Integer adminloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception;

	/**
	 * @Title: createMsgDoctorToAdmin
	 * @Description: TODO
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
	 * @Title: createMsgHospitalToAdmin
	 * @Description: TODO
	 * @param hosploginid
	 * @param docloginid
	 * @param title
	 * @param msg
	 * @param jsonCustormCont
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	boolean createMsgHospitalToAdmin(Integer hosploginid, Integer docloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception;

	/**
	 * @Title: createMsgAdminToUser
	 * @Description: TODO
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
	 * @Description: TODO
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
	 * @Description: TODO
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
