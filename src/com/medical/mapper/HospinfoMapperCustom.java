package com.medical.mapper;


import java.util.List;
import java.util.Map;

import com.medical.po.Hospinfo;



public interface HospinfoMapperCustom {
	
	/**
	 * @Title: selectByHospTypeInAdmin
	 * @Description: 管理员获取医院列表
	 * @param type
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	List<Map<String, Object>> selectByHospTypeInAdmin(Integer type,Integer key);
	/**
	 * 管理员获取医院详细信息
	 * @param 医院登录id
	 * */
	Map<String, Object> selectInfoByHospLoginIdInAdmin(Integer hosploginid);
	//根据医院名模糊查询医院
	List<Map<String, Object>> selectByHospName(String hospname);
	Hospinfo selectByHospLoginId(Integer hosploginid);
	
	/**
	 * @Title: selectAllInfoByHospLoginIdInDoctor
	 * @Description: 医生端获取医院信息
	 * @param hosploginid
	 * @return
	 * @return: Map<String,Object>
	 */
	Map<String, Object> selectAllInfoByHospLoginIdInDoctor(Integer hosploginid);
}