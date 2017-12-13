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

	/**
	 * @Title: phoneTest
	 * @Description: 手机号码判断是否注册
	 * @param userloginphone
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/phonetest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "验证手机号码是否注册", httpMethod = "POST", notes = "验证手机号码是否注册", produces = "application/json")
	public String phoneTest(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam(value = "userloginphone") String userloginphone)
			throws Exception {
		if (!CheckUtils.isChinaPhoneLegal(userloginphone)) {
			return Result.error("手机号码输入有误");
		}
		return userAccountService.findAccountExit(userloginphone);
	}

	/**
	 * @Title: getCode
	 * @Description: 获取短信验证码
	 * @param userloginphone
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/getcode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取短信验证码", httpMethod = "POST", notes = "获取短信验证码", produces = "application/json")
	public String getCode(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam String userloginphone)
			throws Exception {
		if (!CheckUtils.isChinaPhoneLegal(userloginphone)) {
			return Result.error("手机号码输入有误");
		}
		return commonService.getMsgCode(userloginphone);
	}

	/**
	 * @Title: userRegister
	 * @Description: 用户注册
	 * @param userloginphone
	 * @param userloginpwd
	 * @param code
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "用户注册", httpMethod = "POST", notes = "用户注册")
	public String userRegister(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam(value = "userloginphone") String userloginphone,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam(value = "userloginpwd") String userloginpwd,
			@ApiParam(name = "code", required = true, value = "短信验证码") @RequestParam String code) throws Exception {
		if (!CheckUtils.isChinaPhoneLegal(userloginphone)) {
			return Result.error("手机号码输入有误");
		}
		if (StringUtils.isBlank(userloginpwd)) {
			return DataResult.error("密码为空");
		}
		if (StringUtils.isBlank(code)) {
			return DataResult.error("验证码为空");
		}
		return userAccountService.createUserAccount(userloginphone, userloginpwd, code);

	}

	/**
	 * @Title: huanXinRegister
	 * @Description: 环信注册
	 * @param userloginid
	 * @param userloginpwd
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/huanxinregister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "环信注册", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "环信注册")
	public String huanXinRegister(
			@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam(value = "userloginid") Integer userloginid,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam(value = "userloginpwd") String userloginpwd)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (userloginpwd == null) {
			return DataResult.error("密码为空");
		}
		return userAccountService.createHuanXinAccout(userloginid, userloginpwd);
	}

	/**
	 * @Title: userLogin
	 * @Description: 用户登录
	 * @param userloginphone
	 * @param userloginpwd
	 * @param userlogindev
	 * @param userlogintoken
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "用户登录", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "用户登录")
	public String userLogin(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam(value = "userloginphone") String userloginphone,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam(value = "userloginpwd") String userloginpwd,
			@ApiParam(name = "userlogindev", value = "登录设备，1为安卓设置，2为IOS设备") @RequestParam(required = false) Integer userlogindev,
			@ApiParam(name = "userlogintoken", value = "token") @RequestParam(required = false) String userlogintoken)
			throws Exception {
		if (!CheckUtils.isChinaPhoneLegal(userloginphone)) {
			return Result.error("手机号码输入有误");
		}
		if (StringUtils.isBlank(userloginpwd)) {
			return DataResult.error("密码为空");
		}
		if (userlogindev == null) {
			userlogindev = 1;
		}
		if (StringUtils.isBlank(userlogintoken)) {
			return userAccountService.updateUserToNormalLogin(userloginphone, userloginpwd, userlogindev);
		} else {
			return userAccountService.updateUserToAutoLogin(userloginphone, userloginpwd, userlogintoken, userlogindev);
		}
	}

	/**
	 * @Title: exitUserLoginInfo
	 * @Description: 用户退出登陆
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/exit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "用户退出登陆", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "用户退出登陆")
	public String exitUserLoginInfo(
			@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam(value = "userloginid") Integer userloginid)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("id为空");
		}
		return userAccountService.updateUserToExit(userloginid);
	}

	/**
	 * @Title: editPassword
	 * @Description: 修改密码
	 * @param userloginphone
	 * @param userloginpwd
	 * @param code
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/editpassword", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改密码", httpMethod = "POST", notes = "修改密码")
	public String editPassword(
			@ApiParam(name = "userloginphone", required = true, value = "手机号码") @RequestParam(value = "userloginphone") String userloginphone,
			@ApiParam(name = "userloginpwd", required = true, value = "密码") @RequestParam(value = "userloginpwd") String userloginpwd,
			@ApiParam(name = "code", required = true, value = "短信验证码") @RequestParam String code) throws Exception {
		if (!CheckUtils.isChinaPhoneLegal(userloginphone)) {
			return Result.error("手机号码输入有误");
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
