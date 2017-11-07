package com.medical.mapper;

import com.medical.po.Doctoraddress;
import com.medical.po.DoctoraddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctoraddressMapper {
    int countByExample(DoctoraddressExample example);

    int deleteByExample(DoctoraddressExample example);

    int deleteByPrimaryKey(Integer docaddressid);

    int insert(Doctoraddress record);

    int insertSelective(Doctoraddress record);

    List<Doctoraddress> selectByExample(DoctoraddressExample example);

    Doctoraddress selectByPrimaryKey(Integer docaddressid);

    int updateByExampleSelective(@Param("record") Doctoraddress record, @Param("example") DoctoraddressExample example);

    int updateByExample(@Param("record") Doctoraddress record, @Param("example") DoctoraddressExample example);

    int updateByPrimaryKeySelective(Doctoraddress record);

    int updateByPrimaryKey(Doctoraddress record);
}