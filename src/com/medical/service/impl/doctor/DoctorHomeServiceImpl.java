package com.medical.service.impl.doctor;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Preorder;
import com.medical.po.Usersick;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.RecommendDoctorService;
import com.medical.service.iface.doctor.DoctorHomeService;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.PaginationResult;

public class DoctorHomeServiceImpl implements DoctorHomeService {
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private PreorderMapper preorderMapper;
	@Autowired
	private UsersickMapper usersickMapper;
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	@Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private CommonService commonService;
	@Autowired
	private RecommendDoctorService recommendDoctorService;
	// 推荐病情
	@Override
	public String listSickByRecommend(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon) throws Exception{
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		// 医生个人信息为空
		if (doctorinfo == null) {
			return PaginationResult.error("账号不存在");
		}
		DoctorSearch doctorSearch = new DoctorSearch();
		doctorSearch.setLat(lat);
		doctorSearch.setLon(lon);
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = usersickMapperCustom.paginationReSickSortByDistance(doctorSearch);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", page.getList());

	}

	// 按时间排序
	@Override
	public String listSickByTime(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon) throws Exception{
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		// 医生个人信息为空
		if (doctorinfo == null) {
			return PaginationResult.error("账号不存在");
		}
		DoctorSearch doctorSearch = new DoctorSearch();
		doctorSearch.setLat(lat);
		doctorSearch.setLon(lon);
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = usersickMapperCustom.paginationSickSortByTime(doctorSearch);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", page.getList());

	}

	// 按位置查找
	@Override
	public String listSickByLoc(Integer pageNo, Integer pageSize, Integer docloginid, String lat, String lon,
			String province, String city, String area) throws Exception{
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		// 医生个人信息为空
		if (doctorinfo == null) {
			return PaginationResult.error("账号不存在");
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
		return DataResult.success("获取成功", page.getList());
	}

	// 获取病情详情
	@Override
	public String getSickDetail(Integer docloginid, Integer usersickid) throws Exception {
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		// 医生个人信息为空
		if (doctorinfo == null) {
			return PaginationResult.error("账号不存在");
		}
		Map<String, Object> data = usersickMapperCustom.selectAllInfoByUserSickId(usersickid);
		List<Preorder> preorders = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid, 2);
		if (data != null && !data.isEmpty()) {
			if (preorders!=null && preorders.size()>0) {
				data.put("selected", true);
			}else {
				data.put("selected", false);
			}
			return DataResult.success("获取成功", data);
		} else {
			return DataResult.error("病情不存在");
		}

	}

	// 根据医院名迷糊查询医院
	@Override
	public String listHospital(String hospname) throws Exception{
		String name = "%" + hospname + "%";
		List<Map<String, Object>> data = hospinfoMapperCustom.selectByHospName(name);
		if (data != null && data.size() > 0) {
			return DataResult.success("获取成功", data);
		} else {
			return DataResult.error("该医院不存在");
		}

	}

	// 获取医院详细
	@Override
	public String getHospitalDetail(Integer hosploginid) throws Exception{
		Map<String, Object> data = hospinfoMapperCustom.selectAllInfoByHospLoginIdInDoctor(hosploginid);
		if (data != null && !data.isEmpty()) {
			return DataResult.success("获取成功", data);
		} else {
			return DataResult.error("医院不存在");
		}

	}

	// 更改病情部门
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String changeDept(Integer docloginid, Integer usersickid, String usersickprimarydept,
			String usersickseconddept) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo == null) {
			return DataResult.error("账户不存在");
		}
		int type = doctorlogininfo.getDoclogintype();
		if (type!=3) {
			return DataResult.error("账户未审核");
		}
		Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
		if (usersick == null) {
			return DataResult.error("病情不存在");
		}
		int userSickStateId = usersick.getUsersickstateid();
		if (usersick != null && userSickStateId != 2) {
			return DataResult.error("病情状态不允许修改部门");
		}
		Usersick record = new Usersick();
		record.setUsersickid(usersickid);
		record.setUsersickprimarydept(usersickprimarydept);
		record.setUsersickseconddept(usersickseconddept);
		int sickResult = usersickMapperCustom.updateDeptByPrimaryKey(record);
		if (sickResult > 0) {
			// 1为系统推荐医生
			recommendDoctorService.deleteRecommendDoctor(usersickid,null,1);
			recommendDoctorService.addRecommendDoctors(usersickid, usersick.getUserloginid(),
					usersick.getUsersickdesc(), usersick.getUsersickprimarydept(), usersick.getUsersickseconddept());
			return DataResult.success("更改成功");
		} else {
			return DataResult.error("更改失败");
		}
	}

	@Override
	public String getDoctorByName(String docname) throws Exception{
		List<Map<String, Object>> list = doctorinfoMapperCustom.selectByName(docname);
		if (list!=null && list.size()>0) {
			return DataResult.success("获取成功", list);
		}else {
			return DataResult.error("该医生不存在");
		}
		
		
	}
}
