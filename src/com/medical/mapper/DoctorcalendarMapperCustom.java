package com.medical.mapper;

import java.util.List;
import java.util.Map;

import com.medical.po.Doctorcalendar;


public interface DoctorcalendarMapperCustom {
    
	List<Doctorcalendar> selectByDocloginid(Integer docloginid);
	List<Map<String, Object>> selectAllInfoByDocloginid(Integer docloginid);
	List<Doctorcalendar> selectByDayAndTime(String day,String time);

}