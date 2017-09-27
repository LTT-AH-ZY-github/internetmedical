package com.medical.mapper;

import com.medical.po.Doctortitle;
import com.medical.po.DoctortitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctortitleMapper {
    int countByExample(DoctortitleExample example);

    int deleteByExample(DoctortitleExample example);

    int deleteByPrimaryKey(Integer doctitleid);

    int insert(Doctortitle record);

    int insertSelective(Doctortitle record);

    List<Doctortitle> selectByExample(DoctortitleExample example);

    Doctortitle selectByPrimaryKey(Integer doctitleid);

    int updateByExampleSelective(@Param("record") Doctortitle record, @Param("example") DoctortitleExample example);

    int updateByExample(@Param("record") Doctortitle record, @Param("example") DoctortitleExample example);

    int updateByPrimaryKeySelective(Doctortitle record);

    int updateByPrimaryKey(Doctortitle record);
}