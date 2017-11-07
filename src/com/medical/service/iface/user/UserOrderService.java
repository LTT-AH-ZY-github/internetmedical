package com.medical.service.iface.user;

import java.util.Map;

import com.github.pagehelper.PageInfo;

public interface UserOrderService {

	boolean createOrder(Integer docloginid, Integer userloginid, String userorderappointment) throws Exception;

	boolean updateOrderStateToCancel(Integer userOrderId, Integer userLoginId) throws Exception;

	PageInfo<Map<String, Object>> listOrders(Integer userloginid, Integer page, Integer type);

	Map<String, Object> getOrderDetail(Integer userloginid, Integer userorderid);

	boolean updateOrderStateToConfirm(Integer userloginid, Integer userorderid) throws Exception;

	boolean updateOrderStatePayDoctor(Integer userloginid, Integer userorderid) throws Exception;

	boolean updateOrderStatePayHospital(Integer userloginid, Integer userorderid);

}
