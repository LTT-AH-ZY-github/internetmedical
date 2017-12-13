/**
 * 
 */
package com.medical.controller.hopital;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medical.service.iface.hospital.HospitalOrderService;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName: HospitalOrderController.java
 * @Description: 病人订单管理
 * @author xyh
 * @version V1.0
 * @Date 2017年11月27日 下午3:02:52
 */
@RestController
@RequestMapping(value = "/hospital")
public class HospitalOrderController {
	@Autowired
	private HospitalOrderService hospitalOrderService;

	// 医院获取需要住院的病人订单
	@RequestMapping(value = "/listuserorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医院获取需要住院的病人订单", httpMethod = "POST", notes = "医院获取需要住院的病人订单")
	public @ResponseBody String listUserOrder(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "type", value = "为空时获取全部订单，为1时获取等待医院确认的订单，为2时为等待用户缴纳押金的订单，3为已缴纳医院押金,等待住院，4住院完成，等待费用结算，5为订单完成") @RequestParam(required = false) Integer type,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "每页多少数据") @RequestParam(value = "offset") Integer offset)
			throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院id为空");
		}
		if (limit == null) {
			return DataResult.error("当前页为空");
		}
		return hospitalOrderService.listUserOrder(hosploginid, type, limit, offset);
	}
	
	@RequestMapping(value = "/checkberthempty", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医院获取需要住院的病人订单", httpMethod = "POST", notes = "医院获取需要住院的病人订单")
	public @ResponseBody String checkberthempty(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "userorderhospprimarydept", value = "一级部门") @RequestParam String userorderhospprimarydept,
			@ApiParam(name = "userorderhospseconddept",  value = "二级部门") @RequestParam(required = false) String userorderhospseconddept
			)
			throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院id为空");
		}
		if (StringUtils.isBlank(userorderhospprimarydept)) {
			return DataResult.error("一级部门为空");
		}
		return hospitalOrderService.getHospBerthNum(hosploginid, userorderhospprimarydept, userorderhospseconddept);
	}
	// 医院确认需要住院的病人订单
	@RequestMapping(value = "/confirmuserorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医院确认需要住院的病人订单", httpMethod = "POST", notes = "医院确认需要住院的病人订单")
	public @ResponseBody String confirmUserOrder(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "userorderdeposit", required = true, value = "押金") @RequestParam Double userorderdeposit,
			@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userorderhospprimarydept", value = "一级部门") @RequestParam(required = false) String userorderhospprimarydept,
			@ApiParam(name = "userorderhospseconddept", value = "二级部门") @RequestParam(required = false) String userorderhospseconddept

	) throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		if (userorderdeposit == null) {
			return DataResult.error("押金为空");
		}
		return hospitalOrderService.confirmUserOrder(hosploginid, userorderid, userorderdeposit,
				userorderhospprimarydept, userorderhospseconddept);
	}

	// 医院取消订单
	@RequestMapping(value = "/refuseuserorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医院取消订单", httpMethod = "POST", notes = "医院取消订单")
	public @ResponseBody String refuseUserOrder(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid) throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登陆id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		return hospitalOrderService.refuseUserOrder(hosploginid, userorderid);
	}

	// 增加押金
	@RequestMapping(value = "/adddeposit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "增加押金", httpMethod = "POST", notes = "增加押金")
	public @ResponseBody String addDeposit(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userorderdeposit", required = true, value = "押金") @RequestParam BigDecimal userorderdeposit)
			throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登陆id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		if (userorderdeposit == null) {
			return DataResult.error("押金为空");
		}
		return hospitalOrderService.updateUserOrderDeposit(hosploginid, userorderid, userorderdeposit);
	}

	// 住院完成，结算费用
	@RequestMapping(value = "/settleuserorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "住院完成，结算费用", httpMethod = "POST", notes = "住院完成，结算费用")
	public @ResponseBody String settleUserOrder(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userorderhprice", value = "实际产生的费用") @RequestParam BigDecimal userorderhprice
			) throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登陆id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}

		return hospitalOrderService.updateUserOrderToSettle(hosploginid, userorderid, userorderhprice);
	}

}
