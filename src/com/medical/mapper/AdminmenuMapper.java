package com.medical.mapper;

import com.medical.po.Adminmenu;
import com.medical.po.AdminmenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminmenuMapper {
    int countByExample(AdminmenuExample example);

    int deleteByExample(AdminmenuExample example);

    int deleteByPrimaryKey(Integer menuid);

    int insert(Adminmenu record);

    int insertSelective(Adminmenu record);

    List<Adminmenu> selectByExample(AdminmenuExample example);

    Adminmenu selectByPrimaryKey(Integer menuid);

    int updateByExampleSelective(@Param("record") Adminmenu record, @Param("example") AdminmenuExample example);

    int updateByExample(@Param("record") Adminmenu record, @Param("example") AdminmenuExample example);

    int updateByPrimaryKeySelective(Adminmenu record);

    int updateByPrimaryKey(Adminmenu record);
}