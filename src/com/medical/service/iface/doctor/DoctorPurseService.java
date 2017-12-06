/**
 * 
 */
package com.medical.service.iface.doctor;

/**
 * @ClassName:     DoctorPurseService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午1:15:05 
 */
public interface DoctorPurseService {

	/**
	 * @Title: getBalance
	 * @Description: TODO
	 * @param docloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String getBalance(Integer docloginid) throws Exception;

	/**
	 * @Title: listBalanceRecord
	 * @Description: TODO
	 * @param docloginid
	 * @param page
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listBalanceRecord(Integer docloginid, Integer page) throws Exception;

	/**
	 * @Title: listTradeRecord
	 * @Description: TODO
	 * @param docloginid
	 * @param page
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listTradeRecord(Integer docloginid, Integer page) throws Exception;

	

	/**
	 * @Title: editAliPayAccount
	 * @Description: TODO
	 * @param docloginid
	 * @param alipayaccount
	 * @return
	 * @return: String
	 */
	String updateAliPayAccount(Integer docloginid, String alipayaccount) throws Exception;

	/**
	 * @Title: getAliPayAccount
	 * @Description: TODO
	 * @param docloginid
	 * @return
	 * @return: String
	 */
	String getAliPayAccount(Integer docloginid) throws Exception;

}
