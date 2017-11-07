package com.medical.service.iface.doctor;

import java.util.Map;

import com.medical.po.Userorder;

public interface DoctorOrderService {

	Map<String, Object> creatPreOrder(int usersickid, int docloginid, Double preorderprice) throws Exception;

	Map<String, Object> listGrabOrders(Integer docloginid, Integer pageNo, Integer pageSize);

	Map<String, Object> getGrabOrderDetail(Integer preOrderId);

	Map<String, Object> deletePreOrder(Integer docloginid, Integer preorderid) throws Exception;

	Map<String, Object> listOrder(Integer docLoginId, Integer type, Integer pageNo, Integer pageSize) throws Exception;

	Map<String, Object> getOrderDetail(Integer docLoginId, Integer userOrderId);

	Map<String, Object> getHospital(String hospname);

	Map<String, Object> getDoctorByName(String docname);

	Map<String, Object> updateOrderToRefuse(Integer docloginid, Integer userorderid, Integer redocloginid) throws Exception;

	Map<String, Object> updateOrderConfirm(Userorder userorder) throws Exception;

	Map<String, Object> updateOrderToCancle(Integer docLoginId, Integer userorderid) throws Exception;

	Map<String, Object> finishOrder(Integer docloginid, Integer userorderid, Boolean userorderhstate,
			Integer userorderhospid);
	
}
