package com.medical.mapper;

import com.medical.po.DoctorSearch;
import com.medical.po.SickSearch;
import com.medical.po.Usersick;
import com.medical.po.UsersickExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UsersickMapperCustom {
   
	  int selectCountByFamilyId(Integer familyid);
	//查询病情及所有相关信息
    List<Map<String, Object>> selectAllInfoByUserLoginId(Integer id, Integer type);
    //根据登录id及病情状态查询用户的所有病情
    List<Usersick> selectByUserLoginIdAndState(Integer userloginid,Integer usersickstateid);
    Usersick selectByPhone(String phone);
    Map<String, Object> selectById(Integer id);
    int insertSelectiveReturnId(Usersick record);
    List<Map<String, Object>> selectAll(SickSearch sickSearch);
    List<Map<String, Object>> selectAllSortByTime(SickSearch sickSearch);
    List<Map<String, Object>> selectAllSortByLoc(SickSearch sickSearch);
    List<Map<String, Object>> selectReSickSortByDistance(SickSearch sickSearch);
    //获取推荐病情
	List<Map<String, Object>> paginationReSickSortByDistance(DoctorSearch doctorSearch);
	//获取病情按时间排序
	List<Map<String, Object>> paginationSickSortByTime(DoctorSearch doctorSearch);
	//获取病情按位置排序
	List<Map<String, Object>> paginationSickSortByLoc(DoctorSearch doctorSearch);
	//获取病情详情
	Map<String, Object> selectAllInfoByUserSickId(Integer usersickid);
   
}