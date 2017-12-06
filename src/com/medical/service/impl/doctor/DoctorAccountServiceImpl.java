package com.medical.service.impl.doctor;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.huanxin.utils.UserManger;
import com.medical.mapper.AccounttypeMapper;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogMapper;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.DoctorskdMapper;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.po.Accounttype;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlog;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Doctorskd;
import com.medical.service.iface.doctor.DoctorAccountService;
import com.medical.utils.Global;
import com.medical.utils.MD5Util;
import com.medical.utils.TokeManager;
import com.medical.utils.result.DataResult;
import com.netease.code.MsgCode;
@Service
public class DoctorAccountServiceImpl implements DoctorAccountService {
	
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapperCustom doctorlogininfoMapperCustom;
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private DoctorlogMapper doctorlogMapper;
	@Autowired
	private DoctorskdMapper doctorskdMapper;
	@Autowired
	private AccounttypeMapper accounttypeMapper;
	@Autowired
	private UserlogininfoMapperCustom userlogininfoMapperCustom;
	
	// 查找账号是否注册
	@Override
	public String findAccountExit(String phone) throws Exception{
		// 查询医生登录表
		int doctorCount = doctorlogininfoMapperCustom.findDocCountByPhone(phone);
		if (doctorCount > 0) {
			return DataResult.error("该号码已注册");
		} else {
			return DataResult.success("该号码未注册");
		}
	}
	
	// 注册
	@Override
	public String createDoctor(String docloginphone, String magCode, String docLoginPwd) throws Exception {
		boolean msgResult = MsgCode.checkMsg(docloginphone, magCode);
		if (!msgResult) {
			return DataResult.error("验证码错误");
		}
		// 查询医生登录表
	   int doctorCount = doctorlogininfoMapperCustom.findDocCountByPhone(docloginphone);
	   // 查询病人登录表
	  // int userCount = userlogininfoMapperCustom.findUserCountByPhone(docloginphone);
	   if (doctorCount>0 ) {
			return DataResult.error("该号码已注册");
		}
		Doctorlogininfo doctorlogininfo = new Doctorlogininfo();
	
		doctorlogininfo.setDocloginphone(docloginphone);
		doctorlogininfo.setDocloginname(docloginphone);
		String[] str = MD5Util.generate(docLoginPwd);
		// md5值密码
		doctorlogininfo.setDocloginpwd(str[0]);
		// salt值
		doctorlogininfo.setDocloginsalt(str[1]);
		// 未审核用户
		doctorlogininfo.setDoclogintype(1);
		doctorlogininfo.setDocloginpix("http://oytv6cmyw.bkt.clouddn.com/20171103064014944735.jpg");
		// 插入登录信息表
		int result = doctorlogininfoMapperCustom.insertSelectiveReturnId(doctorlogininfo);
		Doctorinfo doctorinfo = new Doctorinfo();
		doctorinfo.setDocloginid(doctorlogininfo.getDocloginid());
		// 创建信息表
		int infoResult = doctorinfoMapper.insertSelective(doctorinfo);
		// 操作成功
		if (result > 0 && infoResult > 0 ) {
			addHuanXinAccout(doctorlogininfo.getDocloginid(), docLoginPwd);
			return DataResult.success("注册成功");
		} else {
			// 操作失败，回滚
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("注册失败");
		}

	}

	// 普通登录
	@Override
	public String updateDoctorToNormalLogin(Doctorlogininfo doctor) throws Exception {

		// 登录信息
		Doctorlogininfo logininfoRecord = new Doctorlogininfo();
		logininfoRecord.setDocloginip(doctor.getDocloginip());
		logininfoRecord.setDocloginpver(doctor.getDocloginpver());
		logininfoRecord.setDocloginloc(doctor.getDocloginloc());
		logininfoRecord.setDocloginlat(doctor.getDocloginlat());
		logininfoRecord.setDocloginlon(doctor.getDocloginlon());
		logininfoRecord.setDocloginmac(doctor.getDocloginmac());
		logininfoRecord.setDoclogintime(new Date());
		logininfoRecord.setDoclogindev(doctor.getDoclogindev());
		logininfoRecord.setDocloginphone(doctor.getDocloginphone());

		// 登录日志信息
		Doctorlog logRecord = new Doctorlog();
		logRecord.setDoclogip(doctor.getDocloginip());
		logRecord.setDoclogtime(new Date());
		logRecord.setDocloglat(doctor.getDocloginlat());
		logRecord.setDocloglon(doctor.getDocloginlon());
		logRecord.setDoclogmac(doctor.getDocloginmac());
		logRecord.setDoclogmodel(doctor.getDocloginmodel());
		logRecord.setDoclogpver(doctor.getDocloginpver());
		logRecord.setDoclogdev(doctor.getDoclogindev());

		// 检查账号密码是否正确
		Doctorlogininfo doctorinfo = doctorlogininfoMapperCustom.selectDoctorByPhone(doctor.getDocloginphone());
		if (doctorinfo == null) {
			return DataResult.error("该号码未注册");
		}
		boolean state = MD5Util.verify(doctor.getDocloginpwd(), doctorinfo.getDocloginsalt(),
				doctorinfo.getDocloginpwd());
		if (!state) {
			return DataResult.error("密码错误");
		} else {
			// 医生登录id
			logininfoRecord.setDocloginid(doctorinfo.getDocloginid());
			logRecord.setDocloginid(doctorinfo.getDocloginid());
			String token = TokeManager.createToken(doctorinfo.getDocloginid(), doctorinfo.getDocloginphone());
			long expireTime = (long) Global.globalToken.get(token);
			logininfoRecord.setDoclogintoken(token);
			logininfoRecord.setDoclogindld(expireTime);
			// 更新登录信息
			int upResult = doctorlogininfoMapper.updateByPrimaryKeySelective(logininfoRecord);
			// 生成登录日志
			int inResult = doctorlogMapper.insertSelective(logRecord);
			Doctorinfo info = doctorinfoMapperCustom.selectByDocLoginId(doctorinfo.getDocloginid());
			Accounttype accounttype = accounttypeMapper.selectByPrimaryKey(doctorinfo.getDoclogintype());
			String typename = "";
			if (accounttype != null) {
				typename = accounttype.getAccounttypename();
			}
			if (upResult == 1 && inResult == 1) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("token", token);
				map.put("id", doctorinfo.getDocloginid());
				map.put("pix", doctorinfo.getDocloginpix());
				map.put("name", info.getDocname());
				map.put("title", info.getDoctitle());
				map.put("type", doctorinfo.getDoclogintype());
				map.put("typename", typename);
				map.put("huanxinaccount", doctorinfo.getDochuanxinaccount());
				return DataResult.success("登录成功", map);
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("登录失败");
			}
		}

	}

	// 自动登录
	@Override
	public String updateDoctorToAutoLogin(Doctorlogininfo doctor) throws Exception {
		// 登录信息
		Doctorlogininfo logininfoRecord = new Doctorlogininfo();
		logininfoRecord.setDocloginip(doctor.getDocloginip());
		logininfoRecord.setDocloginpver(doctor.getDocloginpver());
		logininfoRecord.setDocloginloc(doctor.getDocloginloc());
		logininfoRecord.setDocloginlat(doctor.getDocloginlat());
		logininfoRecord.setDocloginlon(doctor.getDocloginlon());
		logininfoRecord.setDocloginmac(doctor.getDocloginmac());
		logininfoRecord.setDoclogindev(doctor.getDoclogindev());
		logininfoRecord.setDoclogintime(new Date());
		logininfoRecord.setDocloginphone(doctor.getDocloginphone());
		// 登录日志信息
		Doctorlog logRecord = new Doctorlog();
		logRecord.setDoclogip(doctor.getDocloginip());
		logRecord.setDoclogtime(new Date());
		logRecord.setDocloglat(doctor.getDocloginlat());
		logRecord.setDocloglon(doctor.getDocloginlon());
		logRecord.setDoclogmac(doctor.getDocloginmac());
		logRecord.setDoclogmodel(doctor.getDocloginmodel());
		logRecord.setDoclogpver(doctor.getDocloginpver());
		logRecord.setDoclogdev(doctor.getDoclogindev());
		// 检查账号密码是否正确
		Doctorlogininfo doctorinfo = doctorlogininfoMapperCustom.selectDoctorByPhone(doctor.getDocloginphone());
		if (doctorinfo == null) {
			return DataResult.error("该号码未注册");
		} // 登录成功
		boolean state = MD5Util.verify(doctor.getDocloginpwd(), doctorinfo.getDocloginsalt(),
				doctorinfo.getDocloginpwd());
		if (!state) {
			return DataResult.error("密码错误");
		}
		// 医生登录id
		logininfoRecord.setDocloginid(doctorinfo.getDocloginid());
		logRecord.setDocloginid(doctorinfo.getDocloginid());
		String doctorlogintoken = doctor.getDoclogintoken();
		boolean result = TokeManager.isTokenEnable(doctorlogintoken);
		if (result) {
			long expireTime = TokeManager.addTokenTime(doctorlogintoken);
			logininfoRecord.setDoclogindld(expireTime);
			// 更新登录信息
			int upResult = doctorlogininfoMapper.updateByPrimaryKeySelective(logininfoRecord);
			// 生成登录日志
			int inResult = doctorlogMapper.insertSelective(logRecord);
			Doctorinfo info = doctorinfoMapperCustom.selectByDocLoginId(doctorinfo.getDocloginid());
			Accounttype accounttype = accounttypeMapper.selectByPrimaryKey(doctorinfo.getDoclogintype());
			String typename = "";
			if (accounttype != null) {
				typename = accounttype.getAccounttypename();
			}
			if (upResult == 1 && inResult == 1) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", doctorinfo.getDocloginid());
				map.put("token", doctorlogintoken);
				map.put("pix", doctorinfo.getDocloginpix());
				map.put("name", info.getDocname());
				map.put("title", info.getDoctitle());
				map.put("type", doctorinfo.getDoclogintype());
				map.put("typename", typename);
				map.put("huanxinaccount", doctorinfo.getDochuanxinaccount());
				return DataResult.success("自动登录成功", map);
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("自动登录失败");
			}
		} else {
			return DataResult.error("账号过期");
		}
	}
	
	
	
	// 注册环信
	@Override
	public boolean addHuanXinAccout(Integer docloginid, String password) throws Exception {
		boolean registerResult =  UserManger.register("doc_" + docloginid, password);
		if (registerResult) {
			Doctorlogininfo doctorlogininfo = new Doctorlogininfo();
			doctorlogininfo.setDocloginid(docloginid);
			doctorlogininfo.setDochuanxinaccount("doc_" + docloginid);
			doctorlogininfoMapper.updateByPrimaryKeySelective(doctorlogininfo);
			return true;
			
		} else {
			return false;
		}

	}

	// 修改环信密码
	@Override
	public String editHuanXinPassword(Integer docloginid, String password) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("账号不存在");
		} else {
			boolean registerResult = UserManger.register(doctorlogininfo.getDochuanxinaccount(), password);
			if (registerResult) {
				return DataResult.success("修改成功");
			} else {
				return DataResult.error("修改失败");
			}
		}
	}
	// 修改密码
	@Override
	public String updatePassword(String docloginphone, String docloginpwd,String msgCode) throws Exception {
		boolean msgResult = MsgCode.checkMsg(docloginphone, msgCode);
		if (!msgResult) {
			return DataResult.error("验证码错误");
		}
		Doctorlogininfo doctorlogininfo = new Doctorlogininfo();
		Doctorlogininfo logininfo = doctorlogininfoMapperCustom.selectDoctorByPhone(docloginphone);
		if (logininfo == null) {
			return DataResult.error("号码未注册");
		}
		doctorlogininfo.setDocloginid(logininfo.getDocloginid());
		String[] str = MD5Util.generate(docloginpwd);
		doctorlogininfo.setDocloginpwd(str[0]);
		doctorlogininfo.setDocloginsalt(str[1]);
		boolean result = doctorlogininfoMapper.updateByPrimaryKeySelective(doctorlogininfo) > 0;
		if (result) {
			editHuanXinPassword(logininfo.getDocloginid(),docloginpwd);
			return DataResult.success("修改成功");
		} else {
			return DataResult.error("修改失败");
		}

	}
	
	//退出登录
	@Override
	public String updateAccountToExit(Integer docloginid) throws Exception {
		Doctorlogininfo list = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (list != null) {
			TokeManager.deleteToken(list.getDoclogintoken());
			return DataResult.success("退出登录成功");
		} else {
			return DataResult.error("该用户不存在");
		}
	}
	
	
}
