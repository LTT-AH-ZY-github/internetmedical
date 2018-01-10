package com.medical.controller.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.user.UserAccountService;
import com.medical.utils.CheckUtils;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     UserAccountController.java
 * @Description:   用户账户信息管理 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 上午10:45:40 
 */

@RestController
@RequestMapping(value = "/user")
public class UserAccountController {
	@Autowired
	private CommonService commonService;
	@Autowired
	private UserAccountService userAccountService;

	@RequestMapping(value = "/phonetest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "验证手机号码是否注册", httpMethod = "POST", notes = "验证手机号码是否注册", produces = "application/json")
	public String phoneTest(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam String userloginphone)
			throws Exception {
		if (!CheckUtils.isChinaPhoneLegal(userloginphone)) {
			return Result.error("手机号码输入有误");
		}
		return userAccountService.findAccountExit(userloginphone);
	}

	@RequestMapping(value = "/getcode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取短信验证码", httpMethod = "POST", notes = "获取短信验证码", produces = "application/json")
	public String getCode(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam String userloginphone)
			throws Exception {
		if (!CheckUtils.isChinaPhoneLegal(userloginphone)) {
			return Result.error("手机号码有误");
		}
		return commonService.getMsgCode(userloginphone);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "用户注册", httpMethod = "POST", notes = "用户注册")
	public String userRegister(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam String userloginphone,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam String userloginpwd,
			@ApiParam(name = "code", required = true, value = "短信验证码") @RequestParam String code) throws Exception {
		if (!CheckUtils.isChinaPhoneLegal(userloginphone)) {
			return Result.error("手机号码有误");
		}
		if (StringUtils.isBlank(userloginpwd)) {
			return DataResult.error("密码为空");
		}
		if (StringUtils.isBlank(code)) {
			return DataResult.error("验证码为空");
		}
		return userAccountService.createUserAccount(userloginphone, userloginpwd, code);

	}

	@RequestMapping(value = "/huanxinregister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "环信注册", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "环信注册")
	public String huanXinRegister(
			@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam String userloginpwd)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (StringUtils.isBlank(userloginpwd)) {
			return DataResult.error("密码为空");
		}
		return userAccountService.createHuanXinAccout(userloginid, userloginpwd);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "用户登录", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "用户登录")
	public String userLogin(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam String userloginphone,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam String userloginpwd,
			@ApiParam(name = "userlogindev", value = "登录设备，1为安卓设置，2为IOS设备") @RequestParam(required = false) Integer userlogindev,
			@ApiParam(name = "userlogintoken", value = "token") @RequestParam(required = false) String userlogintoken)
			throws Exception {
		if (!CheckUtils.isChinaPhoneLegal(userloginphone)) {
			return Result.error("手机号码有误");
		}
		if (StringUtils.isBlank(userloginpwd)) {
			return DataResult.error("密码为空");
		}
		if (userlogindev!=1 && userlogindev!=2) {
			return DataResult.error("登录设备有误");
		}
		if (StringUtils.isBlank(userlogintoken)) {
			//为普通登录
			return userAccountService.updateUserToNormalLogin(userloginphone, userloginpwd, userlogindev);
		} else {
			//token不为空，为自动登录
			return userAccountService.updateUserToAutoLogin(userloginphone, userloginpwd, userlogintoken, userlogindev);
		}
	}

	
	@RequestMapping(value = "/exit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "用户退出登陆", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "用户退出登陆")
	public String exitUserLoginInfo(
			@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam Integer userloginid)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("id为空");
		}
		return userAccountService.updateUserToExit(userloginid);
	}

	@RequestMapping(value = "/editpassword", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改密码", httpMethod = "POST", notes = "修改密码")
	public String editPassword(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam String userloginphone,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam String userloginpwd,
			@ApiParam(name = "code", required = true, value = "短信验证码") @RequestParam String code) throws Exception {
		if (!CheckUtils.isChinaPhoneLegal(userloginphone)) {
			return Result.error("手机号码有误");
		}
		if (StringUtils.isBlank(userloginpwd)) {
			return DataResult.error("密码为空");
		}
		if (StringUtils.isBlank(code)) {
			return DataResult.error("验证码为空");
		}
		return userAccountService.updatePassword(userloginphone, userloginpwd, code);
	}
}
