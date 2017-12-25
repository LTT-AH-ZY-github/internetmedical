package com.medical.controller.doctor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.medical.service.iface.doctor.DoctorHomeService;
import com.medical.utils.CheckUtils;
import com.medical.utils.StringTools;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     DoctorHomeController.java
 * @Description:   医生主页信息 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午9:44:41 
 */
@RestController
@RequestMapping(value = "/doctor")
public class DoctorHomeController {
	@Autowired
	private DoctorHomeService doctorHomeService;
	

	// 获取病情
	@RequestMapping(value = "/listsicks", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情", httpMethod = "POST", notes = "获取病情", produces = "application/json")
	public String listSick(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam(required = true) Integer page,
			@ApiParam(name = "lat", value = "精度") @RequestParam(required = true) String lat,
			@ApiParam(name = "lon", value = "纬度") @RequestParam(required = true) String lon,
			@ApiParam(name = "province", value = "省") @RequestParam(required = false) String province,
			@ApiParam(name = "city", value = "市") @RequestParam(required = false) String city,
			@ApiParam(name = "area", value = "区") @RequestParam(required = false) String area,
			@ApiParam(name = "type", value = "为空时获取推荐病情，为1时获取按时间排序的病情，为2时获取按位置获取的病情") @RequestParam(required = false) Integer type)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("登录id为空");
		}
		if (!CheckUtils.isNonzeroPositiveIntegerLegal(page)) {
			return DataResult.error("当前页有误");
		}
		if (StringUtils.isBlank(lat)) {
			return DataResult.error("经度为空");
		}
		if (StringUtils.isBlank(lon)) {
			return DataResult.error("纬度为空");
		}
		Integer pageSize = 5;
		if (type == null) {
			// 推荐病情
			return doctorHomeService.listSickByRecommend(page, pageSize, docloginid, lat, lon);
		} else {
			if (type == 1) {
				// 按时间排序的病情
				return doctorHomeService.listSickByTime(page, pageSize, docloginid, lat, lon);

			} else if (type == 2) {
				// 按位置查询的病情
				return doctorHomeService.listSickByLoc(page, pageSize, docloginid, lat, lon, province, city, area);
			} else {
				return DataResult.error("type值超出范围");
			}
		}
	}

	// 获取病情详情
	@RequestMapping(value = "/getsickdetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情详情", httpMethod = "POST", notes = "获取病情详情", produces = "application/json")
	public String getsickDeatil(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam(required = false) Integer docloginid,
			@ApiParam(name = "usersickid", required = true, value = "病情id") @RequestParam(required = true) Integer usersickid)
			throws Exception {
		if (usersickid == null) {
			return DataResult.error("病情id为空");
		}
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return doctorHomeService.getSickDetail(docloginid, usersickid);
	}

	// 更换部门
	@RequestMapping(value = "/changedept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更换部门", httpMethod = "POST", notes = "更换部门")
	public String changeDept(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "usersickid", required = true, value = "病情id") @RequestParam Integer usersickid,
			@ApiParam(name = "usersickprimarydept", value = "一级部门") @RequestParam String usersickprimarydept,
			@ApiParam(name = "usersickseconddept", value = "二级部门") @RequestParam(required = false) String usersickseconddept)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (usersickid == null) {
			return DataResult.error("病情id为空");
		}
		if (StringUtils.isBlank(usersickprimarydept)) {
			return DataResult.error("一级部门为空");
		}
		return doctorHomeService.changeDept(docloginid, usersickid, usersickprimarydept, usersickseconddept);

	}

	// 根据医院名迷糊查询医院
	@RequestMapping(value = "/gethospital", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "根据医院名迷糊查询医院", httpMethod = "POST", notes = "根据医院名迷糊查询医院")
	public String getHosptial(
			@ApiParam(name = "hospname", required = true, value = "医院名") @RequestParam String hospname)
			throws Exception {
		if (StringUtils.isBlank(hospname)) {
			return DataResult.error("医院名为空");
		}
		if (StringTools.strLength(hospname)>20) {
			return DataResult.error("医院名长度过长");
		}
		return doctorHomeService.listHospital(hospname);

	}

	// 根据医院id获取医院详细
	@RequestMapping(value = "/gethospitaldetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "根据医院id获取医院详细", httpMethod = "POST", notes = "根据医院id获取医院详细")
	public String getHosptialDetail(
			@ApiParam(name = "hosploginid", required = true, value = "医院id") @RequestParam Integer hosploginid)
			throws Exception {
		if (hosploginid == null) {
			return DataResult.error("医院id为空");
		}
		return doctorHomeService.getHospitalDetail(hosploginid);

	}

	// 根据名字查询医生
	@RequestMapping(value = "/getdoctorbyname", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "根据名字查询医生", httpMethod = "POST", notes = "根据名字查询医生")
	public String getDoctor(@ApiParam(name = "docname", required = true, value = "医生姓名") @RequestParam String docname) throws Exception {
		if (StringUtils.isBlank(docname)) {
			return DataResult.error("医生姓名为空");
		}
		if (StringTools.strLength(docname)>20) {
			return DataResult.error("医生姓名长度过长");
		}
		return  doctorHomeService.getDoctorByName(docname);
		
	}
	
	
}
