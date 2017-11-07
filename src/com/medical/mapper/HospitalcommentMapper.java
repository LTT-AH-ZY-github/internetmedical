package com.medical.mapper;

import com.medical.po.Hospitalcomment;
import com.medical.po.HospitalcommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HospitalcommentMapper {
    int countByExample(HospitalcommentExample example);

    int deleteByExample(HospitalcommentExample example);

    int deleteByPrimaryKey(Integer hospcommentid);

    int insert(Hospitalcomment record);

    int insertSelective(Hospitalcomment record);

    List<Hospitalcomment> selectByExample(HospitalcommentExample example);

    Hospitalcomment selectByPrimaryKey(Integer hospcommentid);

    int updateByExampleSelective(@Param("record") Hospitalcomment record, @Param("example") HospitalcommentExample example);

    int updateByExample(@Param("record") Hospitalcomment record, @Param("example") HospitalcommentExample example);

    int updateByPrimaryKeySelective(Hospitalcomment record);

    int updateByPrimaryKey(Hospitalcomment record);
}