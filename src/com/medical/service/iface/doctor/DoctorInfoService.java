package com.medical.service.iface.doctor;

import org.springframework.web.multipart.MultipartFile;
import com.medical.po.Doctoraddress;
import com.medical.po.Doctorcalendar;
import com.medical.po.Doctorinfo;

/**
 * @ClassName:     DoctorInfoService.java
 * @Description:   医生个人信息接口
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月9日 下午8:10:11 
 */
public interface DoctorInfoService {

	/**
	 * @Title: updatePix
	 * @Description: 更新头像
	 * @param docloginid 医生登录id
	 * @param picture 头像
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updatePix(Integer docloginid, MultipartFile picture) throws Exception;
	
	/**
	 * @Title: getNormalInfo
	 * @Description: 获取我的介绍和我的擅长
	 * @param docloginid 医生登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String getAbsAndExpert(Integer docloginid) throws Exception;
	
	/**
	 * @Title: updateNormalInfo
	 * @Description: 更新我的介绍和我的擅长
	 * @param docloginid 医生登录id
	 * @param docexpert 擅长
	 * @param docabs 简介
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateAbsAndExpert(Integer docloginid, String docexpert, String docabs) throws Exception;
	
	/**
	 * @Title: getInfo
	 * @Description: 获取医生个人信息
	 * @param docloginid 医生登录id
	 * @param flag 类型 1为获取普通信息，2为获取照片
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String getInfo(Integer docloginid, Integer flag) throws Exception;
	
	/**
	 * @Title: updateNormalInfo
	 * @Description: 更新个人信息
	 * @param doctor 
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateNormalInfo(Doctorinfo doctor) throws Exception;
	/**
	 * @Title: updateSomePicture
	 * @Description: 更新不同类型图片
	 * @param docloginid 医生登录id
	 * @param type 照片类型 1为身份证照片，2为职称照片，3为行医资格证照片，4为工作证照片，5为其他照片
	 * @param oldpicture 原照片路径
	 * @param picture 上传的照片
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateSomePicture(Integer docloginid, Integer type, String oldpicture, MultipartFile[] picture)throws Exception;
	
	/**
	 * @Title: listAddress
	 * @Description: 获取常用地址
	 * @param docloginid 医生登录id
	 * @param page 当前页
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listAddress(Integer docloginid, Integer page) throws Exception;

	/**
	 * @Title: listAllAddress
	 * @Description: 获取全部地址(无分页)
	 * @param docloginid 医生登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listAllAddress(Integer docloginid) throws Exception;
	
	/**
	 * @Title: addAddress
	 * @Description:  添加常用地址
	 * @param doctoraddress
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String addAddress(Doctoraddress doctoraddress) throws Exception;
	
	/**
	 * @Title: editAddress
	 * @Description: 修改常用地址
	 * @param doctoraddress
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateAddress(Doctoraddress doctoraddress) throws Exception;
	
	/**
	 * @Title: delAddress
	 * @Description: 删除地址
	 * @param docloginid 医生登录id
	 * @param docaddressid 地址id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String delAddress(Integer docloginid, Integer docaddressid) throws Exception;
	
	/**
	 * @Title: updateAddressToCheck
	 * @Description: 设置接诊地址
	 * @param docloginid 医生登录id
	 * @param docaddressid 地址id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateAddressToCheck(Integer docloginid, Integer docaddressid) throws Exception;
	
	/**
	 * @Title: listCalendars
	 * @Description: 获取日程
	 * @param docloginid 医生登录id
	 * @param page 当前页
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listCalendars(Integer docloginid, Integer page) throws Exception;
	
	/**
	 * @Title: listCalendarsByMonth
	 * @Description:根据月份获取日程
	 * @param docloginid 医生登录id
	 * @param year 年 格式（2017）
	 * @param month 月（09）
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listCalendarsByMonth(Integer docloginid, String year, String month) throws Exception;
	
	/**
	 * @Title: addCalendar
	 * @Description:  新增日程
	 * @param doctorcalendar
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String addCalendar(Doctorcalendar doctorcalendar) throws Exception;
	
	/**
	 * @Title: updateCalendar
	 * @Description: 修改日程
	 * @param doctorcalendar
	 * @return
	 * @return: String
	 */
	String updateCalendar(Doctorcalendar doctorcalendar) throws Exception;
	
	/**
	 * @Title: deleteCalendar
	 * @Description: 删除日程
	 * @param doccalendarid 日程id
	 * @param docloginid 医生登录id
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String deleteCalendar(Integer doccalendarid, Integer docloginid) throws Exception;
	
	/**
	 * @Title: updateChannelId
	 * @Description: 更新百度云ChannelId
	 * @param docloginid 医生登录id
	 * @param channelid 百度云ChannelId
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateChannelId(Integer docloginid, String channelid) throws Exception;
	/**
	 * @Title: updateInfoToReview
	 * @Description: 提交审核
	 * @param docloginid 医生登录id
	 * @return
	 * @return: String
	 */
	String updateInfoToReview(Integer docloginid) throws Exception;
	/**
	 * @Title: updateInfoToCancelReview
	 * @Description: 撤销审核
	 * @param docloginid 医生登录id
	 * @return
	 * @return: String
	 */
	String updateInfoToCancelReview(Integer docloginid)throws Exception;

	/**
	 * @Title: updateLocation
	 * @Description: 更新医生位置
	 * @param time
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String updateLocation(String time) throws Exception;

	/**
	 * @Title: getReviewInfo
	 * @Description: TODO
	 * @param docloginid
	 * @return
	 * @return: String
	 */
	String getReviewInfo(Integer docloginid)throws Exception;

	


	

	

	

}
