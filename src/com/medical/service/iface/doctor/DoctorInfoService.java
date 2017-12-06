package com.medical.service.iface.doctor;

import java.util.Date;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.medical.po.Doctoraddress;
import com.medical.po.Doctorinfo;

public interface DoctorInfoService {

	/**
	 * 更新头像
	 * @return
	 * @param
	 * */
	String updatePix(Integer docloginid, MultipartFile picture) throws Exception;
	/**
	 * 获取我的介绍和我的擅长
	 * @return
	 * @param
	 * */
	String getNormalInfo(Integer docloginid) throws Exception;
	/**
	 * 更新我的介绍和我的擅长
	 * @return
	 * @param
	 * */
	String updateNormalInfo(Integer docloginid, String docexpert, String docabs) throws Exception;
	/**
	 * 更新第二页图片
	 * @return
	 * @param
	 * */
	String updateSecondInfo(Integer docloginid, Integer type, String oldpicture, MultipartFile[] picture)throws Exception;
	/**
	 * 新增日程
	 * @return
	 * @param
	 * */
	String getInfo(Integer docLoginId, Integer flag) throws Exception;
	/**
	 * 更新第一页信息
	 * @return
	 * @param
	 * */
	String updateFirstInfo(Doctorinfo doctor) throws Exception;
	/**
	 * 获取常用地址
	 * @return
	 * @param
	 * */
	String getAddress(Integer docloginid, Integer page) throws Exception;

	/**
	 * 获取所有地址 无分页
	 * @return
	 * @param
	 * */
	String getAllAddress(Integer docloginid) throws Exception;
	/**
	 * 添加常用地址
	 * @return
	 * @param
	 * */
	String addAddress(Doctoraddress doctoraddress) throws Exception;
	/**
	 * 修改常用地址
	 * @return
	 * @param
	 * */
	String editAddress(Doctoraddress doctoraddress) throws Exception;
	/**
	 * 删除常用地址
	 * @return
	 * @param
	 * */
	String delAddress(Integer docloginid, Integer docaddressid) throws Exception;
	/**
	 * 设置接诊地址
	 * @return
	 * @param
	 * */
	String updateAddress(Integer docloginid, Integer docaddressid) throws Exception;
	/**
	 * 新增日程
	 * @return
	 * @param
	 * */
	String addCalendar(Integer docloginid, Date doccalendarday, String doccalendartime, String doccalendaraffair,
			Integer doccalendaradressid) throws Exception;
	/**
	 * 修改日程
	 * @return
	 * @param
	 * */
	String editCalendar(Integer doccalendarid, Integer docloginid, Date doccalendarday, String doccalendartime,
			String doccalendaraffair, Integer doccalendaradressid) throws Exception;
	/**
	 * 删除日程
	 * @return
	 * @param
	 * */
	String deleteCalendar(Integer doccalendarid, Integer docloginid) throws Exception;
	/**
	 * 获取日程
	 * @return
	 * @param
	 * */
	String getCalendar(Integer docloginid, Integer page) throws Exception;
	/**
	 * 根据月份获取日程
	 * @return
	 * @param
	 * */
	String getCalendarByMonth(Integer docloginid, String year, String month) throws Exception;

	/**
	 * 获取部门
	 * @return
	 * @param
	 * */
	Map<String, Object> getDept() throws Exception;
	String setLocation(String time) throws Exception;
	/**
	 * @Title: updateChannelId
	 * @Description: TODO
	 * @param docloginid
	 * @param channelid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateChannelId(Integer docloginid, String channelid) throws Exception;
	/**
	 * @Title: updateInfoToReview
	 * @Description: TODO
	 * @param docloginid
	 * @return
	 * @return: String
	 */
	String updateInfoToReview(Integer docloginid) throws Exception;
	/**
	 * @Title: updateInfoToCancelReview
	 * @Description: TODO
	 * @param docloginid
	 * @return
	 * @return: String
	 */
	String updateInfoToCancelReview(Integer docloginid)throws Exception;

	


	

	

	

}
