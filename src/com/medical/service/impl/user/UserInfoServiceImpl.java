package com.medical.service.impl.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import com.medical.mapper.AccounttypeMapper;
import com.medical.mapper.AdminexamineMapperCustom;
import com.medical.mapper.FamilyinfoMapper;
import com.medical.mapper.FamilyinfoMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.Accounttype;
import com.medical.po.Adminexamine;
import com.medical.po.Familyinfo;
import com.medical.po.Userinfo;
import com.medical.po.Userlogininfo;
import com.medical.po.UserlogininfoCustom;
import com.medical.service.iface.SenderNotificationService;
import com.medical.service.iface.user.UserInfoService;
import com.medical.utils.PictureTool;
import com.medical.utils.result.DataResult;

import net.sf.json.JSONObject;

/**
 * @ClassName: UserInfoServiceImpl.java
 * @Description: 用户信息管理接口实现类
 * @author xyh
 * @version V1.0
 * @Date 2017年12月7日 下午9:40:30
 */
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
	private SenderNotificationService senderNotificationService;
	@Autowired
	private AccounttypeMapper accounttypeMapper;
	@Autowired
	private AdminexamineMapperCustom adminexamineMapperCustom;

	//更新位置信息
	@Override
	public String updateLocation(Integer userloginid, String userloginlon, String userloginlat, String userloginprovince, String userlogincity, String userloginarea, String userloginother) throws Exception {
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userlogininfo userlogininfo = new Userlogininfo();
		userlogininfo.setUserloginid(userloginid);
		userlogininfo.setUserloginlat(userloginlat);
		userlogininfo.setUserloginlon(userloginlon);
		userlogininfo.setUserloginprovince(userloginprovince);
		userlogininfo.setUserloginarea(userloginarea);
		userlogininfo.setUserlogincity(userlogincity);
		userlogininfo.setUserloginother(userloginother);
		boolean result = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfo) > 0;
		if (result) {
			return DataResult.success("更新成功");
		} else {
			return DataResult.error("更新失败");
		}
	}

	//更新百度云推送ChannelId
	@Override
	public String updateChannelId(Integer userloginid, String channelid) throws Exception {
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userlogininfo record = new Userlogininfo();
		record.setUserloginid(userloginid);
		record.setUserloginchannelid(channelid);
		boolean result = userlogininfoMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			return DataResult.success("更新成功");
		} else {
			return DataResult.error("更新失败");
		}

	}

	//修改用户头像和昵称
	@Override
	public String updateUserPixAndUserName(MultipartFile pictureFile, Integer userloginid, String username)
			throws Exception {

		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (userlogininfo == null) {
			return DataResult.error("账户不存在");
		}
		String file = null;
		if (pictureFile != null && !pictureFile.isEmpty()) {
			file = PictureTool.SaveOnePicture(pictureFile);
		}
        UserlogininfoCustom userlogininfoCustom = new UserlogininfoCustom();
		userlogininfoCustom.setUserloginid(userloginid);
		userlogininfoCustom.setUserloginname(username);
		userlogininfoCustom.setUserloginpix(file);
		boolean result = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoCustom) > 0;
		if (result) {
			return DataResult.success("修改成功", file);
		} else {
			return DataResult.error("修改失败");
		}

	}

	//获取用户信息
	@Override
	public String getUserDetail(Integer userloginid) throws Exception {
		Map<String, Object> reslutMap = userinfoMapperCustom.findUserInfoByLoginId(userloginid);
		if (reslutMap != null) {
			return DataResult.success("获取成功", reslutMap);
		} else {
			return DataResult.error("用户不存在");
		}
	}

	//修改用户信息
	@Override
	public String updateUserInfo(Integer userloginid, String username, String usermale, String usercardnum,
			String useradrprovince, String useradrcity, Integer userage, String useradrarea, String useradrother,
			MultipartFile[] pictureFile) throws Exception {

		Userinfo user = userinfoMapperCustom.selectByLoginId(userloginid);
		if (user == null) {
			return DataResult.error("账户不存在");
		}
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		int type = userlogininfo.getUserlogintype();
		if (type == 2) {
			return DataResult.error("已提交审核，不可修改");
		} else if (type == 3) {
			return DataResult.error("已通过审核，不可修改");
		} else {
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
			boolean result = userinfoMapper.updateByPrimaryKeySelective(userinfo) > 0;
			if (result) {
				return DataResult.success("修改成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("修改失败");
			}
		}

	}

	//提交审核
	@Override
	public String updateInfoToReview(Integer userloginid) throws Exception {
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (userlogininfo == null) {
			return DataResult.error("账户不存在");
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
			jsonCustormCont.put("type", "7");
			senderNotificationService.createMsgUserToAdmin(userloginid, null,1, "通知消息", "提交审核", jsonCustormCont);
			return DataResult.success("提交审核成功");
		} else {
			return DataResult.error("提交审核失败");
		}
	}

	//查询亲属信息
	@Override
	public String listFamily(Integer userloginid) throws Exception {
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		List<Familyinfo> list = familyinfoMapperCustom.findByUserLoginId(userloginid);
		return DataResult.success("获取成功", list);
	}

	//添加亲属信息
	@Override
	public String addFamily(Familyinfo familyinfo) throws Exception {
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(familyinfo.getUserloginid());
		if (userlogininfo == null) {
			return DataResult.error("账户不存在");
		}
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

	//修改亲属信息
	@Override
	public String updateFamily(Familyinfo familyinfo) throws Exception {
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(familyinfo.getUserloginid());
		if (userlogininfo==null) {
			return DataResult.error("账户不存在");
		}
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

	//删除亲属信息
	@Override
	public String deleteFamily(Integer familyid, Integer userloginid) throws Exception {
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (userlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		Familyinfo family = familyinfoMapper.selectByPrimaryKey(familyid);
		if (family == null) {
			return DataResult.error("亲属不存在");
		}
		int user = family.getUserloginid(); 
		if (user != userloginid) { 
			return  DataResult.error("账户信息不匹配"); 
		}
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

	//撤销审核
	@Override
	public String updateInfoToCancelReview(Integer userloginid) throws Exception{
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (userlogininfo == null) {
			return DataResult.error("账户不存在");
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

	//获取审核信息
	@Override
	public String getReviewInfo(Integer userloginid) throws Exception {
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (userlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		int userlogintype =  userlogininfo.getUserlogintype();
		Accounttype accounttype = accounttypeMapper.selectByPrimaryKey(userlogintype);
		
		Map<String, Object> map = new HashMap<>(16);
		map.put("type", userlogintype);
		map.put("typename", accounttype.getAccounttypename());
		if (userlogintype==3 || userlogintype== 4) {
			List<Adminexamine> list = adminexamineMapperCustom.selectByExamineTargetIdAndTypeOrderByTime(userloginid, 1);
			if (list!=null && list.size()>0) {
				map.put("msg", list.get(0).getExamineideas());
			}else {
				map.put("msg", "");
			}
		}else {
			map.put("msg", "");
		}
		return DataResult.success("获取成功", map);
	}

}
