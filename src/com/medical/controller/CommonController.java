/**  
* @Title: CommonController.java  
* @Package com.medical.controller  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月18日  
* @version V1.0  
*/  
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
			@ApiParam(name = "feedbackidea", required = true, value = "意见") @RequestParam String feedbackidea) throws Exception {
			if (StringUtils.isBlank(feedbackidea)) {
				return DataResult.error("意见为空");
			}
			if (feedbackidea.length()>255) {
				return DataResult.error("超出长度限制");
			}
			return commonService.addFeedBack(feedbackidea);
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
			@ApiParam(name = "version", required = true, value = "版本号") @RequestParam String version) throws Exception {
		return commonService.uploadAndroidApp(type,app,version);
	}
}
