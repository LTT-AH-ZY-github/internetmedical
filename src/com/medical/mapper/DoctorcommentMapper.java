package com.medical.mapper;

import com.medical.po.Doctorcomment;
import com.medical.po.DoctorcommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorcommentMapper {
    int countByExample(DoctorcommentExample example);

    int deleteByExample(DoctorcommentExample example);

    int deleteByPrimaryKey(Integer doccommentid);

    int insert(Doctorcomment record);

    int insertSelective(Doctorcomment record);

    List<Doctorcomment> selectByExample(DoctorcommentExample example);

    Doctorcomment selectByPrimaryKey(Integer doccommentid);

    int updateByExampleSelective(@Param("record") Doctorcomment record, @Param("example") DoctorcommentExample example);

    int updateByExample(@Param("record") Doctorcomment record, @Param("example") DoctorcommentExample example);

    int updateByPrimaryKeySelective(Doctorcomment record);

    int updateByPrimaryKey(Doctorcomment record);
}