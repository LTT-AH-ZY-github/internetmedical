package com.medical.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.service.iface.admin.AdminCheckToFundService;
import com.medical.utils.CheckUtils;
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
	@ApiOperation(value="获取需要余额提现医生",httpMethod="POST",notes="获取需要余额提现医生")
	public String listdoctortorefund(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		if (!CheckUtils.isNonzeroPositiveIntegerLegal(limit)) {
			return DataResult.error("limit应为非零正整数");
		}
		if (!CheckUtils.isPositiveIntegerLegal(offset)) {
			return DataResult.error("offset应为正整数");
		}
		return adminCheckToFundService.listDoctorToTransfer(adminloginid, limit, offset);
	}
	
	@RequestMapping(value="/fundtodoctor", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="医生余额提现",httpMethod="POST",notes="医生余额提现")
	public String refundDoctor(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		if (docloginid==null) {
			return DataResult.error("医生登录id为空");
		}
		return adminCheckToFundService.updateTransferToDoctor(adminloginid, docloginid);
	}
	
	@RequestMapping(value="/listhospitaltofund", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取需要余额提现医院",httpMethod="POST",notes="获取需要余额提现医院")
	public String listhospitaltofund(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset
			
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		if (!CheckUtils.isNonzeroPositiveIntegerLegal(limit)) {
			return DataResult.error("limit应为非零正整数");
		}
		if (!CheckUtils.isPositiveIntegerLegal(offset)) {
			return DataResult.error("offset应为正整数");
		}
		return adminCheckToFundService.listHospitalToTransfer(adminloginid, limit, offset);
	}
	
	@RequestMapping(value="/fundtohospital", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="医院余额提现",httpMethod="POST",notes="医院余额提现")
	public String refundhosp(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "hosploginid", value = "医院登录id") @RequestParam Integer hosploginid
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		if (hosploginid==null) {
			return DataResult.error("医院登录id为空");
		}
		return adminCheckToFundService.updateTransferToHospital(adminloginid, hosploginid);
	}
	
	@RequestMapping(value="/listordertofund", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取需要结算的订单",httpMethod="POST",notes="获取需要结算的订单")
	public String listordertofund(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		if (!CheckUtils.isNonzeroPositiveIntegerLegal(limit)) {
			return DataResult.error("limit应为非零正整数");
		}
		if (!CheckUtils.isPositiveIntegerLegal(offset)) {
			return DataResult.error("offset应为正整数");
		}
		return adminCheckToFundService.listOrderToTransfer(adminloginid, limit, offset);
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
			return DataResult.error("订单id为空");
		}
		return adminCheckToFundService.updateTransferToUser(adminloginid, userorderid);
	}
	
	@RequestMapping(value="/listuserordertorefund", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取需要退款的订单",httpMethod="POST",notes="获取需要退款的订单")
	public String listordertofunduser(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset,
			@ApiParam(name = "type", required = true, value = "为0获取全部数据，为1获取用户申请的，为2获取医生申请为3为退款成功") @RequestParam Integer type
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		if (!CheckUtils.isNonzeroPositiveIntegerLegal(limit)) {
			return DataResult.error("limit应为非零正整数");
		}
		if (!CheckUtils.isPositiveIntegerLegal(offset)) {
			return DataResult.error("offset应为正整数");
		}
		if (type ==null || type<0 || type>3) {
			return DataResult.error("type值超出范围");
		}
		return adminCheckToFundService.listDoctorOrderToReFund(adminloginid, limit, offset, type);
	}
	
	@RequestMapping(value="/checkorderrefund", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="病人退款",httpMethod="POST",notes="病人退款")
	public String refundtouser(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "type", value = "是否通过审核") @RequestParam Boolean type,
			@ApiParam(name = "idea", value = "审核意见") @RequestParam String idea
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		if (userorderid==null) {
			return DataResult.error("订单id为空");
		}
		return adminCheckToFundService.updateReFundToUser(adminloginid, userorderid,type,idea);
	}
	@RequestMapping(value="/getalipayrecord", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取支付宝交易记录",httpMethod="POST",notes="获取支付宝交易记录")
	public String getAliPayRecord(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "outtradeno", value = "商户订单号") @RequestParam(required=false) String outtradeno,
			@ApiParam(name = "tradeno", value = "支付宝订单号") @RequestParam(required=false) String tradeno
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		if (StringUtils.isBlank(outtradeno) && StringUtils.isBlank(tradeno)) {
			return DataResult.error("商户单号与支付宝单号不可同时为空");
		}
		return adminCheckToFundService.getAlipayRecord(outtradeno, tradeno);
	}
	
	@RequestMapping(value="/getalipaybill", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取支付宝账单",httpMethod="POST",notes="获取支付宝账单")
	public String getAliPayBill(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "billtype", value = "账单类型，商户通过接口或商户经开放平台授权后其所属服务商通过接口可以获取以下账单类型：trade、signcustomer；trade指商户基于支付宝交易收单的业务账单；signcustomer是指基于商户支付宝余额收入及支出等资金变动的帐务账单；") @RequestParam String billtype,
			@ApiParam(name = "billdate", value = "账单时间：日账单格式为yyyy-MM-dd，月账单格式为yyyy-MM。") @RequestParam String billdate
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		if (StringUtils.isBlank(billtype)) {
			return DataResult.error("账单类型不可为空");
		}
		if (StringUtils.isBlank(billdate)) {
			return DataResult.error("账单时间不可为空");
		}
		return adminCheckToFundService.getAlipayBill(adminloginid,billtype,billdate);
	}
	
	@RequestMapping(value="/getwxpayrecord", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取微信交易记录",httpMethod="POST",notes="获取微信交易记录")
	public String getWXPayRecord(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "outtradeno", value = "商户订单号") @RequestParam(required=false) String outtradeno,
			@ApiParam(name = "tradeno", value = "微信订单号") @RequestParam(required=false) String tradeno
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		if (StringUtils.isBlank(outtradeno) && StringUtils.isBlank(tradeno)) {
			return DataResult.error("商户单号与微信单号不可同时为空");
		}
		return adminCheckToFundService.getWXpayRecord(outtradeno, tradeno);
	}
	
	@RequestMapping(value="/getwxpayrefundrecord", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取微信退款记录",httpMethod="POST",notes="获取微信退款记录")
	public String getWXPayRefundRecord(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "outtradeno", value = "商户订单号") @RequestParam(required=false) String outtradeno,
			@ApiParam(name = "tradeno", value = "微信订单号") @RequestParam(required=false) String tradeno,
			@ApiParam(name = "outrefundno", value = "商户退款单号") @RequestParam(required=false) String outrefundno,
			@ApiParam(name = "refundid", value = "微信退款单号") @RequestParam(required=false) String refundid
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员登录id为空");
		}
		if (StringUtils.isBlank(outtradeno) && StringUtils.isBlank(tradeno) && StringUtils.isBlank(outrefundno) && StringUtils.isBlank(refundid)) {
			return DataResult.error("商户订单号、微信单号、商户退款单号、微信退款单号不可同时为空");
		}
		return adminCheckToFundService.getWXpayRefundRecord(outtradeno, tradeno, outrefundno, refundid);
	}
}
