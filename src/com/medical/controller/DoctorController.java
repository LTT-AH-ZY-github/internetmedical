package com.medical.controller;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.internal.lang.annotation.ajcPrivileged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.medical.po.Doctoraddress;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Userorder;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.doctor.DoctorAccountService;
import com.medical.service.iface.doctor.DoctorHomeService;
import com.medical.service.iface.doctor.DoctorInfoService;
import com.medical.service.iface.doctor.DoctorOrderService;
import com.medical.service.iface.user.UserAccountService;
import com.medical.service.impl.CommonServiceImpl;
import com.medical.utils.CheckUtils;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.PaginationResult;
import com.medical.utils.result.Result;
import com.sun.org.apache.regexp.internal.recompile;
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
@RequestMapping(value = "/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorAccountService doctorAccountService;
	@Autowired
	private DoctorInfoService doctorInfoService;
	@Autowired
	private DoctorHomeService doctorHomeService;
	@Autowired
	private DoctorOrderService doctorOrderService;
	@Autowired
	private CommonService commonService;

	// 判断手机号码是否注册
	@RequestMapping(value = "/phonetest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "判断手机号码是否注册", httpMethod = "POST", notes = "判断手机号码是否注册")
	public String phoneTest(@ApiParam(name = "docloginphone", value = "手机号码") @RequestParam String docloginphone)
			throws Exception {
		if (StringUtils.isBlank(docloginphone)) {
			return Result.error("手机号码为空");
		} else {
			if (!CheckUtils.isChinaPhoneLegal(docloginphone)) {
				return Result.error("手机号码格式错误");
			}
			return commonService.findAccountExit(docloginphone);
		}
	}

	// 发送短信验证码
	@RequestMapping(value = "/getmsgcode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "发送短信验证码", httpMethod = "POST", notes = "发送短信验证码")
	public String getMsgCode(@ApiParam(name = "docloginphone", value = "手机号码") @RequestParam String docloginphone)
			throws Exception {
		if (StringUtils.isBlank(docloginphone)) {
			return Result.error("手机号码为空");
		} else {
			if (!CheckUtils.isChinaPhoneLegal(docloginphone)) {
				return Result.error("手机号码格式错误");
			}
			return commonService.getMsgCode(docloginphone);
		}

	}
	
	// 注册
	@RequestMapping(value = "/docregister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "注册", httpMethod = "POST", notes = "注册")
	public String doctorRegister(@ApiParam(name = "docloginphone", value = "手机号码") @RequestParam String docloginphone,
			@ApiParam(name = "docloginpwd", value = "密码") @RequestParam String docloginpwd,
			@ApiParam(name = "code", value = "短信验证码") @RequestParam String code) throws Exception {
		if (StringUtils.isBlank(docloginphone)) {
			return DataResult.error("手机号码为空");
		}
		if (StringUtils.isNotBlank(docloginphone) && !CheckUtils.isChinaPhoneLegal(docloginphone)) {
			return Result.error("手机号码格式错误");
		}
		if (StringUtils.isBlank(docloginpwd)) {
			return DataResult.error("密码为空");
		}
		if (StringUtils.isBlank(code)) {
			return DataResult.error("验证码为空");
		}
		return doctorAccountService.createDoctor(docloginphone, code, docloginpwd);

	}

	// 环信注册
	@RequestMapping(value = "/huanxinregister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "环信注册", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "环信注册")
	public String huanXinRegister(
			@ApiParam(name = "docloginid", required = true, value = "用户登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "docloginpwd", value = "密码") @RequestParam String docloginpwd) throws Exception {
		if (docloginid != null) {
			boolean result = doctorAccountService.addHuanXinAccout(docloginid, docloginpwd);
			if (result) {
				return DataResult.success("注册成功");
			} else {
				return DataResult.success("已注册");
			}
		} else {
			return DataResult.error("id为空");
		}

	}

	// 登录
	@RequestMapping(value = "/doclogin", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生登录,替换/login", httpMethod = "POST", notes = "医生登录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docloginphone", required = true, value = "手机号码", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docloginpwd", required = true, value = "密码", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "doclogindev", required = false, value = "登录设备，1为安卓设置，2为IOS设备", dataType = "Integer", paramType = "query"),
			@ApiImplicitParam(name = "doclogintoken", required = false, value = "token", dataType = "String", paramType = "query") })
	public String doctorLogin(@ApiIgnore Doctorlogininfo doctorlogininfo) throws Exception {
		String docloginphone = doctorlogininfo.getDocloginphone();
		String docloginpwd = doctorlogininfo.getDocloginpwd();
		String doclogintoken = doctorlogininfo.getDoclogintoken();
		if (StringUtils.isBlank(docloginphone)) {
			return DataResult.error("手机号码为空");
		}
		if (StringUtils.isNotBlank(docloginphone) && !CheckUtils.isChinaPhoneLegal(docloginphone)) {
			return Result.error("手机号码格式错误");
		}
		if (StringUtils.isBlank(docloginpwd)) {
			return DataResult.error("密码为空");
		}
		Integer dev = doctorlogininfo.getDoclogindev();
		if (dev==null) {
			dev=1;
		}
		if (StringUtils.isNotBlank(doclogintoken)) {
			// 自动登录
			return doctorAccountService.updateDoctorToAutoLogin(doctorlogininfo);
		} else {
			// 普通登录
			return doctorAccountService.updateDoctorToNormalLogin(doctorlogininfo);
		}
	}

	// 更新channelId
	@RequestMapping(value = "/updatechannelid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新channelId", httpMethod = "POST", notes = "更新channelId")
	public String updateChannelId(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "channelid", value = "channelid") @RequestParam String channelid) throws Exception {

		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (channelid == null || channelid.trim().length() == 0) {
			return DataResult.error("channelid为空");
		}
		return doctorAccountService.updateChannelId(docloginid, channelid);
	}

	// 用户退出登陆
	@RequestMapping(value = "/exit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "退出登陆", httpMethod = "POST", notes = "退出登陆")
	public String exitUserLoginInfo(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return doctorAccountService.updateAccountToExit(docloginid);

	}

	// 修改密码
	@RequestMapping(value = "/editpassword", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改密码", httpMethod = "POST", notes = "修改密码")
	public String editPassword(
			@ApiParam(name = "docloginphone", required = true, value = "手机号码") @RequestParam String docloginphone,
			@ApiParam(name = "docloginpwd", value = "密码") @RequestParam String docloginpwd,
			@ApiParam(name = "code", required = true, value = "短信验证码") @RequestParam String code) throws Exception {
		if (StringUtils.isBlank(docloginphone)) {
			return DataResult.error("手机号码为空");
		}
		if (StringUtils.isNotBlank(docloginphone) && !CheckUtils.isChinaPhoneLegal(docloginphone)) {
			return Result.error("手机号码格式错误");
		}
		if (StringUtils.isBlank(docloginpwd)) {
			return DataResult.error("密码为空");
		}
		if (StringUtils.isBlank(code)) {
			return DataResult.error("验证码为空");
		}
		return doctorAccountService.updatePassword(docloginphone, docloginpwd, code);
	}
	
	//更新头像
	@RequestMapping(value = "/updatepix", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改头像", httpMethod = "POST", consumes = "multipart/form-data", notes = "修改头像")
	public String addUserInfo(
			@ApiParam(name = "docloginpix", required = true, value = "图片") @RequestParam MultipartFile docloginpix,
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (docloginpix == null || docloginpix.isEmpty()) {
			return DataResult.error("未选择头像");
		}
		return doctorInfoService.updatePix(docloginid,docloginpix);
			

	}

	// 获取我的介绍和我的擅长
	@RequestMapping(value = "/getinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取我的介绍和我的擅长", httpMethod = "POST", notes = "获取我的介绍和我的擅长获取我的介绍和我的擅长")
	public String getInfo(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid != null) {
			return DataResult.error("医生登录id为空");
		}
		return  doctorInfoService.getNormalInfo(docloginid);
	}

	// 更新我的介绍和我的擅长
	@RequestMapping(value = "/updateinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新我的介绍和我的擅长", httpMethod = "POST", notes = "更新我的介绍和我的擅长")
	public String updateinfo(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "docexpert", value = "擅长") @RequestParam(required = false) String docexpert,
			@ApiParam(name = "docabs", value = "个人简介") @RequestParam(required = false) String docabs) throws Exception {
		if (docloginid != null) {
			return DataResult.error("医生登录id为空");
		}
		return doctorInfoService.updateNormalInfo(docloginid, docexpert, docabs);
	}

	// 获取第一页个人信息
	@RequestMapping(value = "/getfirstinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取第一页个人信息,替换/getfirstinfo", httpMethod = "POST", notes = "获取第一页个人信息")
	public String getFirstInfo2(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid!=null) {
			Map<String, Object> result = doctorInfoService.getInfo(docloginid, 1);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("获取数据成功", result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("获取数据失败,因对应数据为空");
			} else {
				return DataResult.error("操作异常");

			}
		} else {
			return DataResult.error("医生登录id为空");
		}
		
	}

	// 获取第二页个人信息
	@RequestMapping(value = "/getsecondinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取第二页个人信息", httpMethod = "POST", notes = "获取第二页个人信息")
	public String getSecondInfo2(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid != null) {
			Map<String, Object> result = doctorInfoService.getInfo(docloginid, 2);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("获取数据成功", result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("获取数据为空");
			} else {
				return DataResult.error("操作异常");

			}
		} else {
			return DataResult.error("医生登录id为空");
		}

	}
	
	// 更新第一页个人信息
	@RequestMapping(value = "/updatefirstinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新第一页个人信息", httpMethod = "POST", notes = "更新第一页个人信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "docloginid", required = true, value="医生登录id",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochosp", required = false, value="医院名称",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "hosplevel", required = false, value="医院等级",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochospprovince", required = false, value="医院所在省",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochospcity", required = false, value="医院所在市",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochosparea", required = false, value="医院所在区县",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochospother", required = false, value="医院所在具体地址",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochosplon", required = false, value="医院所在地址精度",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochosplat", required = false, value="医院所在地址纬度",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docallday", required = false,value="是否全天接诊", dataType = "Boolean", paramType = "query"),
		@ApiImplicitParam(name = "docage", required = false, value="年龄",dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "docmale", required = false, value="性别",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "doccardnum", required = false,value="身份证号码", dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docname", required = false, value="姓名",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docprimarydept", required = false, value="一级部门",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docseconddept", required = false,value="二级部门", dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "doctitle", required = false, value="医生职称",dataType = "String", paramType = "query")
		}
	)
	public String updateFirstInfo(@ApiIgnore Doctorinfo doctorinfo)
			throws Exception {
		Integer docloginid = doctorinfo.getDocloginid();
		if (docloginid!=null) {
			int result = doctorInfoService.updateInfo(doctorinfo);
			if (result==1) {
				return DataResult.success("修改资料成功");
			} else if (result==2) {
				return DataResult.error("修改数据失败");
			} else  if (result==3) {
				return DataResult.error("登录id对应的个人记录为空");
			} else if (result==4) {
				return DataResult.error("已被审核,个人信息不可修改");
			} else if (result==5) {
				return DataResult.error("登录id对应的信息为空");
			} else{
				return DataResult.error("操作异常");

			}
		} else {
			return DataResult.error("医生登录id为空");
		}
		
	}
	
	
	// 更新第二页个人信息
	@RequestMapping(value = "/updatesecondinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新第二页个人信息", httpMethod = "POST", notes = "更新第二页个人信息")
	public String editUserInfo(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "type", value = "照片类型1为身份证照片，2为职称照片，3为行医资格证照片，4为工作证照片，5为其他照片") @RequestParam Integer type,
			@ApiParam(name = "oldpicture", value = "原照片路径") @RequestParam(required = false) String oldpicture,
			@ApiParam(name = "picture", value = "照片")@RequestParam MultipartFile[] picture) throws Exception {
		if (picture.length > 0 && docloginid != null && type != null) {
			if (type>0 && type <6) {
				int result = doctorInfoService.updateSecondInfo(docloginid, type, oldpicture, picture);
				if (result == 1) {
					return DataResult.success("上传成功");
				} else if (result == 2) {
					return DataResult.error("上传失败");
				} else if (result == 3) {
					return DataResult.error("修改数据失败,路径创建失败");
				} else if (result == 4) {
					return DataResult.error("已被审核,个人信息不可修改");
				} else {
					return DataResult.error("登录id对应的信息为空");
				}
				
			} else {
				return DataResult.error("type超出范围");
			}
				

			} else {
				List<String> errList = new ArrayList<String>();
				if (docloginid == null) {
					errList.add("id为空"); 
				}
				
				if (type == null) {
					errList.add("type为空"); 
				}
				if (picture.length == 0) {
					errList.add("照片为空"); 
				}
				return DataResult.error(errList.toString().replace("[", "").replace("]", "")); // 错误信息
			}
	}
	
	@RequestMapping(value = "/reviewinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "提交审核", httpMethod = "POST", notes = "提交审核")
	public String reviewInfo(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid
			) throws Exception {
		if (docloginid==null) {
			return DataResult.error("id为空");
		}
		return doctorAccountService.updateInfoToReview(docloginid);
	}
	
	//获取科室
	@RequestMapping(value = "/getdept", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取科室", httpMethod = "GET", notes = "获取科室")
	public String getDept() throws Exception {
		return commonService.getDept();
	}

	// 获取常用地址
	@RequestMapping(value = "/getaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取常用地址", httpMethod = "POST", notes = "获取常用地址", produces = "application/json")
	public String getAddress(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(required = true) Integer page) {
		Map<String, Object> result = doctorInfoService.getAddress(docloginid,page);
		if ("1".equals(result.get("state"))) {
			return PaginationResult.success("获取数据成功", result.get("data"));
		} else if ("2".equals(result.get("state"))) {
			return PaginationResult.success("获取数据为空",null);
		} else {
			return DataResult.error("异常错误");
		}

	}
	
	// 获取全部常用地址
	@RequestMapping(value = "/getalladdress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取全部常用地址", httpMethod = "POST", notes = "获取全部常用地址", produces = "application/json")
	public String getAllAddress(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid) {
		if (docloginid == null) {
			return DataResult.error("医生id为空");
		}
		return doctorInfoService.getAllAddress(docloginid);

	}
	
	//添加常用地址
	@RequestMapping(value="/addaddress", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "添加常用地址", httpMethod = "POST", notes = "添加常用地址",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "docloginid",required = true,value ="医生登录id",dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "docaddresslocation",required = true,value ="地点名称",dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "docaddressprovince",required = true,value ="省",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docaddresscity",required = true,value ="市",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docaddressarea",required = true,value ="区",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docaddressother",required = false,value ="详细地址",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docaddresslon",required = true,value ="经度",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docaddresslat",required = true,value ="纬度",dataType = "String", paramType = "query")
		 })
	public String addAddress( @ApiIgnore Doctoraddress doctoraddress ){
		int result = doctorInfoService.addAddress(doctoraddress);
		if (result==1) {
			return DataResult.success("新增成功");
		} else if (result==2) {
			return DataResult.error("新增失败");
		} else if (result==3) {
			return DataResult.error("新增失败,该医生不存在");
		} else {
			return DataResult.error("新增失败,异常错误");
		} 
	}

	// 修改常用地址
	@RequestMapping(value = "/editaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改常用地址", httpMethod = "POST", notes = "修改常用地址", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docloginid", required = true, value = "医生登录id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "docaddressid", required = true, value = "地址id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "docaddresslocation",required = false,value ="地点名称",dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "docaddressprovince", required = false, value = "省", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddresscity", required = false, value = "市", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddressarea", required = false, value = "区县", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddressother", required = false, value = "详细地址", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddresslon", required = false, value = "经度", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddresslat", required = false, value = "纬度", dataType = "String", paramType = "query") })
	public String editAddress(@ApiIgnore Doctoraddress doctoraddress) {
		int result = doctorInfoService.editAddress(doctoraddress);
		if (result == 1) {
			return DataResult.success("修改成功");
		} else if (result == 2) {
			return DataResult.error("修改失败");
		} else if (result == 3) {
			return DataResult.error("默认地址不可修改");
		} else if (result == 4) {
			return DataResult.error("修改失败,该地址不属于该医生");
		} else if (result == 5) {
			return DataResult.error("修改失败,该地址不存在");
		} else {
			return DataResult.error("修改失败,异常错误");
		}
	}

	// 删除常用地址
	@RequestMapping(value = "/deleteaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除常用地址", httpMethod = "POST", notes = "删除常用地址", produces = "application/json")
	public String deleteAddress(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "docaddressid", required = true, value = "地址id") @RequestParam(required = true) Integer docaddressid) {
		int result = doctorInfoService.delAddress(docloginid, docaddressid);
		if (result == 1) {
			return DataResult.success("删除成功");
		} else if (result == 2) {
			return DataResult.error("删除失败");
		} else if (result == 3) {
			return DataResult.error("删除失败,该地址正在使用");
		}  else if (result == 4) {
			return DataResult.error("删除失败,该地址不属于该医生");
		}  else if (result == 5) {
			return DataResult.error("默认地址不可删除");
		} else if (result == 6) {
			return DataResult.error("删除失败,该地址不存在");
		} else {
			return DataResult.error("删除失败,异常错误");
		}
	}
	
	//设置坐诊地点
	@RequestMapping(value = "/setaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "设置坐诊地点", httpMethod = "POST", notes = "设置坐诊地点", produces = "application/json")
	public String setAddress(
				@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
				@ApiParam(name = "docaddressid", required = true, value = "地址id") @RequestParam(required = true) Integer docaddressid) {
			int result = doctorInfoService.updateAddress(docloginid, docaddressid);
			if (result == 1) {
				return DataResult.success("设置成功");
			} else if (result == 2) {
				return DataResult.error("设置失败");
			} else if (result == 3) {
				return DataResult.error("该地址已被设置为当前坐诊位置");
			}  else if (result == 4) {
				return DataResult.error("该地址不属于该医生");
			}  else if (result == 5) {
				return DataResult.error("该地址不存在");
			} else  {
				return DataResult.error("删除失败,异常错误");
			}
	}

	// 获取日程表
	@RequestMapping(value = "/getcalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取日程表", httpMethod = "POST", notes = "获取日程表", produces = "application/json")
	public String getCalendar(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(required = true) Integer page) {
		return doctorInfoService.getCalendar(docloginid,page);
		

	}

	// 获取日程表
	@RequestMapping(value = "/getcalendarbymonth", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "按月份获取日程表", httpMethod = "POST", notes = "按月份获取日程表", produces = "application/json")
	public String getCalendarbymonth(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "year", value = "年") @RequestParam(required = true) String year,
			@ApiParam(name = "month", value = "月") @RequestParam(required = true) String month) {
		return doctorInfoService.getCalendarByMonth(docloginid,year, month);
	}
	
	// 新增日程表
	@RequestMapping(value = "/addcalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "设置日程表", httpMethod = "POST", notes = "设置日程表", produces = "application/json")
	public String addCalendar(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "doccalendarday", required = true, value = "时间") @RequestParam(required = true) Date doccalendarday,
			@ApiParam(name = "doccalendartime", required = true, value = "上午或者下午") @RequestParam(required = true) String doccalendartime,
			@ApiParam(name = "doccalendaraffair", required = true, value = "事件") @RequestParam(required = true) String doccalendaraffair,
			@ApiParam(name = "doccalendaradressid", required = true, value = "地址id") @RequestParam(required = true) Integer doccalendaradressid
			) {
		 	return  doctorInfoService.addCalendar(docloginid, doccalendarday, doccalendartime, doccalendaraffair,
					doccalendaradressid);
	}

	// 修改日程
	@RequestMapping(value = "/editcalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改日程", httpMethod = "POST", notes = "修改日程", produces = "application/json")
	public String editCalendar(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "doccalendarid", value = "日程id") @RequestParam Integer doccalendarid,
			@ApiParam(name = "doccalendarday",  value = "时间") @RequestParam(required = false) Date doccalendarday,
			@ApiParam(name = "doccalendartime", value = "上午或者下午") @RequestParam(required = false) String doccalendartime,
			@ApiParam(name = "doccalendaraffair",  value = "事件") @RequestParam(required = false) String doccalendaraffair,
			@ApiParam(name = "doccalendaradressid",  value = "地址id") @RequestParam(required = false) Integer doccalendaradressid
			) {
		
		return doctorInfoService.editCalendar(doccalendarid, docloginid, doccalendarday, doccalendartime,
				doccalendaraffair, doccalendaradressid);
	}

	// 删除日程
	@RequestMapping(value = "/deletecalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除日程", httpMethod = "POST", notes = "删除日程", produces = "application/json")
	public String deleteCalendar(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "doccalendarid", value = "日程id") @RequestParam(required = true) Integer doccalendarid) {
		int result = doctorInfoService.deleteCalendar(doccalendarid, docloginid);
		if (result == 1) {
			return DataResult.success("删除成功");
		} else if (result == 2) {
			return DataResult.error("删除失败");
		} else if (result == 3) {
			return DataResult.success("删除成功");
		} else if (result == 4) {
			return DataResult.error("删除失败");
		} else if (result == 5) {
			return DataResult.error("该日程不属于该医生");
		} else if (result == 6) {
			return DataResult.error("该日程不存在");
		} else {
			return DataResult.error("异常错误");
		}

	}

	// 获取病情
	@RequestMapping(value = "/listsicks", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情", httpMethod = "POST", notes = "获取病情",produces="application/json")
	public String listSick(
			@ApiParam(name = "docloginid",required = true,value ="医生登录id")@RequestParam(required=true) Integer docloginid,
			@ApiParam(name = "page",value ="当前页")@RequestParam(required=true) Integer page,
			@ApiParam(name = "lat",value ="精度")@RequestParam(required=true) String lat,
			@ApiParam(name = "lon",value ="纬度")@RequestParam(required=true) String lon,
			@ApiParam(name = "province",value ="省")@RequestParam(required=false) String province,
			@ApiParam(name = "city",value ="市")@RequestParam(required=false) String city,
			@ApiParam(name = "area",value ="区")@RequestParam(required=false) String area,
			@ApiParam(name = "type",value ="为空时获取推荐病情，为1时获取按时间排序的病情，为2时获取按位置获取的病情")@RequestParam(required=false) Integer type
			) throws Exception {
			if (docloginid==null) {
				return DataResult.error("登录id为空");
			}
			if (page==null) {
				return DataResult.error("当前页为空");
			} else {
				if (page<0) {
					return DataResult.error("当前页不可小于0");	
				}
			}
			if (StringUtils.isBlank(lat)) {
				return DataResult.error("经度为空");
			}
			if (StringUtils.isBlank(lon)) {
				return DataResult.error("纬度为空");
			}
			Integer pageSize = 5;
			if (type==null) {
				//推荐病情
				return doctorHomeService.listSickByRecommend(page, pageSize, docloginid, lat, lon);
			} else {
				if (type==1) {
					//按时间排序的病情
					return doctorHomeService.listSickByTime(page, pageSize, docloginid, lat, lon);
					
				} else if (type==2) {
					//按位置查询的病情
					return doctorHomeService.listSickByLoc(page, pageSize, docloginid, lat, lon, province, city, area);
				}else {
					return DataResult.error("type值超出范围");	
				}
			}
	}
	
	//获取病情详情
	@RequestMapping(value = "/getsickdetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情详情", httpMethod = "POST", notes = "获取病情详情", produces = "application/json")
	public String getsickDeatil(
			@ApiParam(name = "docloginid",value ="医生登录id")@RequestParam(required=false) Integer docloginid,
			@ApiParam(name = "usersickid", required = true, value = "病情id") @RequestParam(required = true) Integer usersickid
	 ) throws Exception {
		if (usersickid==null) {
			return DataResult.error("病情id为空");
		}
		return doctorHomeService.getSickDetail(docloginid,usersickid);
	}
	
	
	
	// 医生抢单
	@RequestMapping(value = "/graborder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生抢单", httpMethod = "POST", notes = "医生抢单", produces = "application/json")
	public String grabOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "usersickid", required = true, value = "病情id") @RequestParam(value = "usersickid") Integer usersickid,
			@ApiParam(name = "preorderprice", value = "预估价格") @RequestParam(required = false) Double preorderprice) throws Exception {
		if (docloginid==null) {
			return DataResult.error("医生登录id为空");
		}
		if (usersickid==null) {
			return DataResult.error("病情id为空");
		}
		return doctorOrderService.creatPreOrder(usersickid, docloginid, preorderprice);
	}
		
	
	//获取已抢订单
	@RequestMapping(value = "/listgraborders", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取已抢订单", httpMethod = "POST", notes = "获取已抢订单", produces = "application/json")
	public String listGrabOrders(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page",required = true,value ="当前页" )@RequestParam(value="page") Integer page
			)throws Exception {
		if (docloginid==null) {
			return DataResult.error("医生登录id为空");
		}
		if (page==null) {
			return DataResult.error("page为空");
		}else {
			if (page<0) {
				return DataResult.error("page需大于0");
			}
		}
		return doctorOrderService.listGrabOrders(docloginid,page,5);
	}
	
	// 医生取消抢单
	@RequestMapping(value = "/cancelgraborder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生取消抢单", httpMethod = "POST", notes = "医生取消抢单")
	public String cancelOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid,
				@ApiParam(name = "preorderid",required = true,value ="预订单id" )@RequestParam(value="preorderid") Integer preorderid) throws Exception {
			if (docloginid==null) {
				return DataResult.error("医生登录id为空");
			}
			if (preorderid==null) {
				return DataResult.error("申请记录id为空");
			}
			return doctorOrderService.deletePreOrder(docloginid,preorderid);
			
	}

	
	@RequestMapping(value = "/listordertoconfirm", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取选择我的订单", httpMethod = "POST", notes = "医生获取选择我的订单")
	public String listOrderToConfirm(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page)
			throws Exception {
		if (docloginid==null) {
			return DataResult.error("登录id为空");
		}
		if (page==null) {
			return DataResult.error("当前页为空");
		} else {
			if (page<0) {
				return DataResult.error("当前页不可小于0");	
			}
		}
		return doctorOrderService.listOrderToConfirm(docloginid, page, 5);
	}

	// 医生获取订单
	@RequestMapping(value = "/getorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取订单", httpMethod = "POST", notes = "医生获取订单")
	public String getorder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page,
			@ApiParam(name = "type", value = "订单类型，为空获取全部,1代表等待病人确认的订单，2代表正在进行的") @RequestParam(required=false) Integer type)
			throws Exception {
		if (docloginid==null) {
			return DataResult.error("医生登录id为空");
		}
		if (page==null) {
			return DataResult.error("当前页为空");
		}else {
			if (page<0 ) {
				return DataResult.error("当前页为大于0的整数");
			}
		}
		if (type!=null && type>2) {
			return DataResult.error("type值超出范围");
		}
		return doctorOrderService.listOrder(docloginid,type, page, 5);
	}

	// 医生获取订单
	@RequestMapping(value = "/listhistoryorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取订单", httpMethod = "POST", notes = "医生获取订单")
	public String listHistoryOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (page == null) {
			return DataResult.error("当前页为空");
		} else {
			if (page < 0) {
				return DataResult.error("当前页为大于0的整数");
			}
		}

		return doctorOrderService.listHistoryOrder(docloginid, page);
	}
	
	//医生获取订单详情
	@RequestMapping(value = "/getorderdetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取订单详情", httpMethod = "POST", notes = "医生获取订单详情")
	public String getOrderDetail(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "userorderid", required = true, value = "订单id") @RequestParam(value = "userorderid") Integer userorderid)
			throws Exception {
		if (docloginid==null) {
			return DataResult.error("医生登录id为空");
		}
		if (userorderid==null) {
			return DataResult.error("订单id为空");
		}
		return doctorOrderService.getOrderDetail(docloginid,userorderid);
	}
	
	//根据医院名迷糊查询医院
	@RequestMapping(value="/gethospital",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ApiOperation(value = "根据医院名迷糊查询医院", httpMethod = "POST", notes = "根据医院名迷糊查询医院")
	public String getHosptial(@ApiParam(name = "hospname", required = true, value = "医院名") @RequestParam String hospname) throws Exception{
		if (hospname==null) {
			return DataResult.error("医院名为空");
		}
		return  doctorHomeService.listHospital(hospname);
		
	}
	
	//根据医院id获取医院详细
	@RequestMapping(value="/gethospitaldetail",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ApiOperation(value = "根据医院id获取医院详细", httpMethod = "POST", notes = "根据医院id获取医院详细")
	public String getHosptialDetail(@ApiParam(name = "hosploginid", required = true, value = "医院id") @RequestParam Integer hosploginid) throws Exception{
		if (hosploginid==null) {
			return DataResult.error("医院id为空");
		}
		return  doctorHomeService.getHospitalDetail(hosploginid);
		
	}
	
	//根据名字查询医生
	@RequestMapping(value = "/getdoctorbyname", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "根据名字查询医生", httpMethod = "POST", notes = "根据名字查询医生")
	public String getDoctor(
			@ApiParam(name = "docname", required = true, value = "医生姓名") @RequestParam String docname
			) {
		if (docname != null && docname.trim().length()!=0) {
			Map<String, Object> result = doctorOrderService.getDoctorByName(docname);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("获取数据成功",result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("获取数据成功,但数据为空");
			} else  {
				return DataResult.error("异常错误");
			}
		} else {
			return DataResult.error("医生姓名为空");
		}
	}
	
	// 医生拒绝接单
	@RequestMapping(value = "/refuseorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生拒绝接单", httpMethod = "POST", notes = "医生拒绝接单")
	public String refuseOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "userorderid", required = true, value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "redocloginid", value = "推荐医生登陆id") @RequestParam(required = false) Integer redocloginid) throws Exception {
		if (docloginid != null && userorderid != null) {
			Map<String, Object> result = doctorOrderService.updateOrderToRefuse(docloginid, userorderid, redocloginid);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("拒绝接单成功,且消息发送成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("拒绝接单成功,但消息发送失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.error("拒绝接单失败，未知错误");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("病情不存在，拒绝接单失败");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("该状态不支持拒绝接单");
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("医生与订单不匹配");
			} else if ("7".equals(result.get("state"))) {
				return DataResult.error("订单不存在");
			} else if ("8".equals(result.get("state"))) {
				return DataResult.error("拒绝接单失败,因推荐医生失败");
			} else if ("9".equals(result.get("state"))) {
				return DataResult.error("拒绝接单失败,因该医生已被推荐");
			} else if ("10".equals(result.get("state"))) {
				return DataResult.error("拒绝接单失败,因该推荐医生不存在");
			} else {
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userorderid == null) {
				errList.add("订单id为空");
			}
			if (docloginid == null) {
				errList.add("医生id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
	}
	
	//医生确认订单
	@RequestMapping(value="/confirmorder",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生确认订单", httpMethod = "POST", notes = "医生确认订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "docloginid",required = true,value ="医生登录id",dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "userorderid",required = true,value ="订单id",dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "userorderdprice",required = false,value ="医生价格",dataType = "Double", paramType = "query"),
		@ApiImplicitParam(name = "userordertpricetype",required = true,value ="交通类型",dataType = "int", paramType = "query" ),
		@ApiImplicitParam(name = "userordertprice",required = false,value ="交通价格" ,dataType = "Double", paramType = "query"),
		@ApiImplicitParam(name = "userorderapricetype",required = true,value ="住宿类型",dataType = "int", paramType = "query" ),
		@ApiImplicitParam(name = "userorderaprice",required = false,value ="住宿价格" ,dataType = "Double", paramType = "query"),
		@ApiImplicitParam(name = "userorderepricetype",required = true,value ="餐饮类型",dataType = "int", paramType = "query" ),
		@ApiImplicitParam(name = "userordereprice",required = false,value ="住宿价格",dataType = "Double", paramType = "query" )
		 })
	public String confirmOrder(@ApiIgnore Userorder userorder,@ApiIgnore Integer docloginid)throws Exception{
		Integer userorderid = userorder.getUserorderid();
		Integer userordertpricetype = userorder.getUserordertpricetype();
		Integer userorderapricetype= userorder.getUserorderapricetype();
		Integer userorderepricetype= userorder.getUserorderepricetype();
		System.out.println("交通类型"+userorderapricetype);
		if (userorderid==null ) {
			return DataResult.error("订单id为空");
		}
		if (userordertpricetype==null ) {
			return DataResult.error("交通类型为空");
		}
		if ( userorderapricetype==null) {
			return DataResult.error("住宿类型为空");
		}
		if ( userorderepricetype==null) {
			return DataResult.error("餐饮类型为空");
		}
		return  doctorOrderService.updateOrderConfirm(userorder);
	}
	
	//医生取消订单
	@RequestMapping(value = "/cancelorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生取消订单", httpMethod = "POST", notes = "医生取消订单")
	public String cancel(
			@ApiParam(name = "docloginid",required = true,value ="医生登陆id" )@RequestParam Integer docloginid,
			@ApiParam(name = "userorderid",required = true,value ="订单id" )@RequestParam Integer userorderid) throws Exception {
		if (docloginid != null && userorderid!=null) {
			Map<String, Object> result = doctorOrderService.updateOrderToCancle(docloginid,userorderid);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("取消成功,且消息发送成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("取消成功,但消息发送失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.success("取消失败，未知错误");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("病情不存在，取消失败");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("该状态不支持取消");
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("医生与订单不匹配");
			} else if ("7".equals(result.get("state"))) {
				return DataResult.error("订单不存在");
			}else {
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userorderid == null) {
				errList.add("订单id为空"); 
			}
			if (docloginid == null) {
				errList.add("医生id为空"); 
			}
			return DataResult.error( errList.toString().replace("[", "").replace("]", ""));
		}
	}
	
	//医生结束订单
	@RequestMapping(value = "/finishorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生结束订单", httpMethod = "POST", notes = "医生结束订单")
	public String finishOrder(
			@ApiParam(name = "docloginid",required = true,value ="医生登陆id" )@RequestParam Integer docloginid,
			@ApiParam(name = "userorderid",required = true,value ="订单id" )@RequestParam Integer userorderid,
			@ApiParam(name = "userorderhstate",required = true,value ="是否住院" )@RequestParam Boolean userorderhstate,
			@ApiParam(name = "userorderhospid",required = false,value ="接诊医院id")@RequestParam(required=false) Integer userorderhospid) throws Exception {
		if (docloginid != null && userorderid!=null) {
			Map<String, Object> result = doctorOrderService.finishOrder(docloginid,userorderid,userorderhstate,userorderhospid);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("确认需要住院成功,且消息发送成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("确认需要住院成功,但消息发送失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.success("确认需要住院失败");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.success("结束订单成功,且消息发送成功");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.success("结束订单成功,但消息发送失败");
			}else if ("6".equals(result.get("state"))) {
				return DataResult.error("结束订单失败");
			} else if ("7".equals(result.get("state"))) {
				return DataResult.error("该订单状态不支持该操作");
			} else {
				return DataResult.error("医生与订单不匹配");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userorderid == null) {
				errList.add("订单id为空"); 
			}
			if (docloginid == null) {
				errList.add("医生id为空"); 
			}
			return DataResult.error( errList.toString().replace("[", "").replace("]", ""));
		}
	}
	
	//获取会诊
	@RequestMapping(value = "/listconsultation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取会诊", httpMethod = "POST", notes = "获取会诊")
	public String listConsultation(
			@ApiParam(name = "docloginid",required = true,value ="医生登陆id" )@RequestParam Integer docloginid,
			@ApiParam(name = "page",required = true,value ="当前页" )@RequestParam Integer page,
			@ApiParam(name = "type",value ="为空时获取全部,为1时获取等待医生确认的会诊请求，为2时获取等待医院确认的会诊,3为进行中的会诊,4为已完成的会诊，5为历史会诊" )@RequestParam(required=false) Integer type
			) throws Exception {
		if (docloginid==null) {
			return DataResult.error("医生登录id为空");
		}
		if (page==null) {
			return DataResult.error("当前页为空");
		}else {
			if (page<=0) {
				return DataResult.error("当前页为大于0的整数");
			}
		}
		if (type!=null && (type<0||type>5)) {
			return DataResult.error("type值超出范围");
		}
		return  doctorOrderService.listConsultation(docloginid,type,page);
		
	}
	
	@RequestMapping(value = "/getconsultationdetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取会诊详情", httpMethod = "POST", notes = "获取会诊详情")
	public String getConsultationDetail(
			@ApiParam(name = "docloginid",required = true,value ="医生登陆id" )@RequestParam Integer docloginid,
			@ApiParam(name = "hosporderid", required = true, value = "订单id") @RequestParam Integer hosporderid
			) throws Exception {
		if (docloginid==null) {
			return DataResult.error("医生登录id为空");
		}
		if (hosporderid==null) {
			return DataResult.error("订单id为空");
		}
		return  doctorOrderService.listConsultationDetail(docloginid,hosporderid);
		
	}
	
	//确认会诊
	@RequestMapping(value = "/confirmconsultation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "确认会诊", httpMethod = "POST", notes = "确认会诊")
	public String confirmconsultation(
				@ApiParam(name = "docloginid",required = true,value ="医生登陆id" )@RequestParam Integer docloginid,
				@ApiParam(name = "hosporderid", required = true, value = "订单id") @RequestParam Integer hosporderid,
				@ApiParam(name = "orderdoctorprice",required = true,value ="医生期望价格" )@RequestParam BigDecimal orderdoctorprice,
				@ApiParam(name = "orderdoctortpricetype", required = true, value = "交通类型") @RequestParam Integer orderdoctortpricetype,
				@ApiParam(name = "orderdoctortprice", value = "交通价格") @RequestParam(required=false) BigDecimal orderdoctortprice,
				@ApiParam(name = "orderdoctorapricetype", required = true, value = "住宿类型") @RequestParam Integer orderdoctorapricetype,
				@ApiParam(name = "orderdoctoraprice", value = "住宿价格") @RequestParam(required=false)  BigDecimal orderdoctoraprice,
				@ApiParam(name = "orderdoctorepricetype", required = true, value = "餐饮价格") @RequestParam Integer orderdoctorepricetype,
				@ApiParam(name = "orderdoctoreprice",  value = "餐饮价格") @RequestParam(required=false)  BigDecimal orderdoctoreprice
				) throws Exception {
			if (docloginid==null) {
				return DataResult.error("医生登录id为空");
			}
			if (hosporderid==null) {
				return DataResult.error("订单id为空");
			}
			if (orderdoctorprice==null) {
				return DataResult.error("价格为空");
			}
			if (orderdoctortpricetype==null) {
				return DataResult.error("交通类型为空");
			}else {
				if (orderdoctortpricetype==1 || orderdoctortpricetype==2 ) {
					if (orderdoctortpricetype==2 && orderdoctortprice==null) {
						return DataResult.error("交通费用为空");
					}
				}else {
					return DataResult.error("交通类型超出范围");
				}
			}
			if (orderdoctorapricetype==null) {
				return DataResult.error("住宿类型为空");
			}else {
				if (orderdoctorapricetype==1 || orderdoctorapricetype==2 ) {
					if (orderdoctorapricetype==2 && orderdoctoraprice==null) {
						return DataResult.error("住宿费用为空");
					}
				}else {
					return DataResult.error("住宿类型超出范围");
				}
			}
			if (orderdoctorepricetype==null) {
				return DataResult.error("餐饮类型为空");
			}else {
				if (orderdoctorepricetype==1 || orderdoctorepricetype==2 ) {
					if (orderdoctorepricetype==2 && orderdoctoreprice==null) {
						return DataResult.error("餐饮费用为空");
					}
				}else {
					return DataResult.error("餐饮类型超出范围");
				}
			}
			return doctorOrderService.updateConsultationToConfirm(docloginid,hosporderid,orderdoctorprice,orderdoctortpricetype,orderdoctortprice,orderdoctorapricetype,orderdoctoraprice,orderdoctorepricetype,orderdoctoreprice);
	}

	// 取消会诊
	@RequestMapping(value = "/cancelconsultation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消会诊", httpMethod = "POST", notes = "取消会诊")
	public String cancelconsultation(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "hosporderid", required = true, value = "订单id") @RequestParam Integer hosporderid
		) throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (hosporderid == null) {
			return DataResult.error("订单id为空");
		}
		return doctorOrderService.updateConsultationToCancel(docloginid,hosporderid);

	}

	//更换部门
	@RequestMapping(value = "/changedept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更换部门", httpMethod = "POST", notes = "更换部门")
	public String changeDept(
			@ApiParam(name = "docloginid",required = true,value ="医生登陆id" )@RequestParam Integer docloginid,
			@ApiParam(name = "usersickid",required = true,value ="病情id" )@RequestParam Integer usersickid,
			@ApiParam(name = "usersickprimarydept",value ="一级部门" )@RequestParam String usersickprimarydept,
			@ApiParam(name = "usersickseconddept",value ="二级部门" )@RequestParam(required=false) String usersickseconddept) throws Exception {
		if (docloginid ==null) {
			return DataResult.error("医生登录id为空");
		}
		if (usersickid ==null) {
			return DataResult.error("病情id为空");
		}
		if (usersickprimarydept ==null) {
			return DataResult.error("一级部门为空");
		}
		return doctorOrderService.changeDept(docloginid,usersickid,usersickprimarydept,usersickseconddept);
			
	}
	
	@RequestMapping(value="/listreceivenotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取需要接收的通知",httpMethod="POST",notes="获取其他发送的通知")
	public @ResponseBody String listreceivenotification(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page,
			@ApiParam(name = "type", value = "当type为空时获取全部通知，为1时获取已读通知，2为时获取未读通知") @RequestParam(required=false) Integer type
			)throws Exception{
		if (docloginid != null  && page!=null) {
			if ( type!=null && (!(type==1||type==2))) {
				return DataResult.error("type值超出范围");
			}
			if (page<0) {
				return DataResult.error("page值超出范围");
			}
			PageInfo<Map<String, Object>> pageInfo = commonService.listReceiveNotification(docloginid, 2, page, type);
			if (pageInfo != null && pageInfo.getTotal()>0) {
				return DataResult.success("获取数据成功", pageInfo.getList());
			}else {
				return DataResult.success("获取数据为空", null);
			}
		}else {
			return DataResult.error("信息不完整");
		}
		
	}
	
	@RequestMapping(value="/listsendernotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取发送的通知",httpMethod="POST",notes="获取发送的通知")
	public @ResponseBody String listsendernotification(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page,
			@ApiParam(name = "type", value = "当type为空时获取全部通知，为1时获取已读通知，2为时获取未读通知") @RequestParam(required=false) Integer type
			)throws Exception{
		if (docloginid != null) {
			if ( type!=null && (!(type==1||type==2))) {
				return DataResult.error("type值超出范围");
			}
			if (page<0) {
				return DataResult.error("page值超出范围");
			}
			PageInfo<Map<String, Object>> pageInfo = commonService.listSenderNotification(docloginid, 2, page, type);
			if (pageInfo != null && pageInfo.getTotal()>0) {
				return DataResult.success("获取数据成功", pageInfo.getList());
			}else {
				return DataResult.success("获取数据为空", null);
			}
		}else {
			return DataResult.error("信息不完整");
		}
		
	}
	@RequestMapping(value="/updatenotificationtoread", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="将通知置为已读",httpMethod="POST",notes="将通知置为已读")
	public @ResponseBody String updateNotificationToRead(
			@ApiParam(name = "notificationid", required = true, value = "通知id") @RequestParam Integer notificationid,
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid
			)throws Exception{
		if (docloginid != null) {
			boolean result= commonService.updateNotificationToRead(notificationid, docloginid);
			if (result) {
				return DataResult.success("已读成功");
			}else {
				return DataResult.success("已读失败");
			}
		}else {
			List<String> errList = new ArrayList<String>();
			if (notificationid == null) {
				errList.add("通知id为空");
			}
			if (docloginid == null) {
				errList.add("医生登录id为空");
			}
			
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		
	}
	@RequestMapping(value="/deletereceivenotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="删除接收的通知",httpMethod="POST",notes="删除接收的通知")
	public @ResponseBody String deleteNotification(
			@ApiParam(name = "notificationid", required = true, value = "通知id") @RequestParam Integer notificationid,
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid
			)throws Exception{
		if (docloginid != null) {
			boolean result= commonService.deleteNotification(notificationid, docloginid);
			if (result) {
				return DataResult.success("删除成功");
			}else {
				return DataResult.error("删除失败");
			}
		}else {
			List<String> errList = new ArrayList<String>();
			if (notificationid == null) {
				errList.add("通知id为空");
			}
			if (docloginid == null) {
				errList.add("医生登录id为空");
			}
			
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		
	}
}
