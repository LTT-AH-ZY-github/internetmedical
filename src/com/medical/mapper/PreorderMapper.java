package com.medical.mapper;

import com.medical.po.Preorder;
import com.medical.po.PreorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PreorderMapper {
    int countByExample(PreorderExample example);

    int deleteByExample(PreorderExample example);

    int deleteByPrimaryKey(Integer preorderid);

    int insert(Preorder record);

    int insertSelective(Preorder record);

    List<Preorder> selectByExample(PreorderExample example);

    Preorder selectByPrimaryKey(Integer preorderid);

    int updateByExampleSelective(@Param("record") Preorder record, @Param("example") PreorderExample example);

    int updateByExample(@Param("record") Preorder record, @Param("example") PreorderExample example);

    int updateByPrimaryKeySelective(Preorder record);

    int updateByPrimaryKey(Preorder record);
}