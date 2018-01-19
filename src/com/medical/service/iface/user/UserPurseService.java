package com.medical.service.iface.user;

/**
 * @ClassName:     UserPursueService.java
 * @Description:   用户钱包功能接口
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 上午11:54:13 
 */
public interface UserPurseService {

	/**
	 * @Title: getBalance
	 * @Description: TODO
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String getBalance(Integer userloginid) throws Exception;

	/**
	 * @Title: listBalanceRecord
	 * @Description: TODO
	 * @param userloginid
	 * @param page
	 * @return
	 * @return: String
	 */
	String listBalanceRecord(Integer userloginid, Integer page) throws Exception;

	/**
	 * @Title: listTradeRecord
	 * @Description: TODO
	 * @param userloginid
	 * @param page
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listTradeRecord(Integer userloginid, Integer page) throws Exception;

	/**
	 * @Title: addAliPayAccount
	 * @Description: 更新用户绑定的支付宝账号
	 * @param userloginid 用户登录id
	 * @param alipayaccount 支付宝账号
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateAliPayAccount(Integer userloginid, String alipayaccount,String alipayname) throws Exception;

	/**
	 * @Title: getAliPayAccount
	 * @Description: 获取用户绑定的支付宝账号<
	 * @param userloginid 用户登录id
	 * @return
	 * @return: String
	 * @throws Exception 
	 */
	String getAliPayAccount(Integer userloginid) throws Exception;

	/**
	 * @Title: listTradeRecordByOrder
	 * @Description: 根据订单获取交易记录
	 * @param userloginid
	 * @param userorderid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listTradeRecordByOrder(Integer userloginid, Integer userorderid) throws Exception;


}
