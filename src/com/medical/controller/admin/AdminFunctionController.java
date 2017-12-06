/**
 * 
 */
package com.medical.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.service.iface.admin.AdminFunctionService;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     AdminFunctionController.java
 * @Description:   管理员功能 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午3:32:37 
 */
@RestController
@RequestMapping(value="/admin")
public class AdminFunctionController {
	@Autowired
	private AdminFunctionService adminFunctionService;
	
	
	@RequestMapping(value="/listuser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取用户",httpMethod="POST",notes="获取用户")
	public String listUserTocCheck(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset,
			@ApiParam(name = "type", value = "为空时获取全部用户，为1时获取未审核的用户，为2时获取待审核的用户，为3时获取审核通过的用户，为4时获取未通过审核的用户") @RequestParam(required=false) Integer type
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminFunctionService.listUser(adminloginid, limit, offset, type);
	}
	@RequestMapping(value="/getuserdetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取用户详情",httpMethod="POST",notes="获取用户详情")
	public String getUserDetail(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		if (userloginid==null) {
			return DataResult.error("用户id为空");
		}
		return adminFunctionService.getUserDetail(adminloginid,userloginid);
	}
	
	@RequestMapping(value="/checkuser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="审核用户",httpMethod="POST",notes="审核用户")
	public String checkuser(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "type", value = "账户状态1代表通过审核，2代表为通过审核") @RequestParam Boolean type
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		if (userloginid==null) {
			return DataResult.error("用户id为空");
		}
		if (type==null) {
			return DataResult.error("审核状态为空");
		}
		return adminFunctionService.updateUserType(adminloginid,userloginid,type);
	}
	
	@RequestMapping(value="/listdoctor", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取医生",httpMethod="POST",notes="获取用户")
	public String listDoctorTocCheck(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset,
			@ApiParam(name = "type", value = "为空时获取全部医生，为1时获取未审核的医生，为2时获取待审核的医生，为3时获取审核通过的医生，为4时获取未通过审核的医生") @RequestParam(required=false) Integer type
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminFunctionService.listDoctor(adminloginid, limit, offset, type);
	}
	
	@RequestMapping(value="/getdoctordetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取用户详情",httpMethod="POST",notes="获取用户详情")
	public String getDoctorDetail(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		if (docloginid==null) {
			return DataResult.error("医生id为空");
		}
		return adminFunctionService.getDoctorDetail(adminloginid,docloginid);
	}
	
	@RequestMapping(value="/checkdoctor", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="审核医生",httpMethod="POST",notes="审核医生")
	public String checkDoctor(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "type", value = "账户状态1代表通过审核，2代表为通过审核") @RequestParam Boolean type
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		if (docloginid==null) {
			return DataResult.error("医生id为空");
		}
		if (type==null) {
			return DataResult.error("审核状态为空");
		}
		return adminFunctionService.updateDoctorType(adminloginid,docloginid,type);
	}
	
	@RequestMapping(value="/listhospital", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取医院",httpMethod="POST",notes="获取用户")
	public String listhospitalTocCheck(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset,
			@ApiParam(name = "type", value = "为空时获取全部医院，为1时获取未审核的医院，为2时获取待审核的医院，为3时获取审核通过的医院，为4时获取未通过审核的医院") @RequestParam(required=false) Integer type
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminFunctionService.listHospital(adminloginid, limit, offset, type);
	}
	
	@RequestMapping(value="/gethospitaldetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取用户详情",httpMethod="POST",notes="获取用户详情")
	public String gethospitalDetail(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "hosploginid", value = "医院登录id") @RequestParam Integer hosploginid
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		if (hosploginid==null) {
			return DataResult.error("医生id为空");
		}
		return adminFunctionService.getHospitalDetail(adminloginid,hosploginid);
	}
	@RequestMapping(value="/checkhospital", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="审核医院",httpMethod="POST",notes="审核医生")
	public String checkHospital(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "hosploginid", value = "医生登录id") @RequestParam Integer hosploginid,
			@ApiParam(name = "type", value = "账户状态1代表通过审核，2代表为通过审核") @RequestParam Boolean type
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		if (hosploginid==null) {
			return DataResult.error("医院id为空");
		}
		if (type==null) {
			return DataResult.error("审核状态为空");
		}
		return adminFunctionService.updateHospitalType(adminloginid,hosploginid,type);
	}
	
	@RequestMapping(value="/listdept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取医院部门",httpMethod="POST",notes="获取医院部门")
	public String listDeptToCheck(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "limit", required = true, value = "每页多少数据") @RequestParam(value = "limit") Integer limit,
			@ApiParam(name = "offset", required = true, value = "从第几条开始") @RequestParam(value = "offset") Integer offset,
			@ApiParam(name = "check", value = "为空时获取全部1代表已审核，2代表未审核") @RequestParam(required=false) Integer check
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminFunctionService.listDept(adminloginid, limit, offset,check);
	}
	@RequestMapping(value="/listfirstdept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="获取医院部门",httpMethod="POST",notes="获取医院部门")
	public String listfirstdept(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid
			
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		return adminFunctionService.listFirstDept(adminloginid);
	}
	@RequestMapping(value="/checkdept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value="审核部门",httpMethod="POST",notes="审核部门")
	public String checkDept(
			@ApiParam(name = "adminloginid", value = "管理员登录id") @RequestParam Integer adminloginid,
			@ApiParam(name = "hospdeptid", value = "部门id") @RequestParam Integer hospdeptid,
			@ApiParam(name = "hospfatherdeptid", value = "一级部门id,如审核为一级部门,父部门id为0") @RequestParam(value="hospfatherdeptid") Integer hospdeptfatherid
			)throws Exception{
		if (adminloginid==null) {
			return DataResult.error("管理员id为空");
		}
		if (hospdeptid==null) {
			return DataResult.error("部门id为空");
		}
		if (hospdeptfatherid==null) {
			return DataResult.error("一级部门id为空");
		}
		if (hospdeptfatherid!=null && hospdeptfatherid<0) {
			return DataResult.error("一级部门id不合法");
		}
		return adminFunctionService.checkDept(adminloginid,hospdeptid,hospdeptfatherid);
	}

}
