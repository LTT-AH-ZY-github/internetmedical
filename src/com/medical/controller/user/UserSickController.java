package com.medical.controller.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.medical.service.iface.user.UserSickService;
import com.medical.utils.result.DataResult;
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

	@RequestMapping(value = "/addsick", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "新增病情", httpMethod = "POST", consumes = "multipart/form-data", notes = "新增病情")
	public String addSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "familyid", value = "亲属id") @RequestParam Integer familyid,
			@ApiParam(name = "usersickdesc", value = "病情描述") @RequestParam String usersickdesc,
			@ApiParam(name = "usersickprimarydept", value = "医院一级科室") @RequestParam(required = false) String usersickprimarydept,
			@ApiParam(name = "usersickseconddept", value = "医院二级科室") @RequestParam(required = false) String usersickseconddept,
			@ApiParam(name = "pictureFile", value = "图片") @RequestParam(required = false) MultipartFile[] pictureFile
			) throws Exception {
		if (userloginid==null) {
			return DataResult.error("用户登录id为空");
		}
		if (familyid==null) {
			return DataResult.error("亲属为空");
		}
		if (StringUtils.isBlank(usersickdesc)) {
			return DataResult.error("病情描述为空");
		}
		if (usersickdesc.length()>250) {
			return DataResult.error("病情描述过多");
		}
		return userSickService.addSick(userloginid,familyid,usersickdesc,usersickprimarydept,usersickseconddept,pictureFile);
	}

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
			return DataResult.error("type有误");
		}
		if (page == null) {
			page = 1;
		}
		return userSickService.listSick(userloginid, type, page);

	}
	
	//待修改
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

	@RequestMapping(value = "/editsick", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改病情", httpMethod = "POST", consumes = "multipart/form-data", notes = "修改病情")
	public String editSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid,
			@ApiParam(name = "familyid", value = "亲属id") @RequestParam Integer familyid,
			@ApiParam(name = "usersickdesc", value = "病情描述") @RequestParam String usersickdesc,
			@ApiParam(name = "usersickpic", value = "原照片路径") @RequestParam String usersickpic,
			@ApiParam(name = "usersickprimarydept", value = "医院一级科室") @RequestParam(required = false) String usersickprimarydept,
			@ApiParam(name = "usersickseconddept", value = "医院二级科室") @RequestParam(required = false) String usersickseconddept,
			@ApiParam(name = "pictureFile", value = "图片") @RequestParam(required = false) MultipartFile[] pictureFile
			) throws Exception {
		if (userloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (usersickid == null ) {
			return DataResult.error("病情id为空");
		}
		if (usersickdesc!=null && usersickdesc.trim().length()==0) {
			return DataResult.error("病情描述不可为空");
		}
		if (usersickdesc!=null && usersickdesc.length()>250) {
			return DataResult.error("病情描述过多");
		}
		return userSickService.editSick(usersickid,userloginid,familyid,usersickdesc,usersickprimarydept,usersickseconddept,pictureFile,usersickpic);
	}

	
	@RequestMapping(value = "/publishsick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "发布病情", httpMethod = "POST", notes = "发布病情")
	public String publishSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam(required = false) Integer userloginid,
			@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid
			) throws Exception {
		if (userloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (usersickid == null) {
			return DataResult.error("病情id为空");
		}
		return userSickService.updateSickStateToPublish(userloginid, usersickid);

	}

	@RequestMapping(value = "/cancelsick", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "取消发布病情", httpMethod = "POST", notes = "取消发布病情")
	public String cancelSick(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam(required = false) Integer userloginid,
			@ApiParam(name = "usersickid", value = "病情id") @RequestParam Integer usersickid
			) throws Exception {
		if (userloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		if (usersickid == null) {
			return DataResult.error("病情id为空");
		}
		return userSickService.updateSickStateToCancel(userloginid, usersickid);
	}

	
	@RequestMapping(value = "/getredoctor", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取当前发布病情相关医生", httpMethod = "POST", notes = "获取推荐医生")
	public String getrReDoctor(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
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

	@RequestMapping(value = "/optdoctor", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "预选医生", httpMethod = "POST", notes = "预选医生")
	public String optDoctor(
			@ApiParam(name = "docloginid", value = "医生登录id") @RequestParam Integer docloginid,
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid
			) throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (docloginid == null) {
			return DataResult.error("医生登录id为空");
		}
		return userSickService.addRelatedDoctor(docloginid, userloginid);
	}
}
