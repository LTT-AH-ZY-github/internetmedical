package com.medical.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.medical.po.HospSearchDocTerm;
import com.medical.po.Hospitaldept;
import com.medical.service.HospitalService;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.hospital.HospitalOrderService;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.Result;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import javafx.scene.chart.PieChart.Data;
import net.sf.json.JSONObject;

/**
 * @author 作者:xyh
 * @date 创建时间：2017年9月15日 上午09:05:48
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/hospital")

public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private HospitalOrderService hospitalOrderService;
	
	@Autowired 
	private CommonService commonService;

	@ResponseBody
	@RequestMapping(value = "/listdoctor", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "医院根据条件获取医生", httpMethod = "POST", notes = "医院根据条件获取医生", responseContainer = "Map", consumes = "multipart/form-data", produces = "application/json")
	@ApiResponses({ @ApiResponse(code = 400, message = "Invalid Order") })
	public String listDoctor(
			@ApiParam(name = "hosploginid", required = true, value = "用户名") @RequestParam(value = "hosploginid") Integer hosploginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page,
			@ApiParam(name = "hosplevel", required = false, value = "医院等级") @RequestParam(value = "hosplevel", required = false) Integer hosplevel,
			@ApiParam(name = "doctortitle", required = false, value = "医生职称") @RequestParam(value = "doctortitle", required = false) Integer doctortitle,
			@ApiParam(name = "details", required = false, value = "描述") @RequestParam(value = "details", required = false) String details)
			throws Exception {

		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		if (page == null) {
			return DataResult.error("当前页为空");
		}

		Integer pageSize = 6;
		HospSearchDocTerm hospSearchDocTerm = new HospSearchDocTerm();
		hospSearchDocTerm.setHospitalLevel(hosplevel);
		hospSearchDocTerm.setDoctorTitle(doctortitle);

		return hospitalOrderService.listDoctor(page, pageSize, hospSearchDocTerm);

	}

	// 创建会诊
	@RequestMapping(value = "/PreOrderRequest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "创建会诊", httpMethod = "POST", notes = "创建会诊")
	public @ResponseBody String PreOrderRequest(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "orderstime", required = true, value = "预约医生时间") @RequestParam String orderstime,
			@ApiParam(name = "orderabs", required = true, value = "情况描述") @RequestParam String orderabs,
			@ApiParam(name = "orderhospprice", required = true, value = "会诊价格") @RequestParam Double orderhospprice,
			@ApiParam(name = "orderhosptpricetype", required = true, value = "交通类型") @RequestParam Integer orderhosptpricetype,
			@ApiParam(name = "orderhosptprice", value = "交通价格") @RequestParam(required = false) Double orderhosptprice,
			@ApiParam(name = "orderhospapricetype", required = true, value = "住宿类型") @RequestParam Integer orderhospapricetype,
			@ApiParam(name = "orderhospaprice", value = "住宿价格") @RequestParam(required = false) Double orderhospaprice,
			@ApiParam(name = "orderhospepricetype", required = true, value = "餐饮费用") @RequestParam Integer orderhospepricetype,
			@ApiParam(name = "orderhospeprice", value = "餐饮价格") @RequestParam(required = false) Double orderhospeprice)
			throws Exception {

		if (docloginid == null ) {
			return DataResult.error("医生id为空");
		}
		if ( hosploginid == null ) {
			return DataResult.error("医院id为空");
		}
		if ( orderhospprice == null) {
			return DataResult.error("医生价格为空");
		}
		return hospitalOrderService.creatConsultation(docloginid, hosploginid, orderabs, orderstime, orderhospprice,
				orderhosptpricetype, orderhosptprice, orderhospapricetype, orderhospaprice, orderhospepricetype,
				orderhospeprice);

	}
	
	// 取消会诊
	@RequestMapping(value = "/refusepreorderrequest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消会诊", httpMethod = "POST", notes = "取消会诊")
	public @ResponseBody String cancelpreorderrequest(
			
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "hosporderid", required = true, value = "会诊订单id") @RequestParam Integer hosporderid
			)
			throws Exception {

		if (hosporderid == null ) {
			return DataResult.error("会诊订单id为空");
		}
		if ( hosploginid == null ) {
			return DataResult.error("医院id为空");
		}
		return hospitalOrderService.cancelConsultation( hosploginid, hosporderid);

	}
	
	// 会诊完成
	@RequestMapping(value = "/finishpreorderrequest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "会诊完成", httpMethod = "POST", notes = "会诊完成")
	public @ResponseBody String finishpreorderrequest(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "hosporderid", required = true, value = "会诊订单id") @RequestParam Integer hosporderid)
			throws Exception {

		if (hosporderid == null) {
			return DataResult.error("会诊订单id为空");
		}
		if (hosploginid == null) {
			return DataResult.error("医院id为空");
		}
		return hospitalOrderService.finishConsultation(hosploginid, hosporderid);

	}
	
	// 医院获取需要住院的病人订单
	@RequestMapping(value = "/listuserorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医院获取需要住院的病人订单", httpMethod = "POST", notes = "医院获取需要住院的病人订单")
	public @ResponseBody String listUserOrder(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "type", value = "为空时获取全部订单，为1时获取等待医院确认的订单，为2时为等待用户缴纳押金的订单，3为已缴纳医院押金,等待住院，4住院完成，等待费用结算，5为订单完成") @RequestParam(required = false) Integer type,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "每页多少数据") @RequestParam(value = "offset") Integer offset)
			throws Exception {
		if (hosploginid != null && limit != null) {
			Map<String, Object> result = hospitalService.listUserOrder(hosploginid,type,limit,offset);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("获取数据成功", result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("获取数据为空");
			} else {
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (limit == null) {
				errList.add("当前页为空");
			}
			if (hosploginid == null) {
				errList.add("医院id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
	}

	// 医院确认需要住院的病人订单
	@RequestMapping(value = "/confirmuserorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医院确认需要住院的病人订单", httpMethod = "POST", notes = "医院确认需要住院的病人订单")
	public @ResponseBody String confirmUserOrder(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "userorderdeposit", required = true, value = "押金") @RequestParam Double userorderdeposit,
			@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userorderhospprimarydept", value = "一级部门") @RequestParam String userorderhospprimarydept,
			@ApiParam(name = "userorderhospseconddept", value = "二级部门") @RequestParam(required=false) String userorderhospseconddept

	) throws Exception {
		if (hosploginid != null && userorderdeposit != null && userorderid != null) {
			boolean result = hospitalOrderService.confirmUserOrder(hosploginid, userorderid, userorderdeposit, userorderhospprimarydept, userorderhospseconddept);
			if (result) {
				return DataResult.success("确认成功");
			} else {
				return DataResult.error("确认失败");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userorderdeposit == null) {
				errList.add("押金为空");
			}
			if (hosploginid == null) {
				errList.add("医院id为空");
			}
			if (userorderid == null) {
				errList.add("订单id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
	}
	
	// 医院确认需要住院的病人订单
	@RequestMapping(value = "/refuseserorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医院拒绝需要住院的病人订单", httpMethod = "POST", notes = "医院拒绝需要住院的病人订单")
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
			@ApiParam(name = "userorderhprice", value = "实际产生的费用") BigDecimal userorderhprice)
			throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登陆id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		
		return hospitalOrderService.updateUserOrderToSettle(hosploginid, userorderid,userorderhprice);
	}
	
	// 增加押金
	@RequestMapping(value = "/finishuserorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "订单完成", httpMethod = "POST", notes = "订单完成")
	public @ResponseBody String finishUserOrder(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid) throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登陆id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}

		return hospitalOrderService.updateUserOrderToEnd(hosploginid, userorderid);
	}

	@RequestMapping(value="/listreceivenotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取需要接收的通知",httpMethod="psot",notes="获取其他发送的通知")
	public @ResponseBody String listreceivenotification(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset,
			@ApiParam(name = "type", value = "当type为空时获取全部通知，为1时获取已读通知，2为时获取未读通知") @RequestParam(required=false) Integer type
			)throws Exception{
		if (hosploginid != null) {
			PageInfo<Map<String, Object>> pageInfo = commonService.listReceiveNotification(hosploginid, 1, limit,offset,type);
			if (pageInfo != null && pageInfo.getTotal()>0) {
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("rows", pageInfo.getList());
				//总共页数
				data.put("total", pageInfo.getTotal());
				return DataResult.success("获取数据成功", data);
			}else {
				return DataResult.success("获取数据为空", null);
			}
		}else {
			return DataResult.success("获取数据为空", null);
		}
		
	}
	@RequestMapping(value="/listsendernotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取发送的通知",httpMethod="psot",notes="获取发送的通知")
	public @ResponseBody String listsendernotification(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset,
			@ApiParam(name = "type", value = "当type为空时获取全部通知，为1时获取已读通知，2为时获取未读通知") @RequestParam(required=false) Integer type
			)throws Exception{
		if (hosploginid != null) {
			PageInfo<Map<String, Object>> pageInfo = commonService.listSenderNotification(hosploginid, 1, limit, offset, type);
			if (pageInfo != null && pageInfo.getTotal()>0) {
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("rows", pageInfo.getList());
				//总共页数
				data.put("total", pageInfo.getTotal());
				return DataResult.success("获取数据成功", data);
			}else {
				return DataResult.success("获取数据为空", null);
			}
		}else {
			return DataResult.success("获取数据为空", null);
		}
		
	}
	
	@RequestMapping(value="/readnotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="将通知置为已读",httpMethod="psot",notes="将通知置为已读")
	public @ResponseBody String readnotification(
			@ApiParam(name = "notificationid", required = true, value = "通知id") @RequestParam Integer notificationid,
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid
			)throws Exception{
		if (hosploginid != null) {
			boolean result= commonService.updateNotificationToRead(notificationid, hosploginid);
			if (result) {
				return DataResult.success("已读成功");
			}else {
				return DataResult.error("已读失败");
			}
		}else {
			List<String> errList = new ArrayList<String>();
			if (notificationid == null) {
				errList.add("通知id为空");
			}
			if (hosploginid == null) {
				errList.add("医院登录id为空");
			}
			
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		
	}
	@RequestMapping(value="/deletereceivenotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="删除接收的通知",httpMethod="psot",notes="删除接收的通知")
	public @ResponseBody String deleteNotification(
			@ApiParam(name = "notificationid", required = true, value = "通知id") @RequestParam Integer notificationid,
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid
			)throws Exception{
		if (hosploginid != null) {
			boolean result= commonService.deleteNotification(notificationid, hosploginid);
			if (result) {
				return DataResult.success("删除成功");
			}else {
				return DataResult.error("删除失败");
			}
		}else {
			List<String> errList = new ArrayList<String>();
			if (notificationid == null) {
				errList.add("通知id为空");
			}
			if (hosploginid == null) {
				errList.add("医院登录id为空");
			}
			
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		
	}
			
			
}
