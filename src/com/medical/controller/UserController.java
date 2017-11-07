package com.medical.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.Null;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.huanxin.utils.UserManger;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.medical.po.City;
import com.medical.po.DoctorSearch;
import com.medical.po.Familyinfo;
import com.medical.po.Userlogininfo;
import com.medical.po.UserlogininfoCustom;
import com.medical.po.UsersickCustom;
import com.medical.service.UserService;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.user.UserAccountService;
import com.medical.service.iface.user.UserHomeService;
import com.medical.service.iface.user.UserInfoService;
import com.medical.service.iface.user.UserOrderService;
import com.medical.service.iface.user.UserSickService;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.Result;
import com.netease.code.MsgCode;

import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author  作者:xyh
 * @date 创建时间：2017年7月18日 上午09:05:48
 * @version 1.0 
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private UserHomeService userHomeService;
	@Autowired
	private UserSickService userSickService;
	@Autowired
	private UserOrderService userOrderService;
	
	
	
	// 手机号码判断是否注册
	@RequestMapping(value = "/phonetest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "验证手机号码是否注册", httpMethod = "POST", notes = "验证手机号码是否注册", produces = "application/json")
	public String phoneTest(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam(value = "userloginphone") String userloginphone)
			throws Exception {
		if (StringUtils.isNotBlank(userloginphone)) {
			if (userloginphone.trim().length() != 11) {
				return Result.error("该手机号码不是11位");
			}
			boolean result = commonService.findAccountExit(userloginphone);
			if (result) {
				return Result.error("该号码已注册");
			} else {
				return Result.success("该号码未注册");
			}
		} else {
			return Result.error("手机号码为空");
		}
	}

	// 获取短信验证码
	@RequestMapping(value = "/getcode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取短信验证码", httpMethod = "POST", notes = "获取短信验证码", produces = "application/json")
	public String getCode(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam String userloginphone)
			throws Exception {
		if (StringUtils.isNotBlank(userloginphone)) {
			if (userloginphone.trim().length() != 11) {
				return Result.error("该手机号码不是11位");
			}
			boolean result = commonService.getMsgCode(userloginphone);
			if (result) {
				return Result.success("获取验证码成功");
			} else {
				return Result.error("获取短信验证码失败");
			}
		} else {
			return Result.error("手机号码为空");
		}
	}
	
	// 用户注册
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "用户注册", httpMethod = "POST", notes = "用户注册")
	public String userRegister(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam(value = "userloginphone") String userloginphone,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam(value = "userloginpwd") String userloginpwd,
			@ApiParam(name = "code", required = true, value = "短信验证码") @RequestParam String code) throws Exception {
		if (StringUtils.isNotBlank(userloginphone) && StringUtils.isNotBlank(userloginpwd)&& StringUtils.isNotBlank(code)) {
			if (userloginphone.trim().length() != 11) {
				return Result.error("该手机号码不是11位");
			}
			boolean accountExit = commonService.findAccountExit(userloginphone);
			if (!accountExit) {
				//boolean codeResult = commonService.getCodeValidity(userloginphone, code);
				if (true) {
					/*int result = userService.createUser(userloginphone, userloginpwd, code);
					if (1 == result) {
						return Result.success("注册成功");
					} else if (2 == result) {
						return Result.error("注册失败，未知错误");
					} else if (3 == result) {
						return Result.error("注册失败，验证码错误");
					} else if (4 == result) {
						return Result.error("注册失败，该用户已注册");
					} else {
						return Result.error("注册失败，异常错误");
					}*/
					boolean result = userAccountService.createUserAccount(userloginphone, userloginpwd);
					if (result) {
						return Result.success("注册成功");
					} else {
						return Result.error("注册失败，未知错误");
					}
				} else {
					return Result.error("验证码错误");
				}
			} else {
				return Result.error("该号码已注册");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (StringUtils.isBlank(userloginpwd)) {
				errList.add("密码为空"); 
			}
			if (StringUtils.isBlank(userloginphone)) {
				errList.add("手机号码为空");
			}
			if (StringUtils.isBlank(code)) {
				errList.add("短信验证码为空");
			}
			return Result.error(errList.toString().replace("[", "").replace("]", ""));
		}
	}
	
	//环信注册
	@RequestMapping(value = "/huanxinregister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "环信注册", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "环信注册")
	public String huanXinRegister(@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam(value = "userloginid") Integer userloginid,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam(value = "userloginpwd") String userloginpwd
			) throws Exception {
		if (userloginid != null) {
			boolean result = userAccountService.addHuanXinAccout(userloginid,userloginpwd);
			if (result) {
				return DataResult.success("注册成功");
			} else {
				return DataResult.error("注册失败");
			}
		}else {
			return DataResult.error("id为空");
		}
		
	}
	// 用户登录
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "用户登录", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "用户登录")
	public String userLogin(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam(value = "userloginphone") String userloginphone,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam(value = "userloginpwd") String userloginpwd,
			@ApiParam(name = "userlogintoken", value = "token") @RequestParam(required=false) String userlogintoken)
			throws Exception {
		if (StringUtils.isNotBlank(userloginphone) && StringUtils.isNotBlank(userloginpwd)) {
			Map<String, Object> result = userAccountService.updateUserToLogin(userloginphone, userloginpwd,
					userlogintoken);
			if (result!=null) {
				return DataResult.success("登录成功",result);
			} else {
				return DataResult.error("登录失败");
			}

		} else {
			List<String> errList = new ArrayList<String>();
			if (StringUtils.isBlank(userloginpwd)) {
				errList.add("密码为空"); 
			}
			if (StringUtils.isBlank(userloginphone)) {
				errList.add("手机号码为空"); 
			}
			return Result.error(errList.toString().replace("[", "").replace("]", ""));
		}
		
	}

	// 用户退出登陆
	@RequestMapping(value = "/exit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "用户退出登陆", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "用户退出登陆")
	public String exitUserLoginInfo(
			@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam(value = "userloginid") Integer userloginid)
			throws Exception {
		if (userloginid != null) {
			boolean result = userAccountService.updateUserToExit(userloginid);
			if (result) {
				return DataResult.success("退出登录成功");
			} else {
				return DataResult.error("退出登录失败");
			}
		} else {
			return DataResult.error("id为空");
		}
	}
	
	// 修改密码
	@RequestMapping(value = "/editpassword", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改密码", httpMethod = "POST", notes = "修改密码")
	public String editPassword(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam(value = "userloginphone") String userloginphone,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam(value = "userloginpwd") String userloginpwd,
			@ApiParam(name = "code", required = true, value = "短信验证码") @RequestParam(value = "userloginpwd") String code)
			throws Exception {
		if (userloginphone.trim().length() != 11) {
			return Result.error("该手机号码不是11位");
		}
		if (StringUtils.isNotBlank(userloginphone) && StringUtils.isNotBlank(userloginpwd) && code != null
				&& StringUtils.isNotBlank(code)) {
			// boolean codeResult = commonService.getCodeValidity(userloginphone, code);
			if (true) {
				boolean result = userAccountService.updatePassword(userloginphone, userloginpwd);
				if (result) {
					return DataResult.success("修改成功");
				} else {
					return DataResult.error("修改失败");
				}
			} else {
				return DataResult.error("短信验证码错误");
			}

		} else {
			List<String> errList = new ArrayList<String>();
			if (StringUtils.isBlank(userloginphone)) {
				errList.add("手机号码为空");
			}
			if (StringUtils.isNotBlank(userloginpwd)) {
				errList.add("密码为空");
			}
			if (StringUtils.isNotBlank(code)) {
				errList.add("验证码为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}
	
	
	//更新用户位置信息
	@RequestMapping(value = "/updatelocation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新用户位置信息", httpMethod = "POST", notes = "更新用户位置信息")
	public String updateLocation(
			@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam(value = "userloginid") Integer userloginid,
			@ApiParam(name = "userloginlon", value = "精度") @RequestParam(value = "userloginlon") String userloginlon,
			@ApiParam(name = "userloginlat", value = "纬度") @RequestParam(value = "userloginlat") String userloginlat)
			throws Exception {
		if (userloginid != null && StringUtils.isNotBlank(userloginlon) && StringUtils.isNotBlank(userloginlat)) {
			boolean result = userInfoService.updateLocation(userloginid,userloginlon,userloginlat);
			if (result) {
				return DataResult.success("更新位置信息成功");
			} else {
				return DataResult.error("更新位置信息失败");
			} 
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid!=null) {
				errList.add("用户登陆id为空"); 
			}
			if (StringUtils.isBlank(userloginlon)) {
				errList.add("精度为空"); 
			}
			if (StringUtils.isBlank(userloginlat)) {
				errList.add("纬度为空"); 
			}
			return Result.error(errList.toString().replace("[", "").replace("]", ""));
			
		}
	}

	// 更新channelId
	@RequestMapping(value = "/updatechannelid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新channelId", httpMethod = "POST", notes = "更新channelId")
	public String updateChannelId(@ApiParam(name = "userloginid", value = "病人登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "channelid", value = "channelid") @RequestParam String channelid) throws Exception {
		if (userloginid != null && StringUtils.isNotBlank(channelid)) {
			boolean result = userInfoService.updateChannelId(userloginid, channelid);
			if (result) {
				return DataResult.success("更新成功");
			} else {
				return DataResult.error("更新失败");
			} 
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("登录id为空");
			}
			if (StringUtils.isNotBlank(channelid)) {
				errList.add("channelid为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
	}

	

	// 修改用户头像和昵称
	@RequestMapping(value = "/updateinfo", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改用户头像和昵称", httpMethod = "POST", consumes = "multipart/form-data", notes = "修改用户头像和昵称")
	public String addUserInfo(
			@ApiParam(name = "pictureFile", required = false, value = "图片") @RequestParam(required = false) MultipartFile pictureFile,
			@ApiParam(name = "userloginname", required = false, value = "昵称") @RequestParam(required = false) String userloginname,
			@ApiParam(name = "userloginid", required = true, value = "登录id") @RequestParam Integer userloginid)
			throws Exception {
		boolean state = (pictureFile != null || (userloginname != null && userloginname.trim().length() != 0))
				&& userloginid != null;
		if (state) {
			String result = userInfoService.updateUserPixAndUserName(pictureFile, userloginid, userloginname);
			if (StringUtils.isNotBlank(result)) {
				return DataResult.success("修改成功",result);
			} else {
				return DataResult.error("修改失败");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (pictureFile == null) {
				errList.add("图片为空");
			}
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}
			if (StringUtils.isNotBlank(userloginname
					) ) {
				errList.add("用户昵称为空");
			}
			return Result.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}

	

	// 获取用户信息
	@RequestMapping(value = "/getinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取用户信息", httpMethod = "POST", notes = "获取用户信息")
	public String findUserInfo(
			@ApiParam(name = "userloginid", required = true, value = "登录id") @RequestParam(value = "userloginid") Integer userloginid)
			throws Exception {
		if (userloginid!=null) {
			Map<String, Object> reslutMap = userInfoService.findUserInfo(userloginid);
			if (reslutMap!=null) {
				return DataResult.success("获取成功", reslutMap);
			} else {
				return DataResult.success("个人信息为空");
			}
		} else {
			return DataResult.error("登录id为空");
		}
	}

	// 修改用户信息
	@RequestMapping(value = "/editinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改用户信息", httpMethod = "POST", consumes = "multipart/form-data", notes = "修改用户信息")
	public String editUserInfo(
			@ApiParam(name = "usercardphoto", value = "图片数组") @RequestParam(value = "usercardphoto", required = false) MultipartFile[] pictureFile,
			@ApiParam(name = "username", value = "姓名") @RequestParam(required = false) String username,
			@ApiParam(name = "usermale", value = "性别") @RequestParam(required = false) String usermale,
			@ApiParam(name = "usercardnum", value = "身份证号码") @RequestParam(required = false) String usercardnum,
			@ApiParam(name = "useradrprovince", value = "地址省份") @RequestParam(required = false) String useradrprovince,
			@ApiParam(name = "useradrcity", value = "地址市") @RequestParam(required = false) String useradrcity,
			@ApiParam(name = "useradrarea", value = "地址区县") @RequestParam(required = false) String useradrarea,
			@ApiParam(name = "useradrother", value = "详细地址") @RequestParam(required = false) String useradrother,
			@ApiParam(name = "userage", value = "年龄") @RequestParam(required = false) Integer userage,
			@ApiParam(name = "userloginid", value = "登录id") @RequestParam(required = true) Integer userloginid)
			throws Exception {
		if (userloginid != null) {
			boolean result = userInfoService.updateUserInfo(userloginid, username, usermale, usercardnum, useradrprovince,
					useradrcity, userage, useradrarea, useradrother, pictureFile);
			if (result) {
				return DataResult.success("信息修改成功");
			} else {
				return DataResult.error("信息修改失败");
			}
			
		} else {
			return DataResult.error("该用户的id为空");
		}
	}

	// 查询亲属信息
	@RequestMapping(value = "/findfamily", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "查询亲属信息", httpMethod = "POST", notes = "查询亲属信息")
	public String findFamily(
			@ApiParam(name = "userloginid", required = false, value = "用户登录id") @RequestParam Integer userloginid)
			throws Exception {
		if (userloginid != null) {
			List<Familyinfo> list = userInfoService.findFamily(userloginid);
			if (list!=null && list.size()>0) {
				return DataResult.success("查询成功", list);
			} else {
				return DataResult.success("查询成功，但亲属为空");
			} 
		} else {
			return DataResult.error("id为空");
		}
	}

	// 添加亲属信息
	@RequestMapping(value = "/addfamily", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "添加亲属信息", httpMethod = "POST", notes = "添加亲属信息")
	public @ResponseBody String addFamily(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "familyname", value = "姓名") @RequestParam String familyname,
			@ApiParam(name = "familymale", value = "性别") @RequestParam String familymale,
			@ApiParam(name = "familyage", value = "年龄") @RequestParam Integer familyage) throws Exception {
		if (userloginid!=null&& StringUtils.isNotBlank(familyname) && StringUtils.isNotBlank(familymale) && familyage!=null ) {
			Familyinfo familyinfo = new Familyinfo();
			familyinfo.setFamilyage(familyage);
			familyinfo.setFamilymale(familymale);
			familyinfo.setFamilyname(familyname); 
			familyinfo.setUserloginid(userloginid);
			familyinfo.setFamilytype(false);
			boolean result = userInfoService.addFamily(familyinfo);
			if (result) {
				return DataResult.success("添加成功");
			} else {
				return DataResult.error("添加失败");
			} 
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("登录id为空");
			}
			if (StringUtils.isBlank(familyname) ) {
				errList.add("亲属姓名为空");
			}
			if (StringUtils.isBlank(familymale) ) {
				errList.add("亲属性别为空");
			}
			if (familyage == null) {
				errList.add("亲属年龄为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		
	}

	// 修改亲属信息
	@RequestMapping(value = "/editfamily", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改亲属信息", httpMethod = "POST", notes = "修改亲属信息")
	public @ResponseBody String editFamily(
			@ApiParam(name = "userloginid", value = "登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "familyid", value = "亲属id") @RequestParam Integer familyid,
			@ApiParam(name = "familyname", value = "姓名") @RequestParam(required = false) String familyname,
			@ApiParam(name = "familymale", value = "性别") @RequestParam(required = false) String familymale,
			@ApiParam(name = "familyage", value = "年龄") @RequestParam(required = false) Integer familyage)
			throws Exception {
		if (userloginid!=null && familyid!=null) {
			Familyinfo familyinfo = new Familyinfo();
			familyinfo.setUserloginid(userloginid);
			familyinfo.setFamilyage(familyage);
			familyinfo.setFamilymale(familymale);
			familyinfo.setFamilyname(familyname);
			familyinfo.setFamilyid(familyid);
			familyinfo.setFamilytype(false);
			boolean result = userInfoService.updateFamily(familyinfo);
			if (result) {
				return DataResult.success("修改成功");
			} else {
				return DataResult.error("修改失败");
			} 
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("登录id为空");
			}
			if (familyid == null) {
				errList.add("亲属id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		
	}

	// 刪除亲属信息
	@RequestMapping(value = "/deletefamily", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除亲属信息", httpMethod = "POST", notes = "删除亲属信息")
	public String deleteFamily(@ApiParam(name = "familyid", value = "当前页") @RequestParam Integer familyid)
			throws Exception {
		if (familyid != null) {
			boolean result = userInfoService.deleteFamily(familyid);
			if (result) {
				return DataResult.success("删除成功");
			} else {
				return DataResult.error("删除失败");
			}
		} else {
			return DataResult.error("familyid为空");
		}
	}

	// 获取医生列表模式
	@RequestMapping(value = "/listdoctors", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生列表模式", httpMethod = "POST", consumes = "multipart/form-data", notes = "获取医生列表模式")
	public @ResponseBody String findDoctors(@ApiParam(name = "page", value = "当前页") @RequestParam Integer page,
			@ApiParam(name = "userloginlon", value = "精度") @RequestParam(value = "userloginlon") String userloginlon,
			@ApiParam(name = "userloginlat", value = "纬度") @RequestParam(value = "userloginlat") String userloginlat,
			@ApiParam(name = "dochospprovince", value = "省") @RequestParam(required = false) String dochospprovince,
			@ApiParam(name = "dochospcity", value = "市") @RequestParam(required = false) String dochospcity,
			@ApiParam(name = "dochosparea", value = "区县") @RequestParam(required = false) String dochosparea,
			@ApiParam(name = "date", value = "时间") @RequestParam(required = false) String date,
			@ApiParam(name = "docprimarydept", value = "一级部门") @RequestParam(required = false) String docprimarydept,
			@ApiParam(name = "docseconddept", value = "二级部门") @RequestParam(required = false) String docseconddept)
			throws Exception {
		if(page!=null && page >0) {
			DoctorSearch doctorSearch = new DoctorSearch();
			doctorSearch.setPageNo(page);
			doctorSearch.setPageSize(10);
			doctorSearch.setLat(userloginlat);
			doctorSearch.setLon(userloginlon);
			doctorSearch.setTime(date);
			doctorSearch.setProvince(dochospprovince);
			doctorSearch.setCity(dochosparea);
			doctorSearch.setArea(dochosparea);
			doctorSearch.setPrimaryDept(docprimarydept);
			doctorSearch.setSecondDept(docseconddept);
			//Map<String, Object> resultMap = userService.listDoctor(doctorSearch);
			PageInfo<Map<String, Object>> list = userHomeService.listDoctor(doctorSearch);
			if (list != null && list.getTotal()>0) {
				return DataResult.success("获取成功",list.getList());
			}else {
				return DataResult.success("数据为空");
			}
		}else {
			if (page==null) {
				return DataResult.error("当前页不可为空");	
			} else {
				return DataResult.error("当前页应为大于0的整数");
			}
			
		}
		

	}

	// 获取医生地图模式
	@RequestMapping(value = "/mapdoctors", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生地图模式", httpMethod = "POST", notes = "获取医生地图模式")
	public @ResponseBody String findDoctorInMap(	
			@ApiParam(name = "userloginlon", value = "精度") @RequestParam(value = "userloginlon") String userloginlon,
			@ApiParam(name = "userloginlat", value = "纬度") @RequestParam(value = "userloginlat") String userloginlat
			) throws Exception {
		if (userloginlat != null && userloginlat.trim() != "" && userloginlon != null
				&& userloginlon.trim() != "" ) {
			List<Map<String, Object>> map = userHomeService.findDoctorsInMap(userloginlat, userloginlon);
			if (map != null && map.size()>0) {
				return DataResult.success("获取成功",map);
			}else {
				return DataResult.success("数据为空");
			}
			/*//先计算查询点的经纬度范围  
			double latitude = Double.parseDouble(userloginlat);
			double longitude = Double.parseDouble(userloginlon);
			//地球半径千米 
			double r = 6371; 
			//5千米距离  
	        double dis = 50;
	        double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(latitude*Math.PI/180));  
	        //角度转为弧度  
	        dlng = dlng*180/Math.PI;
	        double dlat = dis/r;  
	        dlat = dlat*180/Math.PI;          
	        double minlat =latitude-dlat;  
	        double maxlat = latitude+dlat;  
	        double minlng = longitude -dlng;  
	        double maxlng = longitude + dlng;  
			Map<String, Object> resultMap = userService.findDoctorsInMap(minlat, maxlat, minlng, maxlng);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功",resultMap.get("data"));
			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("数据为空");
			} else{
				return DataResult.error("异常错误");
			}*/
		} else {
			return DataResult.error("位置信息不完整");
		}
		
	}

	// 获取医生详细信息
	@RequestMapping(value = "/doctorinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生详细信息", httpMethod = "POST", notes = "获取医生详细信息")
	public String findDoctor(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid != null) {
			Map<String, Object> resultMap = userHomeService.findDoctorDetail(docloginid);
			if (resultMap != null) {
				return DataResult.success("获取成功", resultMap);
			}else {
				return DataResult.success("数据为空");
			}
		} else {
			return DataResult.error("医生id为空");
		}

	}

	/*// 获取医生日程
	@RequestMapping(value = "/getschedule", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生日程", httpMethod = "POST", notes = "获取医生日程")
	public String findSchedule(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid != null) {
			Map<String, Object> resultMap = userService.getSchedule(docloginid);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));
			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("请求成功,数据为空");
			} else {
				return DataResult.error("请求异常");
			}
		} else {
			return DataResult.error(" 请求的id为空"); // 请求的id为空
		}

	}*/

	/*// 获取省市区县
	@RequestMapping(value = "/findcities", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取省市区县", httpMethod = "POST", notes = "获取省市区县")
	public @ResponseBody Map<String, Object> findCities(@RequestBody Map<String, String> mess) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String code = mess.get("parentcode");
		if (code != null && code.trim() != "") {
			List<City> list = userService.findCity(code);
			if (list != null) {
				// 请求数据成功
				map.put("state", "1"); 
				map.put("data", list);
				System.out.println("区县" + list.size());
			} else {
				// 请求数据失败
				map.put("state", "2"); 
			}

		} else {
			// 父代码为空
			map.put("state", "3"); 
		}
		return map;
	}*/

	// 新增病情
	@RequestMapping(value = "/addsick", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "新增病情", httpMethod = "POST", consumes = "multipart/form-data", notes = "新增病情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "usersickdesc", value = "病情描述", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "usersickprimarydept", value = "医院一级科室", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "usersickseconddept", value = "医院二级科室", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "userloginid", value = "用户登录id", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "familyid", value = "亲属id", required = true, dataType = "int", paramType = "query") })
	public String addSick(
			@ApiParam(name = "pictureFile", required = false, value = "图片") @RequestParam(required = false) MultipartFile[] pictureFile,
			@ApiIgnore @Valid UsersickCustom usersickCustom, BindingResult bindingResult) throws Exception {
		// 获取校验错误信息
		if (bindingResult.hasErrors()) {
			List<String> errList = new ArrayList<String>();
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				errList.add(objectError.getDefaultMessage());
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		} else {
			boolean result = userSickService.addSick(pictureFile, usersickCustom);
			if (result) {
				return DataResult.success("新增病情成功");
			}else {
				return DataResult.error("新增病情失败");
			}
			/*int result = userService.addSick(pictureFile, usersickCustom);
			if (1 == result) {
				return DataResult.success("新增病情成功");
			} else if (2 == result) {
				return DataResult.error("新增病情失败");
			} else if (3 == result) {
				return DataResult.error("创建路径失败");
			} else if (4 == result) {
				return DataResult.error("当前用户未审核，不可发布病情");
			} else if (5 == result) {
				return DataResult.error("id对应的记录为空");
			} else {
				return DataResult.error("异常错误");
			}*/

		}

	}

	// 获取病情
	@RequestMapping(value = "/getsick", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情", httpMethod = "POST", notes = "获取病情")
	public @ResponseBody String getSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "type", value = "病情类型,不填获取全部 ,1是未发布的病情 ,2是已发布和生成订单的") @RequestParam(required=false) Integer type) throws Exception {
		if (userloginid != null) {
			if (type!=null && type >2) {
				return DataResult.error("type超出范围");
			}
			List<Map<String, Object>> list = userSickService.listSicks(userloginid, type);
			if (list != null && list.size()>0) {
				return DataResult.success("获取成功", list);
			}else {
				return DataResult.success("数据为空",null);
			}
			/*Map<String, Object> resultMap = userService.findSicks(userloginid,type);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));
			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("请求成功,数据为空");
			} else {
				return DataResult.error("请求异常");
			}*/
		} else {
			return DataResult.error("用户id为空");
		}

	}

	// 获取病情详情
	@RequestMapping(value = "/getonesick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情详情", httpMethod = "POST", notes = "获取病情详情")
	public String getOneSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam(required=false) Integer userloginid,
			@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid)
			throws Exception {
		if (usersickid != null) {
			Map<String, Object> resultMap = userSickService.getSickDetail(usersickid);
			if (resultMap != null) {
				return DataResult.success("获取成功", resultMap);
			}else {
				return DataResult.success("数据为空",null);
			}
			/*Map<String, Object> resultMap = userService.getSickInfo(usersickid);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));
			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("请求成功,数据为空");
			} else {
				return DataResult.error("请求异常");
			}*/
		} else {
			return DataResult.error("病情id为空");
		}

	}

	// 删除病情
	@RequestMapping(value = "/deletesick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除病情", httpMethod = "POST", notes = "删除病情")
	public String deleteSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam(required=false) Integer userloginid,
			@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid)
			throws Exception {
		if (usersickid != null) {
			boolean result = userSickService.deleteSick(null, usersickid);
			if (result) {
				return DataResult.success("删除成功");
			} else {
				return DataResult.error("删除失败");
			}
			/*int result = userService.deleteSick(usersickid);
			if (1 == result) {
				return DataResult.success("删除成功");
			} else if (2 == result) {
				return DataResult.error("删除失败");
			} else if (3 == result) {
				return DataResult.error("该状态不支持删除");
			} else {
				return DataResult.error("操作异常");
			}
*/
		} else {
			return DataResult.error("病情id为空");
		}

	}

	// 修改病情
	@RequestMapping(value = "/editsick", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改病情", httpMethod = "POST", consumes = "multipart/form-data", notes = "修改病情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userloginid", value = "用户登录id", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "usersickid", value = "病情id", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "usersickdesc", value = "病情描述", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "usersickprimarydept", value = "医院一级科室", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "usersickseconddept", value = "医院二级科室", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "familyid", value = "亲属id", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "usersickpic", value = "原图片路径", required = false, dataType = "String", paramType = "query")})
	public String editSick(
			@ApiParam(name = "pictureFile", required = false, value = "图片") @RequestParam(required = false) MultipartFile[] pictureFile,
			@ApiIgnore  UsersickCustom usersickCustom) throws Exception {
		// 获取校验错误信息
		Integer usersickid = usersickCustom.getUsersickid();
		if (usersickid!=null) {
			boolean result = userSickService.editSick(pictureFile, usersickCustom);
			if (result) {
				return DataResult.success("修改病情成功");
			} else {
				return DataResult.error("修改病情失败");
			}
			/*int result = userService.updateSick(pictureFile, usersickCustom);
			if (1 == result) {
				return DataResult.success("修改病情成功");
			} else if (2 == result) {
				return DataResult.error("修改病情失败");
			} else if (3 == result) {
				return DataResult.error("创建路径失败");
			} else if (4 == result) {
				return DataResult.error("已发布状态,不可修改");
			} else if (5 == result) {
				return DataResult.error("订单状态,不可修改");
			} else if (6 == result) {
				return DataResult.error("id对应记录为空");
			} else {
				return DataResult.error("异常错误");
			}*/
		} else {
			return DataResult.error("病情id为空");
		}

	}
	
	// 发布病情
	@RequestMapping(value = "/publishsick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "发布病情", httpMethod = "POST", notes = "发布病情")
	public String publishSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam(required=false) Integer userloginid,
			@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid)
			throws Exception {
		if (usersickid != null) {
			boolean result = userSickService.updateSickStateToPublish(null, usersickid);
			if (result) {
				return DataResult.success("发布成功");
			} else {
				return DataResult.error("发布失败");
			}
			/*int result = userService.updateSickToPublish(usersickid);
			if (1 == result) {
				return DataResult.success("发布成功");
			} else if (2 == result) {
				return DataResult.error("发布失败");
			} else if (3 == result) {
				return DataResult.error("有病情处于发布状态");
			} else if (4 == result) {
				return DataResult.error("有病情处于订单状态");
			} else if (5 == result) {
				return DataResult.error("病情不可重复发布");
			} else if (6 == result) {
				return DataResult.error("id对应记录为空");
			} else {
				return DataResult.error("异常错误");
			}*/
		} else {
			return DataResult.error("id为空");
		}

	}

	// 取消发布病情
	@RequestMapping(value = "/cancelsick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消发布病情", httpMethod = "POST", notes = "取消发布病情")
	public String cancelSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam(required=false) Integer userloginid,
			@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid)
			throws Exception {
		if (usersickid != null) {
			boolean result = userSickService.updateSickStateToCancel(null, usersickid);
			if (result) {
				return DataResult.success("取消发布成功");
			} else {
				return DataResult.error("取消发布失败");
			}
			/*int result = userService.updateSickToCancel(usersickid);
			if (1 == result) {
				return DataResult.success("取消发布成功");
			} else if (2 == result) {
				return DataResult.error("取消发布失败");
			} else if (3 == result) {
				return DataResult.error("该病情处于未发布状态");
			} else if (4 == result) {
				return DataResult.error("该病情处于订单状态");
			} else if (5 == result) {
				return DataResult.error("该病情已结束");
			} else if (6 == result) {
				return DataResult.error("id对应记录为空");
			} else {
				return DataResult.error("异常错误");
			}*/
		} else {
			return DataResult.error("id为空");
		}

	}

	// 获取当前发布病情相关医生
	@RequestMapping(value = "/getredoctor", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取当前发布病情相关医生", httpMethod = "POST", notes = "获取推荐医生")
	public String getrReDoctor(@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "type", value = "医生类型,不填为所有医生,1为系统推荐医生，2为抢单医生，3为其他医生推荐医生，4为预选医生") @RequestParam(required=false) Integer type)
			throws Exception {
		if (userloginid != null) {
			if (type!=null&&(type>4 || type<1)) {
				return DataResult.error("preordertype超出范围");
			}
			List<Map<String, Object>> resultMap = userSickService.listRelatedDoctor(userloginid, type);
			if (resultMap != null && resultMap.size()>0) {
				return DataResult.success("获取成功", resultMap);
			}else {
				return DataResult.success("获取成功,获取的数据为空",null);
			}
			/*Map<String, Object> resultMap = userService.findReDoctor(userloginid,type);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));

			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功,获取的数据为空");

			} else if ("3".equals(resultMap.get("state"))) {
				return DataResult.error("系统错误，发布的病情超过一个");

			}else if ("4".equals(resultMap.get("state"))) {
				return DataResult.success("当前无正在发布的病情");

			} else {
				return DataResult.error("操作异常");
			}*/
		} else {
			return DataResult.error("id为空");
		}

	}

	/*// 获取推荐医生详情
	@RequestMapping(value = "/getredoctordetail", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取推荐医生详情", httpMethod = "POST", notes = "获取推荐医生")
	public String getrReDoctorInfo(@ApiParam(name = "preorderid", value = "预订单id") @RequestParam Integer preorderid)
			throws Exception {
		if (preorderid != null) {
			Map<String, Object> resultMap = userService.findReDoctorDetails(preorderid);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));

			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.error("获取的数据为空");

			} else {
				return DataResult.error("操作异常");
			}
		} else {
			return DataResult.error("id为空");
		}

	}*/

	// 预选医生
	@RequestMapping(value = "/optdoctor", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "预选医生", httpMethod = "POST", notes = "预选医生")
	public String optDoctor(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid) throws Exception {
		if (docloginid!=null && userloginid!=null) {
			boolean result = userSickService.addRelatedDoctor(docloginid, userloginid);
			if (result) {
				return DataResult.success("成功");
			} else {
				return DataResult.error("失败");
			}
			/*int result = userService.addOptDoctor(docloginid, userloginid);
			if (1 == result) {
				return DataResult.success("成功");
			} else if (2 == result) {
				return DataResult.error("失败");
			} else if (3 == result) {
				return DataResult.error("该医生已被选");
			} else if (4 == result) {
				return DataResult.error("系统错误，发布的病情超过一个");
			} else if (5 == result) {
				return DataResult.error("没有发布的病情");
			} else {
				return DataResult.error("异常错误");
			}*/
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}
			if (docloginid == null) {
				errList.add("医生登录id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		

	}

	// 生成订单
	@RequestMapping(value = "/createorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "生成订单", httpMethod = "POST", notes = "生成订单")
	public String createOrder(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "userorderappointment", value = "预约时间") @RequestParam String userorderappointment) throws Exception {
		if (docloginid!= null && userloginid!=null && StringUtils.isNotBlank(userorderappointment)) {
			boolean result = userOrderService.createOrder(docloginid, userloginid, userorderappointment);
			if (result) {
				return DataResult.success("选择成功");
			} else {
				return DataResult.error("选择"
						+ "失败");
			}
			/*int result = userService.createOrder(docloginid, userloginid, userorderappointment);
			if (1 == result) {
				return DataResult.success("选择成功");
			} else if (2 == result) {
				return DataResult.error("失败");
			} else if (3 == result) {
				return DataResult.error("该医生未加入候选");
			} else if (4 == result) {
				return DataResult.error("系统错误，发布的病情超过一个");
			} else if (5 == result) {
				return DataResult.error("没有发布的病情");
			} else {
				return DataResult.error("异常错误");
			}*/
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}
			if (docloginid == null) {
				errList.add("医生登录id为空");
			}
			if (StringUtils.isBlank(userorderappointment)) {
				errList.add("预约时间为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		

	}

	// 取消订单
	@RequestMapping(value = "/cancelorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消订单", httpMethod = "POST", notes = "取消订单")
	public String cancleOrder(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			                  @ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid)
			throws Exception {
		if (userorderid!=null && userloginid!=null) {
			boolean result = userOrderService.updateOrderStateToCancel(userorderid, userloginid);
			if (result) {
				return DataResult.success("取消成功");
			} else {
				return DataResult.error("取消失败");
			}
			/*int result = userService.updateOrderToCancel(userorderid,userloginid);
			if (1 == result) {
				return DataResult.success("成功");
			} else if (2 == result) {
				return DataResult.error("失败");
			} else if (3 == result) {
				return DataResult.error("该状态订单不支持取消");
			} else if (4 == result) {
				return DataResult.error("用户登录id和订单不匹配");
			} else if (5 == result) {
				return DataResult.error("无对应订单");
			} else {
				return DataResult.error("异常错误");
			}*/
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}
			if (userorderid == null) {
				errList.add("订单id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		

	}

	// 获取订单
	@RequestMapping(value = "/getorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取订单", httpMethod = "POST", notes = "获取订单")
	public String order(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page,
			@ApiParam(name = "type", value = "订单类型，为空获取全部,1代表等待确认的订单，2代表正在进行的,3为待评价的") @RequestParam(required=false) Integer type)
			throws Exception {
		if (userloginid!=null && page!=null) {
			if (type!=null&&type>3) {
				return DataResult.error("type超出范围");
			}
			PageInfo<Map<String, Object>>  pageInfo = userOrderService.listOrders(userloginid, page, type);
			if (pageInfo!=null && pageInfo.getTotal()>0) {
				return DataResult.success("获取成功", pageInfo.getList());
			} else {
				return DataResult.success("获取的数据为空",null);
			}
			/*Map<String, Object> resultMap = userService.getOrders(userloginid,page,type);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));
			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("获取的数据为空");
			} else {
				return DataResult.error("操作异常");
			}*/
		} else {
			return DataResult.error("用户登录id为空");
		}
	}

	// 获取订单详细信息
	@RequestMapping(value = "/orderdetail", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取订单详细信息", httpMethod = "POST", notes = "获取订单详细信息")
	public String orderDetail(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "登录id") @RequestParam Integer userloginid)
			throws Exception {
		Map<String, Object> resultMap =userOrderService.getOrderDetail(userloginid, userorderid);
		if (resultMap!=null) {
			return DataResult.success("获取成功", resultMap);

		} else {
			return DataResult.success("获取的数据为空",null);

		}

	}

	// 确认订单
	@RequestMapping(value = "/confirmorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "确认订单", httpMethod = "POST", notes = "确认订单")
	public String confirmOrder(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid
			)
			throws Exception {
		if (userloginid != null && userorderid!=null) {
			boolean result = userOrderService.updateOrderStateToConfirm(userloginid, userorderid);
			if (result) {
				return DataResult.success("确认成功");
			} else {
				return DataResult.error("确认失败，请重试");
			}
			/*int result = userService.updateOrderToConfirm(userorderid,userloginid);
			if (1 == result) {
				return DataResult.success("成功");
			} else if (2 == result) {
				return DataResult.error("失败");
			} else if (3 == result) {
				return DataResult.error("该状态不支持用户确认");
			} else if (4 == result) {
				return DataResult.error("用户和订单不匹配");
			} else if (5 == result) {
				return DataResult.error("无对应订单");
			} else {
				return DataResult.error("异常错误");
			}*/
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}
			if (userorderid == null) {
				errList.add("订单id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		

	}

	// 支付医生费用
	@RequestMapping(value = "/paydoctor", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "支付医生费用", httpMethod = "POST", notes = "支付医生费用")
	public String paydoctor(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid
			) throws Exception {
		if (userloginid != null && userorderid != null ) {
			boolean result = userOrderService.updateOrderStatePayDoctor(userloginid, userorderid);
			if (result) {
				return DataResult.success("支付成功");
			} else {
				return DataResult.error("支付失败");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}
			if (userorderid == null) {
				errList.add("订单id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}

	// 支付医院押金
	@RequestMapping(value = "/payhospital", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "支付医院押金", httpMethod = "POST", notes = "支付医院押金")
	public String payhospital(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid) throws Exception {
		if (userloginid != null && userorderid != null) {
			boolean result = userOrderService.updateOrderStatePayHospital(userloginid, userorderid);
			if (result) {
				return DataResult.success("支付成功");
			} else {
				return DataResult.error("支付失败");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}
			if (userorderid == null) {
				errList.add("订单id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}

	// 确认是否住院
	@RequestMapping(value = "/confirmohospital", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "确认是否住院", httpMethod = "POST", notes = "确认是否住院")
	public String confirmohospital(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid) throws Exception {
		if (userloginid != null && userorderid != null) {
			boolean result = userOrderService.updateOrderStateToConfirm(userloginid, userorderid);
			if (result) {
				return DataResult.success("确认成功");
			} else {
				return DataResult.error("确认失败，请重试");
			}
			/*
			 * int result = userService.updateOrderToConfirm(userorderid,userloginid); if (1
			 * == result) { return DataResult.success("成功"); } else if (2 == result) {
			 * return DataResult.error("失败"); } else if (3 == result) { return
			 * DataResult.error("该状态不支持用户确认"); } else if (4 == result) { return
			 * DataResult.error("用户和订单不匹配"); } else if (5 == result) { return
			 * DataResult.error("无对应订单"); } else { return DataResult.error("异常错误"); }
			 */
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}
			if (userorderid == null) {
				errList.add("订单id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}
	
	//评价
	@RequestMapping(value = "/evaluate", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "对订单进行评价", httpMethod = "POST", notes = "对订单进行评价")
	public String evaluate(
			@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "doccommentservicelevel", value = "医生服务水平(1-5五个等级)") @RequestParam Integer doccommentservicelevel,
			@ApiParam(name = "doccommentprofessionallevel", value = "医生专业水平(1-5五个等级)") @RequestParam Integer doccommentprofessionallevel,
			@ApiParam(name = "doccommentpricelevel", value = "医生价格水平(1-5五个等级)") @RequestParam Integer doccommentpricelevel,
			@ApiParam(name = "doccommentwords", value = "对医生的评价") @RequestParam String doccommentwords,
			@ApiParam(name = "hospcommentservicelevel", value = "医院服务水平(1-5五个等级)") @RequestParam(required=false) Integer hospcommentservicelevel,
			@ApiParam(name = "hospcommentenvironmenlevel", value = "医生环境水平(1-5五个等级)") @RequestParam(required=false) Integer hospcommentenvironmenlevel,
			@ApiParam(name = "hospcommentpricelevel", value = "医生价格水平(1-5五个等级)") @RequestParam(required=false) Integer hospcommentpricelevel,
			@ApiParam(name = "hospcommentwords", value = "对医院的评价") @RequestParam(required=false) String hospcommentwords
			)
			throws Exception {
		if (userloginid != null && userorderid!=null) {
			int result = userService.insertEvaluate(userorderid,userloginid,doccommentservicelevel,doccommentprofessionallevel,doccommentpricelevel,doccommentwords,hospcommentservicelevel,hospcommentenvironmenlevel,hospcommentpricelevel,hospcommentwords);
			if (1 == result) {
				return DataResult.success("评论成功");
			} else if (2 == result) {
				return DataResult.error("对医生评论失败");
			} else if (3 == result) {
				return DataResult.error("对医院评论失败");
			} else if (4 == result) {
				return DataResult.error("更新订单状态失败");
			} else if (5 == result) {
				return DataResult.error("该订单状态不支持评价");
			} else if (6 == result) {
				return DataResult.error("该订单不属于该用户");
			} else {
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}
			if (userorderid == null) {
				errList.add("订单id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		

	}

	// 获取医生评价
	@RequestMapping(value = "/getevaluation", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生评价", httpMethod = "POST", notes = "获取医生评价")
	public String getEvaluation(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page) throws Exception {
		if (docloginid != null && page != null) {
			if (page < 0) {
				return DataResult.error("当前页应大于0");
			}
			
			Map<String, Object> result = userService.getEvaluation(docloginid, page);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("获取数据成功", result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("获取数据成功,但数据为空");
			} else {
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (docloginid == null) {
				errList.add("医生登录id为空");
			}
			if (page == null) {
				errList.add("当前页为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}
	

}