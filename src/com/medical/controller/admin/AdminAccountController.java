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
	@RequestMapping(value="/getmenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="管理员登录时获取菜单",httpMethod="POST",notes="管理员登录时获取菜单")
	public String getmenu(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminAccountService.getMenu(adminloginid);
	}
	@RequestMapping(value="/listadminaccount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取管理员账号",httpMethod="POST",notes="获取管理员账号")
	public String listadminaccount(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", value = "每页多少个") @RequestParam Integer limit,
			@ApiParam(name = "offset", value = "第几个开始") @RequestParam Integer offset
			)throws Exception{
		
		return adminAccountService.listAdminAccount(adminloginid, limit, offset);
	}
	@RequestMapping(value="/addadminaccount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="管理员登录",httpMethod="POST",notes="管理员登录")
	public String adadminaccount(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "adminloginname", value = "管理员登录账号") @RequestParam String adminloginname,
			@ApiParam(name = "adminloginpwd", value = "管理员登录密码") @RequestParam String adminloginpwd
			)throws Exception{
		if (StringUtils.isBlank(adminloginname)) {
			return DataResult.error("登录账号为空");
		}
		if (StringUtils.isBlank(adminloginpwd)) {
			return DataResult.error("密码为空");
		}
		return adminAccountService.addAdminAccount(adminloginid,adminloginname,adminloginpwd);
	}
	
	@RequestMapping(value="/updateadminaccountrole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="修改管理员角色",httpMethod="POST",notes="修改管理员角色")
	public String updateadminaccountrole(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "lowadminloginid", value = "被设置管理员id") @RequestParam Integer lowadminloginid,
			@ApiParam(name = "roleid", value = "角色id") @RequestParam Integer roleid
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		if (lowadminloginid==null) {
			return DataResult.error("被设置管理员id为空");
		}
		if (roleid==null) {
			return DataResult.error("角色id为空");
		}
		return adminAccountService.updateAdminAccountRole(adminloginid, lowadminloginid, roleid);
	}
}
