/**
 * 
 */
package com.medical.service.iface.hospital;

import java.math.BigDecimal;
import java.util.Map;

import com.medical.po.HospSearchDocTerm;

/**
 * @ClassName:     HospitalConsultationService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午3:16:54 
 */
public interface HospitalConsultationService {
	
	/**
	 * @Title: creatConsultation
	 * @Description: TODO
	 * @param docloginid
	 * @param hosploginid
	 * @param orderabs
	 * @param orderstime
	 * @param orderhospprice
	 * @param orderhosptpricetype
	 * @param orderhosptprice
	 * @param orderhospapricetype
	 * @param orderhospaprice
	 * @param orderhospepricetype
	 * @param orderhospeprice
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String creatConsultation(Integer docloginid, Integer hosploginid, String orderabs, String orderstime,
			BigDecimal orderhospprice, Integer orderhosptpricetype, BigDecimal orderhosptprice,
			Integer orderhospapricetype, BigDecimal orderhospaprice, Integer orderhospepricetype,
			BigDecimal orderhospeprice) throws Exception;

	/**
	 * @Title: cancelConsultation
	 * @Description: TODO
	 * @param hosploginid
	 * @param hosporderid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String cancelConsultation(Integer hosploginid, Integer hosporderid) throws Exception;

	/**
	 * @Title: updateStatePayDoctor
	 * @Description: TODO
	 * @param hosploginid
	 * @param hosporderid
	 * @param type
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateStatePayDoctor(Integer hosploginid, Integer hosporderid, Integer type) throws Exception;

	

	/**
	 * @Title: updateStateFinishConsultation
	 * @Description: TODO
	 * @param hosploginid
	 * @param hosporderid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateStateFinishConsultation(Integer hosploginid, Integer hosporderid) throws Exception;

	/**
	 * @Title: listDoctor
	 * @Description: TODO
	 * @param pageNo
	 * @param pageSize
	 * @param hospSearchDocTerm
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	//String listDoctor(Integer pageNo, Integer pageSize, HospSearchDocTerm hospSearchDocTerm) throws Exception;

	/**
	 * @Title: updateStatePayDoctorFinish
	 * @Description: TODO
	 * @param requestParams
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateStatePayDoctorFinish(Map<String, String[]> requestParams) throws Exception;

	/**
	 * @Title: listConsultation
	 * @Description: TODO
	 * @param hosploginid
	 * @param offset
	 * @param limit
	 * @param type
	 * @return
	 * @return: String
	 * @throws Exception 
	 */
	String listConsultation(Integer hosploginid, Integer offset, Integer limit, Integer type) throws Exception;

	/**
	 * @Title: listCalendar
	 * @Description: TODO
	 * @param docloginid
	 * @return
	 * @return: String
	 */
	String listCalendar(Integer docloginid)throws Exception; 

	/**
	 * @Title: listDoctor
	 * @Description: TODO
	 * @param page
	 * @param pageSize
	 * @param province_code
	 * @param area_code
	 * @param city_code
	 * @param details
	 * @param doctortitle
	 * @param hosplevel
	 * @param one_level_dept
	 * @param two_level_dept
	 * @return
	 * @return: String
	 * @throws Exception 
	 */
	String listDoctor(Integer page, Integer pageSize, Integer province_code, Integer area_code, Integer city_code,
			String details, String doctortitle, String hosplevel, Integer one_level_dept, Integer two_level_dept) throws Exception;

	

}
