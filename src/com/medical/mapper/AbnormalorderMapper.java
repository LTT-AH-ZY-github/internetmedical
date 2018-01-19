package com.medical.mapper;

import com.medical.po.Abnormalorder;
import com.medical.po.AbnormalorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbnormalorderMapper {
    int countByExample(AbnormalorderExample example);

    int deleteByExample(AbnormalorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Abnormalorder record);

    int insertSelective(Abnormalorder record);

    List<Abnormalorder> selectByExample(AbnormalorderExample example);

    Abnormalorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Abnormalorder record, @Param("example") AbnormalorderExample example);

    int updateByExample(@Param("record") Abnormalorder record, @Param("example") AbnormalorderExample example);

    int updateByPrimaryKeySelective(Abnormalorder record);

    int updateByPrimaryKey(Abnormalorder record);
}