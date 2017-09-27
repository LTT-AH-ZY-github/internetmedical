package com.medical.mapper;

import com.medical.po.Adminlog;
import com.medical.po.AdminlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminlogMapper {
    int countByExample(AdminlogExample example);

    int deleteByExample(AdminlogExample example);

    int deleteByPrimaryKey(Integer adminlogid);

    int insert(Adminlog record);

    int insertSelective(Adminlog record);

    List<Adminlog> selectByExample(AdminlogExample example);

    Adminlog selectByPrimaryKey(Integer adminlogid);

    int updateByExampleSelective(@Param("record") Adminlog record, @Param("example") AdminlogExample example);

    int updateByExample(@Param("record") Adminlog record, @Param("example") AdminlogExample example);

    int updateByPrimaryKeySelective(Adminlog record);

    int updateByPrimaryKey(Adminlog record);
}