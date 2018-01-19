package com.medical.service.impl.user;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorcalendarMapperCustom;
import com.medical.mapper.DoctorcommentMapperCustom;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.Preorder;
import com.medical.po.Usersick;
import com.medical.service.iface.user.UserHomeService;
import com.medical.utils.GeographyScope;
import com.medical.utils.result.DataResult;


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
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	@Autowired
	private PreorderMapperCustom preorderMapperCustom;

	//列表获取医生
	@Override
	public String listDoctorsInList(Integer page, String userloginlon, String userloginlat, String dochospprovince,
			String dochospcity, String dochosparea, String docprimarydept, String docseconddept, Integer type) throws Exception {
		
		PageHelper.startPage(page, 10);
		Map<String, Object> map = new HashMap<>();
		map.put("lon", userloginlon);
		map.put("lat", userloginlat);
		map.put("province", dochospprovince);
		map.put("city", dochospcity);
		map.put("area", dochosparea);
		map.put("primarydept", docprimarydept);
		map.put("seconddept", docseconddept);
		map.put("type", type);
		List<Map<String, Object>> list = doctorinfoMapperCustom.findDoctorsInList(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (type == null) {
			return DataResult.success("获取推荐医生成功", pageInfo.getList());
		} else if (type == 1) {
			return DataResult.success("按科室获取医生成功", pageInfo.getList());
		} else {
			return DataResult.success("按位置获取医生成功", pageInfo.getList());
		}

	}

	//地图获取医生
	@Override
	public String listDoctorsInMap(String userloginlat, String userloginlon) throws Exception {
		double latitude = Double.parseDouble(userloginlat);
		double longitude = Double.parseDouble(userloginlon);
		// 500千米距离
		int dis = 5000;
		Map<String, Object> map = GeographyScope.getAround(latitude, longitude, dis);
		List<Map<String, Object>> list = doctorinfoMapperCustom.findDoctorInfoInMap((double) map.get("minLat"),
				(double) map.get("maxLat"), (double) map.get("minLon"), (double) map.get("maxLon"));
		return DataResult.success("获取成功", list);
	}

	//获取医生详情
	@Override
	public String getDoctorDetail(Integer docloginid, Integer userloginid) throws Exception {
		Map<String, Object> map = doctorinfoMapperCustom.findDoctorByDocLoginId(docloginid);
		if (map != null && !map.isEmpty()) {
			List<Usersick> list = usersickMapperCustom.selectByUserLoginIdAndState(userloginid, 2);
			if (list!=null && list.size()>0) {
				List<Preorder> preorders = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, list.get(0).getUsersickid(), 4);
				if (preorders!=null && preorders.size()>0) {
					map.put("selected", true);
				}else {
					map.put("selected", false);
				}
			}else {
				map.put("selected", false);
			}
			return DataResult.success("获取成功", map);
		} else {
			return DataResult.error("该医生不存在");
		}
	}

	

	//获取医生评价
	@Override
	public String listEvaluations(Integer docloginid, Integer pageNo) throws Exception{
		PageHelper.startPage(pageNo, 5);
		List<Map<String, Object>> list = doctorcommentMapperCustom.selectByDocLoginId(docloginid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());
	}
}
