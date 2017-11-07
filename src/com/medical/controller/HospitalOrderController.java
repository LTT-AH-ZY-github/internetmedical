package com.medical.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
public class HospitalOrderController {
	// 医院确认需要住院的病人订单
		@RequestMapping(value = "/hospital/refuseuserorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		@ApiOperation(value = "医院确认需要住院的病人订单", httpMethod = "POST", notes = "医院确认需要住院的病人订单")
		public @ResponseBody String refuseuserorder(
				@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
				@ApiParam(name = "userorderid", value = "订单id") @RequestParam Integer userorderid
		) throws Exception {
			if (hosploginid != null && userorderid != null) {
				/*boolean result = hospitalOrderService.confirmUserOrder(hosploginid, userorderid, userorderdeposit, userorderhospprimarydept, userorderhospseconddept);
				if (result) {
					return DataResult.success("确认成功");
				} else {
					return DataResult.error("确认失败");
				}*/
				return DataResult.error("确认失败");
			} else {
				List<String> errList = new ArrayList<String>();
				
				if (hosploginid == null) {
					errList.add("医院id为空");
				}
				if (userorderid == null) {
					errList.add("订单id为空");
				}
				return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
			}
		}
}
