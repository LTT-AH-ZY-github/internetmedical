/**  
* @Title: SenderNotificationServiceImpl.java  
* @Package com.medical.service.impl  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月12日  
* @version V1.0  
*/  
package com.medical.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;

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
import com.medical.po.Doctorlogininfo;
import com.medical.po.Notification;
import com.medical.po.Userlogininfo;
import com.medical.service.iface.SenderNotificationService;
import com.push.baidu.PushToDoctor;
import com.push.baidu.PushToUser;
import com.push.websocket.WebSocketHandler;

import net.sf.json.JSONObject;

/**
 * @ClassName:     SenderNotificationServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月12日 下午10:00:37 
 */
public class SenderNotificationServiceImpl implements SenderNotificationService {
	
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private NotificationMapper notificationMapper;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;

	// 病人发给医生
		@Override
		public boolean createMsgUserToDoctor(Integer userloginid, String name,Integer docloginid, String title, String msg,
				JSONObject jsonCustormCont) throws Exception {
			if (StringUtils.isBlank(name)) {
				name = userinfoMapperCustom.selectByLoginId(userloginid).getUsername();
			}
			String words =  name+ msg;
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
		public boolean createMsgUserToHospital(Integer userloginid,String name, Integer hosploginid, String title, String msg,
				JSONObject jsonCustormCont) throws Exception {
			if (StringUtils.isBlank(name)) {
				name = userinfoMapperCustom.selectByLoginId(userloginid).getUsername();
			}
			String words =  name+ msg;
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
				 WebSocketHandler.sendMessageToUser("hosp_"+hosploginid, new TextMessage(words));  
				return true;
			} else {
				return false;
			}
		}

		// 病人发给医发送管理员
		@Override
		public boolean createMsgUserToAdmin(Integer userloginid,String name, Integer adminloginid, String title, String msg,
				JSONObject jsonCustormCont) throws Exception {
			if (StringUtils.isBlank(name)) {
				name = userinfoMapperCustom.selectByLoginId(userloginid).getUsername();
			}
			String words =  name+ msg;
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
				WebSocketHandler.sendMessageToUser("admin_"+adminloginid, new TextMessage(words));  
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
				 WebSocketHandler.sendMessageToUser("hosp_"+hosploginid, new TextMessage(words));
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
				WebSocketHandler.sendMessageToUser("admin_"+adminloginid, new TextMessage(words)); 
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
				WebSocketHandler.sendMessageToUser("admin_"+adminloginid, new TextMessage(words)); 
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
				 WebSocketHandler.sendMessageToUser("hosp_"+hosploginid, new TextMessage(words));
				return true;
			} else {
				return false;
			}
		}
}
