package com.medical.service.impl.user;

import java.io.File;
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
import com.medical.po.Familyinfo;
import com.medical.po.Userinfo;
import com.medical.po.Userlogininfo;
import com.medical.po.UserlogininfoCustom;
import com.medical.service.iface.user.UserInfoService;
import com.medical.utils.CommonUtils;
import com.medical.utils.CreateFileUtil;
import com.medical.utils.PictureTool;

public class UserInfoServiceImpl implements UserInfoService {
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
	
	
	@Override
	public boolean updateLocation(Integer userloginid, String userloginlon, String userloginlat) {
		Userlogininfo userlogininfo = new Userlogininfo();
		userlogininfo.setUserloginid(userloginid);
		userlogininfo.setUserloginlat(userloginlat);
		userlogininfo.setUserloginlon(userloginlon);
		return userlogininfoMapper.updateByPrimaryKeySelective(userlogininfo) > 0;
	}

	// 更新channelId
	@Override
	public boolean updateChannelId(Integer userloginid, String channelid) {

		/*
		 * Userlogininfo userlogininfo =
		 * userlogininfoMapper.selectByPrimaryKey(userloginid); if (userlogininfo !=
		 * null) {
		 */
		Userlogininfo record = new Userlogininfo();
		record.setUserloginid(userloginid);
		record.setUserloginchannelid(channelid);
		return userlogininfoMapper.updateByPrimaryKeySelective(record) > 0;

		/*
		 * }else { return 3; }
		 */

	}

	// 修改用户头像和昵称
	@Override
	public String updateUserPixAndUserName(MultipartFile pictureFile, Integer userloginid, String username)
			throws Exception {
		UserlogininfoCustom userlogininfoCustom = new UserlogininfoCustom();
		userlogininfoCustom.setUserloginid(userloginid);
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (userlogininfo != null) {
				userlogininfoCustom.setUserloginname(username);
				userlogininfoCustom.setUserloginpix(PictureTool.SaveOnePicture(pictureFile));
				boolean result = userlogininfoMapper.updateByPrimaryKeySelective(userlogininfoCustom) > 0;
				if (result) {
					return userlogininfo.getUserloginpix();
				} else {
					return null;
				}
		} else {
			throw new MyException("用户不存在");
		}

	}

	// 获取用户信息
	@Override
	public Map<String, Object> findUserInfo(Integer userloginid) {
		return userinfoMapperCustom.findUserInfoByLoginId(userloginid);
	}

	// 修改用户信息
	@Override
	public boolean updateUserInfo(Integer userloginid, String username, String usermale, String usercardnum,
			String useradrprovince, String useradrcity, Integer userage, String useradrarea, String useradrother,
			MultipartFile[] pictureFile) throws Exception {

		Userinfo user = userinfoMapperCustom.selectByLoginId(userloginid);
		if (user != null) {
			Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
			boolean type = userlogininfo.getUserlogintype();
			// 未审核
			if (!type) {
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
					int result = userinfoMapper.updateByPrimaryKeySelective(userinfo);
					Familyinfo familyinfo = new Familyinfo();
					familyinfo.setFamilyage(userage);
					familyinfo.setFamilymale(usermale);
					familyinfo.setFamilyname(username);
					familyinfo.setUserloginid(userloginid);
					familyinfo.setFamilytype(true);
					// "1"为用户本人
					List<Familyinfo> list = familyinfoMapperCustom.selectByUserLoginIdAndType(userloginid, 1);
					int familyResult = 0;
					if (list.size() == 0) {
						// 插入到亲属信息表
						familyResult = familyinfoMapper.insertSelective(familyinfo);
					} else {
						Integer id = list.get(0).getFamilyid();
						familyinfo.setFamilyid(id);
						familyResult = familyinfoMapper.updateByPrimaryKey(familyinfo);
					}
					if (result > 0 && familyResult > 0) {
						return true;
					} else {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return false;
					}
					
			} else {
				throw new MyException("该用户已审核");
			}

		} else {
			throw new MyException("用户不存在");
		}

	}

	// 查询亲属信息
	@Override
	public List<Familyinfo> findFamily(Integer userloginid) {
		return familyinfoMapperCustom.findByUserLoginId(userloginid);
	}

	// 添加亲属信息
	@Override
	public boolean addFamily(Familyinfo familyinfo) throws Exception {
		List<Familyinfo> lists = familyinfoMapperCustom.selectByUserLoginIdAndInfo(familyinfo);
		if (lists.size() == 0) {
			return familyinfoMapper.insertSelective(familyinfo) > 0;
		} else {
			throw new MyException("该亲属已存在");
		}
	}

	// 修改亲属信息
	@Override
	public boolean updateFamily(Familyinfo familyinfo) throws Exception {
		Familyinfo family = familyinfoMapper.selectByPrimaryKey(familyinfo.getFamilyid());
		if (family != null) {
			boolean type = family.getFamilytype();
			if (!type) {
				return familyinfoMapper.updateByPrimaryKeySelective(familyinfo) > 0;
			} else {
				throw new MyException("本人信息无法修改");
			}
		} else {

			throw new MyException("亲属不存在");
		}

	}

	// 删除亲属信息
	@Override
	public boolean deleteFamily(Integer familyid) throws Exception {
		Familyinfo familyinfo = familyinfoMapper.selectByPrimaryKey(familyid);
		boolean type = familyinfo.getFamilytype();
		if (!type) {
			int count = usersickMapperCustom.selectCountByFamilyId(familyid);
			if (count == 0) {
				return familyinfoMapper.deleteByPrimaryKey(familyid) > 0;
			} else {
				throw new MyException("该亲属已填写病情，无法删除");
			}
		} else {
			throw new MyException("为本人信息，无法删除");

		}

	}
}
