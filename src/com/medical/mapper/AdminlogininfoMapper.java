package com.medical.mapper;

import com.medical.po.Adminlogininfo;
import com.medical.po.AdminlogininfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminlogininfoMapper {
    int countByExample(AdminlogininfoExample example);

    int deleteByExample(AdminlogininfoExample example);

    int deleteByPrimaryKey(Integer adminloginid);

    int insert(Adminlogininfo record);

    int insertSelective(Adminlogininfo record);

    List<Adminlogininfo> selectByExample(AdminlogininfoExample example);

    Adminlogininfo selectByPrimaryKey(Integer adminloginid);

    int updateByExampleSelective(@Param("record") Adminlogininfo record, @Param("example") AdminlogininfoExample example);

    int updateByExample(@Param("record") Adminlogininfo record, @Param("example") AdminlogininfoExample example);

    int updateByPrimaryKeySelective(Adminlogininfo record);

    int updateByPrimaryKey(Adminlogininfo record);
}