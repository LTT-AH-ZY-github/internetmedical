package com.medical.mapper;

import com.medical.po.Hospitalpackage;
import com.medical.po.HospitalpackageExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface HospitalpackageMapperCustom {
    List<Map<String, Object>> selectByHospLoginId(Integer hosploginid);
}