package com.medical.mapper;

import java.util.List;
import java.util.Map;

import com.medical.po.Doctorcalendar;
import com.medical.po.custom.CalendarParmas;


public interface DoctorcalendarMapperCustom {
    
	List<Doctorcalendar> selectByDocloginid(Integer docloginid);
	/**
	 * 获取日程
	 * @return
	 * @param
	 * */
	List<Map<String, Object>> selectAllInfoByDocloginid(CalendarParmas calendarParmas);
	Map<String, Object> selectAllInfoByDocCalendarId(Integer doccalendarid);
	List<Doctorcalendar> selectByDayAndTime(String day,String time);
	/**
	 * 插入日程并返回id
	 * @return
	 * @param
	 * */
	int insertSelectiveReturnId(Doctorcalendar record);
	/**
	 * 病人端获取医生日程
	 * @return
	 * @param
	 * */
	List<Map<String, Object>> selectAllInfoByDocloginidInUser(Integer docloginid);
	
}