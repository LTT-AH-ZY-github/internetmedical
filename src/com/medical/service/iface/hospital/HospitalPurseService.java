/**
 * 
 */
package com.medical.service.iface.hospital;

/**
 * @ClassName:     HospitalPurseService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午9:27:09 
 */
public interface HospitalPurseService {

	/**
	 * @Title: getBalance
	 * @Description: TODO
	 * @param hosploginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String getBalance(Integer hosploginid) throws Exception;

	/**
	 * @Title: listBalanceRecord
	 * @Description: TODO
	 * @param hosploginid
	 * @param page
	 * @param offset 
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listBalanceRecord(Integer hosploginid, Integer limit, Integer offset) throws Exception;

	
	/**
	 * @Title: listTradeRecord
	 * @Description: TODO
	 * @param hosploginid
	 * @param limit
	 * @param offset
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listTradeRecord(Integer hosploginid, Integer limit, Integer offset) throws Exception;

	/**
	 * @Title: getAliPayAccount
	 * @Description: TODO
	 * @param hosploginid
	 * @return
	 * @return: String
	 */
	String getAliPayAccount(Integer hosploginid);

	/**
	 * @Title: updateAliPayAccount
	 * @Description: TODO
	 * @param hosploginid
	 * @param alipayaccount
	 * @return
	 * @return: String
	 */
	String updateAliPayAccount(Integer hosploginid, String alipayaccount);

}
