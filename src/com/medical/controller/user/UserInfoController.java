package com.medical.controller.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medical.po.Familyinfo;
import com.medical.service.iface.user.UserInfoService;
import com.medical.utils.CheckUtils;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     UserInfoController.java
 * @Description:   用户信息管理 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 上午10:48:01 
 */

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;

	/**
	 * @Title: updateLocation
	 * @Description: 更新用户位置信息
	 * @param userloginid
	 * @param userloginlon
	 * @param userloginlat
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/updatelocation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新用户位置信息", httpMethod = "POST", notes = "更新用户位置信息")
	public String updateLocation(
			@ApiParam(name = "userloginid", required = true, value = "用户登录id") @RequestParam(value = "userloginid") Integer userloginid,
			@ApiParam(name = "userloginlon", value = "精度") @RequestParam(value = "userloginlon") String userloginlon,
			@ApiParam(name = "userloginlat", value = "纬度") @RequestParam(value = "userloginlat") String userloginlat)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登陆id为空");
		}
		if (StringUtils.isBlank(userloginlon)) {
			return DataResult.error("精度为空");
		}
		if (StringUtils.isBlank(userloginlat)) {
			return DataResult.error("纬度为空");
		}
		return userInfoService.updateLocation(userloginid, userloginlon, userloginlat);
	}

	/**
	 * @Title: updateChannelId
	 * @Description: 更新channelId
	 * @param userloginid
	 * @param channelid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/updatechannelid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新channelId", httpMethod = "POST", notes = "更新channelId")
	public String updateChannelId(@ApiParam(name = "userloginid", value = "病人登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "channelid", value = "channelid") @RequestParam String channelid) throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登陆id为空");
		}
		if (StringUtils.isBlank(channelid)) {
			return DataResult.error("channelid为空");
		}
		return userInfoService.updateChannelId(userloginid, channelid);
	}

	/**
	 * @Title: addUserInfo
	 * @Description:修改用户头像和昵称
	 * @param pictureFile
	 * @param userloginname
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/updateinfo", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改用户头像和昵称", httpMethod = "POST", consumes = "multipart/form-data", notes = "修改用户头像和昵称")
	public String addUserInfo(
			@ApiParam(name = "pictureFile", required = false, value = "图片") @RequestParam(required = false) MultipartFile pictureFile,
			@ApiParam(name = "userloginname", required = false, value = "昵称") @RequestParam(required = false) String userloginname,
			@ApiParam(name = "userloginid", required = true, value = "登录id") @RequestParam Integer userloginid)
			throws Exception {
		System.out.println("测试"+userloginname);
		if (userloginid == null) {
			return DataResult.error("用户登陆id为空");
		}
		/*if (StringUtils.isBlank(userloginname) && (pictureFile == null || pictureFile.isEmpty())) {
			return DataResult.error("头像和昵称不可同时为空");
		}*/
		return userInfoService.updateUserPixAndUserName(pictureFile, userloginid, userloginname);
	}

	/**
	 * @Title: findUserInfo
	 * @Description: 获取用户信息
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/getinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "获取用户信息", httpMethod = "POST", notes = "获取用户信息")
	public String findUserInfo(
			@ApiParam(name = "userloginid", required = true, value = "登录id") @RequestParam(value = "userloginid") Integer userloginid)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("登录id为空");
		}
		return userInfoService.findUserInfo(userloginid);
	}

	/**
	 * @Title: editUserInfo
	 * @Description: 修改用户信息
	 * @param pictureFile
	 * @param username
	 * @param usermale
	 * @param usercardnum
	 * @param useradrprovince
	 * @param useradrcity
	 * @param useradrarea
	 * @param useradrother
	 * @param userage
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/editinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改用户信息", httpMethod = "POST", consumes = "multipart/form-data", notes = "修改用户信息")
	public String editUserInfo(
			@ApiParam(name = "usercardphoto", value = "图片数组") @RequestParam(value = "usercardphoto", required = false) MultipartFile[] pictureFile,
			@ApiParam(name = "username", value = "姓名") @RequestParam(required = false) String username,
			@ApiParam(name = "usermale", value = "性别") @RequestParam(required = false) String usermale,
			@ApiParam(name = "usercardnum", value = "身份证号码") @RequestParam(required = false) String usercardnum,
			@ApiParam(name = "useradrprovince", value = "地址省份") @RequestParam(required = false) String useradrprovince,
			@ApiParam(name = "useradrcity", value = "地址市") @RequestParam(required = false) String useradrcity,
			@ApiParam(name = "useradrarea", value = "地址区县") @RequestParam(required = false) String useradrarea,
			@ApiParam(name = "useradrother", value = "详细地址") @RequestParam(required = false) String useradrother,
			@ApiParam(name = "userage", value = "年龄") @RequestParam(required = false) Integer userage,
			@ApiParam(name = "userloginid", value = "登录id") @RequestParam(required = true) Integer userloginid)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("该用户的id为空");
		}
		return userInfoService.updateUserInfo(userloginid, username, usermale, usercardnum, useradrprovince,
				useradrcity, userage, useradrarea, useradrother, pictureFile);

	}

	/**
	 * @Title: reviewInfo
	 * @Description: 提交审核
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/reviewinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "提交审核", httpMethod = "POST", notes = "提交审核")
	public String reviewInfo(
			@ApiParam(name = "userloginid", value = "登录id") @RequestParam(required = true) Integer userloginid)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("id为空");
		}
		return userInfoService.updateInfoToReview(userloginid);
	}
	
	@RequestMapping(value = "/cancelreview", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "撤销审核", httpMethod = "POST", notes = "撤销审核")
	public String cancelreview(
			@ApiParam(name = "userloginid", value = "登录id") @RequestParam(required = true) Integer userloginid)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("id为空");
		}
		return userInfoService.updateInfoToCancelReview(userloginid);
	}

	/**
	 * @Title: findFamily
	 * @Description: 查询亲属信息
	 * @param userloginid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/findfamily", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "查询亲属信息", httpMethod = "POST", notes = "查询亲属信息")
	public String findFamily(@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("id为空");
		}
		return userInfoService.findFamily(userloginid);

	}

	/**
	 * @Title: addFamily
	 * @Description: 添加亲属信息
	 * @param userloginid
	 * @param familyname
	 * @param familymale
	 * @param familyage
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/addfamily", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "添加亲属信息", httpMethod = "POST", notes = "添加亲属信息")
	public @ResponseBody String addFamily(
			@ApiParam(name = "userloginid", value = "用户登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "familyname", value = "姓名") @RequestParam String familyname,
			@ApiParam(name = "familymale", value = "性别") @RequestParam String familymale,
			@ApiParam(name = "familyage", value = "年龄") @RequestParam Integer familyage) throws Exception {
		if (userloginid == null) {
			return DataResult.error("id为空");
		}
		if (StringUtils.isBlank(familyname)) {
			return DataResult.error("亲属姓名为空");
		}
		if (StringUtils.isNotBlank(familyname) && !CheckUtils.isChineseNameLegal(familyname)) {
			return DataResult.error("中文名只允许二到七个汉字");
		}
		if (StringUtils.isBlank(familymale)) {
			return DataResult.error("亲属性别为空");
		}
		if (StringUtils.isNotBlank(familymale) && !CheckUtils.isSexLegal(familymale)) {
			return DataResult.error("性别输入不合法");
		}
		if (familyage == null) {
			return DataResult.error("亲属年龄为空");
		}
		if (familyage != null && !CheckUtils.isAgeLegal(familyage)) {
			return DataResult.error("年龄输入不合法");
		}
		Familyinfo familyinfo = new Familyinfo();
		familyinfo.setFamilyage(familyage);
		familyinfo.setFamilymale(familymale);
		familyinfo.setFamilyname(familyname);
		familyinfo.setUserloginid(userloginid);
		familyinfo.setFamilytype(false);
		return userInfoService.addFamily(familyinfo);

	}

	/**
	 * @Title: editFamily
	 * @Description: 修改亲属信息
	 * @param userloginid
	 * @param familyid
	 * @param familyname
	 * @param familymale
	 * @param familyage
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/editfamily", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改亲属信息", httpMethod = "POST", notes = "修改亲属信息")
	public @ResponseBody String editFamily(
			@ApiParam(name = "userloginid", value = "登录id") @RequestParam Integer userloginid,
			@ApiParam(name = "familyid", value = "亲属id") @RequestParam Integer familyid,
			@ApiParam(name = "familyname", value = "姓名") @RequestParam(required = false) String familyname,
			@ApiParam(name = "familymale", value = "性别") @RequestParam(required = false) String familymale,
			@ApiParam(name = "familyage", value = "年龄") @RequestParam(required = false) Integer familyage)
			throws Exception {
		if (userloginid == null) {
			return DataResult.error("用户登录id为空");
		}
		if (familyid == null) {
			return DataResult.error("亲属id为空");
		}
		if (StringUtils.isNotBlank(familyname) && !CheckUtils.isChineseNameLegal(familyname)) {
			return DataResult.error("中文名只允许二到七个汉字");
		}
		if (StringUtils.isNotBlank(familymale) && !CheckUtils.isSexLegal(familymale)) {
			return DataResult.error("性别输入不合法");
		}
		if (familyage != null && !CheckUtils.isAgeLegal(familyage)) {
			return DataResult.error("年龄输入不合法");
		}
		Familyinfo familyinfo = new Familyinfo();
		familyinfo.setUserloginid(userloginid);
		familyinfo.setFamilyage(familyage);
		familyinfo.setFamilymale(familymale);
		familyinfo.setFamilyname(familyname);
		familyinfo.setFamilyid(familyid);
		familyinfo.setFamilytype(false);
		return userInfoService.updateFamily(familyinfo);

	}

	// 待修改

	/**
	 * @Title: deleteFamily
	 * @Description: 刪除亲属信息
	 * @param userloginid
	 * @param familyid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping(value = "/deletefamily", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "删除亲属信息", httpMethod = "POST", notes = "删除亲属信息")
	public String deleteFamily(
			@ApiParam(name = "userloginid", value = "登录id") @RequestParam(required = false) Integer userloginid,
			@ApiParam(name = "familyid", value = "当前页") @RequestParam Integer familyid) throws Exception {
		if (familyid == null) {
			return DataResult.error("亲属id为空");
		}
		return userInfoService.deleteFamily(familyid);

	}
	

}
