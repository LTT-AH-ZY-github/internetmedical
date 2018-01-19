package com.medical.service.iface.doctor;

import java.math.BigDecimal;

import com.medical.po.Userorder;

/**
 * @ClassName:     DoctorOrderService.java
 * @Description:   用户订单功能接口 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月9日 下午10:06:16 
 */
public interface DoctorOrderService {
	
	/**
	 * @Title: creatPreOrder
	 * @Description: 医生申请病情
	 * @param usersickid 病情id
	 * @param docloginid 医生登录id 
	 * @param preorderprice 预估费用
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String creatPreOrder(Integer usersickid, Integer docloginid, BigDecimal preorderprice) throws Exception;
	
	/**
	 * @Title: listGrabOrders
	 * @Description: 获取已申请的病情
	 * @param docloginid 医生登录id
	 * @param pageNo 当前页
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listGrabOrders(Integer docloginid, Integer pageNo) throws Exception;

	/**
	 * @Title: deletePreOrder
	 * @Description: 取消申请的病情
	 * @param docloginid 医生登录id
	 * @param preorderid 预订单id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String deletePreOrder(Integer docloginid, Integer preorderid) throws Exception;
	
	/**
	 * @Title: listOrderToConfirm
	 * @Description: 获取需要确认订单
	 * @param docloginid 医生登录id
	 * @param pageno 当前页
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listOrderToConfirm(Integer docLoginId, Integer pageNo) throws Exception;
	
	/**
	 * @Title: listOrders
	 * @Description: 获取订单
	 * @param docLoginId
	 * @param type
	 * @param pageNo
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listOrders(Integer docLoginId, Integer type, Integer pageNo) throws Exception;
	
	/**
	 * @Title: getOrderDetail
	 * @Description: 获取订单详情
	 * @param docloginid 医生登录id
	 * @param userorderid 订单id 
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String getOrderDetail(Integer docloginid, Integer userorderid) throws Exception;
	
	/**
	 * @Title: updateOrderToRefuse
	 * @Description: 拒绝订单(推荐其他医生)
	 * @param docloginid 医生登录id
	 * @param userorderid 订单id
	 * @param redocloginid 推荐医生登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateOrderToRefuse(Integer docloginid, Integer userorderid, Integer redocloginid) throws Exception;
	
	/**
	 * @Title: updateOrderConfirm
	 * @Description: 确认订单
	 * @param userorder
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String  updateOrderConfirm(Userorder userorder) throws Exception;
	
	/**
	 * @Title: updateOrderToCancle
	 * @Description: 取消订单
	 * @param docloginid 医生登录id
	 * @param userorderid 订单id 
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateOrderToCancle(Integer docLoginId, Integer userorderid) throws Exception;
	
	/**
	 * @Title: updateOrderTofinish
	 * @Description:结束订单
	 * @param docloginid 医生登录id
	 * @param userorderid 订单id
	 * @param userorderhstate 住院状态
	 * @param userorderhospid 医院id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateOrderTofinish(Integer docloginid, Integer userorderid, Boolean userorderhstate,
			Integer userorderhospid) throws Exception;
	
	/**
	 * @Title: listHistoryOrder
	 * @Description: 获取历史订单
	 * @param docloginid
	 * @param page
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listHistoryOrder(Integer docloginid, Integer page) throws Exception;

	/**
	 * @Title: updateToRefund
	 * @Description: TODO
	 * @param userorderid
	 * @param cancelreason 
	 * @param userloginid
	 * @return
	 * @return: String
	 */
	String updateToRefund(Integer userorderid, Integer docloginid, String cancelreason)throws Exception;
	
	
	
	
	
	
}
