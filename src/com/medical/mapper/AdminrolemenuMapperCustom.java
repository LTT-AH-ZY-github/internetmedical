package com.medical.mapper;

import com.medical.po.Adminrolemenu;
import com.medical.po.AdminrolemenuExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdminrolemenuMapperCustom {
    
    List<Adminrolemenu> selectByParams(Map<String, Object> map);
    List<Map<String, Object>>selectAllInfoByParams(Map<String, Object> map);
}