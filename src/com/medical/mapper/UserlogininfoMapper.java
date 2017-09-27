package com.medical.mapper;

import com.medical.po.Userlogininfo;
import com.medical.po.UserlogininfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserlogininfoMapper {
    int countByExample(UserlogininfoExample example);

    int deleteByExample(UserlogininfoExample example);

    int deleteByPrimaryKey(Integer userloginid);

    int insert(Userlogininfo record);

    int insertSelective(Userlogininfo record);

    List<Userlogininfo> selectByExample(UserlogininfoExample example);

    Userlogininfo selectByPrimaryKey(Integer userloginid);

    int updateByExampleSelective(@Param("record") Userlogininfo record, @Param("example") UserlogininfoExample example);

    int updateByExample(@Param("record") Userlogininfo record, @Param("example") UserlogininfoExample example);

    int updateByPrimaryKeySelective(Userlogininfo record);

    int updateByPrimaryKey(Userlogininfo record);
}