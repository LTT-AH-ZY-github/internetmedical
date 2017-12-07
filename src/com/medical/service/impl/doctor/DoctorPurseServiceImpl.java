/**
 * 
 */
package com.medical.service.impl.doctor;

import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.number.CurrencyFormatter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorpurseMapperCustom;
import com.medical.mapper.PayMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Userinfo;
import com.medical.po.custom.doctor.purse.Purse;
import com.medical.service.iface.doctor.DoctorPurseService;
import com.medical.utils.result.DataResult;

/**
 * @ClassName:     DoctorPurseServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 下午1:15:59 
 */
public class DoctorPurseServiceImpl implements DoctorPurseService {
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorpurseMapperCustom doctorpurseMapperCustom;
	@Autowired
	private PayMapperCustom payMapperCustom;
	/* (non-Javadoc)
	 * @see com.medical.service.iface.doctor.DoctorPurseService#getAliPayAccount(java.lang.Integer)
	 */
	@Override
	public String getAliPayAccount(Integer docloginid) throws Exception{
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo == null) {
			return DataResult.error("账户不存在");
		}
		return DataResult.success("获取成功", doctorinfo.getDocalipayaccount());
	}
	/* (non-Javadoc)
	 * @see com.medical.service.iface.doctor.DoctorPurseService#addAliPayAccount(java.lang.Integer, java.lang.String)
	 */
	@Override
	public String updateAliPayAccount(Integer docloginid, String alipayaccount) throws Exception{
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo == null) {
			return DataResult.error("账户不存在");
		}
		Doctorinfo record = new Doctorinfo();
		record.setDocid(doctorinfo.getDocid());
		record.setDocalipayaccount(alipayaccount);
		boolean result = doctorinfoMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("操作成功");
		} else {
			return DataResult.error("操作失败");
		}
	}
	/**
	 * @Title: getBalance
	 * @Description: TODO
	 * @return: void
	 * @throws Exception 
	 */
	@Override
	public String getBalance(Integer docloginid) throws Exception {
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo == null) {
			return DataResult.error("账户不存在");
		}
		return DataResult.success("获取成功", doctorinfo.getDocpursebalance());
	}
	/**
	 * @return 
	 * @Title: listBalanceRecord
	 * @Description: TODO
	 * @return: void
	 */
	
	@Override
	public String listBalanceRecord(Integer docloginid,Integer page) throws Exception {
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = doctorpurseMapperCustom.selectAllInfoByDocLoginId(docloginid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			return DataResult.success("获取数据成功", pageInfo.getList());
		} else {
			return DataResult.success("获取数据为空", null);
		}
		
	}
	@Override
	public String listTradeRecord(Integer docloginid,Integer page) throws Exception{
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = payMapperCustom.selectByLoginIdAndType(docloginid, 2);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			return DataResult.success("获取数据成功", pageInfo.getList());
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}
	
	

}
