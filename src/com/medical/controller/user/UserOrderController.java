package com.medical.controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.service.iface.user.UserOrderService;
import com.medical.utils.IpUtils;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName: UserOrderController.java
 * @Description: 用户订单管理
 * @author xyh
 * @version V1.0
 * @Date 2017年11月27日 上午10:48:38
 */
@RestController
@RequestMapping(value = "/user")
public class UserOrderController {
	@Autowired
	private UserOrderService userOrderService;

	//生成订单
	@RequestMapping(value = "/createorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "生成订单", httpMethod = "POST", notes = "生成订单")
	public String createOrder(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "doccalendarid", value = "日程id") @RequestParam Integer doccalendarid)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (doccalendarid==null) {
			return DataResult.error("预约时间为空");
		}
		return userOrderService.createOrder(docloginid, userloginid, doccalendarid);
	}
	
	@RequestMapping(value = "/createquickorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "生成需要支付的订单", httpMethod = "POST", notes = "生成需要支付的订单")
	public String createQuickOrder(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "doccalendarid", value = "预约时间") @RequestParam Integer doccalendarid,
			@ApiParam(name = "paytype", value = "支付类型，1为支付宝支付，2为微信支付") @RequestParam Integer paytype,
			HttpServletRequest request)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (doccalendarid==null) {
			return DataResult.error("预约时间为空");
		}
		if (paytype!=1 && paytype!=2) {
			return DataResult.error("支付类型错误");
		}
		String ip = IpUtils.getIpAddr(request);
		return userOrderService.createQuickOrder(docloginid, userloginid, doccalendarid,paytype,ip);
	}
	
	/**
	 * @Title: cancleOrder
	 * @Description: 取消订单
	 * @param userorderid
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/cancelorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消订单", httpMethod = "POST", notes = "取消订单")
	public String cancleOrder(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid) throws Exception {
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		return userOrderService.updateOrderStateToCancel(userorderid, userloginid);

	}

	/**
	 * @Title: order
	 * @Description: 获取订单
	 * @param userloginid
	 * @param page
	 * @param type
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/getorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取订单", httpMethod = "POST", notes = "获取订单")
	public String order(@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page,
			@ApiParam(name = "type", value = "订单类型，为空获取全部,1代表等待确认病人的订单，2代表正在进行的,3为待评价的,4为等待医生确认的") @RequestParam(required = false) Integer type)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (page == null) {
			return DataResult.error("page为空");
		}
		if (type != null && (type < 1 || type > 4)) {
			return DataResult.error("type超出范围");
		}
		return userOrderService.listOrder(userloginid, page, type);
	}

	/**
	 * @Title: gethistoryorder
	 * @Description: 获取历史订单
	 * @param userloginid
	 * @param page
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/gethistoryorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取历史订单", httpMethod = "POST", notes = "获取历史订单")
	public String gethistoryorder(@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page)

			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (page == null) {
			return DataResult.error("page为空");
		}

		return userOrderService.listOrder(userloginid, page, 5);
	}

	/**
	 * @Title: orderDetail
	 * @Description: 获取订单详细信息
	 * @param userorderid
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/orderdetail", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取订单详细信息", httpMethod = "POST", notes = "获取订单详细信息")
	public String orderDetail(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "登录id") @RequestParam Integer userloginid) throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		return userOrderService.getOrderDetail(userloginid, userorderid);
	}

	/**
	 * @Title: confirmOrder
	 * @Description: 确认订单
	 * @param userorderid
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/confirmorder", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "确认订单", httpMethod = "POST", notes = "确认订单")
	public String confirmOrder(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "type", value = "支付方式为1时为支付宝支付2为微信支付") @RequestParam Integer type,
			HttpServletRequest request) throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		String ip = IpUtils.getIpAddr(request);
		return userOrderService.updateOrderStateToConfirm(userloginid, userorderid, type,ip);
		
	}



	

	

	/**
	 * @Title: payDoctorFinishByAliPay
	 * @Description: 支付医生费用回调
	 * @param request
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/paydoctorfinishbyalipay", method=RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "支付宝支付医生费用回调", httpMethod = "POST", notes = "支付宝支付医生费用回调")
	public String payDoctorFinishByAliPay(HttpServletRequest request) throws Exception {
		Map requestParams = request.getParameterMap();
		System.out.println("回调" + requestParams + "hhtp" + request);
		String result = userOrderService.updateOrderStatePayDoctorFinishByAliPay(requestParams);
		net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(result);
		System.out.println("结果"+json.toString());
		if ("100".equals(json.get("code").toString())) {
			return "success";
		} else {
			return "false";
		}
	}
	@RequestMapping(value = "/paydoctorfinishbywxpay", method=RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "支付宝支付医生费用回调", httpMethod = "POST", notes = "支付宝支付医生费用回调")
	public String payDoctorFinishByWXPay(HttpServletRequest request) throws Exception {
		System.out.println("hhtp" + request);
		String result = userOrderService.updateOrderStatePayDoctorFinishByWXPay(request);
		net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(result);
		System.out.println("结果"+json.toString());
		if ("100".equals(json.get("code").toString())) {
			return "success";
		} else {
			return "false";
		}
	}
	/**
	 * @Title: payhospital
	 * @Description: 支付医院押金
	 * @param userorderid
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/payhospital", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "支付医院押金", httpMethod = "POST", notes = "支付医院押金")
	public String payhospital(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "type", value = "支付方式为1时为支付宝支付2为微信支付") @RequestParam Integer type) throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		if (type==null) {
			type=1;
		}
		return userOrderService.updateOrderStatePayHospital(userloginid, userorderid,type);
	}

	/**
	 * @Title: payhospitalfinish
	 * @Description: 支付医院押金回调
	 * @param request
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/payhospitalfinishbyalipay", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "支付医院押金回调", httpMethod = "POST", notes = "支付医院押金回调")
	public String payhospitalfinish(HttpServletRequest request) throws Exception {
		Map<String, String[]> requestParams = request.getParameterMap();
		System.out.println("回调" + requestParams + "hhtp" + request);
		String result = userOrderService.updateOrderStatePayHospitalFinishByAlipay(requestParams);
		net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(result);
		if ("100".equals(json.get("code").toString())) {
			return "success";
		} else {
			return "false";
		}
	}

	/**
	 * @Title: cancelhospital
	 * @Description: 取消住院
	 * @param userorderid
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/cancelhospital", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消住院", httpMethod = "POST", notes = "取消住院")
	public String cancelhospital(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid) throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		return userOrderService.updateOrderStateToCancelHospital(userloginid, userorderid);
	}

	/**
	 * @Title: evaluate
	 * @Description: 评价
	 * @param userorderid
	 * @param userloginid
	 * @param doccommentservicelevel
	 * @param doccommentprofessionallevel
	 * @param doccommentpricelevel
	 * @param doccommentwords
	 * @param hospcommentservicelevel
	 * @param hospcommentenvironmenlevel
	 * @param hospcommentpricelevel
	 * @param hospcommentwords
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/evaluate", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "对订单进行评价", httpMethod = "POST", notes = "对订单进行评价")
	public String evaluate(@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "doccommentservicelevel", value = "医生服务水平(1-5五个等级)") @RequestParam Integer doccommentservicelevel,
			@ApiParam(name = "doccommentprofessionallevel", value = "医生专业水平(1-5五个等级)") @RequestParam Integer doccommentprofessionallevel,
			@ApiParam(name = "doccommentpricelevel", value = "医生价格水平(1-5五个等级)") @RequestParam Integer doccommentpricelevel,
			@ApiParam(name = "doccommentwords", value = "对医生的评价") @RequestParam String doccommentwords,
			@ApiParam(name = "hospcommentservicelevel", value = "医院服务水平(1-5五个等级)") @RequestParam(required = false) Integer hospcommentservicelevel,
			@ApiParam(name = "hospcommentenvironmenlevel", value = "医生环境水平(1-5五个等级)") @RequestParam(required = false) Integer hospcommentenvironmenlevel,
			@ApiParam(name = "hospcommentpricelevel", value = "医生价格水平(1-5五个等级)") @RequestParam(required = false) Integer hospcommentpricelevel,
			@ApiParam(name = "hospcommentwords", value = "对医院的评价") @RequestParam(required = false) String hospcommentwords)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		return userOrderService.insertEvaluate(userorderid, userloginid, doccommentservicelevel,
				doccommentprofessionallevel, doccommentpricelevel, doccommentwords, hospcommentservicelevel,
				hospcommentenvironmenlevel, hospcommentpricelevel, hospcommentwords);
	}
}
