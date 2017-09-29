package com.medical.service;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.medical.po.City;
import com.medical.po.DoctorSearch;
import com.medical.po.Familyinfo;


import com.medical.po.Userinfo;
import com.medical.po.Userlogininfo;
import com.medical.po.UserlogininfoCustom;
import com.medical.po.Userorder;

import com.medical.po.UsersickCustom;

public interface UserService {

	// 验证手机号码是否注册
    int findUserCount(String phone);

	// 用户注册
	public int createUser(String phone, String password ,String code) throws Exception;

	// 用户登录
	Map<String, Object> updateUserToLogin(UserlogininfoCustom userlogininfoCustom) throws Exception;
    
	//退出登录
	int updateUserToExit(Integer userloginid) throws Exception;
	
	// 修改图片
	Map<String, Object> updateUserPixAndUserName(MultipartFile pictureFile, Integer userloginid,String username) throws Exception;

	// 查询图片
	//public Map<String, Object> getUserPix(String phone) throws Exception;

	// 修改昵称
	//public int updateUserName(String phone, String username) throws Exception;

	// 修改密码
	public int updatePassword(String phone, String password, String code) throws Exception;

	// 查询用户信息
	public Map<String, Object> findUserInfo(Integer userloginid) throws Exception;

	// 修改用户信息
	int updateUserInfo(Integer userloginid, String username, String usermale, String usercardnum, String useradrprovince,
			String useradrcity, Integer userage, String useradrarea, String useradrother, MultipartFile[] pictureFile) throws Exception;

	// 查询亲属信息
	public Map<String, Object> findFamily(Integer userloginid) throws Exception;

	// 添加亲属信息
	public int insertFamily(Familyinfo familyinfo) throws Exception;

	// 删除用户信息
	public int deleteFamily(Integer familyid) throws Exception;

	// 更新亲属信息
	public int updateFamily(Familyinfo familyinfo) throws Exception;

	// 查询城市
	public List<City> findCity(String code) throws Exception;

	// 插入病情信息
	public int addSick(MultipartFile[] pictureFile, UsersickCustom usersickCustom) throws Exception;

	// 更新病情信息
	public int updateSick(MultipartFile[] pictureFile, UsersickCustom usersickCustom) throws Exception;

	// 删除病情信息
	public int deleteSick(Integer id) throws Exception;

	// 获取所有病情
	public Map<String, Object> findSicks(Integer userloginid) throws Exception;

	// 获取病情详情
	Map<String, Object> getSickInfo(Integer id) throws Exception;

	// 获取病情图片
	//byte[] getUserSickPix(String fileName) throws Exception;

	// 获取医生头像
	//Map<String, Object> getDoctorPix(int id) throws Exception;

	// 查找医生 地图模式
	Map<String, Object> findDoctorsInMap(String arg1, String arg2, String arg3, String arg4) throws Exception;

	// 获取单个医生信息
	Map<String, Object> findDoctoInfo(Integer docloginid) throws Exception;

	// 获取医生信息 列表模式
	Map<String, Object> findDoctors(DoctorSearch doctorSearch) throws Exception;

	// 查找医生日程安排
	Map<String, Object> getSchedule(Integer id) throws Exception;

	// 根据病情推荐医生
	int creatReDoctor(Integer userSickId, Date date, String desc, String primaryDept, String secondDept) throws Exception;

	// 查询推荐医生
	public Map<String, Object> findReDoctor(Integer userloginid) throws Exception ;

	// 生成订单
	int createOrder(Integer docLoginId, Integer userSickId, String time) throws Exception;

	// 发布病情
	int updateSickToPublish(Integer userSickId) throws Exception;
	
	//取消发布
	int updateSickToCancel(Integer usersickid) throws Exception;

	//int updateOrderState(int userOrderId) throws Exception;
	
	//添加预选医生
	int addOptDoctor(Integer docLoginid, Integer userloginid) throws Exception;
   
	//获取订单
	Map<String, Object> getOrders(Integer userloginid);
	
	//获取完整订单信息
	Map<String, Object> getOrderAllInfo(Integer userLoginId);
	
	//确认订单
	int updateOrderToConfirm(Integer userOrderId, Integer userloginid) throws Exception;
	//取消订单
	int updateOrderToCancel(Integer userOrderId, Integer userloginid) throws Exception;

	Map<String, Object> findReDoctorDetails(Integer preorderid) throws Exception;

	Map<String, Object> listOldOrders(Integer userloginid, Integer pageNo, Integer pageSize);

	

	


	

	

	

	


	

	

	

	

	

	

	

}
