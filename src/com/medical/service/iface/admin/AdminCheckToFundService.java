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
	 * @Title: updateDoctorPurese
	 * @Description: TODO
	 * @param docloginid
	 * @param docloginid 
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateFundToDoctor(Integer adminloginid, Integer docloginid) throws Exception;

	/**
	 * @Title: updateFundToHospita
	 * @Description: TODO
	 * @param adminloginid
	 * @param hosploginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateFundToHospital(Integer adminloginid, Integer hosploginid) throws Exception;

	/**
	 * @Title: listDoctorsToFund
	 * @Description: TODO
	 * @param adminloginid
	 * @param offset 
	 * @param limit 
	 * @return
	 * @return: String
	 */
	String listDoctorsToFund(Integer adminloginid, Integer limit, Integer offset) throws Exception;

	/**
	 * @Title: listhospitalsToFund
	 * @Description: TODO
	 * @param adminloginid
	 * @param limit
	 * @param offset
	 * @return
	 * @return: String
	 */
	String listhospitalsToFund(Integer adminloginid, Integer limit, Integer offset);

	/**
	 * @Title: updateFundToUser
	 * @Description: TODO
	 * @param adminloginid
	 * @param userorderid
	 * @return
	 * @return: String
	 * @throws Exception 
	 */
	String updateFundToUser(Integer adminloginid, Integer userorderid) throws Exception;

	/**
	 * @Title: listOrderToFund
	 * @Description: TODO
	 * @param adminloginid
	 * @return
	 * @return: String
	 */
	String listOrderToFund(Integer adminloginid);

	/**
	 * @Title: listOrderToFund
	 * @Description: TODO
	 * @param adminloginid
	 * @param limit
	 * @param offset
	 * @return
	 * @return: String
	 */
	String listOrderToFund(Integer adminloginid, Integer limit, Integer offset) throws Exception;

}
