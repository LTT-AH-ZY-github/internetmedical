package com.medical.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.medical.po.DoctorCustom;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Doctorskd;
import com.medical.po.SickSearch;
import com.medical.po.Userorder;



public interface DoctorService {
	
	//手机号码是否注册
	int findDocCountByPhone(String docLoginPhone) throws Exception;
	
	// 医生注册
	int createDoctor(String docLoginPhone, String magCode, String docLoginPwd);
	
	//登录
	Map<String, Object> updateDoctorToLogin(Doctorlogininfo doctorlogininfo) throws NoSuchAlgorithmException;
	
	//获取个人信息
	Map<String, Object> getInfo(Integer docLoginId, Integer flag);
	
	//上传照片
	Map<String, Object>  updatePhoto(MultipartFile[] pictureFile, int id, Integer type) throws Exception;
	
	// 获取头像
	Map<String, Object> getPix(int id) throws Exception;
	
	//更新医生信息
	int updateInfo(Doctorinfo doctorinfo) throws Exception;

	//获取日程
	Map<String, Object> getSchedule(Integer docLoginId) throws Exception;
	
	//更新日程
	int updateSchedule(Doctorskd doctorskd);
	
	//医生抢单
	Map<String, Object> creatPreOrder(int userSickId, int docLoginId, Double preorderdprice);
	
	//医生取消抢单
	Map<String, Object> deletePreOrder(int preorderid);
	

	Map<String, Object> updateOrderConfirm(Userorder userorder);

	

	int updateOrder(Userorder userorder) throws Exception;

	Map<String, Object> getSicks(SickSearch sickSearch) throws Exception;

	

	
	
	// 根据时间获取病情
	Map<String, Object> getSickByTime(int id, int page) throws Exception;
    
	// 根据城市获取病情
	Map<String, Object> getSickByLoc(int id, int page, String loc) throws Exception;
	
	//获取推荐病情
	Map<String, Object> getReSick(int id, int page) throws Exception;
	
	
	
	//获取病人头像
	Map<String, Object> getUserPix(int id) throws Exception;
	//获取所有科室
	Map<String, Object> getDeptByFatherId(int id) throws Exception;

	Map<String, Object> getDept() throws Exception;
	

	

	
	//获取病情
	Map<String, Object> listSick(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon,
			String time, String province, String city, String area);

	//获取病情详情
	Map<String, Object> getSickDetail(Integer usersickid) throws Exception;
	
	//获取已抢订单
	Map<String, Object> listGrabOrders(Integer docloginid, Integer pageNo, Integer pageSize);
	//获取已抢订单详情
	Map<String, Object> getGrabOrderDetail(Integer preOrderId);
	//获取订单
	Map<String, Object> listOrder(Integer docLoginId, Integer type, Integer pageNo, Integer pageSize) throws Exception;
	//获取订单详请
	Map<String, Object> getOrderDetail(Integer docLoginId, Integer userOrderId);

	

	

	
	
	

	

	
	

	
	

	



	

	

	

	

	
}
