package com.medical.mapper;

import com.medical.po.Pay;
import com.medical.po.PayExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PayMapperCustom {
	
	int insertSelectiveReturnId(Pay record);
    Pay selectByPayTradeNo(String paytradeno);
    List<Map<String, Object>> selectByLoginIdAndType(Integer loginid,Integer type);

   
}