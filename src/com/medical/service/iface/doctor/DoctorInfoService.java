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
	String getNormalInfo(Integer docloginid);
	/**
	 * 更新我的介绍和我的擅长
	 * @return
	 * @param
	 * */
	String updateNormalInfo(Integer docloginid, String docexpert, String docabs);
	/**
	 * 新增日程
	 * @return
	 * @param
	 * */
	int updateSecondInfo(Integer docloginid, Integer type, String oldpicture, MultipartFile[] picture);
	/**
	 * 新增日程
	 * @return
	 * @param
	 * */
	Map<String, Object> getInfo(Integer docLoginId, Integer flag);
	/**
	 * 新增日程
	 * @return
	 * @param
	 * */
	int updateInfo(Doctorinfo doctor) throws Exception;
	/**
	 * 新增日程
	 * @return
	 * @param
	 * */
	Map<String, Object> getAddress(Integer docloginid, Integer page);
	/**
	 * 新增日程
	 * @return
	 * @param
	 * */
	int addAddress(Doctoraddress doctoraddress);
	/**
	 * 新增日程
	 * @return
	 * @param
	 * */
	int editAddress(Doctoraddress doctoraddress);
	/**
	 * 新增日程
	 * @return
	 * @param
	 * */
	int delAddress(Integer docloginid, Integer docaddressid);
	/**
	 * 新增日程
	 * @return
	 * @param
	 * */
	int updateAddress(Integer docloginid, Integer docaddressid);
	/**
	 * 新增日程
	 * @return
	 * @param
	 * */
	String addCalendar(Integer docloginid, Date doccalendarday, String doccalendartime, String doccalendaraffair,
			Integer doccalendaradressid);
	/**
	 * 修改日程
	 * @return
	 * @param
	 * */
	String editCalendar(Integer doccalendarid, Integer docloginid, Date doccalendarday, String doccalendartime,
			String doccalendaraffair, Integer doccalendaradressid);
	/**
	 * 删除日程
	 * @return
	 * @param
	 * */
	int deleteCalendar(Integer doccalendarid, Integer docloginid);
	/**
	 * 获取日程
	 * @return
	 * @param
	 * */
	String getCalendar(Integer docloginid, Integer page);
	/**
	 * 根据月份获取日程
	 * @return
	 * @param
	 * */
	String getCalendarByMonth(Integer docloginid, String year, String month);

	/**
	 * 新增日程
	 * @return
	 * @param
	 * */
	Map<String, Object> getDept() throws Exception;

	

	/**
	 * 获取所有地址
	 * @return
	 * @param
	 * */
	String getAllAddress(Integer docloginid);

	

	

	

}
