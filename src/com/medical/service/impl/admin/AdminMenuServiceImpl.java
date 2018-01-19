/**  
* @Title: AdminMenuServiceImpl.java  
* @Package com.medical.service.impl.admin  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2018年1月15日  
* @version V1.0  
*/  
package com.medical.service.impl.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Null;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.AdminlogininfoMapper;
import com.medical.mapper.AdminlogininfoMapperCustom;
import com.medical.mapper.AdminmenuMapper;
import com.medical.mapper.AdminmenuMapperCustom;
import com.medical.mapper.AdminroleMapper;
import com.medical.mapper.AdminroleMapperCustom;
import com.medical.mapper.AdminrolemenuMapper;
import com.medical.mapper.AdminrolemenuMapperCustom;
import com.medical.po.Adminlogininfo;
import com.medical.po.Adminmenu;
import com.medical.po.Adminrole;
import com.medical.po.AdminroleExample;
import com.medical.po.Adminrolemenu;
import com.medical.po.Hospitaldept;

import com.medical.service.iface.admin.AdminMenuService;
import com.medical.utils.result.DataResult;

/**
 * @ClassName:     AdminMenuServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2018年1月15日 下午9:32:11 
 */
public class AdminMenuServiceImpl implements AdminMenuService{
	@Autowired
	private AdminlogininfoMapperCustom  adminlogininfoMapperCustom;
	@Autowired
	private AdminlogininfoMapper adminlogininfoMapper;
	@Autowired
	private AdminmenuMapper adminmenuMapper;
	@Autowired
	private AdminmenuMapperCustom adminmenuMapperCustom;
	@Autowired 
	private AdminroleMapper adminroleMapper;
	@Autowired 
	private AdminroleMapperCustom adminroleMapperCustom;
	@Autowired 
	private AdminrolemenuMapper adminrolemenuMapper;
	@Autowired 
	private AdminrolemenuMapperCustom adminrolemenuMapperCustom;
	
	@Override
	public String addAdminRole(Integer adminloginid,String rolename,String roledescription ) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Adminrole adminrole = new Adminrole();
		adminrole.setRolename(rolename);
		adminrole.setRoledescription(roledescription);
		boolean result = adminroleMapper.insertSelective(adminrole)>0;
		if (result) {
			return DataResult.success("新增成功");
		}else {
			return DataResult.error("新增失败");
		}
	}
	@Override
	public String deleteAdminRole(Integer adminloginid,Integer roleid) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Adminrole adminrole = adminroleMapper.selectByPrimaryKey(roleid);
		if (adminrole==null) {
			return DataResult.error("该角色不存在");
		}
		boolean result = adminroleMapper.deleteByPrimaryKey(roleid)>0;
		if (result) {
			return DataResult.success("删除成功");
		}else {
			return DataResult.error("删除失败");
		}
	}
	@Override
	public String updateAdminRole(Integer adminloginid,Integer roleid ,String rolename,String roledescription) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Adminrole adminrole = adminroleMapper.selectByPrimaryKey(roleid);
		if (adminrole==null) {
			return DataResult.error("该角色不存在");
		}
		Adminrole record = new Adminrole();
		record.setRoleid(roleid);
		record.setRolename(rolename);
		record.setRoledescription(roledescription);
		boolean result = adminroleMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("修改成功");
		}else {
			return DataResult.error("修改失败");
		}
	}
	@Override
	public String listAdminRole(Integer adminloginid,Integer limit,Integer offset) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Adminrole> list = adminroleMapperCustom.selectAll();
		PageInfo<Adminrole> pageInfo = new PageInfo<Adminrole>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			// 总共页数
			data.put("total", pageInfo.getTotal());
			return DataResult.success("获取成功", data);
		} else {
			return DataResult.success("获取成功", null);
		}
	}
	
	@Override
	public String listAdminRole(Integer adminloginid) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		List<Adminrole> list = adminroleMapperCustom.selectAll();
		return DataResult.success("获取成功", list);
	}
	@Override
	public String addAdminMenu(Integer adminloginid,Integer menufatherid, String menuname,String menuurl ) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Adminmenu adminmenu = new Adminmenu();
		adminmenu.setMenufatherid(menufatherid);
		adminmenu.setMenuname(menuname);
		adminmenu.setMenuurl(menuurl);
		boolean result = adminmenuMapper.insertSelective(adminmenu)>0;
		if (result) {
			return DataResult.success("新增成功");
		}else {
			return DataResult.error("新增失败");
		}
	}
	@Override
	public String deleteAdminMenu(Integer adminloginid,Integer menuid) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Adminmenu adminmenu = adminmenuMapper.selectByPrimaryKey(menuid);
		if (adminmenu==null) {
			return DataResult.error("该菜单不存在");
		}
		boolean result = adminmenuMapper.deleteByPrimaryKey(menuid)>0;
		if (result) {
			return DataResult.success("删除成功");
		}else {
			return DataResult.error("删除失败");
		}
	}
	@Override
	public String updateAdminMenu(Integer adminloginid,Integer menuid ,Integer menufatherid, String menuname,String menuurl ) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Adminmenu adminmenu = adminmenuMapper.selectByPrimaryKey(menuid);
		if (adminmenu==null) {
			return DataResult.error("该菜单不存在");
		}
		Adminmenu record = new Adminmenu();
		record.setMenuid(menuid);
		record.setMenufatherid(menufatherid);
		record.setMenuname(menuname);
		record.setMenuurl(menuurl);
		boolean result = adminmenuMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("修改成功");
		}else {
			return DataResult.error("修改失败");
		}
	}
	@Override
	public String listAdminMenu(Integer adminloginid,Integer limit,Integer offset,Integer menufatherid) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		Map<String, Object> map = new HashMap<>();
		map.put("menufatherid", menufatherid);
		List<Adminmenu> list = adminmenuMapperCustom.selectByParams(map);
		PageInfo<Adminmenu> pageInfo = new PageInfo<Adminmenu>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			// 总共页数
			data.put("total", pageInfo.getTotal());
			return DataResult.success("获取成功", data);
		} else {
			return DataResult.success("获取成功", null);
		}
	}
	
	@Override
	public String getAdminMenu(Integer adminloginid, Integer menufatherid) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("menufatherid", menufatherid);
		List<Adminmenu> list = adminmenuMapperCustom.selectByParams(map);
		return DataResult.success("获取成功", list);
		
	}
	
	@Override
	public String addAdminRoleMenu(Integer adminloginid,Integer menuid,Integer roleid) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Adminmenu adminmenu = adminmenuMapper.selectByPrimaryKey(menuid);
		if (adminmenu==null) {
			return DataResult.error("该菜单不存在");
		}
		Adminrole adminrole = adminroleMapper.selectByPrimaryKey(roleid);
		if (adminrole==null) {
			return DataResult.error("该角色不存在");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("menuid", menuid);
		map.put("roleid", roleid);
		List<Adminrolemenu> list = adminrolemenuMapperCustom.selectByParams(map);
		if (list!=null && list.size()>0) {
			return DataResult.error("该角色菜单已添加");
		}
		Adminrolemenu adminrolemenu = new Adminrolemenu();
		adminrolemenu.setMenuid(menuid);
		adminrolemenu.setRoleid(roleid);
		boolean result = adminrolemenuMapper.insertSelective(adminrolemenu)>0;
		if (result) {
			return DataResult.success("新增成功");
		}else {
			return DataResult.error("新增失败");
		}
	}
	@Override
	public String deleteAdminRoleMenu(Integer adminloginid,Integer rolemenuid) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Adminrolemenu adminrolemenu = adminrolemenuMapper.selectByPrimaryKey(rolemenuid);
		if (adminrolemenu==null) {
			return DataResult.error("该角色菜单不存在");
		}
		boolean result = adminrolemenuMapper.deleteByPrimaryKey(rolemenuid)>0;
		if (result) {
			return DataResult.success("修改成功");
		}else {
			return DataResult.error("修改失败");
		}
	}
	@Override
	public String updateAdminRoleMenu(Integer adminloginid,Integer rolemenuid,Integer menuid,Integer roleid) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Adminrolemenu adminrolemenu = adminrolemenuMapper.selectByPrimaryKey(rolemenuid);
		if (adminrolemenu==null) {
			return DataResult.error("该角色菜单不存在");
		}
		if (menuid!=null) {
			Adminmenu adminmenu = adminmenuMapper.selectByPrimaryKey(menuid);
			if (adminmenu==null) {
				return DataResult.error("该菜单不存在");
			}
		}
		if (roleid!=null) {
			Adminrole adminrole = adminroleMapper.selectByPrimaryKey(roleid);
			if (adminrole==null) {
				return DataResult.error("该角色不存在");
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("menuid", menuid);
		map.put("roleid", roleid);
		List<Adminrolemenu> list = adminrolemenuMapperCustom.selectByParams(map);
//		if (list!=null && list.size()>0) {
//			return DataResult.error("该角色菜单已添加");
//		}
		Adminrolemenu record = new Adminrolemenu();
		record.setRolemenuid(rolemenuid);
		record.setMenuid(menuid);
		record.setRoleid(roleid);
		boolean result = adminrolemenuMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("修改成功");
		}else {
			return DataResult.error("修改失败");
		}
	}
	@Override
	public String listAdminRoleMenu(Integer adminloginid,Integer roleid,Integer limit,Integer offset) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		Map<String, Object> map = new HashMap<>();
		if (roleid==0) {
			roleid=null;
		}
		map.put("roleid", roleid);
		List<Map<String, Object>> list = adminrolemenuMapperCustom.selectAllInfoByParams(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			// 总共页数
			data.put("total", pageInfo.getTotal());
			return DataResult.success("获取成功", data);
		} else {
			return DataResult.success("获取成功", null);
		}
	}
	/**
	 * 
	 */
	@Override
	public String listAdminRoleMenu(Integer adminloginid, Integer roleid) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Map<String, Object> map = new HashMap<>();
		if (roleid==0) {
			roleid=null;
		}
		map.put("roleid", roleid);
		List<Map<String, Object>> list = adminrolemenuMapperCustom.selectAllInfoByParams(map);
		return DataResult.success("获取成功", list);
	}
	
	
	
	
}
