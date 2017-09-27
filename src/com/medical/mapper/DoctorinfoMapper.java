package com.medical.mapper;

import com.medical.po.Doctorinfo;
import com.medical.po.DoctorinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorinfoMapper {
    int countByExample(DoctorinfoExample example);

    int deleteByExample(DoctorinfoExample example);

    int deleteByPrimaryKey(Integer docid);

    int insert(Doctorinfo record);

    int insertSelective(Doctorinfo record);

    List<Doctorinfo> selectByExample(DoctorinfoExample example);

    Doctorinfo selectByPrimaryKey(Integer docid);

    int updateByExampleSelective(@Param("record") Doctorinfo record, @Param("example") DoctorinfoExample example);

    int updateByExample(@Param("record") Doctorinfo record, @Param("example") DoctorinfoExample example);

    int updateByPrimaryKeySelective(Doctorinfo record);

    int updateByPrimaryKey(Doctorinfo record);
}