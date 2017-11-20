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
	 * 根据接收者和信息类型查询消息
	 * @param 
     * @param 
     * @return 
     */
	PageInfo<Map<String, Object>> listReceiveNotification(Integer notificationreceiver, Integer notificationType,
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
	 * 根据发送者者和信息类型查询消息
     * @param 
     * @return 
     */
	PageInfo<Map<String, Object>> listSenderNotification(Integer notificationsender, Integer notificationType,
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
	String createMsgUserToDoctor(Integer userloginid, Integer docloginid, String title, String msg, JSONObject jsonCustormCont) throws Exception;
	/**
	 * 用户发消息给医院
     * @param 
     * @return 
     */
	String createMsgUserToHospital(Integer userloginid, Integer hosploginid, String title, String msg, JSONObject jsonCustormCont) throws Exception;
	/**
	 * 医生发消息给用户
	 * @param jsonCustormCont 
     * @param 
     * @return 
     */
	String createMsgDoctorToUser(Integer docloginid, Integer userloginid, String title, String msg, JSONObject jsonCustormCont) throws Exception;
	/**
	 * 医生发消息给医院
     * @param 
     * @return 
     */
	String createMsgDoctorToHospital(Integer docloginid, Integer hosploginid, String title, String msg, JSONObject jsonCustormCont)
			throws Exception;
	/**
	 * 医院发消息给用户
     * @param 
     * @return 
     */
	String createMsgHospitalToUser(Integer hosploginid, Integer userloginid, String title, String msg, JSONObject jsonCustormCont) throws Exception;
	/**
	 * 医院发消息给医生
     * @param 
     * @return 
     */
	String createMsgHospitalToDoctor(Integer hosploginid, Integer docloginid, String title, String msg, JSONObject jsonCustormCont)
			throws Exception;
	/**
	 * 获取所有部门
     * @param 
     * @return 
     */
	String getDept() throws Exception;

}
