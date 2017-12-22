package com.medical.controller.hopital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.medical.controller.validation.Add;
import com.medical.controller.validation.Update;
import com.medical.po.Hospitalpackage;
import com.medical.service.iface.hospital.HospitalPackageService;
import com.medical.utils.CheckUtils;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     HospitalPackageController.java
 * @Description:   套餐管理 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月11日 下午8:26:01 
 */
@RestController
@RequestMapping(value = "/hospital")
public class HospitalPackageController {
	@Autowired
	private HospitalPackageService hospitalPackageService;
	
	@RequestMapping(value = "/packageset", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "新增套餐", httpMethod = "POST", notes = "新增套餐")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "packagename", value = "套餐名", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "packagenumber", value = "套餐价格", required = true, dataType = "double", paramType = "query"),
		@ApiImplicitParam(name = "packageabs", value = "套餐简介", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "hosploginid", value = "医院登录id", required = true, dataType = "int", paramType = "query")
	})
	public String packageset(@ApiIgnore @Validated(Add.class) Hospitalpackage hospitalpackage,BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			return DataResult.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return hospitalPackageService.addPackage(hospitalpackage);
    }
	
	@RequestMapping(value = "/getpackagelist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取套餐", httpMethod = "POST", notes = "获取套餐")
	public String getpackagelist(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几个数据开始") @RequestParam(value = "offset") Integer offset
			) throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		if (!CheckUtils.isNonzeroPositiveIntegerLegal(limit)) {
			return DataResult.error("limit应为非零正整数");
		}
		if (!CheckUtils.isPositiveIntegerLegal(offset)) {
			return DataResult.error("offset应为正整数");
		}
		return hospitalPackageService.listPackages(hosploginid,limit,offset);
   }
	
	@RequestMapping(value = "/editpackage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改套餐", httpMethod = "POST", notes = "修改套餐")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "packagename", value = "套餐名", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "packagenumber", value = "套餐价格", required = false, dataType = "double", paramType = "query"),
		@ApiImplicitParam(name = "packageabs", value = "套餐简介", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "hosploginid", value = "医院登录id", required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "packageid", value = "套餐id", required = true, dataType = "int", paramType = "query")
	})
	public String editpackage(@ApiIgnore @Validated(Update.class)Hospitalpackage hospitalpackage,BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			return DataResult.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return hospitalPackageService.editPackage(hospitalpackage);
   }
	
	@RequestMapping(value = "/deletepackage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除套餐", httpMethod = "POST", notes = "删除套餐")
	public String deletepackage(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "packageid", required = true, value = "套餐id") @RequestParam Integer packageid
			) throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		if (packageid == null) {
			return DataResult.error("套餐id为空");
		}
		return hospitalPackageService.deletePackage(hosploginid,packageid);
   }
}
