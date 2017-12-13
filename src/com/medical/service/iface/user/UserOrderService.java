package com.medical.service.iface.user;

import java.util.Map;

import com.medical.po.Userorder;


public interface UserOrderService {
	/**
	 * @Title: createOrder
	 * @Description: 生成订单
	 * @param docloginid 医生登录id
	 * @param userloginid 用户登录id
	 * @param userorderappointment 预约时间
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String createOrder(Integer docloginid, Integer userloginid, String userorderappointment) throws Exception;
	
	/**
	 * @Title: updateOrderStateToCancel
	 * @Description: 取消医生订单
	 * @param userorderid 订单id
	 * @param userloginid 病人登录id 
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateOrderStateToCancel(Integer userorderid, Integer userloginid) throws Exception;
	
	/**
	 * @Title: listOrders
	 * @Description: 获取不同类型订单
	 * @param userloginid 用户登录id
	 * @param page 当前页
	 * @param type 订单类型
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listOrders(Integer userloginid, Integer page, Integer type)throws Exception;
	/**
	 * 获取订单详情
	 * */
	String getOrderDetail(Integer userloginid, Integer userorderid)throws Exception;
	/**
	 * 确认订单
	 * @param type 
	 * */
	String updateOrderStateToConfirm(Integer userloginid, Integer userorderid, Integer type) throws Exception;
	/**
	 * 支付医生费用
	 * */
	String updateOrderStatePayDoctorByAliPay(Userorder userorder) throws Exception;
	/**
	 * 支付医生费用完成后回调
	 * @throws Exception 
	 * */
	String updateOrderStatePayDoctorFinishByAliPay(Map<String, String[]> requestParams) throws Exception;
	/**
	 * 支付医院押金
	 * */
	String updateOrderStatePayHospitalByAlipay(Userorder userorder)throws Exception;
	/**
	 * 支付医院押金回调
	 * */
	String updateOrderStatePayHospitalFinishByAlipay(Map<String, String[]> requestParams) throws Exception;
	/**
	 * 取消住院
	 * */
	String updateOrderStateToCancelHospital(Integer userloginid, Integer userorderid) throws Exception;
	/**
	 * 评论
	 * */
	String insertEvaluate(Integer userorderid, Integer userloginid, Integer doccommentservicelevel,
			Integer doccommentprofessionallevel, Integer doccommentpricelevel, String doccommentwords,
			Integer hospcommentservicelevel, Integer hospcommentenvironmenlevel, Integer hospcommentpricelevel,
			String hospcommentwords) throws Exception;
	
	/**
	 * @Title: updateOrderStatePayHospital
	 * @Description: TODO
	 * @param userloginid
	 * @param userorderid
	 * @param type
	 * @return
	 * @return: String
	 * @throws Exception 
	 */
	String updateOrderStatePayHospital(Integer userloginid, Integer userorderid, Integer type) throws Exception;
	
	
	
	
	
	

	

}
