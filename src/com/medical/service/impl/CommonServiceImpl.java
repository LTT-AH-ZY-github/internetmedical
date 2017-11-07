package com.medical.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import com.medical.exception.custom.MsgErrorException;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Userinfo;
import com.medical.service.UserService;
import com.medical.service.iface.CommonService;
import com.medical.utils.KeyWords;
import com.medical.utils.result.Result;
import com.netease.code.MsgCode;

public class CommonServiceImpl implements CommonService{
	@Autowired 
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private UserlogininfoMapperCustom userlogininfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapperCustom doctorlogininfoMapperCustom;
	
	Logger logger = Logger.getLogger(CommonService.class);
	
	// 查找账号是否注册
	@Override
	public boolean findAccountExit(String phone) {
		// 查询医生登录表
		int doctorCount = doctorlogininfoMapperCustom.findDocCountByPhone(phone);
		// 查询病人登录表
		int userCount = userlogininfoMapperCustom.findUserCountByPhone(phone);
		if (doctorCount == 0 && userCount==0) {
			return false; 
		} else {
			return true; 
		}
	}
	
	//发送短信验证码
	@Override
	public boolean getMsgCode(String phone) throws Exception {
		return MsgCode.getCode(phone);
	}
	
	//发送短信验证码
	@Override
	public boolean getCodeValidity(String phone,String code) throws Exception {
		return MsgCode.checkMsg(phone,code);
	}

	// 根据条件获取推荐医生
	@Override
	public Map<String, Object> listRecommendDoctors(String keyWord, String primaryDept, String secondDept)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (primaryDept == null && secondDept == null) {
			Map<String, Object> result = getByKeyWord(keyWord);
			// 获取成功
			if ("1".equals(result.get("state"))) {
				map.put("state", "1");
				map.put("data", result.get("data"));
			} else {
				map.put("state", "2");
				
			}
			
		} else {
			List<Doctorinfo> list = doctorinfoMapperCustom.selectByDept(primaryDept, secondDept);
			if (list.size() > 0) {
				// 获取成功
				map.put("state", "1");
				map.put("data", list);
			} else {
				Map<String, Object> result = getByKeyWord(keyWord);
				// 获取成功
				if ("1".equals(result.get("state"))) {
					map.put("state", "1");
					map.put("data", result.get("data"));
				} else {
					map.put("state", "2");
					
				}
			}
		}
		return map;

	}
	public Map<String, Object> getByKeyWord(String keyWord) throws Exception{
		String primaryDept = "内科"; 
		String secondDept = null;
		Map<String, Object> map = new HashMap<String, Object>();
		boolean headacheresult1 = keyWord.contains(KeyWords.HEADACHE_WORD1);
		boolean headacheresult2 = keyWord.contains(KeyWords.HEADACHE_WORD2);
		boolean headacheresult3 = keyWord.contains(KeyWords.HEADACHE_WORD3);
		boolean headacheresult4 = keyWord.contains(KeyWords.HEADACHE_WORD4);
		boolean headacheresult5 = keyWord.contains(KeyWords.HEADACHE_WORD5);
		boolean headacheresult6 = keyWord.contains(KeyWords.HEADACHE_WORD6);
		boolean headacheresult7 = keyWord.contains(KeyWords.HEADACHE_WORD7);
		boolean headacheresult8 = keyWord.contains(KeyWords.HEADACHE_WORD8);
		boolean headacheresult9 = keyWord.contains(KeyWords.HEADACHE_WORD9);
		boolean headacheresult10 = keyWord.contains(KeyWords.HEADACHE_WORD10);
		boolean headacheresult11 = keyWord.contains(KeyWords.HEADACHE_WORD11);
		boolean headacheresult12 = keyWord.contains(KeyWords.HEADACHE_WORD12);
		boolean headacheresult = headacheresult1 || headacheresult2 || headacheresult3 || headacheresult4 ||headacheresult5 || headacheresult6 ||headacheresult7 || headacheresult8 || headacheresult9 || headacheresult10 ||headacheresult11 || headacheresult12;
		if (headacheresult) {
			primaryDept = "内科";
			secondDept = "神经内科";
			
		}
		List<Doctorinfo> list = doctorinfoMapperCustom.selectByDept(primaryDept, secondDept);
		if (list.size() > 0) {
			// 获取成功
			map.put("state", "1");
			map.put("data", list);
		} else {
			List<Doctorinfo> defaultList = doctorinfoMapperCustom.selectByDept(null, null);
			if (defaultList.size()>0) {
				map.put("state", "1");
				map.put("data", defaultList);
			} else {
				map.put("state", "2");
			}
			
		}
		return map;
		
	}

	
	
		
		
	
}
