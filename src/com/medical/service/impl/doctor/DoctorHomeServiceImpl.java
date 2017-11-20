package com.medical.service.impl.doctor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorinfo;

import com.medical.service.iface.doctor.DoctorHomeService;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.PaginationResult;

import javafx.scene.chart.PieChart.Data;

public class DoctorHomeServiceImpl implements DoctorHomeService {
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	
	
/*
	// 获取病情
	@Override
	public String listSick(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon,
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
				DoctorSearch doctorSearch = new DoctorSearch();
				doctorSearch.setProvince(doctorinfo.getDochospprovince());
				doctorSearch.setCity(doctorinfo.getDochospcity());
				doctorSearch.setArea(doctorinfo.getDochosparea());
				doctorSearch.setPrimaryDept(doctorinfo.getDocprimarydept());
				doctorSearch.setSecondDept(doctorinfo.getDocseconddept());
				doctorSearch.setLat(lat);
				doctorSearch.setLon(lon);
				PageHelper.startPage(pageNo, pageSize);
				List<Map<String, Object>> list = usersickMapperCustom.paginationReSickSortByDistance(doctorSearch);
				PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
				if (page.getTotal() > 0) {
					return DataResult.success("获取推荐病情成功", page.getList());
					map.put("state", "1");
					map.put("data", page.getList());
				} else {
					return PaginationResult.error("推荐病情获取失败,因数据为空",null);
					//map.put("state", "2");
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
						return DataResult.success("获取推荐病情成功", page.getList());
						// 获取数据成功
						//map.put("state", "3");
						//map.put("data", page.getList());
					} else {
						return PaginationResult.error("推荐病情获取失败,因数据为空",null);
						//map.put("state", "4");
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
						return DataResult.success("按距离排序病情获取成功", page.getList());
					} else {
						return PaginationResult.error("按距离排序病情获取失败,因数据为空",null);
					}
				}
			}
		} else {
			return PaginationResult.error("登录id有点的个人信息为空");
			
		}
	}*/

	
	@Override
	public String listSickByRecommend(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		// 医生个人信息为空
		if (doctorinfo == null) {
			return PaginationResult.error("该用户不存在");
		}
		DoctorSearch doctorSearch = new DoctorSearch();
		doctorSearch.setLat(lat);
		doctorSearch.setLon(lon);
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = usersickMapperCustom.paginationReSickSortByDistance(doctorSearch);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		if (page!=null && page.getTotal()>0) {
			return DataResult.success("获取推荐病情成功", page.getList());
		} else {
			return PaginationResult.success("推荐病情获取失败,因数据为空", null);
		}

	}
	
	@Override
	public String listSickByTime(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		// 医生个人信息为空
		if (doctorinfo == null) {
			return PaginationResult.error("该用户不存在");
		}
		DoctorSearch doctorSearch = new DoctorSearch();
		doctorSearch.setLat(lat);
		doctorSearch.setLon(lon);
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = usersickMapperCustom.paginationSickSortByTime(doctorSearch);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		if (page!=null && page.getTotal()>0) {
			return DataResult.success("按时间排序病情获取成功", page.getList());
		} else {
		    return PaginationResult.success("按时间排序病情获取失败,因数据为空",null);
		}

	}
	
	@Override
	public String listSickByLoc(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon,String province, String city, String area) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		// 医生个人信息为空
		if (doctorinfo == null) {
			return PaginationResult.error("该用户不存在");
		}
		DoctorSearch doctorSearch = new DoctorSearch();
		doctorSearch.setLat(lat);
		doctorSearch.setLon(lon);
		doctorSearch.setProvince(province);
		doctorSearch.setCity(city);
		doctorSearch.setArea(area);
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = usersickMapperCustom.paginationSickSortByLoc(doctorSearch);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		if (page!=null && page.getTotal()>0) {
			return DataResult.success("按距离排序病情获取成功", page.getList());
		} else {
			return PaginationResult.success("按距离排序病情获取失败,因数据为空",null);
		}
	}

	// 获取病情详情
	@Override
	public String getSickDetail(Integer docloginid,Integer usersickid) throws Exception {
		Map<String, Object> data = usersickMapperCustom.selectAllInfoByUserSickId(usersickid);
		if (data!=null && !data.isEmpty()) {
			return DataResult.success("获取病情详情成功", data);
		} else {
			return PaginationResult.error("获取病情详情失败,因数据为空",null);	
		}
		
	}

	// 根据医院名迷糊查询医院
	@Override
	public String listHospital(String hospname) {
		String name = "%" + hospname + "%";
		List<Map<String, Object>> data = hospinfoMapperCustom.selectByHospName(name);
		if (data != null && data.size() > 0) {
			return DataResult.success("获取数据成功", data);
		} else {
			return DataResult.success("获取数据为空", null);
		}

	}

	// 获取医院详细
	@Override
	public String getHospitalDetail(Integer hosploginid) {
		Map<String, Object> data = hospinfoMapperCustom.selectAllInfoByHospLoginIdInDoctor(hosploginid);
		if (data != null && !data.isEmpty()) {
			return DataResult.success("获取数据成功", data);
		} else {
			return DataResult.success("获取数据为空", null);
		}

	}

}
