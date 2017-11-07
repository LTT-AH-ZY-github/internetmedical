package com.medical.service.iface.doctor;


import java.util.Map;

import com.medical.po.Doctorlogininfo;

public interface DoctorAccountService {

	

	

	
	/**
	 *  新增医生账号
	 * @Title: createDoctor 
	 * @Description: TODO
	 * @return: int
	 */
	int createDoctor(String docLoginPhone, String magCode, String docLoginPwd) throws Exception;
	
	/**
	 *  医生登录
	 * @Title: updateDoctorToLogin 
	 * @Description: TODO
	 * @return: Map<String, Object>
	 */
	Map<String, Object> updateDoctorToLogin(Doctorlogininfo doctor) throws Exception;
	
	/**
	 *  更新百度云ChannelId
	 * @Title: updateChannelId 
	 * @Description: TODO
	 * @return: int
	 */
	int updateChannelId(Integer docloginid, String channelid);
	/**
	 *  注册环信
	 * @Title: addHuanXinAccout 
	 * @Description: TODO
	 * @return: boolean
	 */
	boolean addHuanXinAccout(Integer docloginid, String password) throws Exception;

}
