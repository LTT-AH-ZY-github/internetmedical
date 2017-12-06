package com.medical.mapper;


import java.util.List;
import java.util.Map;

import com.medical.po.Userinfo;


public interface UserinfoMapperCustom {
	
	// 根据外键查询用户信息表
    Map<String,Object>  findUserInfoByLoginId(int userloginid);
    Userinfo selectByLoginId(int userloginid) throws Exception;
    
    /**
     * @Title: selectByUserLoginType
     * @Description: 管理员根据用户账号类型查询用户  
     * @param userlogintype
     * @return
     * @return: List<Map<String,Object>>
     */
    List<Map<String, Object>> selectByUserLoginTypeInAdmin(Integer userlogintype,Integer key);
    
    /**
     * @Title: selectInfoByLoginId
     * @Description: 管理员根据用户id查询用户详细
     * @param userloginid
     * @return
     * @return: Map<String,Object>
     */
    Map<String,Object>  selectInfoByLoginIdInAdmin(Integer userloginid) ;
}