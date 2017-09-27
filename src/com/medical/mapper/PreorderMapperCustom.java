package com.medical.mapper;

import com.medical.po.Preorder;
import com.medical.po.PreorderExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PreorderMapperCustom {
   

    int deleteByUserSickId(int userSickId);
    List<Map<String, Object>> selectByUserSickId(Map<String, Object> params);
    List<Preorder> selectByDocIdAndSickId(int docId,int sickId);
    List<Preorder> selectByDocLoginIdAndUserSickId(Integer docloginid, Integer usersickid, Integer preOrderType);
    List<Preorder>  selectByDocLoginIdAndPreOrderType(Integer docloginid, Integer preOrderType);
    
	Map<String, Object> selectAllInfoByPreOrderId(Integer preorderid);
	List<Map<String, Object>>  selectAllInfoByDocLoginId(Integer docloginid);
}