package com.medical.service.iface.user;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.medical.po.DoctorSearch;

/**
 * @author xyh
 *
 */
public interface UserHomeService {
	/**
	 * 获取医生
	 * @return
	 * @param
	 * */
	String listDoctor(DoctorSearch doctorSearch) throws Exception;
	/**
	 * 地图模式获取医生
	 * @return
	 * @param
	 * */
	String findDoctorsInMap(String userloginlat, String userloginlon) throws Exception;
	/**
	 * 获取医生详情
	 * @return
	 * @param
	 * */
	String findDoctorDetail(Integer docloginid) throws Exception;
	/**
	 * 获取医生当天30天内日程
	 * @return
	 * @param
	 * */
	String listCalendar(Integer docloginid, Integer page) throws Exception;
	
	/**
	 * 获取对医生评价
	 * @return
	 * @param
	 * */
	String getEvaluation(Integer docloginid, Integer pageNo);

}
