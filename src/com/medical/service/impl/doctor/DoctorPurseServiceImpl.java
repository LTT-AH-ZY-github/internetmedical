package com.medical.service.impl.doctor;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorpurseMapperCustom;
import com.medical.mapper.PayMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.service.iface.doctor.DoctorPurseService;
import com.medical.utils.result.DataResult;

/**
 * @ClassName:     DoctorPurseServiceImpl.java
 * @Description:   用户钱包功能接口实现类
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
	
	/* (非 Javadoc)  
	* <p>Title: getAliPayAccount</p>  
	* <p>Description: 获取支付宝账号</p>  
	* @param docloginid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorPurseService#getAliPayAccount(java.lang.Integer)  
	*/  
	@Override
	public String getAliPayAccount(Integer docloginid) throws Exception{
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo == null) {
			return DataResult.error("用户不存在");
		}
		return DataResult.success("获取成功", doctorinfo.getDocalipayaccount());
	}
	
	/* (非 Javadoc)  
	* <p>Title: updateAliPayAccount</p>  
	* <p>Description: 更新支付宝账号</p>  
	* @param docloginid
	* @param alipayaccount
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorPurseService#updateAliPayAccount(java.lang.Integer, java.lang.String)  
	*/  
	@Override
	public String updateAliPayAccount(Integer docloginid, String alipayaccount) throws Exception{
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo == null) {
			return DataResult.error("用户不存在");
		}
		Doctorinfo record = new Doctorinfo();
		record.setDocid(doctorinfo.getDocid());
		record.setDocalipayaccount(alipayaccount);
		boolean result = doctorinfoMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("更新成功");
		} else {
			return DataResult.error("更新失败");
		}
	}
	
	/* (非 Javadoc)  
	* <p>Title: getBalance</p>  
	* <p>Description: 获取余额</p>  
	* @param docloginid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorPurseService#getBalance(java.lang.Integer)  
	*/  
	@Override
	public String getBalance(Integer docloginid) throws Exception {
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo == null) {
			return DataResult.error("用户不存在");
		}
		return DataResult.success("获取成功", doctorinfo.getDocpursebalance());
	}
	
	/* (非 Javadoc)  
	* <p>Title: listBalanceRecord</p>  
	* <p>Description: 获取账号金额变动</p>  
	* @param docloginid
	* @param page
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorPurseService#listBalanceRecord(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listBalanceRecord(Integer docloginid,Integer page) throws Exception {
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo == null) {
			return DataResult.error("用户不存在");
		}
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = doctorpurseMapperCustom.selectAllInfoByDocLoginId(docloginid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());
		
		
	}
	
	/* (非 Javadoc)  
	* <p>Title: listTradeRecord</p>  
	* <p>Description:获取交易记录 </p>  
	* @param docloginid
	* @param page
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorPurseService#listTradeRecord(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listTradeRecord(Integer docloginid,Integer page) throws Exception{
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo == null) {
			return DataResult.error("用户不存在");
		}
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = payMapperCustom.selectByLoginIdAndType(docloginid, 2);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());
	}
	
	

}
