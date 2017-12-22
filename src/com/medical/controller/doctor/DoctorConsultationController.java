package com.medical.controller.doctor;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.service.iface.doctor.DoctorConsultationService;
import com.medical.utils.CheckUtils;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     DoctorConsultationController.java
 * @Description:   医生会诊管理 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午9:44:11 
 */
@RestController
@RequestMapping(value = "/doctor")
public class DoctorConsultationController {
	@Autowired
	private DoctorConsultationService doctorConsultationService;

	// 获取会诊
	@RequestMapping(value = "/listconsultation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取会诊", httpMethod = "POST", notes = "获取会诊")
	public String listConsultation(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam Integer page,
			@ApiParam(name = "type", value = "为空时获取全部,为1时获取等待医生确认的会诊请求，为2时获取等待医院确认的会诊,3为进行中的会诊,4为已完成的会诊，5为历史会诊") @RequestParam(required = false) Integer type)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (!CheckUtils.isNonzeroPositiveIntegerLegal(page)) {
			return DataResult.error("当前页为大于0的整数");
		}
		if (type != null && (type < 0 || type > 5)) {
			return DataResult.error("type值超出范围");
		}
		return doctorConsultationService.listConsultation(docloginid, type, page);

	}

	@RequestMapping(value = "/getconsultationdetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取会诊详情", httpMethod = "POST", notes = "获取会诊详情")
	public String getConsultationDetail(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "hosporderid", required = true, value = "订单id") @RequestParam Integer hosporderid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (hosporderid == null) {
			return DataResult.error("订单id为空");
		}
		return doctorConsultationService.listConsultationDetail(docloginid, hosporderid);

	}

	// 确认会诊
	@RequestMapping(value = "/confirmconsultation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "确认会诊", httpMethod = "POST", notes = "确认会诊")
	public String confirmconsultation(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "hosporderid", required = true, value = "订单id") @RequestParam Integer hosporderid,
			@ApiParam(name = "orderdoctorprice", required = true, value = "医生期望价格") @RequestParam BigDecimal orderdoctorprice,
			@ApiParam(name = "orderdoctortpricetype", required = true, value = "交通类型") @RequestParam Integer orderdoctortpricetype,
			@ApiParam(name = "orderdoctortprice", value = "交通价格") @RequestParam(required = false) BigDecimal orderdoctortprice,
			@ApiParam(name = "orderdoctorapricetype", required = true, value = "住宿类型") @RequestParam Integer orderdoctorapricetype,
			@ApiParam(name = "orderdoctoraprice", value = "住宿价格") @RequestParam(required = false) BigDecimal orderdoctoraprice,
			@ApiParam(name = "orderdoctorepricetype", required = true, value = "餐饮价格") @RequestParam Integer orderdoctorepricetype,
			@ApiParam(name = "orderdoctoreprice", value = "餐饮价格") @RequestParam(required = false) BigDecimal orderdoctoreprice)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (hosporderid == null) {
			return DataResult.error("订单id为空");
		}
		if (orderdoctorprice == null) {
			return DataResult.error("医生期望价格为空");
		}
		if (orderdoctortpricetype == null ||(orderdoctortpricetype != 1 && orderdoctortpricetype != 2)) {
			return DataResult.error("交通类型有误");
		} 
		if (orderdoctortpricetype == 2 && orderdoctortprice == null) {
			return DataResult.error("交通费用为空");
		}
		if (orderdoctorapricetype == null || (orderdoctorapricetype != 1 && orderdoctorapricetype != 2)) {
			return DataResult.error("住宿类型有误");
		} 
		if (orderdoctorapricetype == 2 && orderdoctoraprice == null) {
			return DataResult.error("住宿费用为空");
		}
		if (orderdoctorepricetype == null || (orderdoctorepricetype != 1 && orderdoctorepricetype != 2)) {
			return DataResult.error("餐饮类型有误");
		}
		if (orderdoctorepricetype == 2 && orderdoctoreprice == null) {
			return DataResult.error("餐饮费用为空");
		}
		return doctorConsultationService.updateConsultationToConfirm(docloginid, hosporderid, orderdoctorprice,
				orderdoctortpricetype, orderdoctortprice, orderdoctorapricetype, orderdoctoraprice,
				orderdoctorepricetype, orderdoctoreprice);
	}

	// 取消会诊
	@RequestMapping(value = "/cancelconsultation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消会诊", httpMethod = "POST", notes = "取消会诊")
	public String cancelconsultation(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "hosporderid", required = true, value = "订单id") @RequestParam Integer hosporderid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (hosporderid == null) {
			return DataResult.error("订单id为空");
		}
		return doctorConsultationService.updateConsultationToCancel(docloginid, hosporderid);

	}

}
