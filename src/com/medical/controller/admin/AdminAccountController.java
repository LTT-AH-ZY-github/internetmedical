package com.medical.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.service.iface.admin.AdminAccountService;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     AdminAccountController.java
 * @Description:   管理员账号管理
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月1日 下午4:19:47 
 */

@RestController
@RequestMapping(value="/admin")
public class AdminAccountController {
	@Autowired
	private AdminAccountService adminAccountService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="管理员登录",httpMethod="POST",notes="管理员登录")
	public String listdoctortorefund(
			@ApiParam(name = "adminloginname", value = "管理员登录账号") @RequestParam String adminloginname,
			@ApiParam(name = "adminloginpwd", value = "管理员登录密码") @RequestParam String adminloginpwd
			)throws Exception{
		if (StringUtils.isBlank(adminloginname)) {
			return DataResult.error("登录账号为空");
		}
		if (StringUtils.isBlank(adminloginpwd)) {
			return DataResult.error("密码为空");
		}
		return adminAccountService.updateAccountStateToLogin(adminloginname,adminloginpwd);
	}
}
