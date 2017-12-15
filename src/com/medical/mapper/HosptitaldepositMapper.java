package com.medical.mapper;

import com.medical.po.Hosptitaldeposit;
import com.medical.po.HosptitaldepositExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HosptitaldepositMapper {
    int countByExample(HosptitaldepositExample example);

    int deleteByExample(HosptitaldepositExample example);

    int deleteByPrimaryKey(Integer hospdepositid);

    int insert(Hosptitaldeposit record);

    int insertSelective(Hosptitaldeposit record);

    List<Hosptitaldeposit> selectByExample(HosptitaldepositExample example);

    Hosptitaldeposit selectByPrimaryKey(Integer hospdepositid);

    int updateByExampleSelective(@Param("record") Hosptitaldeposit record, @Param("example") HosptitaldepositExample example);

    int updateByExample(@Param("record") Hosptitaldeposit record, @Param("example") HosptitaldepositExample example);

    int updateByPrimaryKeySelective(Hosptitaldeposit record);

    int updateByPrimaryKey(Hosptitaldeposit record);
}