package com.medical.service.iface.user;


/**
 * @ClassName: UserHomeService.java
 * @Description: 用户主页功能
 * @author xyh
 * @version V1.0
 * @Date 2017年12月7日 下午8:58:32
 */
public interface UserHomeService {

	/**
	 * @Title: listDoctorsInList
	 * @Description: 列表获取医生
	 * @param page
	 * @param userloginlon
	 * @param userloginlat
	 * @param dochospprovince
	 * @param dochospcity
	 * @param dochosparea
	 * @param docprimarydept
	 * @param docseconddept
	 * @param type
	 * @return
	 * @return: String
	 */
	String listDoctorsInList(Integer page, String userloginlon, String userloginlat, String dochospprovince,
			String dochospcity, String dochosparea, String docprimarydept, String docseconddept, Integer type)throws Exception;

	/**
	 * @Title: listDoctorsInMap
	 * @Description: 地图模式获取医生
	 * @param userloginlat
	 *            纬度
	 * @param userloginlon
	 *            经度
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listDoctorsInMap(String userloginlat, String userloginlon) throws Exception;

	/**
	 * @Title: getDoctorDetail
	 * @Description: 获取医生详情
	 * @param docloginid
	 *            医生登录id
	 * @param userloginid 
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String getDoctorDetail(Integer docloginid, Integer userloginid) throws Exception;

	/**
	 * @Title: listCalendars
	 * @Description: 获取医生当天30天内日程
	 * @param docloginid
	 *            医生登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listCalendars(Integer docloginid) throws Exception;

	/**
	 * @Title: listEvaluations
	 * @Description: 获取评价
	 * @param docloginid
	 *            医生登录id
	 * @param pageNo
	 *            当前页
	 * @return
	 * @return: String
	 */
	String listEvaluations(Integer docloginid, Integer pageNo) throws Exception;

	

}
