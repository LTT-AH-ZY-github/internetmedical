package com.medical.mapper;

import java.util.List;
import java.util.Map;

import com.medical.po.Doctorcalendar;
import com.medical.po.custom.CalendarParmas;


public interface DoctorcalendarMapperCustom {
    
	/**
	 * @Title: selectByDocloginid
	 * @Description: 根据医生登录id获取医生日程
	 * @param docloginid
	 * @return
	 * @return: List<Doctorcalendar>
	 */
	List<Doctorcalendar> selectByDocloginid(Integer docloginid);
	/**
	 * 获取日程
	 * @return
	 * @param
	 * */
	List<Map<String, Object>> selectAllInfoByDocloginid(CalendarParmas calendarParmas);
	
	/**
	 * @Title: selectAllInfoByDocCalendarId
	 * @Description: 根据日程id获取日程及地址相关信息
	 * @param doccalendarid
	 * @return
	 * @return: Map<String,Object>
	 */
	Map<String, Object> selectAllInfoByDocCalendarId(Integer doccalendarid);
	//
	
	/**
	 * @Title: selectByDayAndTime
	 * @Description: 定时器根据时及上下午查询日程
	 * @param day
	 * @param time
	 * @return
	 * @return: List<Doctorcalendar>
	 */
	List<Doctorcalendar> selectByDayAndTime(String day,String time);
	/**
	 * 插入日程并返回id
	 * @return
	 * @param
	 * */
	int insertSelectiveReturnId(Doctorcalendar record);
	
	/**
	 * @Title: selectAllInfoByDocloginidInUser
	 * @Description: 病人端获取医生日程
	 * @param docloginid
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	List<Map<String, Object>> selectAllInfoByDocloginidInUser(Integer docloginid);
	
	/**
	 * @Title: selectByDocloginidAndDayInDoc
	 * @Description: 医生端查询医生指定日期前最新的日程 
	 * @param calendarParmas
	 * @return
	 * @return: List<Doctorcalendar>
	 */
	List<Doctorcalendar> selectByDocloginidAndDayInDoc(CalendarParmas calendarParmas);
	
	/**
	 * @Title: selectByDocloginidAndDayAndTimeInDoc
	 * @Description: 医生端查询医生指定日期日程 
	 * @param calendarParmas
	 * @return
	 * @return: List<Doctorcalendar>
	 */
	List<Doctorcalendar> selectByDocloginidAndDayAndTimeInDoc(CalendarParmas calendarParmas);
	
}