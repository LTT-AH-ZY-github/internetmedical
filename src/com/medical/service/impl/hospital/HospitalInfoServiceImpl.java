package com.medical.service.impl.hospital;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.medical.mapper.AccounttypeMapper;
import com.medical.mapper.HospinfoMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HosplogininfoMapper;
import com.medical.po.Accounttype;
import com.medical.po.Hospinfo;
import com.medical.po.Hosplogininfo;
import com.medical.po.Hosporder;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.SenderNotificationService;
import com.medical.service.iface.hospital.HospitalInfoService;
import com.medical.utils.PictureTool;
import com.medical.utils.result.DataResult;

import net.sf.json.JSONObject;

public class HospitalInfoServiceImpl implements HospitalInfoService {
	@Autowired
	private HospinfoMapper hospinfoMapper;
	@Autowired
	private HosplogininfoMapper hosplogininfoMapper;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private AccounttypeMapper accounttypeMapper;
	@Autowired
	private CommonService commonService;
	@Autowired 
	private SenderNotificationService senderNotificationService;
	@Override
	public String updateInfo(Hospinfo hospinfo) {
		Integer hosploginid = hospinfo.getHosploginid();
		Hospinfo info = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (info == null) {
			return DataResult.error("账号不存在");
		}
		hospinfo.setHospid(info.getHospid());
		boolean result = hospinfoMapper.updateByPrimaryKeySelective(hospinfo)>0;
		if (result) {
			return DataResult.success("更新成功");
		} else {
			return DataResult.error("更新失败");
		}
	}

	/* (non-Javadoc)
	 * @see com.medical.service.iface.hospital.HospitalInfoService#updateUserPix(org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public String updateUserPix(MultipartFile pictureFile) throws Exception {
		
		return DataResult.success("成功", PictureTool.SaveOnePicture(pictureFile));
		
	}

	/* (non-Javadoc)
	 * @see com.medical.service.iface.hospital.HospitalInfoService#updateHospPic(java.lang.Integer, java.lang.Integer, org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public String updateHospPic(Integer hosploginid, Integer type, MultipartFile[] pictureFile) throws Exception {
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (hospinfo==null) {
			return DataResult.error("账号不存在");
		}
		Hospinfo hospinforecord = new Hospinfo();
		hospinforecord.setHospid(hospinfo.getHospid());
		String path = PictureTool.SavePictures(pictureFile);
		if (type==1) {
			//当地质量技术监督部门办理组织机构代码证
			hospinforecord.setHosporgcodecer(path);
		}else if (type==2) {
			//注册医院执业许可证书照片
			hospinfo.setHosppraclicense(path);
		}else if (type==3){
			//医院法人证明照片
			hospinfo.setHosplegalcer(path);
		}else {
			//平台注册人医师资格证照片
			hospinfo.setHospregdocquacer(path);
		}
		boolean result = hospinfoMapper.updateByPrimaryKeySelective(hospinforecord)>0;
		if (result) {
			return DataResult.success("上传成功");
		} else {
			return DataResult.error("上传失败");
		}
		
	}

	
	@Override
	public String updateToReview(Integer hosploginid) throws Exception {
		Hosplogininfo hosplogininfo =  hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		int type = hosplogininfo.getHosplogintype();
		if (type == 2) {
			return DataResult.error("已提交审核");
		}
		if (type == 3) {
			return DataResult.error("已通过审核");
		}
		Hosplogininfo hosplogininforecord = new Hosplogininfo();
		hosplogininforecord.setHosploginid(hosploginid);
		hosplogininforecord.setHosplogintype(2);
		boolean result = hosplogininfoMapper.updateByPrimaryKeySelective(hosplogininforecord)>0;
		if (result) {
			JSONObject jsonCustormCont = new JSONObject();
			senderNotificationService.createMsgHospitalToAdmin(hosploginid, 1, "消息通知", "提交审核", jsonCustormCont);
			return DataResult.success("提交成功");
		} else {
			return DataResult.error("提交失败");
		}
	}

	/* (non-Javadoc)
	 * @see com.medical.service.iface.hospital.HospitalInfoService#getInfo(java.lang.Integer)
	 */
	@Override
	public String getInfo(Integer hosploginid) throws Exception {
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (hospinfo==null) {
			return DataResult.error("账号信息不存在");
		} 
		Map<String, Object> map = new HashMap<>();
		map.put("hospname", hospinfo.getHospname());
		map.put("hospphone", hospinfo.getHospphone());
		map.put("hospregidcard", hospinfo.getHospregidcard());
		map.put("hospadrprovince", hospinfo.getHospadrprovince());
		map.put("hospadrcity", hospinfo.getHospadrcity());
		map.put("hospadrarea", hospinfo.getHospadrarea());
		map.put("hospadrother", hospinfo.getHospadrother());
		map.put("hospgrade", hospinfo.getHospgrade());
		map.put("hospabs", hospinfo.getHospabs());
		map.put("hospfeature", hospinfo.getHospfeature());
		map.put("hospregdocquacer", hospinfo.getHospregdocquacer());
		map.put("hosporgcodecer", hospinfo.getHosporgcodecer());
		map.put("hosppraclicense", hospinfo.getHosppraclicense());
		map.put("hosplegalcer", hospinfo.getHosplegalcer());
		return DataResult.success("获取成功", map);
	}

	/* (non-Javadoc)
	 * @see com.medical.service.iface.hospital.HospitalInfoService#getLoginInfo(java.lang.Integer)
	 */
	@Override
	public String getLoginInfo(Integer hosploginid) {
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号信息不存在");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("hosploginphone", hosplogininfo.getHosploginphone());
		map.put("hosplogintime", hosplogininfo.getHosplogintime());
		map.put("hosplogintype", hosplogininfo.getHosplogintype());
		Accounttype accounttype = accounttypeMapper.selectByPrimaryKey(hosplogininfo.getHosplogintype());
		map.put("hosplogintypename", accounttype.getAccounttypename());
		return DataResult.success("获取成功", map);
	}
}
