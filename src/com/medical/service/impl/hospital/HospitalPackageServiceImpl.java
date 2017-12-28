package com.medical.service.impl.hospital;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.HospitalpackageMapper;
import com.medical.mapper.HospitalpackageMapperCustom;
import com.medical.mapper.HosplogininfoMapper;
import com.medical.po.Hospitalpackage;
import com.medical.po.Hosplogininfo;
import com.medical.service.iface.hospital.HospitalPackageService;
import com.medical.utils.result.DataResult;

/**
 * @ClassName:     HospitalPackageServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月11日 下午8:29:10 
 */
public class HospitalPackageServiceImpl implements HospitalPackageService {
	@Autowired
	private HosplogininfoMapper hosplogininfoMapper;
	@Autowired
	private HospitalpackageMapper  hospitalpackageMapper;
	@Autowired
	private HospitalpackageMapperCustom  hospitalpackageMapperCustom;
	/* (非 Javadoc)  
	* <p>Title: addPackage</p>  
	* <p>Description: </p>  
	* @param hospitalpackage
	* @return  
	* @see com.medical.service.iface.hospital.HospitalPackageService#addPackage(com.medical.po.Hospitalpackage)  
	*/  
	@Override
	public String addPackage(Hospitalpackage hospitalpackage) throws Exception{
		int hosploginid = hospitalpackage.getHosploginid();
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		boolean result = hospitalpackageMapper.insertSelective(hospitalpackage)>0;
		if (result) {
			return DataResult.success("新增成功");
		}else {
			return DataResult.error("新增失败");
		}
	}
	/* (非 Javadoc)  
	* <p>Title: listPackages</p>  
	* <p>Description: </p>  
	* @param hosploginid
	* @param limit
	* @param offset
	* @return  
	* @see com.medical.service.iface.hospital.HospitalPackageService#listPackages(java.lang.Integer, java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listPackages(Integer hosploginid, Integer limit, Integer offset) throws Exception{
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = hospitalpackageMapperCustom.selectByHospLoginId(hosploginid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			System.out.println("数据"+pageInfo.getList());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("rows", pageInfo.getList());
			// 总共页数
			map.put("total", pageInfo.getTotal());
		
			return DataResult.success("获取成功", map);
		} else {
			return DataResult.success("获取成功", null);
		}
	}
	/* (非 Javadoc)  
	* <p>Title: editPackage</p>  
	* <p>Description: </p>  
	* @param hospitalpackage
	* @return  
	* @see com.medical.service.iface.hospital.HospitalPackageService#editPackage(com.medical.po.Hospitalpackage)  
	*/  
	@Override
	public String editPackage(Hospitalpackage hospitalpackage) throws Exception{
		int hosploginid = hospitalpackage.getHosploginid();
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		int packageid = hospitalpackage.getPackageid();
		Hospitalpackage hpackage = hospitalpackageMapper.selectByPrimaryKey(packageid);
		if (hpackage==null) {
			return DataResult.error("套餐不存在");
		}
		if (hosploginid!=hpackage.getHosploginid()) {
			return DataResult.error("账户信息不匹配");
		}
		hospitalpackage.setPackagetime(new Date());
		boolean result = hospitalpackageMapper.updateByPrimaryKeySelective(hospitalpackage)>0;
		if (result) {
			return DataResult.success("修改成功");
		}else {
			return DataResult.error("修改失败");
		}
	}
	/* (非 Javadoc)  
	* <p>Title: deletePackage</p>  
	* <p>Description: </p>  
	* @param hosploginid
	* @param packageid
	* @return  
	* @see com.medical.service.iface.hospital.HospitalPackageService#deletePackage(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String deletePackage(Integer hosploginid, Integer packageid) throws Exception{
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Hospitalpackage hospitalpackage = hospitalpackageMapper.selectByPrimaryKey(packageid);
		if (hospitalpackage==null) {
			return DataResult.error("套餐不存在");
		}
		if (hosploginid!=hospitalpackage.getHosploginid()) {
			return DataResult.error("账户信息不匹配");
		}
		boolean result = hospitalpackageMapper.deleteByPrimaryKey(packageid)>0;
		if (result) {
			return DataResult.success("删除成功");
		}else {
			return DataResult.error("删除失败");
		}
		
	}
}
