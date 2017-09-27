package com.medical.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.FileImageInputStream;
import javax.validation.constraints.Null;

import org.apache.catalina.User;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.yun.push.utils.PushToAndroid;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.interceptor.MapTokenManager;
import com.medical.interceptor.TokenModel;
import com.medical.mapper.CityMapper;
import com.medical.mapper.CityMapperCustom;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.DoctorskdMapper;
import com.medical.mapper.DoctorskdMapperCustom;
import com.medical.mapper.FamilyinfoMapper;
import com.medical.mapper.FamilyinfoMapperCustom;
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogMapper;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.po.City;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Doctorskd;
import com.medical.po.Familyinfo;
import com.medical.po.Hospitaldept;
import com.medical.po.Preorder;
import com.medical.po.Userinfo;
import com.medical.po.Userlog;
import com.medical.po.Userlogininfo;
import com.medical.po.UserlogininfoCustom;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.po.UsersickCustom;
import com.medical.service.DoctorService;
import com.medical.service.UserService;
import com.medical.utils.CommonUtils;
import com.medical.utils.CreateFileUtil;
import com.medical.utils.MD5Util;
import com.netease.code.MsgCode;
import com.sun.crypto.provider.PBEWithMD5AndDESCipher;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DecimalDV;
import com.sun.swing.internal.plaf.basic.resources.basic;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;


public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
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
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapperCustom doctorlogininfoMapperCustom;
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private DoctorskdMapperCustom doctorskdMapperCustom;
	@Autowired
	private DoctorskdMapper doctorskdMapper;
	@Autowired
	private PreorderMapper preorderMapper;
	@Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private UserorderMapper userorderMapper;
	@Autowired
	private UserorderMapperCustom userorderMapperCustom;
	
	Logger logger = Logger.getLogger(UserService.class);
	
	// 判断手机号码是否注册
	@Override
	public int findUserCount(String phone){
		try {
			// 查询用户登录表
			int count = userlogininfoMapperCustom.findUserCountByPhone(phone);
			if (count== 0) {
				// 未注册
				return 1; 
			} else {
				// 已注册
				return 2; 
			}
		} catch (Exception e) {
			//  操作异常
			logger.error("判断手机号码是否注册异常"+e);
			return 3; 
		}
	}

	// 用户注册
	@Override
	public int createUser(String phone, String password,String code) throws Exception {
		try {
			int count = userlogininfoMapperCustom.findUserCountByPhone(phone);
			if (count==0) {
				//if (MsgCode.checkMsg(phone, code)) {
				if (true) {
					//用户登录信息
					Userlogininfo userlogininfo = new Userlogininfo();
					userlogininfo.setUserloginphone(phone);
					String[] str = MD5Util.generate(password);
					userlogininfo.setUserloginpwd(str[0]); //md5值密码
					userlogininfo.setUserloginsalt(str[1]); //salt值
					userlogininfo.setUserlogintype(false);
					userlogininfo.setUserloginpix("1.jpg");
					userlogininfo.setUserloginname(phone);
					// 写入用户登录表
					int result = userlogininfoMapperCustom.insertSelectiveReturnId(userlogininfo);
					Userinfo userinfo = new Userinfo();
					userinfo.setUserloginid(userlogininfo.getUserloginid());
					userinfo.setUserphone(phone);
					//用户信息表
					int infoResult = userinfoMapper.insertSelective(userinfo);
					if (result >0 && infoResult>0) {
						return 1; // 注册成功
					} else {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return 2; // 注册失败
					}
				} else {
					//验证码错误
					return 3;
				}
				
			} else {
				return 4; //该用户已注册
			}
			
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("用户注册异常"+e);
			return 5; // 操作异常
		}
	}

	// 用户登录
	@Override
	public Map<String, Object> updateUserToLogin(UserlogininfoCustom userlogininfoCustom) throws Exception {
		MapTokenManager mapTokenManager = new MapTokenManager();
		Map<String, Object> map = new HashMap<String, Object>();
		//用户日志表
		Userlog userlog = new Userlog();
		//userlog.setUserloginid(userlogininfoCustom.getUserloginid());
		userlog.setUserlogip(userlogininfoCustom.getUserloginip());
		userlog.setUserlogtime(new Date());
		userlog.setUserloglat(userlogininfoCustom.getUserloginlat());
		userlog.setUserloglon(userlogininfoCustom.getUserloginlon());
		userlog.setUserlogmac(userlogininfoCustom.getUserloginmac());
		userlog.setUserlogmodel(userlogininfoCustom.getUserloginmodel());
		userlog.setUserlogpver(userlogininfoCustom.getUserloginpver());
		String phone = userlogininfoCustom.getUserloginphone();
		String acceptedToken = userlogininfoCustom.getUserlogintoken();
		try {
			UserlogininfoCustom user =userlogininfoMapperCustom.findUserLoginInfoByPhone(phone);
			//该号码已注册
			if (user!=null) {
				// 用户名密码验证成功
				boolean state =  MD5Util.verify(userlogininfoCustom.getUserloginpwd(), user.getUserloginsalt(), user.getUserloginpwd());
				if (state) {
					userlogininfoCustom.setUserloginpwd(null);
					//用户登录id
					userlog.setUserloginid(user.getUserloginid());
					userlogininfoCustom.setUserloginid(user.getUserloginid());
					if (acceptedToken == null) { // 没有token重新登录
						TokenModel tokenModel = mapTokenManager.createToken(userlogininfoCustom.getUserloginphone(),
								mapTokenManager.setTokenTime(new Date().getTime(), 30)); // token 过期时间 30天
						userlogininfoCustom.setUserlogintoken(tokenModel.getToken());
						userlogininfoCustom.setUserlogindld(tokenModel.getTime());
						// 更新登录信息
						int upResult = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoCustom);// 更新登录信息
						int inResult = userlogMapper.insertSelective(userlog);// 生成登录日志
						if (upResult == 1 && inResult == 1) {
							map.put("state", "1");// 登录成功
							map.put("token", tokenModel.getToken());
							map.put("username", user.getUserloginname());
							map.put("pix", user.getUserloginpix());
							map.put("type", user.getUserlogintype());
							map.put("id", user.getUserloginid());
						} else {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							map.put("state", "2");; // 登录失败
						}
					} else { // 有token 自动登录
						int result = mapTokenManager.checkToken(acceptedToken);
						if (result == 1) {
							map.put("state", "3");// 当前token不存在
						} else if (result == 2) {
							map.put("state", "4");// token已过期
						} else if (result == 3) {
							 // token延期30天  
							long time = mapTokenManager.addTokenTime(acceptedToken, 30);
							//设置过期时间
							userlogininfoCustom.setUserlogindld(time);
							// 更新登录信息
							int upResult = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoCustom);
							// 生成登录日志
							int inResult = userlogMapper.insertSelective(userlog);
							if (upResult == 1 && inResult == 1) {
								map.put("token", acceptedToken);
								map.put("state", "5"); // 登录成功
								map.put("username", user.getUserloginname());
								map.put("pix", user.getUserloginpix());
								map.put("type", user.getUserlogintype());
								map.put("id", user.getUserloginid());
							} else {
								TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
								map.put("state", "6"); // 登录失败
							}
						}
					}
				} else {
					map.put("state", "7"); // 用户账号密码不匹配
				}
				
			} else {
				map.put("state", "8"); // 该号码未注册
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			map.put("state", "9"); // 操作异常
		}
		return map;
	}
	
	// 用户退出登录
	@Override
	public int updateUserToExit(Integer userloginid) throws Exception {
		MapTokenManager mapTokenManager = new MapTokenManager();	
		try {
				Userlogininfo list = userlogininfoMapper.selectByPrimaryKey(userloginid);
				if(list!=null) {
					if (list.getUserlogintoken()!=null && list.getUserlogintoken().trim()!="") {
						mapTokenManager.deleteToken(list.getUserlogintoken());
						return 1; //退出成功
					}else {
						return 2; // token为空
					}
					
				}else {
					return 3; // 该id对应的记录为空
				}
				
			} catch (Exception e) {
				return 4; // 操作异常
			}
			
		}
	
	// 修改用户头像和昵称
	@Override
	public Map<String, Object> updateUserPixAndUserName(MultipartFile pictureFile,Integer userloginid,String username) throws Exception {
		UserlogininfoCustom userlogininfoCustom = new UserlogininfoCustom();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
			if (userlogininfo!=null) {
				if (!pictureFile.isEmpty()) {
					//真实路径
					String reallyDir ="D:\\\\upload\\\\user\\\\"+userloginid+"\\\\pix\\\\";
					//保存到数据库的路径
					String virtualDir = "user/"+userloginid+"/pix/";
					boolean state = CreateFileUtil.createDir(reallyDir);
					if (state) {
						String name = CommonUtils.randomFileName();
						String ext = "jpg";
						String file =name + "." + ext;
						String reallyPath = reallyDir + file;
						String virtualPath = virtualDir+file;
					    pictureFile.transferTo(new File(reallyPath));
						userlogininfoCustom.setUserloginid(userloginid);
						userlogininfoCustom.setUserloginpix(virtualPath);
						userlogininfoCustom.setUserloginname(username);
						int result = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoCustom); // 更新用户头像
						if (result>0) {
							map.put("state", "1"); //修改成功
							map.put("data", virtualPath);
						} else {
							map.put("state", "2"); //修改失败
						}
					}else {
						//路径创建失败
						map.put("state", "3");
					}
				} else {
					userlogininfoCustom.setUserloginname(username);
					int result = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoCustom); // 更新用户头像
					if (result>0) {
						map.put("state", "4"); //修改成功
					} else {
						map.put("state", "5");//修改失败
					}
				}
				
			} else {
				map.put("state", "6");//该id对应的记录为空
			}
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			map.put("state", "7"); //操作异常
		}
		return map;
	}

	/*// 获取用户头像
	@Override
	public Map<String, Object> getUserPix(String phone) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			UserlogininfoCustom list = userlogininfoMapperCustom.findUserLoginInfoByPhone(phone);
			if (list.getUserloginpix() != null && list.getUserloginpix().trim() != "") {
				try {
                    String data = list.getUserloginpix();
					FileImageInputStream input = new FileImageInputStream(new File(data));
					ByteArrayOutputStream output = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					int numBytesRead = 0;
					while ((numBytesRead = input.read(buf)) != -1) {
						output.write(buf, 0, numBytesRead);
					}
					byte[] bytes = output.toByteArray();
					output.close();
					input.close();
					map.put("state", "1"); // 获取成功
					map.put("data", bytes);
				} catch (Exception e) {
					map.put("state", "2"); // 获取头像失败
				}
			} else {
				map.put("state", "3"); // 头像为空
			}
		} catch (Exception e) {
			map.put("state", "4"); // 操作异常
		}
		return map;
	}
*/
	/*// 修改昵称
	@Override
	public int updateUserName(String phone, String username) throws Exception {
		UserlogininfoCustom userlogininfoCustom = new UserlogininfoCustom();
		try {
			UserlogininfoCustom list = userlogininfoMapperCustom.findUserLoginInfoByPhone(phone);
			userlogininfoCustom.setUserloginid(list.getUserloginid());
			userlogininfoCustom.setUserloginname(username);
			int result = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoCustom);
			if (result==1) {
				return 1; // 更新数据成功
			}else {
				return 2; // 更新失败
			}
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 3; // 操作异常
		}

	}*/

	// 修改密码
	@Override
	public int updatePassword(String phone, String password,String code) throws Exception {
		UserlogininfoCustom userlogininfoCustom = new UserlogininfoCustom();
		try {
			//if (MsgCode.checkMsg(phone, code)) {
			if (true) {
				UserlogininfoCustom list = userlogininfoMapperCustom.findUserLoginInfoByPhone(phone);
				if (list!=null) {
					userlogininfoCustom.setUserloginid(list.getUserloginid());
					String[] str = MD5Util.generate(password);
					userlogininfoCustom.setUserloginpwd(str[0]); //md5值密码
					userlogininfoCustom.setUserloginsalt(str[1]); //salt值
					int result = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoCustom);
					if (result > 0) {
						//修改成功
						return 1;
					} else {
						//修改失败
						return 2;
					}
				} else {
					//该号码为注册
					return 3;
				}
			}else {
				return 4;
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 5;//操作异常
		}
	}

	// 获取用户信息
	@Override
	public Map<String, Object> findUserInfo(Integer userloginid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> userMap = userinfoMapperCustom.findUserInfoByLoginId(userloginid);
			if (userMap != null) { // 该id对应的记录不为空
				map.put("state", "1");
				map.put("data", userMap); // 个人信息
			} else {
				map.put("state", "2"); // 对应的个人信息为空
			}

		} catch (Exception e) {
             map.put("state", "3");// 操作异常
		}
		return map;
	}

	// 修改用户信息
	@Override
	public int updateUserInfo(Integer userloginid, String username, String usermale, String usercardnum, String useradrprovince,
			String useradrcity, Integer userage, String useradrarea, String useradrother, MultipartFile[] pictureFile) throws Exception {
		try {
			Userinfo user = userinfoMapperCustom.selectByLoginId(userloginid);
			if (user != null) {
				Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
				boolean type = userlogininfo.getUserlogintype();
				// 未审核
				if (!type) {
					Userinfo userinfo = new Userinfo();
					String reallyDir = "D:\\\\upload\\\\user\\\\" + userloginid + "\\\\card\\\\";
					// 保存到数据库的路径
					String virtualDir = "user/" + userloginid + "/card/";
					boolean state = CreateFileUtil.createDir(reallyDir);
					if (state) {
						String fileName = null;
						// 图片重命名及保存
						for (int i = 0; i < pictureFile.length; i++) {
							String name = CommonUtils.randomFileName();
							String ext = "jpg";
							String file = name + "." + ext;
							String reallyPath = reallyDir + file;
							String virtualPath = virtualDir + file;
							pictureFile[i].transferTo(new File(reallyPath));
							if (i != pictureFile.length - 1) {
								fileName += virtualPath + ",";
							} else {
								fileName += virtualPath;
							}
						}
						userinfo.setUseradrprovince(useradrprovince);
						userinfo.setUseradrcity(useradrcity);
						userinfo.setUseradrarea(useradrarea);
						userinfo.setUseradrother(useradrother);
						userinfo.setUserage(userage);
						userinfo.setUsercardnum(usercardnum);
						userinfo.setUserid(user.getUserid());
						userinfo.setUsername(username);
						userinfo.setUsermale(usermale);
						userinfo.setUsercardphoto(fileName);
						int result = userinfoMapper.updateByPrimaryKeySelective(userinfo);
						Familyinfo familyinfo = new Familyinfo();
						familyinfo.setFamilyage(userage);
						familyinfo.setFamilymale(usermale);
						familyinfo.setFamilyname(username);
						familyinfo.setUserloginid(userloginid);
						familyinfo.setFamilytype(true);// "1"为用户本人
						List<Familyinfo> list = familyinfoMapperCustom.selectByUserLoginIdAndType(userloginid,1);
						int familyResult =0; 
						if (list.size()==0) {
							familyResult = familyinfoMapper.insertSelective(familyinfo); // 插入到亲属信息表
						} else {
							Integer id = list.get(0).getFamilyid();
							familyinfo.setFamilyid(id);
							familyResult = familyinfoMapper.updateByPrimaryKey(familyinfo);
						}
						if (result > 0 && familyResult>0) {
							return 1; // 操作成功
						} else {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							return 2; // 操作失败
						}

					} else {
						//创建路径失败
						return 3; 
					}
				} else {
					//该用户已审核
					return 4; 
				}

			} else {
				return 5; // 该id对应的记录为空
			}

		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 6; // 操作异常
		}
	}

	// 查询亲属信息
	@Override
	public Map<String, Object> findFamily(Integer userloginid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Familyinfo> familyList = familyinfoMapperCustom.findByUserLoginId(userloginid);
			if (familyList!=null) {
				map.put("state", "1"); // 查询成功
				map.put("data", familyList);
			} else {
				map.put("state", "2"); // 查询出的亲属为空
			}
			
		} catch (Exception e) {
			map.put("state", "3"); // 操作异常
		}
		return map;
	}

	// 添加亲属信息
	@Override
	public int insertFamily(Familyinfo familyinfo) throws Exception {
		try {
			Integer age =  familyinfo.getFamilyage();
			String male = familyinfo.getFamilymale();
			String name =  familyinfo.getFamilyname();
			List<Familyinfo> lists = familyinfoMapperCustom.selectByUserLoginIdAndType(familyinfo.getUserloginid(), 0);
			boolean type =  false;
			for (Familyinfo list :lists) {
				if (age==list.getFamilyage()&&male.equals(list.getFamilymale())&&name.equals(list.getFamilymale())) {
					type = true;
					break;
				}
				
			}
			if (!type) {
				int result = familyinfoMapperCustom.insertReturnId(familyinfo);
				if (result > 0) {
					return 1;
				} else {
					return 2;
				}
			} else {
				return 3;
			}
			
		} catch (Exception e) {
			return 4;
		}
		
	}

	// 修改亲属信息
	@Override
	public int updateFamily(Familyinfo familyinfo) throws Exception {
		try {
			Familyinfo family = familyinfoMapper.selectByPrimaryKey(familyinfo.getFamilyid());
			if (family!=null) {
				boolean type= family.getFamilytype();
				if (!type) {
					int result = familyinfoMapper.updateByPrimaryKeySelective(familyinfo);
					if (result > 0) {
						return 1;// 修改成功
					} else {
						return 2; // 修改失败
					}
				}else {
					return 3; // 无法修改
				}
			} else {
				return 4; // 对应亲属信息为空
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return 5; // 异常错误
		}
		
	} 

	// 删除亲属信息
	@Override
	public int deleteFamily(Integer familyid) throws Exception {
		try {
			Familyinfo familyinfo = familyinfoMapper.selectByPrimaryKey(familyid);
			boolean type= familyinfo.getFamilytype();
			if (!type) {
				int result = familyinfoMapper.deleteByPrimaryKey(familyid);
				if (result == 1) {
					return 1; //删除成功
				} else {
					return 2; //删除失败
				}
			} else {
					return 3; // 为用户本人，无法删除
			}
			

		} catch (Exception e) {
			return 4; // 删除异常
		}
	}
	
	//查询城市
	@Override
	public List<City> findCity(String code) throws Exception {
		try {
			List<City> list = cityMapperCustom.selectByParentCode(code);
			return list;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	//获取全部病情
	@Override
	public Map<String, Object> findSicks(Integer userloginid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> list = usersickMapperCustom.selectAllInfoByUserLoginId(userloginid);
			if (list!=null) {
				map.put("state", "1");
				map.put("data", list);// 获取成功
			}else {
				map.put("state", "2"); //数据为空
			}
			
		} catch (Exception e) {
			map.put("state", "3"); // 异常错误
		}
		return map;
	}

	// 获取病情信息
	@Override
	public Map<String, Object> getSickInfo(Integer usersickid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			Map<String, Object> resultMap = usersickMapperCustom.selectById(usersickid);
			if (resultMap != null) {
				map.put("state", "1");
				map.put("data", resultMap);// 获取成功
			} else {
				map.put("state", "2"); // 数据为空
			}
		} catch (Exception e) {
			map.put("state", "3"); // 异常错误
		}
		return map;
	}
	
	// 删除病情信息
	@Override
	public int deleteSick(Integer usersickid) throws Exception {
		try {
			Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
			Integer stateid =  usersick.getUsersickstateid();
			if (stateid<3) {
				int result = usersickMapper.deleteByPrimaryKey(usersickid);
				if (result > 0) {
					return 1; // 删除成功
				} else {
					return 2; // 删除失败
				}
			} else {
				//该状态不支持删除
				return 3;
			
			}
			
		} catch (Exception e) {
			return 4; // 操作异常
		}
	}

/*	// 获取用户头像
	@Override
	public byte[] getUserSickPix(String fileName) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		byte[] bytes = null;
		try {
			FileImageInputStream input = new FileImageInputStream(new File("D:\\upload\\" + fileName+".png"));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			bytes = output.toByteArray();
			output.close();
			input.close();
		} catch (Exception e) {
			bytes = null;
		}
		return bytes;
	}*/
	

	// 插入病情信息
	@Override
	public int addSick(MultipartFile[] pictureFile, UsersickCustom usersickCustom) throws Exception {
		try {
			int userloginid = usersickCustom.getUserloginid();
			Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
			if (user!=null) {
				Usersick usersick = new Usersick();
				
				//真实路径
				String reallyDir ="D:\\\\upload\\\\user\\\\"+userloginid+"\\\\sick\\\\";
				//保存到数据库的路径
				String virtualDir = "user/"+userloginid+"/sick/";
				boolean state = CreateFileUtil.createDir(reallyDir);
				if (state) {
					String fileName = null;
					// 图片重命名及保存
					for (int i = 0; i < pictureFile.length; i++) {
						String name = CommonUtils.randomFileName();
						String ext = "jpg";
						String file =name + "." + ext;
						String reallyPath = reallyDir + file;
						String virtualPath = virtualDir+file;
					    pictureFile[i].transferTo(new File(reallyPath));
						if (i != pictureFile.length - 1) {
							fileName += virtualPath + ",";
						} else {
							fileName += virtualPath;
						}
					}
					System.out.println("照片"+fileName);
					usersick.setUsersickpic(fileName);
					usersick.setFamilyid(usersickCustom.getFamilyid());
					usersick.setUserloginid(user.getUserloginid());
					usersick.setUsersickprimarydept(usersickCustom.getUsersickprimarydept());
					usersick.setUsersickseconddept(usersickCustom.getUsersickseconddept());
					usersick.setUsersickdesc(usersickCustom.getUsersickdesc());
					usersick.setUsersicktime(new Date());
					int result = usersickMapperCustom.insertSelectiveReturnId(usersick);
					if (result>0) {
						return 1;
					}else {
						return 2; //插入失败
					}
				}else {
					//创建路径失败
					return 3; 
				}
				
			}else {
				return 4;  // id对应的记录为空
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 5; // 异常错误
		}
	}
	
	// 更新病情信息
	@Override
	public int updateSick(MultipartFile[] pictureFile, UsersickCustom usersickCustom) {
		try {
			int usersickid = usersickCustom.getUsersickid();
			Usersick sick = usersickMapper.selectByPrimaryKey(usersickid);
			// id对应病情不为空
			if (sick != null) {
				int userSickStateId = sick.getUsersickstateid();
				if (userSickStateId == 1) {
					int userloginid = sick.getUserloginid();
					Usersick usersick = new Usersick();
					usersick.setUsersickid(usersickid);
					if (pictureFile.length != 0) {
						// 真实路径
						String reallyDir = "D:\\\\upload\\\\user\\\\" + userloginid + "\\\\sick\\\\";
						// 保存到数据库的路径
						String virtualDir = "user/" + userloginid + "/sick/";
						boolean state = CreateFileUtil.createDir(reallyDir);
						// 路径创建成功
						if (state) {
							String fileName = null;
							// 图片重命名及保存
							for (int i = 0; i < pictureFile.length; i++) {
								String name = CommonUtils.randomFileName();
								String ext = "jpg";
								String file = name + "." + ext;
								String reallyPath = reallyDir + file;
								String virtualPath = virtualDir + file;
								pictureFile[i].transferTo(new File(reallyPath));
								if (i != pictureFile.length - 1) {
									fileName += virtualPath + ",";
								} else {
									fileName += virtualPath;
								}
							}
							usersick.setUsersickpic(fileName);
						} else {
							// 路径创建失败
							return 3;
						}
					}
					usersick.setFamilyid(usersickCustom.getFamilyid());
					usersick.setUsersickprimarydept(usersickCustom.getUsersickprimarydept());
					usersick.setUsersickseconddept(usersickCustom.getUsersickseconddept());
					usersick.setUsersickdesc(usersickCustom.getUsersickdesc());
					usersick.setUsersicktime(new Date());
					int result = usersickMapper.updateByPrimaryKeySelective(usersick);
					if (result > 0) {
						// 修改成功
						return 1;
					} else {
						// 修改失败
						return 2;
					}
				} else if (userSickStateId == 2) {
					// 已发布状态,不可修改
					return 4;
				} else {
					// 订单状态,不可修改
					return 5;
				}

			} else {
				// id对应记录为空
				return 6;
			}

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			return 7;
		}
	}
	
	
	
	//获取医生  列表模式
	@Override
	public Map<String, Object> findDoctors(DoctorSearch doctorSearch) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			/*Integer pageNo = pageNo == null ? 1 : pageNo;
			Integer pageSize = pageSize == null ? 3 : pageSize;*/
			PageHelper.startPage(doctorSearch.getPageNo(), doctorSearch.getPageSize());
			List<Map<String, Object>> list = doctorinfoMapperCustom.findDoctorInfoInList(doctorSearch);
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
			map.put("state", "3"); // 操作异常
		}
		return map;
	}

	// 获取单个医生信息
	@Override
	public Map<String, Object> findDoctoInfo(Integer docloginid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> doctor = doctorinfoMapperCustom.findDoctorByDocLoginId(docloginid);
			if (doctor != null) {
				Doctorskd doctorskd = doctorskdMapperCustom.selectByDocLoginId((Integer)doctor.get("docloginid"));
				int[] arr = { doctorskd.getMonam(), doctorskd.getTueam(), doctorskd.getWedam(), doctorskd.getThuam(),
						doctorskd.getFriam(), doctorskd.getSatam(), doctorskd.getSunam(), doctorskd.getMonpm(),
						doctorskd.getTuepm(), doctorskd.getWedpm(), doctorskd.getThupm(), doctorskd.getFripm(),
						doctorskd.getSatpm(), doctorskd.getSunpm() };
				doctor.put("doctorskd", arr);
				map.put("state", "1"); // 获取成功
				map.put("data", doctor);
			} else {
				map.put("state", "2"); // 获取数据为空
			}
		} catch (Exception e) {
			map.put("state", "3"); //操作异常

		}
		return map;
	}

	// 地图模式获取医生信息
	@Override
	public Map<String, Object> findDoctorsInMap(String arg1, String arg2, String arg3, String arg4) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> resultMap= doctorinfoMapperCustom.findDoctorInfoInMap(arg1, arg2, arg3, arg4);
			if (resultMap!=null) {
				map.put("state", "1"); //获取数据成功
				map.put("data", resultMap);
			} else {
				map.put("state", "2"); //获取数据为空
			}
			
		} catch (Exception e) {
			map.put("state", "3"); //操作异常
		}
		return map;
	}

/*	// 获取医生头像
	@Override
	public Map<String, Object> getDoctorPix(int id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Doctorlogininfo list = doctorlogininfoMapper.selectByPrimaryKey(id);
			if (list != null) {
				if (list.getDocloginpix() != null && list.getDocloginpix().trim() != "") {
					map.put("state", "1"); // 获取成功
					map.put("data", list.getDocloginpix());
				} else {
					map.put("state", "2"); // 头像为空
				}
			} else {
				map.put("state", "3"); // 该id对应的数据为空
			}

		} catch (Exception e) {
			map.put("state", "3"); // 操作异常
		}
		return map;
	}*/
	
	// 获取单个医生日程安排
	@Override
	public Map<String, Object> getSchedule(Integer id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Doctorskd doctorskd = doctorskdMapperCustom.selectByDocLoginId(id);
			if (doctorskd != null) {
				map.put("state", "1"); // 获取成功
				// 拼接成数组
				int[] arr = { doctorskd.getMonam(), doctorskd.getTueam(), doctorskd.getWedam(), doctorskd.getThuam(),
						doctorskd.getFriam(), doctorskd.getSatam(), doctorskd.getSunam(), doctorskd.getMonpm(),
						doctorskd.getTuepm(), doctorskd.getWedpm(), doctorskd.getThupm(), doctorskd.getFripm(),
						doctorskd.getSatpm(), doctorskd.getSunpm() };
				map.put("data", arr);
			} else {
				map.put("state", "2"); // 获取数据为空
			}
		} catch (Exception e) {
			map.put("state", "3"); // 操作异常

		}
		return map;
	}

	
	// 根据病情推荐医生
	@Override
	public int creatReDoctor(Integer userSickId,Date date ,String desc,String primaryDept,String secondDept) throws Exception {
		try {
			preorderMapperCustom.deleteByUserSickId(userSickId);
			DoctorSearch doctorSearch =new DoctorSearch();
			doctorSearch.setPageNo(1);
			doctorSearch.setPageSize(5);
			doctorSearch.setPrimaryDept(primaryDept);
			doctorSearch.setSecondDept(secondDept);
			List<Map<String, Object>> resultMap = doctorinfoMapperCustom.findDoctorByInfo(doctorSearch);
			if (resultMap!=null) {
				for (int i = 0; i < resultMap.size(); i++) {
					Preorder preorder = new Preorder();
					preorder.setPreorderdocloginid((Integer) resultMap.get(i).get("docLoginId"));
					preorder.setPreorderstate(1);
					preorder.setUsersickid(userSickId);
					Usersick usersick = usersickMapper.selectByPrimaryKey(userSickId);
					if (usersick!=null) {
						preorder.setPreorderuserloginid(usersick.getUserloginid());
					}
					preorder.setPreordertype(1);
					preorder.setPreordertime(date);
					preorderMapper.insertSelective(preorder);
				
				}
				return 1;
			}else {
				return 2;
			}
		}catch (Exception e) {
			return 3;
		}
		
	}
	
	//获取推荐医生
	@Override
	public Map<String, Object> findReDoctor(Integer userloginid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Usersick> list = usersickMapperCustom.selectByUserLoginIdAndState(userloginid, 2);
			if (list.size()==1) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("id", list.get(0).getUsersickid());
				params.put("lon", 0);
				params.put("lat", 0);
				List<Map<String,Object>> dataMap = preorderMapperCustom.selectByUserSickId(params);
				if (dataMap.size()!=0) {
					map.put("state", "1"); //获取数据成功
					map.put("data", dataMap);
				} else {
					map.put("state", "2"); // 获取数据为空
				}
			}else {
				if (list.size()>1) {
					//系统错误，发布的病情超过一个
					map.put("state", "3");
				} else {
					//没有发布的病情
					map.put("state", "4");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", "5"); // 操作异常
		}
		return map;
	}
	//获取推荐医生详情
	@Override
	public Map<String, Object> findReDoctorDetails(Integer preorderid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String,Object> dataMap = preorderMapperCustom.selectAllInfoByPreOrderId(preorderid);
			if (!dataMap.isEmpty()) {
				Doctorskd doctorskd = doctorskdMapperCustom.selectByDocLoginId((Integer)dataMap.get("docloginid"));
				int[] arr = { doctorskd.getMonam(), doctorskd.getTueam(), doctorskd.getWedam(), doctorskd.getThuam(),
						doctorskd.getFriam(), doctorskd.getSatam(), doctorskd.getSunam(), doctorskd.getMonpm(),
						doctorskd.getTuepm(), doctorskd.getWedpm(), doctorskd.getThupm(), doctorskd.getFripm(),
						doctorskd.getSatpm(), doctorskd.getSunpm() };
				dataMap.put("doctorskd", arr);
				map.put("state", "1"); //获取数据成功
				map.put("data", dataMap);
			} else {
				map.put("state", "2"); // 获取数据为空
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("state", "3"); // 操作异常
		}
		return map;
	}
	
	//发布病情
	@Override
	public int updateSickToPublish(Integer usersickid) throws Exception {
		try {
			Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
			if (usersick!=null) {
				int type = usersick.getUsersickstateid();
				if (type==1) {
					List<Map<String, Object>> maps = usersickMapperCustom.selectAllInfoByUserLoginId(usersick.getUserloginid());
					int state = 1;
					for (Map<String, Object> map:maps) {
						if ((int)map.get("usersickstateid")==2) {
							state =2;
							break;
						} else if ((int)map.get("usersickstateid")==3){
							state =3;
							break;
						}
					}
					if (state==1) { // 可以发布
						Usersick user = new Usersick();
						user.setUsersickid(usersickid);
						user.setUsersickstateid(2); // "2"为发布状态
						user.setUsersickptime(new Date());
						int result = usersickMapper.updateByPrimaryKeySelective(user);
						int reDoctor = creatReDoctor(usersickid,usersick.getUsersicktime(),usersick.getUsersickdesc(), usersick.getUsersickprimarydept(),usersick.getUsersickseconddept());
						if (result>0 && reDoctor>0) {
							return 1; //请求成功
						} else {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							return 2; // 更新数据错误
						}
					} else if (state==2) {
						return 3; //有病情已发布
					} else {
	                    return 4; //有病情已生成订单
					}
				} else {
					return 5;//该病情不可重复发布
				}
				
			} else {
				return 6; // 该Id对应的记录为空
			}
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 7;  // 操作异常
		}
		
		
	}
	
	//取消发布
	@Override
	public int updateSickToCancel(Integer userSickId) throws Exception {
		try {
			Usersick usersick = usersickMapper.selectByPrimaryKey(userSickId);
			if (usersick!=null) {
				int type = usersick.getUsersickstateid();
				if (type==2) {
					Usersick user = new Usersick();
					user.setUsersickid(userSickId);
					user.setUsersickstateid(1); // "1"为草稿
					int result = usersickMapper.updateByPrimaryKeySelective(user);
					int deResult = preorderMapperCustom.deleteByUserSickId(userSickId);
					if (result>0 && deResult>0) {
						return 1; //请求成功
					} else {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return 2; // 更新数据错误
					}
				}else if (type==1) {
					//该病情未发布
					return 3;
				} else if (type==3) {
					//已生成订单
					return 4;
				}else  {
					//该病情已结束
					return 5;
				}
			} else {
				return 6; // 该Id对应的记录为空
			}
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 7;  // 操作异常
		}
		
		
	}
	
	//预选医生
	@Override
	public int addOptDoctor(Integer docloginid, Integer userloginid) throws Exception {
		try {
			List<Usersick> lists = usersickMapperCustom.selectByUserLoginIdAndState(userloginid, 2);
			if (lists.size() == 1) {
				int usersickid = lists.get(0).getUsersickid();
				Preorder preorder = new Preorder();
				preorder.setPreorderdocloginid(docloginid);
				preorder.setPreorderstate(1);
				preorder.setPreorderuserloginid(userloginid);
				List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid,4);
				if (list.size() == 0) { // 该医生未被推荐
					preorder.setUsersickid(lists.get(0).getUsersickid());
					preorder.setPreordertype(4); // 预选医生
					preorder.setPreordertime(new Date());
					int result = preorderMapper.insertSelective(preorder);
					if (result > 0) {
						return 1; // 操作成功
					} else {
						return 2; // 操作失败
					}

				} else {
					return 3; // 该医生已被选

				}
			} else {
				if (lists.size() > 1) {
					// 系统错误，发布的病情超过一个
					return 4;
				} else {
					// 没有发布的病情
					return 5;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("预选医生异常错误"+e);
			return 6;
		}
	}
	
	// 生成订单
	@Override
	public int createOrder(Integer docloginid,Integer userloginid,String userorderappointment)  throws Exception {
		try {
			//查询处于发布状态的病情
			List<Usersick> lists = usersickMapperCustom.selectByUserLoginIdAndState(userloginid, 2);
			if (lists.size() == 1) {
				int usersickid = lists.get(0).getUsersickid();
				//订单信息
				Userorder userorder = new Userorder();
				userorder.setUserorderdocloginid(docloginid);
				//预约时间
				userorder.setUserorderappointment(userorderappointment);
				//下单时间
				userorder.setUserorderptime(new Date()); 
				List<Preorder> preorders = preorderMapperCustom.selectByDocIdAndSickId(docloginid, usersickid);
				if (preorders.size()!=0) {
					List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid, 3);
					if (list.size()==1) {
						userorder.setUserorderrecdocloginid(list.get(0).getPreorderredocloginid());
					}
					userorder.setUserorderstateid(1); // 等待医生确定并完善消息 
					userorder.setUsersickid(usersickid);
					//Usersick user = usersickMapper.selectByPrimaryKey(usersickid);
					userorder.setUserloginid(userloginid);
					// 插入订单
					int result = userorderMapperCustom.insertSelectiveReturnId(userorder);
					Usersick usersick = new Usersick();
					usersick.setUsersickid(usersickid);
					usersick.setUserorderid(userorder.getUserorderid());
					usersick.setUsersickstateid(3); //已生成订单
					// 更新病情信息
					int upResult =usersickMapper.updateByPrimaryKeySelective(usersick);
					if (result>0 && upResult>0) {
						return 1; //成功
					} else {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return 2; // 生成订单失败
					}
				} else {
					return 3; // 该医生未加入候选
				}
			} else {
				if (lists.size() > 1) {
					// 系统错误，发布的病情超过一个
					return 4;
				} else {
					// 没有发布的病情
					return 5;
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("生成订单时异常"+e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 6; //操作异常
		}
		
	}
	
	//取消订单
	@Override
	public int updateOrderToCancel(Integer userOrderId)  throws Exception {
		try {
			Userorder user = userorderMapper.selectByPrimaryKey(userOrderId);
			if (user!=null) {
				int state = user.getUserorderstateid();
				if (state<=3) {
					Userorder userorder = new Userorder();
					userorder.setUserorderid(userOrderId);
					userorder.setUserorderetime(new Date());
					userorder.setUserorderstateid(8); //病人取消订单
					Usersick usersick = new Usersick();
					usersick.setUsersickid(user.getUsersickid());
					usersick.setUserorderid(0); //无订单
					usersick.setUsersickstateid(2); //已发布
					// 更新订单
					int result = userorderMapper.updateByPrimaryKeySelective(userorder);
					// 更新病情信息
					int upResult =usersickMapper.updateByPrimaryKeySelective(usersick);
					if (result>0 && upResult>0) {
						return 1; //成功
					} else {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return 2; // 生成订单失败
					}
				} else {
					//该状态订单不支持取消
					return 3;
				}
			} else {
				// 无对应订单
				return 4;
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 5; //操作异常
		}
		
	}
	
	//获取订单
	@Override
	public Map<String, Object> getOrders(Integer userloginid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> order = userorderMapperCustom.selectAllInfoByUserLoginId(userloginid);
			if (order.size()== 1) {
				map.put("state", "1");
				map.put("data", order);
			} else {
				map.put("state", "2");
			}

		} catch (Exception e) {
			map.put("state", "3");
		}
		return map;
	}
	
	// 获取完整订单信息
    @Override
	public Map<String, Object> getOrderAllInfo(Integer userOrderId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> order = userorderMapperCustom.selectAllInfoByUserOrderId(userOrderId);
			if (order != null) {
				map.put("state", "1");
				map.put("data", order);
			} else {
				map.put("state", "2");
			}

		} catch (Exception e) {
			map.put("state", "3");
		}
		return map;
	}
    
    //确认订单
    @Override
    public int updateOrderToConfirm(Integer userOrderId) throws Exception{
    	try {
    		Userorder user = userorderMapper.selectByPrimaryKey(userOrderId);
			if (user!=null) {
				int state = user.getUserorderstateid();
				//订单处于等待病人确定状态
				if (state==2) {
					Userorder userorder = new Userorder();
		    		userorder.setUserorderid(userOrderId);
		    		userorder.setUserorderstateid(3); // 待付款
					int result = userorderMapper.updateByPrimaryKeySelective(userorder);
					if (result>0) {
						/*Userorder info= userorderMapper.selectByPrimaryKey(userOrderId);
						if (info!=null) {
							Doctorlogininfo doctor  =doctorlogininfoMapper.selectByPrimaryKey(info.getUserorderdoc());
							Map<String, Object> user = userinfoMapperCustom.findUserInfoByLoginId(info.getUserloginid());
							if (doctor!=null && user!=null) {
								String[] tags = {doctor.getDocloginphone(),"doctor"};
								String title = "通知";
								String msg = user.get("username")+"病人已确认订单";
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
						}*/
						return 1;
					} else {
						return 2;
					}
				} else {
					//该状态不支持用户确认
					return 3;
				}
			} else {
				// 无对应订单
				return 4;
			}
    	} catch (Exception e) {
			return 5;
		}
    }
   /* //取消订单
    @Override
    public int updateOrderToCancel(int userOrderId) throws Exception{
    	try {
    		Userorder userorder = new Userorder();
    		userorder.setUserorderid(userOrderId);
    		userorder.setUserorderstateid(5); 
			int result = userorderMapper.updateByPrimaryKeySelective(userorder);
			if (result>0) {
				Userorder info= userorderMapper.selectByPrimaryKey(userOrderId);
				if (info!=null) {
					Doctorlogininfo doctor  =doctorlogininfoMapper.selectByPrimaryKey(info.getUserorderdoc());
					Map<String, Object> user = userinfoMapperCustom.findUserInfoByLoginId(info.getUserloginid());
					if (doctor!=null && user!=null) {
						String[] tags = {doctor.getDocloginphone(),"doctor"};
						String title = "通知";
						String msg = user.get("username")+"病人已确认订单";
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
				return 1;
			} else {
				return 4;
			}
		} catch (Exception e) {
			return 5;
		}
    }*/
    //获取历史订单
	@Override
	public Map<String, Object> listOldOrders(Integer userloginid) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> order = userorderMapperCustom.selectByUserLoginId(userloginid);
			if (order.size()== 1) {
				map.put("state", "1");
				map.put("data", order);
			} else {
				map.put("state", "2");
			}

		} catch (Exception e) {
			map.put("state", "3");
		}
		return map;
		
	}

}
