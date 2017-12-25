package com.medical.service.iface;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;


public interface CommonService {

	
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
	String listReceiveNotification(Integer notificationreceiver, Integer notificationType,
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
	String listSenderNotification(Integer notificationsender, Integer notificationType,
			 Integer page, Integer type) throws Exception;
	
	
	/**
	 * 将通知置为已读
     * @param 
     * @return 
     */
	String updateNotificationToRead(Integer notificationid, Integer notificationreceiverid) throws Exception;

	String deleteNotification(Integer notificationid, Integer hosploginid) throws Exception;
	
	
	/**
	 * 获取所有部门
     * @param 
     * @return 
     *//*
	String getDept() throws Exception;*/
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
	 * @Title: listDepts
	 * @Description: 获取部门
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listDepts() throws Exception;

	/**
	 * @Title: getUnreadNotificationNum
	 * @Description: TODO
	 * @param hosploginid
	 * @return
	 * @return: String
	 */
	String getUnreadNotificationNum(Integer hosploginid);

	/**
	 * @Title: addFeedBack
	 * @Description: TODO
	 * @param feedbackidea
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String addFeedBack(String feedbackidea) throws Exception;

	/**
	 * @Title: getAppVersion
	 * @Description: TODO
	 * @param type
	 * @param  
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String getAppVersion(Integer apptype, Integer systemtype) throws Exception;

	/**
	 * @Title: uploadAndroidApp
	 * @Description: TODO
	 * @param type
	 * @param app
	 * @param version
	 * @return
	 * @return: String
	 */
	String uploadAndroidApp(Integer type, MultipartFile app, String version)throws Exception;

}
