package com.medical.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import com.baidu.yun.push.utils.PushToAndroid;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huanxin.utils.UserManger;
import com.medical.interceptor.MapTokenManager;
import com.medical.interceptor.TokenModel;
import com.medical.mapper.CityMapperCustom;
import com.medical.mapper.DoctoraddressMapper;
import com.medical.mapper.DoctoraddressMapperCustom;
import com.medical.mapper.DoctorcalendarMapper;
import com.medical.mapper.DoctorcalendarMapperCustom;
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
import com.medical.mapper.HospinfoMapperCustom;
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
import com.medical.po.DoctorSearch;
import com.medical.po.Doctoraddress;
import com.medical.po.Doctorcalendar;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Doctorskd;
import com.medical.po.Hospitaldept;
import com.medical.po.Preorder;
import com.medical.po.SickSearch;
import com.medical.po.Userlogininfo;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.po.Doctorlog;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.doctor.DoctorAccountService;
import com.medical.service.DoctorService;
import com.medical.utils.CommonUtils;
import com.medical.utils.CreateFileUtil;
import com.medical.utils.MD5Util;
import com.medical.utils.PictureTool;

/**
 * 
 * @author xyh
 *
 */
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
	private UserlogininfoMapperCustom userlogininfoMapperCustom;
	
	@Autowired
	private UsersickMapper usersickMapper; 
	@Autowired
	private UsersickMapperCustom usersickMapperCustom; 
    @Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private UserorderMapperCustom userorderMapperCustom;
	
	
	@Autowired
	private HospitaldeptMapperCustom hospitaldeptMapperCustom;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DoctoraddressMapper doctoraddressMapper;
	@Autowired
	private DoctoraddressMapperCustom doctoraddressMapperCustom;
	@Autowired
	private DoctorcalendarMapper doctorcalendarMapper;
	@Autowired
	private DoctorcalendarMapperCustom doctorcalendarMapperCustom;
	@Autowired
	private DoctorAccountService doctorAccountService;
	
	Logger logger = Logger.getLogger(DoctorService.class);

	// 判断手机号码是否注册
	@Override
	public int findDocCountByPhone(String phone) {
		
		
			// 查询医生登录表
			int doctorCount = doctorlogininfoMapperCustom.findDocCountByPhone(phone);
			// 查询病人登录表
			int userCount = userlogininfoMapperCustom.findUserCountByPhone(phone);
			
			if (doctorCount == 0 && userCount == 0) {
				// 未注册
				return 1;
			} else {
				if (userCount > 0) {
					// 在病人端已注册
					return 2;
				} else {
					// 在医生端已注册
					return 3;
				}
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
					//md5值密码
					doctorLogininfo.setDocloginpwd(str[0]); 
					//salt值
					doctorLogininfo.setDocloginsalt(str[1]); 
					//未审核用户
					doctorLogininfo.setDoclogintype(1);
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
						doctorAccountService.addHuanXinAccout(doctorLogininfo.getDocloginid(),docLoginPwd);
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
			e.printStackTrace();
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
	@Override
	public Map<String, Object> getDoctorDept(Integer docloginid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
				Map<String, Object> doctorinfo = doctorinfoMapperCustom.selectFirstInfoDeptByDocLoginId(docloginid);
				if (doctorinfo != null) {
					map.put("state", "1");
					map.put("data", doctorinfo);
				} else {
					map.put("state", "2"); // id对应的个人信息为空
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
			int type = doctorlogininfo.getDoclogintype();
			//该医生信息未被审核
			if (true) {
				 Doctorinfo doctorinfo = new Doctorinfo();
				    doctor.setDocloginid(doctor.getDocloginid());
				    doctorinfo.setDocname(doctor.getDocname());
				    doctorinfo.setDoccardnum(doctor.getDoccardnum());
				    doctorinfo.setDocmale(doctor.getDocmale());
				    doctorinfo.setDocage(doctor.getDocage());
				    doctorinfo.setDochosp(doctor.getDochosp());
				    doctorinfo.setHosplevel(doctor.getHosplevel());
				    doctorinfo.setDochospprovince(doctor.getDochospprovince());
				    doctorinfo.setDochospcity(doctor.getDochospcity());
				    doctorinfo.setDochosparea(doctor.getDochosparea());
				    doctorinfo.setDochospother(doctor.getDochospother());
				    doctorinfo.setDochosplat(doctor.getDochosplat());
				    doctorinfo.setDochosplon(doctor.getDochosplon());
				    doctorinfo.setDocaddresslat(doctor.getDochosplat());
				    doctorinfo.setDocaddresslon(doctor.getDochosplon());
				    doctorinfo.setDocprimarydept(doctor.getDocprimarydept());
				    doctorinfo.setDocseconddept(doctor.getDocseconddept());
				    doctorinfo.setDocallday(doctor.getDocallday());
				    doctorinfo.setDoctitle(doctor.getDoctitle());
				    Doctorinfo doctorinfo2 = doctorinfoMapperCustom.findDoctorinfoByDocLoginId(doctor.getDocloginid());
				    if (doctorinfo2!=null) {
				    	doctorinfo.setDocid(doctorinfo2.getDocid()); //个人信息id
						int result = doctorinfoMapper.updateByPrimaryKeySelective(doctorinfo);
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

	// 更新医生照片
	@Override
	public int updateSecondInfo(Integer docloginid, String olddoccardphoto, MultipartFile[] doccardphoto,
			String olddoctitlephoto, MultipartFile[] doctitlephoto, String olddocqualphoto,
			MultipartFile[] docqualphoto, String olddocworkcardphoto, MultipartFile[] docworkcardphoto,
			String olddocotherphoto, MultipartFile[] docotherphoto) {
		try {
			Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
			Doctorinfo info = doctorinfoMapperCustom.findDoctorinfoByDocLoginId(docloginid);
			// 该id对应的医生不为空
			if (doctorlogininfo != null && info != null) {
				int type = doctorlogininfo.getDoclogintype();
				// 该医生信息未被审核
				if (true) {
						String cardPhotoPath = PictureTool.SavePictures(doccardphoto);
						if (olddoccardphoto != null) {
							if (cardPhotoPath != null) {
								olddoccardphoto = olddoccardphoto + "," + cardPhotoPath;
							}
						} else {
							olddoccardphoto = cardPhotoPath;
						}
						
						String titlePhotoPath = PictureTool.SavePictures(doctitlephoto);
						if (olddoctitlephoto != null) {
							if (titlePhotoPath != null) {
								olddoctitlephoto = olddoctitlephoto + "," + titlePhotoPath;
							}
						} else {
							olddoctitlephoto = titlePhotoPath;
						}
						
						String qualPhotoPath = PictureTool.SavePictures(docqualphoto);
						if (olddocqualphoto != null) {
							if (qualPhotoPath != null) {
								olddocqualphoto = olddocqualphoto + "," + qualPhotoPath;
							}
							
						} else {
							olddocqualphoto = qualPhotoPath;
						}
						
						String workCardPhotoPath = PictureTool.SavePictures(docworkcardphoto);
						if (olddocworkcardphoto != null) {
							if (workCardPhotoPath != null) {
								olddocworkcardphoto = olddocworkcardphoto + "," + workCardPhotoPath;
							}
							
						} else {
							olddocworkcardphoto = workCardPhotoPath;
						}
						
						String otherPhotoPath = PictureTool.SavePictures(docotherphoto);
						if (olddocotherphoto != null) {
							if (otherPhotoPath != null) {
								olddocotherphoto = olddocotherphoto + "," + otherPhotoPath;
							}
							
						} else {
							olddocotherphoto = otherPhotoPath;
						}
						Doctorinfo doctorinfo = new Doctorinfo();
						doctorinfo.setDocid(info.getDocid());
						doctorinfo.setDoccardphoto(olddoccardphoto);
						doctorinfo.setDocqualphoto(olddocqualphoto);
						doctorinfo.setDocworkcardphoto(olddocworkcardphoto);
						doctorinfo.setDoctitlephoto(olddoctitlephoto);
						doctorinfo.setDocotherphoto(olddocotherphoto);
						int result = doctorinfoMapper.updateByPrimaryKeySelective(doctorinfo);
						if (result > 0) {
							// 更新成功
							return 1;
						} else {
							// 更新失败
							return 2;
						}
					
				} else {
					return 4; // 医生已被审核,个人信息无法修改
				}
			} else {
				return 5; // 登录id对应的信息为空
			}

		} catch (Exception e) {
			logger.error("更新医生图片失败" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 6; // 操作异常
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
				lat = lat == null ? doctorinfo.getDocaddresslat() : lat;
				lon = lon == null ? doctorinfo.getDocaddresslon() : lon;
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
	public Map<String, Object> deletePreOrder(Integer docloginid ,Integer preorderid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Preorder preorder = preorderMapper.selectByPrimaryKey(preorderid);
			if (preorder != null) {
				Integer docLoginId = preorder.getPreorderdocloginid();
				Integer userLoginId = preorder.getPreorderuserloginid();
				Integer userSickId = preorder.getUsersickid();
				if (docloginid== docLoginId) {
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
					//预定单与医生信息不符
					map.put("state", "5");
				}
			} else {
				// 预订单id对应数据为空
				map.put("state", "6");
			}

		} catch (Exception e) {
		
			logger.error("医生取消抢单失败" + e);
			map.put("state", "7");// 操作异常
		}
		return map;
	}
	
	//医生确认
	@Override
	public Map<String, Object> updateOrderConfirm(Userorder userorder){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer userorderid = userorder.getUserorderid();
			Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
			//订单存在
			if (order!=null) {
				//订单状态
				int stateid = order.getUserorderstateid();
				//等待医生确认状态
				if (stateid==1) {
					userorder.setUserorderstateid(2);
					//接单时间
					userorder.setUserorderrtime(new Date());
					System.out.println("id............."+userorder.getUserloginid());
					userorder.setUserloginid(null);
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
			map.put("state", "7"); 
		}
		return map;
	}
	//待修改
	//医生完善订单消息
	/*@Override
	public int updateOrder(Userorder userorder) throws Exception{
		try {
			Userorder order = new Userorder();
			order.setUserorderid(userorder.getUserorderid());
			order.setUserorderstateid(3);
			order.setUserorderrtime(new Date());
			order.setUserorderdprice(userorder.getUserorderdprice());
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
	*/
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
				sickSearch.setLat(doctorinfo.getDocaddresslat());
				sickSearch.setLon(doctorinfo.getDocaddresslon());
				sickSearch.setPageSize(11);
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
				sickSearch.setLat(doctorinfo.getDocaddresslat());
				sickSearch.setLon(doctorinfo.getDocaddresslon());
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
				sickSearch.setLat(doctorinfo.getDocaddresslat());
				sickSearch.setLon(doctorinfo.getDocaddresslon());
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
	public Map<String, Object> listGrabOrders(Integer docloginid,Integer pageNo,Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PageHelper.startPage(pageNo, pageSize);
			List<Map<String, Object>> list = preorderMapperCustom.listByDocLoginId(docloginid);
			PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
			if (page.getTotal()>0) {
				// 获取数据成功
				map.put("state", "1");
				map.put("data", page.getList());
			} else {
				map.put("state", "2");
			}
		}catch (Exception e) {
			logger.error("获取已抢订单错误"+e);
			map.put("state", "3");
		}
		
		return map;
	}
	//获取已抢订单详情
	@Override
	public Map<String, Object> getGrabOrderDetail(Integer preOrderId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> result = preorderMapperCustom.selectAllInfoByPreOrderIdInDoc(preOrderId);
			if (!result.isEmpty()) {
				map.put("state", "1");// 获取成功
				map.put("data", result);
			} else {
				map.put("state", "2");
			}
		}catch (Exception e) {
			logger.error("获取已抢订单详情"+e);
			map.put("state", "3");
		}
		
		return map;
	}

	// 获取订单
	@Override
	public Map<String, Object> listOrder(Integer docLoginId, Integer type,Integer pageNo,Integer pageSize) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PageHelper.startPage(pageNo, pageSize);
			List<Map<String, Object>> list = userorderMapperCustom.listByDocLoginId(docLoginId,type);
			PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
			if (page.getTotal()>0) {
				// 获取数据成功
				
				map.put("state", "1");
				map.put("data", page.getList());
			} else {
				map.put("state", "2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", "3");
			logger.error("医生获取订单异常" + e);
		}
		return map;
	}

	// 获取订单详情
	@Override
	public Map<String, Object> getOrderDetail(Integer docLoginId,Integer userOrderId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> data = userorderMapperCustom.selectAllInfoByUserOrderIdInDoc(docLoginId,userOrderId);
			if (!data.isEmpty()) {
				map.put("state", "1");
				map.put("data", data);
			} else {
				map.put("state", "2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", "3");
			logger.error("医生获取订单异常" + e);
		}
		return map;
	}

	@Override
	public Map<String, Object> getHospital(String hospname) {
		Map<String, Object> map = new HashMap<String, Object>();
		String name = "%"+hospname+"%";
		try {
			List<Map<String, Object>>  data = hospinfoMapperCustom.selectByHospName(name);
			if (data.size()==0) {
				map.put("state", "2");
			} else {
				map.put("state", "1");
				map.put("data", data);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", "3");
		}
		return map;
	}
	
	//医生取消订单
	@Override
	public Map<String, Object> updateOrderToCancle(Integer docLoginId, Integer userorderid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Userorder userorder = userorderMapper.selectByPrimaryKey(userorderid);
			if (userorder!=null) {
				Integer doc = userorder.getUserorderdocloginid();
				if (docLoginId==doc) {
					Integer userorderstateid = userorder.getUserorderstateid();
					Integer usersickid = userorder.getUsersickid();
					if (userorderstateid<4) {
						//订单信息
						Userorder record = new Userorder();
						record.setUserorderid(userorderid);
						record.setUserorderstateid(15);
						record.setUserorderetime(new Date());
						Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
						if (usersick!=null) {
							//病情信息
							Usersick sick = new Usersick();
							sick.setUsersickid(usersickid);
							sick.setUsersickstateid(2);
							int orderResult = userorderMapper.updateByPrimaryKeySelective(record);
							int sickResult = usersickMapper.updateByPrimaryKeySelective(sick);
							if (orderResult>0 && sickResult>0) {
								Doctorinfo doctor  =doctorinfoMapperCustom.findDoctorinfoByDocLoginId(docLoginId);
								Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(usersick.getUserloginid());
								if (doctor!=null && user!=null) {
									String[] tags = {user.getUserloginphone(),"sick"};
									String title = "通知";
									String msg = doctor.getDocname()+"医生取消订单";
									String sign = "3"; //等待病人再确认
									//消息推送
									Map<String, Object> push = PushToAndroid.PushMsgToSmartTag(tags, title, msg,sign);
									if ("1".equals(push.get("state"))) {
										//取消订单成功，且消息发送成功
										map.put("state", "1");
									} else {
										//取消订单成功，且消息发送失败
										map.put("state", "2");
										map.put("msg", push.get("msg"));
									}
									
								} else {
									//取消订单成功，且消息发送失败
									map.put("state", "2");
									map.put("msg", "获取用户信息失败");
								}
							} else {
								//取消失败，未知错误
								TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
								map.put("state", "3");
							}
							
						} else {
							//病情不存在，取消失败
							map.put("state", "4");
						}
					} else {
						//该状态不支持取消
						map.put("state", "5");
					}
					
				} else {
					//医生与订单不匹配
					map.put("state", "6");
				}
				
			} else {
				//订单不存在
				map.put("state", "7");
			}
		} catch (Exception e) {
			//异常错误
			map.put("state", "8");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
		return map;
	}
	
	//医生拒绝接单并推荐其他
	@Override
	public Map<String, Object> updateOrderToRefuse(Integer docloginid, Integer userorderid, Integer redocloginid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Userorder userorder = userorderMapper.selectByPrimaryKey(userorderid);
			if (userorder!=null) {
				Integer doc = userorder.getUserorderdocloginid();
				if (docloginid==doc) {
					Integer userorderstateid = userorder.getUserorderstateid();
					Integer usersickid = userorder.getUsersickid();
					if (userorderstateid==1) {
						//订单信息
						Userorder record = new Userorder();
						record.setUserorderid(userorderid);
						if (redocloginid==null) {
							record.setUserorderstateid(13);
						} else {
							record.setUserorderstateid(14);
							Preorder preorder = new Preorder();
							preorder.setUsersickid(usersickid);
							preorder.setPreorderuserloginid(userorder.getUserloginid());
							//医生推荐
							preorder.setPreordertype(3);
							preorder.setPreorderredocloginid(docloginid);
							Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(redocloginid);
							if (userlogininfo!=null) {
								preorder.setPreorderdocloginid(redocloginid);
								preorder.setPreordertime(new Date());
								List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(redocloginid, usersickid, 3);
								if (list.size()==0) {
									int preResult = preorderMapper.insertSelective(preorder);
									if (preResult==0) {
										//插入推荐医生失败
										map.put("state", "8");
										return map;
									}
								} else {
									//该医生已被推荐
									map.put("state", "9");
									return map;
								}
							} else {
								//推荐医生不存在
								map.put("state", "10");
								return map;
							}
							
						}
						record.setUserorderetime(new Date());
						Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
						if (usersick!=null) {
							//病情信息
							Usersick sick = new Usersick();
							sick.setUsersickid(usersickid);
							sick.setUsersickstateid(2);
							int orderResult = userorderMapper.updateByPrimaryKeySelective(record);
							int sickResult = usersickMapper.updateByPrimaryKeySelective(sick);
							if (orderResult>0 && sickResult>0 ) {
								Doctorinfo doctor  =doctorinfoMapperCustom.findDoctorinfoByDocLoginId(docloginid);
								Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(usersick.getUserloginid());
								if (doctor!=null && user!=null) {
									String[] tags = {user.getUserloginphone(),"sick"};
									String title = "通知";
									String msg = doctor.getDocname()+"医生拒绝该订单";
									String sign = "3"; //等待病人再确认
									//消息推送
									Map<String, Object> push = PushToAndroid.PushMsgToSmartTag(tags, title, msg,sign);
									if ("1".equals(push.get("state"))) {
										//取消订单成功，且消息发送成功
										map.put("state", "1");
									} else {
										//取消订单成功，且消息发送失败
										map.put("state", "2");
										map.put("msg", push.get("msg"));
									}
									
								} else {
									//取消订单成功，且消息发送失败
									map.put("state", "2");
									map.put("msg", "获取用户信息失败");
								}
							} else {
								//取消失败，未知错误
								TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
								map.put("state", "3");
							}
							
						} else {
							//病情不存在，取消失败
							map.put("state", "4");
						}
					} else {
						//该状态不支持取消
						map.put("state", "5");
					}
					
				} else {
					//医生与订单不匹配
					map.put("state", "6");
				}
				
			} else {
				//订单不存在
				map.put("state", "7");
			}
		} catch (Exception e) {
			//异常错误
			map.put("state", "11");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
		return map;
	}
	
	//医生修改病情部门
	@Override
	public Map<String, Object> changeDept(Integer docloginid, Integer usersickid, String usersickprimarydept,
			String usersickseconddept) {
		try {
			Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
			Usersick sick = usersickMapper.selectByPrimaryKey(usersickid);
			if (doctorlogininfo!=null) {
				Usersick usersick = new Usersick();
				usersick.setUsersickid(usersickid);
				usersick.setUsersickprimarydept(usersickprimarydept);
				usersick.setUsersickseconddept(usersickseconddept);
				int result = usersickMapper.updateByPrimaryKeySelective(usersick);
				int delresult = preorderMapperCustom.deleteByDocLoginIdAndPreOrderType(docloginid, 1);
				if (result>0 && delresult>0) {
					Map<String, Object> resultMap = commonService.listRecommendDoctors(sick.getUsersickpic(), sick.getUsersickprimarydept(), sick.getUsersickseconddept());
					boolean flag = false;
					if ("1".equals(resultMap.get("state"))) {
						List<Doctorinfo> list = (List<Doctorinfo>) resultMap.get("data");
						for (Doctorinfo doctorinfo : list) {
							Preorder preorder = new Preorder();
							preorder.setPreorderdocloginid(doctorinfo.getDocloginid());
							preorder.setUsersickid(usersickid);
							preorder.setPreordertype(1);
							preorder.setPreordertime(new Date());
							int preResult = preorderMapper.insertSelective(preorder);
							if (preResult<=0) {
								flag =true;
								break;
							} 
						}
						if (flag) {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							
						}
				} else {
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				}
				
				} else {

				}
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Map<String, Object> finishOrder(Integer docloginid, Integer userorderid, Boolean userorderhstate,
			Integer userorderhospid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Userorder order = userorderMapperCustom.selectByDocLoginIdAndUserOrderId(docloginid,userorderid);
			Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
			if (order!=null) {
				Integer userOrderStateId = order.getUserorderstateid();
				//预付款完成,等待医生就诊状态
				if (userOrderStateId==4) {
					if (userorderhstate) {
						Userorder userorder = new Userorder();
						userorder.setUserorderid(userorderid);
						//需要住院，等待医院确认
						userorder.setUserorderstateid(5);
						userorder.setUserorderhospid(userorderhospid);
						userorder.setUserorderchosehosptime(new Date());
						//住院部门默认为医生所在部门
						userorder.setUserorderhospprimarydept(doctorinfo.getDocprimarydept());
						userorder.setUserorderhospseconddept(doctorinfo.getDocseconddept());
						int result = userorderMapper.updateByPrimaryKeySelective(userorder);
						if (result>0) {
							map.put("state", "1");
						} else {
							//操作失败
							map.put("state", "2");
						}
					} else {
						Userorder userorder = new Userorder();
						userorder.setUserorderid(userorderid);
						userorder.setUserorderetime(new Date());
						userorder.setUserorderstateid(9);
						int result = userorderMapper.updateByPrimaryKeySelective(userorder);
						Usersick usersick = new Usersick();
						usersick.setUsersickid(order.getUsersickid());
						//该病情已结束
						usersick.setUsersickstateid(4);
						int sickResult = usersickMapper.updateByPrimaryKeySelective(usersick);
						if (result>0 && sickResult>0) {
							map.put("state", "3");
						} else {
							//操作失败
							map.put("state", "4");
						}
					}
				} else {
					//该状态不支持该操作
					map.put("state", "5");
				}
				
			} else {
				//订单id跟医生id不匹配
				map.put("state", "6");
			}		
		} catch (Exception e) {
			map.put("state", "7");
		}
		return map;
	}

	@Override
	public Map<String, Object> getDoctorByName(String docname) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> list = doctorinfoMapperCustom.selectByName(docname);
			if (list.size()>0) {
				map.put("state", "1");
				map.put("data", list);
			} else {
				map.put("state", "2");
			}
			
		} catch (Exception e) {
			map.put("state", "3");
		}
		return map;
	}

	@Override
	public int addAddress(Doctoraddress doctoraddress) {
		try {
			int docloginid = doctoraddress.getDocloginid();
			Doctorlogininfo doctorlogininfo =  doctorlogininfoMapper.selectByPrimaryKey(docloginid);
			if (doctorlogininfo != null) {
					doctoraddress.setDocaddresstype(false);
					doctoraddress.setDocaddresschecked(false);
					int result = doctoraddressMapper.insertSelective(doctoraddress);
					if (result>0) {
						//新增成功
						return 1;
					} else {
						//新增失败
						return 2;
					}
				
			}else {
				//新增失败,该医生不存在
				return 3;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			//新增失败,异常错误
			logger.error("医生添加常用地址"+e);
			return 4;
		}
		
	}

	@Override
	public int editAddress(Doctoraddress doctoraddress) {
		try {
			int docloginid = doctoraddress.getDocloginid();
			int docaddressid = doctoraddress.getDocaddressid();
			Doctoraddress  address = doctoraddressMapper.selectByPrimaryKey(docaddressid);
			if (address!=null) {
				int loginid = address.getDocloginid();
				if (docloginid == loginid) {
					boolean type = address.getDocaddresstype();
					if (!type) {
						int result = doctoraddressMapper.updateByPrimaryKeySelective(doctoraddress);
						if (result>0) {
							//修改成功
							return 1;
						} else {
							//修改失败
							return 2;
							}
						
					}else {
						//默认地址不可修改
						return 3;
					}
				} else {
					//该地址不属于该医生
					return 4;
				}
					
			} else {
				//该地址不存在
				return 5;
			}
		} catch (Exception e) {
			e.printStackTrace();
			//新增失败,异常错误
			logger.error("医生添加常用地址"+e);
			return 6;
		}
	}

	@Override
	public int delAddress(Integer docloginid, Integer docaddressid) {
		try {
			Doctoraddress  address = doctoraddressMapper.selectByPrimaryKey(docaddressid);
			if (address!=null) {
				int loginid = address.getDocloginid();
				boolean type = address.getDocaddresstype();
				if (!type) {
					if (docloginid == loginid) {
						boolean checked = address.getDocaddresschecked();
						if (!checked) {
							int result = doctoraddressMapper.deleteByPrimaryKey(docaddressid);
							if (result>0) {
								//删除成功
								return 1;
							} else {
								//删除失败
								return 2;
							}
						} else {
							//该地址正在使用
							return 3;
						}
						
					} else {
						//该地址不属于该医生
						return 4;
					}
						
				} else {
					//默认地址不可删除
					return 5;
				}
				
			} else {
				//该地址不存在
				return 6;
			}
		} catch (Exception e) {
			e.printStackTrace();
			//删除失败,异常错误
			logger.error("医生删除常用地址异常"+e);
			return 7;
		}
	}

	@Override
	public Map<String, Object> getAddress(Integer docloginid, Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PageHelper.startPage(page, 5);
			List<Doctoraddress> result = doctoraddressMapperCustom.selectByDocloginid(docloginid);
		    PageInfo<Doctoraddress> pageInfo = new PageInfo<Doctoraddress>(result);
		    if (pageInfo.getSize()!=0) {
				map.put("state", "1");
				map.put("data", pageInfo.getList());
			} else {
				map.put("state", "2");
			}
			
			if (result.size()>0) {
				map.put("state", "1");
				map.put("data", result);
			} else {
				//数据为空
				map.put("state", "2");		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询常用地址异常"+e);
			map.put("state", "3");
		}
		return map;
	}

	@Override
	public Map<String, Object> getCalendar(Integer docloginid, Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*try {
			PageHelper.startPage(page, 5);
			List<Map<String, Object>> result = doctorcalendarMapperCustom.selectAllInfoByDocloginid(docloginid);
		    PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(result);
		    if (pageInfo.getSize()!=0) {
				map.put("state", "1");
				map.put("data", pageInfo.getList());
			} else {
				map.put("state", "2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询日程表异常"+e);
			map.put("state", "3");
		}*/
		return map;
	}

	@Override
	public int addCalendar(Integer docloginid,Date doccalendarday, String doccalendartime,
			String doccalendaraffair, Integer doccalendaradressid) {
		try {
			List<Doctorcalendar> lists = doctorcalendarMapperCustom.selectByDocloginid(docloginid);
			if (lists.size()==0) {
				Doctorcalendar doctorcalendar = new Doctorcalendar();
				doctorcalendar.setDoccalendarday(doccalendarday);
				doctorcalendar.setDoccalendartime(doccalendartime);
				doctorcalendar.setDoccalendaraffair(doccalendaraffair);
				doctorcalendar.setDocloginid(docloginid);
				doctorcalendar.setDoccalendaradressid(doccalendaradressid);
				int result = doctorcalendarMapper.insertSelective(doctorcalendar);
				if (result>0) {
					return 1;
				} else {
					return 2;		
				}
			} else {
				boolean flag = true;
				for (Doctorcalendar doctorcalendar : lists) {
					if (doccalendarday.getTime()==doctorcalendar.getDoccalendarday().getTime() && doccalendartime.equals(doctorcalendar.getDoccalendartime())) {
						flag = false;
						break;
					}
				}
				if (flag) {
					Doctorcalendar doctorcalendar = new Doctorcalendar();
					doctorcalendar.setDoccalendarday(doccalendarday);
					doctorcalendar.setDoccalendartime(doccalendartime);
					doctorcalendar.setDoccalendaraffair(doccalendaraffair);
					doctorcalendar.setDocloginid(docloginid);
					doctorcalendar.setDoccalendaradressid(doccalendaradressid);
					int result = doctorcalendarMapper.insertSelective(doctorcalendar);
					if (result>0) {
						return 1;
					} else {
						return 2;		
					}
				} else {
					return 3;	
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("新增日程异常"+e);
			return 4;
		}
	}
	@Override
	public int editCalendar(Integer doccalendarid, Integer docloginid,Date doccalendarday, String doccalendartime,
			String doccalendaraffair, Integer doccalendaradressid) {
		try {
			Doctorcalendar calendar = doctorcalendarMapper.selectByPrimaryKey(doccalendarid);
			if (calendar != null) {
				int doctor = calendar.getDocloginid();
				if (docloginid==doctor) {
					Doctorcalendar doctorcalendar = new Doctorcalendar();
					doctorcalendar.setDoccalendarday(doccalendarday);
					doctorcalendar.setDoccalendartime(doccalendartime);
					doctorcalendar.setDoccalendaraffair(doccalendaraffair);
					doctorcalendar.setDocloginid(docloginid);
					doctorcalendar.setDoccalendaradressid(doccalendaradressid);
					doctorcalendar.setDoccalendarid(doccalendarid);
					int result = doctorcalendarMapper.updateByPrimaryKeySelective(doctorcalendar);
					if (result>0) {
						return 1;
					} else {
						return 2;		
					}
				} else {
					//该日程不属于该医生
					return 3;	
				}
			}else {
				//该日程不存在
				return 4;	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("更新日程异常"+e);
			return 5;
		}
	}

	@Override
	public int deleteCalendar(Integer doccalendarid, Integer docloginid) {
		try {
			Doctorcalendar doctorcalendar = doctorcalendarMapper.selectByPrimaryKey(doccalendarid);
			if (doctorcalendar != null) {
				Integer doctor = doctorcalendar.getDocloginid();
				if (docloginid==doctor) {
					Calendar current = Calendar.getInstance();
					Calendar today = Calendar.getInstance();	//今天
					today.set(Calendar.YEAR, current.get(Calendar.YEAR));
					today.set(Calendar.MONTH, current.get(Calendar.MONTH));
					today.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
					//  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
					today.set( Calendar.HOUR_OF_DAY, 0);
					today.set( Calendar.MINUTE, 0);
					today.set(Calendar.SECOND, 0);
					Date day = today.getTime();
					Calendar tridDay = Calendar.getInstance();	
					tridDay.set(Calendar.YEAR, current.get(Calendar.YEAR));
			        tridDay.set(Calendar.MONTH, current.get(Calendar.MONTH));
			        tridDay.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH)+3);
			        tridDay.set( Calendar.HOUR_OF_DAY, 0);
			        tridDay.set( Calendar.MINUTE, 0);
			        tridDay.set(Calendar.SECOND, 0);
			        Date day2 = tridDay.getTime(); 
					Date time = doctorcalendar.getDoccalendarday();
					System.out.println("三天"+tridDay+"time"+time+"今天"+today);
					System.out.println("三天"+day2.getTime());
					System.out.println("某天"+time.getTime());
					System.out.println("今天"+day.getTime());
					System.out.println("结果"+(day2.getTime()>time.getTime() && time.getTime()>day.getTime()));
					if (day2.getTime()>time.getTime() && time.getTime()>day.getTime()) {
						//修改医生定位
						Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
						Doctorinfo info = new Doctorinfo();
						info.setDocaddressprovince(null);
						info.setDocaddresscity(null);
						info.setDocaddressarea(null);
						info.setDocaddressother(null);
						info.setDocaddresslocation(null);
						info.setDocaddresslon(doctorinfo.getDochosplon());
						info.setDocaddresslat(doctorinfo.getDochosplat());
						info.setDocid(doctorinfo.getDocid());
						int docResult = doctorinfoMapperCustom.updateInfoByPrimaryKey(info);
						int result = doctorcalendarMapper.deleteByPrimaryKey(doccalendarid);
						if (result>0 && docResult>0) {
							return 1;
						} else {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							return 2;
						}
						
					} else {
						int result = doctorcalendarMapper.deleteByPrimaryKey(doccalendarid);
						if (result>0) {
							return 3;
						} else {
							return 4;
						}
					}
					
				} else {
					//该日程不属于该医生
					return 5;
				}
			}else {
				//该日程不存在
				return 6;
			}
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			// TODO: handle exception
			return 7;
		}
	}

	@Override
	public int updateAddress(Integer docloginid, Integer docaddressid) {
		try {
			Doctoraddress doctoraddress = doctoraddressMapper.selectByPrimaryKey(docaddressid);
			if (doctoraddress != null) {
				Integer doctor = doctoraddress.getDocloginid();
				if (docloginid.equals(doctor)) {
					boolean checked = doctoraddress.getDocaddresschecked();
					if (!checked) {
						int result = doctoraddressMapperCustom.updateCheckedByDocLoginId(docloginid, 0);
						System.out.println("更新的人数"+result);
						Doctoraddress address = new Doctoraddress();
						address.setDocaddressid(docaddressid);
						address.setDocaddresschecked(true);
						int upResult = doctoraddressMapper.updateByPrimaryKeySelective(address);
						Doctorinfo doctorallinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
						Doctorinfo doctorinfo = new Doctorinfo();
						doctorinfo.setDocaddressprovince(doctoraddress.getDocaddressprovince());
						doctorinfo.setDocaddresscity(doctoraddress.getDocaddresscity());
						doctorinfo.setDocaddressarea(doctoraddress.getDocaddressarea());
						doctorinfo.setDocaddressother(doctoraddress.getDocaddressother());
						doctorinfo.setDocaddresslat(doctoraddress.getDocaddresslat());
						doctorinfo.setDocaddresslon(doctoraddress.getDocaddresslon());
						doctorinfo.setDocaddresslocation(doctoraddress.getDocaddresslocation());
						doctorinfo.setDocid(doctorallinfo.getDocid());
						int infoResult = doctorinfoMapper.updateByPrimaryKeySelective(doctorinfo);
						if (upResult > 0 && infoResult>0) {
							return 1;
						} else {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							return 2;
						}
					} else {
						// 该地址已被设置为当前坐诊位置
						return 3;
					}

				} else {
					// 该地址不属于该医生
					return 4;
				}

			}else {
				// 该地址不存在
				return 5;
			}

		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 6;
		}

	}

	@Override
	public int updateChannelId(Integer docloginid, String channelid) {
		try {
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
		} catch (Exception e) {
			logger.error("更新channelId异常"+e);
			return 4;
		}
		
	}
	@Override
	public int setLocation(String time) {
		Calendar current = Calendar.getInstance();
		Calendar tridDay = Calendar.getInstance();	
		tridDay.set(Calendar.YEAR, current.get(Calendar.YEAR));
        tridDay.set(Calendar.MONTH, current.get(Calendar.MONTH));
        tridDay.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH)+3);
        tridDay.set( Calendar.HOUR_OF_DAY, 0);
        tridDay.set( Calendar.MINUTE, 0);
        tridDay.set(Calendar.SECOND, 0);
        Date day2 = tridDay.getTime(); 
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String time2=df.format(day2);
        System.out.println("时间"+time2);
        List<Doctorcalendar> list = doctorcalendarMapperCustom.selectByDayAndTime(time2, time);
        if (list.size()!=0) {
			for (Doctorcalendar doctorcalendar : list) {
				updateAddress(doctorcalendar.getDocloginid(),doctorcalendar.getDoccalendaradressid());
			}
		}
		return 1;
	}   
	
	
	

	
}