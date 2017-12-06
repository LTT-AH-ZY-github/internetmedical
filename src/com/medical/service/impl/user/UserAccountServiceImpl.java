package com.medical.service.impl.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.huanxin.utils.UserManger;
import com.medical.mapper.AccounttypeMapper;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserlogMapper;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.po.Accounttype;
import com.medical.po.Userinfo;
import com.medical.po.Userlog;
import com.medical.po.Userlogininfo;
import com.medical.po.UserlogininfoCustom;
import com.medical.service.iface.user.UserAccountService;
import com.medical.utils.Global;
import com.medical.utils.MD5Util;
import com.medical.utils.TokeManager;
import com.medical.utils.result.DataResult;
import com.netease.code.MsgCode;

/**
 * 用户账号
 * 
 * @ClassName: UserAccountServiceImpl
 * @Description: TODO
 * @author: xyh
 * @date: 2017年7月31日 下午4:38:41
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserlogininfoMapperCustom userlogininfoMapperCustom;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private UserlogMapper userlogMapper;
	@Autowired
	private AccounttypeMapper accounttypeMapper;

	Logger logger = Logger.getLogger(UserAccountService.class);

	// 查找账号是否注册
	@Override
	public String findAccountExit(String phone) {
		// 查询病人登录表
		int userCount = userlogininfoMapperCustom.findUserCountByPhone(phone);
		if (userCount > 0) {
			return DataResult.error("该号码已注册");

		} else {
			return DataResult.success("该号码未注册");
		}
	}

	// 用户注册
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String createUserAccount(String phone, String password, String code) throws Exception {
		boolean msgResult = MsgCode.checkMsg(phone, code);
		if (!msgResult) {
			return DataResult.error("验证码错误");
		}
		// 查询医生登录表
		// int doctorCount = doctorlogininfoMapperCustom.findDocCountByPhone(phone);
		// 查询病人登录表
		int userCount = userlogininfoMapperCustom.findUserCountByPhone(phone);
		if (userCount > 0) {
			return DataResult.error("该号码已注册");
		}
		// 用户登录信息
		Userlogininfo userlogininfoRecord = new Userlogininfo();
		userlogininfoRecord.setUserloginphone(phone);
		String[] str = MD5Util.generate(password);
		// md5值密码
		userlogininfoRecord.setUserloginpwd(str[0]);
		// salt值
		userlogininfoRecord.setUserloginsalt(str[1]);
		// 1为未审核
		userlogininfoRecord.setUserlogintype(1);
		// 默认头像
		userlogininfoRecord.setUserloginpix("http://oytv6cmyw.bkt.clouddn.com/20171103064014944735.jpg");
		String phoneNumber = phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
		userlogininfoRecord.setUserloginname(phoneNumber);
		// 写入用户登录表
		int result = userlogininfoMapperCustom.insertSelectiveReturnId(userlogininfoRecord);
		Userinfo userinfoRecord = new Userinfo();
		userinfoRecord.setUserloginid(userlogininfoRecord.getUserloginid());
		userinfoRecord.setUserphone(phone);
		// 用户信息表
		int infoResult = userinfoMapper.insertSelective(userinfoRecord);

		if (result > 0 && infoResult > 0) {
			addHuanXinAccout(userlogininfoRecord.getUserloginid(), password);
			return DataResult.success("注册成功");
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("注册失败");
		}
	}

	// 普通登录
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateUserToNormalLogin(String userloginphone, String userloginpwd, Integer userlogindev)
			throws Exception {
		Map<String, Object> map = new HashMap<>(16);
		Userlogininfo userlogininfoReocrd = new Userlogininfo();
		// 登录设备
		userlogininfoReocrd.setUserlogindev(userlogindev);
		userlogininfoReocrd.setUserlogintime(new Date());
		// 用户日志表
		Userlog userlogRecord = new Userlog();
		userlogRecord.setUserlogtime(new Date());
		userlogRecord.setUserlogdev(userlogindev);
		UserlogininfoCustom user = userlogininfoMapperCustom.findUserLoginInfoByPhone(userloginphone);
		if (user == null) {
			return DataResult.error("该号码未注册");
		}
		// 用户名密码验证成功
		boolean state = MD5Util.verify(userloginpwd, user.getUserloginsalt(), user.getUserloginpwd());
		if (!state) {
			return DataResult.error("密码错误");
		}
		// 用户登录id
		userlogRecord.setUserloginid(user.getUserloginid());
		userlogininfoReocrd.setUserloginid(user.getUserloginid());
		// 没有token重新登录
		String token = TokeManager.createToken(user.getUserloginid(), userloginphone);
		long expireTime = (long) Global.globalToken.get(token);
		userlogininfoReocrd.setUserlogintoken(token);
		userlogininfoReocrd.setUserlogindld(expireTime);
		// 更新登录信息
		int upResult = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoReocrd);
		Accounttype accounttype = accounttypeMapper.selectByPrimaryKey(user.getUserlogintype());
		String typename = "";
		if (accounttype != null) {
			typename = accounttype.getAccounttypename();
		}
		// 生成登录日志
		int inResult = userlogMapper.insertSelective(userlogRecord);
		if (upResult > 0 && inResult > 0) {
			map.put("token", token);
			map.put("username", user.getUserloginname());
			map.put("pix", user.getUserloginpix());
			map.put("type", user.getUserlogintype());
			map.put("typename", typename);
			map.put("id", user.getUserloginid());
			map.put("huanxinaccount", user.getUserhuanxinaccount());
			return DataResult.success("登录成功", map);
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("登录失败");
		}
	}

	// 自动登录
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateUserToAutoLogin(String userloginphone, String userloginpwd, String userlogintoken,
			Integer userlogindev) throws Exception {
		Map<String, Object> map = new HashMap<>(16);
		Userlogininfo userlogininfoRecord = new Userlogininfo();
		userlogininfoRecord.setUserlogindev(userlogindev);
		userlogininfoRecord.setUserlogintime(new Date());
		// 用户日志表
		Userlog userlogRecord = new Userlog();
		userlogRecord.setUserlogtime(new Date());
		userlogRecord.setUserlogdev(userlogindev);
		UserlogininfoCustom user = userlogininfoMapperCustom.findUserLoginInfoByPhone(userloginphone);
		if (user == null) {
			return DataResult.error("该号码未注册");
		}
		// 用户名密码验证成功
		boolean state = MD5Util.verify(userloginpwd, user.getUserloginsalt(), user.getUserloginpwd());
		if (!state) {
			return DataResult.error("密码错误");
		}
		// 用户登录id
		userlogRecord.setUserloginid(user.getUserloginid());
		userlogininfoRecord.setUserloginid(user.getUserloginid());
		boolean result = TokeManager.isTokenEnable(userlogintoken);
		if (result) {
			long expireTime = TokeManager.addTokenTime(userlogintoken);
			userlogininfoRecord.setUserlogindld(expireTime);
			// 更新登录信息
			int upResult = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoRecord);
			// 生成登录日志
			int inResult = userlogMapper.insertSelective(userlogRecord);
			Accounttype accounttype = accounttypeMapper.selectByPrimaryKey(user.getUserlogintype());
			String typename = "";
			if (accounttype != null) {
				typename = accounttype.getAccounttypename();
			}
			if (upResult > 0 && inResult > 0) {
				map.put("token", userlogintoken);
				map.put("username", user.getUserloginname());
				map.put("pix", user.getUserloginpix());
				map.put("type", user.getUserlogintype());
				map.put("typename", typename);
				map.put("id", user.getUserloginid());
				map.put("huanxinaccount", user.getUserhuanxinaccount());
				return DataResult.success("自动登录成功", map);
			} else {
				// 登录失败
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("自动登录失败");
			}
		} else {
			return DataResult.error("token已过期");
		}

	}

	// 用户退出登录
	@Override
	public String updateUserToExit(Integer userloginid) throws Exception {
		Userlogininfo list = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (list != null) {
			TokeManager.deleteToken(list.getUserlogintoken());
			return DataResult.success("退出登录成功");
		} else {
			return DataResult.error("该用户不存在");
		}
	}

	// 修改密码
	@Override
	public String updatePassword(String phone, String password, String code) throws Exception {
		boolean msgResult = MsgCode.checkMsg(phone, code);
		if (!msgResult) {
			return DataResult.error("验证码错误");
		}
		Userlogininfo userlogininfoRecord = new UserlogininfoCustom();
		UserlogininfoCustom list = userlogininfoMapperCustom.findUserLoginInfoByPhone(phone);
		if (list == null) {
			return DataResult.error("该号码未注册");
		}
		userlogininfoRecord.setUserloginid(list.getUserloginid());
		String[] str = MD5Util.generate(password);
		// md5值密码
		userlogininfoRecord.setUserloginpwd(str[0]);
		// salt值
		userlogininfoRecord.setUserloginsalt(str[1]);
		boolean result = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoRecord) > 0;
		if (result) {
			editHuanXinPassword(list.getUserloginid(), password);
			return DataResult.success("修改成功");
		} else {
			return DataResult.error("修改失败");
		}

	}

	// 注册环信
	@Override
	public String addHuanXinAccout(Integer userloginid, String password) throws Exception {
		boolean registerResult = UserManger.register("user_" + userloginid, password);
		if (registerResult) {
			Userlogininfo userlogininfo = new Userlogininfo();
			userlogininfo.setUserloginid(userloginid);
			userlogininfo.setUserhuanxinaccount("user_" + userloginid);
			userlogininfoMapper.updateByPrimaryKeySelective(userlogininfo);
			return DataResult.success("注册成功");
		} else {
			return DataResult.success("已注册");
		}
	}

	// 修改环信密码
	@Override
	public String editHuanXinPassword(Integer userloginid, String password) throws Exception {
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (userlogininfo == null) {
			return DataResult.error("账号不存在");
		} else {
			boolean registerResult = UserManger.updatePassword(userlogininfo.getUserhuanxinaccount(), password);
			if (registerResult) {
				return DataResult.success("修改成功");
			} else {
				return DataResult.error("修改失败");
			}
		}
	}
}
