/**
 * 
 */
package com.medical.service.iface.user;

/**
 * @ClassName:     UserPursueService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
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
	 * @Description: TODO
	 * @param userloginid
	 * @param alipayaccount
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String addAliPayAccount(Integer userloginid, String alipayaccount) throws Exception;

	/**
	 * @Title: getAliPayAccount
	 * @Description: TODO
	 * @param docloginid
	 * @return
	 * @return: String
	 * @throws Exception 
	 */
	String getAliPayAccount(Integer docloginid) throws Exception;

}
