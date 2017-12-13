package com.medical.mapper;

import com.medical.po.Adminlogininfo;


public interface AdminlogininfoMapperCustom {
    
    Adminlogininfo selectByAdminLoginName(String adminloginname);

}