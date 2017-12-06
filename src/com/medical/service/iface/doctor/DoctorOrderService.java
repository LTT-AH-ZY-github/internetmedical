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
	String getOrderDetail(Integer docLoginId, Integer userOrderId) throws Exception;
	



	String updateOrderToRefuse(Integer docloginid, Integer userorderid, Integer redocloginid) throws Exception;
	/**
	 * 确认订单
	 * @param
	 * @return
	 * 
	 * */
	String  updateOrderConfirm(Userorder userorder) throws Exception;

	String updateOrderToCancle(Integer docLoginId, Integer userorderid) throws Exception;

	String finishOrder(Integer docloginid, Integer userorderid, Boolean userorderhstate,
			Integer userorderhospid) throws Exception;
	String listOrderToConfirm(Integer docLoginId, Integer pageNo, Integer pageSize) throws Exception;
	/**
	 * 获取历史订单
	 * @param
	 * @return
	 * 
	 * */
	String listHistoryOrder(Integer docloginid, Integer page) throws Exception;
	
	
	
	
	
	
}
