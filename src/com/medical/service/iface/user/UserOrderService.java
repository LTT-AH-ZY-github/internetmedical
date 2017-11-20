package com.medical.service.iface.user;

import java.util.Map;

import com.github.pagehelper.PageInfo;

public interface UserOrderService {
	/**
	 * 生成订单
	 * */
	String createOrder(Integer docloginid, Integer userloginid, String userorderappointment) throws Exception;
	/**
	 * 取消医生订单
	 * */
	String updateOrderStateToCancel(Integer userOrderId, Integer userLoginId) throws Exception;
	/**
	 * 获取不同类型订单
	 * */
	String listOrders(Integer userloginid, Integer page, Integer type);

	Map<String, Object> getOrderDetail(Integer userloginid, Integer userorderid);
	/**
	 * 确认订单
	 * */
	String updateOrderStateToConfirm(Integer userloginid, Integer userorderid) throws Exception;

	boolean updateOrderStatePayDoctor(Integer userloginid, Integer userorderid) throws Exception;

	boolean updateOrderStatePayHospital(Integer userloginid, Integer userorderid);

	
	/**
	 * 取消住院
	 * */
	String updateOrderStateToCancelHospital(Integer userloginid, Integer userorderid) throws Exception;

	int insertEvaluate(Integer userorderid, Integer userloginid, Integer doccommentservicelevel,
			Integer doccommentprofessionallevel, Integer doccommentpricelevel, String doccommentwords,
			Integer hospcommentservicelevel, Integer hospcommentenvironmenlevel, Integer hospcommentpricelevel,
			String hospcommentwords) throws Exception;

	

}
