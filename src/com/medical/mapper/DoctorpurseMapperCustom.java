package com.medical.mapper;

import com.medical.po.Doctorpurse;
import com.medical.po.DoctorpurseExample;
import com.medical.po.custom.doctor.purse.Purse;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DoctorpurseMapperCustom {
   
	/**
	 * 查询医生的钱包资金流动
	 * */
    List<Doctorpurse> selectByDocLoginId(Integer docloginid);

    List<Map<String, Object>>  selectAllInfoByDocLoginId(Integer docloginid);

    
}