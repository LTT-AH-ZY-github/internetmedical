package com.medical.controller;

import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author  作者:xyh
 * @date 创建时间：2017年9月24日 上午12:05:48
 * @version 1.0 
 */
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ErrorController {
	/**
	 * 请求异常
	 * 
	 * @return
	 * @throws Exception
	 *             String
	 */
	@RequestMapping(value = "/error_404", produces = "application/json;charset=UTF-8")
	public String error_404() throws Exception {
		return "{\"msg\":\"找不到页面\",\"code\":\"1000001\"}";
	}

	/**
	 * 服务器异常
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/error_500", produces = "application/json;charset=UTF-8")
	public String error_500() {
		return "{\"msg\":\"服务器处理失败\",\"code\":\"1000002\"}";
	}
}
