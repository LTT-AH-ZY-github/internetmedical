package com.medical.mapper;

import com.medical.po.Hosppurse;
import com.medical.po.HosppurseExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface HosppurseMapperCustom {
    

    List<Hosppurse> selectHosploginid(Integer hosploginid);
    List<Map<String, Object>> selectAllInfoByHosploginid(Integer hosploginid);

}