package com.medical.service.impl.user;


import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.FamilyinfoMapper;
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Familyinfo;
import com.medical.po.Preorder;
import com.medical.po.Userinfo;
import com.medical.po.Userlogininfo;
import com.medical.po.Usersick;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.DeleteFileService;
import com.medical.service.iface.RecommendDoctorService;
import com.medical.service.iface.user.UserHomeService;
import com.medical.service.iface.user.UserSickService;
import com.medical.utils.PictureTool;
import com.medical.utils.result.DataResult;

import net.sf.json.JSONObject;


public class UserSickServiceImpl implements UserSickService {

	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private UsersickMapper usersickMapper;
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private PreorderMapper preorderMapper;
	@Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private FamilyinfoMapper familyinfoMapper;
	@Autowired
	private DeleteFileService deleteFileService;
	@Autowired
	private RecommendDoctorService recommendDoctorService;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private UserHomeService userHomeService;
	@Autowired
	private CommonService commonService;
	
	//新增病情 
	@Override
	public String addSick(Integer userloginid, Integer familyid, String usersickdesc, String usersickprimarydept,
			String usersickseconddept, MultipartFile[] pictureFile) throws Exception {
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		Userinfo userinfo = userinfoMapperCustom.selectByLoginId(userloginid);
		if (user == null || userinfo==null) {
			return DataResult.error("账号不存在");
		}
		Usersick usersick = new Usersick();
		int type = user.getUserlogintype();
		if (type!=3) {
			return DataResult.error("账号未审核,不可添加病情");
		}
		//获取对应亲属信息
		Familyinfo familyinfo = familyinfoMapper.selectByPrimaryKey(familyid);
		if (familyinfo==null) {
			return DataResult.error("亲属不存在");
		}
		usersick.setFamilymale(familyinfo.getFamilymale());
		usersick.setFamilyname(familyinfo.getFamilyname());
		usersick.setFamilyage(familyinfo.getFamilyage());
		usersick.setFamilyid(familyid);
		//病情图片
		usersick.setUsersickpic(PictureTool.SavePictures(pictureFile));
		usersick.setUserloginid(user.getUserloginid());
		usersick.setUsersickprimarydept(usersickprimarydept);
		usersick.setUsersickseconddept(usersickseconddept);
		usersick.setUsersickdesc(usersickdesc);
		//病情创建时间
		usersick.setUsersicktime(new Date());
		boolean result = usersickMapperCustom.insertSelectiveReturnId(usersick) > 0;
		if (result) {
			return DataResult.success("新增病情成功");
		} else {
			return DataResult.error("新增病情失败");
		}

	}

	//获取病情
	@Override
	public String listSick(Integer userloginid, Integer type,Integer page) throws Exception{
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user == null) {
			return DataResult.error("账号不存在");
		}
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list =  usersickMapperCustom.selectAllInfoByUserLoginId(userloginid, type);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());
	}
	
	
	//获取病情详情
	@Override
	public String getSickDetail(Integer userloginid,Integer usersickid) throws Exception{
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user == null) {
			return DataResult.error("账号不存在");
		}
		Map<String, Object> map =  usersickMapperCustom.selectById(usersickid);
		if (map != null && !map.isEmpty()) {
			return DataResult.success("获取数据成功", map);
		}else {
			return DataResult.error("病情不存在");
		}
	}

	//删除病情信息 
	@Override
	public String deleteSick(Integer userloginid, Integer usersickid) throws Exception {
		/*Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user == null) {
			return DataResult.error("账号不存在");
		}*/
		Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
		Integer stateid = usersick.getUsersickstateid();
		if (stateid == 2 || stateid ==3) {
			return DataResult.error("该状态不支持删除");
		}
		/*int userid = user.getUserlogindev();
		if (userloginid!=userid) {
			return DataResult.error("账号信息不匹配");
		}*/
		// 发布状态 删除相关医生
		String path = usersick.getUsersickpic();
		if (StringUtils.isNotBlank(path)) {
			deleteFileService.addFileName(path);
		}
		Usersick sickrecord = new Usersick();
		sickrecord.setUsersickid(usersickid);
		sickrecord.setUsersickisdelete(true);
		boolean result = usersickMapper.updateByPrimaryKeySelective(sickrecord) > 0;
		if (stateid == 2) {
			boolean preResult = preorderMapperCustom.deleteAllByUserSickId(usersickid)>0;
			result = preResult && result;
		}   
		if (result) {
			return DataResult.success("删除成功");
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("删除失败");
		}
	}
	
	// 修改病情信息
	@Override
	public String editSick(Integer usersickid, Integer userloginid, Integer familyid, String usersickdesc,
			String usersickprimarydept, String usersickseconddept, MultipartFile[] pictureFile, String usersickpic) throws Exception {
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user == null) {
			return DataResult.error("账号不存在");
		}
		Usersick sick = usersickMapper.selectByPrimaryKey(usersickid);
		// id对应病情不为空
		if (sick == null) {
			return DataResult.error("病情不存在");
		}
		int userid = sick.getUserloginid();
		if (userloginid!=userid) {
			return DataResult.error("账号信息不匹配");
		}
		int userSickStateId = sick.getUsersickstateid();
		if (userSickStateId == 1 || userSickStateId == 4) {
			String oldpath = usersickpic;
			String path = PictureTool.SavePictures(pictureFile);
			if (StringUtils.isNotBlank(oldpath)) {
				if (StringUtils.isNotBlank(path)) {
					oldpath = oldpath + "," + path;
				}
			} else {
				oldpath = path;
			}
			Usersick usersick = new Usersick();
			usersick.setUsersickid(usersickid);
			usersick.setUsersickpic(oldpath);
			usersick.setFamilyid(familyid);
			usersick.setUsersickprimarydept(usersickprimarydept);
			usersick.setUsersickseconddept(usersickseconddept);
			usersick.setUsersickdesc(usersickdesc);
			usersick.setUsersicktime(new Date());
			boolean result=  usersickMapper.updateByPrimaryKeySelective(usersick) > 0;
			if (result) {
				return DataResult.success("修改成功");
			} else {
				return DataResult.error("修改失败");
			}

		} else {
			return DataResult.error("该病情状态不支持修改");
		}
	}
	
	//发布病情 
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateSickStateToPublish(Integer userloginid, Integer usersickid) throws Exception {
		Userlogininfo userinfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (userinfo == null) {
			return DataResult.error("账号不存在");
		}
		Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
		if (usersick == null) {
			return DataResult.error("该病情不存在");
		}
		int userid = usersick.getUserloginid();
		if (userloginid != userid) {
			return DataResult.error("账号信息不匹配");
		}
		List<Map<String, Object>> maps = usersickMapperCustom.selectAllInfoByUserLoginId(userloginid, null);
		for (Map<String, Object> map : maps) {
			int usersickstateid = (int) map.get("usersickstateid");
			if (usersickstateid == 2 || usersickstateid==3) {
				return DataResult.error("只可同时发布一个病情");
			}
		}
		int type = usersick.getUsersickstateid();
		if (type == 1 || type==4) {
			if (type==4) {
				recommendDoctorService.deleteRecommendDoctor(usersickid, null,null);
			}
			Usersick user = new Usersick();
			user.setUsersickid(usersickid);
			// "2"为发布状态
			user.setUsersickstateid(2);
			user.setUsersickptime(new Date());
			int result = usersickMapper.updateByPrimaryKeySelective(user);
			if (result > 0) {
				recommendDoctorService.addRecommendDoctors(usersickid, userloginid, usersick.getUsersickdesc(), 
						usersick.getUsersickprimarydept(), usersick.getUsersickseconddept());
				return DataResult.success("发布病情成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("发布病情失败");
			}
		} else {
			return DataResult.error("该病情不可重复发布");
		}

	}

	//取消发布病情
	@Override
	public String updateSickStateToCancel(Integer userloginid, Integer userSickId) throws Exception {
		Usersick usersick = usersickMapper.selectByPrimaryKey(userSickId);
		if (usersick == null) {
			return DataResult.error("该病情不存在");
		}
		int type = usersick.getUsersickstateid();
		if (type == 1) {
			return DataResult.error("该病情未发布");
		} else if (type == 2) {
			Usersick user = new Usersick();
			user.setUsersickid(userSickId);
			user.setUsersickstateid(1);
			preorderMapperCustom.deleteAllByUserSickId(userSickId);
			boolean result=  usersickMapper.updateByPrimaryKeySelective(user) > 0;
			if (result) {
				return DataResult.success("取消发布成功");
			} else {
				return DataResult.error("取消发布失败");
			}
		} else if (type == 3) {
			return DataResult.error("已生成订单,不可取消");
		}  else {
			return DataResult.error("该病情已结束");
		}
	

	}

	//获取病情相关医生  
	@Override
	public  String listRelatedDoctor(Integer userloginid, Integer preordertype,Integer page) throws Exception {
		List<Usersick> count = usersickMapperCustom.selectByUserLoginIdAndState(userloginid, 2);
		if (count.size() == 1) {
			int userSickId = count.get(0).getUsersickid();
			PageHelper.startPage(page, 5);
			List<Map<String, Object>> list =   preorderMapperCustom.selectByUserSickId(userSickId, preordertype);
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
			return DataResult.success("获取成功", pageInfo.getList());
		} else {
			if (count.size() > 1) {
				return DataResult.error("系统错误，发布的病情超过一个");
			} else {
				return DataResult.success("当前无处于发布状态的病情",null);

			}
		}
	}

	//添加预选医生
	@Override
	public String addRelatedDoctor(Integer docloginid, Integer userloginid) throws Exception {
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user == null) {
			return DataResult.error("用户不存在");
		}
		Doctorlogininfo doctorlogininfo =  doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorlogininfo == null ||doctorinfo==null ) {
			return DataResult.error("该医生不存在");
		}
		String calendar = commonService.listDcotorCalendar(docloginid);
		JSONObject jsonObject =JSONObject.fromObject(calendar);
		if ("200".equals(jsonObject.get("code").toString())) {
			return calendar;
		}
		List<Map<String, Object>> data = (List<Map<String, Object>>) jsonObject.get("data");
		if (data==null || data.size()==0) {
			return DataResult.error("该医生暂无日程安排");
		}
		List<Usersick> count = usersickMapperCustom.selectByUserLoginIdAndState(userloginid, 2);
		if (count.size() == 1) {
			int usersickid = count.get(0).getUsersickid();
			Preorder preorder = new Preorder();
			preorder.setPreorderdocloginid(docloginid);
			preorder.setPreorderstate(1);
			preorder.setPreorderuserloginid(userloginid);
			List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid, 4);
			// 该医生未被选择
			if (list.size() == 0) { 
				preorder.setUsersickid(count.get(0).getUsersickid());
				// 4为预选医生
				preorder.setPreordertype(4); 
				preorder.setPreordertime(new Date());
				boolean result=  preorderMapper.insertSelective(preorder) > 0;
				if (result) {
					return DataResult.success("选择成功");
				} else {
					return DataResult.error("选择失败");
				}
			} else {
				return DataResult.error("该医生已选择");

			}
		} else {
			if (count.size() > 1) {
				return DataResult.error("系统错误，发布的病情超过一个");
			} else {
				return DataResult.error("当前无处于发布状态的病情");

			}
		}
	}
}
