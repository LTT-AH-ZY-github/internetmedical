package com.medical.mapper;

import com.medical.po.Hospitalberth;
import com.medical.po.HospitalberthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HospitalberthMapper {
    int countByExample(HospitalberthExample example);

    int deleteByExample(HospitalberthExample example);

    int deleteByPrimaryKey(Integer hospberthid);

    int insert(Hospitalberth record);

    int insertSelective(Hospitalberth record);

    List<Hospitalberth> selectByExample(HospitalberthExample example);

    Hospitalberth selectByPrimaryKey(Integer hospberthid);

    int updateByExampleSelective(@Param("record") Hospitalberth record, @Param("example") HospitalberthExample example);

    int updateByExample(@Param("record") Hospitalberth record, @Param("example") HospitalberthExample example);

    int updateByPrimaryKeySelective(Hospitalberth record);

    int updateByPrimaryKey(Hospitalberth record);
}