package com.medical.mapper;

import com.medical.po.Doctorlogininfo;
import com.medical.po.DoctorlogininfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorlogininfoMapper {
    int countByExample(DoctorlogininfoExample example);

    int deleteByExample(DoctorlogininfoExample example);

    int deleteByPrimaryKey(Integer docloginid);

    int insert(Doctorlogininfo record);

    int insertSelective(Doctorlogininfo record);

    List<Doctorlogininfo> selectByExample(DoctorlogininfoExample example);

    Doctorlogininfo selectByPrimaryKey(Integer docloginid);

    int updateByExampleSelective(@Param("record") Doctorlogininfo record, @Param("example") DoctorlogininfoExample example);

    int updateByExample(@Param("record") Doctorlogininfo record, @Param("example") DoctorlogininfoExample example);

    int updateByPrimaryKeySelective(Doctorlogininfo record);

    int updateByPrimaryKey(Doctorlogininfo record);
}