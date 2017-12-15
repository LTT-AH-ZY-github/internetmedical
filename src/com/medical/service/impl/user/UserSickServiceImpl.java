package com.medical.service.impl.user;


import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.FamilyinfoMapper;
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Familyinfo;
import com.medical.po.Preorder;
import com.medical.po.Userlogininfo;
import com.medical.po.Usersick;
import com.medical.po.UsersickCustom;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.DeleteFileService;
import com.medical.service.iface.user.UserSickService;
import com.medical.utils.PictureTool;
import com.medical.utils.StringTools;
import com.medical.utils.result.DataResult;


public class UserSickServiceImpl implements UserSickService {

	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
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
	private CommonService commonService;
	@Autowired
	private FamilyinfoMapper familyinfoMapper;
	@Autowired
	private DeleteFileService deleteFileService;
	
	/* (非 Javadoc)  
	* <p>Title: addSick</p>  
	* <p>Description: 插入病情信息</p>  
	* @param pictureFile
	* @param usersickCustom
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.user.UserSickService#addSick(org.springframework.web.multipart.MultipartFile[], com.medical.po.UsersickCustom)  
	*/  
	@Override
	public String addSick(MultipartFile[] pictureFile, UsersickCustom usersickCustom) throws Exception {
		int userloginid = usersickCustom.getUserloginid();
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user == null) {
			return DataResult.error("账号不存在");
		}
		Usersick usersick = new Usersick();
		int type = user.getUserlogintype();
		if (type!=3) {
			return DataResult.error("账号未审核,不可发布病情");
		}
		//获取对应亲属信息
		Familyinfo familyinfo = familyinfoMapper.selectByPrimaryKey(usersickCustom.getFamilyid());
		usersick.setFamilymale(familyinfo.getFamilymale());
		usersick.setFamilyname(familyinfo.getFamilyname());
		usersick.setFamilyage(familyinfo.getFamilyage());
		usersick.setFamilyid(usersickCustom.getFamilyid());
		//病情图片
		usersick.setUsersickpic(PictureTool.SavePictures(pictureFile));
		
		usersick.setUserloginid(user.getUserloginid());
		usersick.setUsersickprimarydept(usersickCustom.getUsersickprimarydept());
		usersick.setUsersickseconddept(usersickCustom.getUsersickseconddept());
		usersick.setUsersickdesc(usersickCustom.getUsersickdesc());
		//病情创建时间
		usersick.setUsersicktime(new Date());
		boolean result = usersickMapperCustom.insertSelectiveReturnId(usersick) > 0;
		if (result) {
			return DataResult.success("新增病情成功");
		} else {
			return DataResult.error("新增病情失败");
		}

	}

	/* (非 Javadoc)  
	* <p>Title: listSicks</p>  
	* <p>Description: 按type获取病情</p>  
	* @param userloginid
	* @param type
	* @param page
	* @return  
	* @see com.medical.service.iface.user.UserSickService#listSicks(java.lang.Integer, java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listSicks(Integer userloginid, Integer type,Integer page) throws Exception{
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user == null) {
			return DataResult.error("账号不存在");
		}
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list =  usersickMapperCustom.selectAllInfoByUserLoginId(userloginid, type);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());
	}
	
	
	/* (非 Javadoc)  
	* <p>Title: getSickDetail</p>  
	* <p>Description: 获取病情详情</p>  
	* @param userloginid
	* @param usersickid
	* @return  
	* @see com.medical.service.iface.user.UserSickService#getSickDetail(java.lang.Integer, java.lang.Integer)  
	*/  
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

	/* (非 Javadoc)  
	* <p>Title: deleteSick</p>  
	* <p>Description: 删除病情信息</p>  
	* @param userloginid
	* @param usersickid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.user.UserSickService#deleteSick(java.lang.Integer, java.lang.Integer)  
	*/  
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
	public String editSick(MultipartFile[] pictureFile, UsersickCustom usersickCustom) throws Exception {
		int userloginid = usersickCustom.getUserloginid();
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user == null) {
			return DataResult.error("账号不存在");
		}
		int usersickid = usersickCustom.getUsersickid();
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
		if (userSickStateId == 1) {
			String oldpath = usersickCustom.getUsersickpic();
			/*String savepath = sick.getUsersickpic();
			if (StringUtils.isBlank(savepath)) {
				savepath="";
			}
			
			if (StringUtils.isBlank(oldpath)) {
				oldpath="";
			}
			String[] saves = savepath.split(",");
			String[] olds = oldpath.split(",");
			StringTools.getParamOneDifferent(saves, olds);*/
			
			String path = PictureTool.SavePictures(pictureFile);
			if (oldpath != null) {
				if (path != null) {
					oldpath = oldpath + "," + path;
				}
			} else {
				oldpath = path;
			}
			Usersick usersick = new Usersick();
			usersick.setUsersickid(usersickid);
			usersick.setUsersickpic(oldpath);
			usersick.setFamilyid(usersickCustom.getFamilyid());
			usersick.setUsersickprimarydept(usersickCustom.getUsersickprimarydept());
			usersick.setUsersickseconddept(usersickCustom.getUsersickseconddept());
			usersick.setUsersickdesc(usersickCustom.getUsersickdesc());
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
	//待修改
	 
	
	/* (非 Javadoc)  
	* <p>Title: updateSickStateToPublish</p>  
	* <p>Description: 发布病情</p>  
	* @param userloginid
	* @param usersickid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.user.UserSickService#updateSickStateToPublish(java.lang.Integer, java.lang.Integer)  
	*/  
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
			if ((int) map.get("usersickstateid") == 2) {
				return DataResult.error("只可同时发布一个病情");
			} else if ((int) map.get("usersickstateid") == 3) {
				return DataResult.error("只可同时发布一个病情");
			}
		}
		int type = usersick.getUsersickstateid();
		if (type == 1 || type==4) {
			Usersick user = new Usersick();
			user.setUsersickid(usersickid);
			// "2"为发布状态
			user.setUsersickstateid(2);
			user.setUsersickptime(new Date());
			int result = usersickMapper.updateByPrimaryKeySelective(user);
			Map<String, Object> resultMap = commonService.listRecommendDoctors(usersick.getUsersickdesc(),
					usersick.getUsersickprimarydept(), usersick.getUsersickseconddept());
			if ("1".equals(resultMap.get("state"))) {
				List<Doctorinfo> list = (List<Doctorinfo>) resultMap.get("data");
				for (Doctorinfo doctorinfo : list) {
					Preorder preorder = new Preorder();
					preorder.setPreorderdocloginid(doctorinfo.getDocloginid());
					preorder.setUsersickid(usersickid);
					preorder.setPreordertype(1);
					preorder.setPreordertime(new Date());
					int preResult = preorderMapper.insertSelective(preorder);
					if (preResult <= 0) {
						break;
					}
				}
			}
			if (result > 0) {
				return DataResult.success("发布病情成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("发布病情失败");
			}
		} else {
			return DataResult.error("该病情不可重复发布");
		}

	}

	/* (非 Javadoc)  
	* <p>Title: updateSickStateToCancel</p>  
	* <p>Description: 取消发布</p>  
	* @param userloginid
	* @param userSickId
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.user.UserSickService#updateSickStateToCancel(java.lang.Integer, java.lang.Integer)  
	*/  
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

	/* (非 Javadoc)  
	* <p>Title: listRelatedDoctor</p>  
	* <p>Description: 获取病情医生</p>  
	* @param userloginid
	* @param preordertype
	* @param page
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.user.UserSickService#listRelatedDoctor(java.lang.Integer, java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public  String listRelatedDoctor(Integer userloginid, Integer preordertype,Integer page) throws Exception {
		List<Usersick> count = usersickMapperCustom.selectByUserLoginIdAndState(userloginid, 2);
		if (count.size() == 1) {
			int userSickId = count.get(0).getUsersickid();
			PageHelper.startPage(page, 5);
			List<Map<String, Object>> list =   preorderMapperCustom.selectByUserSickId(userSickId, preordertype);
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
			if (pageInfo!=null && pageInfo.getTotal() > 0) {
				return DataResult.success("获取数据成功", pageInfo.getList());
			} else {
				return DataResult.success("获取数据为空",null);
			}
		} else {
			if (count.size() > 1) {
				return DataResult.error("系统错误，发布的病情超过一个");
			} else {
				return DataResult.success("当前无处于发布状态的病情",null);

			}
		}
	}

	/* (非 Javadoc)  
	* <p>Title: addRelatedDoctor</p>  
	* <p>Description: 预选医生</p>  
	* @param docloginid
	* @param userloginid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.user.UserSickService#addRelatedDoctor(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String addRelatedDoctor(Integer docloginid, Integer userloginid) throws Exception {
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user == null) {
			return DataResult.error("用户不存在");
		}
		Doctorlogininfo doctorlogininfo =  doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("该医生不存在");
		}
		//int type = user.getUserlogintype();
				/*
				 * if (type!=3) { return DataResult.error("账号未审核,不可发布病情"); }
				 */
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
				return DataResult.success("当前无处于发布状态的病情",null);

			}
		}
	}
}
