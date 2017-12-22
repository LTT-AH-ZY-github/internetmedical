/**  
* @Title: HospitalUnitPriceController.java  
* @Package com.medical.controller.hopital  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月11日  
* @version V1.0  
*/  
package com.medical.controller.hopital;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.medical.controller.validation.Add;
import com.medical.controller.validation.Update;
import com.medical.po.Hospitalunitprice;
import com.medical.service.iface.hospital.HospitalUnitPriceService;
import com.medical.utils.CheckUtils;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     HospitalUnitPriceController.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月11日 下午5:02:11 
 */
@RestController
@RequestMapping(value = "/hospital")
public class HospitalUnitPriceController {
	@Autowired
	private HospitalUnitPriceService  hospitalUnitPriceService;
	
	@RequestMapping(value = "/unitpriceset", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "新增", httpMethod = "POST", notes = "新增")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "unitpricename", value = "名称", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "unitpricenumber", value = "价格", required = true, dataType = "double", paramType = "query"),
		@ApiImplicitParam(name = "unitpriceabs", value = "简介", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "unitpriceoperatetime", value = "时间", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "hosploginid", value = "医院登录id", required = true, dataType = "int", paramType = "query")
	})
	public String unitpriceset(@ApiIgnore  @Validated(Add.class) Hospitalunitprice hospitalunitprice, BindingResult bindingResult
			) throws Exception{
		if (bindingResult.hasErrors()) {
			return DataResult.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return hospitalUnitPriceService.creatUnitPrice(hospitalunitprice); 
	}
	
	@RequestMapping(value = "/getunitpricelist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取", httpMethod = "POST", notes = "获取")
	public String getunitpricelist(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几个数据开始") @RequestParam(value = "offset") Integer offset) throws Exception{
		if (hosploginid==null) {
			return DataResult.error("医院登录id为空");
		}
		if (!CheckUtils.isNonzeroPositiveIntegerLegal(limit)) {
			return DataResult.error("limit应为非零正整数");
		}
		if (!CheckUtils.isPositiveIntegerLegal(offset)) {
			return DataResult.error("offset应为正整数");
		}
		return hospitalUnitPriceService.listUnitPrice(hosploginid,limit,offset); 
	}
	
	@RequestMapping(value = "/editunitprice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改", httpMethod = "POST", notes = "修改")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "unitpricename", value = "名称", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "unitpricenumber", value = "价格", required = false, dataType = "double", paramType = "query"),
		@ApiImplicitParam(name = "unitpriceabs", value = "简介", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "unitpriceoperatetime", value = "时间", required = false, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "unitpriceid", value = "单价id", required = true, dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "hosploginid", value = "医院登录id", required = true, dataType = "int", paramType = "query")
	})
	public String editunitprice(@ApiIgnore @Validated(Update.class) Hospitalunitprice hospitalunitprice, BindingResult bindingResult
			) throws Exception{
		if (bindingResult.hasErrors()) {
			return DataResult.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return hospitalUnitPriceService.updateUnitPrice(hospitalunitprice); 
	}
	
	@RequestMapping(value = "/deleteunitprice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除", httpMethod = "POST", notes = "删除")
	public String deleteunitprice(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "unitpriceid", required = true, value = "单价id") @RequestParam Integer unitpriceid
			) throws Exception{
		if (hosploginid==null) {
			return DataResult.error("医院登录id为空");
		}
		if (unitpriceid==null) {
			return DataResult.error("单价id为空");
		}
		return hospitalUnitPriceService.deleteUnitPrice(hosploginid,unitpriceid); 
	}
}
