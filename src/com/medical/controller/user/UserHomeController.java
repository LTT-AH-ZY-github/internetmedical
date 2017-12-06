package com.medical.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medical.po.DoctorSearch;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.user.UserHomeService;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName: UserHomeController.java
 * @Description: 用户主页
 * @author xyh
 * @version V1.0
 * @Date 2017年11月27日 上午10:47:30
 */

@RestController
@RequestMapping(value = "/user")
public class UserHomeController {
	@Autowired
	private CommonService commonService;
	@Autowired
	private UserHomeService userHomeService;

	/**
	 * @Title: getDept
	 * @Description: 获取科室
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/getdept", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取科室", httpMethod = "GET", notes = "获取科室")
	public String getDept() throws Exception {
		return commonService.getDept();
	}

	/**
	 * @Title: findDoctors
	 * @Description: 获取医生列表模式
	 * @param page
	 * @param userloginlon
	 * @param userloginlat
	 * @param dochospprovince
	 * @param dochospcity
	 * @param dochosparea
	 * @param docprimarydept
	 * @param docseconddept
	 * @param type
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/listdoctors", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生列表模式", httpMethod = "POST", consumes = "multipart/form-data", notes = "获取医生列表模式")
	public @ResponseBody String findDoctors(@ApiParam(name = "page", value = "当前页") @RequestParam Integer page,
			@ApiParam(name = "userloginlon", value = "经度") @RequestParam(value = "userloginlon") String userloginlon,
			@ApiParam(name = "userloginlat", value = "纬度") @RequestParam(value = "userloginlat") String userloginlat,
			@ApiParam(name = "dochospprovince", value = "省") @RequestParam(required = false) String dochospprovince,
			@ApiParam(name = "dochospcity", value = "市") @RequestParam(required = false) String dochospcity,
			@ApiParam(name = "dochosparea", value = "区县") @RequestParam(required = false) String dochosparea,
			@ApiParam(name = "docprimarydept", value = "一级部门") @RequestParam(required = false) String docprimarydept,
			@ApiParam(name = "docseconddept", value = "二级部门") @RequestParam(required = false) String docseconddept,
			@ApiParam(name = "type", value = "为空时获取推荐医生，为1时获取按科室获取，2时获取按位置获取") @RequestParam(required = false) Integer type)
			throws Exception {
		if (page == null) {
			return DataResult.error("当前页为空");

		}
		if (page != null && page < 1) {
			return DataResult.error("当前页应为大于0的整数");
		}
		if (userloginlat == null) {
			return DataResult.error("纬度为空");
		}
		if (userloginlon == null) {
			return DataResult.error("经度为空");
		}
		DoctorSearch doctorSearch = new DoctorSearch();
		doctorSearch.setPageNo(page);
		doctorSearch.setPageSize(10);
		doctorSearch.setLat(userloginlat);
		doctorSearch.setLon(userloginlon);
		doctorSearch.setProvince(dochospprovince);
		doctorSearch.setCity(dochospcity);
		doctorSearch.setArea(dochosparea);
		doctorSearch.setPrimaryDept(docprimarydept);
		doctorSearch.setSecondDept(docseconddept);
		doctorSearch.setType(type);
		return userHomeService.listDoctor(doctorSearch);
	}

	/**
	 * @Title: findDoctorInMap
	 * @Description:获取医生地图模式
	 * @param userloginlon
	 * @param userloginlat
	 * @return
	 * @throws Exception
	 * @return: String
	 */

	@RequestMapping(value = "/mapdoctors", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生地图模式", httpMethod = "POST", notes = "获取医生地图模式")
	public @ResponseBody String findDoctorInMap(
			@ApiParam(name = "userloginlon", value = "精度") @RequestParam(value = "userloginlon") String userloginlon,
			@ApiParam(name = "userloginlat", value = "纬度") @RequestParam(value = "userloginlat") String userloginlat)
			throws Exception {
		if (StringUtils.isBlank(userloginlon)) {
			return DataResult.error("精度为空");
		}
		if (StringUtils.isBlank(userloginlat)) {
			return DataResult.error("纬度为空");
		}
		return userHomeService.findDoctorsInMap(userloginlat, userloginlon);

	}

	/**
	 * @Title: findDoctor
	 * @Description: 获取医生详细信息
	 * @param docloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/doctorinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生详细信息", httpMethod = "POST", notes = "获取医生详细信息")
	public String findDoctor(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生id为空");

		}
		return userHomeService.findDoctorDetail(docloginid);
	}

	/**
	 * @Title: getCalendarbymonth
	 * @Description: 获取医生日程
	 * @param docloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/getcalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生当天后30天内日程", httpMethod = "POST", notes = "获取医生当天后30天内日程", produces = "application/json")
	public String getCalendarbymonth(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid

	) throws Exception {
		return userHomeService.listCalendar(docloginid);
	}

	/**
	 * @Title: getEvaluation
	 * @Description: 获取医生评价
	 * @param docloginid
	 * @param page
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/getevaluation", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生评价", httpMethod = "POST", notes = "获取医生评价")
	public String getEvaluation(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam Integer page) throws Exception {
		if (docloginid != null && page != null) {
			if (page < 0) {
				return DataResult.error("当前页应大于0");
			}
			return userHomeService.getEvaluation(docloginid, page);

		} else {
			List<String> errList = new ArrayList<String>();
			if (docloginid == null) {
				errList.add("医生登录id为空");
			}
			if (page == null) {
				errList.add("当前页为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}

}
