package com.medical.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.MacSpi;

import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.taglibs.standard.lang.jstl.LessThanOperator;
import org.eclipse.jdt.internal.compiler.tool.EclipseCompiler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.sql.dialect.mysql.ast.MysqlForeignKey.On;
import com.baidu.yun.push.utils.PushToAndroid;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.controller.DoctorController;
import com.medical.interceptor.MapTokenManager;
import com.medical.interceptor.TokenModel;
import com.medical.mapper.CityMapperCustom;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogMapper;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.DoctorskdMapper;
import com.medical.mapper.DoctorskdMapperCustom;
import com.medical.mapper.DoctortitleMapper;
import com.medical.mapper.FamilyinfoMapper;
import com.medical.mapper.FamilyinfoMapperCustom;
import com.medical.mapper.HospitaldeptMapper;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogMapper;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.City;
import com.medical.po.DoctorCustom;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorinfo;
import com.medical.po.DoctorinfoCustom;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Doctorskd;
import com.medical.po.Doctortitle;
import com.medical.po.Hospitaldept;
import com.medical.po.Preorder;
import com.medical.po.SickSearch;
import com.medical.po.Userlogininfo;
import com.medical.po.UserlogininfoCustom;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.po.Doctorlog;

import com.medical.service.DoctorService;
import com.medical.service.UserService;
import com.medical.utils.CommonUtils;
import com.medical.utils.CreateFileUtil;
import com.medical.utils.MD5Util;
import com.netease.code.MsgCode;
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

import javafx.scene.layout.AnchorPane;
import sun.net.www.content.text.plain;

public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private DoctorlogininfoMapperCustom doctorlogininfoMapperCustom;
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private DoctorlogMapper doctorlogMapper;
	@Autowired
	private DoctorskdMapper doctorskdMapper;
	@Autowired
	private DoctorskdMapperCustom doctorskdMapperCustom;
	@Autowired
	private PreorderMapper preorderMapper;
	@Autowired
	private UserorderMapper userorderMapper;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private UserlogininfoMapperCustom userlogininfoMapperCustom;
	@Autowired
	private UserlogMapper userlogMapper;
	@Autowired
	private FamilyinfoMapper familyinfoMapper;
	@Autowired
	private FamilyinfoMapperCustom familyinfoMapperCustom;
	@Autowired
	private CityMapperCustom cityMapperCustom;
	@Autowired
	private UsersickMapper usersickMapper; 
	@Autowired
	private UsersickMapperCustom usersickMapperCustom; 
    @Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private UserorderMapperCustom userorderMapperCustom;
	@Autowired
	private HospitaldeptMapper hospitaldeptMapper;
	@Autowired
	private DoctortitleMapper doctortitleMapper;
	@Autowired
	private HospitaldeptMapperCustom hospitaldeptMapperCustom;
	
	Logger logger = Logger.getLogger(DoctorService.class);
	// 判断手机号码是否注册
	@Override
	public int findDocCountByPhone(String docLoginPhone) throws Exception {
		try {
			// 查询用户登录表
			int count = doctorlogininfoMapperCustom.findDocCountByPhone(docLoginPhone);
			if (count == 0) {
				return 1; // 未注册
			} else {
				return 2; // 已注册
			}
		} catch (Exception e) {
			logger.error("验证手机号码异常"+e);
			return 3; // 操作异常
		}
	}

	// 注册
	@Override
	public int createDoctor(String docLoginPhone, String magCode, String docLoginPwd) {
		try {
			/*if (MsgCode.checkMsg(docLoginPhone, magCode)) {*/
			if (true) {
				int count = doctorlogininfoMapperCustom.findDocCountByPhone(docLoginPhone);
				//判断是否注册过
				if (count == 0) { //未注册
					Doctorlogininfo doctorLogininfo = new Doctorlogininfo();
					doctorLogininfo.setDocloginphone(docLoginPhone);
					doctorLogininfo.setDocloginname(docLoginPhone);
					String[] str = MD5Util.generate(docLoginPwd);
					doctorLogininfo.setDocloginpwd(str[0]); //md5值密码
					doctorLogininfo.setDocloginsalt(str[1]); //salt值
					doctorLogininfo.setDoclogintype(false);//未审核用户
					doctorLogininfo.setDocloginpix("1.jpg");
					//插入登录信息表
					int result = doctorlogininfoMapperCustom.insertSelectiveReturnId(doctorLogininfo);
					Doctorinfo doctorinfo =new Doctorinfo();
					doctorinfo.setDocloginid(doctorLogininfo.getDocloginid());
					//创建信息表
					int infoResult = doctorinfoMapper.insertSelective(doctorinfo);
					//创建日程表
					Doctorskd doctorskd = new Doctorskd();
					doctorskd.setDocloginid(doctorLogininfo.getDocloginid());
					int skdResult = doctorskdMapper.insertSelective(doctorskd);
					// 操作成功
					if (result >0 && infoResult>0 &&skdResult>0) {
						return 1;
					} else {
						logger.error("医生注册异常,有信息未插入");
						//操作失败，回滚
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return 2;
					}
				} else {
					//该号码已经注册过
					return 3;
				}
				
			} else {
				return 4;
			}
			
		} catch (Exception e) {
			logger.error("医生注册异常"+e);
			//操作异常，回滚
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 5;
		}

	}

	// 登录
	@Override
	public Map<String, Object> updateDoctorToLogin(Doctorlogininfo doctor) throws NoSuchAlgorithmException {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MapTokenManager mapTokenManager = new MapTokenManager();
			//登录信息
			Doctorlogininfo doctorlogininfo = new Doctorlogininfo();
			doctorlogininfo.setDocloginip(doctor.getDocloginip());
			doctorlogininfo.setDocloginpver(doctor.getDocloginpver());
			doctorlogininfo.setDocloginloc(doctor.getDocloginloc());
			doctorlogininfo.setDocloginlat(doctor.getDocloginlat());
			doctorlogininfo.setDocloginlon(doctor.getDocloginlon());
			doctorlogininfo.setDocloginmac(doctor.getDocloginmac());
			doctorlogininfo.setDoclogintime(new Date());
			doctorlogininfo.setDocloginphone(doctor.getDocloginphone());
			//doctorlogininfo.setDocloginpwd(doctor.getDocloginpwd());
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
			Doctorlogininfo doctorinfo = doctorlogininfoMapperCustom.selectDoctorByPhone(doctorlogininfo.getDocloginphone());
			if (doctorinfo != null) { // 登录成功
				boolean state =  MD5Util.verify(doctor.getDocloginpwd(), doctorinfo.getDocloginsalt(), doctorinfo.getDocloginpwd());
				System.out.println("密码"+state);
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
							Map<String, Object> info= doctorinfoMapperCustom.selectNameAndTitleByDocLoginId(doctorinfo.getDocloginid());
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
								Map<String, Object> info= doctorinfoMapperCustom.selectNameAndTitleByDocLoginId(doctorinfo.getDocloginid());
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
			map.put("state", "9"); //异常错误
		}
		

		return map;

	}
	
	// 获取个人信息
	@Override
	public Map<String, Object> getInfo(Integer docLoginId, Integer flag) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (flag == 1) {
				Map<String, Object> doctorinfo = doctorinfoMapperCustom.selectFirstInfoByDocLoginId(docLoginId);
				if (doctorinfo != null) {
					map.put("state", "1");
					map.put("data", doctorinfo);
				} else {
					map.put("state", "2"); // id对应的个人信息为空
				}
			} else {
				Map<String, Object> doctorinfo = doctorinfoMapperCustom.selectSecondInfoByDocLoginId(docLoginId);
				// 身份证照片 职称 行医资格证 工作证 其他照片
				if (doctorinfo != null) {
					map.put("state", "1");
					map.put("data", doctorinfo);
				} else {
					map.put("state", "2"); // id对应的个人信息为空
				}
			}
		} catch (Exception e) {
			logger.error("获取个人信息失败" + e);
			map.put("state", "3"); // 操作异常
		}
		return map;
	}
	// 获取头像
	@Override
	public Map<String,Object> getPix(int id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(id);
			if (doctorlogininfo!=null) {
				String pix = doctorlogininfo.getDocloginpix();
				if (pix!=null && pix.trim()!="") {
					map.put("state", "1"); //请求成功
					map.put("data", pix);
					
				} else {
					map.put("state", "2"); //头像为空
				}
			} else {
				map.put("state", "3"); // id对应的记录为空
			}
		} catch (Exception e) {
			logger.error("获取头像失败"+e);
			map.put("state", "4"); //操作异常
		}
		return map;
	}
	
	//更新医生信息
	@Override 
	public int updateInfo(Doctorinfo doctor) throws Exception {
		try {
		Integer docloginid=doctor.getDocloginid();
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		//该id对应的医生不为空
		if (doctorlogininfo!=null) {
			boolean type = doctorlogininfo.getDoclogintype();
			//该医生信息未被审核
			if (!type) {
				 Doctorinfo doctorinfo = new Doctorinfo();
				    doctor.setDocloginid(doctor.getDocloginid());
				    doctorinfo.setDocname(doctor.getDocname());
				    doctorinfo.setDoccardnum(doctor.getDoccardnum());
				    doctorinfo.setDocmale(doctor.getDocmale());
				    doctorinfo.setDocage(doctor.getDocage());
				    doctorinfo.setDochosp(doctor.getDochosp());
				    doctorinfo.setDocprimarydept(doctor.getDocprimarydept());
				    doctorinfo.setDocseconddept(doctor.getDocseconddept());
				    doctorinfo.setDocallday(doctor.getDocallday());
				    Doctorinfo doctorinfo2 = doctorinfoMapperCustom.findDoctorinfoByDocLoginId(doctor.getDocloginid());
				    if (doctorinfo2!=null) {
				    	doctorinfo.setDocid(doctorinfo2.getDocid()); //个人信息id
						int result = doctorinfoMapper.insertSelective(doctorinfo);
						if (result==1) {
							return 1; //成功
						} else {
							return 2; //更新失败
						}
					} else {
						return 3; //登录id对应的个人记录为空
					}
				    
			} else {
				return 4; //医生已被审核,个人信息无法修改
			}
		} else {
			return 5; //登录id对应的信息为空
		}
		
			   
		} catch (Exception e) {
			logger.error("更新医生信息失败"+e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 6; //操作异常
		}
	}
	//获取日程
	@Override
	public Map<String,Object> getSchedule(Integer docLoginId) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Doctorskd doctorskd = doctorskdMapperCustom.selectByDocLoginId(docLoginId);
			if (doctorskd!=null) {
				// 查询数据成功
				map.put("state", "1");
				int [] arr = {doctorskd.getMonam(),doctorskd.getTueam(),doctorskd.getWedam(),doctorskd.getThuam(),doctorskd.getFriam(),doctorskd.getSatam(),doctorskd.getSunam(),
						doctorskd.getMonpm(),doctorskd.getTuepm(),doctorskd.getWedpm(),doctorskd.getThupm(),doctorskd.getFripm(),doctorskd.getSatpm(),doctorskd.getSunpm()};
				map.put("data", arr);
				map.put("id", doctorskd.getDocskdid());
			} else {
				//查询到数据为空
				map.put("state", "2");
			}
		} catch (Exception e) {
			//异常错误
			logger.error("医生获取日程时错误"+e);
			map.put("state", "3");
		}
		return map;
	}
	//更新用户日程
	@Override
	public int updateSchedule(Doctorskd doctorskd){
		try {
			Doctorskd doctor = doctorskdMapper.selectByPrimaryKey(doctorskd.getDocskdid());
			// 为更新数据
			if (doctor!=null) { 
				int result = doctorskdMapper.updateByPrimaryKey(doctorskd);
				if (result>0) {
					//更新日程成功
					return 1; 
				} else {
					// 更新日程失败
					return 2;
				}
			} else {
				//未创建日程
				return 3;
			}
		} catch (Exception e) {
			logger.error("设置医生日程异常"+e);
			return 4;
			
		}
		
	}
	//获取病情
	@Override
	public Map<String, Object> listSick(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon,String time,
			 String province,String city,String area) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			pageNo = pageNo == null ? 1 : pageNo;
			pageSize = pageSize == null ? 3 : pageSize;
			Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
			// 医生个人信息不为空
			if (doctorinfo != null) {
				lat = lat == null ? doctorinfo.getDoclat() : lat;
				lon = lon == null ? doctorinfo.getDoclon() : lon;
				// 获取推荐病情
				if ((province == null || province.trim().length() == 0) && (time == null || time.trim().length() == 0)) {
					if (lat == null || lat.trim() == "" || lat == null || lat.trim() == "") {

					}
					DoctorSearch doctorSearch = new DoctorSearch();
					doctorSearch.setProvince(doctorinfo.getDochospprovince());
					doctorSearch.setCity(doctorinfo.getDochospcity());
					doctorSearch.setArea(doctorinfo.getDochosparea());
					doctorSearch.setPrimaryDept(doctorinfo.getDocprimarydept());
					doctorSearch.setSecondDept(doctorinfo.getDocseconddept());
					doctorSearch.setLat("0");
					doctorSearch.setLat("0");
					PageHelper.startPage(pageNo, pageSize);
					List<Map<String, Object>> list = usersickMapperCustom.paginationReSickSortByDistance(doctorSearch);
					PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
					if (page.getTotal()>0) {
						// 获取数据成功
						map.put("state", "1");
						map.put("data", page.getList());
					} else {
						map.put("state", "2");
					}

				} else {
					// 按时间排序
					if (time != null && time.trim() != "") {
						DoctorSearch doctorSearch = new DoctorSearch();
						doctorSearch.setLat(lat);
						doctorSearch.setLon(lon);
						doctorSearch.setTime(time);
						PageHelper.startPage(pageNo, pageSize);
						List<Map<String, Object>> list = usersickMapperCustom.paginationSickSortByTime(doctorSearch);
						PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
						if (!list.isEmpty()) {
							// 获取数据成功
							map.put("state", "3");
							map.put("data", page.getList());
						} else {
							map.put("state", "4");
						}
					//按位置排序
					} else {
						DoctorSearch doctorSearch = new DoctorSearch();
						doctorSearch.setLat(lat);
						doctorSearch.setLon(lon);
						doctorSearch.setProvince(province);
						doctorSearch.setCity(city);
						doctorSearch.setArea(area);
						PageHelper.startPage(pageNo, pageSize);
						List<Map<String, Object>> list = usersickMapperCustom.paginationSickSortByLoc(doctorSearch);
						PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
						if (!list.isEmpty()) {
							// 获取数据成功
							map.put("state", "5");
							map.put("data", page.getList());
						} else {
							map.put("state", "6");
						}
					}
				}
			}else {
				//登录id有点的个人信息为空
				map.put("state", "7");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			//操作异常
			map.put("state", "8");
		}
		
		return map;
	}

	// 获取病情详情
	@Override
	public Map<String, Object> getSickDetail(Integer usersickid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> data = usersickMapperCustom.selectAllInfoByUserSickId(usersickid);
			if (!data.isEmpty()) {
				map.put("state", "1");
				map.put("data", data);
			} else {
				map.put("state", "2");
			}
		} catch (Exception e) {
			map.put("state", "3");
		}
		return map;
	}
	
	//医生抢单
	@Override 
	public Map<String, Object> creatPreOrder(int usersickid, int docloginid, Double preorderprice) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Preorder preorder = new Preorder();
			preorder.setPreorderdocloginid(docloginid);
			preorder.setPreorderstate(1);
			if (preorderprice!=null) {
				preorder.setPreorderprice(new BigDecimal(preorderprice));	
			} 
			preorder.setUsersickid(usersickid);
			preorder.setPreordertype(2); // 医生抢单
			preorder.setPreordertime(new Date());
			// 查询病情信息
			Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
			if (usersick != null) {
				// 病人登录id
				preorder.setPreorderuserloginid(usersick.getUserloginid());
				List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid, 2);
				if (list.size()==0) {
					// 插入预订单
					int result = preorderMapper.insertSelective(preorder);
					// 数据插入成功
					if (result > 0) {
						Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(usersick.getUserloginid());
						Doctorinfo doctor = doctorinfoMapperCustom.findDoctorinfoByDocLoginId(docloginid);
						if (user != null && doctor != null) {
							String[] tags = { user.getUserloginphone(), "sick" };
							String title = "通知";
							String msg = doctor.getDocname() + "医生已抢单";
							String sign = "1"; // 医生抢单
							// 消息推送
							Map<String, Object> pushMap = PushToAndroid.PushMsgToSmartTag(tags, title, msg, sign);
							if ("1".equals(pushMap.get("state"))) {
								map.put("state", "1");// 操作成功,且消息发送成功
							} else {
								// 操作成功，但消息推送失败
								map.put("state", "2");
								map.put("msg", pushMap.get("msg"));
							}

						} else {
							map.put("state", "3"); // 操作成功，消息推送获取用户信息获取数据失败，
						}

					} else {
						map.put("state", "4"); // 抢单失败
					}

				} else {
					map.put("state", "5");// 已抢单
				}

				} else {
					map.put("state", "6");// 查询病情失败
				}
				
		} catch (Exception e) {
			logger.error("医生抢单失败" + e);
			map.put("state", "7"); // 操作异常
		}
		return map;
	}
	//医生取消抢单
	@Override
	public Map<String, Object> deletePreOrder(int preorderid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Preorder preorder = preorderMapper.selectByPrimaryKey(preorderid);
			if (preorder != null) {
				Integer docLoginId = preorder.getPreorderdocloginid();
				Integer userLoginId = preorder.getPreorderuserloginid();
				Integer userSickId = preorder.getUsersickid();
				int result = preorderMapper.deleteByPrimaryKey(preorderid);
				if (result > 0) {
					Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userLoginId);
					Doctorinfo doctor = doctorinfoMapperCustom.findDoctorinfoByDocLoginId(docLoginId);
					if (user != null && doctor != null) {
						String[] tags = { user.getUserloginphone(), "sick" };
						String title = "通知";
						String msg = doctor.getDocname() + "医生已取消抢单";
						String sign = "1"; // 医生抢单
						// 消息推送
						Map<String, Object> pushMap = PushToAndroid.PushMsgToSmartTag(tags, title, msg, sign);
						if ("1".equals(pushMap.get("state"))) {
							map.put("state", "1"); // 操作成功,且消息发送成功
						} else {
							map.put("state", "2");
							map.put("msg", pushMap.get("msg"));// 操作成功，但消息推送失败
						}
						
					} else {
						map.put("state", "3"); // 操作成功，但消息推送失败因获取数据失败
					}
				} else {
					map.put("state", "4");// 取消抢单失败
				}
			} else {
				// 预订单id对应数据为空
				map.put("state", "5");
			}

		} catch (Exception e) {
		
			logger.error("医生取消抢单失败" + e);
			map.put("state", "6");// 操作异常
		}
		return map;
	}
	//获取订单
	@Override 
	public Map<String, Object> listOrder(Integer docLoginId,Integer type) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> data = userorderMapperCustom.selectAllByDocLoginId(docLoginId);
			if (data.size()!=0) {
				map.put("state", "1");
				map.put("data", data);
			} else {
				map.put("state", "2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", "3");
			logger.error("医生获取订单异常"+e);
		}
		return map;
	}
	//医生确认
	@Override
	public Map<String, Object> updateOrderConfirm(Integer userorderid, Double userorderdprice, Double userorderhprice,
			Integer userorderhospid){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
			//订单存在
			if (order!=null) {
				//订单状态
				int stateid = order.getUserorderstateid();
				//等待医生确认状态
				if (stateid==1) {
					BigDecimal orderdprice = order.getUserorderdprice();
					BigDecimal orderhprice = order.getUserorderhprice();
					//订单信息
					Userorder userorder = new Userorder();
					userorder.setUserorderid(userorderid);
					if (userorderdprice!=null) {
						userorder.setUserorderdprice(new BigDecimal(userorderdprice));
						orderdprice = new BigDecimal(userorderdprice);
					}else {
						if (orderdprice==null) {
							//医生价格为空
							map.put("state", "7"); 
							return map;
						}
					}
					if (userorderhprice!=null) {
						userorder.setUserorderhprice(new BigDecimal(userorderhprice));
						orderhprice = new BigDecimal(userorderhprice);
					}else{
						if (orderhprice==null) {
							//医院价格为空
							map.put("state", "8"); 
							return map;
						}
					}
					BigDecimal userorderprice = orderdprice.add(orderhprice);
					userorder.setUserorderprice(userorderprice);
					userorder.setUserorderhospid(userorderhospid);
					userorder.setUserorderstateid(2);
					//接单时间
					userorder.setUserorderrtime(new Date());
					int state = userorderMapper.updateByPrimaryKeySelective(userorder);
					//确认成功
					if (state>0) {
						Doctorinfo doctor  =doctorinfoMapperCustom.findDoctorinfoByDocLoginId(order.getUserorderdocloginid());
						Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(order.getUserloginid());
						if (doctor!=null && user!=null) {
							String[] tags = {user.getUserloginphone(),"sick"};
							String title = "通知";
							String msg = doctor.getDocname()+"医生已接单";
							String sign = "2"; //医生已接单 
							// 消息推送
							Map<String, Object> pushMap = PushToAndroid.PushMsgToSmartTag(tags, title, msg, sign);
							if ("1".equals(pushMap.get("state"))) {
								map.put("state", "1"); // 操作成功,且消息发送成功
							} else {
								map.put("state", "2");
								map.put("msg", pushMap.get("msg"));// 操作成功，但消息推送失败
							}
						} else {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							//获取信息失败
							map.put("state", "3");  
						}
					
					}else {
						//确认失败
						map.put("state", "4");  
					}
				}else {
					//该状态不支持确认
					map.put("state", "5"); 
				}
			}else{
				//id对应订单不存在
				map.put("state", "6");  	
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("医生确认订单错误"+e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			 //操作异常
			map.put("state", "9"); 
		}
		return map;
	}
	
	//医生完善订单消息
	@Override
	public int updateOrder(Userorder userorder) throws Exception{
		try {
			Userorder order = new Userorder();
			order.setUserorderid(userorder.getUserorderid());
			order.setUserorderstateid(3);
			order.setUserorderrtime(new Date());
			BigDecimal doctorMoney = userorder.getUserorderdprice();
			BigDecimal hospMoney  = userorder.getUserorderhprice();
			BigDecimal money =doctorMoney.add(hospMoney);
			order.setUserorderdprice(doctorMoney);
			order.setUserorderhprice(hospMoney);
			order.setUserorderprice(money);
			order.setUserorderhospid(userorder.getUserorderhospid());
			int state = userorderMapper.updateByPrimaryKeySelective(order);
			if (state>0) {
				Userorder info= userorderMapper.selectByPrimaryKey(userorder.getUserorderid());
				if (info!=null) {
					Doctorinfo doctor  =doctorinfoMapperCustom.findDoctorinfoByDocLoginId(info.getUserorderdocloginid());
					Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(info.getUserloginid());
					if (doctor!=null && user!=null) {
						String[] tags = {user.getUserloginphone(),"sick"};
						String title = "通知";
						String msg = doctor.getDocname()+"医生已完善订单信息";
						String sign = "3"; //等待病人再确认
						//消息推送
						PushToAndroid.PushMsgToSmartTag(tags, title, msg,sign);
						return 1;//获取成功
					} else {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return 2; //医生信息为空
					}
				
				} else {
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return 3; //订单信息为空
				}
				
			} else {
				return 4; //更新失败
			}
		} catch (Exception e) {
			logger.error("医生完善订单信息错误"+e);
			return 5; //操作异常
		}
	}
	
	//获取全部病情
	@Override 
	public Map<String, Object> getSicks(SickSearch sickSearch)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> lists = usersickMapperCustom.selectAll(sickSearch);
			if (lists!=null) {
				map.put("state", "1");
				map.put("data", lists);
			} else {
				map.put("state", "2");
			}
			
		} catch (Exception e) {
			logger.error("医生获取全部病情错误"+e);
			map.put("state", "3");
		}
		return map;
	}
	
	
	//获取病人头像
	@Override
	public Map<String, Object> getUserPix(int id)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Usersick usersick = usersickMapper.selectByPrimaryKey(id);
			if (usersick!=null) {
				Userlogininfo userlogininfo =  userlogininfoMapper.selectByPrimaryKey(usersick.getUserloginid());
				if (userlogininfo!=null) {
					map.put("state", "1");
					map.put("data", userlogininfo);
				} else {

				}
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}
	
	//上传图片
	@Override 
	public Map<String, Object> updatePhoto(MultipartFile[] pictureFile,int id,Integer type) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			//真实路径
			String reallyDir ="D:\\\\upload\\\\doctor\\\\"+id+"\\\\";
			//保存到数据库的路径
			String virtualDir = "doctor/"+id+"/";
			boolean state = CreateFileUtil.createDir(reallyDir);
			if (state) {
				String photo ="";
				for (int i = 0; i < pictureFile.length; i++) {
					String name = CommonUtils.randomFileName();
					String ext = "jpg";
					String file =name + "." + ext;
					String reallyPath = reallyDir + file;
					String virtualPath = virtualDir+file;
					pictureFile[i].transferTo(new File(reallyPath));
					if (i != pictureFile.length - 1) {
						photo += virtualPath + ",";
					} else {
						photo += virtualPath;
					}
				}
				if (type==0) { //头像
					Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(id);
					if (doctorlogininfo!=null) {
						Doctorlogininfo doctor =new Doctorlogininfo();
						doctor.setDocloginid(id);
						doctor.setDocloginpix(photo);
						int inResult = doctorlogininfoMapper.updateByPrimaryKeySelective(doctor);
						if (inResult>0) {
							map.put("state", "1"); //插入成功
							map.put("data",photo);
						} else {
							map.put("state", "2"); //插入失败
						}
					}else {
						map.put("state", "3");; // 对应个人信息为空
					}
					
				} else if (type>0 && type<6) {
					Doctorinfo info = doctorinfoMapperCustom.findDoctorinfoByDocLoginId(id);
					if (info!=null) {
						Doctorinfo doctorinfo =new Doctorinfo();
						doctorinfo.setDocid(info.getDocid());
						if (type==1) { //身份证
							doctorinfo.setDoccardphoto(photo);
						} else if (type==2) {//医生职称
							doctorinfo.setDoctitlephoto(photo);
						} else if (type==3) {//行医资格证
							doctorinfo.setDocqualphoto(photo);
						} else if (type==4) { //工作证
							doctorinfo.setDocworkcardphoto(photo);
						}else  if (type==5){ //其他照片
							doctorinfo.setDocotherphoto(photo);
						}
						int result = doctorinfoMapper.updateByPrimaryKeySelective(doctorinfo);
						if (result>0) {
							map.put("state", "1"); //插入成功
							map.put("data",photo);
						} else {
							map.put("state", "2"); //插入成功
						}
					}else {
						map.put("state", "3");; // 对应个人信息为空
					}
				}else {
					map.put("state", "4"); //type超出范围
				} 
				
			} else {
				map.put("state", "5"); //创建文件夹失败
			}
			
		} catch (Exception e) {
			logger.error("医生上传图片错误"+e);
			map.put("state", "6"); //操作异常
		}
		return map;
	}
	
	//获取推荐病情
	@Override
	public Map<String, Object> getReSick(int id,int page)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Doctorinfo doctorinfo = doctorinfoMapperCustom.findDoctorinfoByDocLoginId(id);
			if (doctorinfo!=null) {
				SickSearch sickSearch =new SickSearch();
				sickSearch.setDept(doctorinfo.getDocdept());
				sickSearch.setLat(doctorinfo.getDoclat());
				sickSearch.setLon(doctorinfo.getDoclon());
				sickSearch.setPageSize(10);
				sickSearch.setStartPage(page);
				List<Map<String, Object>> list = usersickMapperCustom.selectReSickSortByDistance(sickSearch);
				if (!list.isEmpty()) {
					map.put("state", "1"); //成功
					map.put("data", list);
				} else {
					map.put("state", "2");
				}
			} else {
				map.put("state", "3");
			}
			
		} catch (Exception e) {
			logger.error("医生获取推荐病情错误"+e);
			map.put("state", "4");
		}
		return map;
	}
	
	//获取病情按时间排序
	@Override
	public Map<String, Object> getSickByTime(int id,int page) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Doctorinfo doctorinfo = doctorinfoMapperCustom.findDoctorinfoByDocLoginId(id);
			if (doctorinfo!=null) {
				//String[] str = doctorinfo.getDocloc().split("市");
				SickSearch sickSearch = new SickSearch();
				//sickSearch.setLoc("%"+str[0]+"%");
				sickSearch.setLat(doctorinfo.getDoclat());
				sickSearch.setLon(doctorinfo.getDoclon());
				sickSearch.setPageSize(5);
				sickSearch.setStartPage(page);
				List<Map<String, Object>> list = usersickMapperCustom.selectAllSortByTime(sickSearch);
				if (!list.isEmpty()) {
					map.put("state", "1");//获取成功
					map.put("data", list);
				} else {
					map.put("state", "2");// 查询到数据为空
				}
			} else {
				map.put("state", "3"); // id对应的记录为空
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("医生获取按时间排序的病情错误"+e);
			map.put("state", "4"); //操作异常
		}
		return map;
	}

	// 获取病情按时间排序
	@Override
	public Map<String, Object> getSickByLoc(int id, int page, String loc) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Doctorinfo doctorinfo = doctorinfoMapperCustom.findDoctorinfoByDocLoginId(id);
			if (doctorinfo != null) {
				SickSearch sickSearch = new SickSearch();
				sickSearch.setLoc("%" + loc + "%");
				sickSearch.setLat(doctorinfo.getDoclat());
				sickSearch.setLon(doctorinfo.getDoclon());
				sickSearch.setPageSize(5);
				sickSearch.setStartPage(page);
				List<Map<String, Object>> list = usersickMapperCustom.selectAllSortByLoc(sickSearch);
				if (!list.isEmpty()) {
					map.put("state", "1");// 获取成功
					map.put("data", list);
				} else {
					map.put("state", "2");// 查询到数据为空
				}
			} else {
				map.put("state", "3"); // id对应的记录为空
			}

		} catch (Exception e) {
			logger.error("医生获取按位置排序的病情错误"+e);
			map.put("state", "4"); // 操作异常
		}
		return map;
	}
	@Override
	public Map<String, Object> getDept() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Hospitaldept> list = hospitaldeptMapperCustom.selectAll();
			if (!list.isEmpty()) {
				//一级单位及下级单位
				List<Map<String, Object>> data = new ArrayList<>();
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> dept = new HashMap<>();
					Hospitaldept hospitaldept = list.get(i);
					int fatherId = hospitaldept.getHospdeptfatherid();
					if (fatherId==0) {
						dept.put("first", hospitaldept.getHospdeptname());
						int id = hospitaldept.getHospdeptid();
						List<String> sonDept = new ArrayList<>();
						for (int j = 0; j < list.size(); j++) {
							Hospitaldept hospitaldept2 = list.get(j);
							int fatherId2 =  hospitaldept2.getHospdeptfatherid();
							System.out.println("id"+id+"......"+fatherId2);
							if (id==fatherId2) {
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
				// 查询成功
				map.put("state", "1");
				map.put("data", data);
			} else {
				// 查询失败，
				map.put("state", "2");
			}
			
		} catch (Exception e) {
			logger.error("查询科室异常"+e);
			map.put("state", "3");
		}
		return map;
	}
	
	//获取科室
	@Override 
	public Map<String, Object> getDeptByFatherId(int id)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Hospitaldept> list = hospitaldeptMapperCustom.selectByFatherId(id);
			if (!list.isEmpty()) {
				map.put("state", "1");// 获取成功
				map.put("data", list);
			} else {
				map.put("state", "2");
			}
		} catch (Exception e) {
			logger.error("医生获取科室错误"+e);
			map.put("state", "3");
		}
		return map;
	}
	//获取已抢订单
	@Override
	public Map<String, Object> listGrabOrders(Integer docloginid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> result = preorderMapperCustom.selectAllInfoByDocLoginId(docloginid);
			if (result.size()!=0) {
				map.put("state", "1");// 获取成功
				map.put("data", result);
			} else {
				map.put("state", "2");
			}
		}catch (Exception e) {
			logger.error("获取已抢订单错误"+e);
			map.put("state", "3");
		}
		
		return map;
	}

	

	
}