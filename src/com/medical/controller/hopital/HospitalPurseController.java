package com.medical.controller.hopital;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.service.iface.hospital.HospitalPurseService;
import com.medical.utils.CheckUtils;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     HospitalPurseController.java
 * @Description:   医院钱包
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午3:48:54 
 */
@RestController
@RequestMapping(value = "/hospital")
public class HospitalPurseController {
	@Autowired
	private HospitalPurseService hospitalPurseService;
	
	@RequestMapping(value = "/getalipayaccount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取支付宝账号", httpMethod = "POST", notes = "获取支付宝账号", produces = "application/json")
	public String getalipayaccount(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid
			
	) throws Exception{
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		return hospitalPurseService.getAliPayAccount(hosploginid);
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
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name="alipayaccount",required=true,value="支付宝账号")@RequestParam String alipayaccount,
			@ApiParam(name="alipayname",required=true,value="支付宝姓名")@RequestParam String alipayname
	) throws Exception{
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		if (StringUtils.isEmpty(alipayaccount)) {
			return DataResult.error("支付宝账号为空");
		}
		return hospitalPurseService.updateAliPayAccount(hosploginid, alipayaccount,alipayname);
	}
	@RequestMapping(value = "/getbalance", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取账户余额", httpMethod = "POST", notes = "获取账户余额", produces = "application/json")
	public String getBalance(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid
	) throws Exception{
		if (hosploginid == null) {
			return DataResult.error("医院登录id为空");
		}
		return hospitalPurseService.getBalance(hosploginid);
		// TODO Auto-generated method stub

	}
	
	@RequestMapping(value = "/listbalancerecord", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取账户余额变动记录", httpMethod = "POST", notes = "获取账户余额变动记录", produces = "application/json")
	public String listBalanceRecord(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "每页多少数据") @RequestParam(value = "offset") Integer offset
	) throws Exception{
		if (hosploginid == null) {
			return DataResult.error("医院登陆id为空");
		}
		if (!CheckUtils.isPositiveIntegerLegal(limit)) {
			return DataResult.error("limit应为正整数");
		}
		return hospitalPurseService.listBalanceRecord(hosploginid,limit,offset);
		// TODO Auto-generated method stub

	}
	
	@RequestMapping(value = "/listtraderecord", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取交易记录", httpMethod = "POST", notes = "获取交易记录", produces = "application/json")
	public String listTradeRecord(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "每页多少数据") @RequestParam(value = "offset") Integer offset
	) throws Exception{
		if (hosploginid == null) {
			return DataResult.error("医院登陆id为空");
		}
		return hospitalPurseService.listTradeRecord(hosploginid, limit,offset);
	}
	

}
