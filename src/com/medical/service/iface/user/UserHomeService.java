package com.medical.service.iface.user;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.medical.po.DoctorSearch;

public interface UserHomeService {

	PageInfo<Map<String, Object>> listDoctor(DoctorSearch doctorSearch) throws Exception;

	List<Map<String, Object>> findDoctorsInMap(String userloginlat, String userloginlon) throws Exception;

	Map<String, Object> findDoctorDetail(Integer docloginid) throws Exception;

}
