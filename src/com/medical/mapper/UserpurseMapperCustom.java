package com.medical.mapper;

import com.medical.po.Userpurse;
import com.medical.po.UserpurseExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserpurseMapperCustom {
    

    List<Map<String, Object>> selectByUserLoginId(Integer userloginid);

}