package com.medical.mapper;

import com.medical.po.Adminexamine;
import com.medical.po.AdminexamineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminexamineMapperCustom {
    

    List<Adminexamine> selectByExamineTargetIdAndTypeOrderByTime(Integer examinetargetid,Integer type);

   
}