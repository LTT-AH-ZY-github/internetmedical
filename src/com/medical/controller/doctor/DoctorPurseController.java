package com.medical.controller.doctor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.service.iface.doctor.DoctorPurseService;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     DoctorPurseController.java
 * @Description:   医生钱包
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午9:46:12 
 */
@RestController
@RequestMapping(value = "/doctor")
public class DoctorPurseController {
	@Autowired
	private DoctorPurseService doctorPurseService;
	
	@RequestMapping(value = "/getalipayaccount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取支付宝账号", httpMethod = "POST", notes = "获取支付宝账号", produces = "application/json")
	public String getalipayaccount(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid
			
	) throws Exception{
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return doctorPurseService.getAliPayAccount(docloginid);
	}
	/**
	 * @return 
	 * @Title: pub
	 * @Description: TODO
	 * @return: void
	 */
	@RequestMapping(value = "/updatealipayaccount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改支付宝账号", httpMethod = "POST", notes = "修改支付宝账号", produces = "application/json")
	public String updatealipayaccount(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name="alipayaccount",required=true,value="支付宝账号")@RequestParam String alipayaccount
	) throws Exception{
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (StringUtils.isEmpty(alipayaccount)) {
			return DataResult.error("支付宝账号为空");
		}
		return doctorPurseService.updateAliPayAccount(docloginid, alipayaccount);
	}
	@RequestMapping(value = "/getbalance", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取账户余额", httpMethod = "POST", notes = "获取账户余额", produces = "application/json")
	public String getBalance(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid
	) throws Exception{
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return doctorPurseService.getBalance(docloginid);
		// TODO Auto-generated method stub

	}
	
	@RequestMapping(value = "/listbalancerecord", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取账户余额变动记录", httpMethod = "POST", notes = "获取账户余额变动记录", produces = "application/json")
	public String listBalanceRecord(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam Integer page
	) throws Exception{
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return doctorPurseService.listBalanceRecord(docloginid,page);
		// TODO Auto-generated method stub

	}
	
	@RequestMapping(value = "/listtraderecord", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取交易记录", httpMethod = "POST", notes = "获取交易记录", produces = "application/json")
	public String listTradeRecord(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam Integer page
	) throws Exception{
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return doctorPurseService.listTradeRecord(docloginid, page);
		// TODO Auto-generated method stub

	}
	
}
