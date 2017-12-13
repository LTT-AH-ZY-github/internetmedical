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
	String updateUserOrderToEnd(Integer hosploginid, Integer userorderid);
	/**
	 * 创建会诊
	 * @param orderabs 
	 * @param orderstime 
	 * @return
	 * @param
	 * 
	 * */
	String creatConsultation(Integer docloginid, Integer hosploginid, String orderabs, String orderstime,
			BigDecimal orderhospprice, Integer orderhosptpricetype, BigDecimal orderhosptprice,
			Integer orderhospapricetype, BigDecimal orderhospaprice, Integer orderhospepricetype,
			BigDecimal orderhospeprice) throws Exception;
	/**
	 * 取消会诊
	 * */
	String cancelConsultation(Integer hosploginid, Integer hosporderid) throws Exception;
	/**
	 * 支付医生会诊费用
	 * */
	String payDoctor(Integer hosploginid, Integer hosporderid) throws Exception;
	/**
	 * 支付医生会诊费用完成
	 * */
	
	/**
	 * 结束会诊
	 * */
	String finishConsultation(Integer hosploginid, Integer hosporderid) throws Exception;
	/**
	 * @Title: payDoctorFinish
	 * @Description: TODO
	 * @param requestParams
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String payDoctorFinish(Map<String, String[]> requestParams) throws Exception;
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
