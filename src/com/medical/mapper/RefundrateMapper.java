package com.medical.mapper;

import com.medical.po.Refundrate;
import com.medical.po.RefundrateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundrateMapper {
    int countByExample(RefundrateExample example);

    int deleteByExample(RefundrateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Refundrate record);

    int insertSelective(Refundrate record);

    List<Refundrate> selectByExample(RefundrateExample example);

    Refundrate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Refundrate record, @Param("example") RefundrateExample example);

    int updateByExample(@Param("record") Refundrate record, @Param("example") RefundrateExample example);

    int updateByPrimaryKeySelective(Refundrate record);

    int updateByPrimaryKey(Refundrate record);
}