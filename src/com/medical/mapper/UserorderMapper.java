package com.medical.mapper;

import com.medical.po.Userorder;
import com.medical.po.UserorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserorderMapper {
    int countByExample(UserorderExample example);

    int deleteByExample(UserorderExample example);

    int deleteByPrimaryKey(Integer userorderid);

    int insert(Userorder record);

    int insertSelective(Userorder record);

    List<Userorder> selectByExample(UserorderExample example);

    Userorder selectByPrimaryKey(Integer userorderid);

    int updateByExampleSelective(@Param("record") Userorder record, @Param("example") UserorderExample example);

    int updateByExample(@Param("record") Userorder record, @Param("example") UserorderExample example);

    int updateByPrimaryKeySelective(Userorder record);

    int updateByPrimaryKey(Userorder record);
}