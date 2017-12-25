package com.medical.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.medical.po.UsersickCustom;
import com.medical.service.iface.user.UserSickService;
import com.medical.utils.StringTools;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName: UserSickController.java
 * @Description: 用户病情管理
 * @author xyh
 * @version V1.0
 * @Date 2017年11月27日 上午10:49:05
 */
@RestController
@RequestMapping(value = "/user")
public class UserSickController {
	@Autowired
	private UserSickService userSickService;

	/**
	 * @Title: addSick
	 * @Description: 新增病情
	 * @param pictureFile
	 * @param usersickCustom
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/addsick", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "新增病情", httpMethod = "POST", consumes = "multipart/form-data", notes = "新增病情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "usersickdesc", value = "病情描述", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "usersickprimarydept", value = "医院一级科室", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "usersickseconddept", value = "医院二级科室", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "userloginid", value = "用户登录id", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "familyid", value = "亲属id", required = true, dataType = "int", paramType = "query") })
	public String addSick(
			@ApiParam(name = "pictureFile", required = false, value = "图片") @RequestParam(required = false) MultipartFile[] pictureFile,
			@ApiIgnore @Valid UsersickCustom usersickCustom, BindingResult bindingResult) throws Exception {
		
		String usersickdesc  = usersickCustom.getUsersickdesc();
		Integer userloginid  = usersickCustom.getUserloginid();
		Integer familyid  = usersickCustom.getFamilyid();
		if (StringUtils.isBlank(usersickdesc)) {
			return DataResult.error("病情描述为空");
		}
		if (StringTools.strLength(usersickdesc)>200) {
			return DataResult.error("病情描述过多");
		}
		if (userloginid==null) {
			return DataResult.error("用户登录id为空");
		}
		if (familyid==null) {
			return DataResult.error("亲属为空");
		}
		return userSickService.addSick(pictureFile, usersickCustom);

	}

	/**
	 * @Title: getSick
	 * @Description: 获取病情
	 * @param userloginid
	 * @param page
	 * @param type
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/getsick", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情", httpMethod = "POST", notes = "获取病情")
	public @ResponseBody String getSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam(required = false) Integer page,
			@ApiParam(name = "type", value = "病情类型,不填获取全部 ,1是未发布的病情 ,2是已发布和生成订单的") @RequestParam(required = false) Integer type)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户id为空");
		}
		if (type != null && (type < 1 || type > 2)) {
			return DataResult.error("type超出范围");
		}
		if (page == null) {
			page = 1;
		}
		return userSickService.listSicks(userloginid, type, page);

	}

	/**
	 * @Title: getOneSick
	 * @Description: 获取病情详情
	 * @param userloginid
	 * @param usersickid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/getonesick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取病情详情", httpMethod = "POST", notes = "获取病情详情")
	public String getOneSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam(required = false) Integer userloginid,
			@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid) throws Exception {
		if (usersickid == null) {
			return DataResult.error("病情id为空");
		}
		return userSickService.getSickDetail(userloginid, usersickid);
	}

	/**
	 * @Title: deleteSick
	 * @Description: 删除病情
	 * @param userloginid
	 * @param usersickid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/deletesick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除病情", httpMethod = "POST", notes = "删除病情")
	public String deleteSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam(required = false) Integer userloginid,
			@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid) throws Exception {
		if (usersickid == null) {
			return DataResult.error("病情id为空");
		}
		return userSickService.deleteSick(null, usersickid);
	}

	// 待修改
	//

	/**
	 * @Title: editSick
	 * @Description: 修改病情
	 * @param pictureFile
	 * @param usersickCustom
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/editsick", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改病情", httpMethod = "POST", consumes = "multipart/form-data", notes = "修改病情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userloginid", value = "用户登录id", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "usersickid", value = "病情id", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "usersickdesc", value = "病情描述", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "usersickprimarydept", value = "医院一级科室", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "usersickseconddept", value = "医院二级科室", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "familyid", value = "亲属id", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "usersickpic", value = "原图片路径", required = false, dataType = "String", paramType = "query") })
	public String editSick(
			@ApiParam(name = "pictureFile", required = false, value = "图片") @RequestParam(required = false) MultipartFile[] pictureFile,
			@ApiIgnore UsersickCustom usersickCustom) throws Exception {
		
		Integer userloginid = usersickCustom.getUserloginid();
		if (userloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		Integer usersickid = usersickCustom.getUsersickid();
		if (usersickid == null) {
			return DataResult.error("病情id为空");
		}
		String usersickdesc = usersickCustom.getUsersickdesc();
		if (usersickdesc!=null && StringTools.strLength(usersickdesc)>200) {
			return DataResult.error("病情描述过多");
		}
		return userSickService.editSick(pictureFile, usersickCustom);
	}

	/**
	 * @Title: publishSick
	 * @Description: 发布病情
	 * @param userloginid
	 * @param usersickid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/publishsick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "发布病情", httpMethod = "POST", notes = "发布病情")
	public String publishSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam(required = false) Integer userloginid,
			@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid) throws Exception {
		if (userloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (usersickid == null) {
			return DataResult.error("病情id为空");
		}
		return userSickService.updateSickStateToPublish(userloginid, usersickid);

	}

	/**
	 * @Title: cancelSick
	 * @Description: 取消发布病情
	 * @param userloginid
	 * @param usersickid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/cancelsick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消发布病情", httpMethod = "POST", notes = "取消发布病情")
	public String cancelSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam(required = false) Integer userloginid,
			@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid) throws Exception {
		if (userloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (usersickid == null) {
			return DataResult.error("病情id为空");
		}
		return userSickService.updateSickStateToCancel(userloginid, usersickid);
	}

	/**
	 * @Title: getrReDoctor
	 * @Description: 获取当前发布病情相关医生
	 * @param userloginid
	 * @param page
	 * @param type
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/getredoctor", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取当前发布病情相关医生", httpMethod = "POST", notes = "获取推荐医生")
	public String getrReDoctor(@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "page", value = "当前页") @RequestParam(required = false) Integer page,
			@ApiParam(name = "type", value = "医生类型,不填为所有医生,1为系统推荐医生，2为抢单医生，3为其他医生推荐医生，4为预选医生") @RequestParam(required = false) Integer type)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (type != null && (type > 4 || type < 1)) {
			return DataResult.error("preordertype超出范围");
		}
		if (page == null) {
			page = 1;
		}
		return userSickService.listRelatedDoctor(userloginid, type, page);
	}

	/**
	 * @Title: optDoctor
	 * @Description: 预选医生
	 * @param docloginid
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/optdoctor", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "预选医生", httpMethod = "POST", notes = "预选医生")
	public String optDoctor(@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid) throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return userSickService.addRelatedDoctor(docloginid, userloginid);
	}
}
