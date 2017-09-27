package com.medical.mapper;

import com.medical.po.Hosplogininfo;
import com.medical.po.HosplogininfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HosplogininfoMapper {
    int countByExample(HosplogininfoExample example);

    int deleteByExample(HosplogininfoExample example);

    int deleteByPrimaryKey(Integer hosploginid);

    int insert(Hosplogininfo record);

    int insertSelective(Hosplogininfo record);

    List<Hosplogininfo> selectByExample(HosplogininfoExample example);

    Hosplogininfo selectByPrimaryKey(Integer hosploginid);

    int updateByExampleSelective(@Param("record") Hosplogininfo record, @Param("example") HosplogininfoExample example);

    int updateByExample(@Param("record") Hosplogininfo record, @Param("example") HosplogininfoExample example);

    int updateByPrimaryKeySelective(Hosplogininfo record);

    int updateByPrimaryKey(Hosplogininfo record);
}