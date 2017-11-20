package com.medical.service.iface.hospital;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.medical.po.HospSearchDocTerm;

public interface HospitalOrderService {

	
	/**
	 * 医院根据条件获取医生
	 * */
	String listDoctor(Integer pageNo, Integer pageSize, HospSearchDocTerm hospSearchDocTerm) throws Exception;
	/**
	 * 医院确认病人住院
	 * */
	boolean confirmUserOrder(Integer hosploginid, Integer userorderid, Double userorderdeposit,
			String userorderhospprimarydept, String userorderhospseconddept) throws Exception;
	
	/**
	 * 医院拒绝病人住院
	 * */
	String refuseUserOrder(Integer hosploginid, Integer userorderid) throws Exception;
	/**
	 * 增加押金
	 * */
	String updateUserOrderDeposit(Integer hosploginid, Integer userorderid, BigDecimal userorderdeposit);
	/**
	 * 住院完成,结算费用
	 * @param userorderhprice 
	 * */
	String updateUserOrderToSettle(Integer hosploginid, Integer userorderid, BigDecimal userorderhprice);
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
	String creatConsultation(Integer docloginid, Integer hosploginid, String orderabs, String orderstime, Double orderhospprice,
			Integer orderhosptpricetype, Double orderhosptprice, Integer orderhospapricetype, Double orderhospaprice,
			Integer orderhospepricetype, Double orderhospeprice) throws Exception;
	/**
	 * 取消会诊
	 * */
	String cancelConsultation(Integer hosploginid, Integer hosporderid) throws Exception;
	/**
	 * 结束会诊
	 * */
	String finishConsultation(Integer hosploginid, Integer hosporderid) throws Exception;
	
	
	
	

}
