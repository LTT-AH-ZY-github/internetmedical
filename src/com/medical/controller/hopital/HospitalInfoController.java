/**
 * 
 */
package com.medical.controller.hopital;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medical.po.Hospinfo;
import com.medical.service.iface.hospital.HospitalInfoService;
import com.medical.utils.result.DataResult;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @ClassName:     HospitalInfoController.java
 * @Description:   医院信息管理
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午3:31:47 
 */
@RestController
@RequestMapping(value = "/hospital")
public class HospitalInfoController {
	@Autowired
	private HospitalInfoService hospitalInfoService;

	@RequestMapping(value = "/updateinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "更新医院信息", httpMethod = "POST", notes = "更新医院信息")
	public @ResponseBody String updateInfo(
				@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
				@ApiParam(name = "hospname", value = "医院名称") @RequestParam String hospname,
				@ApiParam(name = "hospabs", value = "医院简介") @RequestParam String hospabs,
				@ApiParam(name = "hospgrade", value = "医院等级") @RequestParam Integer hospgrade,
				@ApiParam(name = "hospphone", value = "医院联系电话") @RequestParam String hospphone,
				@ApiParam(name = "hospfeature", value = "医院特色") @RequestParam String hospfeature,
				@ApiParam(name = "hospadrprovince", value = "医院所在省") @RequestParam String hospadrprovince,
				@ApiParam(name = "hospadrcity", value = "医院所在市") @RequestParam String hospadrcity,
				@ApiParam(name = "hospadrarea", value = "医院所在区") @RequestParam String hospadrarea,
				@ApiParam(name = "hospadrother", value = "医院所在详细地址") @RequestParam String hospadrother,
				@ApiParam(name = "hospadrlon", value = "医院所在经度") @RequestParam String hospadrlon,
				@ApiParam(name = "hospadrlat", value = "医院所在纬度") @RequestParam String hospadrlat
			) throws Exception {
			if (hosploginid == null) {
				return DataResult.error("医院登陆id为空");
			}
			Hospinfo hospinfo = new Hospinfo();
			hospinfo.setHosploginid(hosploginid);;
			hospinfo.setHospname(hospname);
			hospinfo.setHospabs(hospabs);
			hospinfo.setHospgrade(hospgrade+"");
			hospinfo.setHospphone(hospphone);
			hospinfo.setHospfeature(hospfeature);
			hospinfo.setHospadrprovince(hospadrprovince);
			hospinfo.setHospadrcity(hospadrcity);
			hospinfo.setHospadrarea(hospadrarea);
			hospinfo.setHospadrother(hospadrother);
			hospinfo.setHospadrlat(hospadrlat);
			hospinfo.setHospadrlon(hospadrlon);
			return hospitalInfoService.updateInfo(hospinfo);
	}
	@RequestMapping(value = "/updatepic", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "修改用户头像", httpMethod = "POST", consumes = "multipart/form-data", notes = "修改用户头像和昵称")
	public String addUserInfo(
			@ApiParam(name = "pictureFile", required = false, value = "图片") @RequestParam(required = false) MultipartFile pictureFile
			)
			throws Exception {
		
		
		return hospitalInfoService.updateUserPix(pictureFile);
	}
	
	@RequestMapping(value = "/updatepicture", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "上传图片", httpMethod = "POST", consumes = "multipart/form-data", notes = "上传图片")
	public String updatepicture(
			@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid,
			@ApiParam(name = "type", required = true, value = "1为当地质量技术监督部门办理组织机构代码证，2为注册医院执业许可证书照片3为医院法人证明照片4为平台注册人医师资格证照片") @RequestParam Integer type,
			@ApiParam(name = "pictureFile", required = false, value = "图片") @RequestParam(required = false) MultipartFile[]  pictureFile
			)
			throws Exception {
		return hospitalInfoService.updateHospPic(hosploginid,type,pictureFile);
	}
	@RequestMapping(value = "/reviewinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "提交审核资料", httpMethod = "POST", notes = "提交审核资料")
	public @ResponseBody String reviewinfo(
				@ApiParam(name = "hosploginid", required = true, value = "医院登陆id") @RequestParam Integer hosploginid
				) throws Exception {
			if (hosploginid == null) {
				return DataResult.error("医院登陆id为空");
			}
			return hospitalInfoService.updateToReview(hosploginid);
		}
}
