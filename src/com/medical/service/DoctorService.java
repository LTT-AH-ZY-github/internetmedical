package com.medical.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.medical.po.DoctorCustom;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctoraddress;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Doctorskd;
import com.medical.po.SickSearch;
import com.medical.po.Userorder;



public interface DoctorService {
	
	//手机号码是否注册
	int findDocCountByPhone(String docLoginPhone);
	
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
	Map<String, Object> deletePreOrder(Integer docloginid, Integer preorderid);
	

	Map<String, Object> updateOrderConfirm(Userorder userorder);

	

	//int updateOrder(Userorder userorder) throws Exception;

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

	Map<String, Object> getHospital(String hospname);
	//医生取消订单
	Map<String, Object> updateOrderToCancle(Integer docloginid, Integer userorderid);
	//医生拒绝接单
	Map<String, Object> updateOrderToRefuse(Integer docloginid, Integer userorderid, Integer redocloginid);
	//医生修改病情部门
	Map<String, Object> changeDept(Integer docloginid, Integer userorderid, String usersickprimarydept,
			String usersickseconddept);

	int updateSecondInfo(Integer docloginid, String olddoccardphoto, MultipartFile[] doccardphoto,
			String olddoctitlephoto, MultipartFile[] doctitlephoto, String olddocqualphoto,
			MultipartFile[] docqualphoto, String olddocworkcardphoto, MultipartFile[] docworkcardphoto,
			String olddocotherphoto, MultipartFile[] docotherphoto);
	//医生结束订单
	Map<String, Object> finishOrder(Integer docloginid, Integer userorderid, Boolean userorderhstate,
			Integer userorderhospid);
	//根据医生姓名获取医生
	Map<String, Object> getDoctorByName(String docname);
	//医生获取常用地址
	Map<String, Object> getAddress(Integer docloginid, Integer page);
	//医生添加常用地址
	int addAddress(Doctoraddress doctoraddress);
	//医生修改常用地址
	int editAddress(Doctoraddress doctoraddress);
	//医生删除常用地址
	int delAddress(Integer docloginid, Integer docaddressid);
	//医生获取日程表
	Map<String, Object> getCalendar(Integer docloginid, Integer page);
	//医生设置日程表
	int addCalendar(Integer docloginid, Date doccalendarday, String doccalendartime, String doccalendaraffair,
			Integer doccalendaradressid);
	//医生更新日程表
	int editCalendar(Integer doccalendarid, Integer docloginid, Date doccalendarday, String doccalendartime,
			String doccalendaraffair, Integer doccalendaradressid);
	//医生删除日程表
	int deleteCalendar(Integer doccalendarid, Integer docloginid);
	//医生设置坐诊地点
	int updateAddress(Integer docloginid, Integer docaddressid);
	//更新channelId
	int updateChannelId(Integer docloginid, String channelid);

	Map<String, Object> getDoctorDept(Integer docLoginId);

	int setLocation(String time);

	

	

	

	

	

	

	

	
	
	

	

	
	

	
	

	



	

	

	

	

	
}
