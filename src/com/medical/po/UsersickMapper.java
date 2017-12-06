package com.medical.po;

import com.medical.po.Usersick;
import com.medical.po.UsersickExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersickMapper {
    int countByExample(UsersickExample example);

    int deleteByExample(UsersickExample example);

    int deleteByPrimaryKey(Integer usersickid);

    int insert(Usersick record);

    int insertSelective(Usersick record);

    List<Usersick> selectByExample(UsersickExample example);

    Usersick selectByPrimaryKey(Integer usersickid);

    int updateByExampleSelective(@Param("record") Usersick record, @Param("example") UsersickExample example);

    int updateByExample(@Param("record") Usersick record, @Param("example") UsersickExample example);

    int updateByPrimaryKeySelective(Usersick record);

    int updateByPrimaryKey(Usersick record);
}