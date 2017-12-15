package com.medical.mapper;

import com.medical.po.Deletefile;
import com.medical.po.DeletefileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeletefileMapper {
    int countByExample(DeletefileExample example);

    int deleteByExample(DeletefileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Deletefile record);

    int insertSelective(Deletefile record);

    List<Deletefile> selectByExample(DeletefileExample example);

    Deletefile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Deletefile record, @Param("example") DeletefileExample example);

    int updateByExample(@Param("record") Deletefile record, @Param("example") DeletefileExample example);

    int updateByPrimaryKeySelective(Deletefile record);

    int updateByPrimaryKey(Deletefile record);
}