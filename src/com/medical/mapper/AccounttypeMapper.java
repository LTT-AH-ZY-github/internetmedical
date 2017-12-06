package com.medical.mapper;

import com.medical.po.Accounttype;
import com.medical.po.AccounttypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccounttypeMapper {
    int countByExample(AccounttypeExample example);

    int deleteByExample(AccounttypeExample example);

    int deleteByPrimaryKey(Integer accounttypeid);

    int insert(Accounttype record);

    int insertSelective(Accounttype record);

    List<Accounttype> selectByExample(AccounttypeExample example);

    Accounttype selectByPrimaryKey(Integer accounttypeid);

    int updateByExampleSelective(@Param("record") Accounttype record, @Param("example") AccounttypeExample example);

    int updateByExample(@Param("record") Accounttype record, @Param("example") AccounttypeExample example);

    int updateByPrimaryKeySelective(Accounttype record);

    int updateByPrimaryKey(Accounttype record);
}