package com.medical.service.impl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.CityMapperCustom;
import com.medical.mapper.DoctorcalendarMapperCustom;
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
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorcalendar;
import com.medical.po.Doctorskd;
import com.medical.service.iface.user.UserHomeService;
import com.medical.utils.GeographyScope;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.DataResult2;

public class UserHomeServiceImpl implements UserHomeService {
	
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
	private DoctorcalendarMapperCustom doctorcalendarMapperCustom;

	// 获取医生 列表模式
	@Override
	public String listDoctor(DoctorSearch doctorSearch) throws Exception {
		PageHelper.startPage(doctorSearch.getPageNo(), doctorSearch.getPageSize());
		List<Map<String, Object>> list = doctorinfoMapperCustom.findDoctorInfoInList(doctorSearch);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			return DataResult.success("获取数据成功", pageInfo.getList());
		}else {
			return DataResult.success("获取数据为空", null);
		}
	}

	// 地图模式获取医生信息
	@Override
	public String findDoctorsInMap(String userloginlat, String userloginlon) throws Exception {
		double latitude = Double.parseDouble(userloginlat);
		double longitude = Double.parseDouble(userloginlon);
		// 5千米距离
		int dis = 50;
		Map<String, Object> map = GeographyScope.getAround(latitude, longitude, dis);
		List<Map<String, Object>> list =  doctorinfoMapperCustom.findDoctorInfoInMap((double) map.get("minLat"), (double) map.get("maxLat"),
				(double) map.get("minLon"), (double) map.get("maxLon"));
		if (list != null && list.size()>0) {
			return DataResult.success("获取成功", list);
		}else {
			return DataResult.success("获取为空", null);
		}

	}

	// 获取医生信息
	@Override
	public String findDoctorDetail(Integer docloginid) throws Exception {
		Map<String, Object> map =  doctorinfoMapperCustom.findDoctorByDocLoginId(docloginid);
		if (map != null && !map.isEmpty()) {
			return DataResult.success("获取成功", map);
		}else {
			return DataResult.success("获取为空", null);
		}
	}
	
	//获取医生日程
	@Override
	public String listCalendar(Integer docloginid,Integer page) throws Exception {
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list =  doctorcalendarMapperCustom.selectAllInfoByDocloginidInUser(docloginid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			return DataResult2.success("获取数据成功", pageInfo.getList());
		}else {
			return DataResult2.success("获取数据为空", null);
		}
	}
	
	//获取对医生评价
	@Override
	public String getEvaluation(Integer docloginid,Integer pageNo) {
		PageHelper.startPage(pageNo,5 );
		List<Map<String, Object>> list = doctorcommentMapperCustom.selectByDocLoginId(docloginid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			return DataResult.success("获取数据成功", pageInfo.getList());
		}else {
			return DataResult.success("获取数据为空", null);
		}
		
	}
}
