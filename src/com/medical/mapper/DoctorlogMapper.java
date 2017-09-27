package com.medical.mapper;

import com.medical.po.Doctorlog;
import com.medical.po.DoctorlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorlogMapper {
    int countByExample(DoctorlogExample example);

    int deleteByExample(DoctorlogExample example);

    int deleteByPrimaryKey(Integer doclogid);

    int insert(Doctorlog record);

    int insertSelective(Doctorlog record);

    List<Doctorlog> selectByExample(DoctorlogExample example);

    Doctorlog selectByPrimaryKey(Integer doclogid);

    int updateByExampleSelective(@Param("record") Doctorlog record, @Param("example") DoctorlogExample example);

    int updateByExample(@Param("record") Doctorlog record, @Param("example") DoctorlogExample example);

    int updateByPrimaryKeySelective(Doctorlog record);

    int updateByPrimaryKey(Doctorlog record);
}