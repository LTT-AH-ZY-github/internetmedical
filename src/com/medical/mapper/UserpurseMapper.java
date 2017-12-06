package com.medical.mapper;

import com.medical.po.Userpurse;
import com.medical.po.UserpurseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserpurseMapper {
    int countByExample(UserpurseExample example);

    int deleteByExample(UserpurseExample example);

    int deleteByPrimaryKey(Integer userpurseid);

    int insert(Userpurse record);

    int insertSelective(Userpurse record);

    List<Userpurse> selectByExample(UserpurseExample example);

    Userpurse selectByPrimaryKey(Integer userpurseid);

    int updateByExampleSelective(@Param("record") Userpurse record, @Param("example") UserpurseExample example);

    int updateByExample(@Param("record") Userpurse record, @Param("example") UserpurseExample example);

    int updateByPrimaryKeySelective(Userpurse record);

    int updateByPrimaryKey(Userpurse record);
}