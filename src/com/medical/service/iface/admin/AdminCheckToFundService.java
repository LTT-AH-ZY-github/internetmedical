/**  
* @Title: AdminFundService.java  
* @Package com.medical.service.iface.admin  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月13日  
* @version V1.0  
*/  
package com.medical.service.iface.admin;

/**
 * @ClassName:     AdminFundService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月13日 上午11:27:22 
 */
public interface AdminCheckToFundService {

	/**
	 * @Title: listDoctorsToTransfer
	 * @Description: 获取需要提现的医生
	 * @param adminloginid 
	 * @param limit
	 * @param offset
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listDoctorToTransfer(Integer adminloginid, Integer limit, Integer offset) throws Exception;

	/**
	 * @Title: updateTransferToDoctor
	 * @Description: TODO
	 * @param adminloginid
	 * @param docloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateTransferToDoctor(Integer adminloginid, Integer docloginid) throws Exception;

	/**
	 * @Title: listHospitalToTransfer
	 * @Description: TODO
	 * @param adminloginid
	 * @param limit
	 * @param offset
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listHospitalToTransfer(Integer adminloginid, Integer limit, Integer offset) throws Exception;
	
	/**
	 * @Title: updateTransferToHospital
	 * @Description: TODO
	 * @param adminloginid
	 * @param hosploginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateTransferToHospital(Integer adminloginid, Integer hosploginid) throws Exception;

	/**
	 * @Title: listOrderToTransfer
	 * @Description: TODO
	 * @param adminloginid
	 * @param limit
	 * @param offset
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listOrderToTransfer(Integer adminloginid, Integer limit, Integer offset) throws Exception;

	/**
	 * @Title: updateTransferToUser
	 * @Description: TODO
	 * @param adminloginid
	 * @param userorderid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateTransferToUser(Integer adminloginid, Integer userorderid) throws Exception;

	/**
	 * @Title: listDoctorOrderToReFund
	 * @Description: TODO
	 * @param adminloginid
	 * @param limit
	 * @param offset
	 * @param type
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listDoctorOrderToReFund(Integer adminloginid, Integer limit, Integer offset, Integer type) throws Exception;

	/**
	 * @Title: updateReFundToUser
	 * @Description: TODO
	 * @param adminloginid
	 * @param userorderid
	 * @param type
	 * @param idea
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateReFundToUser(Integer adminloginid, Integer userorderid, Boolean type, String idea) throws Exception;

	/**
	 * @Title: getAlipayRecord
	 * @Description: 查询支付宝交易记录
	 * @param out_trade_no 商户订单号
	 * @param trade_no 支付宝订单号
	 * @return
	 * @return: String
	 */
	String getAlipayRecord(String out_trade_no, String trade_no) throws Exception;

	/**
	 * @Title: getAlipayBill
	 * @Description: TODO
	 * @param adminloginid
	 * @param billtype
	 * @param billdate
	 * @return
	 * @return: String
	 */
	String getAlipayBill(Integer adminloginid, String billtype, String billdate)throws Exception;

	/**
	 * @Title: getWXpayRecord
	 * @Description: TODO
	 * @param out_trade_no
	 * @param trade_no
	 * @return
	 * @return: String
	 */
	String getWXpayRecord(String out_trade_no, String trade_no) throws Exception;

	/**
	 * @Title: getWXpayRefundRecord
	 * @Description: TODO
	 * @param out_trade_no
	 * @param trade_no
	 * @param out_refund_no
	 * @param refund_id
	 * @return
	 * @return: String
	 */
	String getWXpayRefundRecord(String out_trade_no, String trade_no, String out_refund_no, String refund_id);


	


	
}
