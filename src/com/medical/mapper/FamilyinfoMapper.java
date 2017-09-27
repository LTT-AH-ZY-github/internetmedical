package com.medical.mapper;

import com.medical.po.Familyinfo;
import com.medical.po.FamilyinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FamilyinfoMapper {
    int countByExample(FamilyinfoExample example);

    int deleteByExample(FamilyinfoExample example);

    int deleteByPrimaryKey(Integer familyid);

    int insert(Familyinfo record);

    int insertSelective(Familyinfo record);

    List<Familyinfo> selectByExample(FamilyinfoExample example);

    Familyinfo selectByPrimaryKey(Integer familyid);

    int updateByExampleSelective(@Param("record") Familyinfo record, @Param("example") FamilyinfoExample example);

    int updateByExample(@Param("record") Familyinfo record, @Param("example") FamilyinfoExample example);

    int updateByPrimaryKeySelective(Familyinfo record);

    int updateByPrimaryKey(Familyinfo record);
}