package com.medical.controller.hopital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medical.service.iface.CommonService;
import com.medical.utils.CheckUtils;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName: HospitalNotificationController.java
 * @Description: 通知管理
 * @author xyh
 * @version V1.0
 * @Date 2017年11月27日 下午3:03:46
 */
@RestController
@RequestMapping(value = "/hospital")
public class HospitalNotificationController {

	@Autowired
	private CommonService commonService;

	@RequestMapping(value = "/listreceivenotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取需要接收的通知", httpMethod = "POST", notes = "获取其他发送的通知")
	public @ResponseBody String listreceivenotification(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset,
			@ApiParam(name = "type", value = "当type为空时获取全部通知，为1时获取已读通知，2为时获取未读通知") @RequestParam(required = false) Integer type)
			throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		if (!CheckUtils.isNonzeroPositiveIntegerLegal(limit)) {
			return DataResult.error("limit应为非零正整数");
		}
		if (!CheckUtils.isPositiveIntegerLegal(offset)) {
			return DataResult.error("offset应为正整数");
		}
		if (type != null && (type != 1 || type != 2)) {
			return DataResult.error("type值超出范围");
		}
		return commonService.listReceiveNotification(hosploginid, 1, limit, offset, type);

	}
	@RequestMapping(value = "/getunreadnotificationnum", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取未读的通知数量", httpMethod = "POST", notes = "获取未读的通知数量")
	public @ResponseBody String getUnreadNotificationNum(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid
			)
			throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		return commonService.getUnreadNotificationNum(hosploginid);

	}
	@RequestMapping(value = "/listsendernotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取发送的通知", httpMethod = "POST", notes = "获取发送的通知")
	public @ResponseBody String listsendernotification(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset,
			@ApiParam(name = "type", value = "当type为空时获取全部通知，为1时获取已读通知，2为时获取未读通知") @RequestParam(required = false) Integer type)
			throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		if (!CheckUtils.isNonzeroPositiveIntegerLegal(limit)) {
			return DataResult.error("limit应为非零正整数");
		}
		if (!CheckUtils.isPositiveIntegerLegal(offset)) {
			return DataResult.error("offset应为正整数");
		}
		if (type != null && (type != 1 || type != 2)) {
			return DataResult.error("type值超出范围");
		}
		return commonService.listSenderNotification(hosploginid, 1, limit, offset, type);
	}

	@RequestMapping(value = "/readnotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "将通知置为已读", httpMethod = "POST", notes = "将通知置为已读")
	public @ResponseBody String readnotification(
			@ApiParam(name = "notificationid", required = true, value = "通知id") @RequestParam Integer notificationid,
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid)
			throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		if (notificationid == null) {
			return DataResult.error("通知id为空");
		}
		boolean result = commonService.updateNotificationToRead(notificationid, hosploginid);
		if (result) {
			return DataResult.success("已读成功");
		} else {
			return DataResult.error("已读失败");
		}

	}

	@RequestMapping(value = "/deletereceivenotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除接收的通知", httpMethod = "POST", notes = "删除接收的通知")
	public @ResponseBody String deleteNotification(
			@ApiParam(name = "notificationid", required = true, value = "通知id") @RequestParam Integer notificationid,
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid)
			throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		if (notificationid == null) {
			return DataResult.error("通知id为空");
		}

		boolean result = commonService.deleteNotification(notificationid, hosploginid);
		if (result) {
			return DataResult.success("删除成功");
		} else {
			return DataResult.error("删除失败");
		}

	}

}
