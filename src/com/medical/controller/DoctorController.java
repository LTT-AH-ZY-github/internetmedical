package com.medical.controller;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Null;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.taglibs.standard.lang.jstl.NullLiteral;
import org.jcp.xml.dsig.internal.MacOutputStream;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.yun.push.utils.PushToAndroid;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.medical.po.City;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Doctorskd;
import com.medical.po.SickSearch;
import com.medical.po.Userorder;
import com.medical.service.DoctorService;
import com.medical.utils.CommonUtils;
import com.medical.utils.CreateFileUtil;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.PaginationResult;
import com.medical.utils.result.Result;
import com.netease.code.MsgCode;
import com.sun.corba.se.spi.orbutil.fsm.State;
import com.sun.org.apache.xerces.internal.impl.xs.SchemaSymbols;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
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
	private DoctorService doctorService;

	
	// 判断手机号码是否注册
	@RequestMapping(value = "/phone", method = RequestMethod.POST, produces = "application/json")
	
	public Map<String, Object> phone(@RequestBody  Map<String, String> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String phone = params.get("phone");
		if (phone != null && phone.trim() != "") {
			int result = doctorService.findDocCountByPhone(phone);
			map.put("state", result); // 1 为未注册 2为已注册 3 操作异常
		} else {
			map.put("state", "4"); // 手机号码为空
		}
		return map;
	}

	// 判断手机号码是否注册
	@RequestMapping(value = "/phonetest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "判断手机号码是否注册", httpMethod = "POST", notes = "判断手机号码是否注册")
	public String phoneTest(@ApiParam(name = "docloginphone", value = "手机号码") @RequestParam String docloginphone)
			throws Exception {
		if (docloginphone != null && docloginphone.trim().length() != 0) {
			int result = doctorService.findDocCountByPhone(docloginphone);
			if (result == 1) {
				return DataResult.success("该号码未注册");
			} else if (result == 2) {
				return DataResult.error("该号码已注册");
			} else {
				return DataResult.error("异常错误");
			}
		} else {
			return DataResult.error("手机号码为空");
		}

	}
	
	//发送短信验证码
	@RequestMapping(value="/getcode", method = RequestMethod.POST,produces = "application/json")
	public Map<String, Object> getCode(@RequestBody Map<String, String> params) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String phone = params.get("phone");
		if (phone != null && phone.trim() != "") {
			Map<String, Object> result = MsgCode.getCode(phone);
			double code =  (double) result.get("code");
		    if (code==200){
		         map.put("state", "1"); //发送成功
		    }else {
		    	map.put("state", "2");  //发送失败
		    	map.put("code",code+"");  
		    }
		    
	    }else {
			map.put("state", "3"); //手机号码为空
		}
		return map;
	}
	
	//发送短信验证码
	@RequestMapping(value = "/getmsgcode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "发送短信验证码", httpMethod = "POST", notes = "发送短信验证码")
	public String getMsgCode(@ApiParam(name = "docloginphone",value="手机号码") @RequestParam String docloginphone) throws Exception {
		if (docloginphone!=null && docloginphone.trim().length()!=0) {
			Map<String, Object> result = MsgCode.getCode(docloginphone);
			double code = (double) result.get("code");
			if (code == 200) {
				return Result.success("获取短信成功");
			} else {
				return Result.error("获取短信失败,错误代码为" + code);
			}
		} else {
			return DataResult.error("手机号码为空");
		}
		

	}
	
	// 注册
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> userRegister(@RequestBody Map<String, String> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String phone = params.get("phone");
		String password = params.get("password");
		String code = params.get("code");
		if (phone != null && phone.trim() != "" && password != null && password.trim() != "" && code!=null && code.trim()!="") {
			if (MsgCode.checkMsg(phone, code)) {
				int result = doctorService.createDoctor(phone,"1", password);
				map.put("state", result+""); //  1表示成功 2表示失败 3该号码已注册 4 操作异常
			} else {
				map.put("state", "5"); // 5 验证码错误
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (phone == null || phone.trim() == "") {
				errList.add("密码为空"); // 密码为空
			}
			if (password == null || password.trim() == "") {
				errList.add("手机号码为空"); // 手机号码为空
			}
			if (code == null || code.trim() == "") {
				errList.add("验证码为空"); // 手机号码为空
			}
			map.put("state", "6"); // 请求的数据不完整
			map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息

		}
		return map;
	}

	// 注册
	@RequestMapping(value = "/docregister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "注册", httpMethod = "POST", notes = "注册")
	public String doctorRegister(@ApiParam(name = "docloginphone", value = "手机号码") @RequestParam String docloginphone,
			@ApiParam(name = "docloginpwd", value = "密码") @RequestParam String docloginpwd,
			@ApiParam(name = "code", value = "短信验证码") @RequestParam String code) throws Exception {
		if (docloginphone != null && docloginphone.trim().length() != 0 && docloginpwd != null
				&& docloginpwd.trim().length() != 0 && code != null && code.trim().length() != 0) {
			int result = doctorService.createDoctor(docloginphone, code, docloginpwd);
			if (1 == result) {
				return DataResult.success("注册成功");
			} else if (2 == result) {
				return DataResult.error("注册失败");
			} else if (3 == result) {
				return DataResult.error("该号码已注册");
			} else {
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (docloginphone == null || docloginphone.trim() == "") {
				errList.add("手机号码为空"); // 密码为空
			}
			if (docloginpwd == null || docloginpwd.trim() == "") {
				errList.add("密码为空"); // 手机号码为空
			}
			if (code == null || code.trim() == "") {
				errList.add("验证码为空"); // 手机号码为空
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}
	
	// 登录
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Map<String, Object> userLogin(@RequestBody @Valid Doctorlogininfo doctorlogininfo,BindingResult bindingResult) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			List<String> errList = new ArrayList<String>();
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				errList.add(objectError.getDefaultMessage());
			}
			map.put("state", "8"); // 请求的数据不完整
			map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
		} else {
			Map<String, Object> result = doctorService.updateDoctorToLogin(doctorlogininfo);
			if ("1".equals(result.get("state"))) { // 重新登录成功
				map.put("state", "1");
				map.put("token", result.get("token"));
				map.put("id", result.get("id"));
				map.put("pix", result.get("pix"));
				map.put("name", result.get("name"));
				map.put("type", result.get("type"));
			} else {
				map.put("state", result.get("state"));
			}
		}
		return map;
	}

	// 登录
	@RequestMapping(value = "/doclogin", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生登录", httpMethod = "POST", notes = "医生登录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docloginphone", required = true, value="手机号码",dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docloginpwd", required = true, value="密码",dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "doclogintoken", required = false, value="token",dataType = "String", paramType = "query") })
	public String doctorLogin(@ApiIgnore Doctorlogininfo doctorlogininfo) throws Exception {
		String docloginphone = doctorlogininfo.getDocloginphone();
		String docloginpwd  = doctorlogininfo.getDocloginpwd();
		if (docloginphone!=null&& docloginphone.trim().length()!=0 && docloginpwd!=null && docloginpwd.trim().length()!=0) {
			Map<String, Object> result = doctorService.updateDoctorToLogin(doctorlogininfo);
			if ("1".equals(result.get("state"))) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("token", result.get("token"));
				map.put("name", result.get("name"));
				map.put("pix", result.get("pix"));
				map.put("type", result.get("type"));
				map.put("id", result.get("id"));
				return DataResult.success("登录成功", map);
			} else if ("2".equals(result.get("state"))) {
				return DataResult.error("登录失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.error("当前token不存在");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("token已过期");
			} else if ("4".equals(result.get("state"))) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("token", result.get("token"));
				map.put("name", result.get("name"));
				map.put("pix", result.get("pix"));
				map.put("type", result.get("type"));
				map.put("id", result.get("id"));
				return DataResult.success("自动登录成功", map);
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("自动登录失败");
			} else if ("7".equals(result.get("state"))) {
				return DataResult.error("用户账号密码不匹配");
			}else if ("8".equals(result.get("state"))) {
				return DataResult.error("该号码未注册");
			} else {
				return DataResult.error("操作异常");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (docloginphone == null || docloginphone.trim() == "") {
				errList.add("手机号码为空");
			}
			if (docloginpwd == null || docloginpwd.trim() == "") {
				errList.add("密码为空"); 
			}
			return DataResult.error( errList.toString().replace("[", "").replace("]", ""));
		}
		
	}
	
	//获取第一页个人信息
	@RequestMapping(value="/getfirstinfo",method=RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public Map<String, Object> getFirstInfo(@RequestBody Map<String, Integer> params) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = params.get("id");
		if (id!=null) {
			Map<String, Object> result = doctorService.getInfo(id,1);
			if ("1".equals(result.get("state"))) {
				//请求成功
				map.put("state", "1"); 
				map.put("data", result.get("data"));
			} else {
				//"2"id 对应的记录为空
				//"3"操作异常
				map.put("state", result.get("state"));
			}
		} else {
			//id为空
			map.put("state", "4");
		}
		return map;
	}

	// 获取第一页个人信息
	@RequestMapping(value = "/getfirstinfo2", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取第一页个人信息", httpMethod = "POST", notes = "获取第一页个人信息")
	public String getFirstInfo2(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid!=null) {
			Map<String, Object> result = doctorService.getInfo(docloginid, 1);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("获取数据成功", result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return DataResult.error("获取数据失败,因对应数据为空");
			} else {
				return DataResult.error("操作异常");

			}
		} else {
			return DataResult.error("医生登录id为空");
		}
		
	}
	
	//获取第二页个人信息
	@RequestMapping(value = "/getsecondinfo", method = RequestMethod.POST)
	public Map<String, Object> getSecondInfo(@RequestBody Map<String, Integer> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer id = params.get("id");
			if (id != null) {
				Map<String, Object> result = doctorService.getInfo(id, 2);
				if ("1".equals(result.get("state"))) {
					map.put("state", "1"); // 请求成功
					map.put("data", result.get("data"));
				} else {
					/*
					 *
					 * "2"id 对应的记录为空 "3"操作异常
					 */
					map.put("state", result.get("state"));
				}
			} else {
				map.put("state", "4");// id为空
			}
		} catch (Exception e) {
			throw e;
		}
		
		
		return map;
	}

	// 获取第二页个人信息
	@RequestMapping(value = "/getsecondinfo2", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取第二页个人信息", httpMethod = "POST", notes = "获取第二页个人信息")
	public String getSecondInfo2(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid != null) {
			Map<String, Object> result = doctorService.getInfo(docloginid, 2);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("获取数据成功", result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return DataResult.error("获取数据失败");
			} else {
				return DataResult.error("操作异常");

			}
		} else {
			return DataResult.error("医生登录id为空");
		}

	}
	
	//更新第一页信息
	@RequestMapping(value="/updatefirst")
	public Map<String, Object>updateFirst(@RequestBody Doctorinfo doctorinfo) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = doctorinfo.getDocloginid();
		if (id!=null) {
			int state = doctorService.updateInfo(doctorinfo);
			map.put("state", state+"");
			/*
			 * "1"成功
			 * "2"更新失败
			 * "3"登录id对应的记录为空
			 * "4"操作异常
			 * */
		} else {
			map.put("state", "5"); // 登录id为空
		}
		return map;
		
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
		}
	)
	public String updateFirstInfo(@ApiIgnore Doctorinfo doctorinfo)
			throws Exception {
		Integer docloginid = doctorinfo.getDocloginid();
		if (docloginid!=null) {
			int result = doctorService.updateInfo(doctorinfo);
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

	// 传图片
	@RequestMapping(value = "/updateSecondInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新第二页个人信息", httpMethod = "POST", notes = "更新第二页个人信息")
	public String updateSecondInfo(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "olddoccardphoto", value = "原身份证照片路径") @RequestParam(required = false) String olddoccardphoto,
			@ApiParam(name = "doccardphoto", value = "身份证照片") @RequestParam MultipartFile[] doccardphoto,
			@ApiParam(name = "olddoctitlephoto", value = "原职称照片路径") @RequestParam(required = false) String olddoctitlephoto,
			@ApiParam(name = "doctitlephoto", value = "职称照片") @RequestParam MultipartFile[] doctitlephoto,
			@ApiParam(name = "olddocqualphoto", value = "原行医资格证照片路径") @RequestParam(required = false) String olddocqualphoto,
			@ApiParam(name = "docqualphoto", value = "行医资格证照片") @RequestParam MultipartFile[] docqualphoto,
			@ApiParam(name = "olddocworkcardphoto", value = "原工作证照片路径") @RequestParam(required = false) String olddocworkcardphoto,
			@ApiParam(name = "docworkcardphoto", value = "工作证照片") @RequestParam MultipartFile[] docworkcardphoto,
			@ApiParam(name = "olddocotherphoto", value = "原其他照片路径") @RequestParam(required = false) String olddocotherphoto,
			@ApiParam(name = "docotherphoto", value = "其他照片") @RequestParam MultipartFile[] docotherphoto)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		if (docloginid != null) {
			int result = doctorService.updateSecondInfo(docloginid, olddoccardphoto, doccardphoto, olddoctitlephoto,
					doctitlephoto, olddocqualphoto, docqualphoto, olddocworkcardphoto, docworkcardphoto,
					olddocotherphoto, docotherphoto);
			if (result == 1) {
				return DataResult.success("修改资料成功");
			} else if (result == 2) {
				return DataResult.error("修改数据失败");
			} else if (result == 3) {
				return DataResult.error("修改数据失败,路径创建失败");
			} else if (result == 4) {
				return DataResult.error("已被审核,个人信息不可修改");
			} else if (result == 5) {
				return DataResult.error("登录id对应的信息为空");
			} else {
				return DataResult.error("操作异常");
			}
		} else {
			return DataResult.error("医生登陆Id为空");
		}
	}
		
	// 传图片
	@RequestMapping(value = "/photo", method = RequestMethod.POST)
	public Map<String, Object> editUserInfo(@RequestParam("appPhoto") MultipartFile[] pictureFile,
			@RequestParam Map<String, String> parmas) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer id = Integer.parseInt(parmas.get("id"));
			Integer type = Integer.parseInt(parmas.get("type"));
			if (pictureFile.length > 0 && id != null && type != null) {
				Map<String, Object> result = doctorService.updatePhoto(pictureFile, id, type);
				if ("1".equals(result.get("state"))) {
					map.put("state", "1");
					map.put("data", result.get("data"));
				} else {
					map.put("state", result.get("state"));
				}

			} else {
				List<String> errList = new ArrayList<String>();
				if (id == null) {
					errList.add("id为空"); // 密码为空
				}
				
				if (type == null) {
					errList.add("类型为空"); // 手机号码为空
				}
				if (pictureFile.length == 0) {
					errList.add("照片为空"); // 手机号码为空
				}
				map.put("state", "7"); // 请求的数据不完整
				map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
			}
		} catch (Exception e) {
			map.put("state", "8"); // 类型转换异常
		}
		
		return map;
	}

	// 获取推荐病情
	@RequestMapping(value = "/getresick")
	public Map<String, Object> getReSick(@RequestBody Map<String, Integer> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = params.get("id");
		Integer page = params.get("page");
		if (id != null && page!=null) {
			Map<String, Object> list = doctorService.getReSick(id,page);
			if ("1".equals(list.get("state"))) {
				map.put("state", "1"); // 成功
				map.put("data", list.get("data"));
			} else {
				map.put("state", list.get("state"));
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (id == null) {
				errList.add("id为空"); // id为空
			}
			if (page == null) {
				errList.add("当前页数为空"); // 手机号码为空
			}
			map.put("state", "5"); // 请求的数据不完整
			map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
		}
		return map;
	}

	/*// 获取病情按时间排序
	@RequestMapping(value = "getsickbytime", method = RequestMethod.POST)
	public Map<String, Object> getSickByTime(@RequestBody Map<String, Integer> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = params.get("id");
		Integer page = params.get("page");
		if (id != null && page != null) {
			Map<String, Object> result = doctorService.getSickByTime(id, page);
			if ("1".equals(result.get("state"))) {
				map.put("state", "1");
				map.put("data", result.get("data"));
			} else {
				map.put("state", result.get("state"));
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (id == null) {
				errList.add("id为空"); // id为空
			}
			if (page == null) {
				errList.add("当前页数为空"); // 手机号码为空
			}
			map.put("state", "5"); // 请求的数据不完整
			map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
		}

		return map;

	}*/

	/*// 获取病情按城市排序
	@RequestMapping(value = "/getsickbyloc", method = RequestMethod.POST)
	public Map<String, Object> getSickByCity(@RequestBody Map<String, Object> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer id = (Integer) params.get("id");
			Integer page = (Integer) params.get("page");
			String loc = (String) params.get("loc");
			if (id != null && page != null && loc != null && loc.trim() != "") {
				Map<String, Object> result = doctorService.getSickByLoc(id, page, loc);
				if ("1".equals(result.get("state"))) {
					map.put("state", "1");
					map.put("data", result.get("data"));
				} else {
					map.put("state", result.get("state"));
				}
			} else {
				List<String> errList = new ArrayList<String>();
				if (id == null) {
					errList.add("id为空"); // id为空
				}
				if (page == null) {
					errList.add("当前页数为空"); // 当前页数为空
				}
				if (loc != null && loc.trim() != "") {
					errList.add("当前位置为空"); // 当前位置为空
				}
				map.put("state", "5"); // 请求的数据不完整
				map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
			}

		} catch (Exception e) {
			map.put("state", "6"); // 接收数据类型错误
		}

		return map;

	}*/

	// 获取病情详细
	/*@RequestMapping(value = "/sickdetail")
	public Map<String, Object> getSickDetail(@RequestBody Map<String, Integer> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = params.get("id");
		if (id != null) {
			Map<String, Object> data = doctorService.getSickDetail(id);
			if ("1".equals(data.get("state"))) {
				map.put("state", "1");
				map.put("data", data.get("data"));
			} else {
				map.put("state", data.get("state"));
			}

		} else {
			map.put("state", "7"); // id为空
		}
		return map;
	}
*/
	// 获取病人头像
/*	@RequestMapping(value = "/getuserpix", method = RequestMethod.POST)
	public Map<String, Object> getPix(@RequestBody Map<String, Integer> params) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		//病情id
		Integer id = params.get("id");
		if (id!=null) {
			map.put("state", "1"); //请求成功
			System.out.println("2222");
		} else {
			map.put("state", "7");
		}
		return map;
	}*/
	//获取科室
	@RequestMapping(value = "/getdept", method = RequestMethod.GET)
	public Map<String, Object> getDept() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> result = doctorService.getDept();
		if ("1".equals(result.get("state"))) {
			map.put("state", "1"); // 请求成功
			map.put("data", result.get("data"));
		} else {
			map.put("state", result.get("state"));
		}
		return map;
	}
	//获取科室
	@RequestMapping(value = "/getfatherdept", method = RequestMethod.GET)
	public Map<String, Object> getSonDept() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> result = doctorService.getDeptByFatherId(0);
		if ("1".equals(result.get("state"))) {
			map.put("state", "1"); //请求成功
			map.put("data", result.get("data")); 
		} else {
			map.put("state", "2");
		}
		return map;
	}
	
	//获取科室
	@RequestMapping(value = "/getsondept", method = RequestMethod.POST)
	public Map<String, Object> getSonDept(@RequestBody Map<String, Integer> params) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = params.get("id");
		if (id != null) {
			Map<String, Object> result = doctorService.getDeptByFatherId(id);
			if ("1".equals(result.get("state"))) {
				map.put("state", "1"); //请求成功
				map.put("data", result.get("data")); 
			} else {
				map.put("state", "2");
			}
		} else {
			map.put("state", "7"); // id为空
		}
		return map;
		
	}
	// 获取日程表
	@RequestMapping(value="/getschedule")
	public Map<String, Object> getSchedule(@RequestBody Map<String, Integer> params) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Integer docLoginId = params.get("docloginid");
		if (docLoginId!=null) {
			Map<String, Object> result = doctorService.getSchedule(docLoginId);
			if ("1".equals(result.get("state"))) {
				map.put("state", "1"); //请求成功
				map.put("data", result.get("data")); 
				map.put("docskdid", result.get("id"));
			} else {
				map.put("state",result.get("state"));
			}
		} else {
			//医生登录id为空
			map.put("state", "4");
		}
		return map;
	}
	//设置日程
	@RequestMapping(value="/schedule")
	public Map<String, Object> updateSchedule(@Valid Doctorskd doctorskd,BindingResult bindingResult){
		Map<String, Object> map = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			List<String> errList = new ArrayList<String>();
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				errList.add(objectError.getDefaultMessage());
			}
			map.put("state", "5"); // 请求的数据不完整
			map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
		} else {
			int result = doctorService.updateSchedule(doctorskd);
			//"1"更新日程成功
			//"2"更新日程失败
			//"3"该id对应的日程为空
			//"4"操作异常
			map.put("state", result+"");
			
		}
		return map;
	}
	
	// 获取病情
	@RequestMapping(value = "/listsicks", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情", httpMethod = "POST", notes = "获取病情",produces="application/json")
	public String listSick(@ApiParam(name = "docloginid",required = true,value ="医生登录id")@RequestParam(required=true) Integer docloginid,
			@ApiParam(name = "page",value ="当前页")@RequestParam(required=true) Integer page,
			@ApiParam(name = "lat",value ="精度")@RequestParam(required=true) String lat,
			@ApiParam(name = "lon",value ="纬度")@RequestParam(required=true) String lon,
			@ApiParam(name = "time",value ="时间")@RequestParam(required=false) String time,
			@ApiParam(name = "province",value ="省")@RequestParam(required=false) String province,
			@ApiParam(name = "city",value ="市")@RequestParam(required=false) String city,
			@ApiParam(name = "area",value ="区")@RequestParam(required=false) String area
			
			) throws Exception {
		   Integer pageSize = 5;
			Map<String, Object> result = doctorService.listSick(page, pageSize, docloginid,lat, lon,time,province,city,area);
			if ("1".equals(result.get("state"))) {
				return PaginationResult.success("推荐病情获取成功", result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return PaginationResult.error("推荐病情获取失败,因数据为空",null);
			} else if ("3".equals(result.get("state"))) {
				return PaginationResult.success("按时间排序病情获取成功", result.get("data"));
			} else if ("4".equals(result.get("state"))) {
				return PaginationResult.error("获取失败");
			} else if ("5".equals(result.get("state"))) {
				return PaginationResult.success("按距离排序病情获取成功", result.get("data"));
			} else if ("6".equals(result.get("state"))) {
				return PaginationResult.error("获取失败");
			} else if ("7".equals(result.get("state"))) {
				return PaginationResult.error("查询个人信息为空");
			}else {
				return DataResult.error("异常错误");
			}		

	}
	
	//获取病情详情
	@RequestMapping(value = "/getsickdetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情详情", httpMethod = "POST", notes = "获取病情详情", produces = "application/json")
	public String getsickDeatil(
			@ApiParam(name = "usersickid", required = true, value = "病情id") @RequestParam(required = true) Integer usersickid

	) throws Exception {

		Map<String, Object> result = doctorService.getSickDetail(usersickid);
		if ("1".equals(result.get("state"))) {
			return DataResult.success("病情详情获取成功", result.get("data"));
		} else if ("2".equals(result.get("state"))) {
			return DataResult.error("获取失败");
		} else {
			return DataResult.error("异常错误");
		}

	}
	// 医生抢单
	@RequestMapping(value = "/graborder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生抢单", httpMethod = "POST", notes = "医生抢单", produces = "application/json")
	public String grabOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "usersickid", required = true, value = "病情id") @RequestParam(value = "usersickid") Integer usersickid,
			@ApiParam(name = "preorderprice", value = "预估价格") @RequestParam(required = false) Double preorderprice) {
		if (docloginid != null && usersickid != null) {
			Map<String, Object> result = doctorService.creatPreOrder(usersickid, docloginid, preorderprice);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("操作成功,且消息发送成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.error("操作成功，但消息推送失败", result.get("msg"));
			} else if ("3".equals(result.get("state"))) {
				return DataResult.error("操作成功，消息推送获取用户信息获取数据失败");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("抢单失败");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("抢单失败，已抢单");
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("查询病情失败");
			} else {
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (docloginid == null) {
				errList.add("医生登录id为空"); // id为空
			}
			if (usersickid == null) {
				errList.add("病情id为空"); // 手机号码为空
			}
			return DataResult.error( errList.toString().replace("[", "").replace("]", ""));
		}
	}
	
	//获取已抢订单
	@RequestMapping(value = "/listgraborders", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取已抢订单", httpMethod = "POST", notes = "获取已抢订单", produces = "application/json")
	public String listGrabOrders(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page",required = true,value ="当前页" )@RequestParam(value="page") Integer page
			) {
		Map<String, Object> result = doctorService.listGrabOrders(docloginid,page,5);
		if ("1".equals(result.get("state"))) {
			return DataResult.success("获取成功",result.get("data"));
		} else if ("2".equals(result.get("state"))) {
			return DataResult.error("数据为空");
		}else {
			return DataResult.error("异常错误");
		}

	}
	//获取已抢订单
	@RequestMapping(value = "/getgraborder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取已抢订单详情", httpMethod = "POST", notes = "获取已抢订单详情", produces = "application/json")
	public String getGrabOrder(
			@ApiParam(name = "preorderid", required = true, value = "登录id") @RequestParam(value = "preorderid") Integer preorderid) {
		Map<String, Object> result = doctorService.getGrabOrderDetail(preorderid);
		if ("1".equals(result.get("state"))) {
			return DataResult.success("获取成功", result.get("data"));
		} else if ("2".equals(result.get("state"))) {
			return DataResult.error("数据为空");
		} else {
			return DataResult.error("异常错误");
		}

	}
	
	// 医生取消抢单
	@RequestMapping(value = "/cancelorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生取消抢单", httpMethod = "POST", notes = "医生取消抢单")
	public String cancelOrder(@ApiParam(name = "preorderid",required = true,value ="预订单id" )@RequestParam(value="preorderid") Integer preorderid) {
		if (preorderid != null) {
			Map<String, Object> result = doctorService.deletePreOrder(preorderid);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("取消成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("取消成功,但消息发送失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.success("取消成功,但消息发送失败");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("取消抢单失败");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("预订单id对应数据为空");
			} else {
				return DataResult.error("异常错误");
			}
		} else {
			// 预订单id为空
			return DataResult.error("预订单id为空");
		}
	}
	
	//医生获取等待确认订单
	@RequestMapping(value="/listordertoconfirm",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取等待确认订单", httpMethod = "POST", notes = "医生获取等待确认订单")
	public String listOrderToConfirm(@ApiParam(name = "docloginid",required = true,value ="登录id" )@RequestParam(value="docloginid") Integer docloginid,
							@ApiParam(name = "page",required = true,value ="当前页" )@RequestParam(value="page") Integer page
			)throws Exception{
		Map<String, Object> resultMap = doctorService.listOrder(docloginid, 1,page,5);
		if ("1".equals(resultMap.get("state"))) {
			return DataResult.success("获取成功", resultMap.get("data"));

		} else if ("2".equals(resultMap.get("state"))) {
			return DataResult.error("获取的数据为空");

		} else{
			return DataResult.error("操作异常");
		}
		
	}

	// 医生获取正在进行订单
	@RequestMapping(value = "/listorderinpro", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取正在进行订单", httpMethod = "POST", notes = "医生获取正在进行订单")
	public String listOnOrderInPro(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page)
			throws Exception {
		Map<String, Object> resultMap = doctorService.listOrder(docloginid,2, page, 5);
		if ("1".equals(resultMap.get("state"))) {
			return DataResult.success("获取成功", resultMap.get("data"));

		} else if ("2".equals(resultMap.get("state"))) {
			return DataResult.error("获取的数据为空");

		} else {
			return DataResult.error("操作异常");
		}

	}

	// 医生获取全部订单
	@RequestMapping(value = "/listallorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取全部订单", httpMethod = "POST", notes = "医生获取全部订单")
	public String listAllOrder(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page)
			throws Exception {
		Map<String, Object> resultMap = doctorService.listOrder(docloginid,3, page, 5);
		if ("1".equals(resultMap.get("state"))) {
			return DataResult.success("获取成功", resultMap.get("data"));

		} else if ("2".equals(resultMap.get("state"))) {
			return DataResult.error("获取的数据为空");

		} else {
			return DataResult.error("操作异常");
		}

	}
	
	//医生获取订单详情
	@RequestMapping(value = "/getorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取订单详情", httpMethod = "POST", notes = "医生获取订单详情")
	public String getOrder(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "userorderid", required = true, value = "订单id") @RequestParam(value = "userorderid") Integer userorderid)
			throws Exception {
		Map<String, Object> resultMap = doctorService.getOrderDetail(docloginid,userorderid);
		if ("1".equals(resultMap.get("state"))) {
			return DataResult.success("获取成功", resultMap.get("data"));
		} else if ("2".equals(resultMap.get("state"))) {
			return DataResult.success("请求成功,但数据为空");
		} else {
			return DataResult.error("操作异常");
		}

	}
	
	//根据医院名迷糊查询医院
	@RequestMapping(value="/gethospital",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ApiOperation(value = "根据医院名迷糊查询医院", httpMethod = "POST", notes = "根据医院名迷糊查询医院")
	public String getHosptial(@ApiParam(name = "hospname", required = true, value = "医院名") @RequestParam String hospname) throws Exception{
		if (hospname!=null) {
			Map<String, Object> result = doctorService.getHospital(hospname);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("请求成功", result.get("data"));
			} else if ("2".equals(result.get("state"))){
				return DataResult.success("请求成功,但数据为空");
			}else {
				return DataResult.error("操作异常");
			}
		} else {
			return DataResult.error("医院名为空");
		}
	}

	// 医生拒绝接单
	@RequestMapping(value = "/refuseorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生拒绝接单", httpMethod = "POST", notes = "医生拒绝接单")
	public String refuseOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "userorderid", required = true, value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "redocloginid", value = "推荐医生登陆id") @RequestParam(required = false) Integer redocloginid) {
		if (docloginid != null && userorderid != null) {
			Map<String, Object> result = doctorService.updateOrderToRefuse(docloginid, userorderid, redocloginid);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("拒绝接单成功,且消息发送成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("拒绝接单成功,但消息发送失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.success("拒绝接单失败，未知错误");
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
		@ApiImplicitParam(name = "userorderhstate",required = true,value ="是否住院" ,dataType = "Boolean", paramType = "query"),
		@ApiImplicitParam(name = "userorderhospid",required = false,value ="接诊医院id",dataType = "int", paramType = "query" ),
		@ApiImplicitParam(name = "userorderhprice",required = false,value ="医院价格" ,dataType = "Double", paramType = "query"),
		@ApiImplicitParam(name = "userordertpricetype",required = true,value ="交通类型",dataType = "int", paramType = "query" ),
		@ApiImplicitParam(name = "userordertprice",required = false,value ="交通价格" ,dataType = "Double", paramType = "query"),
		@ApiImplicitParam(name = "userorderapricetype",required = true,value ="住宿类型",dataType = "int", paramType = "query" ),
		@ApiImplicitParam(name = "userorderaprice",required = false,value ="住宿价格" ,dataType = "Double", paramType = "query"),
		@ApiImplicitParam(name = "userorderepricetype",required = true,value ="餐饮类型",dataType = "int", paramType = "query" ),
		@ApiImplicitParam(name = "userordereprice",required = false,value ="住宿价格",dataType = "Double", paramType = "query" )
		 })
	public String confirmOrder(@ApiIgnore Userorder userorder,@ApiIgnore Integer docloginid)throws Exception{
		Integer userorderid = userorder.getUserorderid();
		Boolean userorderhstate = userorder.getUserorderhstate();
		Integer userordertpricetype = userorder.getUserordertpricetype();
		Integer userorderapricetype= userorder.getUserorderapricetype();
		Integer userorderepricetype= userorder.getUserorderepricetype();
		if (userorderid!=null && userorderhstate!=null && userordertpricetype!=null && userorderapricetype!=null&& userorderepricetype!=null) {
			Map<String, Object> result = doctorService.updateOrderConfirm(userorder);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("操作成功,且消息发送成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("操作成功，但消息推送失败",result.get("msg"));
			} else if ("3".equals(result.get("state"))) {
				return DataResult.success("操作成功，消息推送获取用户信息获取数据失败");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("确认失败");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("该状态不支持确认");
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("查询病情失败");
			} else{
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userorderid == null) {
				errList.add("订单id为空"); 
			}
			if (userorderhstate == null) {
				errList.add("是否医院为空"); 
			}
			if (userordertpricetype == null) {
				errList.add("交通类型为空"); 
			}
			if (userorderepricetype == null) {
				errList.add("餐饮类型为空");
			}
			return DataResult.error( errList.toString().replace("[", "").replace("]", ""));
		}
		
	
	}
	
	//医生取消订单
	@RequestMapping(value = "/cancel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生取消订单", httpMethod = "POST", notes = "医生取消订单")
	public String cancel(
			@ApiParam(name = "docloginid",required = true,value ="医生登陆id" )@RequestParam Integer docloginid,
			@ApiParam(name = "userorderid",required = true,value ="订单id" )@RequestParam Integer userorderid) {
		if (docloginid != null && userorderid!=null) {
			Map<String, Object> result = doctorService.updateOrderToCancle(docloginid,userorderid);
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
	//更换部门
	@RequestMapping(value = "/changedept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更换部门", httpMethod = "POST", notes = "更换部门")
	public String changeDept(
			@ApiParam(name = "docloginid",required = true,value ="医生登陆id" )@RequestParam Integer docloginid,
			@ApiParam(name = "usersickid",required = true,value ="订单id" )@RequestParam Integer userorderid,
			@ApiParam(name = "usersickprimarydept",value ="一级部门" )@RequestParam String usersickprimarydept,
			@ApiParam(name = "usersickseconddept",value ="二级部门" )@RequestParam(required=false) String usersickseconddept) {
		if (docloginid != null && userorderid!=null) {
			Map<String, Object> result = doctorService.changeDept(docloginid,userorderid,usersickprimarydept,usersickseconddept);
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
	/*//医生完善订单信息
	@RequestMapping(value="/updateorder")
	public Map<String, Object> editOrder(@RequestBody @Valid Userorder userorder,BindingResult bindingResult) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			List<String> errList = new ArrayList<String>();
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				errList.add(objectError.getDefaultMessage());
			}
			map.put("state", "6"); // 请求的数据不完整
			map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
			
		} else {
			int result = doctorService.updateOrder(userorder);
			map.put("state", result+"");
		}
		return map;
	}*/
	
/*	//获取全部病情
	@RequestMapping(value = "/sicks", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getSicks(@RequestBody Map<String, String> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String page = params.get("page");
		String lon = params.get("lon");
		String lat = params.get("lat");
		String dept = params.get("dept");
		String loc = params.get("loc");
		String date = params.get("date");
		System.out.println("loc位置"+loc);
		if (lon != null && lon.trim() != "" && lat != null && lat.trim() != "" && page != null && page.trim() != "") {
			int num = Integer.parseInt(page);
			SickSearch sickSearch = new SickSearch();
			int startPage = (num - 1) * 10;
			sickSearch.setStartPage(startPage);
			sickSearch.setPageSize(10);
			sickSearch.setLat(lat);
			sickSearch.setLon(lon);
			sickSearch.setTime(date);
			System.out.println("day"+date);
			if (dept != null && dept.trim() != "") {
				sickSearch.setDept(dept.trim());
			}
			if (loc != null && loc.trim() != "") {
				sickSearch.setLoc(loc.trim()+"%");
				sickSearch.setLat("0");
				sickSearch.setLon("0");
			}
			Map<String, Object> resultMap = doctorService.getSicks(sickSearch);
			if ("1".equals(resultMap.get("state"))) {
				map.put("state", "1"); // 请求数据成功
				map.put("data", resultMap.get("data"));
			} else {
				map.put("state", "2"); // 请求失败
			}
			
		} else {
			List<String> errList = new ArrayList<String>();
			if (page == null || page.trim() == "") {

				errList.add("当前页数为空"); // 当前页数为空
			}
			if (lon == null || lon.trim() == "") {
				errList.add("经度为空"); // 经度为空
			}
			if (lat == null || lat.trim() == "") {
				errList.add("纬度为空"); // 纬度为空
			}
			map.put("state", "3"); // 请求的数据不完整
			map.put("errMsg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
		}
		return map;
	}*/
	
	
}
