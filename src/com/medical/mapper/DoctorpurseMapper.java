package com.medical.mapper;

import com.medical.po.Doctorpurse;
import com.medical.po.DoctorpurseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorpurseMapper {
    int countByExample(DoctorpurseExample example);

    int deleteByExample(DoctorpurseExample example);

    int deleteByPrimaryKey(Integer docpurseid);

    int insert(Doctorpurse record);

    int insertSelective(Doctorpurse record);

    List<Doctorpurse> selectByExample(DoctorpurseExample example);

    Doctorpurse selectByPrimaryKey(Integer docpurseid);

    int updateByExampleSelective(@Param("record") Doctorpurse record, @Param("example") DoctorpurseExample example);

    int updateByExample(@Param("record") Doctorpurse record, @Param("example") DoctorpurseExample example);

    int updateByPrimaryKeySelective(Doctorpurse record);

    int updateByPrimaryKey(Doctorpurse record);
}