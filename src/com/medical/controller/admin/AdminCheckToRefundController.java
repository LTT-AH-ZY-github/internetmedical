/**
 * 
 */
package com.medical.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     AdminCheckToRefundController.java
 * @Description:   审核退款
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月1日 下午4:32:28 
 */
public class AdminCheckToRefundController {
	
	
	@RequestMapping(value="/listdoctortorefund", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取医生",httpMethod="POST",notes="获取用户")
	public String listdoctortorefund(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset,
			@ApiParam(name = "type", value = "为空时获取全部医生，为1时获取未审核的医生，为2时获取待审核的医生，为3时获取审核通过的医生，为4时获取未通过审核的医生") @RequestParam(required=false) Integer type
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return null;
	}
	
	@RequestMapping(value="/refunddoctor", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="",httpMethod="POST",notes="获取用户")
	public String refundDoctor(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		if (docloginid==null) {
			return DataResult.error("医生登录id");
		}
		return null;
	}
}
