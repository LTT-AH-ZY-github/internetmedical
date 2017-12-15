package com.medical.mapper;

import com.medical.po.Adminexaminedept;
import com.medical.po.AdminexaminedeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminexaminedeptMapper {
    int countByExample(AdminexaminedeptExample example);

    int deleteByExample(AdminexaminedeptExample example);

    int deleteByPrimaryKey(Integer examineid);

    int insert(Adminexaminedept record);

    int insertSelective(Adminexaminedept record);

    List<Adminexaminedept> selectByExample(AdminexaminedeptExample example);

    Adminexaminedept selectByPrimaryKey(Integer examineid);

    int updateByExampleSelective(@Param("record") Adminexaminedept record, @Param("example") AdminexaminedeptExample example);

    int updateByExample(@Param("record") Adminexaminedept record, @Param("example") AdminexaminedeptExample example);

    int updateByPrimaryKeySelective(Adminexaminedept record);

    int updateByPrimaryKey(Adminexaminedept record);
}