package com.medical.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.Null;

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
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.medical.po.City;
import com.medical.po.DoctorSearch;
import com.medical.po.Familyinfo;
import com.medical.po.UserlogininfoCustom;
import com.medical.po.UsersickCustom;
import com.medical.service.UserService;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.Result;
import com.netease.code.MsgCode;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
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

	// 手机号码判断是否注册
	@RequestMapping(value = "/phonetest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "验证手机号码是否注册", httpMethod = "POST", notes = "验证手机号码是否注册", produces = "application/json")
	public String phoneTest(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam(value = "userloginphone") String userloginphone)
			throws Exception {
		if (userloginphone != null && userloginphone.trim().length() != 0) {
			int result = userService.findUserCount(userloginphone);
			if (1 == result) {
				return Result.success("未注册");
			} else if (2 == result) {
				return Result.error("已注册");
			} else {
				return Result.error("操作异常");
			}
		} else {
			return Result.error("手机号码为空");
		}
	}

	// 获取短信验证码
	@RequestMapping(value = "/getcode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取短信验证码", httpMethod = "POST", notes = "获取短信验证码", produces = "application/json")
	public String getCode(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam(value = "userloginphone") String userloginphone)
			throws Exception {
		if (userloginphone != null && userloginphone.trim().length() != 0) {
			Map<String, Object> result = MsgCode.getCode(userloginphone);
			double code = (double) result.get("code");
			if (code == 200) {
				return Result.success("成功");
			} else {
				return Result.error("获取短信失败,错误代码为" + code);
			}
		} else {
			return Result.error("手机号码为空");
		}
	}

	// 用户注册
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "用户注册", httpMethod = "POST", notes = "用户注册", produces = "application/json")
	public String userRegister(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam(value = "userloginphone") String userloginphone,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam(value = "userloginpwd") String userloginpwd,
			@ApiParam(name = "code", required = true, value = "短信验证码") @RequestParam String code) throws Exception {
		if (userloginphone != null && userloginphone.trim().length() != 0 && userloginpwd != null
				&& userloginpwd.trim().length() != 0) {
			int result = userService.createUser(userloginphone, userloginpwd, code);
			if (1 == result) {
				return Result.success("注册成功");
			} else if (2 == result) {
				return Result.error("注册失败");
			} else if (3 == result) {
				return Result.error("验证码错误");
			} else if (4 == result) {
				return Result.error("该用户已注册");
			} else {
				return Result.error("操作异常");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginphone == null || userloginphone.trim().length() != 0) {
				errList.add("密码为空"); // 密码为空
			}
			if (userloginpwd == null || userloginpwd.trim().length() != 0) {
				errList.add("手机号码为空"); // 手机号码为空
			}
			if (code == null || code.trim().length() != 0) {
				errList.add("短信验证码为空"); // 手机号码为空
			}
			return Result.error(errList.toString().replace("[", "").replace("]", ""));
		}
	}

	// 用户登录
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "用户登录", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "用户登录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userloginphone", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "userloginpwd", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "userlogintoken", required = false, dataType = "String", paramType = "query") })
	public String userLogin(@ApiIgnore UserlogininfoCustom userlogininfoCustom) throws Exception {
		String userloginphone = userlogininfoCustom.getUserloginphone();
		String userloginpwd = userlogininfoCustom.getUserloginpwd();
		if (userloginphone != null && userloginphone.trim().length() != 0 && userloginpwd != null
				&& userloginpwd.trim().length() != 0) {
			Map<String, Object> result = userService.updateUserToLogin(userlogininfoCustom);
			if ("1".equals(result.get("state"))) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("token", result.get("token"));
				map.put("username", result.get("username"));
				map.put("pix", result.get("pix"));
				map.put("type", result.get("type"));
				map.put("id", result.get("id"));
				return DataResult.success("登录成功", map);
			} else if ("2".equals(result.get("state"))) {
				return DataResult.error("登录失败", null);
			} else if ("3".equals(result.get("state"))) {
				return DataResult.error("当前token不存在", null);
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("token已过期", null);
			} else if ("5".equals(result.get("state"))) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("token", result.get("token"));
				map.put("username", result.get("username"));
				map.put("pix", result.get("pix"));
				map.put("type", result.get("type"));
				map.put("id", result.get("id"));
				return DataResult.success("自动登录成功", map);
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error(" 登录失败", null);

			} else if ("7".equals(result.get("state"))) {
				return DataResult.error("用户账号密码不匹配", null);

			}
			if ("8".equals(result.get("state"))) {
				return DataResult.error("该号码未注册", null);

			} else {
				return DataResult.error("操作异常", null);

			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginphone == null || userloginphone.trim().length() != 0) {
				errList.add("密码为空"); // 密码为空
			}
			if (userloginpwd == null || userloginpwd.trim().length() != 0) {
				errList.add("手机号码为空"); // 手机号码为空
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
			int result = userService.updateUserToExit(userloginid);
			if (1 == result) {
				return DataResult.success("登录成功");
			} else if (2 == result) {
				return DataResult.error("token为空");
			} else if (3 == result) {
				return DataResult.error("id对应记录为空");
			} else {
				return DataResult.error("操作异常");
			}
		} else {
			return DataResult.error("手机号码为空");
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
		if ((pictureFile != null || (userloginname != null && userloginname.trim().length() != 0))
				&& userloginid != null) {
			Map<String, Object> result = userService.updateUserPixAndUserName(pictureFile, userloginid, userloginname);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("修改成功", result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return DataResult.error("修改失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.error("修改失败，因路径创建失败");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.success("修改昵称成功");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("修改昵称失败");
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("该id对应的记录为空");
			} else {
				return DataResult.error("操作异常");

			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (pictureFile == null) {
				errList.add("图片为空");
			}
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}
			if (userloginname == null || userloginname.trim().length() != 0) {
				errList.add("用户昵称为空");
			}
			return Result.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}

	/*
	 * // 获取用户头像
	 * 
	 * @RequestMapping(value = "/getpix", method = RequestMethod.POST)
	 * 
	 * @ApiOperation(value = "修改用户头像", httpMethod = "POST",notes ="修改用户头像") public
	 * String getUserPix(@ApiParam(name = "phone",required = true,value ="手机号码"
	 * )@RequestParam String use) throws Exception { byte[] bytes = null; if (phone
	 * != null && phone.trim() != "") { Map<String, Object> dataMap =
	 * userService.getUserPix(phone); if ("1".equals(dataMap.get("state"))) {
	 * bytes=(byte[]) dataMap.get("data"); } else { bytes=null; }
	 * 
	 * } return bytes; }
	 */

	/*
	 * // 修改昵称
	 * 
	 * @RequestMapping(value = "/editusername", method = RequestMethod.POST,
	 * produces = "application/json") public Map<String, Object>
	 * editUserName(@RequestBody Map<String, Object> params) throws Exception {
	 * String phone = (String) params.get("phone"); String username = (String)
	 * params.get("username"); Map<String, Object> map = new HashMap<String,
	 * Object>(); if (phone != null && phone.trim() != "" && username != null &&
	 * username.trim() != "") { int result = userService.updateUserName(phone,
	 * username); if (result == 1) { map.put("state", "1"); // 修改成功 } else {
	 * map.put("state", result); //“2”修改失败，“3”修改异常 } } else { List<String> errList =
	 * new ArrayList<String>(); if (phone == null || phone.trim() == "") {
	 * errList.add("手机号码为空"); // 手机号码为空 } if (username == null || username.trim() ==
	 * "") { errList.add("用户昵称为空"); // 用户昵称为空 } map.put("state", "4"); // 请求的数据不完整
	 * map.put("errMsg", errList.toString().replace("[", "").replace("]", "")); //
	 * 错误信息 } return map; }
	 */

	// 修改密码
	@RequestMapping(value = "/editpassword", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改密码", httpMethod = "POST", notes = "修改密码")
	public String editPassword(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam(value = "userloginphone") String userloginphone,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam(value = "userloginpwd") String userloginpwd,
			@ApiParam(name = "code", required = true, value = "短信验证码") @RequestParam(value = "userloginpwd") String code)
			throws Exception {
		if (userloginphone != null && userloginphone.trim().length() != 0 && userloginpwd != null
				&& userloginpwd.trim().length() != 0 && code != null && code.trim().length() != 0) {
			int result = userService.updatePassword(userloginphone, userloginpwd, code);
			if (1 == result) {
				return DataResult.success("修改成功");
			} else if (2 == result) {
				return DataResult.error("修改失败");
			} else if (3 == result) {
				return DataResult.error("该号码未注册");
			} else if (4 == result) {
				return DataResult.error("短信验证码错误");
			} else {
				return DataResult.error("操作异常");
			}

		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginphone == null || userloginphone.trim().length() == 0) {
				errList.add("手机号码为空"); // 手机号码为空
			}
			if (userloginpwd == null || userloginpwd.trim().length() == 0) {
				errList.add("密码为空"); // 密码为空
			}
			if (code == null || code.trim().length() == 0) {
				errList.add("密码为空"); // 密码为空
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}

	// 获取用户信息
	@RequestMapping(value = "/getinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取用户信息", httpMethod = "POST", notes = "获取用户信息")
	public String findUserInfo(
			@ApiParam(name = "userloginid", required = true, value = "登录id") @RequestParam(value = "userloginid") Integer userloginid)
			throws Exception {
		if (userloginid!=null) {
			Map<String, Object> reslutMap = userService.findUserInfo(userloginid);
			if ("1".equals(reslutMap.get("state"))) {
				return DataResult.success("获取数据成功", reslutMap.get("data"));
			} else if ("2".equals(reslutMap.get("state"))) {
				return DataResult.error("对应的个人信息为空");
			} else {
				return DataResult.error("操作异常");
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
			int result = userService.updateUserInfo(userloginid, username, usermale, usercardnum, useradrprovince,
					useradrcity, userage, useradrarea, useradrother, pictureFile);
			if (result == 1) {
				return DataResult.success("修改成功");

			} else if (result == 2) {
				return DataResult.error("修改失败");

			} else if (result == 3) {
				return DataResult.error("创建路径失败");
			} else if (result == 4) {
				return DataResult.error("该用户已审核");
			}else if (result == 5) {
				return DataResult.error("该id对应的记录为空");
			} else {
				return DataResult.error("操作异常");
			}
		} else {
			return DataResult.error("id为空");
		}
	}

	// 查询亲属信息
	@RequestMapping(value = "/findfamily", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "查询亲属信息", httpMethod = "POST", notes = "查询亲属信息")
	public String findFamily(
			@ApiParam(name = "userloginid", required = false, value = "用户登录id") @RequestParam Integer userloginid)
			throws Exception {
		if (userloginid != null) {
			Map<String, Object> resultMap = userService.findFamily(userloginid);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("查询成功", resultMap.get("data"));
			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("查询成功，但亲属为空");
			} else {
				return DataResult.error("操作异常");
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
		if (userloginid!=null&&familyname!=null&&familyname.trim().length()!=0&&familymale!=null&&familymale.trim().length()!=0&&familyage!=null) {
			Familyinfo familyinfo = new Familyinfo();
			familyinfo.setFamilyage(familyage);
			familyinfo.setFamilymale(familymale);
			familyinfo.setFamilyname(familyname);
			familyinfo.setUserloginid(userloginid);
			familyinfo.setFamilytype(false);
			int result = userService.insertFamily(familyinfo);
			if (result == 1) {
				return DataResult.success("添加成功");
			} else if (result == 2) {
				return DataResult.error("添加失败");
			} else if (result == 3) {
				return DataResult.error("已添加该亲属");
			} else {
				return DataResult.error("操作异常");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("登录id为空");
			}
			if (familyname == null||familyname.trim().length()!=0) {
				errList.add("寝室姓名为空");
			}
			if (familymale == null || familymale.trim().length() != 0) {
				errList.add("亲属年龄为空");
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
			int result = userService.updateFamily(familyinfo);
			if (result == 1) {
				return DataResult.success("修改成功");
			} else if (result == 2) {
				return DataResult.error("修改失败");
			} else if (result == 3) {
				return DataResult.error("修改失败,本人信息不支持修改");
			} else  if (result == 4) {
				return DataResult.error("对应亲属信息为空");
			} else{
				return DataResult.error("异常错误");
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
			int result = userService.deleteFamily(familyid);
			if (result == 1) {
				return DataResult.success("删除成功");
			} else if (result == 2) {
				return DataResult.error("删除失败");
			} else if (result == 3) {
				return DataResult.error("删除失败,为用户本人");
			} else {
				return DataResult.error("操作异常");
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
		Map<String, Object> resultMap = userService.findDoctors(doctorSearch);
		if ("1".equals(resultMap.get("state"))) {
			return DataResult.success("请求成功", resultMap.get("data"));
		} else if ("2".equals(resultMap.get("state"))) {
			return DataResult.success("请求成功但数据为空");
		} else {
			return DataResult.error("操作异常");
		}

	}

	// 获取医生地图模式
	@RequestMapping(value = "/mapdoctors", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生地图模式", httpMethod = "POST", notes = "获取医生地图模式")
	public @ResponseBody String findDoctorInMap(	
			@ApiParam(name = "userloginlon", value = "精度1") @RequestParam(value = "userloginlon") String userloginlon,
			@ApiParam(name = "userloginlat", value = "纬度1") @RequestParam(value = "userloginlat") String userloginlat,
			@ApiParam(name = "userloginlon2", value = "精度2") @RequestParam(value = "userloginlon2") String userloginlon2,
			@ApiParam(name = "userloginlat2", value = "纬度2") @RequestParam(value = "userloginlat2") String userloginlat2) throws Exception {
		
		if (userloginlat != null && userloginlat.trim() != "" && userloginlat2 != null && userloginlat2.trim() != "" && userloginlon != null
				&& userloginlon.trim() != "" && userloginlon2 != null && userloginlon2.trim() != "") {
			Map<String, Object> resultMap = userService.findDoctorsInMap(userloginlat, userloginlat2, userloginlon, userloginlon2);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取数据成功",resultMap.get("data"));
			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("获取数据为空");
			} else{
				return DataResult.error("异常错误");
			}
		} else {
			return DataResult.error("位置信息不完整");
		}
		
	}

	// 获取单个医生详细信息
	@RequestMapping(value = "/doctorinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取单个医生详细信息", httpMethod = "POST", notes = "获取单个医生详细信息")
	public String findDoctor(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid != null) {
			Map<String, Object> resultMap = userService.findDoctoInfo(docloginid);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));

			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("获取的数据为空");

			} else {
				return DataResult.error("操作异常");
			}
		} else {
			return DataResult.error("请求的id为空");
		}

	}

	// 获取医生日程
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

	}

	/*
	 * // 获取医生头像
	 * 
	 * @RequestMapping(value = "/getdoctorpix/{id}", method =
	 * RequestMethod.GET,produces = "application/json;charset=UTF-8") public byte[]
	 * getDoctorPix(@PathVariable String id) throws Exception { byte[] bytes = null;
	 * if (id != null && id.trim() != "") { int doctorLoginId =
	 * Integer.parseInt(id); Map<String, Object> dataMap =
	 * userService.getDoctorPix(doctorLoginId); try { if
	 * ("1".equals(dataMap.get("state"))) { String data = (String)
	 * dataMap.get("data"); FileImageInputStream input = new
	 * FileImageInputStream(new File(data)); ByteArrayOutputStream output = new
	 * ByteArrayOutputStream(); byte[] buf = new byte[1024]; int numBytesRead = 0;
	 * while ((numBytesRead = input.read(buf)) != -1) { output.write(buf, 0,
	 * numBytesRead); } bytes = output.toByteArray(); output.close(); input.close();
	 * } } catch (Exception e) { e.printStackTrace(); bytes = null; }
	 * 
	 * } return bytes; }
	 */

	// 获取省市区县
	@RequestMapping(value = "/findcities", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取省市区县", httpMethod = "POST", notes = "获取省市区县")
	public @ResponseBody Map<String, Object> findCities(@RequestBody Map<String, String> mess) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String code = mess.get("parentcode");
		if (code != null && code.trim() != "") {
			List<City> list = userService.findCity(code);
			if (list != null) {
				map.put("state", "1"); // 请求数据成功
				map.put("data", list);
				System.out.println("区县" + list.size());
			} else {
				map.put("state", "2"); // 请求数据失败
			}

		} else {
			map.put("state", "3"); // 父代码为空
		}
		return map;
	}

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
			int result = userService.addSick(pictureFile, usersickCustom);
			if (1 == result) {
				return DataResult.success("新增病情成功");
			} else if (2 == result) {
				return DataResult.error("新增病情失败");
			} else if (3 == result) {
				return DataResult.error("id对应的记录为空");
			} else {
				return DataResult.error("异常错误");
			}

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
			Map<String, Object> resultMap = userService.findSicks(userloginid,type);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));
			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("请求成功,数据为空");
			} else {
				return DataResult.error("请求异常");
			}
		} else {
			return DataResult.error("用户id为空");
		}

	}

	/*
	 * // 获取病情图片
	 * 
	 * @RequestMapping(value = "/getsickpic/{file}", method =
	 * RequestMethod.GET,produces = "application/json;charset=UTF-8") public byte[]
	 * getSickPic(@PathVariable String file) throws Exception { byte[] bytes = null;
	 * if (file != null) { bytes = userService.getUserSickPix(file); } else { bytes
	 * = null; } return bytes; }
	 */

	// 获取病情详情
	@RequestMapping(value = "/getonesick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情详情", httpMethod = "POST", notes = "获取病情详情")
	public String getOneSick(@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid)
			throws Exception {
		if (usersickid != null) {
			Map<String, Object> resultMap = userService.getSickInfo(usersickid);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));
			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("请求成功,数据为空");
			} else {
				return DataResult.error("请求异常");
			}
		} else {
			return DataResult.error("病情id为空");
		}

	}

	// 删除病情
	@RequestMapping(value = "/deletesick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除病情", httpMethod = "POST", notes = "删除病情")
	public String deleteSick(@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid)
			throws Exception {
		if (usersickid != null) {
			int result = userService.deleteSick(usersickid);
			if (1 == result) {
				return DataResult.success("删除成功");
			} else if (2 == result) {
				return DataResult.error("删除失败");
			} else if (3 == result) {
				return DataResult.error("该状态不支持删除");
			} else {
				return DataResult.error("操作异常");
			}

		} else {
			return DataResult.error("病情id为空");
		}

	}

	// 修改病情
	@RequestMapping(value = "/editsick", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改病情", httpMethod = "POST", consumes = "multipart/form-data", notes = "修改病情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "usersickid", value = "病情id", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "usersickdesc", value = "病情描述", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "usersickprimarydept", value = "医院一级科室", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "usersickseconddept", value = "医院二级科室", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "familyid", value = "亲属id", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "usersickpic", value = "原图片路径", required = false, dataType = "String", paramType = "query")})
	public String editSick(
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
			int result = userService.updateSick(pictureFile, usersickCustom);
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
			}

		}

	}

	// 发布病情
	@RequestMapping(value = "/publishsick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "发布病情", httpMethod = "POST", notes = "发布病情")
	public String publishSick(@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid)
			throws Exception {
		if (usersickid != null) {
			int result = userService.updateSickToPublish(usersickid);
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
			}
		} else {
			return DataResult.error("id为空");
		}

	}

	// 取消发布病情
	@RequestMapping(value = "/cancelsick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消发布病情", httpMethod = "POST", notes = "取消发布病情")
	public String cancelSick(@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid)
			throws Exception {
		if (usersickid != null) {
			int result = userService.updateSickToCancel(usersickid);
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
			}
		} else {
			return DataResult.error("id为空");
		}

	}

	// 获取当前发布病情相关医生
	@RequestMapping(value = "/getredoctor", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取当前发布病情相关医生", httpMethod = "POST", notes = "获取推荐医生")
	public String getrReDoctor(@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "preordertype", value = "医生类型,不填为所有医生,1为系统推荐医生，2为抢单医生，3为其他医生推荐医生，4为预选医生") @RequestParam(required=false) Integer preordertype)
			throws Exception {
		if (userloginid != null) {
			if (preordertype!=null&&preordertype>4) {
				return DataResult.error("preordertype超出范围");
			}
			Map<String, Object> resultMap = userService.findReDoctor(userloginid,preordertype);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));

			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功,获取的数据为空");

			} else if ("3".equals(resultMap.get("state"))) {
				return DataResult.error("系统错误，发布的病情超过一个");

			}
			if ("4".equals(resultMap.get("state"))) {
				return DataResult.error("没有发布的病情");

			} else {
				return DataResult.error("操作异常");
			}
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
			int result = userService.addOptDoctor(docloginid, userloginid);
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
			}
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
		if (docloginid!= null && userloginid!=null && userorderappointment!=null && userorderappointment.trim().length()!=0) {
			int result = userService.createOrder(docloginid, userloginid, userorderappointment);
			if (1 == result) {
				return DataResult.success("成功");
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
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}
			if (docloginid == null) {
				errList.add("医生登录id为空");
			}
			if (userorderappointment==null || userorderappointment.trim().length()==0) {
				errList.add("预约时间为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		

	}

	// 取消订单
	@RequestMapping(value = "/cancleorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消订单", httpMethod = "POST", notes = "取消订单")
	public String cancleOrder(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			                  @ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid)
			throws Exception {
		if (userorderid!=null && userloginid!=null) {
			int result = userService.updateOrderToCancel(userorderid,userloginid);
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

	// 获取订单
	@RequestMapping(value = "/getorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取订单", httpMethod = "POST", notes = "获取订单")
	public String order(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page,
			@ApiParam(name = "type", value = "订单类型，为空获取全部,1代表等待确认的订单，2代表正在进行的") @RequestParam(required=false) Integer type)
			throws Exception {
		if (userloginid!=null && page!=null) {
			if (type!=null&&type>2) {
				return DataResult.error("type超出范围");
			}
			Map<String, Object> resultMap = userService.getOrders(userloginid,page,type);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));
			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("获取的数据为空");

			} else {
				return DataResult.error("操作异常");
			}
		} else {
			return DataResult.error("用户登录id为空");
		}
		

	}

	/*// 获取订单详细信息
	@RequestMapping(value = "/orderdetail", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取订单详细信息", httpMethod = "POST", notes = "获取订单详细信息")
	public String orderDetail(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid)
			throws Exception {
		Map<String, Object> resultMap = userService.getOrderAllInfo(userorderid);
		if ("1".equals(resultMap.get("state"))) {
			return DataResult.success("获取成功", resultMap.get("data"));

		} else if ("2".equals(resultMap.get("state"))) {
			return DataResult.error("获取的数据为空");

		} else {
			return DataResult.error("操作异常");
		}

	}*/

	// 确认订单
	@RequestMapping(value = "/confirmorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "确认订单", httpMethod = "POST", notes = "确认订单")
	public String confirmOrder(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid
			)
			throws Exception {
		if (userloginid != null && userorderid!=null) {
			int result = userService.updateOrderToConfirm(userorderid,userloginid);
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
    
	/*//获取历史订单
	@RequestMapping(value = "/getoldorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取历史订单", httpMethod = "POST", notes = "获取历史订单")
	public String getOldOrders(@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page)
				throws Exception {
		if (userloginid!=null) {
			Integer pageSize = 5;
			Map<String, Object> resultMap = userService.listOldOrders(userloginid,page,pageSize);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));

			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("获取的数据为空");

			} else {
				return DataResult.error("操作异常");
			}
		} else {
			return DataResult.error("用户登录id为空");
		}
		

	}*/
	/*
	 * //取消订单
	 * 
	 * @RequestMapping(value="cancelorder",produces =
	 * "application/json;charset=UTF-8") public Map<String, Object>
	 * cancelOrder(@RequestBody Map<String, String> params) throws Exception{
	 * Map<String, Object> map = new HashMap<String, Object>(); String userOrderId =
	 * params.get("userorderid"); // 订单id if (userOrderId != null &&
	 * userOrderId.trim() != "") { int orderId = Integer.parseInt(userOrderId); int
	 * result = userService.updateOrderToCancel(orderId); map.put("state", result);
	 * 
	 * } else {
	 * 
	 * map.put("state", "6");// id为空 } return map; }
	 */

}