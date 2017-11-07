package com.medical.service.impl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorskd;
import com.medical.service.iface.user.UserHomeService;
import com.medical.utils.GeographyScope;

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

	// 获取医生 列表模式
	@Override
	public PageInfo<Map<String, Object>> listDoctor(DoctorSearch doctorSearch) throws Exception {
		PageHelper.startPage(doctorSearch.getPageNo(), doctorSearch.getPageSize());
		List<Map<String, Object>> list = doctorinfoMapperCustom.findDoctorInfoInList(doctorSearch);
		return new PageInfo<Map<String, Object>>(list);
	}

	// 地图模式获取医生信息
	@Override
	public List<Map<String, Object>> findDoctorsInMap(String userloginlat, String userloginlon) throws Exception {
		double latitude = Double.parseDouble(userloginlat);
		double longitude = Double.parseDouble(userloginlon);
		// 5千米距离
		int dis = 50;
		Map<String, Object> map = GeographyScope.getAround(latitude, longitude, dis);
		return doctorinfoMapperCustom.findDoctorInfoInMap((double) map.get("minLat"), (double) map.get("maxLat"),
				(double) map.get("minLon"), (double) map.get("maxLon"));

	}

	// 获取医生信息
	@Override
	public Map<String, Object> findDoctorDetail(Integer docloginid) throws Exception {
		Map<String, Object> doctor = doctorinfoMapperCustom.findDoctorByDocLoginId(docloginid);
		if (doctor != null) {
			Doctorskd doctorskd = doctorskdMapperCustom.selectByDocLoginId((Integer) doctor.get("docloginid"));
			if (doctorskd != null) {
				int[] arr = { doctorskd.getMonam(), doctorskd.getTueam(), doctorskd.getWedam(), doctorskd.getThuam(),
						doctorskd.getFriam(), doctorskd.getSatam(), doctorskd.getSunam(), doctorskd.getMonpm(),
						doctorskd.getTuepm(), doctorskd.getWedpm(), doctorskd.getThupm(), doctorskd.getFripm(),
						doctorskd.getSatpm(), doctorskd.getSunpm() };
				doctor.put("doctorskd", arr);
			} else {
				int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				doctor.put("doctorskd", arr);
			}
		}
		return doctor;
	}
}
