package com.medical.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.medical.service.iface.CommonService;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     CommonController.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月18日 下午4:27:58 
 */
@RestController
@RequestMapping(value="/common")
public class CommonController {
	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value = "/addfeedback", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "意见反馈", httpMethod = "POST", notes = "意见反馈")
	public String addFeedBack(
			@ApiParam(name = "feedbackidea", required = true, value = "意见") @RequestParam String feedbackidea,
			@ApiParam(name = "type", required = true, value = "1为病人安卓端,2为医生安卓端,3为病人IOS端,4为医生IOS端,5为医院web端") @RequestParam Integer type
			) throws Exception {
			if (StringUtils.isBlank(feedbackidea)) {
				return DataResult.error("意见为空");
			}
			if (feedbackidea.length()>255) {
				return DataResult.error("超出长度限制");
			}
			if (type==null || type<1 || type>5) {
				return DataResult.error("type有误");
			}
			return commonService.addFeedBack(type,feedbackidea);
	}
	
	@RequestMapping(value = "/getandroidappversion", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取安卓app版本", httpMethod = "POST", notes = "获取安卓app版本")
	public String getappversion(@ApiParam(name = "type", required = true, value = "1为病人端，2为医生端") @RequestParam Integer type) throws Exception {
		return commonService.getAppVersion(type,1);
	}
	
	@RequestMapping(value = "/uploadandroidapp", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "提交安卓app", httpMethod = "POST", notes = "提交安卓app")
	public String uploadandroidapp(
			@ApiParam(name = "type", required = true, value = "1为病人端，2为医生端") @RequestParam Integer type,
			@ApiParam(name = "app", required = true, value = "app") @RequestParam MultipartFile app,
			@ApiParam(name = "version", required = true, value = "版本号") @RequestParam String version,
			@ApiParam(name = "description",  value = "版本描述") @RequestParam(required=false) String description
			) throws Exception {
		if (type!=1 && type != 2) {
			return DataResult.error("type有误");
		}
		if (StringUtils.isBlank(version)) {
			return DataResult.error("版本号为空");
		}
		if (version.length()>255) {
			return DataResult.error("版本号超出长度限制");
		}
		if (description!=null && description.trim().length()==0) {
			return DataResult.error("描述不可只为空格");
		}
		if (StringUtils.isNotBlank(description) && description.length()>255) {
			return DataResult.error("描述过长");
		}
		return commonService.uploadAndroidApp(type,app,version,description);
	}
}
