package com.medical.mapper;

import com.medical.po.Userorder;
import com.medical.po.UserorderExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserorderMapperCustom {
    

    int insertSelectiveReturnId(Userorder record);

    List<Map<String, Object>> selectByUserLoginId(int id);
    Map<String, Object>  selectAllInfoByUserOrderId(int id);
    Map<String, Object>  selectByDocLoginId(Integer id);
    //医生查询所有订单
    Map<String, Object> selectAllByDocLoginIdAndOrderType(Integer docLoginId, Integer type);
    Map<String, Object> selectAllInfoByUserLoginIdAndStateId(Integer docLoginId, Integer type);
    //查询病人正在进行中的订单
    List<Map<String, Object>> selectAllInfoByUserLoginId(Integer userloginid, Integer type);
    //查询医生所有订单
    List<Map<String, Object>> listByDocLoginId(Integer docLoginId, Integer type);
    //获取医生订单详情
    Map<String, Object> selectAllInfoByUserOrderIdInDoc(Integer docLoginId,Integer userOrderId);
}