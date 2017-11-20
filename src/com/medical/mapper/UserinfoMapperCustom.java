package com.medical.mapper;


import java.util.List;
import java.util.Map;

import com.medical.po.Userinfo;


public interface UserinfoMapperCustom {
	
	// 根据外键查询用户信息表
    Map<String,Object>  findUserInfoByLoginId(int userloginid);
    Userinfo selectByLoginId(int userloginid) throws Exception;
    /**
     *管理员根据用户账号类型查询用户  
     * */
    List<Map<String, Object>> selectByUserLoginType(Integer userlogintype);
    /**
     *管理员根据用户id查询用户详细
     * */
    Map<String,Object>  selectInfoByLoginId(Integer userloginid) ;
}