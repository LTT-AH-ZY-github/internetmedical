package com.medical.mapper;

import com.medical.po.Hosplevel;
import com.medical.po.HosplevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HosplevelMapper {
    int countByExample(HosplevelExample example);

    int deleteByExample(HosplevelExample example);

    int deleteByPrimaryKey(Integer hosplevelid);

    int insert(Hosplevel record);

    int insertSelective(Hosplevel record);

    List<Hosplevel> selectByExample(HosplevelExample example);

    Hosplevel selectByPrimaryKey(Integer hosplevelid);

    int updateByExampleSelective(@Param("record") Hosplevel record, @Param("example") HosplevelExample example);

    int updateByExample(@Param("record") Hosplevel record, @Param("example") HosplevelExample example);

    int updateByPrimaryKeySelective(Hosplevel record);

    int updateByPrimaryKey(Hosplevel record);
}