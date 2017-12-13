package com.medical.mapper;

import com.medical.po.Hospitalpackage;
import com.medical.po.HospitalpackageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HospitalpackageMapper {
    int countByExample(HospitalpackageExample example);

    int deleteByExample(HospitalpackageExample example);

    int deleteByPrimaryKey(Integer packageid);

    int insert(Hospitalpackage record);

    int insertSelective(Hospitalpackage record);

    List<Hospitalpackage> selectByExample(HospitalpackageExample example);

    Hospitalpackage selectByPrimaryKey(Integer packageid);

    int updateByExampleSelective(@Param("record") Hospitalpackage record, @Param("example") HospitalpackageExample example);

    int updateByExample(@Param("record") Hospitalpackage record, @Param("example") HospitalpackageExample example);

    int updateByPrimaryKeySelective(Hospitalpackage record);

    int updateByPrimaryKey(Hospitalpackage record);
}