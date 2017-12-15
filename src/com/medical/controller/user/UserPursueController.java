package com.medical.controller.user;

import static org.junit.Assert.fail;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.service.iface.user.UserPurseService;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     UserPursueController.java
 * @Description:   用户钱包管理
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 上午10:48:51 
 */
@RestController
@RequestMapping(value = "/user")
public class UserPursueController {
	@Autowired
	private UserPurseService userPursueService;
	
	/**
	 * @return 
	 * @Title: pub
	 * @Description: TODO
	 * @return: void
	 */
	/*@RequestMapping(value = "/getbalance", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取账户余额", httpMethod = "POST", notes = "获取账户余额", produces = "application/json")
	public String getBalance(
			@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam(value = "userloginid") Integer userloginid
	) throws Exception{
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		return userPursueService.getBalance(userloginid);
		// TODO Auto-generated method stub

	}
	*/
	/*@RequestMapping(value = "/listbalancerecord", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取账户余额变动记录", httpMethod = "POST", notes = "获取账户余额变动记录", produces = "application/json")
	public String listBalanceRecord(
			@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam(value = "userloginid") Integer userloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam Integer page
	) throws Exception{
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
	 
		return userPursueService.listBalanceRecord(userloginid,page);
		// TODO Auto-generated method stub

	}*/
	@RequestMapping(value = "/getalipayaccount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取支付宝账号", httpMethod = "POST", notes = "获取支付宝账号", produces = "application/json")
	public String getBalance(
			@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam(value = "userloginid") Integer userloginid
	) throws Exception{
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		return userPursueService.getAliPayAccount(userloginid);
		

	}
	@RequestMapping(value = "/updatealipayaccount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新用户绑定的支付宝账号", httpMethod = "POST", notes = "更新用户绑定的支付宝账号", produces = "application/json")
	public String updatealipayaccount(
			@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam(value = "userloginid") Integer userloginid,
			@ApiParam(name="alipayaccount",value="支付宝账号")@RequestParam(required =false) String alipayaccount,
			@ApiParam(name="alipayname",value="支付宝账号")@RequestParam(required =false) String alipayname
			) throws Exception{
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (StringUtils.isBlank(alipayaccount) && StringUtils.isBlank(alipayname)) {
			return DataResult.error("支付宝账号和姓名不可同时为空");
		}
		return userPursueService.updateAliPayAccount(userloginid, alipayaccount,alipayname);
	}
	@RequestMapping(value = "/listtraderecord", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取交易记录", httpMethod = "POST", notes = "获取交易记录", produces = "application/json")
	public String listTradeRecord(
			@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam(value = "userloginid") Integer userloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam Integer page
	) throws Exception{
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		return userPursueService.listTradeRecord(userloginid, page);
		// TODO Auto-generated method stub

	}
	
}
