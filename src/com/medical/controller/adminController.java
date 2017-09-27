package com.medical.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  作者:熊阳辉
 * @date 创建时间：2017年7月18日 上午11:05:48
 * @version 1.0 
 */
@RestController
@RequestMapping(value="/admin")
public class adminController {
	@RequestMapping(value="ad")
	public void test(){
		System.out.println("123");
		
	}
}

