package com.medical.controller.doctor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.medical.po.Doctorlogininfo;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.doctor.DoctorAccountService;
import com.medical.utils.CheckUtils;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.Result;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


/**
 * @ClassName:     DoctorAccountController.java
 * @Description:   医生账号管理
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午9:16:36 
 */
@RestController
@RequestMapping(value = "/doctor")
public class DoctorAccountController {
	@Autowired
	private DoctorAccountService doctorAccountService;
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
			return doctorAccountService.findAccountExit(docloginphone);
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
		if (dev == null) {
			dev = 1;
		}
		if (StringUtils.isNotBlank(doclogintoken)) {
			// 自动登录
			return doctorAccountService.updateDoctorToAutoLogin(doctorlogininfo);
		} else {
			// 普通登录
			return doctorAccountService.updateDoctorToNormalLogin(doctorlogininfo);
		}
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

}
