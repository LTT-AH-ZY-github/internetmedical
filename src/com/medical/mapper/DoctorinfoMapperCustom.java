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
	//List<Map<String, Object>> findDoctorInfoInListByLoc(DoctorSearch doctorSearch)throws Exception;
	
	//医生信息地图模式
	List<Map<String, Object>> findDoctorInfoInMap(double arg1,double arg2,double arg3,double arg4)throws Exception;
	
	//根据登录Id查询医生
	Doctorinfo findDoctorinfoByDocLoginId(Integer docloginid);
	
	//根据登录Id查询医生
	Map<String, Object> findDoctorByDocLoginId(Integer docloginid);
	
	List<Map<String, Object>> findDoctorByInfo(DoctorSearch doctorSearch);
	
	//查询第一页信息
	Map<String, Object> selectFirstInfoByDocLoginId(Integer id);
	Map<String, Object> selectFirstInfoDeptByDocLoginId(Integer id);
	
	//查询第二页信息
	Map<String, Object> selectSecondInfoByDocLoginId(Integer id);
	
	
	Map<String, Object> selectNameAndTitleByDocLoginId(Integer id);
	
	//医院获取医生
	List<Map<String, Object>> paginationDoctorList(HospSearchDocTerm hospSearchDocTerm);
	
	//根据登录Id查询医生
	Doctorinfo selectByDocLoginId(Integer docloginid);
	
	List<Doctorinfo> selectByDept(String docPrimaryDept,String docSecondDept );
	//根据医生姓名获取医生
	List<Map<String, Object>> selectByName(String docname);
	int updateInfoByPrimaryKey(Doctorinfo doctorinfo);
	/**
	 * 管理员获取医生列表
	 * @param 用户账号类型
	 * */
	List<Map<String, Object>> selectByDocLoginTypeInAdmin(Integer type);
	/**
	 * 管理员获取医生详细信息
	 * @param 医生登录id
	 * */
	Map<String, Object>selectInfoByDocLoginIdInAdmin(Integer docloginid);
}