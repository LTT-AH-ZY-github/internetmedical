package com.medical.mapper;



import java.util.List;
import java.util.Map;

import com.medical.po.DoctorCustom;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorinfo;
import com.medical.po.HospSearchDocTerm;




public interface DoctorinfoMapperCustom {
    
	//医生信息列表模式
	List<Map<String, Object>> findDoctorInfoInList(DoctorSearch doctorSearch)throws Exception;
	//医生信息列表模式
	List<Map<String, Object>> findDoctorInfoInListByLoc(DoctorSearch doctorSearch)throws Exception;
	
	//医生信息地图模式
	List<Map<String, Object>> findDoctorInfoInMap(String arg1,String arg2,String arg3,String arg4)throws Exception;
	
	//根据登录Id查询医生
	Doctorinfo findDoctorinfoByDocLoginId(Integer docloginid);
	
	//根据登录Id查询医生
	Map<String, Object> findDoctorByDocLoginId(Integer docloginid);
	
	List<Map<String, Object>> findDoctorByInfo(DoctorSearch doctorSearch);
	
	//查询第一页信息
	Map<String, Object> selectFirstInfoByDocLoginId(Integer id);
	
	//查询第二页信息
	Map<String, Object> selectSecondInfoByDocLoginId(Integer id);
	
	
	Map<String, Object> selectNameAndTitleByDocLoginId(Integer id);
	
	//医院获取医生
	List<Map<String, Object>> paginationDoctorList(HospSearchDocTerm hospSearchDocTerm);
	
	//根据登录Id查询医生
	Doctorinfo selectByDocLoginId(Integer docloginid);
	
	
}