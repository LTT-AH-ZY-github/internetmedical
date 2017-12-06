package com.medical.service.impl;

import java.util.ArrayList;
import com.push.websocket.WebSocketHandler;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.socket.TextMessage;

import com.baidu.yun.push.utils.PushToDoctor;
import com.baidu.yun.push.utils.PushToUser;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.medical.exception.custom.MyException;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HospitaldeptMapper;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.mapper.NotificationMapper;
import com.medical.mapper.NotificationMapperCustom;

import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;

import com.medical.po.Hospitaldept;
import com.medical.po.Notification;
import com.medical.po.Userlogininfo;
import com.medical.service.iface.CommonService;
import com.medical.utils.KeyWords;
import com.medical.utils.result.DataResult;
import com.netease.code.MsgCode;
import net.sf.json.JSONObject;

public class CommonServiceImpl implements CommonService {
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private UserlogininfoMapperCustom userlogininfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapperCustom doctorlogininfoMapperCustom;
	@Autowired
	private NotificationMapper notificationMapper;
	@Autowired
	private NotificationMapperCustom notificationMapperCustom;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private HospitaldeptMapperCustom hospitaldeptMapperCustom;
	@Autowired
	private HospitaldeptMapper hospitaldeptMapper;

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

	// 根据条件获取推荐医生
	@Override
	public Map<String, Object> listRecommendDoctors(String keyWord, String primaryDept, String secondDept)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (primaryDept == null && secondDept == null) {
			Map<String, Object> result = getByKeyWord(keyWord);
			// 获取成功
			if ("1".equals(result.get("state"))) {
				map.put("state", "1");
				map.put("data", result.get("data"));
			} else {
				map.put("state", "2");

			}

		} else {
			List<Doctorinfo> list = doctorinfoMapperCustom.selectByDept(primaryDept, secondDept);
			if (list.size() > 0) {
				// 获取成功
				map.put("state", "1");
				map.put("data", list);
			} else {
				Map<String, Object> result = getByKeyWord(keyWord);
				// 获取成功
				if ("1".equals(result.get("state"))) {
					map.put("state", "1");
					map.put("data", result.get("data"));
				} else {
					map.put("state", "2");

				}
			}
		}
		return map;

	}

	public Map<String, Object> getByKeyWord(String keyWord) throws Exception {
		String primaryDept = "内科";
		String secondDept = null;
		Map<String, Object> map = new HashMap<String, Object>();
		boolean headacheresult1 = keyWord.contains(KeyWords.HEADACHE_WORD1);
		boolean headacheresult2 = keyWord.contains(KeyWords.HEADACHE_WORD2);
		boolean headacheresult3 = keyWord.contains(KeyWords.HEADACHE_WORD3);
		boolean headacheresult4 = keyWord.contains(KeyWords.HEADACHE_WORD4);
		boolean headacheresult5 = keyWord.contains(KeyWords.HEADACHE_WORD5);
		boolean headacheresult6 = keyWord.contains(KeyWords.HEADACHE_WORD6);
		boolean headacheresult7 = keyWord.contains(KeyWords.HEADACHE_WORD7);
		boolean headacheresult8 = keyWord.contains(KeyWords.HEADACHE_WORD8);
		boolean headacheresult9 = keyWord.contains(KeyWords.HEADACHE_WORD9);
		boolean headacheresult10 = keyWord.contains(KeyWords.HEADACHE_WORD10);
		boolean headacheresult11 = keyWord.contains(KeyWords.HEADACHE_WORD11);
		boolean headacheresult12 = keyWord.contains(KeyWords.HEADACHE_WORD12);
		boolean headacheresult = headacheresult1 || headacheresult2 || headacheresult3 || headacheresult4
				|| headacheresult5 || headacheresult6 || headacheresult7 || headacheresult8 || headacheresult9
				|| headacheresult10 || headacheresult11 || headacheresult12;
		if (headacheresult) {
			primaryDept = "内科";
			secondDept = "神经内科";

		}
		List<Doctorinfo> list = doctorinfoMapperCustom.selectByDept(primaryDept, secondDept);
		if (list.size() > 0) {
			// 获取成功
			map.put("state", "1");
			map.put("data", list);
		} else {
			List<Doctorinfo> defaultList = doctorinfoMapperCustom.selectByDept(null, null);
			if (defaultList.size() > 0) {
				map.put("state", "1");
				map.put("data", defaultList);
			} else {
				map.put("state", "2");
			}

		}
		return map;

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

	// 病人医生获取需要接收的通知
	@Override
	public PageInfo<Map<String, Object>> listReceiveNotification(Integer notificationreceiverid,
			Integer notificationType, Integer page, Integer type) throws Exception {
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = notificationMapperCustom.selectByReceiverAndType(notificationreceiverid,
				notificationType, type);
		return new PageInfo<Map<String, Object>>(list);
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
	public PageInfo<Map<String, Object>> listSenderNotification(Integer notificationsenderid, Integer notificationType,
			Integer page, Integer type) throws Exception {
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = notificationMapperCustom.selectBySenderAndType(notificationsenderid,
				notificationType, type);
		return new PageInfo<Map<String, Object>>(list);
	}

	// 将消息置为已读
	@Override
	public boolean updateNotificationToRead(Integer notificationid, Integer notificationreceiverid) throws Exception {
		Notification notification = notificationMapper.selectByPrimaryKey(notificationid);
		if (notification != null) {
			int receiverid = notification.getNotificationreceiverid();
			boolean read = notification.getNotificationread();
			boolean remove = notification.getNotificationremove();
			if (remove) {
				throw new MyException("该通知不存在");
			} else {
				if (notificationreceiverid.equals(receiverid)) {
					if (read) {
						throw new MyException("该通知已读");
					} else {
						Notification record = new Notification();
						record.setNotificationid(notificationid);
						record.setNotificationreadtime(new Date());
						record.setNotificationread(true);
						return notificationMapper.updateByPrimaryKeySelective(record) > 0;
					}

				} else {
					throw new MyException("该通知不属于该用户");
				}
			}
		} else {
			throw new MyException("该通知不存在");
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
	public boolean deleteNotification(Integer notificationid, Integer notificationreceiverid) throws Exception {
		Notification notification = notificationMapper.selectByPrimaryKey(notificationid);
		if (notification != null) {
			int receiverid = notification.getNotificationreceiverid();
			boolean remove = notification.getNotificationremove();
			if (remove) {
				throw new MyException("该通知不存在");
			} else {
				if (notificationreceiverid.equals(receiverid)) {
					Notification record = new Notification();
					record.setNotificationid(notificationid);
					record.setNotificationremove(true);
					return notificationMapper.updateByPrimaryKeySelective(record) > 0;
				} else {
					throw new MyException("该通知不属于该用户");
				}
			}

		} else {
			throw new MyException("该通知不存在");
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

	// 病人发给医生
	@Override
	public boolean createMsgUserToDoctor(Integer userloginid, Integer docloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception {
		String words = userinfoMapperCustom.selectByLoginId(userloginid).getUsername() + msg;
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		int dev = doctorlogininfo.getDoclogindev();
		String channelid = doctorlogininfo.getDocloginchannelid();
		Notification notification = new Notification();
		notification.setNotificationtitle(title);
		notification.setNotificationwords(words);
		notification.setNotificationdata(jsonCustormCont.toString());
		notification.setNotificationcreatetime(new Date());
		notification.setNotificationsenderid(userloginid);
		notification.setNotificationreceiverid(docloginid);
		notification.setNotificationremove(false);
		notification.setNotificationread(false);
		// 病人发给医生
		notification.setNotificationtypeid(1);
		boolean result = notificationMapper.insertSelective(notification) > 0;
		if (result) {
			PushToDoctor pushToDoctor = new PushToDoctor(channelid, title, words, dev);
			pushToDoctor.send();
			return true;
		} else {
			return false;
		}
	}

	// 病人发给医院
	@Override
	public boolean createMsgUserToHospital(Integer userloginid, Integer hosploginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception {
		String words = userinfoMapperCustom.selectByLoginId(userloginid).getUsername() + msg;
		Notification notification = new Notification();
		notification.setNotificationtitle(title);
		notification.setNotificationwords(words);
		notification.setNotificationdata(jsonCustormCont.toString());
		notification.setNotificationcreatetime(new Date());
		notification.setNotificationsenderid(userloginid);
		notification.setNotificationreceiverid(hosploginid);
		notification.setNotificationremove(false);
		notification.setNotificationread(false);
		// 2病人发给医院
		notification.setNotificationtypeid(2);
		boolean result = notificationMapper.insertSelective(notification) > 0;
		if (result) {
			// infoHandler().sendMessageToUser(hosploginid+"", new TextMessage(words));
			return true;
		} else {
			return false;
		}
	}

	// 病人发给医发送管理员
	@Override
	public boolean createMsgUserToAdmin(Integer userloginid, Integer adminloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception {
		String words = userinfoMapperCustom.selectByLoginId(userloginid).getUsername() + msg;
		Notification notification = new Notification();
		notification.setNotificationtitle(title);
		notification.setNotificationwords(words);
		notification.setNotificationdata(jsonCustormCont.toString());
		notification.setNotificationcreatetime(new Date());
		notification.setNotificationsenderid(userloginid);
		notification.setNotificationreceiverid(adminloginid);
		notification.setNotificationremove(false);
		notification.setNotificationread(false);
		// 2病人发给管理员
		notification.setNotificationtypeid(7);
		boolean result = notificationMapper.insertSelective(notification) > 0;
		if (result) {
			// infoHandler().sendMessageToUser(hosploginid+"", new TextMessage(words));
			return true;

		} else {
			return false;
		}
	}

	// 医生发送消息给病人
	@Override
	public boolean createMsgDoctorToUser(Integer docloginid, Integer userloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception {
		String words = doctorinfoMapperCustom.selectByDocLoginId(docloginid).getDocname() + "医生" + msg;
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		int dev = userlogininfo.getUserlogindev();
		String channelid = userlogininfo.getUserloginchannelid();
		Notification notification = new Notification();
		notification.setNotificationtitle(title);
		notification.setNotificationwords(words);
		notification.setNotificationdata(jsonCustormCont.toString());
		notification.setNotificationcreatetime(new Date());
		notification.setNotificationsenderid(docloginid);
		notification.setNotificationreceiverid(userloginid);
		notification.setNotificationremove(false);
		notification.setNotificationread(false);
		// 医生发给病人
		notification.setNotificationtypeid(3);
		boolean result = notificationMapper.insertSelective(notification) > 0;
		if (result) {
			PushToUser pushToUser = new PushToUser(channelid, title, words, dev);
			pushToUser.send();
			return true;
		} else {
			return false;
		}
	}

	// 医生发给医院
	@Override
	public boolean createMsgDoctorToHospital(Integer docloginid, Integer hosploginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception {
		String words = doctorinfoMapperCustom.selectByDocLoginId(docloginid).getDocname() + "医生" + msg;
		Notification notification = new Notification();
		notification.setNotificationtitle(title);
		notification.setNotificationwords(words);
		notification.setNotificationdata(jsonCustormCont.toString());
		notification.setNotificationcreatetime(new Date());
		notification.setNotificationsenderid(docloginid);
		notification.setNotificationreceiverid(hosploginid);
		notification.setNotificationremove(false);
		notification.setNotificationread(false);
		// 4医生发给医院
		notification.setNotificationtypeid(4);
		boolean result = notificationMapper.insertSelective(notification) > 0;
		if (result) {
			// infoHandler().sendMessageToUser(hosploginid+"", new TextMessage(words));
			return true;
		} else {
			return false;
		}
	}

	// 医生发给管理员
	@Override
	public boolean createMsgDoctorToAdmin(Integer docloginid, Integer adminloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception {
		String words = doctorinfoMapperCustom.selectByDocLoginId(docloginid).getDocname() + "医生" + msg;
		Notification notification = new Notification();
		notification.setNotificationtitle(title);
		notification.setNotificationwords(words);
		notification.setNotificationdata(jsonCustormCont.toString());
		notification.setNotificationcreatetime(new Date());
		notification.setNotificationsenderid(docloginid);
		notification.setNotificationreceiverid(adminloginid);
		notification.setNotificationremove(false);
		notification.setNotificationread(false);
		// 4医生发给医院
		notification.setNotificationtypeid(8);
		boolean result = notificationMapper.insertSelective(notification) > 0;
		if (result) {
			// infoHandler().sendMessageToUser(hosploginid+"", new TextMessage(words));
			return true;
		} else {
			return false;
		}
	}

	// 医院发送消息给病人 
	@Override
	public boolean createMsgHospitalToUser(Integer hosploginid, Integer userloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception {
		String words = hospinfoMapperCustom.selectByHospLoginId(hosploginid).getHospname() + msg;
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		int dev = userlogininfo.getUserlogindev();
		String channelid = userlogininfo.getUserloginchannelid();
		Notification notification = new Notification();
		notification.setNotificationtitle(title);
		notification.setNotificationwords(words);
		notification.setNotificationdata(jsonCustormCont.toString());
		notification.setNotificationcreatetime(new Date());
		notification.setNotificationsenderid(hosploginid);
		notification.setNotificationreceiverid(userloginid);
		notification.setNotificationremove(false);
		notification.setNotificationread(false);
		// 5医院发送消息给病人
		notification.setNotificationtypeid(5);
		boolean result = notificationMapper.insertSelective(notification) > 0;
		if (result) {
			PushToUser pushToUser = new PushToUser(channelid, title, words, dev);
			pushToUser.send();
			return true;
		} else {
			return false;
		}
	}

	// 医院发送消息给医生
	@Override
	public boolean createMsgHospitalToDoctor(Integer hosploginid, Integer docloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception {
		String words = hospinfoMapperCustom.selectByHospLoginId(hosploginid).getHospname() + msg;
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		int dev = doctorlogininfo.getDoclogindev();
		String channelid = doctorlogininfo.getDocloginchannelid();
		Notification notification = new Notification();
		notification.setNotificationtitle(title);
		notification.setNotificationwords(words);
		notification.setNotificationdata(jsonCustormCont.toString());
		notification.setNotificationcreatetime(new Date());
		notification.setNotificationsenderid(hosploginid);
		notification.setNotificationreceiverid(docloginid);
		notification.setNotificationremove(false);
		notification.setNotificationread(false);
		// 5医院发送消息给医生
		notification.setNotificationtypeid(6);
		boolean result = notificationMapper.insertSelective(notification) > 0;
		if (result) {
			PushToDoctor pushToDoctor = new PushToDoctor(channelid, title, words, dev);
			pushToDoctor.send();
			return true;
		} else {
			return false;
		}
	}

	// 医院发送消息给管理员
	@Override
	public boolean createMsgHospitalToAdmin(Integer hosploginid, Integer adminloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception {
		String words = hospinfoMapperCustom.selectByHospLoginId(hosploginid).getHospname() + msg;
		Notification notification = new Notification();
		notification.setNotificationtitle(title);
		notification.setNotificationwords(words);
		notification.setNotificationdata(jsonCustormCont.toString());
		notification.setNotificationcreatetime(new Date());
		notification.setNotificationsenderid(hosploginid);
		notification.setNotificationreceiverid(adminloginid);
		notification.setNotificationremove(false);
		notification.setNotificationread(false);
		// 5医院发送消息给管理体员
		notification.setNotificationtypeid(9);
		boolean result = notificationMapper.insertSelective(notification) > 0;
		if (result) {

			return true;
		} else {
			return false;
		}
	}

	// 管理员发送消息给病人
	@Override
	public boolean createMsgAdminToUser(Integer adminloginid, Integer userloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception {
		String words = "管理员" + msg;
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		int dev = userlogininfo.getUserlogindev();
		String channelid = userlogininfo.getUserloginchannelid();
		Notification notification = new Notification();
		notification.setNotificationtitle(title);
		notification.setNotificationwords(words);
		notification.setNotificationdata(jsonCustormCont.toString());
		notification.setNotificationcreatetime(new Date());
		notification.setNotificationsenderid(adminloginid);
		notification.setNotificationreceiverid(userloginid);
		notification.setNotificationremove(false);
		notification.setNotificationread(false);
		// 5医院发送消息给病人
		notification.setNotificationtypeid(10);
		boolean result = notificationMapper.insertSelective(notification) > 0;
		if (result) {
			PushToUser pushToUser = new PushToUser(channelid, title, words, dev);
			pushToUser.send();
			return true;
		} else {
			return false;
		}
	}

	// 管理员发送消息给医生
	@Override
	public boolean createMsgAdminToDoctor(Integer adminloginid, Integer docloginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception {
		String words = "管理员" + msg;
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		int dev = doctorlogininfo.getDoclogindev();
		String channelid = doctorlogininfo.getDocloginchannelid();
		Notification notification = new Notification();
		notification.setNotificationtitle(title);
		notification.setNotificationwords(words);
		notification.setNotificationdata(jsonCustormCont.toString());
		notification.setNotificationcreatetime(new Date());
		notification.setNotificationsenderid(adminloginid);
		notification.setNotificationreceiverid(docloginid);
		notification.setNotificationremove(false);
		notification.setNotificationread(false);
		// 11管理员发送消息给医生
		notification.setNotificationtypeid(11);
		boolean result = notificationMapper.insertSelective(notification) > 0;
		if (result) {
			PushToDoctor pushToDoctor = new PushToDoctor(channelid, title, words, dev);
			pushToDoctor.send();
			return true;
		} else {
			return false;
		}
	}
	
	// 管理员发给医院
	@Override
	public boolean createMsgAdminToHospital(Integer adminloginid, Integer hosploginid, String title, String msg,
			JSONObject jsonCustormCont) throws Exception {
		String words = "管理员" + msg;
		Notification notification = new Notification();
		notification.setNotificationtitle(title);
		notification.setNotificationwords(words);
		notification.setNotificationdata(jsonCustormCont.toString());
		notification.setNotificationcreatetime(new Date());
		notification.setNotificationsenderid(adminloginid);
		notification.setNotificationreceiverid(hosploginid);
		notification.setNotificationremove(false);
		notification.setNotificationread(false);
		// 12管理员发给医院
		notification.setNotificationtypeid(12);
		boolean result = notificationMapper.insertSelective(notification) > 0;
		if (result) {
			// infoHandler().sendMessageToUser(hosploginid+"", new TextMessage(words));
			return true;
		} else {
			return false;
		}
	}
	// 获取所有部门
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
	}

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
			seconddeptRecord.setHospdeptischeck(false);
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
			primarydeptRecord.setHospdeptischeck(false);
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
			seconddeptRecord.setHospdeptischeck(false);
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
			primarydeptRecord.setHospdeptischeck(false);
			boolean primarydeptResult = hospitaldeptMapperCustom.insertSelectiveReturnId(primarydeptRecord) > 0;
			Hospitaldept seconddeptRecord = new Hospitaldept();
			seconddeptRecord.setHospdeptname(seconddept);
			seconddeptRecord.setHospdeptfatherid(primarydeptRecord.getHospdeptid());
			seconddeptRecord.setHospdeptischeck(false);
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
		seconddeptRecord.setHospdeptischeck(false);
		boolean result = hospitaldeptMapper.insertSelective(seconddeptRecord) > 0;
		if (result) {
			return DataResult.success("新增成功");
		} else {
			return DataResult.error("新增失败");
		}
	}
}
