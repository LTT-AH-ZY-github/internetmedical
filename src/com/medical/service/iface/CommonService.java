package com.medical.service.iface;

import java.util.Map;

import com.medical.exception.custom.MsgErrorException;

public interface CommonService {

	Map<String, Object> listRecommendDoctors(String keyWord, String primaryDept, String secondDept) throws Exception;
	
	//手机号码是否注册
	boolean findAccountExit(String phone);
	
	//发送短信验证码
	boolean getMsgCode(String phone) throws  Exception;
	
	//验证短信验证证
	boolean getCodeValidity(String phone, String code) throws Exception;

}
