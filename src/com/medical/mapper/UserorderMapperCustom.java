package com.medical.mapper;

import com.medical.po.Userorder;
import com.medical.po.UserorderExample;
import com.medical.po.custom.user.order.UserOrderListInUser;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserorderMapperCustom {
    

    int insertSelectiveReturnId(Userorder record);
    
    //
    //Map<String, Object> selectAllInfoByUserLoginIdAndStateId(Integer userLoginId, Integer type);
    
    /**
     * @Title: selectAllInfoByUserLoginId
     * @Description: 用户查询不同状态订单
     * @param userloginid 
     * @param type
     * @return
     * @return: List<Map<String,Object>>
     */
    List<Map<String, Object>> selectAllInfoByUserLoginId(Integer userloginid, Integer type);

    //用户查询订单详情
    Map<String, Object>  selectAllInfoByUserLoginIdAndUserOrderId(Integer userloginid,Integer userorderid);
   
    //医生查找不同状态订单
    List<Map<String, Object>> listByDocLoginId(Integer docLoginId, Integer type);
    
    //获取医生订单详情
    Map<String, Object> selectAllInfoByUserOrderIdInDoc(Integer docloginid,Integer userOrderId);
    
   // Map<String, Object>  selectByDocLoginId(Integer id);
    //医生查询所有订单
   /* Map<String, Object> selectAllByDocLoginIdAndOrderType(Integer docLoginId, Integer type);*/
    
    
   
    
    //根据医生登录id和订单id查找订单
    Userorder selectByDocLoginIdAndUserOrderId(Integer docLoginId,Integer userOrderId);
    
    //根据病人登录id和订单id查找订单
    Userorder selectByUserLoginIdAndUserOrderId(Integer userLoginId,Integer userOrderId);
   
    //医院查找不同状态订单
	List<Map<String, Object>> listByHospLoginIdAnType(Integer hosploginid, Integer type);
	/**
	 * 医生查找处于等待自己确认的订单
	 * @param
	 * @return
	 * 
	 * */
	List<Map<String, Object>> listOrderToConfirmByDocLoginId(Integer docloginid);
	/**
	 * 医生查找不同状态的订单
	 * @param
	 * @return
	 * 
	 * */
	List<Map<String, Object>> listByDocLoginIdAndState(Integer docLoginId, Integer type);
	/**
	 * 医生获取订单详情
	 * @param
	 * @return
	 * 
	 * */
	Map<String, Object>  selectAllInfoByUserOrderId(Integer docloginid,Integer userOrderId);
	/**
	 * 医生获取历史订单
	 * @param
	 * @return
	 * 
	 * */
	List<Map<String, Object>> listHistortOrderByDocLoginId(Integer docloginid);
	
	/**
	 * @Title: listOrderToFundInAdmin
	 * @Description: 管理员获取需要退款的订单
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	List<Map<String, Object>> listOrderToFundInAdmin();
	
	List<Map<String, Object>>  listDoctorOrderToReFundInAdmin(Map<String, Integer> map);

}