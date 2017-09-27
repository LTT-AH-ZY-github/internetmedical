package com.medical.mapper;

import com.medical.po.Hospitaldept;
import com.medical.po.HospitaldeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HospitaldeptMapper {
    int countByExample(HospitaldeptExample example);

    int deleteByExample(HospitaldeptExample example);

    int deleteByPrimaryKey(Integer hospdeptid);

    int insert(Hospitaldept record);

    int insertSelective(Hospitaldept record);

    List<Hospitaldept> selectByExample(HospitaldeptExample example);

    Hospitaldept selectByPrimaryKey(Integer hospdeptid);

    int updateByExampleSelective(@Param("record") Hospitaldept record, @Param("example") HospitaldeptExample example);

    int updateByExample(@Param("record") Hospitaldept record, @Param("example") HospitaldeptExample example);

    int updateByPrimaryKeySelective(Hospitaldept record);

    int updateByPrimaryKey(Hospitaldept record);
}