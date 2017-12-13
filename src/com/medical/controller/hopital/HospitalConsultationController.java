package com.medical.controller.hopital;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medical.po.HospSearchDocTerm;
import com.medical.service.iface.hospital.HospitalConsultationService;
import com.medical.utils.CheckUtils;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @ClassName: HospitalConsultationController.java
 * @Description: 会诊管理
 * @author xyh
 * @version V1.0
 * @Date 2017年11月27日 下午3:14:24
 */
@RestController
@RequestMapping(value = "/hospital")
public class HospitalConsultationController {
	@Autowired
	private HospitalConsultationService hospitalConsultationService;

	@RequestMapping(value = "/listdoctor", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医院根据条件获取医生", httpMethod = "POST", notes = "医院根据条件获取医生", responseContainer = "Map", consumes = "multipart/form-data", produces = "application/json")
	@ApiResponses({ @ApiResponse(code = 400, message = "Invalid Order") })
	public String listDoctor(
			@ApiParam(name = "hosploginid", required = true, value = "用户名") @RequestParam(value = "hosploginid") Integer hosploginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page,
			@ApiParam(name = "hosplevel", required = false, value = "医院等级value") @RequestParam(value = "hosplevel", required = false) String hosplevel,
			@ApiParam(name = "doctortitle", required = false, value = "医生职称value") @RequestParam(value = "doctortitle", required = false) String doctortitle,
			@ApiParam(name = "details", required = false, value = "描述") @RequestParam(value = "details", required = false) String details,
			@ApiParam(name = "province_code", required = false, value = "省key") @RequestParam(required = false) Integer province_code,
			@ApiParam(name = "city_code", required = false, value = "市key") @RequestParam( required = false) Integer city_code,
			@ApiParam(name = "area_code", required = false, value = "区县key") @RequestParam(required = false) Integer area_code,
			@ApiParam(name = "One_level_dept", required = false, value = "一级部门key") @RequestParam( required = false) Integer One_level_dept,
			@ApiParam(name = "Two_level_dept", required = false, value = "二级部门key") @RequestParam( required = false) Integer Two_level_dept
			)
			throws Exception {

		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		if (page == null) {
			return DataResult.error("当前页为空");
		}
		if (StringUtils.isBlank(hosplevel)) {
			hosplevel=null;
		}
		if (StringUtils.isBlank(doctortitle)) {
			doctortitle=null;
		}
		if (province_code!=null && province_code==0) {
			province_code=null;
		}
		if (city_code!=null && city_code==0) {
			city_code=null;
		}
		if (area_code!=null && area_code==0) {
			area_code=null;
		}
		if (One_level_dept!=null && One_level_dept==0) {
			One_level_dept=null;
		}
		if (Two_level_dept!=null && Two_level_dept==0) {
			Two_level_dept=null;
		}
		Integer pageSize = 6;
		HospSearchDocTerm hospSearchDocTerm = new HospSearchDocTerm();
		hospSearchDocTerm.setArea_code(area_code);
		hospSearchDocTerm.setCity_code(city_code);
		hospSearchDocTerm.setDetails(details);
		hospSearchDocTerm.setDoctorTitle(doctortitle);
		hospSearchDocTerm.setHospLevel(hosplevel);
		hospSearchDocTerm.setOne_level_dept(One_level_dept);
		hospSearchDocTerm.setProvince_code(province_code);
		hospSearchDocTerm.setTwo_level_dept(Two_level_dept);
		return hospitalConsultationService.listDoctor(page, pageSize,province_code,city_code,area_code,details,doctortitle,hosplevel,One_level_dept,Two_level_dept);

	}
	@RequestMapping(value = "/getcalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生当天后30天内日程", httpMethod = "POST", notes = "获取医生当天后30天内日程", produces = "application/json")
	public String getCalendarbymonth(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid

	) throws Exception {
		return hospitalConsultationService.listCalendar(docloginid);
	}
	// 创建会诊
	@RequestMapping(value = "/PreOrderRequest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "创建会诊", httpMethod = "POST", notes = "创建会诊")
	public String PreOrderRequest(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "orderstime", required = true, value = "预约医生时间") @RequestParam String orderstime,
			@ApiParam(name = "orderabs", required = true, value = "情况描述") @RequestParam String orderabs,
			@ApiParam(name = "orderhospprice", required = true, value = "会诊价格") @RequestParam BigDecimal orderhospprice,
			@ApiParam(name = "orderhosptpricetype", required = true, value = "交通类型") @RequestParam Integer orderhosptpricetype,
			@ApiParam(name = "orderhosptprice", value = "交通价格") @RequestParam(required = false) BigDecimal orderhosptprice,
			@ApiParam(name = "orderhospapricetype", required = true, value = "住宿类型") @RequestParam Integer orderhospapricetype,
			@ApiParam(name = "orderhospaprice", value = "住宿价格") @RequestParam(required = false) BigDecimal orderhospaprice,
			@ApiParam(name = "orderhospepricetype", required = true, value = "餐饮费用") @RequestParam Integer orderhospepricetype,
			@ApiParam(name = "orderhospeprice", value = "餐饮价格") @RequestParam(required = false) BigDecimal orderhospeprice)
			throws Exception {

		if (docloginid == null) {
			return DataResult.error("医生id为空");
		}
		if (hosploginid == null) {
			return DataResult.error("医院id为空");
		}
		if (orderhospprice == null) {
			return DataResult.error("医生价格为空");
		}
		return hospitalConsultationService.creatConsultation(docloginid, hosploginid, orderabs, orderstime,
				orderhospprice, orderhosptpricetype, orderhosptprice, orderhospapricetype, orderhospaprice,
				orderhospepricetype, orderhospeprice);

	}
	//获取会诊信息
	@RequestMapping(value = "/listconsultation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取会诊信息", httpMethod = "POST", notes = "获取会诊信息")
	public String listConsultation(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "type", value = "为空时获取全部数据，为1时获取等待医生确认，为2时获取等待医院确认，3为获取付款完成的，4为订单完成，6为取消的订单") @RequestParam(required=false) Integer type,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "每页多少数据") @RequestParam(value = "offset") Integer offset)
			throws Exception {

		/*if (type == null) {
			return DataResult.error("会诊订单id为空");
		}*/
		if (hosploginid == null) {
			return DataResult.error("医院id为空");
		}
		if (!CheckUtils.isPositiveIntegerLegal(limit)) {
			return DataResult.error("limit应为正整数");
		}
		return hospitalConsultationService.listConsultation(hosploginid,limit,offset,type);

	}
	// 取消会诊
	@RequestMapping(value = "/refusepreorderrequest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消会诊", httpMethod = "POST", notes = "取消会诊")
	public String cancelpreorderrequest(

			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "hosporderid", required = true, value = "会诊订单id") @RequestParam Integer hosporderid)
			throws Exception {

		if (hosporderid == null) {
			return DataResult.error("会诊订单id为空");
		}
		if (hosploginid == null) {
			return DataResult.error("医院id为空");
		}
		return hospitalConsultationService.cancelConsultation(hosploginid, hosporderid);

	}

	// 支付会诊费用
	@RequestMapping(value = "/paydoctor", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消会诊", httpMethod = "POST", notes = "取消会诊")
	public String paydoctor(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "hosporderid", required = true, value = "会诊订单id") @RequestParam Integer hosporderid,
			@ApiParam(name = "type", required = true, value = "支付方式1为支付宝2为微信支付") @RequestParam(defaultValue="1") Integer type)
			throws Exception {

		if (hosporderid == null) {
			return DataResult.error("会诊订单id为空");
		}
		if (hosploginid == null) {
			return DataResult.error("医院id为空");
		}
		return hospitalConsultationService.updateStatePayDoctor(hosploginid, hosporderid,type);

	}

	// 支付会诊费用
	@RequestMapping(value = "/paydoctorfinishbyalipay", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消会诊", httpMethod = "POST", notes = "取消会诊")
	public String paydoctorfinishbyalipay(HttpServletRequest request)

			throws Exception {
		Map requestParams = request.getParameterMap();
		System.out.println("回调" + requestParams + "hhtp" + request);
		String result = hospitalConsultationService.updateStatePayDoctorFinish(requestParams);
		net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(result);
		if ("100".equals(json.get("code").toString())) {
			return "success";
		} else {
			return "false";
		}

	}

	// 会诊完成
	@RequestMapping(value = "/finishpreorderrequest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "会诊完成", httpMethod = "POST", notes = "会诊完成")
	public String finishpreorderrequest(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "hosporderid", required = true, value = "会诊订单id") @RequestParam Integer hosporderid)
			throws Exception {

		if (hosporderid == null) {
			return DataResult.error("会诊订单id为空");
		}
		if (hosploginid == null) {
			return DataResult.error("医院id为空");
		}
		return hospitalConsultationService.updateStateFinishConsultation(hosploginid, hosporderid);

	}

}
