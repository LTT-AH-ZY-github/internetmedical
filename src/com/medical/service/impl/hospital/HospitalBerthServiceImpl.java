/**  
* @Title: HospitalBerthServiceImpl.java  
* @Package com.medical.service.impl.hospital  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月11日  
* @version V1.0  
*/  
package com.medical.service.impl.hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.util.MapComparator;
import com.medical.mapper.HospitalberthMapper;
import com.medical.mapper.HospitalberthMapperCustom;
import com.medical.mapper.HospitaldeptMapper;
import com.medical.mapper.HosplogininfoMapper;
import com.medical.po.Hospitalberth;
import com.medical.po.Hospitaldept;
import com.medical.po.Hosplogininfo;
import com.medical.service.iface.hospital.HospitalBerthService;
import com.medical.utils.result.DataResult;

/**
 * @ClassName:     HospitalBerthServiceImpl.java
 * @Description:   医院床位管理接口实现类
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月11日 下午7:19:54 
 */
public class HospitalBerthServiceImpl implements HospitalBerthService {
	@Autowired
	private HosplogininfoMapper hosplogininfoMapper;
	@Autowired
	private HospitaldeptMapper hospitaldeptMapper;
	@Autowired
	private HospitalberthMapper  hospitalberthMapper;
	@Autowired
	private HospitalberthMapperCustom  hospitalberthMapperCustom;

	/* (非 Javadoc)  
	* <p>Title: getBerthNum</p>  
	* <p>Description: 获取医院各个部门床位数</p>  
	* @param hosploginid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.hospital.HospitalBerthService#getBerthNum(java.lang.Integer)  
	*/  
	@Override
	public String getBerthNum(Integer hosploginid) throws Exception {
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		List<Map<String, Object>> list = hospitalberthMapperCustom.selectBerthCountByHospLoginId(hosploginid);
		return DataResult.success("获取成功", list);
	}

	/* (非 Javadoc)  
	* <p>Title: getOneBerthNum</p>  
	* <p>Description: 获取医院指定部门床位数</p>  
	* @param hosploginid
	* @param hospberthdeptid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.hospital.HospitalBerthService#getOneBerthNum(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String getOneBerthNum(Integer hosploginid, Integer hospberthdeptid) throws Exception {
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Hospitaldept hospitaldept = hospitaldeptMapper.selectByPrimaryKey(hospberthdeptid);
		if (hospitaldept==null) {
			return DataResult.error("部门不存在");
		}
		List<Hospitalberth> list = hospitalberthMapperCustom.selectByHospLoginIdAndHospDerthDeptId(hospberthdeptid, hosploginid);
		List<Map<String, Object>> data = new ArrayList<>();
		for (Hospitalberth hospitalberth : list) {
			Map<String, Object> map = new HashMap<>();
			map.put("hospdeptname", hospitaldept.getHospdeptname());
			map.put("hospdeptabs", hospitaldept.getHospdeptabs());
			map.put("hospberthname", hospitalberth.getHospberthname());
			map.put("hospberthabs", hospitalberth.getHospberthabs());
			map.put("hospberthid", hospitalberth.getHospberthid());
			data.add(map);
					
		}
		return DataResult.success("获取成功", data);
	}

	/* (非 Javadoc)  
	* <p>Title: addHospBerth</p>  
	* <p>Description: </p>  
	* @param hospitalberth
	* @return  
	* @see com.medical.service.iface.hospital.HospitalBerthService#addHospBerth(com.medical.po.Hospitalberth)  
	*/  
	@Override
	public String addHospBerth(Hospitalberth hospitalberth) throws Exception{
		int hosploginid =  hospitalberth.getHosploginid();
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		int deptid = hospitalberth.getHospberthdeptid();
		Hospitaldept hospitaldept = hospitaldeptMapper.selectByPrimaryKey(deptid);
		if (hospitaldept==null) {
			return DataResult.error("部门不存在");
		}
		hospitalberth.setHospberthid(null);
		boolean result = hospitalberthMapperCustom.insertSelectiveReturnId(hospitalberth)>0;
		if (result) {
			Map<String, Object> map = new HashMap<>();
			map.put("hospberthid", hospitalberth.getHospberthid());
			return DataResult.success("新增成功",map);
		}else {
			return DataResult.error("新增失败");
		}
	}

	/* (非 Javadoc)  
	* <p>Title: deleteHospBerth</p>  
	* <p>Description: </p>  
	* @param hosploginid
	* @param hospberthid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.hospital.HospitalBerthService#deleteHospBerth(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String deleteHospBerth(Integer hosploginid, Integer hospberthid) throws Exception {
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Hospitalberth hospitalberth = hospitalberthMapper.selectByPrimaryKey(hospberthid);
		if (hospitalberth==null) {
			return DataResult.error("床位不存在");
		}
		if (hosploginid!=hospitalberth.getHosploginid()) {
			return DataResult.error("账户信息不匹配");
		}
		boolean result = hospitalberthMapper.deleteByPrimaryKey(hospberthid)>0;
		if (result) {
			return DataResult.success("删除成功");
		}else {
			return DataResult.error("删除失败");
		} 
	}
	

}
