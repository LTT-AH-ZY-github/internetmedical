package com.medical.service.impl.user;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import com.medical.exception.custom.MyException;
import com.medical.mapper.CityMapperCustom;
import com.medical.mapper.DoctorcommentMapper;
import com.medical.mapper.DoctorcommentMapperCustom;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.DoctorskdMapper;
import com.medical.mapper.DoctorskdMapperCustom;
import com.medical.mapper.FamilyinfoMapper;
import com.medical.mapper.FamilyinfoMapperCustom;
import com.medical.mapper.HospitalcommentMapper;
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogMapper;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Preorder;
import com.medical.po.Userlogininfo;
import com.medical.po.Usersick;
import com.medical.po.UsersickCustom;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.user.UserSickService;
import com.medical.utils.CommonUtils;
import com.medical.utils.CreateFileUtil;
import com.medical.utils.PictureTool;

public class UserSickServiceImpl implements UserSickService {
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
	@Autowired
	private UserlogininfoMapperCustom userlogininfoMapperCustom;
	@Autowired
	private UserlogMapper userlogMapper;
	@Autowired
	private FamilyinfoMapper familyinfoMapper;
	@Autowired
	private FamilyinfoMapperCustom familyinfoMapperCustom;
	@Autowired
	private CityMapperCustom cityMapperCustom;
	@Autowired
	private UsersickMapper usersickMapper;
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapperCustom doctorlogininfoMapperCustom;
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private DoctorskdMapperCustom doctorskdMapperCustom;
	@Autowired
	private DoctorskdMapper doctorskdMapper;
	@Autowired
	private PreorderMapper preorderMapper;
	@Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private UserorderMapper userorderMapper;
	@Autowired
	private UserorderMapperCustom userorderMapperCustom;
	@Autowired
	private DoctorcommentMapper doctorcommentMapper;
	@Autowired
	private HospitalcommentMapper hospitalcommentMapper;
	@Autowired
	private DoctorcommentMapperCustom doctorcommentMapperCustom;
	@Autowired
	private CommonService commonService;

	// 插入病情信息
	@Override
	public boolean addSick(MultipartFile[] pictureFile, UsersickCustom usersickCustom) throws Exception {
		int userloginid = usersickCustom.getUserloginid();
		Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (user != null) {
			Usersick usersick = new Usersick();
			boolean type = user.getUserlogintype();
			// 测试
			if (true) {
				usersick.setUsersickpic(PictureTool.SavePictures(pictureFile));
				usersick.setFamilyid(usersickCustom.getFamilyid());
				usersick.setUserloginid(user.getUserloginid());
				usersick.setUsersickprimarydept(usersickCustom.getUsersickprimarydept());
				usersick.setUsersickseconddept(usersickCustom.getUsersickseconddept());
				usersick.setUsersickdesc(usersickCustom.getUsersickdesc());
				usersick.setUsersicktime(new Date());
				return usersickMapperCustom.insertSelectiveReturnId(usersick) > 0;
			} else {
				throw new MyException("当前用户未审核，不可发布病情");
			}

		} else {
			throw new MyException("用户不存在");

		}

	}

	// 按type获取病情
	@Override
	public List<Map<String, Object>> listSicks(Integer userloginid, Integer type) {
		return usersickMapperCustom.selectAllInfoByUserLoginId(userloginid, type);
	}

	// 获取病情详情
	@Override
	public Map<String, Object> getSickDetail(Integer usersickid) {
		return usersickMapperCustom.selectById(usersickid);
	}

	// 删除病情信息
	@Override
	public boolean deleteSick(Integer userloginid, Integer usersickid) throws Exception {
		Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
		Integer stateid = usersick.getUsersickstateid();
		if (stateid < 3) {
			// 发布状态 删除相关医生
			if (stateid == 2) {
				preorderMapperCustom.deleteAllByUserSickId(usersickid);
			}
			return usersickMapper.deleteByPrimaryKey(usersickid) > 0;

		} else {
			throw new MyException("该状态不支持删除");
		}

	}
	
	// 修改病情信息
	@Override
	public boolean editSick(MultipartFile[] pictureFile, UsersickCustom usersickCustom) throws Exception {
		int usersickid = usersickCustom.getUsersickid();
		Usersick sick = usersickMapper.selectByPrimaryKey(usersickid);
		int userloginid = sick.getUserloginid();
		// id对应病情不为空
		if (sick != null) {
			int userSickStateId = sick.getUsersickstateid();
			if (userSickStateId == 1) {
				String oldpath = usersickCustom.getUsersickpic();
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
				return usersickMapper.updateByPrimaryKeySelective(usersick) > 0;

			} else {
				throw new MyException("该病情状态不支持修改");
			}

		} else {
			throw new MyException("该病情不存在");
		}

	}

	// 发布病情
	@Override
	public boolean updateSickStateToPublish(Integer userloginid, Integer usersickid) throws Exception {
		Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
		if (usersick != null) {
			int type = usersick.getUsersickstateid();
			if (type == 1) {
				List<Map<String, Object>> maps = usersickMapperCustom
						.selectAllInfoByUserLoginId(usersick.getUserloginid(), null);
				int state = 1;
				for (Map<String, Object> map : maps) {
					if ((int) map.get("usersickstateid") == 2) {
						state = 2;
						break;
					} else if ((int) map.get("usersickstateid") == 3) {
						state = 3;
						break;
					}
				}
				if (state == 1) { // 可以发布
					Usersick user = new Usersick();
					user.setUsersickid(usersickid);
					user.setUsersickstateid(2); // "2"为发布状态
					user.setUsersickptime(new Date());
					int result = usersickMapper.updateByPrimaryKeySelective(user);
					Map<String, Object> resultMap = commonService.listRecommendDoctors(usersick.getUsersickdesc(),
							usersick.getUsersickprimarydept(), usersick.getUsersickseconddept());
					boolean flag = false;
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
								flag = true;
								break;
							}
						}
						if (flag) {
							TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
							throw new MyException("推荐医生失败");

						}
					} else {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						throw new MyException("推荐医生失败");
					}
					if (result > 0 && !flag) {
						return true;
					} else {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return false; // 更新数据错误
					}
				} else if (state == 2) {
					throw new MyException("有病情已发布");

				} else {
					throw new MyException("有病情已生成订单");

				}
			} else {
				throw new MyException("该病情不可重复发布");

			}

		} else {
			throw new MyException("该Id对应的记录为空");

		}

	}

	// 取消发布
	@Override
	public boolean updateSickStateToCancel(Integer userloginid, Integer userSickId) throws Exception {
		Usersick usersick = usersickMapper.selectByPrimaryKey(userSickId);
		if (usersick != null) {
			int type = usersick.getUsersickstateid();
			if (type == 2) {
				Usersick user = new Usersick();
				user.setUsersickid(userSickId);
				user.setUsersickstateid(1);
				preorderMapperCustom.deleteAllByUserSickId(userSickId);
				return usersickMapper.updateByPrimaryKeySelective(user) > 0;

			} else if (type == 1) {
				throw new MyException("该病情未发布");

			} else if (type == 3) {
				throw new MyException("已生成订单");

			} else {
				throw new MyException("该病情已结束");

			}
		} else {
			throw new MyException("该Id对应的记录为空");

		}

	}

	// 获取病情医生
	@Override
	public List<Map<String, Object>> listRelatedDoctor(Integer userloginid, Integer preordertype) throws Exception {
		List<Usersick> list = usersickMapperCustom.selectByUserLoginIdAndState(userloginid, 2);
		if (list.size() == 1) {
			int userSickId = list.get(0).getUsersickid();
			return preorderMapperCustom.selectByUserSickId(userSickId, preordertype);
		} else {
			if (list.size() > 1) {
				throw new MyException("系统错误，发布的病情超过一个");

			} else {
				throw new MyException("没有发布的病情");

			}
		}
	}

	// 预选医生
	@Override
	public boolean addRelatedDoctor(Integer docloginid, Integer userloginid) throws Exception {

		List<Usersick> lists = usersickMapperCustom.selectByUserLoginIdAndState(userloginid, 2);
		if (lists.size() == 1) {
			int usersickid = lists.get(0).getUsersickid();
			Preorder preorder = new Preorder();
			preorder.setPreorderdocloginid(docloginid);
			preorder.setPreorderstate(1);
			preorder.setPreorderuserloginid(userloginid);
			List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid, 4);
			if (list.size() == 0) { // 该医生未被推荐
				preorder.setUsersickid(lists.get(0).getUsersickid());
				preorder.setPreordertype(4); // 预选医生
				preorder.setPreordertime(new Date());
				return preorderMapper.insertSelective(preorder) > 0;
			} else {
				throw new MyException("该医生已被选");

			}
		} else {
			if (lists.size() > 1) {
				throw new MyException("系统错误，发布的病情超过一个");

			} else {
				throw new MyException("没有发布的病情");

			}
		}

	}
}
