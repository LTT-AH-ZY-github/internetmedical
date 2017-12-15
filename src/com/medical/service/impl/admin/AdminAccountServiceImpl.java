/**
 * 
 */
package com.medical.service.impl.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.medical.mapper.AdminlogininfoMapperCustom;
import com.medical.po.Adminlogininfo;
import com.medical.service.iface.admin.AdminAccountService;
import com.medical.utils.result.DataResult;

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
			map.put("pic", adminlogininfo.getAdminloginpix());
			return DataResult.success("登录成功",map);
		}else {
			return DataResult.error("密码错误");
		}
	}
}
