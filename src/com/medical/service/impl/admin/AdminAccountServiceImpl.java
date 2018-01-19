/**
 * 
 */
package com.medical.service.impl.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.AdminlogininfoMapper;
import com.medical.mapper.AdminlogininfoMapperCustom;
import com.medical.mapper.AdminmenuMapper;
import com.medical.mapper.AdminmenuMapperCustom;
import com.medical.mapper.AdminroleMapper;
import com.medical.mapper.AdminrolemenuMapper;
import com.medical.mapper.AdminrolemenuMapperCustom;
import com.medical.po.Adminlogininfo;
import com.medical.po.Adminmenu;
import com.medical.po.Adminrole;
import com.medical.service.iface.admin.AdminAccountService;
import com.medical.utils.result.DataResult;
import com.sun.glass.ui.Robot;

/**
 * @ClassName:     AdminAccountServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月1日 下午4:21:16 
 */
public class AdminAccountServiceImpl implements AdminAccountService {
	@Autowired
	private AdminlogininfoMapperCustom  adminlogininfoMapperCustom;
	@Autowired
	private AdminlogininfoMapper  adminlogininfoMapper;
	@Autowired
	private AdminmenuMapperCustom adminmenuMapperCustom;
	@Autowired
	private AdminrolemenuMapperCustom adminrolemenuMapperCustom;
	@Autowired
	private AdminroleMapper adminroleMapper;
	@Override
	public String updateAccountStateToLogin(String adminloginname, String adminloginpwd) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapperCustom.selectByAdminLoginName(adminloginname);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		String pwd = adminlogininfo.getAdminloginpwd();
		if (pwd.equals(adminloginpwd)) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", adminlogininfo.getAdminloginid());
			map.put("adminloginpix", adminlogininfo.getAdminloginpix());
			return DataResult.success("登录成功",map);
		}else {
			return DataResult.error("密码错误");
		}
	}

	/**
	 * 
	 */
	@Override
	public String addAdminAccount(Integer adminloginid, String adminloginname, String adminloginpwd) {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Adminlogininfo record = new Adminlogininfo();
		record.setAdminloginname(adminloginname);
		record.setAdminloginpwd(adminloginpwd);
		record.setRegistrationtime(new Date());
		boolean result = adminlogininfoMapper.insertSelective(record)>0;
		if (result) {
			return DataResult.success("注册成功");	
		}else {
			return DataResult.error("注册失败");	
		}
		
	}
	
	@Override
	public String updateAdminAccountRole(Integer adminloginid, Integer lowadminloginid, Integer roleid) {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Adminlogininfo record = new Adminlogininfo();
		record.setAdminloginid(lowadminloginid);
		record.setRoleid(roleid);
		boolean result = adminlogininfoMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("更新成功");	
		}else {
			return DataResult.error("更新失败");	
		}
		
	}

	/**
	 * 
	 */
	@Override
	public String getMenu(Integer adminloginid) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		int roleid = adminlogininfo.getRoleid();
		if (roleid==-1) {
			return null; 
		}else if (roleid==0) {
			 Map<String, Object> map = new HashMap<>();
			 List<Adminmenu> list =  adminmenuMapperCustom.selectByParams(map);
			 return DataResult.success("获取成功", list);
		}else {
			Map<String, Object> map = new HashMap<>();
			map.put("roleid", roleid);
			List<Map<String, Object>> list =  adminrolemenuMapperCustom.selectAllInfoByParams(map);
			return DataResult.success("获取成功", list);
		}
	}

	/**
	 * 
	 */
	@Override
	public String listAdminAccount(Integer adminloginid,Integer limit,Integer offset) throws Exception {
		Adminlogininfo admin = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (admin==null) {
			return DataResult.error("账号不存在");
		}
		
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		
		Map<String, Object> map = new HashMap<>();
		List<Adminlogininfo> adminlist = adminlogininfoMapperCustom.selectByParams(map);
		PageInfo<Adminlogininfo> pageInfo = new PageInfo<Adminlogininfo>(adminlist);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> finishData = new HashMap<String, Object>();
			List<Adminlogininfo> list = pageInfo.getList();
			if (list!=null && list.size()>0) {
				List<Map<String, Object>> datalist = new ArrayList<>();
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					Adminlogininfo adminlogininfo = (Adminlogininfo) iterator.next();
					Map<String, Object> data = new HashMap<>();
					data.put("adminloginid",adminlogininfo.getAdminloginid());
					data.put("adminloginname",adminlogininfo.getAdminloginid());
					data.put("adminloginpix",adminlogininfo.getAdminloginid());
					data.put("adminloginname",adminlogininfo.getAdminloginid());
					data.put("adminloginid",adminlogininfo.getAdminloginid());
					data.put("registrationtime",adminlogininfo.getAdminloginid());
					Date date = adminlogininfo.getAdminlogintime();
					if (date==null) {
						date=null;
					}
					data.put("adminlogintime",date);
					int roleid = adminlogininfo.getRoleid();
					data.put("roleid",roleid);
					if (roleid>0) {
						Adminrole adminrole= adminroleMapper.selectByPrimaryKey(roleid);
						if (adminrole!=null) {
							data.put("rolename",adminrole.getRolename());
						}else {
							data.put("rolename","");
						}
					}else {
						data.put("rolename","");
					}
					datalist.add(data);
					
				}
				finishData.put("rows", datalist);
				// 总共页数
				finishData.put("total", pageInfo.getTotal());
				return DataResult.success("获取成功", finishData);
			}
			return DataResult.success("获取成功", null);
		} else {
			return DataResult.success("获取成功", null);
		}
		}
}
