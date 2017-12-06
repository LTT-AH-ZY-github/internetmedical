package com.medical.service.iface.doctor;

import java.util.Map;

public interface DoctorHomeService {

	/*String listSick(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon,
			String time, String province, String city, String area);*/

	String getSickDetail(Integer docloginid, Integer usersickid) throws Exception;

	String listSickByRecommend(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon)throws Exception;

	String listSickByTime(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon)throws Exception;

	

	String listSickByLoc(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon, String province,
			String city, String area) throws Exception;
	/**
	 * 根据医院名模糊查询医院
	 * @param
	 * @return
	 * 
	 * */
	String listHospital(String hospname) throws Exception;
	/**
	 *根据医院id获取医院信息
	 * @param
	 * @return
	 * 
	 * */
	String getHospitalDetail(Integer hosploginid) throws Exception;

	/**
	 * @Title: changeDept
	 * @Description: TODO
	 * @param docloginid
	 * @param usersickid
	 * @param usersickprimarydept
	 * @param usersickseconddept
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String changeDept(Integer docloginid, Integer usersickid, String usersickprimarydept, String usersickseconddept)
			throws Exception;

	/**
	 * @Title: getDoctorByName
	 * @Description: TODO
	 * @param docname
	 * @return
	 * @return: Map<String,Object>
	 */
	Map<String, Object> getDoctorByName(String docname) throws Exception;
}
