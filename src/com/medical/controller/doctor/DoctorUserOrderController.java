package com.medical.controller.doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.medical.po.Userorder;
import com.medical.service.iface.doctor.DoctorOrderService;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     DoctorUserOrderController.java
 * @Description:   医生订单管理
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午9:46:25 
 */
@RestController
@RequestMapping(value = "/doctor")
public class DoctorUserOrderController {
	@Autowired
	private DoctorOrderService doctorOrderService;

	// 医生抢单
	@RequestMapping(value = "/graborder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生抢单", httpMethod = "POST", notes = "医生抢单", produces = "application/json")
	public String grabOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "usersickid", required = true, value = "病情id") @RequestParam(value = "usersickid") Integer usersickid,
			@ApiParam(name = "preorderprice", value = "预估价格") @RequestParam(required = false) Double preorderprice)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (usersickid == null) {
			return DataResult.error("病情id为空");
		}
		return doctorOrderService.creatPreOrder(usersickid, docloginid, preorderprice);
	}

	// 获取已抢订单
	@RequestMapping(value = "/listgraborders", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取已抢订单", httpMethod = "POST", notes = "获取已抢订单", produces = "application/json")
	public String listGrabOrders(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (page == null) {
			return DataResult.error("page为空");
		} else {
			if (page < 0) {
				return DataResult.error("page需大于0");
			}
		}
		return doctorOrderService.listGrabOrders(docloginid, page, 5);
	}

	// 医生取消抢单
	@RequestMapping(value = "/cancelgraborder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生取消抢单", httpMethod = "POST", notes = "医生取消抢单")
	public String cancelOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "preorderid", required = true, value = "预订单id") @RequestParam(value = "preorderid") Integer preorderid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (preorderid == null) {
			return DataResult.error("申请记录id为空");
		}
		return doctorOrderService.deletePreOrder(docloginid, preorderid);

	}

	@RequestMapping(value = "/listordertoconfirm", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取选择我的订单", httpMethod = "POST", notes = "医生获取选择我的订单")
	public String listOrderToConfirm(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("登录id为空");
		}
		if (page == null) {
			return DataResult.error("当前页为空");
		} else {
			if (page < 0) {
				return DataResult.error("当前页不可小于0");
			}
		}
		return doctorOrderService.listOrderToConfirm(docloginid, page, 5);
	}

	// 医生获取订单
	@RequestMapping(value = "/getorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取订单", httpMethod = "POST", notes = "医生获取订单")
	public String getorder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page,
			@ApiParam(name = "type", value = "订单类型，为空获取全部,1代表等待病人确认的订单，2代表正在进行的") @RequestParam(required = false) Integer type)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (page == null) {
			return DataResult.error("当前页为空");
		} else {
			if (page < 0) {
				return DataResult.error("当前页为大于0的整数");
			}
		}
		if (type != null && type > 2) {
			return DataResult.error("type值超出范围");
		}
		return doctorOrderService.listOrder(docloginid, type, page, 5);
	}

	// 医生获取订单
	@RequestMapping(value = "/listhistoryorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取历史订单", httpMethod = "POST", notes = "医生获取历史订单")
	public String listHistoryOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (page == null) {
			return DataResult.error("当前页为空");
		} else {
			if (page < 0) {
				return DataResult.error("当前页为大于0的整数");
			}
		}

		return doctorOrderService.listHistoryOrder(docloginid, page);
	}

	// 医生获取订单详情
	@RequestMapping(value = "/getorderdetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取订单详情", httpMethod = "POST", notes = "医生获取订单详情")
	public String getOrderDetail(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "userorderid", required = true, value = "订单id") @RequestParam(value = "userorderid") Integer userorderid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		return doctorOrderService.getOrderDetail(docloginid, userorderid);
	}

	// 医生拒绝接单
	@RequestMapping(value = "/refuseorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生拒绝接单", httpMethod = "POST", notes = "医生拒绝接单")
	public String refuseOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "userorderid", required = true, value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "redocloginid", value = "推荐医生登陆id") @RequestParam(required = false) Integer redocloginid)
			throws Exception {
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return doctorOrderService.updateOrderToRefuse(docloginid, userorderid, redocloginid);

	}

	// 医生确认订单
	@RequestMapping(value = "/confirmorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生确认订单", httpMethod = "POST", notes = "医生确认订单")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docloginid", required = true, value = "医生登录id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "userorderid", required = true, value = "订单id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "userorderdprice", required = false, value = "医生价格", dataType = "Double", paramType = "query"),
			@ApiImplicitParam(name = "userordertpricetype", required = true, value = "交通类型", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "userordertprice", required = false, value = "交通价格", dataType = "Double", paramType = "query"),
			@ApiImplicitParam(name = "userorderapricetype", required = true, value = "住宿类型", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "userorderaprice", required = false, value = "住宿价格", dataType = "Double", paramType = "query"),
			@ApiImplicitParam(name = "userorderepricetype", required = true, value = "餐饮类型", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "userordereprice", required = false, value = "住宿价格", dataType = "Double", paramType = "query") })
	public String confirmOrder(@ApiIgnore Userorder userorder, @ApiIgnore Integer docloginid) throws Exception {
		Integer userorderid = userorder.getUserorderid();
		Integer userordertpricetype = userorder.getUserordertpricetype();
		Integer userorderapricetype = userorder.getUserorderapricetype();
		Integer userorderepricetype = userorder.getUserorderepricetype();
		System.out.println("交通类型测试" + userorderapricetype);
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		if (userordertpricetype == null) {
			return DataResult.error("交通类型为空");
		}
		if (userorderapricetype == null) {
			return DataResult.error("住宿类型为空");
		}
		if (userorderepricetype == null) {
			return DataResult.error("餐饮类型为空");
		}
		return doctorOrderService.updateOrderConfirm(userorder);
	}

	// 医生取消订单
	@RequestMapping(value = "/cancelorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生取消订单", httpMethod = "POST", notes = "医生取消订单")
	public String cancel(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "userorderid", required = true, value = "订单id") @RequestParam Integer userorderid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		return doctorOrderService.updateOrderToCancle(docloginid, userorderid);
			
		
	}

	// 医生结束订单
	@RequestMapping(value = "/finishorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生结束订单", httpMethod = "POST", notes = "医生结束订单")
	public String finishOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "userorderid", required = true, value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "userorderhstate", required = true, value = "是否住院") @RequestParam Boolean userorderhstate,
			@ApiParam(name = "userorderhospid", required = false, value = "接诊医院id") @RequestParam(required = false) Integer userorderhospid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (userorderid == null) {
			return DataResult.error("订单id为空");
		}
		return doctorOrderService.finishOrder(docloginid, userorderid, userorderhstate,
					userorderhospid);
			
		
	}

}
