package com.medical.service.iface.hospital;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.medical.po.HospSearchDocTerm;

public interface HospitalOrderService {

	
	/**
	 * 医院根据条件获取医生
	 * */
	//String listDoctor(Integer pageNo, Integer pageSize, HospSearchDocTerm hospSearchDocTerm) throws Exception;
	/**
	 * 医院获取需要住院的病人订单
	 * */
	String listUserOrder(Integer hosploginid, Integer type, Integer limit, Integer offset) throws Exception;
	/**
	 * 医院确认病人住院
	 * */
	String confirmUserOrder(Integer hosploginid, Integer userorderid, Double userorderdeposit,
			String userorderhospprimarydept, String userorderhospseconddept) throws Exception;
	
	/**
	 * 医院拒绝病人住院
	 * */
	String refuseUserOrder(Integer hosploginid, Integer userorderid) throws Exception;
	/**
	 * 增加押金
	 * @throws Exception 
	 * */
	String updateUserOrderDeposit(Integer hosploginid, Integer userorderid, BigDecimal userorderdeposit) throws Exception;
	/**
	 * 住院完成,结算费用
	 * @param userorderhprice 
	 * @throws Exception 
	 * */
	String updateUserOrderToSettle(Integer hosploginid, Integer userorderid, BigDecimal userorderhprice) throws Exception;
	/**
	 * 结束三方订单
	 * */
	String updateUserOrderToEnd(Integer hosploginid, Integer userorderid) throws Exception;
	

	/**
	 * @Title: getHospDeptNum
	 * @Description: 获取医院床位数量
	 * @param hosploginid 医院登录id
	 * @param userorderhospprimarydept 一级部门名称
	 * @param userorderhospseconddept 二级部门名称
	 * @return
	 * @return: String
	 */
	String getHospBerthNum(Integer hosploginid, String userorderhospprimarydept, String userorderhospseconddept) throws Exception;
	
	
	
	
	
	
	
	

}
