/**
 * 
 */
package com.medical.service.iface.hospital;

import java.math.BigDecimal;

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
	String getAliPayAccount(Integer hosploginid) throws Exception;

	

	/**
	 * @Title: updateAliPayAccount
	 * @Description: TODO
	 * @param hosploginid
	 * @param alipayaccount
	 * @param alipayname
	 * @return
	 * @return: String
	 */
	String updateAliPayAccount(Integer hosploginid, String alipayaccount, String alipayname);

	/**
	 * @Title: listTradeRecordByOrder
	 * @Description: TODO
	 * @param hosploginid
	 * @param userorderid
	 * @return
	 * @return: String
	 */
	String listTradeRecordByOrder(Integer hosploginid, Integer userorderid) throws Exception;

	/**
	 * @Title: listTradeRecordByConsultation
	 * @Description: TODO
	 * @param hosploginid
	 * @param hosporderod
	 * @return
	 * @return: String
	 */
	String listTradeRecordByConsultation(Integer hosploginid, Integer hosporderod)throws Exception;

	/**
	 * @Title: updateBalance
	 * @Description: 更新医院账户余额
	 * @param hosploginid 医院登录id
	 * @param type 类型 1为转入 2为转出
	 * @param amount 变动金额
	 * @param remark 备注
	 * @param payid 支付id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateBalance(Integer hosploginid, Integer type, BigDecimal amount, String remark, Integer payid)
			throws Exception;

}
