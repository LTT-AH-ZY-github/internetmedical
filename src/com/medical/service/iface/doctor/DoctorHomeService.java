package com.medical.service.iface.doctor;

import java.util.Map;

public interface DoctorHomeService {

	/*String listSick(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon,
			String time, String province, String city, String area);*/

	String getSickDetail(Integer docloginid, Integer usersickid) throws Exception;

	String listSickByRecommend(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon);

	String listSickByTime(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon);

	

	String listSickByLoc(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon, String province,
			String city, String area);
	/**
	 * 根据医院名模糊查询医院
	 * @param
	 * @return
	 * 
	 * */
	String listHospital(String hospname);
	/**
	 *根据医院id获取医院信息
	 * @param
	 * @return
	 * 
	 * */
	String getHospitalDetail(Integer hosploginid);
}
