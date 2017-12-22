package com.medical.controller.doctor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.medical.service.iface.doctor.DoctorPurseService;
import com.medical.utils.CheckUtils;
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
			@ApiParam(name="alipayaccount",value="支付宝账号")@RequestParam(required=false) String alipayaccount,
			@ApiParam(name="alipayname",value="支付宝账号")@RequestParam(required=false) String alipayname
			) throws Exception{
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (StringUtils.isBlank(alipayaccount) && StringUtils.isBlank(alipayname)) {
			return DataResult.error("支付宝账号和姓名不可同时为空");
		}
		return doctorPurseService.updateAliPayAccount(docloginid, alipayaccount,alipayname);
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
		if (!CheckUtils.isPageLegal(page)) {
			return DataResult.error("当前页有误");
		}
		return doctorPurseService.listBalanceRecord(docloginid,page);
		

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
		if (!CheckUtils.isPageLegal(page)) {
			return DataResult.error("当前页有误");
		}
		return doctorPurseService.listTradeRecord(docloginid, page);
		
	}
	
	@RequestMapping(value = "/listtraderecordbyorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "根据病人订单获取交易记录", httpMethod = "POST", notes = "根据病人订单获取交易记录", produces = "application/json")
	public String listTradeRecordByOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "userorderid", required = true, value = "订单id") @RequestParam Integer userorderid
		
	) throws Exception{
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (userorderid==null) {
			return DataResult.error("订单id为空");
		}
		return doctorPurseService.listTradeRecordByOrder(docloginid, userorderid);
		// TODO Auto-generated method stub

	}
	
	@RequestMapping(value = "/listtraderecordbyconsultation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "根据会诊订单获取交易记录", httpMethod = "POST", notes = "根据会诊订单获取交易记录", produces = "application/json")
	public String listtraderecordbyconsultation(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "hosporderid", required = true, value = "会诊订单id") @RequestParam Integer hosporderid
	) throws Exception{
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (hosporderid==null) {
			return DataResult.error("会诊订单id为空");
		}
		return doctorPurseService.listTradeRecordByConsultation(docloginid, hosporderid);
		

	}
	
}
