package com.medical.mapper;

import com.medical.po.Doctortitle;
import com.medical.po.DoctortitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoctortitleMapperCustom {
    

    List<Doctortitle> selectAll();

}