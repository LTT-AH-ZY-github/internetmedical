package com.medical.service.iface.doctor;

import java.math.BigDecimal;
import java.util.Map;

import com.medical.po.Userorder;

public interface DoctorOrderService {
	/**
	 * 医生申请病情
	 * @param
	 * @return
	 * 
	 * */
	String creatPreOrder(int usersickid, int docloginid, Double preorderprice) throws Exception;
	/**
	 * 获取申请的病情
	 * @param
	 * @return
	 * 
	 * */
	String listGrabOrders(Integer docloginid, Integer pageNo, Integer pageSize) throws Exception;

	//Map<String, Object> getGrabOrderDetail(Integer preOrderId);
	/**
	 * 取消申请的病情
	 * @param
	 * @return
	 * 
	 * */
	String deletePreOrder(Integer docloginid, Integer preorderid) throws Exception;
	/**
	 * 获取订单
	 * @param
	 * @return
	 * 
	 * */
	String listOrder(Integer docLoginId, Integer type, Integer pageNo, Integer pageSize) throws Exception;
	
	/**
	 * 获取订单详情
	 * @param
	 * @return
	 * 
	 * */
	String getOrderDetail(Integer docLoginId, Integer userOrderId);
	

	Map<String, Object> getDoctorByName(String docname);

	Map<String, Object> updateOrderToRefuse(Integer docloginid, Integer userorderid, Integer redocloginid) throws Exception;
	/**
	 * 确认订单
	 * @param
	 * @return
	 * 
	 * */
	String  updateOrderConfirm(Userorder userorder) throws Exception;

	Map<String, Object> updateOrderToCancle(Integer docLoginId, Integer userorderid) throws Exception;

	Map<String, Object> finishOrder(Integer docloginid, Integer userorderid, Boolean userorderhstate,
			Integer userorderhospid) throws Exception;
	String listOrderToConfirm(Integer docLoginId, Integer pageNo, Integer pageSize) throws Exception;
	/**
	 * 获取历史订单
	 * @param
	 * @return
	 * 
	 * */
	String listHistoryOrder(Integer docloginid, Integer page);
	/**
	 * 获取会诊
	 * @param
	 * @return
	 * 
	 * */
	String listConsultation(Integer docloginid, Integer type, Integer page);
	/**
	 * 获取会诊详情
	 * @param
	 * @return
	 * @throws Exception 
	 * 
	 * */
	String listConsultationDetail(Integer docloginid, Integer hosporderid) throws Exception;
	/**
	 * 确认会诊
	 * @param
	 * @return
	 * 
	 * */
	String updateConsultationToConfirm(Integer docloginid, Integer hosporderid, BigDecimal orderdoctorprice,
			Integer orderdoctortpricetype, BigDecimal orderdoctortprice, Integer orderdoctorapricetype,
			BigDecimal orderdoctoraprice, Integer orderdoctorepricetype, BigDecimal orderdoctoreprice);
	/**
	 * 取消会诊
	 * @param
	 * @return
	 * 
	 * */
	String updateConsultationToCancel(Integer docloginid, Integer hosporderid);
	/**
	 * 更改病情部门
	 * @param
	 * @return
	 * @throws Exception 
	 * 
	 * */
	String changeDept(Integer docloginid, Integer usersickid, String usersickprimarydept, String usersickseconddept) throws Exception;
	
	
	
	
}
