package com.medical.mapper;


import java.util.List;
import java.util.Map;

import com.medical.po.Doctorcomment;


public interface DoctorcommentMapperCustom {
    
	//查询医生的相关评论
    List<Map<String, Object>> selectByDocLoginId(Integer docloginid);
    //根据
    List<Doctorcomment> selectByUserLoginIdAndUserOrderId(Integer userloginid,Integer userorderid);

}