package com.medical.service.impl.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.medical.mapper.AdminlogininfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HospitaldeptMapper;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.mapper.HosplogininfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogininfoMapper;

import com.medical.po.Adminlogininfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Hospitaldept;
import com.medical.po.Hosplogininfo;
import com.medical.po.Userlogininfo;
import com.medical.service.iface.admin.AdminFunctionService;
import com.medical.utils.result.DataResult;




public class AdminFunctionServiceImpl implements AdminFunctionService{
	@Autowired
	private AdminlogininfoMapper adminlogininfoMapper;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private HosplogininfoMapper hosplogininfoMapper;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private HospitaldeptMapperCustom hospitaldeptMapperCustom;
	@Autowired
	private HospitaldeptMapper hospitaldeptMapper;
	
	//管理员根据用户账号类型查询用户 
	@Override
	public String listUser(Integer adminloginid,Integer limit,Integer offset,Integer type) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		int pageNo = 1; 
		if (offset!=0) {
			pageNo =  offset/limit+1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = userinfoMapperCustom.selectByUserLoginTypeInAdmin(type,0);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			//总共页数
			data.put("total", pageInfo.getTotal());
			return DataResult.success("获取数据成功", data);
		}else {
			return DataResult.success("获取数据为空", null);
		}
	}
	
	//获取用户详细信息
	@Override
	public String getUserDetail(Integer adminloginid, Integer userloginid) {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Map<String, Object> map = userinfoMapperCustom.selectInfoByLoginIdInAdmin(userloginid);
		if (map != null && !map.isEmpty()) {
			return DataResult.success("获取数据成功", map);
		}else {
			return DataResult.success("获取数据为空", null);
		}
	}
	
	//用户审核
	@Override
	public String updateUserType(Integer adminloginid, Integer userloginid, Boolean type) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(userloginid);
		if (userlogininfo == null) {
			return DataResult.error("用户账号不存在");
		}
		int userlogintype = userlogininfo.getUserlogintype();
		if (userlogintype==1) {
			return DataResult.error("用户账号未提交审核");
		}
		if (userlogintype==3) {
			return DataResult.error("用户账号已通过审核");
		}
		if (userlogintype==4) {
			return DataResult.error("用户账号处于未通过审核状态");
		}
		Userlogininfo record = new Userlogininfo();
		record.setUserloginid(userloginid);
		if (type) {
			//通过审核
			record.setUserlogintype(3);
		} else {
			//未通过审核
			record.setUserlogintype(4);
		}
		boolean result = userlogininfoMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("审核成功");
		} else {
			return DataResult.error("审核失败");
		}
	}

	// 管理员根据用户账号类型查询医生
	@Override
	public String listDoctor(Integer adminloginid, Integer limit, Integer offset, Integer type) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo == null) {
			return DataResult.error("该管理员账号不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = doctorinfoMapperCustom.selectByDocLoginTypeInAdmin(type,0);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			// 总共页数
			data.put("total", pageInfo.getTotal());
			return DataResult.success("获取数据成功", data);
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}
	
	// 管理员获取医生详情
	@Override
	public String getDoctorDetail(Integer adminloginid, Integer docloginid) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Map<String, Object> map = doctorinfoMapperCustom.selectInfoByDocLoginIdInAdmin(docloginid);
		if (map != null && !map.isEmpty()) {
			return DataResult.success("获取数据成功", map);
		}else {
			return DataResult.success("获取数据为空", null);
		}
	}
	//审核医生
	@Override
	public String updateDoctorType(Integer adminloginid, Integer docloginid, Boolean type) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("医生账号不存在");
		}
		int doclogintype = doctorlogininfo.getDoclogintype();
		if (doclogintype==1) {
			return DataResult.error("医生账号未提交审核");
		}
		if (doclogintype==3) {
			return DataResult.error("医生账号已通过审核");
		}
		if (doclogintype==4) {
			return DataResult.error("医生账号处于未通过审核状态");
		}
		Doctorlogininfo record = new Doctorlogininfo();
		record.setDocloginid(docloginid);
		if (type) {
			record.setDoclogintype(3);
		} else {
			record.setDoclogintype(4);
		}
		boolean result = doctorlogininfoMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("审核成功");
		} else {
			return DataResult.error("审核失败");
		}
	}
	
	//获取医院列表信息
	@Override
	public String listHospital(Integer adminloginid, Integer limit, Integer offset, Integer type) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo == null) {
			return DataResult.error("该管理员账号不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = hospinfoMapperCustom.selectByHospTypeInAdmin(type,0);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			// 总共页数
			data.put("total", pageInfo.getTotal());
			return DataResult.success("获取数据成功", data);
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}
	
	//获取医院详细信息
	@Override
	public String getHospitalDetail(Integer adminloginid, Integer hosploginid) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Map<String, Object> map = hospinfoMapperCustom.selectInfoByHospLoginIdInAdmin(hosploginid);
		if (map != null && !map.isEmpty()) {
			return DataResult.success("获取数据成功", map);
		}else {
			return DataResult.success("获取数据为空", null);
		}
	}
	//审核医院
	@Override
	public String updateHospitalType(Integer adminloginid, Integer hosploginid, Boolean type) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo == null) {
			return DataResult.error("医院账号不存在");
		}
		int hosplogintype = hosplogininfo.getHosplogintype();
		if (hosplogintype==1) {
			return DataResult.error("医院账号未提交审核");
		}
		if (hosplogintype==3) {
			return DataResult.error("医院账号已通过审核");
		}
		if (hosplogintype==4) {
			return DataResult.error("医院账号处于未通过审核状态");
		}
		Hosplogininfo record = new Hosplogininfo();
		record.setHosploginid(hosploginid);
		if (type) {
			record.setHosplogintype(3);
		} else {
			record.setHosplogintype(4);
		}
		boolean result = hosplogininfoMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("审核成功");
		} else {
			return DataResult.error("审核失败");
		}
	}

	
	@Override
	public String listDept(Integer adminloginid, Integer limit, Integer offset,Integer check) {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = hospitaldeptMapperCustom.selectByCheck(check,1);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("rows", pageInfo.getList());
			// 总共页数
			data.put("total", pageInfo.getTotal());
			System.out.println("数据"+pageInfo.getList());
			return DataResult.success("获取数据成功", data);
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}

	/* (non-Javadoc)
	 * @see com.medical.service.iface.admin.AdminFunctionService#checkDept(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String checkDept(Integer adminloginid, Integer hospdeptid, Integer hospdeptfatherid) {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		//审核为一级部门
		if (hospdeptfatherid==0) {
			Hospitaldept record = new Hospitaldept();
			record.setHospdeptid(hospdeptid);
			record.setHospdeptfatherid(0);
			record.setHospdeptischeck(true);
			boolean result = hospitaldeptMapper.updateByPrimaryKeySelective(record)>0;
			if (result) {
				return DataResult.success("审核成功");
			} else {
				return DataResult.error("审核失败");
			}
		}else {
			Hospitaldept hospitaldept = hospitaldeptMapper.selectByPrimaryKey(hospdeptfatherid);
			if (hospitaldept == null) {
				return DataResult.error("该一级部门不存在");
			}
			boolean check = hospitaldept.getHospdeptischeck();
			if (!check) {
				return DataResult.error("该一级部门未审核");
			}
			Hospitaldept record = new Hospitaldept();
			record.setHospdeptid(hospdeptid);
			record.setHospdeptfatherid(hospdeptfatherid);
			record.setHospdeptischeck(true);
			boolean result = hospitaldeptMapper.updateByPrimaryKeySelective(record)>0;
			if (result) {
				return DataResult.success("审核成功");
			} else {
				return DataResult.error("审核失败");
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.medical.service.iface.admin.AdminFunctionService#listFirstDept(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String listFirstDept(Integer adminloginid) {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("该管理员账号不存在");
		}
		List<Map<String, Object>> list = hospitaldeptMapperCustom.selectFirstDept();
		return DataResult.success("获取数据成功", list);
	}

	

	

}
