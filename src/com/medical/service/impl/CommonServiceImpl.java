package com.medical.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Null;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.AppversionMapper;
import com.medical.mapper.AppversionMapperCustom;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.FeedbackMapper;
import com.medical.mapper.HospitaldeptMapper;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.mapper.NotificationMapper;
import com.medical.mapper.NotificationMapperCustom;

import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.po.Appversion;
import com.medical.po.Feedback;
import com.medical.po.Hospitaldept;
import com.medical.po.Notification;
import com.medical.service.iface.CommonService;
import com.medical.utils.result.DataResult;
import com.netease.utils.MsgCode;

public class CommonServiceImpl implements CommonService {
	@Autowired
	private UserlogininfoMapperCustom userlogininfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapperCustom doctorlogininfoMapperCustom;
	@Autowired
	private NotificationMapper notificationMapper;
	@Autowired
	private NotificationMapperCustom notificationMapperCustom;
	@Autowired
	private HospitaldeptMapperCustom hospitaldeptMapperCustom;
	@Autowired
	private HospitaldeptMapper hospitaldeptMapper;
	@Autowired
	private FeedbackMapper feedbackMapper;
	@Autowired
	private AppversionMapperCustom appversionMapperCustom;
	@Autowired
	private AppversionMapper appversionMapper;

	Logger logger = Logger.getLogger(CommonService.class);

	/*
	 * @Bean//这个注解会从Spring容器拿出Bean public WebSocketHandler infoHandler() { return
	 * new WebSocketHandler(); }
	 */

	// 查找账号是否注册
	@Override
	public String findAccountExit(String phone) {
		// 查询医生登录表
		int doctorCount = doctorlogininfoMapperCustom.findDocCountByPhone(phone);
		// 查询病人登录表
		int userCount = userlogininfoMapperCustom.findUserCountByPhone(phone);
		if (doctorCount > 0 || userCount > 0) {
			return DataResult.error("该号码已注册");

		} else {
			return DataResult.success("该号码未注册");
		}
	}

	// 发送短信验证码
	@Override
	public String getMsgCode(String phone) throws Exception {
		boolean result = MsgCode.getCode(phone);
		if (result) {
			return DataResult.success("短信验证码发送成功");
		} else {
			return DataResult.error("短信验证码发送失败");
		}
	}

	// 发送短信验证码
	@Override
	public boolean getCodeValidity(String phone, String code) throws Exception {
		return MsgCode.checkMsg(phone, code);
	}
	
	//
	
	
	@Override
	public String listDepts() throws Exception {
		
		List<Hospitaldept> list = hospitaldeptMapperCustom.selectAll();
		if (!list.isEmpty()) {
			// 一级单位及下级单位
			List<Map<String, Object>> data = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> dept = new HashMap<>();
				Hospitaldept hospitaldept = list.get(i);
				int fatherId = hospitaldept.getHospdeptfatherid();
				if (fatherId == 0) {
					dept.put("first", hospitaldept.getHospdeptname());
					int id = hospitaldept.getHospdeptid();
					List<String> sonDept = new ArrayList<>();
					for (int j = 0; j < list.size(); j++) {
						Hospitaldept hospitaldept2 = list.get(j);
						int fatherId2 = hospitaldept2.getHospdeptfatherid();
						if (id == fatherId2) {
							sonDept.add(hospitaldept2.getHospdeptname());
						} else {
							continue;
						}
					}
					dept.put("second", sonDept);
					data.add(dept);
				} else {
					continue;
				}
			}
			return DataResult.success("查询成功", data);
		} else {
			return DataResult.error("查询失败");
		}
	}
	
	// 医院获取需要接收的通知
	@Override
	public String listReceiveNotification(Integer notificationreceiverid, Integer notificationType, Integer limit,
			Integer offset, Integer type) throws Exception {
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = notificationMapperCustom.selectByReceiverAndType(notificationreceiverid,
				notificationType, type);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			// 总共页数
			data.put("total", pageInfo.getTotal());
			return DataResult.success("获取数据成功", data);
		} else {
			return DataResult.success("获取数据为空", null);
		}

	}
	/* (非 Javadoc)  
	* <p>Title: getUnreadNotificationNum</p>  
	* <p>Description: </p>  
	* @param hosploginid
	* @return  
	* @see com.medical.service.iface.CommonService#getUnreadNotificationNum(java.lang.Integer)  
	*/  
	@Override
	public String getUnreadNotificationNum(Integer hosploginid) {
		
		List<Map<String, Object>> list = notificationMapperCustom.selectByReceiverAndType(hosploginid,
				1, 2);
		Map<String, Object> map = new HashMap<>();
		map.put("number", list.size());
		return DataResult.success("获取成功", map);
	}
	// 病人医生获取需要接收的通知
	@Override
	public String listReceiveNotification(Integer notificationreceiverid,
			Integer notificationType, Integer page, Integer type) throws Exception {
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = notificationMapperCustom.selectByReceiverAndType(notificationreceiverid,
				notificationType, type);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());
	}

	// 医院获取需要发送的通知
	@Override
	public String listSenderNotification(Integer notificationsenderid, Integer notificationType, Integer limit,
			Integer offset, Integer type) throws Exception {
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = notificationMapperCustom.selectBySenderAndType(notificationsenderid,
				notificationType, type);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			// 总共页数
			data.put("total", pageInfo.getTotal());
			return DataResult.success("获取数据成功", data);
		} else {
			return DataResult.success("获取数据为空", null);
		}

	}

	// 用户医生获取需要发送的通知
	@Override
	public String listSenderNotification(Integer notificationsenderid, Integer notificationType,
			Integer page, Integer type) throws Exception {
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = notificationMapperCustom.selectBySenderAndType(notificationsenderid,
				notificationType, type);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());
	}

	// 将消息置为已读
	@Override
	public String updateNotificationToRead(Integer notificationid, Integer notificationreceiverid) throws Exception {
		Notification notification = notificationMapper.selectByPrimaryKey(notificationid);
		if (notification == null) {
			return DataResult.error("该通知不存在");
		}
		int receiverid = notification.getNotificationreceiverid();
		boolean read = notification.getNotificationread();
		boolean remove = notification.getNotificationremove();
		if (remove) {
			return DataResult.error("该通知不存在");
		} 
		if (notificationreceiverid!=receiverid) {
			return DataResult.error("账户信息不匹配");
		}
		if (read) {
			return DataResult.error("该通知已读");			
		}
		Notification record = new Notification();
		record.setNotificationid(notificationid);
		record.setNotificationreadtime(new Date());
		record.setNotificationread(true);
		boolean result = notificationMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			return DataResult.success("已读成功");
		}else {
			return DataResult.error("已读失败");	
		}
		
	}

	// 将全部未读消息置为已读
	@Override
	public String updateAllNotificationToRead(Integer notificationreceiverid, Integer notificationtype)
			throws Exception {
		// type为2时获取未读通知
		List<Map<String, Object>> list = notificationMapperCustom.selectByReceiverAndType(notificationreceiverid,
				notificationtype, 2);
		if (list == null || list.size() == 0) {
			return DataResult.error("无未读通知");
		}
		int result = notificationMapperCustom.updateAllToReadByReceverIdAndNotificationType(notificationreceiverid,
				notificationtype);
		if (result > 0) {
			return DataResult.success("全部已读成功");
		} else {
			return DataResult.error("全部已读失败");
		}
	}

	// 将消息删除
	@Override
	public String deleteNotification(Integer notificationid, Integer notificationreceiverid) throws Exception {
		Notification notification = notificationMapper.selectByPrimaryKey(notificationid);
		if (notification == null) {
			return DataResult.error("该通知不存在");
		}
		int receiverid = notification.getNotificationreceiverid();
		boolean remove = notification.getNotificationremove();
		if (remove) {
			return DataResult.error("该通知不存在");
		} 
		if (notificationreceiverid!=receiverid) {
			return DataResult.error("账户信息不匹配");
		}
		Notification record = new Notification();
		record.setNotificationid(notificationid);
		record.setNotificationremove(true);
		boolean result = notificationMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			return DataResult.success("删除成功");
		}else {
			return DataResult.error("删除失败");	
		}
		
	}

	// 将所有消息删除
	@Override
	public String deleteAllNotification(Integer notificationreceiverid, Integer notificationtype) throws Exception {
		// type为null时获取未读和已读通知
		List<Map<String, Object>> list = notificationMapperCustom.selectByReceiverAndType(notificationreceiverid,
				notificationtype, null);
		if (list == null || list.size() == 0) {
			return DataResult.error("无通知");
		}
		int result = notificationMapperCustom.updateAllToDelByReceverIdAndNotificationType(notificationreceiverid,
				notificationtype);
		if (result > 0) {
			return DataResult.success("删除成功");
		} else {
			return DataResult.error("删除失败");
		}
	}

	
	/*// 获取所有部门
	@Override
	public String getDept() throws Exception {
		List<Hospitaldept> list = hospitaldeptMapperCustom.selectAll();
		if (list == null || list.isEmpty()) {
			return DataResult.error("部门为空");
		}
		// 一级单位及下级单位
		List<Map<String, Object>> data = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> dept = new HashMap<>();
			Hospitaldept hospitaldept = list.get(i);
			int fatherId = hospitaldept.getHospdeptfatherid();
			if (fatherId == 0) {
				dept.put("first", hospitaldept.getHospdeptname());
				int id = hospitaldept.getHospdeptid();
				List<String> sonDept = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					Hospitaldept hospitaldept2 = list.get(j);
					int fatherId2 = hospitaldept2.getHospdeptfatherid();
					System.out.println("id" + id + "......" + fatherId2);
					if (id == fatherId2) {
						sonDept.add(hospitaldept2.getHospdeptname());
					} else {
						continue;
					}
				}
				dept.put("second", sonDept);
				data.add(dept);
			} else {
				continue;
			}
		}
		return DataResult.success("获取成功", data);
	}*/

	@Override
	public String addDept(Integer docloginid, String primarydept, String seconddept) {
		// 一级部门为空
		if (StringUtils.isBlank(primarydept)) {
			List<Hospitaldept> seconddeptlist = hospitaldeptMapperCustom.selectByPrimaryDeptAndSecondDeptAndCheck(null,
					seconddept, null);
			if (seconddeptlist != null && seconddeptlist.size() > 0) {
				return DataResult.error("该部门已存在");

			}
			Hospitaldept seconddeptRecord = new Hospitaldept();
			seconddeptRecord.setHospdeptname(seconddept);
			// -1为二级部门
			seconddeptRecord.setHospdeptfatherid(-1);
			seconddeptRecord.setHospdeptischeck(1);
			seconddeptRecord.setHospdeptsubmitter(docloginid);
			//1为医生提交审核
			seconddeptRecord.setHospdeptsubmittertype(1);
			boolean result = hospitaldeptMapper.insertSelective(seconddeptRecord) > 0;
			if (result) {
				return DataResult.success("新增成功");
			} else {
				return DataResult.error("新增失败");
			}

		}
		// 二级部门为空
		if (StringUtils.isBlank(seconddept)) {
			List<Hospitaldept> primarydeptlist = hospitaldeptMapperCustom
					.selectByPrimaryDeptAndSecondDeptAndCheck(primarydept, null, null);
			if (primarydeptlist != null && primarydeptlist.size() > 0) {
				return DataResult.error("该部门已存在");

			}
			Hospitaldept primarydeptRecord = new Hospitaldept();
			primarydeptRecord.setHospdeptname(primarydept);
			primarydeptRecord.setHospdeptfatherid(0);
			//1为未审核
			primarydeptRecord.setHospdeptischeck(1);
			primarydeptRecord.setHospdeptsubmitter(docloginid);
			//1为医生提交审核
			primarydeptRecord.setHospdeptsubmittertype(1);
			boolean primarydeptResult = hospitaldeptMapperCustom.insertSelectiveReturnId(primarydeptRecord) > 0;
			if (primarydeptResult) {
				return DataResult.success("新增成功");
			} else {
				return DataResult.error("新增失败");
			}

		}
		// 一级二级部门都存在
		List<Hospitaldept> primarydeptlist = hospitaldeptMapperCustom
				.selectByPrimaryDeptAndSecondDeptAndCheck(primarydept, null, null);
		List<Hospitaldept> seconddeptlist = hospitaldeptMapperCustom.selectByPrimaryDeptAndSecondDeptAndCheck(null,
				seconddept, null);
		if (primarydeptlist != null && primarydeptlist.size() > 0 && seconddeptlist != null
				&& seconddeptlist.size() > 0) {
			return DataResult.error("该部门已存在");
		}
		if (primarydeptlist != null && primarydeptlist.size() > 0) {
			Hospitaldept seconddeptRecord = new Hospitaldept();
			seconddeptRecord.setHospdeptname(seconddept);
			seconddeptRecord.setHospdeptfatherid(primarydeptlist.get(0).getHospdeptid());
			//1为未审核
			seconddeptRecord.setHospdeptischeck(1);
			
			boolean result = hospitaldeptMapper.insertSelective(seconddeptRecord) > 0;
			if (result) {
				return DataResult.success("新增成功");
			} else {
				return DataResult.error("新增失败");
			}
		} else {
			Hospitaldept primarydeptRecord = new Hospitaldept();
			primarydeptRecord.setHospdeptname(primarydept);
			primarydeptRecord.setHospdeptfatherid(0);
			//1为未审核
			primarydeptRecord.setHospdeptischeck(1);
			primarydeptRecord.setHospdeptsubmitter(docloginid);
			//1为医生提交审核
			primarydeptRecord.setHospdeptsubmittertype(1);
			boolean primarydeptResult = hospitaldeptMapperCustom.insertSelectiveReturnId(primarydeptRecord) > 0;
			Hospitaldept seconddeptRecord = new Hospitaldept();
			seconddeptRecord.setHospdeptname(seconddept);
			seconddeptRecord.setHospdeptfatherid(primarydeptRecord.getHospdeptid());
			//1为未审核
			seconddeptRecord.setHospdeptischeck(1);
			seconddeptRecord.setHospdeptsubmitter(docloginid);
			//1为医生提交审核
			seconddeptRecord.setHospdeptsubmittertype(1);
			boolean result = hospitaldeptMapper.insertSelective(seconddeptRecord) > 0;
			if (result && primarydeptResult) {
				return DataResult.success("新增成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("新增失败");
			}

		}
	}

	@Override
	public String addSecondDept(Integer docloginid, String seconddept) {
		// 一级二级部门都存在
		List<Hospitaldept> seconddeptlist = hospitaldeptMapperCustom.selectByPrimaryDeptAndSecondDeptAndCheck(null,
				seconddept, null);
		if (seconddeptlist != null && seconddeptlist.size() > 0) {
			return DataResult.error("该部门已存在");
		}
		List<Hospitaldept> primarydeptlist = hospitaldeptMapperCustom.selectByPrimaryDeptAndSecondDeptAndCheck("其他部门",
				null, null);
		Hospitaldept seconddeptRecord = new Hospitaldept();
		seconddeptRecord.setHospdeptname(seconddept);
		seconddeptRecord.setHospdeptfatherid(primarydeptlist.get(0).getHospdeptid());
		//1为未审核
		seconddeptRecord.setHospdeptischeck(1);
		boolean result = hospitaldeptMapper.insertSelective(seconddeptRecord) > 0;
		if (result) {
			return DataResult.success("新增成功");
		} else {
			return DataResult.error("新增失败");
		}
	}

	@Override
	public String addFeedBack(Integer type,String feedbackidea) throws Exception{
		Feedback feedback = new Feedback();
		feedback.setFeedbackidea(feedbackidea);
		feedback.setFeedbacktime(new Date());
		feedback.setFeedbackischeck(false);
		feedback.setFeedbacktype(type);
		feedback.setFeedbackchecktime(new Date());
		boolean result = feedbackMapper.insertSelective(feedback) > 0;
		if (result) {
			return DataResult.success("添加成功");
		} else {
			return DataResult.error("添加失败");
		}
	}
	
	@Override
	public String getAppVersion(Integer apptype, Integer systemtype) throws Exception{
		List<Appversion> list = appversionMapperCustom.selectByAppyType(apptype,systemtype);
		if (list!=null && list.size()>0) {
			Map<String, Object> map = new HashMap<>();
			map.put("version", list.get(0).getAppversion());
			map.put("url", list.get(0).getAppurl());
			map.put("description", list.get(0).getDescription());
			return DataResult.success("获取成功",map);
		} else {
			return DataResult.success("数据为空",null);
		}
	}

	/* (非 Javadoc)  
	* <p>Title: uploadAndroidApp</p>  
	* <p>Description: </p>  
	* @param type
	* @param app
	* @param version
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.CommonService#uploadAndroidApp(java.lang.Integer, org.springframework.web.multipart.MultipartFile, java.lang.String)  
	*/  
	@Override
	public String uploadAndroidApp(Integer type, MultipartFile app, String version, String description) throws Exception {
		//type为1是病人端
		String name = null;
		if (type==1) {
			name="suyunuser";
		}else {
			name="suyundoctor";
		}
		// 获取后缀
		String oriName = app.getOriginalFilename();
		String ext = oriName.substring(oriName.lastIndexOf("."));
		String file = name + ext;
		String reallyPath = "C:\\app\\" + file;
		app.transferTo(new File(reallyPath));
		Appversion appversion = new Appversion();
		appversion.setApppublishtime(new Date());
		appversion.setAppversion(version);
		appversion.setApptype(type);
		appversion.setDescription(description);
		appversion.setAppurl("http://118.89.172.204:8080/download/"+file);
		//1为安卓
		appversion.setSystemtype(1);
		boolean result = appversionMapper.insertSelective(appversion)>0;
		if (result) {
			return DataResult.success("上传成功");	
		}else {
			return DataResult.success("上传失败");
		}
		
	}
}
