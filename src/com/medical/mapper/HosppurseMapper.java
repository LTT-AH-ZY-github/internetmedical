package com.medical.mapper;

import com.medical.po.Hosppurse;
import com.medical.po.HosppurseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HosppurseMapper {
    int countByExample(HosppurseExample example);

    int deleteByExample(HosppurseExample example);

    int deleteByPrimaryKey(Integer hosppurseid);

    int insert(Hosppurse record);

    int insertSelective(Hosppurse record);

    List<Hosppurse> selectByExample(HosppurseExample example);

    Hosppurse selectByPrimaryKey(Integer hosppurseid);

    int updateByExampleSelective(@Param("record") Hosppurse record, @Param("example") HosppurseExample example);

    int updateByExample(@Param("record") Hosppurse record, @Param("example") HosppurseExample example);

    int updateByPrimaryKeySelective(Hosppurse record);

    int updateByPrimaryKey(Hosppurse record);
}