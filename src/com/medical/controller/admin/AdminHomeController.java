/**  
* @Title: AdminHomeController.java  
* @Package com.medical.controller.admin  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2018年1月8日  
* @version V1.0  
*/  
package com.medical.controller.admin;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.service.iface.CommonService;
import com.medical.service.iface.hospital.HospitalHomeService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     AdminHomeController.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2018年1月8日 下午12:18:32 
 */
@RestController
@RequestMapping(value="/admin")
public class AdminHomeController {
	@Autowired
	private HospitalHomeService hospitalHomeService;
	@Autowired
	private CommonService commonService;
	@RequestMapping(value = "/listalldept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取部门", httpMethod = "POST", notes = "获取部门")
	public String listAllDept(
			@ApiParam(name = "hospdeptfatherid", required = true, value = "医院部门父id") @RequestParam Integer hospdeptfatherid) throws Exception{
		return hospitalHomeService.listDept(hospdeptfatherid);
	}
	@RequestMapping(value = "/listcity", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取城市", httpMethod = "POST", notes = "获取城市")
	public String listCity(
			@ApiParam(name = "cityparentcode", required = true, value = "城市父id") @RequestParam String cityparentcode) throws Exception{
		return hospitalHomeService.listCity(cityparentcode);
	}
	@RequestMapping(value = "/listhosplevel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医院等级", httpMethod = "POST", notes = "获取医院等级")
	public String listhosplevel(
			) throws Exception{
		return hospitalHomeService.listHospLevel();
	}
	@RequestMapping(value = "/listdoctortitle", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生等级", httpMethod = "POST", notes = "获取医生等级")
	public String listdoctortitle(
			) throws Exception{
		return hospitalHomeService.listDoctorTitle(); 
	}
	
	
	
}
