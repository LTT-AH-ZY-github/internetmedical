/**  
* @Title: HospitalBerthController.java  
* @Package com.medical.controller.hopital  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月11日  
* @version V1.0  
*/
package com.medical.controller.hopital;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.medical.controller.validation.Add;
import com.medical.po.Hospitalberth;
import com.medical.service.iface.hospital.HospitalBerthService;
import com.medical.utils.CheckUtils;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.Result;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName: HospitalBerthController.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xyh
 * @version V1.0
 * @Date 2017年12月11日 下午7:18:34
 */
@RestController
@RequestMapping(value = "/hospital")
public class HospitalBerthController {
	@Autowired
	private HospitalBerthService hospitalBerthService;

	@RequestMapping(value = "/myhospdeptinit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医院床位数", httpMethod = "POST", notes = "获取医院床位数")
	public String myhospdeptinit(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid) throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		return hospitalBerthService.getBerthNum(hosploginid);
    }
	
	@RequestMapping(value = "/gethospitalberth", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取各个部门床位数", httpMethod = "POST", notes = "获取各个部门床位数")
	public String gethospitalberth(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "hospberthdeptid", required = true, value = "部门id") @RequestParam Integer hospberthdeptid
			) throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		if (hospberthdeptid == null) {
			return DataResult.error("部门id为空");
		}
		return hospitalBerthService.getOneBerthNum(hosploginid,hospberthdeptid);
   }
	
	@RequestMapping(value = "/addhospberth", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "增加床位", httpMethod = "POST", notes = "增加床位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "hospberthname", value = "床位名称", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "hospberthabs", value = "床位简介", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "hospberthdeptid", value = "部门id", required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "hosploginid", value = "医院登录id", required = true, dataType = "int", paramType = "query")
	})
	public String addhospberth(@ApiIgnore @Validated(Add.class)Hospitalberth hospitalberth,BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			return DataResult.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return hospitalBerthService.addHospBerth(hospitalberth);
   }
	
	@RequestMapping(value = "/deletehospberth", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除床位", httpMethod = "POST", notes = "删除床位")
	public String deletehospberth(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "hospberthid", required = true, value = "床位id") @RequestParam Integer hospberthid
			) throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		if (hospberthid == null) {
			return DataResult.error("床位d为空");
		}
		return hospitalBerthService.deleteHospBerth(hosploginid,hospberthid);
   }
}
