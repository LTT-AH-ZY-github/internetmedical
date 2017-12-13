package com.medical.service.impl.doctor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctoraddressMapper;
import com.medical.mapper.DoctoraddressMapperCustom;
import com.medical.mapper.DoctorcalendarMapper;
import com.medical.mapper.DoctorcalendarMapperCustom;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogMapper;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.DoctorskdMapper;
import com.medical.mapper.DoctorskdMapperCustom;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.mapper.HosporderMapper;
import com.medical.mapper.HosporderMapperCustom;
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Preorder;
import com.medical.po.Usersick;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.doctor.DoctorAccountService;
import com.medical.service.iface.doctor.DoctorHomeService;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.PaginationResult;

public class DoctorHomeServiceImpl implements DoctorHomeService {
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private DoctorlogininfoMapperCustom doctorlogininfoMapperCustom;
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private DoctorlogMapper doctorlogMapper;
	@Autowired
	private DoctorskdMapper doctorskdMapper;
	@Autowired
	private DoctorskdMapperCustom doctorskdMapperCustom;
	@Autowired
	private PreorderMapper preorderMapper;
	@Autowired
	private UserorderMapper userorderMapper;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;

	@Autowired
	private UserlogininfoMapperCustom userlogininfoMapperCustom;

	@Autowired
	private UsersickMapper usersickMapper;
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	@Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private UserorderMapperCustom userorderMapperCustom;

	@Autowired
	private HospitaldeptMapperCustom hospitaldeptMapperCustom;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DoctoraddressMapper doctoraddressMapper;
	@Autowired
	private DoctoraddressMapperCustom doctoraddressMapperCustom;
	@Autowired
	private DoctorcalendarMapper doctorcalendarMapper;
	@Autowired
	private DoctorcalendarMapperCustom doctorcalendarMapperCustom;
	@Autowired
	private DoctorAccountService doctorAccountService;
	@Autowired
	private HosporderMapper hosporderMapper;
	@Autowired
	private HosporderMapperCustom hosporderMapperCustom;

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
		if (page != null && page.getTotal() > 0) {
			return DataResult.success("获取推荐病情成功", page.getList());
		} else {
			return PaginationResult.success("推荐病情获取失败,因数据为空", null);
		}

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
		if (page != null && page.getTotal() > 0) {
			return DataResult.success("按时间排序病情获取成功", page.getList());
		} else {
			return PaginationResult.success("按时间排序病情获取失败,因数据为空", null);
		}

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
		if (page != null && page.getTotal() > 0) {
			return DataResult.success("按距离排序病情获取成功", page.getList());
		} else {
			return PaginationResult.success("按距离排序病情获取失败,因数据为空", null);
		}
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
		if (data != null && !data.isEmpty()) {
			return DataResult.success("获取病情详情成功", data);
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
			return DataResult.success("获取数据成功", data);
		} else {
			return DataResult.success("获取数据为空", null);
		}

	}

	// 获取医院详细
	@Override
	public String getHospitalDetail(Integer hosploginid) throws Exception{
		Map<String, Object> data = hospinfoMapperCustom.selectAllInfoByHospLoginIdInDoctor(hosploginid);
		if (data != null && !data.isEmpty()) {
			return DataResult.success("获取数据成功", data);
		} else {
			return DataResult.error("医院不存在");
		}

	}

	// 更改病情部门
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
		// 1为系统推荐医生
		preorderMapperCustom.deleteByUserSickIdAndPreOrderType(usersickid, 1);
		if (sickResult > 0) {
			Map<String, Object> resultMap = commonService.listRecommendDoctors(usersick.getUsersickpic(),
					usersick.getUsersickprimarydept(), usersick.getUsersickseconddept());
			boolean flag = false;
			if ("1".equals(resultMap.get("state"))) {
				@SuppressWarnings("unchecked")
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
					return DataResult.error("更改失败");
				}
				return DataResult.success("更改成功");
			} else {

				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("更改失败");
			}
		} else {
			return DataResult.error("更改失败");
		}
	}

	@Override
	public Map<String, Object> getDoctorByName(String docname) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, Object>> list = doctorinfoMapperCustom.selectByName(docname);
		if (list.size() > 0) {
			map.put("state", "1");
			map.put("data", list);
		} else {
			map.put("state", "2");
		}

		return map;
	}
}
