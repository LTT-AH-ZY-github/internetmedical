/**
 * 
 */
package com.medical.service.impl.hospital;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.HospinfoMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HosppurseMapperCustom;
import com.medical.mapper.PayMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Hospinfo;
import com.medical.service.iface.hospital.HospitalPurseService;
import com.medical.utils.result.DataResult;

/**
 * @ClassName:     HospitalPurseServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午9:26:56 
 */
public class HospitalPurseServiceImpl implements HospitalPurseService{
	
	@Autowired
	private HospinfoMapper hospinfoMapper;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private HosppurseMapperCustom hosppurseMapperCustom;
	@Autowired
	private PayMapperCustom payMapperCustom;
	@Override
	public String getBalance(Integer hosploginid) throws Exception {
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (hospinfo == null) {
			return DataResult.error("账户不存在");
		}
		return DataResult.success("获取成功", hospinfo.getHosppursebalance());
	}
	/**
	 * @return 
	 * @Title: listBalanceRecord
	 * @Description: TODO
	 * @return: void
	 */
	
	@Override
	public String listBalanceRecord(Integer hosploginid,Integer limit,Integer offset ) throws Exception {
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = hosppurseMapperCustom.selectAllInfoByHosploginid(hosploginid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			return DataResult.success("获取数据成功", pageInfo.getList());
		} else {
			return DataResult.success("获取数据为空", null);
		}
		
	}
	@Override
	public String listTradeRecord(Integer hosploginid,Integer limit,Integer offset) throws Exception{
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = payMapperCustom.selectByLoginIdAndType(hosploginid, 3);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			return DataResult.success("获取数据成功", pageInfo.getList());
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}
	/* (non-Javadoc)
	 * @see com.medical.service.iface.hospital.HospitalPurseService#getAliPayAccount(java.lang.Integer)
	 */
	@Override
	public String getAliPayAccount(Integer hosploginid) {
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (hospinfo == null) {
			return DataResult.error("账户不存在");
		}
		return DataResult.success("获取成功", hospinfo.getHospalipayaccount());
	}
	/* (non-Javadoc)
	 * @see com.medical.service.iface.hospital.HospitalPurseService#updateAliPayAccount(java.lang.Integer, java.lang.String)
	 */
	@Override
	public String updateAliPayAccount(Integer hosploginid, String alipayaccount) {
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (hospinfo == null) {
			return DataResult.error("账户不存在");
		}
		Hospinfo record = new Hospinfo();
		record.setHospid(hospinfo.getHospid());
		record.setHospalipayaccount(alipayaccount);
		boolean result = hospinfoMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("修改成功");
		} else {
			return DataResult.error("修改失败");
		}
	}

}
