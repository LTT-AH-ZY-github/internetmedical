package com.medical.mapper;

import com.medical.po.Hosporder;
import com.medical.po.HosporderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HosporderMapper {
    int countByExample(HosporderExample example);

    int deleteByExample(HosporderExample example);

    int deleteByPrimaryKey(Integer hosporderid);

    int insert(Hosporder record);

    int insertSelective(Hosporder record);

    List<Hosporder> selectByExample(HosporderExample example);

    Hosporder selectByPrimaryKey(Integer hosporderid);

    int updateByExampleSelective(@Param("record") Hosporder record, @Param("example") HosporderExample example);

    int updateByExample(@Param("record") Hosporder record, @Param("example") HosporderExample example);

    int updateByPrimaryKeySelective(Hosporder record);

    int updateByPrimaryKey(Hosporder record);
}