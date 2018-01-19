package com.medical.mapper;

import com.medical.po.Adminrolemenu;
import com.medical.po.AdminrolemenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminrolemenuMapper {
    int countByExample(AdminrolemenuExample example);

    int deleteByExample(AdminrolemenuExample example);

    int deleteByPrimaryKey(Integer rolemenuid);

    int insert(Adminrolemenu record);

    int insertSelective(Adminrolemenu record);

    List<Adminrolemenu> selectByExample(AdminrolemenuExample example);

    Adminrolemenu selectByPrimaryKey(Integer rolemenuid);

    int updateByExampleSelective(@Param("record") Adminrolemenu record, @Param("example") AdminrolemenuExample example);

    int updateByExample(@Param("record") Adminrolemenu record, @Param("example") AdminrolemenuExample example);

    int updateByPrimaryKeySelective(Adminrolemenu record);

    int updateByPrimaryKey(Adminrolemenu record);
}