package com.medical.service.iface.admin;

public interface AdminFunctionService {
	/**
	 * 管理获取不同类型的用户
	 * @param 
	 * */
	String listUser(Integer adminloginid, Integer limit, Integer offset, Integer type) throws Exception;
	/**
	 * 管理获取用户详细信息
	 * @param 
	 * */
	String getUserDetail(Integer adminloginid, Integer userloginid) throws Exception;
	/**
	 * 管理审核用户信息
	 *  
	 * */
	String updateUserType(Integer adminloginid, Integer userloginid, Boolean type) throws Exception;
	/**
	 * 管理员获取不同类型的医生
	 * @param 
	 * */
	String listDoctor(Integer adminloginid, Integer limit, Integer offset, Integer type) throws Exception;
	/**
	 * 管理获取医生详细信息
	 * @param 
	 * */
	String getDoctorDetail(Integer adminloginid, Integer userloginid)throws Exception;
	/**
	 * 管理审核医生信息
	 *  
	 * */
	String updateDoctorType(Integer adminloginid, Integer docloginid, Boolean type)throws Exception;
	/**
	 * 管理获取医生列表信息
	 * @param 
	 * */
	String listHospital(Integer adminloginid, Integer limit, Integer offset, Integer type)throws Exception;
	/**
	 * 管理获取医生详细信息
	 * @param 
	 * */
	String getHospitalDetail(Integer adminloginid, Integer hosploginid)throws Exception;
	/**
	 * 管理审核医院信息
	 *  
	 * */
	String updateHospitalType(Integer adminloginid, Integer hosploginid, Boolean type)throws Exception;
	
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
	String listDept(Integer adminloginid, Integer limit, Integer offset, Integer check);
	/**
	 * @Title: checkDept
	 * @Description: TODO
	 * @param adminloginid
	 * @param hospdeptid
	 * @param hospdeptfatherid
	 * @return
	 * @return: String
	 */
	String checkDept(Integer adminloginid, Integer hospdeptid, Integer hospdeptfatherid);
	
	/**
	 * @Title: listFirstDept
	 * @Description: TODO
	 * @param adminloginid
	 * @return
	 * @return: String
	 */
	String listFirstDept(Integer adminloginid);
	
	
	
	

}
