package com.medical.service.iface.doctor;

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
	 * @return
	 * @return: String
	 */
	String updateAliPayAccount(Integer docloginid, String alipayaccount) throws Exception;

	
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

	

	

}
