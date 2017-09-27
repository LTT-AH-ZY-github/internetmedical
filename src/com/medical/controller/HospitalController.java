package com.medical.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.medical.po.HospSearchDocTerm;
import com.medical.po.Hospitaldept;
import com.medical.service.HospitalService;
import com.medical.utils.result.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import net.sf.json.JSONObject;
/**
 * @author  作者:xyh
 * @date 创建时间：2017年9月15日 上午09:05:48
 * @version 1.0 
 */
@Controller
@RequestMapping(value="/hospital")

public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	@ResponseBody
	@RequestMapping(value="/listdoctor",method = RequestMethod.POST,produces="application/json")
	@ApiOperation(value = "医院根据条件获取医生", httpMethod = "POST", notes = "医院根据条件获取医生",responseContainer="Map",consumes="multipart/form-data",produces="application/json")
	@ApiResponses({ @ApiResponse(code = 400, message = "Invalid Order") })
	public Map<String, Object> listDoctor(@ApiParam(name = "hosploginid",required = true,value = "用户名")  @RequestParam(value="hosploginid")Integer hosploginid,
			@ApiParam(name = "page",required = true,value = "当前页") @RequestParam(value="page") Integer page,
			@ApiParam(name = "hosplevel",required = false,value = "医院等级") @RequestParam(value="hosplevel",required=false)Integer hosplevel,
			@ApiParam(name = "doctortitle",required = false,value = "医生职称") @RequestParam(value="doctortitle",required=false)Integer doctortitle,
			@ApiParam(name = "details",required = false,value = "描述") @RequestParam(value="details",required=false)String details) {
		Map<String, Object> map = new HashMap<>();
		try {
			
			if (page!=null && hosploginid!=null) {
				Integer pageSize = 6;
				HospSearchDocTerm hospSearchDocTerm = new HospSearchDocTerm();
				hospSearchDocTerm.setHospitalLevel(hosplevel);
				hospSearchDocTerm.setDoctorTitle(doctortitle);
			
				Map<String, Object> result = hospitalService.listDoctor(page,pageSize,hospSearchDocTerm);
				if ("1".equals(result.get("state"))) {
					map.put("state", "1");
					map.put("BaseData", result.get("data"));
					PageInfo<Map<String, Object>> pageInfo = (PageInfo<Map<String, Object>>) result.get("page");
					//总共页数
					map.put("allcount", pageInfo.getPages());
					//当前页
					map.put("page", pageInfo.getPageNum());
					/*System.out.println(pageInfo.getPageNum());
				    System.out.println(pageInfo.getPageSize());
				    System.out.println(page.getStartRow());
				    System.out.println(page.getEndRow());
				    System.out.println(page.getTotal());
				    System.out.println(page.getPages());
				    System.out.println(page.getFirstPage());
				    System.out.println(page.getLastPage());
				    System.out.println(page.isHasPreviousPage());
				    System.out.println(page.isHasNextPage());*/
				} else {
					map.put("state", result.get("state"));
				}
			} else {
				List<String> errList = new ArrayList<String>();
				if (page == null ) {
					errList.add("当前页为空"); // 密码为空
				}
				if (hosploginid == null) {
					errList.add("医院id为空"); // 手机号码为空
				}
				map.put("state", "4"); // 请求的数据不完整
				map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;

	}
	@RequestMapping(value="/PreOrderRequest")
	public String PreOrderRequest(@RequestParam Integer docloginid, @RequestParam Integer hosploginid) throws Exception{
		return Result.success("成功");
		
	}
}
