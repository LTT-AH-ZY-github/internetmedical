package com.medical.mapper;

import com.medical.po.Preorder;
import com.medical.po.PreorderExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PreorderMapperCustom {
   

    int deleteByUserSickId(int userSickId);
    //List<Map<String, Object>> selectByUserSickId(Map<String, Object> params);
    List<Preorder> selectByDocIdAndSickId(Integer docId,Integer sickId);
    List<Preorder> selectByDocLoginIdAndUserSickId(Integer docloginid, Integer usersickid, Integer preOrderType);
    List<Preorder>  selectByDocLoginIdAndPreOrderType(Integer docloginid, Integer preOrderType);
    
	Map<String, Object> selectAllInfoByPreOrderId(Integer preorderid);
	
	//获取医生已抢订单
	List<Map<String, Object>>  listByDocLoginId(Integer docloginid);
	//获取已抢订单详情
	Map<String, Object> selectAllInfoByPreOrderIdInDoc(Integer preorderid);
	List<Map<String, Object>> selectByUserSickId(Integer userSickId, Integer preordertype);
	int deleteByDocLoginIdAndUserSickId(Integer docloginid, Integer usersickid);
	int deleteByDocLoginIdAndPreOrderType(Integer docloginid, Integer preOrderType);
	int deleteAllByUserSickId(Integer usersickid);
	/**
	 * 根据病情和类型删除相关医生
	 * 
	 * */
	int deleteByUserSickIdAndPreOrderType(Integer usersickid, Integer preordertype);
}