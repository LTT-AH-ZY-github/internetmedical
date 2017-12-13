/**
 * 
 */
package com.medical.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.service.iface.admin.AdminCheckToFundService;
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
@RequestMapping(value="/admin")
@RestController
public class AdminCheckToFundController {
	@Autowired
	private AdminCheckToFundService adminCheckToFundService;
	
	
	@RequestMapping(value="/listdoctortofund", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取需要提现医生",httpMethod="POST",notes="获取需要提现医生")
	public String listdoctortorefund(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset
			
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminCheckToFundService.listDoctorsToFund(adminloginid,limit,offset);
	}
	
	@RequestMapping(value="/fundtodoctor", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="医生提现",httpMethod="POST",notes="医生提现")
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
		return adminCheckToFundService.updateFundToDoctor(adminloginid,docloginid);
	}
	@RequestMapping(value="/listhospitaltofund", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取需要提现医院",httpMethod="POST",notes="获取需要提现医院")
	public String listhospitaltofund(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset
			
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminCheckToFundService.listhospitalsToFund(adminloginid,limit,offset);
	}
	
	@RequestMapping(value="/fundtohospital", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="医生提现",httpMethod="POST",notes="医生提现")
	public String refundhosp(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "hosploginid", value = "医院登录id") @RequestParam Integer hosploginid
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		if (hosploginid==null) {
			return DataResult.error("医院登录id");
		}
		return adminCheckToFundService.updateFundToHospital(adminloginid, hosploginid);
	}
	@RequestMapping(value="/listordertofund", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取需要退款的订单",httpMethod="POST",notes="病人退款")
	public String listordertofund(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		
		return adminCheckToFundService.listOrderToFund(adminloginid,limit,offset);
	}
	@RequestMapping(value="/fundtouser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="病人退款",httpMethod="POST",notes="病人退款")
	public String fundtouser(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		if (userorderid==null) {
			return DataResult.error("订单id");
		}
		return adminCheckToFundService.updateFundToUser(adminloginid, userorderid);
	}
	
}
