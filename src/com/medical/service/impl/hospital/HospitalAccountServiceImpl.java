package com.medical.service.impl.hospital;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.huanxin.utils.UserManger;
import com.medical.mapper.HospinfoMapper;
import com.medical.mapper.HosplogMapper;
import com.medical.mapper.HosplogininfoMapper;
import com.medical.mapper.HosplogininfoMapperCustom;
import com.medical.po.Accounttype;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlog;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Doctorskd;
import com.medical.po.Hospinfo;
import com.medical.po.Hosplog;
import com.medical.po.Hosplogininfo;
import com.medical.service.iface.hospital.HospitalAccountService;
import com.medical.utils.Global;
import com.medical.utils.MD5Util;
import com.medical.utils.TokeManager;
import com.medical.utils.result.DataResult;
import com.netease.code.MsgCode;

public class HospitalAccountServiceImpl implements HospitalAccountService{
	@Autowired
	private  HosplogininfoMapper hosplogininfoMapper;
	@Autowired
	private  HosplogininfoMapperCustom hosplogininfoMapperCustom;
	@Autowired
	private  HospinfoMapper hospinfoMapper;
	@Autowired
	private  HosplogMapper hosplogMapper;
	// 查找账号是否注册
		@Override
		public String findAccountExit(String hosploginphone) {
			// 查询医生登录表
			Hosplogininfo hosplogininfo = hosplogininfoMapperCustom.selectByHospLoginPhone(hosploginphone);

			if (hosplogininfo!= null) {
				return DataResult.error("该号码已注册");

			} else {
				return DataResult.success("该号码未注册");
			}
		}
		// 注册
		@Override
		public String createAccount(String hosploginphone, String msgcode, String hosploginppwd) throws Exception {
			boolean msgResult = MsgCode.checkMsg(hosploginphone, msgcode);
			if (!msgResult) {
				return DataResult.error("验证码错误");
			}
			// 查询医生登录表
			Hosplogininfo hosplogininfo = hosplogininfoMapperCustom.selectByHospLoginPhone(hosploginphone);
		  
		   if (hosplogininfo!= null) {
				return DataResult.error("该号码已注册");
			}
			Hosplogininfo hosplogininforecord = new Hosplogininfo();
		
			hosplogininforecord.setHosploginphone(hosploginphone);
			String phoneNumber = hosploginphone.substring(0, 3) + "****" + hosploginphone.substring(7, hosploginphone.length());
			hosplogininforecord.setHosploginname(phoneNumber);
			String[] str = MD5Util.generate(hosploginppwd);
			// md5值密码
			hosplogininforecord.setHosploginpwd(str[0]);
			// salt值
			hosplogininforecord.setHosploginsalt(str[1]);
			// 未审核用户
			hosplogininforecord.setHosplogintype(1);
			hosplogininforecord.setHosploginpix("http://oytv6cmyw.bkt.clouddn.com/20171103064014944735.jpg");
			// 插入登录信息表
			int result = hosplogininfoMapperCustom.insertSelectiveReturnId(hosplogininforecord);
			Hospinfo hospinfoRecord = new Hospinfo();
			hospinfoRecord.setHosploginid(hosplogininforecord.getHosploginid());
			// 创建信息表
			int infoResult = hospinfoMapper.insertSelective(hospinfoRecord);
			// 操作成功
			if (result > 0 && infoResult > 0 ) {
				addHuanXinAccout(hosplogininforecord.getHosploginid(), hosploginppwd);
				return DataResult.success("注册成功");
			} else {
				// 操作失败，回滚
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("注册失败");
			}

		}

		// 普通登录
		@Override
		public String updateDoctorToNormalLogin(String hosploginphone,String hosploginppwd) throws Exception {

			// 登录信息
			Hosplogininfo hosplogininforecord = new Hosplogininfo();
			hosplogininforecord.setHosplogintime(new Date());
			
			// 登录日志信息
			Hosplog logRecord = new Hosplog();
			logRecord.setHosplogtime(new Date());
			

			// 检查账号密码是否正确
			Hosplogininfo hosplogininfo = hosplogininfoMapperCustom.selectByHospLoginPhone(hosploginphone);
			if (hosplogininfo == null) {
				return DataResult.error("该号码未注册");
			}
			boolean state = MD5Util.verify(hosploginppwd, hosplogininfo.getHosploginsalt(),
					hosplogininfo.getHosploginpwd());
			if (!state) {
				return DataResult.error("密码错误");
			}
			hosplogininforecord.setHosploginid(hosplogininfo.getHosploginid());
			boolean loginresult = hosplogininfoMapper.updateByPrimaryKeySelective(hosplogininforecord)>0;
			
			logRecord.setHosploginid(hosplogininfo.getHosploginid());
			boolean logresult = hosplogMapper.insertSelective(logRecord)>0;
			if (logresult && loginresult) {
				Map<String, Object> map = new HashMap<>();
				map.put("hosploginid", hosplogininfo.getHosploginid());
				map.put("huanxinaccount", hosplogininfo.getHosphuanxinaccount());
				return DataResult.success("登录成功",map);
			} else {
				return DataResult.error("登录失败");
			}
			

		}

		
		
		
		// 注册环信
		@Override
		public boolean addHuanXinAccout(Integer hosploginid, String password) throws Exception {
			boolean registerResult =  UserManger.register("hosp_" + hosploginid, password);
			if (registerResult) {
				Hosplogininfo hosplogininforecord = new Hosplogininfo();
				hosplogininforecord.setHosploginid(hosploginid);
				hosplogininforecord.setHosphuanxinaccount("hosp_" + hosploginid);
				hosplogininfoMapper.updateByPrimaryKeySelective(hosplogininforecord);
				return true;
			} else {
				return false;
			}

		}

		// 修改环信密码
		@Override
		public String editHuanXinPassword(Integer hosploginid, String password) throws Exception {
			Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
			if (hosplogininfo == null) {
				return DataResult.error("账号不存在");
			} else {
				boolean registerResult = UserManger.register(hosplogininfo.getHosphuanxinaccount(), password);
				if (registerResult) {
					return DataResult.success("修改成功");
				} else {
					return DataResult.error("修改失败");
				}
			}
		}
		// 修改密码
		@Override
		public String updatePassword(String hosploginphone, String hosploginpwd,String msgCode) throws Exception {
			boolean msgResult = MsgCode.checkMsg(hosploginphone, msgCode);
			if (!msgResult) {
				return DataResult.error("验证码错误");
			}
			Hosplogininfo hosplogininforecord = new Hosplogininfo();
			Hosplogininfo hosplogininfo = hosplogininfoMapperCustom.selectByHospLoginPhone(hosploginphone);
			if (hosplogininfo == null) {
				return DataResult.error("号码未注册");
			}
			hosplogininforecord.setHosploginid(hosplogininfo.getHosploginid());
			String[] str = MD5Util.generate(hosploginpwd);
			hosplogininforecord.setHosploginpwd(str[0]);
			hosplogininforecord.setHosploginsalt(str[1]);
			boolean result = hosplogininfoMapper.updateByPrimaryKeySelective(hosplogininforecord) > 0;
			if (result) {
				editHuanXinPassword(hosplogininfo.getHosploginid(),hosploginpwd);
				return DataResult.success("修改成功");
			} else {
				return DataResult.error("修改失败");
			}

		}
		
		//退出登录
		@Override
		public String updateAccountToExit(Integer hosploginid) throws Exception {
			Hosplogininfo list = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
			if (list != null) {
				TokeManager.deleteToken(list.getHosplogintoken());
				return DataResult.success("退出登录成功");
			} else {
				return DataResult.error("该用户不存在");
			}
		}
}
