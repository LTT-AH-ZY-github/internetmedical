package com.medical.mapper;

import com.medical.po.Appversion;
import com.medical.po.AppversionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppversionMapperCustom {
    
    List<Appversion> selectByAppyType(Integer apptype,Integer systemtype);
}