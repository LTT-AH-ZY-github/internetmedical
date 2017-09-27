package com.medical.mapper;

import com.medical.po.Doctorskd;
import com.medical.po.DoctorskdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorskdMapper {
    int countByExample(DoctorskdExample example);

    int deleteByExample(DoctorskdExample example);

    int deleteByPrimaryKey(Integer docskdid);

    int insert(Doctorskd record);

    int insertSelective(Doctorskd record);

    List<Doctorskd> selectByExample(DoctorskdExample example);

    Doctorskd selectByPrimaryKey(Integer docskdid);

    int updateByExampleSelective(@Param("record") Doctorskd record, @Param("example") DoctorskdExample example);

    int updateByExample(@Param("record") Doctorskd record, @Param("example") DoctorskdExample example);

    int updateByPrimaryKeySelective(Doctorskd record);

    int updateByPrimaryKey(Doctorskd record);
}