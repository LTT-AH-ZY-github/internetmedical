package com.medical.mapper;

import com.medical.po.Hospitalunitprice;
import com.medical.po.HospitalunitpriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HospitalunitpriceMapper {
    int countByExample(HospitalunitpriceExample example);

    int deleteByExample(HospitalunitpriceExample example);

    int deleteByPrimaryKey(Integer unitpriceid);

    int insert(Hospitalunitprice record);

    int insertSelective(Hospitalunitprice record);

    List<Hospitalunitprice> selectByExample(HospitalunitpriceExample example);

    Hospitalunitprice selectByPrimaryKey(Integer unitpriceid);

    int updateByExampleSelective(@Param("record") Hospitalunitprice record, @Param("example") HospitalunitpriceExample example);

    int updateByExample(@Param("record") Hospitalunitprice record, @Param("example") HospitalunitpriceExample example);

    int updateByPrimaryKeySelective(Hospitalunitprice record);

    int updateByPrimaryKey(Hospitalunitprice record);
}