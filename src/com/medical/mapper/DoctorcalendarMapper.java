package com.medical.mapper;

import com.medical.po.Doctorcalendar;
import com.medical.po.DoctorcalendarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctorcalendarMapper {
    int countByExample(DoctorcalendarExample example);

    int deleteByExample(DoctorcalendarExample example);

    int deleteByPrimaryKey(Integer doccalendarid);

    int insert(Doctorcalendar record);

    int insertSelective(Doctorcalendar record);

    List<Doctorcalendar> selectByExample(DoctorcalendarExample example);

    Doctorcalendar selectByPrimaryKey(Integer doccalendarid);

    int updateByExampleSelective(@Param("record") Doctorcalendar record, @Param("example") DoctorcalendarExample example);

    int updateByExample(@Param("record") Doctorcalendar record, @Param("example") DoctorcalendarExample example);

    int updateByPrimaryKeySelective(Doctorcalendar record);

    int updateByPrimaryKey(Doctorcalendar record);
}