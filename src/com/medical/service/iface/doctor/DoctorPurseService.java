package com.medical.service.iface.doctor;

import java.math.BigDecimal;

/**
 * @ClassName:     DoctorPurseService.java
 * @Description:   用户钱包功能接口
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午1:15:05 
 */
public interface DoctorPurseService {
	
	/**
	 * @Title: getAliPayAccount
	 * @Description: 获取支付宝账户
	 * @param docloginid 医生登录id
	 * @return
	 * @return: String
	 */
	String getAliPayAccount(Integer docloginid) throws Exception;
	
	/**
	 * @Title: updateAliPayAccount
	 * @Description: 更新支付宝账户
	 * @param docloginid 医生登录id
	 * @param alipayaccount 支付宝账号
	 * @param alipayname 
	 * @return
	 * @return: String
	 */
	String updateAliPayAccount(Integer docloginid, String alipayaccount, String alipayname) throws Exception;

	
	/**
	 * @Title: getBalance
	 * @Description: 获取余额
	 * @param docloginid 医生登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String getBalance(Integer docloginid) throws Exception;

	/**
	 * @Title: listBalanceRecord
	 * @Description: TODO 获取账户金额变动记录
	 * @param docloginid 医生登录id
	 * @param page 当前页
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listBalanceRecord(Integer docloginid, Integer page) throws Exception;

	/**
	 * @Title: listTradeRecord
	 * @Description: 获取交易记录
	 * @param docloginid 医生登录id
	 * @param page 当前页
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listTradeRecord(Integer docloginid, Integer page) throws Exception;

	/**
	 * @Title: listTradeRecordByOrder
	 * @Description: TODO
	 * @param userloginid
	 * @param userorderid
	 * @param page
	 * @return
	 * @return: String
	 */
	String listTradeRecordByOrder(Integer userloginid, Integer userorderid);

	/**
	 * @Title: listTradeRecordByConsultation
	 * @Description: TODO
	 * @param docloginid
	 * @param hosporderid
	 * @return
	 * @return: String
	 */
	String listTradeRecordByConsultation(Integer docloginid, Integer hosporderid);

	


	/**
	 * @Title: updateBalance
	 * @Description: 更新账户余额
	 * @param docloginid 医生登录id
	 * @param type 1为转入 2为转出
	 * @param amount 变动金额
	 * @param remark 备注
	 * @param payid 支付id 
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateBalance(Integer docloginid, Integer type, BigDecimal amount, String remark, Integer payid)
			throws Exception;

	

	

}
