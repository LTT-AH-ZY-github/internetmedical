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
import com.medical.exception.custom.MyException;
import com.medical.exception.custom.TokenException;
import com.medical.exception.custom.UpdatePasswordException;
import com.medical.exception.custom.UserLoginException;
import com.medical.interceptor.MapTokenManager;
import com.medical.interceptor.TokenModel;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserlogMapper;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.po.Userinfo;
import com.medical.po.Userlog;
import com.medical.po.Userlogininfo;
import com.medical.po.UserlogininfoCustom;
import com.medical.service.UserService;
import com.medical.service.iface.user.UserAccountService;
import com.medical.utils.Global;
import com.medical.utils.MD5Util;
import com.medical.utils.TokeManager;
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
	private DoctorlogininfoMapperCustom doctorlogininfoMapperCustom;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private UserlogMapper userlogMapper;

	Logger logger = Logger.getLogger(UserAccountService.class);

	// 用户注册
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean createUserAccount(String phone, String password) throws Exception {
		// 用户登录信息
		Userlogininfo userlogininfo = new Userlogininfo();
		userlogininfo.setUserloginphone(phone);
		String[] str = MD5Util.generate(password);
		// md5值密码
		userlogininfo.setUserloginpwd(str[0]);
		// salt值
		userlogininfo.setUserloginsalt(str[1]);
		userlogininfo.setUserlogintype(false);
		userlogininfo.setUserloginpix("1.jpg");
		String phoneNumber = phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
		userlogininfo.setUserloginname(phoneNumber);
		// 写入用户登录表
		int result = userlogininfoMapperCustom.insertSelectiveReturnId(userlogininfo);
		Userinfo userinfo = new Userinfo();
		userinfo.setUserloginid(userlogininfo.getUserloginid());
		userinfo.setUserphone(phone);
		// 用户信息表
		int infoResult = userinfoMapper.insertSelective(userinfo);
		
		if (result > 0 && infoResult > 0) {
			addHuanXinAccout(userlogininfo.getUserloginid(),password);
			return true;
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return false;
		}
	}

	// 用户登录
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Map<String, Object> updateUserToLogin(String userloginphone, String userloginpwd, String userlogintoken)
			throws Exception {
		Map<String, Object> map = new HashMap<>(16);
		Userlogininfo userlogininfo = new Userlogininfo();
		// 用户日志表
		Userlog userlog = new Userlog();
		userlog.setUserlogtime(new Date());
		UserlogininfoCustom user = userlogininfoMapperCustom.findUserLoginInfoByPhone(userloginphone);
		// 该号码已注册
		if (user != null) {
			// 用户名密码验证成功
			boolean state = MD5Util.verify(userloginpwd, user.getUserloginsalt(), user.getUserloginpwd());

			if (state) {
				// 用户登录id
				userlog.setUserloginid(user.getUserloginid());
				userlogininfo.setUserloginid(user.getUserloginid());
				// 没有token重新登录
				if (userlogintoken == null) {
					String token = TokeManager.createToken(user.getUserloginid(), userloginphone);
					long expireTime = (long) Global.globalToken.get(token);
					userlogininfo.setUserlogintoken(token);
					userlogininfo.setUserlogindld(expireTime);
					// 更新登录信息
					int upResult = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfo);
					// 生成登录日志
					int inResult = userlogMapper.insertSelective(userlog);
					if (upResult > 0 && inResult > 0) {
						map.put("token", token);
						map.put("username", user.getUserloginname());
						map.put("pix", user.getUserloginpix());
						map.put("type", user.getUserlogintype());
						map.put("id", user.getUserloginid());
					} else {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						throw new UserLoginException("登录失败");
					}
				} else { // 有token 自动登录
					boolean result = TokeManager.isTokenEnable(userlogintoken);
					if (result) {
						long expireTime = TokeManager.addTokenTime(userlogintoken);
						userlogininfo.setUserlogindld(expireTime);
						// 更新登录信息
						int upResult = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfo);
						// 生成登录日志
						int inResult = userlogMapper.insertSelective(userlog);
						if (upResult > 0 && inResult > 0) {
							map.put("token", userlogintoken);
							map.put("username", user.getUserloginname());
							map.put("pix", user.getUserloginpix());
							map.put("type", user.getUserlogintype());
							map.put("id", user.getUserloginid());
						} else {
							// 登录失败
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							throw new UserLoginException("自动登录失败");
						}
					} else {
						throw new UserLoginException("token已过期");
					}

				}
			} else {
				throw new UserLoginException("用户账号密码不匹配");
			}

		} else {
			throw new UserLoginException(" 该号码未注册");

		}

		return map;
	}

	// 用户退出登录
	@Override
	public boolean updateUserToExit(Integer userloginid) throws Exception {
		Userlogininfo list = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (list != null) {
			TokeManager.deleteToken(list.getUserlogintoken());
			return true;
		} else {
			throw new TokenException("该用户不存在");
		}
	}

	// 修改密码
	@Override
	public boolean updatePassword(String phone, String password) throws Exception {
		UserlogininfoCustom userlogininfoCustom = new UserlogininfoCustom();
		UserlogininfoCustom list = userlogininfoMapperCustom.findUserLoginInfoByPhone(phone);
		if (list != null) {
			userlogininfoCustom.setUserloginid(list.getUserloginid());
			String[] str = MD5Util.generate(password);
			// md5值密码
			userlogininfoCustom.setUserloginpwd(str[0]);
			// salt值
			userlogininfoCustom.setUserloginsalt(str[1]);
			return userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoCustom) > 0;
		} else {
			throw new UpdatePasswordException("该号码未注册");
		}
	}

	// 注册环信
	@Override
	public boolean addHuanXinAccout(Integer userloginid,String password) throws Exception {
		return UserManger.register("user_"+userloginid, password);
	}

}
