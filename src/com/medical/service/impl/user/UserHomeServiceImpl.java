package com.medical.service.impl.user;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorcalendarMapperCustom;
import com.medical.mapper.DoctorcommentMapperCustom;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.po.DoctorSearch;
import com.medical.service.iface.user.UserHomeService;
import com.medical.utils.GeographyScope;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.DataResult2;

/**
 * @ClassName: UserHomeServiceImpl.java
 * @Description: 用户首页信息
 * @author xyh
 * @version V1.0
 * @Date 2017年12月7日 下午9:02:37
 */
public class UserHomeServiceImpl implements UserHomeService {

	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorcommentMapperCustom doctorcommentMapperCustom;
	@Autowired
	private DoctorcalendarMapperCustom doctorcalendarMapperCustom;

	/*
	 * (非 Javadoc) <p>Title: listDoctor</p> <p>Description: 获取医生 列表模式</p>
	 * 
	 * @param doctorSearch
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.user.UserHomeService#listDoctor(com.medical.po.
	 * DoctorSearch)
	 */
	@Override
	public String listDoctor(DoctorSearch doctorSearch) throws Exception {
		Integer type = doctorSearch.getType();
		PageHelper.startPage(doctorSearch.getPageNo(), doctorSearch.getPageSize());
		List<Map<String, Object>> list = doctorinfoMapperCustom.findDoctorInfoInList(doctorSearch);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (type == null) {
			return DataResult.success("获取推荐医生成功", pageInfo.getList());
		} else if (type == 1) {
			return DataResult.success("按科室获取医生成功", pageInfo.getList());
		} else {
			return DataResult.success("按位置获取医生成功", pageInfo.getList());
		}

	}

	/*
	 * (非 Javadoc) <p>Title: findDoctorsInMap</p> <p>Description: 地图模式获取医生信息</p>
	 * 
	 * @param userloginlat
	 * 
	 * @param userloginlon
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.user.UserHomeService#findDoctorsInMap(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public String findDoctorsInMap(String userloginlat, String userloginlon) throws Exception {
		double latitude = Double.parseDouble(userloginlat);
		double longitude = Double.parseDouble(userloginlon);
		// 5千米距离
		int dis = 50;
		Map<String, Object> map = GeographyScope.getAround(latitude, longitude, dis);
		List<Map<String, Object>> list = doctorinfoMapperCustom.findDoctorInfoInMap((double) map.get("minLat"),
				(double) map.get("maxLat"), (double) map.get("minLon"), (double) map.get("maxLon"));
		return DataResult.success("获取成功", list);
	}

	/*
	 * (非 Javadoc) <p>Title: findDoctorDetail</p> <p>Description: 获取医生信息</p>
	 * 
	 * @param docloginid
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.medical.service.iface.user.UserHomeService#findDoctorDetail(java.lang.
	 * Integer)
	 */
	@Override
	public String findDoctorDetail(Integer docloginid) throws Exception {
		Map<String, Object> map = doctorinfoMapperCustom.findDoctorByDocLoginId(docloginid);
		if (map != null && !map.isEmpty()) {
			return DataResult.success("获取成功", map);
		} else {
			return DataResult.error("该医生不存在");
		}
	}

	/*
	 * (非 Javadoc) <p>Title: listCalendar</p> <p>Description: 获取医生日程</p>
	 * 
	 * @param docloginid
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see com.medical.service.iface.user.UserHomeService#listCalendar(java.lang.
	 * Integer)
	 */
	@Override
	public String listCalendar(Integer docloginid) throws Exception {
		List<Map<String, Object>> list = doctorcalendarMapperCustom.selectAllInfoByDocloginidInUser(docloginid);
		return DataResult2.success("获取成功", list);
	}

	/*
	 * (非 Javadoc) <p>Title: getEvaluation</p> <p>Description: 获取对医生评价</p>
	 * 
	 * @param docloginid
	 * 
	 * @param pageNo
	 * 
	 * @return
	 * 
	 * @see com.medical.service.iface.user.UserHomeService#getEvaluation(java.lang.
	 * Integer, java.lang.Integer)
	 */
	@Override
	public String getEvaluation(Integer docloginid, Integer pageNo) {
		PageHelper.startPage(pageNo, 5);
		List<Map<String, Object>> list = doctorcommentMapperCustom.selectByDocLoginId(docloginid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());
	}
}
