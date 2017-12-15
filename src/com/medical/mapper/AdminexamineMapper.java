package com.medical.mapper;

import com.medical.po.Adminexamine;
import com.medical.po.AdminexamineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminexamineMapper {
    int countByExample(AdminexamineExample example);

    int deleteByExample(AdminexamineExample example);

    int deleteByPrimaryKey(Integer examineid);

    int insert(Adminexamine record);

    int insertSelective(Adminexamine record);

    List<Adminexamine> selectByExample(AdminexamineExample example);

    Adminexamine selectByPrimaryKey(Integer examineid);

    int updateByExampleSelective(@Param("record") Adminexamine record, @Param("example") AdminexamineExample example);

    int updateByExample(@Param("record") Adminexamine record, @Param("example") AdminexamineExample example);

    int updateByPrimaryKeySelective(Adminexamine record);

    int updateByPrimaryKey(Adminexamine record);
}