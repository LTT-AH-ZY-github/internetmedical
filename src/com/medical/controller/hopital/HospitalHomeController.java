/**
 * 
 */
package com.medical.controller.hopital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.po.Hospitalunitprice;
import com.medical.service.iface.hospital.HospitalHomeService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     HospitaHomeController.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月4日 下午8:47:58 
 */
@RestController
@RequestMapping(value = "/hospital")
public class HospitalHomeController {
	@Autowired
	private HospitalHomeService hospitalHomeService;
	@RequestMapping(value = "/listdept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取部门", httpMethod = "POST", notes = "获取部门")
	public String listDept(
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
