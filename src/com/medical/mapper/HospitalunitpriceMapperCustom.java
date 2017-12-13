package com.medical.mapper;

import com.medical.po.Hospitalunitprice;
import com.medical.po.HospitalunitpriceExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface HospitalunitpriceMapperCustom {
   
    List<Map<String, Object>> selectByHospLoginId(Integer hosploginid);

   
}