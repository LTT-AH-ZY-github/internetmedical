package com.medical.service.impl.doctor;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.huanxin.utils.UserManger;
import com.medical.interceptor.MapTokenManager;
import com.medical.interceptor.TokenModel;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogMapper;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.DoctorskdMapper;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlog;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Doctorskd;
import com.medical.service.iface.doctor.DoctorAccountService;
import com.medical.utils.MD5Util;
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
	
	// 注册
	@Override
	public int createDoctor(String docLoginPhone, String magCode, String docLoginPwd) throws Exception {

		/* if (MsgCode.checkMsg(docLoginPhone, magCode)) { */
		if (true) {
			int count = doctorlogininfoMapperCustom.findDocCountByPhone(docLoginPhone);
			// 判断是否注册过
			if (count == 0) { // 未注册
				Doctorlogininfo doctorLogininfo = new Doctorlogininfo();
				doctorLogininfo.setDocloginphone(docLoginPhone);
				doctorLogininfo.setDocloginname(docLoginPhone);
				String[] str = MD5Util.generate(docLoginPwd);
				// md5值密码
				doctorLogininfo.setDocloginpwd(str[0]);
				// salt值
				doctorLogininfo.setDocloginsalt(str[1]);
				// 未审核用户
				doctorLogininfo.setDoclogintype(false);
				doctorLogininfo.setDocloginpix("1.jpg");
				// 插入登录信息表
				int result = doctorlogininfoMapperCustom.insertSelectiveReturnId(doctorLogininfo);
				Doctorinfo doctorinfo = new Doctorinfo();
				doctorinfo.setDocloginid(doctorLogininfo.getDocloginid());
				// 创建信息表
				int infoResult = doctorinfoMapper.insertSelective(doctorinfo);
				// 创建日程表
				Doctorskd doctorskd = new Doctorskd();
				doctorskd.setDocloginid(doctorLogininfo.getDocloginid());
				int skdResult = doctorskdMapper.insertSelective(doctorskd);
				// 操作成功
				if (result > 0 && infoResult > 0 && skdResult > 0) {
					addHuanXinAccout(doctorLogininfo.getDocloginid(), docLoginPwd);
					return 1;
				} else {

					// 操作失败，回滚
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return 2;
				}
			} else {
				// 该号码已经注册过
				return 3;
			}

		} else {
			return 4;
		}

	}

	// 登录
	@Override
	public Map<String, Object> updateDoctorToLogin(Doctorlogininfo doctor) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MapTokenManager mapTokenManager = new MapTokenManager();
			// 登录信息
			Doctorlogininfo doctorlogininfo = new Doctorlogininfo();
			doctorlogininfo.setDocloginip(doctor.getDocloginip());
			doctorlogininfo.setDocloginpver(doctor.getDocloginpver());
			doctorlogininfo.setDocloginloc(doctor.getDocloginloc());
			doctorlogininfo.setDocloginlat(doctor.getDocloginlat());
			doctorlogininfo.setDocloginlon(doctor.getDocloginlon());
			doctorlogininfo.setDocloginmac(doctor.getDocloginmac());
			doctorlogininfo.setDoclogintime(new Date());
			doctorlogininfo.setDocloginphone(doctor.getDocloginphone());
			// doctorlogininfo.setDocloginpwd(doctor.getDocloginpwd());
			// 登录日志信息
			Doctorlog doctorlog = new Doctorlog();
			doctorlog.setDoclogip(doctorlogininfo.getDocloginip());
			doctorlog.setDoclogtime(new Date());
			doctorlog.setDocloglat(doctorlogininfo.getDocloginlat());
			doctorlog.setDocloglon(doctorlogininfo.getDocloginlon());
			doctorlog.setDoclogmac(doctorlogininfo.getDocloginmac());
			doctorlog.setDoclogmodel(doctorlogininfo.getDocloginmodel());
			doctorlog.setDoclogpver(doctorlogininfo.getDocloginpver());
			// 检查账号密码是否正确
			Doctorlogininfo doctorinfo = doctorlogininfoMapperCustom
					.selectDoctorByPhone(doctorlogininfo.getDocloginphone());
			if (doctorinfo != null) { // 登录成功
				boolean state = MD5Util.verify(doctor.getDocloginpwd(), doctorinfo.getDocloginsalt(),
						doctorinfo.getDocloginpwd());
				System.out.println("密码" + state);
				if (state) {
					// 医生登录id
					doctorlogininfo.setDocloginid(doctorinfo.getDocloginid());
					doctorlog.setDocloginid(doctorinfo.getDocloginid());
					// 获取登录Id
					String acceptedToken = doctorlogininfo.getDoclogintoken();
					if (acceptedToken == null) { // 没有token重新登录
						TokenModel tokenModel = mapTokenManager.createToken(doctorlogininfo.getDocloginphone(),
								mapTokenManager.setTokenTime(new Date().getTime(), 30)); // token 过期时间 30天
						doctorlogininfo.setDoclogintoken(tokenModel.getToken());
						doctorlogininfo.setDoclogindld(tokenModel.getTime());
						// 更新登录信息

						int upResult = doctorlogininfoMapper.updateByPrimaryKeySelective(doctorlogininfo);// 更新登录信息
						int inResult = doctorlogMapper.insertSelective(doctorlog);// 生成登录日志
						Map<String, Object> info = doctorinfoMapperCustom
								.selectNameAndTitleByDocLoginId(doctorinfo.getDocloginid());
						if (upResult == 1 && inResult == 1) {
							map.put("state", "1"); // 操作成功
							map.put("token", tokenModel.getToken());
							map.put("id", doctorinfo.getDocloginid());
							map.put("pix", doctorinfo.getDocloginpix());
							map.put("name", info.get("docname"));
							map.put("title", info.get("doctitlename"));
							map.put("type", doctorinfo.getDoclogintype());
						} else {
							map.put("state", "2"); // 操作失败
						}

					} else { // 有token 自动登录
						int result = mapTokenManager.checkToken(acceptedToken);
						if (result == 1) {
							map.put("state", "3");// 当前token不存在
						} else if (result == 2) {
							map.put("state", "4");// token已过期
						} else if (result == 3) {
							long time = mapTokenManager.addTokenTime(acceptedToken, 30); // token延期30天
							doctorlogininfo.setDoclogindld(time);

							int upResult = doctorlogininfoMapper.updateByPrimaryKeySelective(doctorlogininfo);// 更新登录信息
							int inResult = doctorlogMapper.insertSelective(doctorlog);// 生成登录日志
							Map<String, Object> info = doctorinfoMapperCustom
									.selectNameAndTitleByDocLoginId(doctorinfo.getDocloginid());
							if (upResult == 1 && inResult == 1) {
								map.put("state", "5"); // 操作成功
								map.put("id", doctorinfo.getDocloginid());
								map.put("token", acceptedToken);
								map.put("pix", doctorinfo.getDocloginpix());
								map.put("name", info.get("docname"));
								map.put("title", info.get("doctitlename"));
								map.put("type", doctorinfo.getDoclogintype());
							} else {
								map.put("state", "6"); // 操作失败
							}

						}
					}
				} else {
					map.put("state", "7"); // 用户名密码不匹配
				}

			} else {
				map.put("state", "8"); // 该号码未注册
			}
		} catch (Exception e) {
			map.put("state", "9"); // 异常错误
		}

		return map;

	}
	
	@Override
	public int updateChannelId(Integer docloginid, String channelid) {
		
			Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
			if (doctorlogininfo != null) {
				Doctorlogininfo record = new Doctorlogininfo();
				record.setDocloginid(docloginid);
				record.setDocloginchannelid(channelid);
				int result = doctorlogininfoMapper.updateByPrimaryKeySelective(record);
				if (result>0) {
					return 1;
				} else {
					return 2;
				}
				
			}else {
				return 3;
			}
		
		
	}
	
	// 注册环信
	@Override
	public boolean addHuanXinAccout(Integer docloginid, String password) throws Exception {
		return UserManger.register("doc_" + docloginid, password);

	}
}
