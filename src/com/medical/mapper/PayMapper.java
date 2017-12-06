package com.medical.mapper;

import com.medical.po.Pay;
import com.medical.po.PayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayMapper {
    int countByExample(PayExample example);

    int deleteByExample(PayExample example);

    int deleteByPrimaryKey(Integer payid);

    int insert(Pay record);

    int insertSelective(Pay record);

    List<Pay> selectByExampleWithBLOBs(PayExample example);

    List<Pay> selectByExample(PayExample example);

    Pay selectByPrimaryKey(Integer payid);

    int updateByExampleSelective(@Param("record") Pay record, @Param("example") PayExample example);

    int updateByExampleWithBLOBs(@Param("record") Pay record, @Param("example") PayExample example);

    int updateByExample(@Param("record") Pay record, @Param("example") PayExample example);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKeyWithBLOBs(Pay record);

    int updateByPrimaryKey(Pay record);
}