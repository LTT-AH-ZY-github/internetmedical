package com.medical.mapper;


import java.util.List;
import java.util.Map;

import com.medical.po.Hospinfo;



public interface HospinfoMapperCustom {
	//根据医院名模糊查询医院
	List<Map<String, Object>> selectByHospName(String hospname);
	Hospinfo selectByHospLoginId(Integer hosploginid);
}