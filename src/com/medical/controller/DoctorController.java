package com.medical.controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.medical.po.Doctoraddress;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Userorder;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.doctor.DoctorAccountService;
import com.medical.service.iface.doctor.DoctorHomeService;
import com.medical.service.iface.doctor.DoctorInfoService;
import com.medical.service.iface.doctor.DoctorOrderService;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.PaginationResult;
import com.medical.utils.result.Result;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author  作者:xyh
 * @date 创建时间：2017年7月18日 上午09:05:48
 * @version 1.0 
 */
@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorAccountService doctorAccountService;
	@Autowired
	private DoctorInfoService doctorInfoService;
	@Autowired
	private DoctorHomeService doctorHomeService;
	@Autowired
	private DoctorOrderService doctorOrderService;
	@Autowired
	private CommonService commonService;

	// 判断手机号码是否注册
	@RequestMapping(value = "/phonetest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "判断手机号码是否注册,替换/phone", httpMethod = "POST", notes = "判断手机号码是否注册")
	public String phoneTest(@ApiParam(name = "docloginphone", value = "手机号码") @RequestParam String docloginphone)
			throws Exception {
		if (StringUtils.isNotBlank(docloginphone)) {
			if (docloginphone.trim().length() != 11) {
				return Result.error("该手机号码不是11位");
			}
			boolean result = commonService.findAccountExit(docloginphone);
			if (result) {
				return Result.error("该号码已注册");
			} else {
				return Result.success("该号码未注册");
			}
		} else {
			return Result.error("手机号码为空");
		}

	}
	
	//发送短信验证码
	@RequestMapping(value = "/getmsgcode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "发送短信验证码,替换/getcode", httpMethod = "POST", notes = "发送短信验证码")
	public String getMsgCode(@ApiParam(name = "docloginphone",value="手机号码") @RequestParam String docloginphone) throws Exception {
		if (StringUtils.isNotBlank(docloginphone)) {
			if (docloginphone.trim().length() != 11) {
				return Result.error("该手机号码不是11位");
			}
			boolean result = commonService.getMsgCode(docloginphone);
			if (result) {
				return Result.success("获取验证码成功");
			} else {
				return Result.error("获取短信验证码失败");
			}
		} else {
			return Result.error("手机号码为空");
		}
		

	}
	
	/*// 注册
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> userRegister(@RequestBody Map<String, String> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String phone = params.get("phone");
		String password = params.get("password");
		String code = params.get("code");
		if (phone != null && phone.trim() != "" && password != null && password.trim() != "" && code!=null && code.trim()!="") {
			if (MsgCode.checkMsg(phone, code)) {
			if (true) {
				int result = doctorService.createDoctor(phone,"1", password);
				map.put("state", result+""); //  1表示成功 2表示失败 3该号码已注册 4 操作异常
			} else {
				map.put("state", "5"); // 5 验证码错误
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (phone == null || phone.trim() == "") {
				errList.add("密码为空"); // 密码为空
			}
			if (password == null || password.trim() == "") {
				errList.add("手机号码为空"); // 手机号码为空
			}
			if (code == null || code.trim() == "") {
				errList.add("验证码为空"); // 手机号码为空
			}
			map.put("state", "6"); // 请求的数据不完整
			map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息

		}
		return map;
	}*/

	// 注册
	@RequestMapping(value = "/docregister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "注册,替换/register", httpMethod = "POST", notes = "注册")
	public String doctorRegister(@ApiParam(name = "docloginphone", value = "手机号码") @RequestParam String docloginphone,
			@ApiParam(name = "docloginpwd", value = "密码") @RequestParam String docloginpwd,
			@ApiParam(name = "code", value = "短信验证码") @RequestParam String code) throws Exception {
		if (StringUtils.isNotBlank(docloginphone) && StringUtils.isNotEmpty(docloginpwd) && StringUtils.isNotBlank(code)) {
			int result = doctorAccountService.createDoctor(docloginphone, code, docloginpwd);
			if (1 == result) {
				return DataResult.success("注册成功");
			} else if (2 == result) {
				return DataResult.error("注册失败");
			} else {
				return DataResult.error("该号码已注册");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (StringUtils.isBlank(docloginphone)) {
				errList.add("手机号码为空");
			}
			if (StringUtils.isEmpty(docloginpwd)) {
				errList.add("密码为空");
			}
			if (StringUtils.isBlank(code)) {
				errList.add("验证码为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}

	}

	// 环信注册
	@RequestMapping(value = "/huanxinregister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "环信注册", httpMethod = "POST", consumes = "application/x-www-form-urlencoded", notes = "环信注册")
	public String huanXinRegister(
			@ApiParam(name = "docloginid", required = true, value = "用户登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "docloginpwd", value = "密码") @RequestParam String docloginpwd)
					throws Exception {
		if (docloginid != null) {
			boolean result = doctorAccountService.addHuanXinAccout(docloginid,docloginpwd);
			if (result) {
				return DataResult.success("注册成功");
			} else {
				return DataResult.error("注册失败");
			}
		} else {
			return DataResult.error("id为空");
		}

	}
	
	// 登录
	@RequestMapping(value = "/doclogin", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生登录,替换/login", httpMethod = "POST", notes = "医生登录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docloginphone", required = true, value="手机号码",dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docloginpwd", required = true, value="密码",dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "doclogintoken", required = false, value="token",dataType = "String", paramType = "query") })
	public String doctorLogin(@ApiIgnore Doctorlogininfo doctorlogininfo) throws Exception {
		String docloginphone = doctorlogininfo.getDocloginphone();
		String docloginpwd  = doctorlogininfo.getDocloginpwd();
		if (docloginphone!=null&& docloginphone.trim().length()!=0 && docloginpwd!=null && docloginpwd.trim().length()!=0) {
			Map<String, Object> result = doctorAccountService.updateDoctorToLogin(doctorlogininfo);
			if ("1".equals(result.get("state"))) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("token", result.get("token"));
				map.put("name", result.get("name"));
				map.put("pix", result.get("pix"));
				map.put("type", result.get("type"));
				map.put("id", result.get("id"));
				return DataResult.success("登录成功", map);
			} else if ("2".equals(result.get("state"))) {
				return DataResult.error("登录失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.error("当前token不存在");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("token已过期");
			} else if ("4".equals(result.get("state"))) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("token", result.get("token"));
				map.put("name", result.get("name"));
				map.put("pix", result.get("pix"));
				map.put("type", result.get("type"));
				map.put("id", result.get("id"));
				return DataResult.success("自动登录成功", map);
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("自动登录失败");
			} else if ("7".equals(result.get("state"))) {
				return DataResult.error("用户账号密码不匹配");
			}else if ("8".equals(result.get("state"))) {
				return DataResult.error("该号码未注册");
			} else {
				return DataResult.error("操作异常");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (docloginphone == null || docloginphone.trim() == "") {
				errList.add("手机号码为空");
			}
			if (docloginpwd == null || docloginpwd.trim() == "") {
				errList.add("密码为空"); 
			}
			return DataResult.error( errList.toString().replace("[", "").replace("]", ""));
		}
		
	}

	// 更新channelId
	@RequestMapping(value = "/updatechannelid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新channelId", httpMethod = "POST", notes = "更新channelId")
	public String updateChannelId(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "channelid", value = "channelid") @RequestParam String channelid) throws Exception {

		if (docloginid != null && channelid!=null && channelid.length()!=0) {
			int result = doctorAccountService.updateChannelId(docloginid, channelid);
			if (result==1) {
				return DataResult.success("更新成功");
			} else if (result==2){
				return DataResult.error("更新失败,未知错误");
			} else if (result==3){
				return DataResult.error("医生不存在");
			} else {
				return DataResult.error("更新失败,异常错误");
			}

		} else {
			List<String> errList = new ArrayList<String>();
			if (docloginid == null ) {
				errList.add("登录id为空");
			}
			if (channelid == null || channelid.trim().length() == 0) {
				errList.add("channelid为空"); 
			}
			return DataResult.error( errList.toString().replace("[", "").replace("]", ""));

		}
	}
	
	// 获取第一页个人信息
	@RequestMapping(value = "/getfirstinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取第一页个人信息,替换/getfirstinfo", httpMethod = "POST", notes = "获取第一页个人信息")
	public String getFirstInfo2(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid!=null) {
			Map<String, Object> result = doctorInfoService.getInfo(docloginid, 1);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("获取数据成功", result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("获取数据失败,因对应数据为空");
			} else {
				return DataResult.error("操作异常");

			}
		} else {
			return DataResult.error("医生登录id为空");
		}
		
	}

	// 获取第二页个人信息
	@RequestMapping(value = "/getsecondinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取第二页个人信息", httpMethod = "POST", notes = "获取第二页个人信息")
	public String getSecondInfo2(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid)
			throws Exception {
		if (docloginid != null) {
			Map<String, Object> result = doctorInfoService.getInfo(docloginid, 2);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("获取数据成功", result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("获取数据为空");
			} else {
				return DataResult.error("操作异常");

			}
		} else {
			return DataResult.error("医生登录id为空");
		}

	}
	
	// 更新第一页个人信息
	@RequestMapping(value = "/updatefirstinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新第一页个人信息", httpMethod = "POST", notes = "更新第一页个人信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "docloginid", required = true, value="医生登录id",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochosp", required = false, value="医院名称",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "hosplevel", required = false, value="医院等级",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochospprovince", required = false, value="医院所在省",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochospcity", required = false, value="医院所在市",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochosparea", required = false, value="医院所在区县",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochospother", required = false, value="医院所在具体地址",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochosplon", required = false, value="医院所在地址精度",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "dochosplat", required = false, value="医院所在地址纬度",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docallday", required = false,value="是否全天接诊", dataType = "Boolean", paramType = "query"),
		@ApiImplicitParam(name = "docage", required = false, value="年龄",dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "docmale", required = false, value="性别",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "doccardnum", required = false,value="身份证号码", dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docname", required = false, value="姓名",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docprimarydept", required = false, value="一级部门",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docseconddept", required = false,value="二级部门", dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "doctitle", required = false, value="医生职称",dataType = "String", paramType = "query")
		}
	)
	public String updateFirstInfo(@ApiIgnore Doctorinfo doctorinfo)
			throws Exception {
		Integer docloginid = doctorinfo.getDocloginid();
		if (docloginid!=null) {
			int result = doctorInfoService.updateInfo(doctorinfo);
			if (result==1) {
				return DataResult.success("修改资料成功");
			} else if (result==2) {
				return DataResult.error("修改数据失败");
			} else  if (result==3) {
				return DataResult.error("登录id对应的个人记录为空");
			} else if (result==4) {
				return DataResult.error("已被审核,个人信息不可修改");
			} else if (result==5) {
				return DataResult.error("登录id对应的信息为空");
			} else{
				return DataResult.error("操作异常");

			}
		} else {
			return DataResult.error("医生登录id为空");
		}
		
	}
	
	
	// 传图片
	@RequestMapping(value = "/updatesecondinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新第二页个人信息", httpMethod = "POST", notes = "更新第二页个人信息")
	public String editUserInfo(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "type", value = "照片类型1为身份证照片，2为职称照片，3为行医资格证照片，4为工作证照片，5为其他照片") @RequestParam Integer type,
			@ApiParam(name = "oldpicture", value = "原照片路径") @RequestParam(required = false) String oldpicture,
			@ApiParam(name = "picture", value = "照片")@RequestParam MultipartFile[] picture) throws Exception {
		if (picture.length > 0 && docloginid != null && type != null) {
			if (type>0 && type <6) {
				int result = doctorInfoService.updateSecondInfo(docloginid, type, oldpicture, picture);
				if (result == 1) {
					return DataResult.success("上传成功");
				} else if (result == 2) {
					return DataResult.error("上传失败");
				} else if (result == 3) {
					return DataResult.error("修改数据失败,路径创建失败");
				} else if (result == 4) {
					return DataResult.error("已被审核,个人信息不可修改");
				} else {
					return DataResult.error("登录id对应的信息为空");
				}
				
			} else {
				return DataResult.error("type超出范围");
			}
				

			} else {
				List<String> errList = new ArrayList<String>();
				if (docloginid == null) {
					errList.add("id为空"); 
				}
				
				if (type == null) {
					errList.add("type为空"); 
				}
				if (picture.length == 0) {
					errList.add("照片为空"); 
				}
				return DataResult.error(errList.toString().replace("[", "").replace("]", "")); // 错误信息
			}
	}

	/*// 获取推荐病情
	@RequestMapping(value = "/getresick")
	public Map<String, Object> getReSick(@RequestBody Map<String, Integer> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = params.get("id");
		Integer page = params.get("page");
		if (id != null && page!=null) {
			Map<String, Object> list = doctorService.getReSick(id,page);
			if ("1".equals(list.get("state"))) {
				map.put("state", "1"); // 成功
				map.put("data", list.get("data"));
			} else {
				map.put("state", list.get("state"));
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (id == null) {
				errList.add("id为空"); // id为空
			}
			if (page == null) {
				errList.add("当前页数为空"); // 手机号码为空
			}
			map.put("state", "5"); // 请求的数据不完整
			map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
		}
		return map;
	}*/

	/*// 获取病情按时间排序
	@RequestMapping(value = "getsickbytime", method = RequestMethod.POST)
	public Map<String, Object> getSickByTime(@RequestBody Map<String, Integer> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = params.get("id");
		Integer page = params.get("page");
		if (id != null && page != null) {
			Map<String, Object> result = doctorService.getSickByTime(id, page);
			if ("1".equals(result.get("state"))) {
				map.put("state", "1");
				map.put("data", result.get("data"));
			} else {
				map.put("state", result.get("state"));
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (id == null) {
				errList.add("id为空"); // id为空
			}
			if (page == null) {
				errList.add("当前页数为空"); // 手机号码为空
			}
			map.put("state", "5"); // 请求的数据不完整
			map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
		}

		return map;

	}*/

	/*// 获取病情按城市排序
	@RequestMapping(value = "/getsickbyloc", method = RequestMethod.POST)
	public Map<String, Object> getSickByCity(@RequestBody Map<String, Object> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer id = (Integer) params.get("id");
			Integer page = (Integer) params.get("page");
			String loc = (String) params.get("loc");
			if (id != null && page != null && loc != null && loc.trim() != "") {
				Map<String, Object> result = doctorService.getSickByLoc(id, page, loc);
				if ("1".equals(result.get("state"))) {
					map.put("state", "1");
					map.put("data", result.get("data"));
				} else {
					map.put("state", result.get("state"));
				}
			} else {
				List<String> errList = new ArrayList<String>();
				if (id == null) {
					errList.add("id为空"); // id为空
				}
				if (page == null) {
					errList.add("当前页数为空"); // 当前页数为空
				}
				if (loc != null && loc.trim() != "") {
					errList.add("当前位置为空"); // 当前位置为空
				}
				map.put("state", "5"); // 请求的数据不完整
				map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
			}

		} catch (Exception e) {
			map.put("state", "6"); // 接收数据类型错误
		}

		return map;

	}*/

	// 获取病情详细
	/*@RequestMapping(value = "/sickdetail")
	public Map<String, Object> getSickDetail(@RequestBody Map<String, Integer> params) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = params.get("id");
		if (id != null) {
			Map<String, Object> data = doctorService.getSickDetail(id);
			if ("1".equals(data.get("state"))) {
				map.put("state", "1");
				map.put("data", data.get("data"));
			} else {
				map.put("state", data.get("state"));
			}

		} else {
			map.put("state", "7"); // id为空
		}
		return map;
	}
*/
	// 获取病人头像
/*	@RequestMapping(value = "/getuserpix", method = RequestMethod.POST)
	public Map<String, Object> getPix(@RequestBody Map<String, Integer> params) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		//病情id
		Integer id = params.get("id");
		if (id!=null) {
			map.put("state", "1"); //请求成功
			System.out.println("2222");
		} else {
			map.put("state", "7");
		}
		return map;
	}*/
	//获取科室
	@RequestMapping(value = "/getdept", method = RequestMethod.GET)
	public Map<String, Object> getDept() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> result = doctorInfoService.getDept();
		if ("1".equals(result.get("state"))) {
			map.put("state", "1"); // 请求成功
			map.put("data", result.get("data"));
		} else {
			map.put("state", result.get("state"));
		}
		return map;
	}
/*	//获取科室
	@RequestMapping(value = "/getfatherdept", method = RequestMethod.GET)
	public Map<String, Object> getSonDept() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> result = doctorService.getDeptByFatherId(0);
		if ("1".equals(result.get("state"))) {
			map.put("state", "1"); //请求成功
			map.put("data", result.get("data")); 
		} else {
			map.put("state", "2");
		}
		return map;
	}
	*/
	/*//获取科室
	@RequestMapping(value = "/getsondept", method = RequestMethod.POST)
	public Map<String, Object> getSonDept(@RequestBody Map<String, Integer> params) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = params.get("id");
		if (id != null) {
			Map<String, Object> result = doctorService.getDeptByFatherId(id);
			if ("1".equals(result.get("state"))) {
				map.put("state", "1"); //请求成功
				map.put("data", result.get("data")); 
			} else {
				map.put("state", "2");
			}
		} else {
			map.put("state", "7"); // id为空
		}
		return map;
		
	}*/
	/*// 获取日程表
	@RequestMapping(value="/getschedule")
	public Map<String, Object> getSchedule(@RequestBody Map<String, Integer> params) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Integer docLoginId = params.get("docloginid");
		if (docLoginId!=null) {
			Map<String, Object> result = doctorService.getSchedule(docLoginId);
			if ("1".equals(result.get("state"))) {
				map.put("state", "1"); //请求成功
				map.put("data", result.get("data")); 
				map.put("docskdid", result.get("id"));
			} else {
				map.put("state",result.get("state"));
			}
		} else {
			//医生登录id为空
			map.put("state", "4");
		}
		return map;
	}*/
	/*//设置日程
	@RequestMapping(value="/schedule")
	public Map<String, Object> updateSchedule(@Valid Doctorskd doctorskd,BindingResult bindingResult){
		Map<String, Object> map = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			List<String> errList = new ArrayList<String>();
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				errList.add(objectError.getDefaultMessage());
			}
			map.put("state", "5"); // 请求的数据不完整
			map.put("msg", errList.toString().replace("[", "").replace("]", "")); // 错误信息
		} else {
			int result = doctorService.updateSchedule(doctorskd);
			//"1"更新日程成功
			//"2"更新日程失败
			//"3"该id对应的日程为空
			//"4"操作异常
			map.put("state", result+"");
			
		}
		return map;
	}*/
	
	// 获取常用地址
	@RequestMapping(value = "/getaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取常用地址", httpMethod = "POST", notes = "获取常用地址", produces = "application/json")
	public String getAddress(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(required = true) Integer page) {
		Map<String, Object> result = doctorInfoService.getAddress(docloginid,page);
		if ("1".equals(result.get("state"))) {
			return PaginationResult.success("获取数据成功", result.get("data"));
		} else if ("2".equals(result.get("state"))) {
			return PaginationResult.success("获取数据为空",null);
		} else {
			return DataResult.error("异常错误");
		}

	}
	
	//添加常用地址
	@RequestMapping(value="/addaddress", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "添加常用地址", httpMethod = "POST", notes = "添加常用地址",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "docloginid",required = true,value ="医生登录id",dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "docaddresslocation",required = true,value ="地点名称",dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "docaddressprovince",required = true,value ="省",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docaddresscity",required = true,value ="市",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docaddressarea",required = true,value ="区",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docaddressother",required = true,value ="详细地址",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docaddresslon",required = true,value ="经度",dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "docaddresslat",required = true,value ="纬度",dataType = "String", paramType = "query")
		 })
	public String addAddress( @ApiIgnore Doctoraddress doctoraddress ){
		int result = doctorInfoService.addAddress(doctoraddress);
		if (result==1) {
			return DataResult.success("新增成功");
		} else if (result==2) {
			return DataResult.error("新增失败");
		} else if (result==3) {
			return DataResult.error("新增失败,该医生不存在");
		} else {
			return DataResult.error("新增失败,异常错误");
		} 
	}

	// 修改常用地址
	@RequestMapping(value = "/editaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改常用地址", httpMethod = "POST", notes = "修改常用地址", produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docloginid", required = true, value = "医生登录id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "docaddressid", required = true, value = "地址id", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "docaddresslocation",required = false,value ="地点名称",dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "docaddressprovince", required = false, value = "省", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddresscity", required = false, value = "市", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddressarea", required = false, value = "区县", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddressother", required = false, value = "详细地址", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddresslon", required = false, value = "经度", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "docaddresslat", required = false, value = "纬度", dataType = "String", paramType = "query") })
	public String editAddress(@ApiIgnore Doctoraddress doctoraddress) {
		int result = doctorInfoService.editAddress(doctoraddress);
		if (result == 1) {
			return DataResult.success("修改成功");
		} else if (result == 2) {
			return DataResult.error("修改失败");
		} else if (result == 3) {
			return DataResult.error("默认地址不可修改");
		} else if (result == 4) {
			return DataResult.error("修改失败,该地址不属于该医生");
		} else if (result == 5) {
			return DataResult.error("修改失败,该地址不存在");
		} else {
			return DataResult.error("修改失败,异常错误");
		}
	}

	// 删除常用地址
	@RequestMapping(value = "/deleteaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除常用地址", httpMethod = "POST", notes = "删除常用地址", produces = "application/json")
	public String deleteAddress(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "docaddressid", required = true, value = "地址id") @RequestParam(required = true) Integer docaddressid) {
		int result = doctorInfoService.delAddress(docloginid, docaddressid);
		if (result == 1) {
			return DataResult.success("删除成功");
		} else if (result == 2) {
			return DataResult.error("删除失败");
		} else if (result == 3) {
			return DataResult.error("删除失败,该地址正在使用");
		}  else if (result == 4) {
			return DataResult.error("删除失败,该地址不属于该医生");
		}  else if (result == 5) {
			return DataResult.error("默认地址不可删除");
		} else if (result == 6) {
			return DataResult.error("删除失败,该地址不存在");
		} else {
			return DataResult.error("删除失败,异常错误");
		}
	}
	
	//设置坐诊地点
	@RequestMapping(value = "/setaddress", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "设置坐诊地点", httpMethod = "POST", notes = "设置坐诊地点", produces = "application/json")
	public String setAddress(
				@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
				@ApiParam(name = "docaddressid", required = true, value = "地址id") @RequestParam(required = true) Integer docaddressid) {
			int result = doctorInfoService.updateAddress(docloginid, docaddressid);
			if (result == 1) {
				return DataResult.success("设置成功");
			} else if (result == 2) {
				return DataResult.error("设置失败");
			} else if (result == 3) {
				return DataResult.error("该地址已被设置为当前坐诊位置");
			}  else if (result == 4) {
				return DataResult.error("该地址不属于该医生");
			}  else if (result == 5) {
				return DataResult.error("该地址不存在");
			} else  {
				return DataResult.error("删除失败,异常错误");
			}
	}

	// 获取日程表
	@RequestMapping(value = "/getcalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取日程表", httpMethod = "POST", notes = "获取日程表", produces = "application/json")
	public String getCalendar(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(required = true) Integer page) {
		Map<String, Object> result = doctorInfoService.getCalendar(docloginid,page);
		if ("1".equals(result.get("state"))) {
			return PaginationResult.success("获取数据成功", result.get("data"));
		} else if ("2".equals(result.get("state"))) {
			return PaginationResult.success("获取数据为空",null);
		} else {
			return DataResult.error("异常错误");
		}

	}

	// 新增日程表
	@RequestMapping(value = "/addcalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "设置日程表", httpMethod = "POST", notes = "设置日程表", produces = "application/json")
	public String addCalendar(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "doccalendarday", required = true, value = "时间") @RequestParam(required = true) Date doccalendarday,
			@ApiParam(name = "doccalendartime", required = true, value = "上午或者下午") @RequestParam(required = true) String doccalendartime,
			@ApiParam(name = "doccalendaraffair", required = true, value = "事件") @RequestParam(required = true) String doccalendaraffair,
			@ApiParam(name = "doccalendaradressid", required = true, value = "地址id") @RequestParam(required = true) Integer doccalendaradressid
			) {
		 	int result = doctorInfoService.addCalendar(docloginid, doccalendarday, doccalendartime, doccalendaraffair,
					doccalendaradressid);
			if (result == 1) {
				return DataResult.success("新增成功");
			} else if (result == 2) {
				return DataResult.error("新增失败");
			} else if (result == 3) {
				return DataResult.error("当天日程已被设置");
			} else {
				return DataResult.error("新增失败,异常错误");
			}
		
	}

	// 修改日程
	@RequestMapping(value = "/editcalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改日程", httpMethod = "POST", notes = "修改日程", produces = "application/json")
	public String editCalendar(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "doccalendarid", value = "日程id") @RequestParam Integer doccalendarid,
			@ApiParam(name = "doccalendarday",  value = "时间") @RequestParam(required = false) Date doccalendarday,
			@ApiParam(name = "doccalendartime", value = "上午或者下午") @RequestParam(required = false) String doccalendartime,
			@ApiParam(name = "doccalendaraffair",  value = "事件") @RequestParam(required = false) String doccalendaraffair,
			@ApiParam(name = "doccalendaradressid",  value = "地址id") @RequestParam(required = false) Integer doccalendaradressid
			) {

		int result = doctorInfoService.editCalendar(doccalendarid, docloginid, doccalendarday, doccalendartime,
				doccalendaraffair, doccalendaradressid);
		if (result == 1) {
			return DataResult.success("修改成功");
		} else if (result == 2) {
			return DataResult.error("修改失败");
		} else if (result == 3) {
			return DataResult.error("该日程不属于该医生");
		} else if (result == 4) {
			return DataResult.error("该日程不存在");
		} else {
			return DataResult.error("异常错误");
		}

	}

	// 删除日程
	@RequestMapping(value = "/deletecalendar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除日程", httpMethod = "POST", notes = "删除日程", produces = "application/json")
	public String deleteCalendar(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(required = true) Integer docloginid,
			@ApiParam(name = "doccalendarid", value = "日程id") @RequestParam(required = true) Integer doccalendarid) {
		int result = doctorInfoService.deleteCalendar(doccalendarid, docloginid);
		if (result == 1) {
			return DataResult.success("删除成功");
		} else if (result == 2) {
			return DataResult.error("删除失败");
		} else if (result == 3) {
			return DataResult.success("删除成功");
		} else if (result == 4) {
			return DataResult.error("删除失败");
		} else if (result == 5) {
			return DataResult.error("该日程不属于该医生");
		} else if (result == 6) {
			return DataResult.error("该日程不存在");
		} else {
			return DataResult.error("异常错误");
		}

	}

	// 获取病情
	@RequestMapping(value = "/listsicks", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情", httpMethod = "POST", notes = "获取病情",produces="application/json")
	public String listSick(@ApiParam(name = "docloginid",required = true,value ="医生登录id")@RequestParam(required=true) Integer docloginid,
			@ApiParam(name = "page",value ="当前页")@RequestParam(required=true) Integer page,
			@ApiParam(name = "lat",value ="精度")@RequestParam(required=true) String lat,
			@ApiParam(name = "lon",value ="纬度")@RequestParam(required=true) String lon,
			@ApiParam(name = "time",value ="时间")@RequestParam(required=false) String time,
			@ApiParam(name = "province",value ="省")@RequestParam(required=false) String province,
			@ApiParam(name = "city",value ="市")@RequestParam(required=false) String city,
			@ApiParam(name = "area",value ="区")@RequestParam(required=false) String area
			
			) throws Exception {
		   Integer pageSize = 5;
			Map<String, Object> result = doctorHomeService.listSick(page, pageSize, docloginid,lat, lon,time,province,city,area);
			if ("1".equals(result.get("state"))) {
				return PaginationResult.success("推荐病情获取成功", result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return PaginationResult.error("推荐病情获取失败,因数据为空",null);
			} else if ("3".equals(result.get("state"))) {
				return PaginationResult.success("按时间排序病情获取成功", result.get("data"));
			} else if ("4".equals(result.get("state"))) {
				return PaginationResult.error("获取失败");
			} else if ("5".equals(result.get("state"))) {
				return PaginationResult.success("按距离排序病情获取成功", result.get("data"));
			} else if ("6".equals(result.get("state"))) {
				return PaginationResult.error("获取失败");
			} else if ("7".equals(result.get("state"))) {
				return PaginationResult.error("查询个人信息为空");
			}else {
				return DataResult.error("异常错误");
			}		

	}
	
	//获取病情详情
	@RequestMapping(value = "/getsickdetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情详情", httpMethod = "POST", notes = "获取病情详情", produces = "application/json")
	public String getsickDeatil(
			@ApiParam(name = "usersickid", required = true, value = "病情id") @RequestParam(required = true) Integer usersickid

	) throws Exception {

		Map<String, Object> result = doctorHomeService.getSickDetail(usersickid);
		if ("1".equals(result.get("state"))) {
			return DataResult.success("病情详情获取成功", result.get("data"));
		} else if ("2".equals(result.get("state"))) {
			return DataResult.success("数据为空",null);
		} else {
			return DataResult.error("异常错误");
		}

	}
	
	// 医生抢单
	@RequestMapping(value = "/graborder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生抢单", httpMethod = "POST", notes = "医生抢单", produces = "application/json")
	public String grabOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "usersickid", required = true, value = "病情id") @RequestParam(value = "usersickid") Integer usersickid,
			@ApiParam(name = "preorderprice", value = "预估价格") @RequestParam(required = false) Double preorderprice) throws Exception {
		if (docloginid != null && usersickid != null) {
			Map<String, Object> result = doctorOrderService.creatPreOrder(usersickid, docloginid, preorderprice);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("操作成功,且消息发送成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.error("操作成功，但消息推送失败", result.get("msg"));
			} else if ("3".equals(result.get("state"))) {
				return DataResult.error("操作成功，消息推送获取用户信息获取数据失败");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("抢单失败");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("抢单失败，已抢单");
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("查询病情失败");
			} else {
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (docloginid == null) {
				errList.add("医生登录id为空"); // id为空
			}
			if (usersickid == null) {
				errList.add("病情id为空"); // 手机号码为空
			}
			return DataResult.error( errList.toString().replace("[", "").replace("]", ""));
		}
	}
	
	//获取已抢订单
	@RequestMapping(value = "/listgraborders", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取已抢订单", httpMethod = "POST", notes = "获取已抢订单", produces = "application/json")
	public String listGrabOrders(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page",required = true,value ="当前页" )@RequestParam(value="page") Integer page
			) {
		Map<String, Object> result = doctorOrderService.listGrabOrders(docloginid,page,5);
		if ("1".equals(result.get("state"))) {
			return DataResult.success("获取成功",result.get("data"));
		} else if ("2".equals(result.get("state"))) {
			return DataResult.success("数据为空",null);
		}else {
			return DataResult.error("异常错误");
		}

	}
	//获取已抢订单
	@RequestMapping(value = "/getgraborder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取已抢订单详情", httpMethod = "POST", notes = "获取已抢订单详情", produces = "application/json")
	public String getGrabOrder(
			@ApiParam(name = "preorderid", required = true, value = "登录id") @RequestParam(value = "preorderid") Integer preorderid) {
		Map<String, Object> result = doctorOrderService.getGrabOrderDetail(preorderid);
		if ("1".equals(result.get("state"))) {
			return DataResult.success("获取成功", result.get("data"));
		} else if ("2".equals(result.get("state"))) {
			return DataResult.success("数据为空",null);
		} else {
			return DataResult.error("异常错误");
		}

	}
	
	// 医生取消抢单
	@RequestMapping(value = "/cancelgraborder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生取消抢单", httpMethod = "POST", notes = "医生取消抢单")
	public String cancelOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "preorderid",required = true,value ="预订单id" )@RequestParam(value="preorderid") Integer preorderid) throws Exception {
		if (preorderid != null) {
			Map<String, Object> result = doctorOrderService.deletePreOrder(docloginid,preorderid);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("取消成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("取消成功,但消息发送失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.success("取消成功,但消息发送失败");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("取消抢单失败");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("预订单信息和医生信息不符");
			}  else if ("6".equals(result.get("state"))) {
				return DataResult.error("预订单id对应数据为空");
			}else {
				return DataResult.error("异常错误");
			}
		} else {
			// 预订单id为空
			return DataResult.error("预订单id为空");
		}
	}

	// 医生获取订单
	@RequestMapping(value = "/getorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取订单", httpMethod = "POST", notes = "医生获取订单")
	public String getorder(
			@ApiParam(name = "docloginid", required = true, value = "医生登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page,
			@ApiParam(name = "type", value = "订单类型，为空获取全部,1代表等待病人确认的订单，2代表正在进行的") @RequestParam(required=false) Integer type)
			throws Exception {
		if (docloginid!=null && page!=null) {
			if (type!=null && type>2) {
				return DataResult.error("type值超出范围");
			}
			Map<String, Object> resultMap = doctorOrderService.listOrder(docloginid,type, page, 5);
			if ("1".equals(resultMap.get("state"))) {
				return DataResult.success("获取成功", resultMap.get("data"));

			} else if ("2".equals(resultMap.get("state"))) {
				return DataResult.success("获取的数据为空",null);

			} else {
				return DataResult.error("操作异常");
			}
		}else {
			List<String> errList = new ArrayList<String>();
			if (page == null) {
				errList.add("当前页为空");
			}
			if (docloginid == null) {
				errList.add("医生id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
		

	}
	
	//医生获取等待确认订单
	@RequestMapping(value="/listordertoconfirm",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取等待确认订单", httpMethod = "POST", notes = "医生获取等待确认订单")
	public String listOrderToConfirm(@ApiParam(name = "docloginid",required = true,value ="登录id" )@RequestParam(value="docloginid") Integer docloginid,
							@ApiParam(name = "page",required = true,value ="当前页" )@RequestParam(value="page") Integer page
			)throws Exception{
		Map<String, Object> resultMap = doctorOrderService.listOrder(docloginid,3,page,5);
		if ("1".equals(resultMap.get("state"))) {
			return DataResult.success("获取成功", resultMap.get("data"));

		} else if ("2".equals(resultMap.get("state"))) {
			return DataResult.success("获取的数据为空",null);

		} else{
			return DataResult.error("操作异常");
		}
		
	}

/*	// 医生获取正在进行订单
	@RequestMapping(value = "/listorderinpro", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取正在进行订单", httpMethod = "POST", notes = "医生获取正在进行订单")
	public String listOnOrderInPro(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page)
			throws Exception {
		Map<String, Object> resultMap = doctorService.listOrder(docloginid,2, page, 5);
		if ("1".equals(resultMap.get("state"))) {
			return DataResult.success("获取成功", resultMap.get("data"));

		} else if ("2".equals(resultMap.get("state"))) {
			return DataResult.error("获取的数据为空");

		} else {
			return DataResult.error("操作异常");
		}

	}*/
/*
	// 医生获取全部订单
	@RequestMapping(value = "/listallorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取全部订单", httpMethod = "POST", notes = "医生获取全部订单")
	public String listAllOrder(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "page", required = true, value = "当前页") @RequestParam(value = "page") Integer page)
			throws Exception {
		Map<String, Object> resultMap = doctorService.listOrder(docloginid,3, page, 5);
		if ("1".equals(resultMap.get("state"))) {
			return DataResult.success("获取成功", resultMap.get("data"));

		} else if ("2".equals(resultMap.get("state"))) {
			return DataResult.error("获取的数据为空");

		} else {
			return DataResult.error("操作异常");
		}

	}*/
	
	//医生获取订单详情
	@RequestMapping(value = "/getorderdetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生获取订单详情", httpMethod = "POST", notes = "医生获取订单详情")
	public String getOrderDetail(
			@ApiParam(name = "docloginid", required = true, value = "登录id") @RequestParam(value = "docloginid") Integer docloginid,
			@ApiParam(name = "userorderid", required = true, value = "订单id") @RequestParam(value = "userorderid") Integer userorderid)
			throws Exception {
		Map<String, Object> resultMap = doctorOrderService.getOrderDetail(docloginid,userorderid);
		if ("1".equals(resultMap.get("state"))) {
			return DataResult.success("获取成功", resultMap.get("data"));
		} else if ("2".equals(resultMap.get("state"))) {
			return DataResult.success("请求成功,但数据为空",null);
		} else {
			return DataResult.error("操作异常");
		}

	}
	
	//根据医院名迷糊查询医院
	@RequestMapping(value="/gethospital",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ApiOperation(value = "根据医院名迷糊查询医院", httpMethod = "POST", notes = "根据医院名迷糊查询医院")
	public String getHosptial(@ApiParam(name = "hospname", required = true, value = "医院名") @RequestParam String hospname) throws Exception{
		if (hospname!=null) {
			Map<String, Object> result = doctorOrderService.getHospital(hospname);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("请求成功", result.get("data"));
			} else if ("2".equals(result.get("state"))){
				return DataResult.success("请求成功,但数据为空",null);
			}else {
				return DataResult.error("操作异常");
			}
		} else {
			return DataResult.error("医院名为空");
		}
	}
	
	//根据名字查询医生
	@RequestMapping(value = "/getdoctorbyname", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "根据名字查询医生", httpMethod = "POST", notes = "根据名字查询医生")
	public String getDoctor(
			@ApiParam(name = "docname", required = true, value = "医生姓名") @RequestParam String docname
			) {
		if (docname != null && docname.trim().length()!=0) {
			Map<String, Object> result = doctorOrderService.getDoctorByName(docname);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("获取数据成功",result.get("data"));
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("获取数据成功,但数据为空");
			} else  {
				return DataResult.error("异常错误");
			}
		} else {
			return DataResult.error("医生姓名为空");
		}
	}
	
	// 医生拒绝接单
	@RequestMapping(value = "/refuseorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生拒绝接单", httpMethod = "POST", notes = "医生拒绝接单")
	public String refuseOrder(
			@ApiParam(name = "docloginid", required = true, value = "医生登陆id") @RequestParam Integer docloginid,
			@ApiParam(name = "userorderid", required = true, value = "订单id") @RequestParam Integer userorderid,
			@ApiParam(name = "redocloginid", value = "推荐医生登陆id") @RequestParam(required = false) Integer redocloginid) throws Exception {
		if (docloginid != null && userorderid != null) {
			Map<String, Object> result = doctorOrderService.updateOrderToRefuse(docloginid, userorderid, redocloginid);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("拒绝接单成功,且消息发送成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("拒绝接单成功,但消息发送失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.error("拒绝接单失败，未知错误");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("病情不存在，拒绝接单失败");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("该状态不支持拒绝接单");
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("医生与订单不匹配");
			} else if ("7".equals(result.get("state"))) {
				return DataResult.error("订单不存在");
			} else if ("8".equals(result.get("state"))) {
				return DataResult.error("拒绝接单失败,因推荐医生失败");
			} else if ("9".equals(result.get("state"))) {
				return DataResult.error("拒绝接单失败,因该医生已被推荐");
			} else if ("10".equals(result.get("state"))) {
				return DataResult.error("拒绝接单失败,因该推荐医生不存在");
			} else {
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userorderid == null) {
				errList.add("订单id为空");
			}
			if (docloginid == null) {
				errList.add("医生id为空");
			}
			return DataResult.error(errList.toString().replace("[", "").replace("]", ""));
		}
	}
	
	//医生确认订单
	@RequestMapping(value="/confirmorder",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生确认订单", httpMethod = "POST", notes = "医生确认订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "docloginid",required = true,value ="医生登录id",dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "userorderid",required = true,value ="订单id",dataType = "int", paramType = "query"),
		@ApiImplicitParam(name = "userorderdprice",required = false,value ="医生价格",dataType = "Double", paramType = "query"),
		@ApiImplicitParam(name = "userordertpricetype",required = true,value ="交通类型",dataType = "int", paramType = "query" ),
		@ApiImplicitParam(name = "userordertprice",required = false,value ="交通价格" ,dataType = "Double", paramType = "query"),
		@ApiImplicitParam(name = "userorderapricetype",required = true,value ="住宿类型",dataType = "int", paramType = "query" ),
		@ApiImplicitParam(name = "userorderaprice",required = false,value ="住宿价格" ,dataType = "Double", paramType = "query"),
		@ApiImplicitParam(name = "userorderepricetype",required = true,value ="餐饮类型",dataType = "int", paramType = "query" ),
		@ApiImplicitParam(name = "userordereprice",required = false,value ="住宿价格",dataType = "Double", paramType = "query" )
		 })
	public String confirmOrder(@ApiIgnore Userorder userorder,@ApiIgnore Integer docloginid)throws Exception{
		Integer userorderid = userorder.getUserorderid();
		Integer userordertpricetype = userorder.getUserordertpricetype();
		Integer userorderapricetype= userorder.getUserorderapricetype();
		Integer userorderepricetype= userorder.getUserorderepricetype();
		if (userorderid!=null && userordertpricetype!=null && userorderapricetype!=null&& userorderepricetype!=null) {
			Map<String, Object> result = doctorOrderService.updateOrderConfirm(userorder);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("操作成功,且消息发送成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("操作成功，但消息推送失败",result.get("msg"));
			} else if ("3".equals(result.get("state"))) {
				return DataResult.success("操作成功，消息推送获取用户信息获取数据失败");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("确认失败");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("该状态不支持确认");
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("查询病情失败");
			} else{
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userorderid == null) {
				errList.add("订单id为空"); 
			}
			if (userordertpricetype == null) {
				errList.add("交通类型为空"); 
			}
			if (userorderepricetype == null) {
				errList.add("餐饮类型为空");
			}
			return DataResult.error( errList.toString().replace("[", "").replace("]", ""));
		}
		
	
	}
	
	//医生取消订单
	@RequestMapping(value = "/cancelorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生取消订单", httpMethod = "POST", notes = "医生取消订单")
	public String cancel(
			@ApiParam(name = "docloginid",required = true,value ="医生登陆id" )@RequestParam Integer docloginid,
			@ApiParam(name = "userorderid",required = true,value ="订单id" )@RequestParam Integer userorderid) throws Exception {
		if (docloginid != null && userorderid!=null) {
			Map<String, Object> result = doctorOrderService.updateOrderToCancle(docloginid,userorderid);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("取消成功,且消息发送成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("取消成功,但消息发送失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.success("取消失败，未知错误");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("病情不存在，取消失败");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("该状态不支持取消");
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("医生与订单不匹配");
			} else if ("7".equals(result.get("state"))) {
				return DataResult.error("订单不存在");
			}else {
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userorderid == null) {
				errList.add("订单id为空"); 
			}
			if (docloginid == null) {
				errList.add("医生id为空"); 
			}
			return DataResult.error( errList.toString().replace("[", "").replace("]", ""));
		}
	}
	
	//医生结束订单
	@RequestMapping(value = "/finishorder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "医生结束订单", httpMethod = "POST", notes = "医生结束订单")
	public String finishOrder(
			@ApiParam(name = "docloginid",required = true,value ="医生登陆id" )@RequestParam Integer docloginid,
			@ApiParam(name = "userorderid",required = true,value ="订单id" )@RequestParam Integer userorderid,
			@ApiParam(name = "userorderhstate",required = true,value ="是否住院" )@RequestParam Boolean userorderhstate,
			@ApiParam(name = "userorderhospid",required = false,value ="接诊医院id")@RequestParam(required=false) Integer userorderhospid) {
		if (docloginid != null && userorderid!=null) {
			Map<String, Object> result = doctorOrderService.finishOrder(docloginid,userorderid,userorderhstate,userorderhospid);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("确认需要住院成功,且消息发送成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.error("确认需要住院成功,但消息发送失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.success("结束订单成功");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("结束订单失败，未知错误");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("该订单状态不支持该操作");
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("医生与订单不匹配");
			} else {
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (userorderid == null) {
				errList.add("订单id为空"); 
			}
			if (docloginid == null) {
				errList.add("医生id为空"); 
			}
			return DataResult.error( errList.toString().replace("[", "").replace("]", ""));
		}
	}
	
	//更换部门
	/*@RequestMapping(value = "/changedept", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更换部门", httpMethod = "POST", notes = "更换部门")
	public String changeDept(
			@ApiParam(name = "docloginid",required = true,value ="医生登陆id" )@RequestParam Integer docloginid,
			@ApiParam(name = "usersickid",required = true,value ="病情id" )@RequestParam Integer usersickid,
			@ApiParam(name = "usersickprimarydept",value ="一级部门" )@RequestParam String usersickprimarydept,
			@ApiParam(name = "usersickseconddept",value ="二级部门" )@RequestParam(required=false) String usersickseconddept) {
		if (docloginid != null && usersickid!=null) {
			Map<String, Object> result = doctorService.changeDept(docloginid,usersickid,usersickprimarydept,usersickseconddept);
			if ("1".equals(result.get("state"))) {
				return DataResult.success("取消成功,且消息发送成功");
			} else if ("2".equals(result.get("state"))) {
				return DataResult.success("取消成功,但消息发送失败");
			} else if ("3".equals(result.get("state"))) {
				return DataResult.success("取消失败，未知错误");
			} else if ("4".equals(result.get("state"))) {
				return DataResult.error("病情不存在，取消失败");
			} else if ("5".equals(result.get("state"))) {
				return DataResult.error("该状态不支持取消");
			} else if ("6".equals(result.get("state"))) {
				return DataResult.error("医生与订单不匹配");
			} else if ("7".equals(result.get("state"))) {
				return DataResult.error("订单不存在");
			}else {
				return DataResult.error("异常错误");
			}
		} else {
			List<String> errList = new ArrayList<String>();
			if (usersickid == null) {
				errList.add("订单id为空"); 
			}
			if (docloginid == null) {
				errList.add("医生id为空"); 
			}
			return DataResult.error( errList.toString().replace("[", "").replace("]", ""));
		}
	}*/
	

	
}
