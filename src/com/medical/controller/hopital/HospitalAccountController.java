package com.medical.controller.hopital;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.hospital.HospitalAccountService;
import com.medical.utils.CheckUtils;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import net.sf.json.JSONObject;

/**
 * @ClassName: HospitalAccountController.java
 * @Description: 医院账号管理
 * @author xyh
 * @version V1.0
 * @Date 2017年11月27日 下午3:31:30
 */
@RestController
@RequestMapping(value = "/hospital")
public class HospitalAccountController {
	@Autowired
	private HospitalAccountService hospitalAccountService;
	@Autowired
	private CommonService commonService;

	// 判断手机号码是否注册
	@RequestMapping(value = "/phonetest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "判断手机号码是否注册", httpMethod = "POST", notes = "判断手机号码是否注册")
	public String phoneTest(@ApiParam(name = "hosploginphone", value = "手机号码") @RequestParam String hosploginphone)
			throws Exception {
		if (StringUtils.isBlank(hosploginphone)) {
			return Result.error("手机号码为空");
		} else {
			if (!CheckUtils.isChinaPhoneLegal(hosploginphone)) {
				return Result.error("手机号码格式错误");
			}
			return hospitalAccountService.findAccountExit(hosploginphone);
		}
	}

	// 发送短信验证码
	@RequestMapping(value = "/getmsgcode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "发送短信验证码", httpMethod = "POST", notes = "发送短信验证码")
	public String getMsgCode(@ApiParam(name = "hosploginphone", value = "手机号码") @RequestParam String hosploginphone)
			throws Exception {
		if (StringUtils.isBlank(hosploginphone)) {
			return Result.error("手机号码为空");
		} else {
			if (!CheckUtils.isChinaPhoneLegal(hosploginphone)) {
				return Result.error("手机号码格式错误");
			}
			return commonService.getMsgCode(hosploginphone);
		}

	}

	// 注册
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "注册", httpMethod = "POST", notes = "注册")
	public String doctorRegister(@ApiParam(name = "hosploginphone", value = "手机号码") @RequestParam String hosploginphone,
			@ApiParam(name = "hosploginpwd", value = "密码") @RequestParam String hosploginpwd,
			@ApiParam(name = "code", value = "短信验证码") @RequestParam String code) throws Exception {
		if (StringUtils.isBlank(hosploginphone)) {
			return DataResult.error("手机号码为空");
		}
		if (StringUtils.isNotBlank(hosploginphone) && !CheckUtils.isChinaPhoneLegal(hosploginphone)) {
			return Result.error("手机号码格式错误");
		}
		if (StringUtils.isBlank(hosploginpwd)) {
			return DataResult.error("密码为空");
		}
		if (StringUtils.isBlank(code)) {
			return DataResult.error("验证码为空");
		}
		return hospitalAccountService.createAccount(hosploginphone, code, hosploginpwd);

	}

	// 环信注册
	@RequestMapping(value = "/huanxinregister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "环信注册", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "环信注册")
	public String huanXinRegister(
			@ApiParam(name = "hosploginid", required = true, value = "用户登录id") @RequestParam Integer hosploginid,
			@ApiParam(name = "hosploginpwd", value = "密码") @RequestParam String hosploginpwd) throws Exception {
		if (hosploginid == null) {
			return DataResult.error("id为空");
		}
		boolean result = hospitalAccountService.addHuanXinAccout(hosploginid, hosploginpwd);
		if (result) {
			return DataResult.success("注册成功");
		} else {
			return DataResult.success("已注册");
		}

	}

	// 登录
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "登录", httpMethod = "POST", notes = "登录")
	public String doctorLogin(
			@ApiParam(name = "hosploginphone", required = true, value = "登录号码") @RequestParam String hosploginphone,
			@ApiParam(name = "hosploginpwd", required = true, value = "密码") @RequestParam String hosploginpwd)
			throws Exception {
		if (StringUtils.isBlank(hosploginphone)) {
			return DataResult.error("手机号码为空");
		}
		if (StringUtils.isNotBlank(hosploginphone) && !CheckUtils.isChinaPhoneLegal(hosploginphone)) {
			return Result.error("手机号码格式错误");
		}
		if (StringUtils.isBlank(hosploginpwd)) {
			return DataResult.error("密码为空");
		}
		return hospitalAccountService.updateDoctorToNormalLogin(hosploginphone, hosploginpwd);
	}
	
	// 登录
	/*@RequestMapping(value = "/weblogin", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "登录", httpMethod = "POST", notes = "登录")
	public String webLogin(
			@ApiParam(name = "hosploginphone", required = true, value = "登录号码") @RequestParam String hosploginphone,
			@ApiParam(name = "hosploginpwd", required = true, value = "密码") @RequestParam String hosploginpwd)
			throws Exception {
		if (StringUtils.isBlank(hosploginphone)) {
			return DataResult.error("手机号码为空");
		}
		if (StringUtils.isNotBlank(hosploginphone) && !CheckUtils.isChinaPhoneLegal(hosploginphone)) {
			return Result.error("手机号码格式错误");
		}
		if (StringUtils.isBlank(hosploginpwd)) {
			return DataResult.error("密码为空");
		}
		return hospitalAccountService.updateDoctorToNormalLogin(hosploginphone, hosploginpwd);
	}*/

	@RequestMapping(value = "/loginsubmit", produces = "application/json;charset=UTF-8")
	public  String loginsubmit(HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("进入登陆提交函数！！");
		response.addHeader("Access-Control-Allow-Origin","*");
		String hosploginphone = request.getParameter("hosploginphone");
		String hosploginpwd = request.getParameter("hosploginpwd");
		Map<String,Object> result = new HashMap<String,Object>();
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(hosploginpwd.getBytes());
		String hosploginpwdMD5 = new BigInteger(1, md.digest()).toString(16);
		String data =  hospitalAccountService.updateDoctorToNormalLogin(hosploginphone, hosploginpwdMD5);
		JSONObject jsonObject = JSONObject.fromObject(data);
		String logincode = jsonObject.get("code").toString();
		if("100".equals(logincode)) {
			JSONObject datajson = jsonObject.getJSONObject("data");
			String huanxinaccount = datajson.get("huanxinaccount").toString();
			HttpSession session = request.getSession();  
		    session.setAttribute("huanxinaccount", huanxinaccount); 
		}
		return data;
		
	}
	// 用户退出登陆
	@RequestMapping(value = "/exit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "退出登陆", httpMethod = "POST", notes = "退出登陆")
	public String exitUserLoginInfo(
			@ApiParam(name = "hosploginid", required = true, value = "用户登录id") @RequestParam Integer hosploginid)
			throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		return hospitalAccountService.updateAccountToExit(hosploginid);

	}

	// 修改密码
	@RequestMapping(value = "/editpassword", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改密码", httpMethod = "POST", notes = "修改密码")
	public String editPassword(
			@ApiParam(name = "hosploginphone", required = true, value = "登录号码") @RequestParam String hosploginphone,
			@ApiParam(name = "hosploginpwd", required = true, value = "密码") @RequestParam String hosploginpwd,
			@ApiParam(name = "code", required = true, value = "短信验证码") @RequestParam String code) throws Exception {
		if (StringUtils.isBlank(hosploginphone)) {
			return DataResult.error("手机号码为空");
		}
		if (StringUtils.isNotBlank(hosploginphone) && !CheckUtils.isChinaPhoneLegal(hosploginphone)) {
			return Result.error("手机号码格式错误");
		}
		if (StringUtils.isBlank(hosploginpwd)) {
			return DataResult.error("密码为空");
		}
		if (StringUtils.isBlank(code)) {
			return DataResult.error("验证码为空");
		}
		return hospitalAccountService.updatePassword(hosploginphone, hosploginpwd, code);

	}
}
