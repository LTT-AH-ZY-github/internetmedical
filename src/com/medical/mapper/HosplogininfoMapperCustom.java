package com.medical.mapper;

import com.medical.po.Hosplogininfo;
import com.medical.po.HosplogininfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HosplogininfoMapperCustom {
   
    Hosplogininfo selectByHospLoginPhone(String hosploginphone);

    int insertSelectiveReturnId(Hosplogininfo hosplogininfo);
}