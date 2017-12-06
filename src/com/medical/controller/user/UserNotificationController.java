package com.medical.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.medical.service.iface.CommonService;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName: UserNotificationController.java
 * @Description: 用户通知管理
 * @author xyh
 * @version V1.0
 * @Date 2017年11月27日 上午10:48:17
 */

@RestController
@RequestMapping(value = "/user")
public class UserNotificationController {
	@Autowired
	private CommonService commonService;

	/**
	 * @Title: listreceivenotification
	 * @Description: 获取需要接收的通知
	 * @param userloginid
	 * @param page
	 * @param type
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/listreceivenotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取需要接收的通知", httpMethod = "psot", notes = "获取其他发送的通知")
	public @ResponseBody String listreceivenotification(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page,
			@ApiParam(name = "type", value = "当type为空时获取全部通知，为1时获取已读通知，2为时获取未读通知") @RequestParam(required = false) Integer type)
			throws Exception {
		if (userloginid != null && page != null) {
			if (type != null && (!(type == 1 || type == 2))) {
				return DataResult.error("type值超出范围");
			}
			if (page < 0) {
				return DataResult.error("page值超出范围");
			}
			PageInfo<Map<String, Object>> pageInfo = commonService.listReceiveNotification(userloginid, 3, page, type);
			if (pageInfo != null && pageInfo.getTotal() > 0) {
				return DataResult.success("获取数据成功", pageInfo.getList());
			} else {
				return DataResult.success("获取数据为空", null);
			}
		} else {
			return DataResult.error("信息不完整");
		}

	}

	/**
	 * @Title: listsendernotification
	 * @Description: 获取发送的通知
	 * @param userloginid
	 * @param page
	 * @param type
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/listsendernotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取发送的通知", httpMethod = "psot", notes = "获取发送的通知")
	public @ResponseBody String listsendernotification(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page,
			@ApiParam(name = "type", value = "当type为空时获取全部通知，为1时获取已读通知，2为时获取未读通知") @RequestParam(required = false) Integer type)
			throws Exception {
		if (userloginid != null) {
			if (type != null && (!(type == 1 || type == 2))) {
				return DataResult.error("type值超出范围");
			}
			if (page < 0) {
				return DataResult.error("page值超出范围");
			}
			PageInfo<Map<String, Object>> pageInfo = commonService.listSenderNotification(userloginid, 3, page, type);
			if (pageInfo != null && pageInfo.getTotal() > 0) {
				return DataResult.success("获取数据成功", pageInfo.getList());
			} else {
				return DataResult.success("获取数据为空", null);
			}
		} else {
			return DataResult.error("信息不完整");
		}

	}

	/**
	 * @Title: updateNotificationToRead
	 * @Description: 将通知置为已读
	 * @param notificationid
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/updatenotificationtoread", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "将通知置为已读", httpMethod = "psot", notes = "将通知置为已读")
	public @ResponseBody String updateNotificationToRead(
			@ApiParam(name = "notificationid", required = true, value = "通知id") @RequestParam Integer notificationid,
			@ApiParam(name = "userloginid", required = true, value = "用户登陆id") @RequestParam Integer userloginid)
			throws Exception {
		if (userloginid != null) {
			boolean result = commonService.updateNotificationToRead(notificationid, userloginid);
			if (result) {
				return DataResult.success("已读成功");
			} else {
				return DataResult.success("已读失败");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (notificationid == null) {
				errList.add("通知id为空");
			}
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}

			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}

	/**
	 * @Title: updateAllNotificationToRead
	 * @Description: 将该用户的所有未读通知置为已读
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/updateallnotificationtoread", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "将该用户的所有未读通知置为已读", httpMethod = "psot", notes = "将该用户的所有未读通知置为已读")
	public @ResponseBody String updateAllNotificationToRead(
			@ApiParam(name = "userloginid", required = true, value = "用户登陆id") @RequestParam Integer userloginid)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户id为空");
		}
		return commonService.updateAllNotificationToRead(userloginid, 3);
	}

	/**
	 * @Title: deleteNotification
	 * @Description: 删除接收的通知
	 * @param notificationid
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/deletereceivenotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除接收的通知", httpMethod = "psot", notes = "删除接收的通知")
	public @ResponseBody String deleteNotification(
			@ApiParam(name = "notificationid", required = true, value = "通知id") @RequestParam Integer notificationid,
			@ApiParam(name = "userloginid", required = true, value = "用户登陆id") @RequestParam Integer userloginid)
			throws Exception {
		if (userloginid != null) {
			boolean result = commonService.deleteNotification(notificationid, userloginid);
			if (result) {
				return DataResult.success("删除成功");
			} else {
				return DataResult.error("删除失败");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (notificationid == null) {
				errList.add("通知id为空");
			}
			if (userloginid == null) {
				errList.add("用户登录id为空");
			}

			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}

	/**
	 * @Title: deleteAllNotification
	 * @Description: 删除接收的所有通知
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/deleteallreceivenotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除接收的所有通知", httpMethod = "psot", notes = "删除接收的所有通知")
	public @ResponseBody String deleteAllNotification(
			@ApiParam(name = "userloginid", required = true, value = "用户登陆id") @RequestParam Integer userloginid)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		return commonService.deleteAllNotification(userloginid, 3);
	}
}
