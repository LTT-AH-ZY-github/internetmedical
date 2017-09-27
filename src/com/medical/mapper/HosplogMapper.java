package com.medical.mapper;

import com.medical.po.Hosplog;
import com.medical.po.HosplogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HosplogMapper {
    int countByExample(HosplogExample example);

    int deleteByExample(HosplogExample example);

    int deleteByPrimaryKey(Integer hosplogid);

    int insert(Hosplog record);

    int insertSelective(Hosplog record);

    List<Hosplog> selectByExample(HosplogExample example);

    Hosplog selectByPrimaryKey(Integer hosplogid);

    int updateByExampleSelective(@Param("record") Hosplog record, @Param("example") HosplogExample example);

    int updateByExample(@Param("record") Hosplog record, @Param("example") HosplogExample example);

    int updateByPrimaryKeySelective(Hosplog record);

    int updateByPrimaryKey(Hosplog record);
}