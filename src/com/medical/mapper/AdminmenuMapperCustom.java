package com.medical.mapper;

import com.medical.po.Adminmenu;
import com.medical.po.AdminmenuExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdminmenuMapperCustom {
    

    List<Adminmenu> selectByParams(Map<String, Object> map);

    
}