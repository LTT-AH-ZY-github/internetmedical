package com.medical.service.iface.admin;

import java.math.BigDecimal;

public interface AdminFunctionService {
	/**
	 * 管理获取不同类型的用户
	 * @param usermale 
	 * @param enddatetime 
	 * @param startdatetime 
	 * @param userloginphone 
	 * @param userage 
	 * @param useradrarea 
	 * @param useradrcity 
	 * @param useradrprovince 
	 * @param 
	 * */
	String listUser(Integer adminloginid, Integer limit, Integer offset, Integer type, Integer useradrprovince, Integer useradrcity, Integer useradrarea, Integer userage, String userloginphone, String startdatetime, String enddatetime, String usermale) throws Exception;
	/**
	 * 管理获取用户详细信息
	 * @param 
	 * */
	String getUserDetail(Integer adminloginid, Integer userloginid) throws Exception;
	/**
	 * 管理审核用户信息
	 * @param idea 
	 *  
	 * */
	String updateUserType(Integer adminloginid, Integer userloginid, Boolean type, String idea) throws Exception;
	/**
	 * 管理员获取不同类型的医生
	 * @param enddatetime 
	 * @param startdatetime 
	 * @param dochospsdept 
	 * @param dochospfdept 
	 * @param dochosplevel 
	 * @param docloginphone 
	 * @param docage 
	 * @param doctitle 
	 * @param 
	 * */
	String listDoctor(Integer adminloginid, Integer limit, Integer offset, Integer type, String doctitle, Integer docage, String docloginphone, String dochosplevel, Integer dochospfdept, Integer dochospsdept, String startdatetime, String enddatetime) throws Exception;
	/**
	 * 管理获取医生详细信息
	 * @param 
	 * */
	String getDoctorDetail(Integer adminloginid, Integer userloginid)throws Exception;
	/**
	 * 管理审核医生信息
	 * @param idea 
	 *  
	 * */
	String updateDoctorType(Integer adminloginid, Integer docloginid, Boolean type, String idea)throws Exception;
	/**
	 * 管理获取医生列表信息
	 * @param enddatetime 
	 * @param startdatetime 
	 * @param hosploginphone 
	 * @param hosplevel 
	 * @param hospadrarea 
	 * @param hospadrcity 
	 * @param hospadrprovince 
	 * @param 
	 * */
	String listHospital(Integer adminloginid, Integer limit, Integer offset, Integer type, Integer hospadrprovince, Integer hospadrcity, Integer hospadrarea, String hosplevel, String hosploginphone, String startdatetime, String enddatetime)throws Exception;
	/**
	 * 管理获取医生详细信息
	 * @param 
	 * */
	String getHospitalDetail(Integer adminloginid, Integer hosploginid)throws Exception;
	/**
	 * 管理审核医院信息
	 * @param idea 
	 *  
	 * */
	String updateHospitalType(Integer adminloginid, Integer hosploginid, Boolean type, String idea)throws Exception;
	
	/**
	 * @Title: listDept
	 * @Description: TODO
	 * @param adminloginid
	 * @param limit
	 * @param offset
	 * @param check
	 * @return
	 * @return: String
	 */
	String listDept(Integer adminloginid, Integer limit, Integer offset, Integer check) throws Exception;
	/**
	 * @Title: checkDept
	 * @Description: TODO
	 * @param adminloginid
	 * @param hospdeptid
	 * @param hospdeptfatherid
	 * @return
	 * @return: String
	 */
	String checkDept(Integer adminloginid, Integer hospdeptid, Integer hospdeptfatherid) throws Exception;
	
	/**
	 * @Title: listFirstDept
	 * @Description: TODO
	 * @param adminloginid
	 * @return
	 * @return: String
	 */
	String listFirstDept(Integer adminloginid) throws Exception;
	
	/**
	 * @Title: listFeedBack
	 * @Description: TODO
	 * @param adminloginid
	 * @param check 
	 * @param type
	 * @param limit
	 * @param offset
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listFeedBack(Integer adminloginid, Boolean check, Integer type, Integer limit, Integer offset) throws Exception;
	/**
	 * @Title: updateFeedBackToCheck
	 * @Description: TODO
	 * @param adminloginid
	 * @param feedbackid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateFeedBackToCheck(Integer adminloginid, Integer feedbackid) throws Exception;
	/**
	 * @Title: updateRefundRate
	 * @Description: TODO
	 * @param adminloginid
	 * @param docfefundrate
	 * @param hospfefundrate
	 * @return
	 * @return: String
	 */
	String updateRefundRate(Integer adminloginid, BigDecimal docfefundrate, BigDecimal hospfefundrate)throws Exception;
	/**
	 * @Title: getRefundRate
	 * @Description: TODO
	 * @param adminloginid
	 * @return
	 * @return: String
	 */
	String getRefundRate(Integer adminloginid)throws Exception;
	
	
	
	

}
