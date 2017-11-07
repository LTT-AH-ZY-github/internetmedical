package com.medical.service.impl.doctor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorinfo;

import com.medical.service.iface.doctor.DoctorHomeService;

public class DoctorHomeServiceImpl implements DoctorHomeService {
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	
	

	// 获取病情
	@Override
	public Map<String, Object> listSick(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon,
			String time, String province, String city, String area) {
		Map<String, Object> map = new HashMap<String, Object>();

		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		// 医生个人信息不为空
		if (doctorinfo != null) {
			lat = lat == null ? doctorinfo.getDocaddresslat() : lat;
			lon = lon == null ? doctorinfo.getDocaddresslon() : lon;
			// 获取推荐病情
			if ((province == null || province.trim().length() == 0) && (time == null || time.trim().length() == 0)) {
				if (lat == null || lat.trim() == "" || lat == null || lat.trim() == "") {

				}
				DoctorSearch doctorSearch = new DoctorSearch();
				doctorSearch.setProvince(doctorinfo.getDochospprovince());
				doctorSearch.setCity(doctorinfo.getDochospcity());
				doctorSearch.setArea(doctorinfo.getDochosparea());
				doctorSearch.setPrimaryDept(doctorinfo.getDocprimarydept());
				doctorSearch.setSecondDept(doctorinfo.getDocseconddept());
				doctorSearch.setLat("0");
				doctorSearch.setLat("0");
				PageHelper.startPage(pageNo, pageSize);
				List<Map<String, Object>> list = usersickMapperCustom.paginationReSickSortByDistance(doctorSearch);
				PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
				if (page.getTotal() > 0) {
					// 获取数据成功
					map.put("state", "1");
					map.put("data", page.getList());
				} else {
					map.put("state", "2");
				}

			} else {
				// 按时间排序
				if (time != null && time.trim() != "") {
					DoctorSearch doctorSearch = new DoctorSearch();
					doctorSearch.setLat(lat);
					doctorSearch.setLon(lon);
					doctorSearch.setTime(time);
					PageHelper.startPage(pageNo, pageSize);
					List<Map<String, Object>> list = usersickMapperCustom.paginationSickSortByTime(doctorSearch);
					PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
					if (!list.isEmpty()) {
						// 获取数据成功
						map.put("state", "3");
						map.put("data", page.getList());
					} else {
						map.put("state", "4");
					}
					// 按位置排序
				} else {
					DoctorSearch doctorSearch = new DoctorSearch();
					doctorSearch.setLat(lat);
					doctorSearch.setLon(lon);
					doctorSearch.setProvince(province);
					doctorSearch.setCity(city);
					doctorSearch.setArea(area);
					PageHelper.startPage(pageNo, pageSize);
					List<Map<String, Object>> list = usersickMapperCustom.paginationSickSortByLoc(doctorSearch);
					PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
					if (!list.isEmpty()) {
						// 获取数据成功
						map.put("state", "5");
						map.put("data", page.getList());
					} else {
						map.put("state", "6");
					}
				}
			}
		} else {
			// 登录id有点的个人信息为空
			map.put("state", "7");
		}

		return map;
	}

	// 获取病情详情
	@Override
	public Map<String, Object> getSickDetail(Integer usersickid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> data = usersickMapperCustom.selectAllInfoByUserSickId(usersickid);
			if (!data.isEmpty()) {
				map.put("state", "1");
				map.put("data", data);
			} else {
				map.put("state", "2");
			}
		} catch (Exception e) {
			map.put("state", "3");
		}
		return map;
	}

}
