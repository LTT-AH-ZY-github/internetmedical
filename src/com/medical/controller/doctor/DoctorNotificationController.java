package com.medical.controller.doctor;

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
 * @ClassName:     DoctorNotificationController.java
 * @Description:   医生通知
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午9:45:59 
 */
@RestController
@RequestMapping(value = "/doctor")
public class DoctorNotificationController {
	@Autowired
	private CommonService commonService;
	@RequestMapping(value="/listreceivenotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取需要接收的通知",httpMethod="POST",notes="获取其他发送的通知")
	public @ResponseBody String listreceivenotification(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page,
			@ApiParam(name = "type", value = "当type为空时获取全部通知，为1时获取已读通知，2为时获取未读通知") @RequestParam(required=false) Integer type
			)throws Exception{
		if (docloginid != null  && page!=null) {
			if ( type!=null && (!(type==1||type==2))) {
				return DataResult.error("type值超出范围");
			}
			if (page<0) {
				return DataResult.error("page值超出范围");
			}
			PageInfo<Map<String, Object>> pageInfo = commonService.listReceiveNotification(docloginid, 2, page, type);
			if (pageInfo != null && pageInfo.getTotal()>0) {
				return DataResult.success("获取数据成功", pageInfo.getList());
			}else {
				return DataResult.success("获取数据为空", null);
			}
		}else {
			return DataResult.error("信息不完整");
		}
		
	}
	
	@RequestMapping(value="/listsendernotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取发送的通知",httpMethod="POST",notes="获取发送的通知")
	public @ResponseBody String listsendernotification(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page,
			@ApiParam(name = "type", value = "当type为空时获取全部通知，为1时获取已读通知，2为时获取未读通知") @RequestParam(required=false) Integer type
			)throws Exception{
		if (docloginid != null) {
			if ( type!=null && (!(type==1||type==2))) {
				return DataResult.error("type值超出范围");
			}
			if (page<0) {
				return DataResult.error("page值超出范围");
			}
			PageInfo<Map<String, Object>> pageInfo = commonService.listSenderNotification(docloginid, 2, page, type);
			if (pageInfo != null && pageInfo.getTotal()>0) {
				return DataResult.success("获取数据成功", pageInfo.getList());
			}else {
				return DataResult.success("获取数据为空", null);
			}
		}else {
			return DataResult.error("信息不完整");
		}
		
	}
	@RequestMapping(value="/updatenotificationtoread", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="将通知置为已读",httpMethod="POST",notes="将通知置为已读")
	public @ResponseBody String updateNotificationToRead(
			@ApiParam(name = "notificationid", required = true, value = "通知id") @RequestParam Integer notificationid,
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid
			)throws Exception{
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (notificationid == null) {
			return DataResult.error("通知id为空");
		}
		return commonService.updateNotificationToRead(notificationid, docloginid);
	}
	
	@RequestMapping(value="/updateallnotificationtoread", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="将该用户的所有未读通知置为已读",httpMethod="POST",notes="将该用户的所有未读通知置为已读")
	public @ResponseBody String updateAllNotificationToRead(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid
			)throws Exception{
		if (docloginid == null) {
			return DataResult.error("医生id为空");
		}
		return commonService.updateAllNotificationToRead(docloginid, 2);
	}
	@RequestMapping(value="/deletereceivenotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="删除接收的通知",httpMethod="POST",notes="删除接收的通知")
	public @ResponseBody String deleteNotification(
			@ApiParam(name = "notificationid", required = true, value = "通知id") @RequestParam Integer notificationid,
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid
			)throws Exception{
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (notificationid == null) {
			return DataResult.error("通知id为空");
		}
		return commonService.deleteNotification(notificationid, docloginid);
	}
	
	@RequestMapping(value="/deleteallreceivenotification", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="删除接收的所有通知",httpMethod="POST",notes="删除接收的所有通知")
	public @ResponseBody String deleteAllNotification(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid
			)throws Exception{
		if (docloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		return commonService.deleteAllNotification(docloginid, 2);
	}
}
