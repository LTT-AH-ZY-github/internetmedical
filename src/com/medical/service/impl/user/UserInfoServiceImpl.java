package com.medical.service.impl.user;


import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import com.medical.mapper.FamilyinfoMapper;
import com.medical.mapper.FamilyinfoMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.Familyinfo;
import com.medical.po.Userinfo;
import com.medical.po.Userlogininfo;
import com.medical.po.UserlogininfoCustom;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.user.UserInfoService;
import com.medical.utils.PictureTool;
import com.medical.utils.result.DataResult;

import net.sf.json.JSONObject;


public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
	@Autowired
	private FamilyinfoMapper familyinfoMapper;
	@Autowired
	private FamilyinfoMapperCustom familyinfoMapperCustom;
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	@Autowired
	private CommonService commonService;
	
	
	//每次登录更新位置信息
	@Override
	public String updateLocation(Integer userloginid, String userloginlon, String userloginlat) throws Exception{
		Userlogininfo userlogininfo = new Userlogininfo();
		userlogininfo.setUserloginid(userloginid);
		userlogininfo.setUserloginlat(userloginlat);
		userlogininfo.setUserloginlon(userloginlon);
		boolean result=  userlogininfoMapper.updateByPrimaryKeySelective(userlogininfo) > 0;
		if (result) {
			return DataResult.success("更新位置信息成功");
		} else {
			return DataResult.error("更新位置信息失败");
		} 
	}

	// 更新channelId
	@Override
	public String updateChannelId(Integer userloginid, String channelid) throws Exception{
		Userlogininfo record = new Userlogininfo();
		record.setUserloginid(userloginid);
		record.setUserloginchannelid(channelid);
		boolean result =  userlogininfoMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			return DataResult.success("更新成功");
		} else {
			return DataResult.error("更新失败");
		} 

	}

	// 修改用户头像和昵称
	@Override
	public String updateUserPixAndUserName(MultipartFile pictureFile, Integer userloginid, String username)
			throws Exception {
		
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (userlogininfo == null) {
			return DataResult.error("用户不存在");
		}
		String file = null;
		if (pictureFile!=null && !pictureFile.isEmpty() ) {
			file = PictureTool.SaveOnePicture(pictureFile);
		}
		
		UserlogininfoCustom userlogininfoCustom = new UserlogininfoCustom();
		userlogininfoCustom.setUserloginid(userloginid);
		userlogininfoCustom.setUserloginname(username);
		userlogininfoCustom.setUserloginpix(file);
		boolean result = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoCustom) > 0;
		if (result) {
			return DataResult.success("修改成功",file);
		} else {
			return DataResult.error("修改失败");
		}
		
	}

	// 获取用户信息
	@Override
	public String findUserInfo(Integer userloginid) throws Exception{
		Map<String, Object> reslutMap = userinfoMapperCustom.findUserInfoByLoginId(userloginid);
		if (reslutMap!=null) {
			return DataResult.success("获取成功", reslutMap);
		} else {
			return DataResult.success("个人信息为空");
		}
	}

	// 修改用户信息
	@Override
	public String updateUserInfo(Integer userloginid, String username, String usermale, String usercardnum,
			String useradrprovince, String useradrcity, Integer userage, String useradrarea, String useradrother,
			MultipartFile[] pictureFile) throws Exception {

		Userinfo user = userinfoMapperCustom.selectByLoginId(userloginid);
		if (user == null) {
			return DataResult.error("用户不存在");
		}
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		int type = userlogininfo.getUserlogintype();
		if (type == 2) {
			return DataResult.error("已提交审核，不可修改");
		}else if (type == 3) {
			return DataResult.error("已通过审核，不可修改");
		}else {
			Userinfo userinfo = new Userinfo();
			userinfo.setUseradrprovince(useradrprovince);
			userinfo.setUseradrcity(useradrcity);
			userinfo.setUseradrarea(useradrarea);
			userinfo.setUseradrother(useradrother);
			userinfo.setUserage(userage);
			userinfo.setUsercardnum(usercardnum);
			userinfo.setUserid(user.getUserid());
			userinfo.setUsername(username);
			userinfo.setUsermale(usermale);
			userinfo.setUsercardphoto(PictureTool.SavePictures(pictureFile));
			boolean result = userinfoMapper.updateByPrimaryKeySelective(userinfo)>0;
			Familyinfo familyinfo = new Familyinfo();
			familyinfo.setFamilyage(userage);
			familyinfo.setFamilymale(usermale);
			familyinfo.setFamilyname(username);
			familyinfo.setUserloginid(userloginid);
			familyinfo.setFamilytype(true);
			// "1"为用户本人
			List<Familyinfo> list = familyinfoMapperCustom.selectByUserLoginIdAndType(userloginid, 1);
			boolean familyResult = false;
			//int familyResult = 0;
			if (list.size() == 0) {
				// 插入到亲属信息表
				familyResult = familyinfoMapper.insertSelective(familyinfo)>0;
			} else {
				Integer id = list.get(0).getFamilyid();
				familyinfo.setFamilyid(id);
				familyResult = familyinfoMapper.updateByPrimaryKey(familyinfo)>0;
			}
			if (result && familyResult) {
				return DataResult.success("信息修改成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("信息修改失败");
			}
		}
		
	}
	//消息
	// 提交审核
	@Override
	public String updateInfoToReview(Integer userloginid) throws Exception {
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (userlogininfo == null) {
			return DataResult.error("用户不存在");
		}
		int type = userlogininfo.getUserlogintype();
		if (type == 2) {
			return DataResult.error("已提交审核");
		}
		if (type == 3) {
			return DataResult.error("已通过审核");
		}
		Userlogininfo record = new Userlogininfo();
		record.setUserloginid(userloginid);
		record.setUserloginsubchecktime(new Date());
		record.setUserlogintype(2);
		boolean result = userlogininfoMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			JSONObject jsonCustormCont = new JSONObject();
			boolean push = commonService.createMsgUserToAdmin(userloginid, 0, "通知消息", "提交资料审核", jsonCustormCont);
			return DataResult.success("提交审核成功");
		} else {
			return DataResult.error("提交审核失败");
		}
	}

	// 查询亲属信息
	@Override
	public String findFamily(Integer userloginid) throws Exception{
		List<Familyinfo> list = familyinfoMapperCustom.findByUserLoginId(userloginid);
		if (list!=null && list.size()>0) {
			return DataResult.success("查询成功", list);
		} else {
			return DataResult.success("数据为空");
		} 
	}

	// 添加亲属信息
	@Override
	public String addFamily(Familyinfo familyinfo) throws Exception {
		List<Familyinfo> lists = familyinfoMapperCustom.selectByUserLoginIdAndInfo(familyinfo);
		if (lists.size() == 0) {
			boolean result = familyinfoMapper.insertSelective(familyinfo) > 0;
			if (result) {
				return DataResult.success("添加成功");
			} else {
				return DataResult.error("添加失败");
			} 
		} else {
			return DataResult.error("该亲属已存在");
		 }
		
	}

	// 修改亲属信息
	@Override
	public String updateFamily(Familyinfo familyinfo) throws Exception {
		Familyinfo family = familyinfoMapper.selectByPrimaryKey(familyinfo.getFamilyid());
		if (family == null) {
			return DataResult.error("亲属不存在");
		}
		int user = familyinfo.getUserloginid();
		int userloginid = family.getUserloginid();
		if (user != userloginid) {
			return DataResult.error("账户信息不匹配");
		}
		boolean type = family.getFamilytype();
		if (type) {
			return DataResult.error("本人信息无法修改");
		}
		boolean result = familyinfoMapper.updateByPrimaryKeySelective(familyinfo) > 0;
		if (result) {
			return DataResult.success("修改成功");
		} else {
			return DataResult.error("修改失败");
		}

	}

	// 删除亲属信息
	@Override
	public String deleteFamily(Integer familyid) throws Exception {
		Familyinfo family = familyinfoMapper.selectByPrimaryKey(familyid);
		if (family == null) {
			return DataResult.error("亲属不存在");
		}
		/*
		 * int user = familyinfo.getUserloginid(); int userloginid =
		 * family.getUserloginid(); if (user != userloginid) { return
		 * DataResult.error("账户信息不匹配"); }
		 */
		boolean type = family.getFamilytype();
		if (type) {
			return DataResult.error("本人信息无法删除");
		}
		int count = usersickMapperCustom.selectCountByFamilyId(familyid);
		if (count == 0) {
			boolean result = familyinfoMapper.deleteByPrimaryKey(familyid) > 0;
			if (result) {
				return DataResult.success("删除成功");
			} else {
				return DataResult.error("删除失败");
			}
		} else {
			return DataResult.error("该亲属已填写病情，无法删除");
		}

	}

	/* (non-Javadoc)
	 * @see com.medical.service.iface.user.UserInfoService#updateInfoToCancelReview(java.lang.Integer)
	 */
	@Override
	public String updateInfoToCancelReview(Integer userloginid) {
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (userlogininfo == null) {
			return DataResult.error("用户不存在");
		}
		int type = userlogininfo.getUserlogintype();
		if (type == 1) {
			return DataResult.error("未提交审核");
		}
		if (type == 3) {
			return DataResult.error("已通过审核");
		}
		if (type == 4) {
			return DataResult.error("未通过审核");
		}
		Userlogininfo record = new Userlogininfo();
		record.setUserloginid(userloginid);
		record.setUserloginsubchecktime(new Date());
		record.setUserlogintype(1);
		boolean result = userlogininfoMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			return DataResult.success("撤销审核成功");
		} else {
			return DataResult.error("撤销审核失败");
		}
	}
	
	
}
