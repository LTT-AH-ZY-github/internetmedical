package com.medical.mapper;

import com.medical.po.Doctoraddress;
import java.util.List;


public interface DoctoraddressMapperCustom {
   
	/**
     * @Title: selectByDocloginid
     * @Description: 医生端根据医生登录id获取其所有地址
     * @param docloginid 医生登录id
     * @return
     * @return: List<Doctoraddress>
     */
    List<Doctoraddress> selectByDocloginid(Integer docloginid);
    
    /**
     * @Title: selectByDocloginidAndType
     * @Description: 根据医生登录id及地址是否为医院所在地址查询
     * @param docloginid
     * @param type
     * @return
     * @return: List<Doctoraddress>
     */
    List<Doctoraddress> selectByDocloginidAndType(Integer docloginid,Integer type);
   
    /**
     * @Title: updateCheckedByDocLoginId
     * @Description: 根据医生登录id更新所有地址的选中状态
     * @param docloginid
     * @param checked
     * @return
     * @return: int
     */
    int updateCheckedByDocLoginId(Integer docloginid,Integer checked);
   
}