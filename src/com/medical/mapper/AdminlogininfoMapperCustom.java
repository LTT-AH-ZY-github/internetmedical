package com.medical.mapper;

import java.util.List;
import java.util.Map;

import com.medical.po.Adminlogininfo;


public interface AdminlogininfoMapperCustom {
    
    Adminlogininfo selectByAdminLoginName(String adminloginname);
    List<Adminlogininfo>  selectByParams(Map<String, Object> map);
}