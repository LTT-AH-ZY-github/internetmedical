package com.medical.controller.doctor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.medical.controller.validation.Add;
import com.medical.controller.validation.Update;
import com.medical.po.Doctoraddress;
import com.medical.po.Doctorcalendar;
import com.medical.po.Doctorinfo;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.doctor.DoctorInfoService;
import com.medical.utils.CheckUtils;
import com.medical.utils.StringTools;
import com.medical.utils.TimeUtil;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName: DoctorInfoController.java
 * @Description: 医生信息管理
 * @author xyh
 * @version V1.0
 * @Date 2017年11月27日 下午9:45:12
 */
@RestController
@RequestMapping(value = "/doctor")
public class DoctorInfoController {
	@Autowired
	private DoctorInfoService doctorInfoService;
	@Autowired
	private CommonService commonService;

	// 更新channelId
	@RequestMapping(value = "/updatechannelid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新channelId", httpMethod = "POST", notes = "更新channelId")
	public String updateChannelId(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "channelid", value = "channelid") @RequestParam String channelid) throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (StringUtils.isBlank(channelid)) {
			return DataResult.error("channelid为空");
		}
		return doctorInfoService.updateChannelId(docloginid, channelid);

	}

	// 更新头像
	@RequestMapping(value = "/updatepix", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改头像", httpMethod = "POST", consumes = "multipart/form-data", notes = "修改头像")
	public String addUserInfo(
			@ApiParam(name = "docloginpix", required = true, value = "图片") @RequestParam MultipartFile docloginpix,
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid) throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (docloginpix == null || docloginpix.isEmpty()) {
			return DataResult.error("未选择头像");
		}
		return doctorInfoService.updatePix(docloginid, docloginpix);

	}

	// 获取我的介绍和我的擅长
	@RequestMapping(value = "/getinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取我的介绍和我的擅长", httpMethod = "POST", notes = "获取我的介绍和我的擅长")
	public String getInfo(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return doctorInfoService.getAbsAndExpert(docloginid);
	}

	// 更新我的介绍和我的擅长
	@RequestMapping(value = "/updateinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新我的介绍和我的擅长", httpMethod = "POST", notes = "更新我的介绍和我的擅长")
	public String updateinfo(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "docexpert", value = "擅长") @RequestParam(required = false) String docexpert,
			@ApiParam(name = "docabs", value = "个人简介") @RequestParam(required = false) String docabs) throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (StringUtils.isBlank(docexpert) && StringUtils.isBlank(docabs)) {
			return DataResult.error("所填信息为空");
		}
		if (StringUtils.isNotBlank(docexpert) && StringTools.strLength(docexpert) > 200) {
			return DataResult.error("擅长输入过长");
		}
		if (StringUtils.isNotBlank(docabs) && StringTools.strLength(docabs) > 200) {
			return DataResult.error("个人简介输入过长");
		}
		return doctorInfoService.updateAbsAndExpert(docloginid, docexpert, docabs);
	}

	// 获取第一页个人信息
	@RequestMapping(value = "/getfirstinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取第一页个人信息", httpMethod = "POST", notes = "获取第一页个人信息")
	public String getFirstInfo(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return doctorInfoService.getInfo(docloginid, 1);
	}

	// 获取第二页个人信息
	@RequestMapping(value = "/getsecondinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取第二页个人信息", httpMethod = "POST", notes = "获取第二页个人信息")
	public String getSecondInfo(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return doctorInfoService.getInfo(docloginid, 2);

	}

	// 更新第一页个人信息
	@RequestMapping(value = "/updatefirstinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新第一页个人信息", httpMethod = "POST", notes = "更新第一页个人信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docloginid", required = true, value = "医生登录id", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "dochosp", required = false, value = "医院名称", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "hosplevel", required = false, value = "医院等级", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "dochospprovince", required = false, value = "医院所在省", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "dochospcity", required = false, value = "医院所在市", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "dochosparea", required = false, value = "医院所在区县", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "dochospother", required = false, value = "医院所在具体地址", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "dochosplon", required = false, value = "医院所在地址精度", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "dochosplat", required = false, value = "医院所在地址纬度", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docallday", required = false, value = "是否全天接诊", dataType = "Boolean", paramType = "query"),
			@ApiImplicitParam(name = "docage", required = false, value = "年龄", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "docmale", required = false, value = "性别", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "doccardnum", required = false, value = "身份证号码", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docname", required = false, value = "姓名", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docprimarydept", required = false, value = "一级部门", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docseconddept", required = false, value = "二级部门", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "doctitle", required = false, value = "医生职称", dataType = "String", paramType = "query") })
	public String updateFirstInfo(@ApiIgnore Doctorinfo doctorinfo) throws Exception {

		Integer docloginid = doctorinfo.getDocloginid();
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		String docname = doctorinfo.getDocname();
		System.out.println("姓名" + docname);
		if (docname != null && !CheckUtils.isChineseNameLegal(docname)) {
			return DataResult.error("姓名输入有误");
		}
		String doccardnum = doctorinfo.getDoccardnum();
		if (doccardnum != null && doccardnum.length() != 18) {
			return DataResult.error("身份证输入不合法");
		}
		String docmale = doctorinfo.getDocmale();
		System.out.println("性别" + docmale);
		if (docmale != null && !CheckUtils.isSexLegal(docmale)) {
			return DataResult.error("性别输入不合法");
		}
		Integer docage = doctorinfo.getDocage();
		System.out.println("年龄" + docage);
		if (docage != null && !CheckUtils.isAgeLegal(docage)) {
			return DataResult.error("年龄输入不合法");
		}
		String dochosp = doctorinfo.getDochosp();
		if (dochosp != null && dochosp.trim().length() == 0) {
			return DataResult.error("医院名为空");
		}
		if (dochosp != null && StringTools.strLength(dochosp) > 50) {
			return DataResult.error("医院名超出范围");
		}
		return doctorInfoService.updateNormalInfo(doctorinfo);

	}

	// 更新第二页个人信息
	@RequestMapping(value = "/updatesecondinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新第二页个人信息", httpMethod = "POST", notes = "更新第二页个人信息")
	public String editUserInfo(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "type", value = "照片类型1为身份证照片，2为职称照片，3为行医资格证照片，4为工作证照片，5为其他照片") @RequestParam Integer type,
			@ApiParam(name = "oldpicture", value = "原照片路径") @RequestParam(required = false) String oldpicture,
			@ApiParam(name = "picture", value = "照片") @RequestParam MultipartFile[] picture) throws Exception {
		if (picture == null || picture.length == 0) {
			return DataResult.error("照片为空");
		}
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (type == null || (type < 1 || type > 5)) {
			return DataResult.error("type值不合法");
		}
		return doctorInfoService.updateSomePicture(docloginid, type, oldpicture, picture);
	}

	@RequestMapping(value = "/cancelreview", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "撤销审核", httpMethod = "POST", notes = "撤销审核")
	public String cancelreview(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("id为空");
		}
		return doctorInfoService.updateInfoToCancelReview(docloginid);
	}

	@RequestMapping(value = "/reviewinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "提交审核", httpMethod = "POST", notes = "提交审核")
	public String reviewInfo(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("id为空");
		}
		return doctorInfoService.updateInfoToReview(docloginid);
	}

	@RequestMapping(value = "/getreviewinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取账户状态", httpMethod = "POST", notes = "获取账户状态")
	public String getreviewInfo(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("id为空");
		}
		return doctorInfoService.getReviewInfo(docloginid);
	}

	// 获取常用地址
	@RequestMapping(value = "/getaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取常用地址", httpMethod = "POST", notes = "获取常用地址", produces = "application/json")
	public String getAddress(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(required = true) Integer page)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生id为空");
		}
		if (!CheckUtils.isPageLegal(page)) {
			return DataResult.error("当前页有误");
		}
		return doctorInfoService.listAddress(docloginid, page);
	}

	// 获取全部常用地址
	@RequestMapping(value = "/getalladdress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取全部常用地址", httpMethod = "POST", notes = "获取全部常用地址", produces = "application/json")
	public String getAllAddress(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return doctorInfoService.listAllAddress(docloginid);

	}

	// 添加常用地址
	@RequestMapping(value = "/addaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "添加常用地址", httpMethod = "POST", notes = "添加常用地址", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docloginid", required = true, value = "医生登录id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "docaddresslocation", required = true, value = "地点名称", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "docaddressprovince", required = true, value = "省", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddresscity", required = true, value = "市", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddressarea", required = false, value = "区", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddressother", required = false, value = "详细地址", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddresslon", required = true, value = "经度", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddresslat", required = true, value = "纬度", dataType = "String", paramType = "query") })
	public String addAddress(@ApiIgnore @Validated(Add.class) Doctoraddress doctoraddress, BindingResult bindingResult)
			throws Exception {
		if (bindingResult.hasErrors()) {
			return DataResult.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return doctorInfoService.addAddress(doctoraddress);

	}

	@RequestMapping(value = "/editaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改地址信息", httpMethod = "POST", notes = "修改地址信息", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docloginid", required = true, value = "医生登录id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "docaddressid", required = true, value = "地址id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "docaddresslocation", required = false, value = "地点名称", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "docaddressprovince", required = false, value = "省", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddresscity", required = false, value = "市", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddressarea", required = false, value = "区县", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddressother", required = false, value = "详细地址", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddresslon", required = false, value = "经度", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddresslat", required = false, value = "纬度", dataType = "String", paramType = "query") })
	public String editAddress(@ApiIgnore @Validated(Update.class) Doctoraddress doctoraddress,
			BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			return DataResult.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return doctorInfoService.updateAddress(doctoraddress);

	}

	// 删除常用地址
	@RequestMapping(value = "/deleteaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除常用地址", httpMethod = "POST", notes = "删除常用地址", produces = "application/json")
	public String deleteAddress(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "docaddressid", required = true, value = "地址id") @RequestParam(required = true) Integer docaddressid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生id为空");
		}
		if (docaddressid == null) {
			return DataResult.error("医生地址id为空");
		}
		return doctorInfoService.delAddress(docloginid, docaddressid);
	}

	// 设置坐诊地点
	@RequestMapping(value = "/setaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "设置坐诊地点", httpMethod = "POST", notes = "设置坐诊地点", produces = "application/json")
	public String setAddress(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "docaddressid", required = true, value = "地址id") @RequestParam(required = true) Integer docaddressid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (docaddressid == null) {
			return DataResult.error("医生地址id为空");
		}
		return doctorInfoService.updateAddressToCheck(docloginid, docaddressid);
	}

	// 获取日程表
	@RequestMapping(value = "/getcalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取日程表", httpMethod = "POST", notes = "获取日程表", produces = "application/json")
	public String getCalendar(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(required = true) Integer page)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (!CheckUtils.isPageLegal(page)) {
			return DataResult.error("当前页有误");
		}
		return doctorInfoService.listCalendars(docloginid, page);

	}

	@RequestMapping(value = "/getcalendarbymonth", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "按月份获取日程表", httpMethod = "POST", notes = "按月份获取日程表", produces = "application/json")
	public String getCalendarbymonth(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "year", value = "年") @RequestParam(required = true) String year,
			@ApiParam(name = "month", value = "月") @RequestParam(required = true) String month) throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (StringUtils.isBlank(year)) {
			return DataResult.error("年为空");
		}
		if (StringUtils.isBlank(month)) {
			return DataResult.error("月为空");
		}
		return doctorInfoService.listCalendarsByMonth(docloginid, year, month);
	}

//	@RequestMapping(value = "/addcalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//	@ApiOperation(value = "设置日程表", httpMethod = "POST", notes = "设置日程表", produces = "application/json")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "docloginid", required = true, value = "医生登录id", dataType = "int", paramType = "query"),
//			@ApiImplicitParam(name = "doccalendarday", required = true, value = "时间(格式如2017-01-02)", dataType = "Date", paramType = "query"),
//			@ApiImplicitParam(name = "doccalendartime", required = true, value = "上午或者下午", dataType = "String", paramType = "query"),
//			@ApiImplicitParam(name = "doccalendaraffair", required = false, value = "事件", dataType = "String", paramType = "query"),
//			@ApiImplicitParam(name = "doccalendaradressid", required = true, value = "地址id", dataType = "int", paramType = "query"), })
//	public String addCalendar(@ApiIgnore @Validated(Add.class) Doctorcalendar doctorcalendar,
//			BindingResult bindingResult) throws Exception {
//		if (bindingResult.hasErrors()) {
//			return DataResult.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
//		}
//		String doccalendaraffair = doctorcalendar.getDoccalendaraffair();
//		if (doccalendaraffair != null && StringTools.strLength(doccalendaraffair) > 200) {
//			DataResult.error("事件超出长度限制");
//		}
//		return doctorInfoService.addCalendar(doctorcalendar);
//	}
	
	@RequestMapping(value = "/addcalendar ", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "设置日程表", httpMethod = "POST", notes = "设置日程表", produces = "application/json")
	public String addCalendar(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "doccalendarday", value = "时间数组(格式如2017-01-02)") @RequestParam(required = false) Date[] doccalendarday,
			@ApiParam(name = "doccalendardays", value = "时间数组(格式如2017-01-02)") @RequestParam(required = false) String doccalendardays,
			@ApiParam(name = "doccalendarprice", value = "出诊价格") @RequestParam(required = false) BigDecimal doccalendarprice,
			@ApiParam(name = "doccalendaraffair", value = "备注") @RequestParam(required = false) String doccalendaraffair,
			@ApiParam(name = "doccalendaradressid", value = "地址id") @RequestParam Integer doccalendaradressid,
			@ApiParam(name = "doccalendarmorning", value = "上午时间段，没有则为空") @RequestParam(required = false) String doccalendarmorning,
			@ApiParam(name = "doccalendarafternoon", value = "下午时间段，没有则为空") @RequestParam(required = false) String doccalendarafternoon,
			@ApiParam(name = "doccalendarnight", value = "晚上时间段，没有则为空") @RequestParam(required = false) String doccalendarnight
			) throws Exception {
		if (docloginid==null) {
			return DataResult.error("医生登录id为空");
		}
		boolean DataIsEmpty = doccalendarday==null || doccalendarday.length==0;
		boolean DataIsEmpty2 = StringUtils.isBlank(doccalendardays);
		if (DataIsEmpty && DataIsEmpty2) {
			return DataResult.error("时间为空");
		}
		if (DataIsEmpty && !DataIsEmpty2) {
			List<Date> list = new ArrayList<Date>();  
	        String [] doccalendardayStr = doccalendardays.split(",");
			for (String string : doccalendardayStr) {
				list.add(TimeUtil.strLongToDate(string));
			}
			int size = list.size();
			doccalendarday = (Date[]) list.toArray( new Date[size]);
		}
		if (doccalendaradressid==null) {
			return DataResult.error("地址为空");
		}
		if (StringUtils.isBlank(doccalendarmorning) && StringUtils.isBlank(doccalendarafternoon) && StringUtils.isBlank(doccalendarnight)) {
			DataResult.error("时间段不可全为空");
		}
		if (doccalendaraffair != null && StringTools.strLength(doccalendaraffair) > 200) {
			DataResult.error("事件超出长度限制");
		}
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
//		String dstr="2018-01-10";  
//		String dstr2="2018-4-25";
//		String dstr3="2018-4-26";
//		String dstr4="2018-4-27";
//		 Date[] day = {sdf.parse(dstr),sdf.parse(dstr2),sdf.parse(dstr3),sdf.parse(dstr4)};
		return doctorInfoService.addCalendar(docloginid,doccalendarday,doccalendarprice,doccalendaraffair,doccalendaradressid,doccalendarmorning,doccalendarafternoon,doccalendarnight);
	}

	// 修改日程
	@RequestMapping(value = "/editcalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改日程", httpMethod = "POST", notes = "修改日程", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docloginid", required = true, value = "医生登录id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "doccalendarid", required = true, value = "日程id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "doccalendarday", required = false, value = "时间(格式如2017-01-02)", dataType = "Date", paramType = "query"),
			@ApiImplicitParam(name = "doccalendartimeinterval", required = false, value = "时间区间", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "doccalendaraffair", required = false, value = "事件", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "doccalendaradressid", required = false, value = "地址id", dataType = "int", paramType = "query"), 
			@ApiImplicitParam(name = "doccalendarprice", required = false, value = "出诊费用", dataType = "BigDecimal", paramType = "query"),})
	public String editCalendar(@ApiIgnore @Validated(Update.class) Doctorcalendar doctorcalendar,
			BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			return DataResult.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		String doccalendaraffair = doctorcalendar.getDoccalendaraffair();
		if (doccalendaraffair != null && StringTools.strLength(doccalendaraffair) > 200) {
			DataResult.error("事件超出长度限制");
		}
		return doctorInfoService.updateCalendar(doctorcalendar);
	}

	// 删除日程
	@RequestMapping(value = "/deletecalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除日程", httpMethod = "POST", notes = "删除日程", produces = "application/json")
	public String deleteCalendar(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "doccalendarid", value = "日程id") @RequestParam(required = true) Integer doccalendarid)
			throws Exception {
		if (docloginid == null) {
			return DataResult.error("医生id为空");
		}
		return doctorInfoService.deleteCalendar(doccalendarid, docloginid);
	}

	// 获取科室
	@RequestMapping(value = "/getdept", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取科室", httpMethod = "GET", notes = "获取科室")
	public String getDept() throws Exception {
		return commonService.listDepts();
	}

	// 新增科室
	@RequestMapping(value = "/adddept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "新增科室", httpMethod = "POST", notes = "新增科室")
	public String addDept(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "primarydept", value = "一级部门") @RequestParam(required = false) String primarydept,
			@ApiParam(name = "seconddept", value = "二级部门") @RequestParam(required = false) String seconddept)
			throws Exception {
		if (primarydept != null && primarydept.trim().length() == 0) {
			DataResult.error("一级部门不可为空格");
		}
		if (primarydept != null && StringTools.strLength(primarydept) > 20) {
			DataResult.error("一级部门超出长度限制");
		}
		if (seconddept != null && seconddept.trim().length() == 0) {
			DataResult.error("二级部门不可为空格");
		}
		if (seconddept != null && StringTools.strLength(seconddept) > 20) {
			DataResult.error("二级部门超出长度限制");
		}
		return commonService.addDept(docloginid, primarydept, seconddept);
	}

	@RequestMapping(value = "/updateprice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "设置医生出诊总价", httpMethod = "POST", notes = "设置医生出诊总价")
	public String updateFee(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "docprice", required = true, value = "医生出诊总价") @RequestParam(required = true) BigDecimal docprice)
			throws Exception {
		if (docloginid == null) {
			DataResult.error("医生登录id为空");
		}
		if (docprice == null) {
			DataResult.error("医生出诊总价为空");
		}

		return doctorInfoService.updateFee(docloginid, docprice);
	}

	@RequestMapping(value = "/getprice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取医生出诊总价", httpMethod = "POST", notes = "获取医生出诊总价")
	public String getfee(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid)
			throws Exception {
		if (docloginid == null) {
			DataResult.error("医生登录id为空");
		}
		return doctorInfoService.getFee(docloginid);
	}
}
