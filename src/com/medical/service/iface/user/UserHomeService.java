package com.medical.service.iface.user;

import com.medical.po.DoctorSearch;

/**
 * @ClassName: UserHomeService.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xyh
 * @version V1.0
 * @Date 2017年12月7日 下午8:58:32
 */
public interface UserHomeService {

	/**
	 * @Title: listDoctor
	 * @Description: 获取医生
	 * @param doctorSearch
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listDoctor(DoctorSearch doctorSearch) throws Exception;

	/**
	 * @Title: findDoctorsInMap
	 * @Description: 地图模式获取医生
	 * @param userloginlat
	 *            纬度
	 * @param userloginlon
	 *            经度
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String findDoctorsInMap(String userloginlat, String userloginlon) throws Exception;

	/**
	 * @Title: findDoctorDetail
	 * @Description: 获取医生详情
	 * @param docloginid
	 *            医生登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String findDoctorDetail(Integer docloginid) throws Exception;

	/**
	 * @Title: listCalendar
	 * @Description: 获取医生当天30天内日程
	 * @param docloginid
	 *            医生登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listCalendar(Integer docloginid) throws Exception;

	/**
	 * @Title: getEvaluation
	 * @Description: 获取评价
	 * @param docloginid
	 *            医生登录id
	 * @param pageNo
	 *            当前页
	 * @return
	 * @return: String
	 */
	String getEvaluation(Integer docloginid, Integer pageNo);

}
