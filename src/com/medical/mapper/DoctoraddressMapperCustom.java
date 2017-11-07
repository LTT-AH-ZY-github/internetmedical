package com.medical.mapper;

import com.medical.po.Doctoraddress;
import com.medical.po.DoctoraddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctoraddressMapperCustom {
   

    List<Doctoraddress> selectByDocloginid(Integer docloginid);
    int updateCheckedByDocLoginId(Integer docloginid,Integer checked);
   
}