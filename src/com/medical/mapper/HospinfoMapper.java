package com.medical.mapper;

import com.medical.po.Hospinfo;
import com.medical.po.HospinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HospinfoMapper {
    int countByExample(HospinfoExample example);

    int deleteByExample(HospinfoExample example);

    int deleteByPrimaryKey(Integer hospid);

    int insert(Hospinfo record);

    int insertSelective(Hospinfo record);

    List<Hospinfo> selectByExample(HospinfoExample example);

    Hospinfo selectByPrimaryKey(Integer hospid);

    int updateByExampleSelective(@Param("record") Hospinfo record, @Param("example") HospinfoExample example);

    int updateByExample(@Param("record") Hospinfo record, @Param("example") HospinfoExample example);

    int updateByPrimaryKeySelective(Hospinfo record);

    int updateByPrimaryKey(Hospinfo record);
}