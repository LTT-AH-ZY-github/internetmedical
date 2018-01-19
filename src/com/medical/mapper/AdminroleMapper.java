package com.medical.mapper;

import com.medical.po.Adminrole;
import com.medical.po.AdminroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminroleMapper {
    int countByExample(AdminroleExample example);

    int deleteByExample(AdminroleExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(Adminrole record);

    int insertSelective(Adminrole record);

    List<Adminrole> selectByExample(AdminroleExample example);

    Adminrole selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") Adminrole record, @Param("example") AdminroleExample example);

    int updateByExample(@Param("record") Adminrole record, @Param("example") AdminroleExample example);

    int updateByPrimaryKeySelective(Adminrole record);

    int updateByPrimaryKey(Adminrole record);
}