/**  
* @Title: AminMenuController.java  
* @Package com.medical.controller.admin  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2018年1月15日  
* @version V1.0  
*/  
package com.medical.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.medical.service.iface.admin.AdminMenuService;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     AminMenuController.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2018年1月15日 下午9:29:57 
 */
@RestController
@RequestMapping(value="/admin")
public class AdminMenuController {
	
	@Autowired
	private AdminMenuService adminMenuService;
	
	@RequestMapping(value = "/addadminrole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "增加管理员角色", httpMethod = "POST", notes = "增加管理员角色")
	public String addrole(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "rolename", value = "角色名称") @RequestParam String rolename,
			@ApiParam(name = "roledescription", value = "角色描述") @RequestParam String roledescription
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		if (StringUtils.isBlank(rolename)) {
			return DataResult.error("目录为空");
		}
		return adminMenuService.addAdminRole(adminloginid, rolename, roledescription);
	}
	
	@RequestMapping(value = "/deleteadminrole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除管理员角色", httpMethod = "POST", notes = "删除管理员角色")
	public String deleteadminrole(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "roleid", value = "角色id") @RequestParam Integer roleid
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		
		return adminMenuService.deleteAdminRole(adminloginid, roleid);
	}
	
	@RequestMapping(value = "/updateadminrole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新管理员角色", httpMethod = "POST", notes = "更新管理员角色")
	public String updateAdminRole(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "roleid", value = "角色id") @RequestParam Integer roleid,
			@ApiParam(name = "rolename", value = "角色名称") @RequestParam(required=false) String rolename,
			@ApiParam(name = "roledescription", value = "角色描述") @RequestParam(required=false) String roledescription
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		if (StringUtils.isBlank(rolename)) {
			return DataResult.error("目录为空");
		}
		return adminMenuService.updateAdminRole(adminloginid, roleid, rolename, roledescription);
	}
	
	@RequestMapping(value = "/listadminrole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取管理员角色", httpMethod = "POST", notes = "获取管理员角色")
	public String listAdminRole(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", value = "每页多少个") @RequestParam Integer limit,
			@ApiParam(name = "offset", value = "第几个开始") @RequestParam Integer offset
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminMenuService.listAdminRole(adminloginid, limit, offset);
	}
	
	@RequestMapping(value = "/listalladminrole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取管理员角色", httpMethod = "POST", notes = "获取管理员角色")
	public String listAllAdminRole(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminMenuService.listAdminRole(adminloginid);
	}
	
	@RequestMapping(value = "/addadminmenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "增加菜单", httpMethod = "POST", notes = "增加菜单")
	public String addAdminMenu(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "menufatherid", value = "父id") @RequestParam Integer menufatherid,
			@ApiParam(name = "menuname", value = "菜单名称") @RequestParam String menuname,
			@ApiParam(name = "menuurl", value = "菜单url") @RequestParam String menuurl
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminMenuService.addAdminMenu(adminloginid, menufatherid, menuname, menuurl);
	}
	
	@RequestMapping(value = "/deleteadminmenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除菜单", httpMethod = "POST", notes = "删除菜单")
	public String deleteAdminMenu(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "menuid", value = "菜单id") @RequestParam Integer menuid
			
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminMenuService.deleteAdminMenu(adminloginid, menuid);
	}
	
	@RequestMapping(value = "/updateadminmenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "增加菜单", httpMethod = "POST", notes = "增加菜单")
	public String updateAdminMenu(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "menuid", value = "菜单id") @RequestParam Integer menuid,
			@ApiParam(name = "menufatherid", value = "父id") @RequestParam(required=false)  Integer menufatherid,
			@ApiParam(name = "menuname", value = "菜单名称") @RequestParam(required=false)  String menuname,
			@ApiParam(name = "menuurl", value = "菜单url") @RequestParam(required=false)  String menuurl
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminMenuService.updateAdminMenu(adminloginid, menuid, menufatherid, menuname, menuurl);
	}
	
	@RequestMapping(value = "/listadminmenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取菜单", httpMethod = "POST", notes = "获取菜单")
	public String listAdminMenu(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", value = "每页多少个") @RequestParam Integer limit,
			@ApiParam(name = "offset", value = "第几个开始") @RequestParam Integer offset,
			@ApiParam(name = "menufatherid", value = "为-1时获取全部数据，为0时获取一级菜单，为其他获取二级菜单") @RequestParam Integer menufatherid
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminMenuService.listAdminMenu(adminloginid, limit, offset,menufatherid);
	}
	@RequestMapping(value = "/getadminmenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取菜单", httpMethod = "POST", notes = "获取菜单")
	public String getAdminMenu(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "menufatherid", value = "为-1时获取全部数据，为0时获取一级菜单，为其他获取二级菜单") @RequestParam Integer menufatherid
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminMenuService.getAdminMenu(adminloginid,menufatherid);
	}
	@RequestMapping(value = "/addadminrolemenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "增加角色菜单", httpMethod = "POST", notes = "增加角色菜单")
	public String addAdminRoleMenu(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "menuid", value = "菜单id") @RequestParam Integer menuid,
			@ApiParam(name = "roleid", value = "角色id") @RequestParam  Integer roleid
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminMenuService.addAdminRoleMenu(adminloginid, menuid, roleid);
	}
	@RequestMapping(value = "/deleteadminrolemenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除角色菜单", httpMethod = "POST", notes = "删除角色菜单")
	public String deleteAdminRoleMenu(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "rolemenuid", value = "角色菜单id") @RequestParam Integer rolemenuid
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminMenuService.deleteAdminRoleMenu(adminloginid, rolemenuid);
	}
	
	@RequestMapping(value = "/updateadminrolemenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改角色菜单", httpMethod = "POST", notes = "修改角色菜单")
	public String updateAdminRoleMenu(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "rolemenuid", value = "角色菜单id") @RequestParam Integer rolemenuid,
			@ApiParam(name = "menuid", value = "菜单id") @RequestParam(required=false)  Integer menuid,
			@ApiParam(name = "roleid", value = "角色id") @RequestParam(required=false)  Integer roleid
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminMenuService.updateAdminRoleMenu(adminloginid, rolemenuid, menuid, roleid);
	}
	
	@RequestMapping(value = "/listadminrolemenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取菜单", httpMethod = "POST", notes = "获取菜单")
	public String listAdminRoleMenu(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", value = "每页多少个") @RequestParam Integer limit,
			@ApiParam(name = "offset", value = "第几个开始") @RequestParam Integer offset,
			@ApiParam(name = "roleid", value = "为0时获取全部数据") @RequestParam Integer roleid
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminMenuService.listAdminRoleMenu(adminloginid, roleid, limit, offset);
	}
	
	@RequestMapping(value = "/listalladminrolemenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取菜单", httpMethod = "POST", notes = "获取菜单")
	public String listAllAdminRoleMenu(
			@ApiParam(name = "adminloginid", value = "管理员登录账号") @RequestParam Integer adminloginid,
			@ApiParam(name = "roleid", value = "为0时获取全部数据") @RequestParam Integer roleid
			) throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminMenuService.listAdminRoleMenu(adminloginid, roleid);
	}
	
	
}
