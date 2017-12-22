/**
 * 
 */
package com.medical.service.impl.hospital;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.HospinfoMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HosppurseMapper;
import com.medical.mapper.HosppurseMapperCustom;
import com.medical.mapper.PayMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorpurse;
import com.medical.po.Hospinfo;
import com.medical.po.Hosppurse;
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
	private HosppurseMapper hosppurseMapper;
	@Autowired
	private HosppurseMapperCustom hosppurseMapperCustom;
	@Autowired
	private PayMapperCustom payMapperCustom;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public synchronized String updateBalance(Integer hosploginid,Integer type,BigDecimal amount,String remark,Integer payid) throws Exception {
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (hospinfo == null) {
			return DataResult.error("用户不存在");
		}
		if (type!=1 && type!=2) {
			return DataResult.error("type类型有误");
		}
		if (amount.compareTo(BigDecimal.ZERO) == 0) {
			return DataResult.error("变动金额为零");
		}
		BigDecimal balance = hospinfo.getHosppursebalance();
		Hosppurse hosppurserecord = new Hosppurse();
		hosppurserecord.setHosploginid(hosploginid);
		hosppurserecord.setHosppurseamount(amount);
		hosppurserecord.setHosppurseremark(remark);
		hosppurserecord.setPayid(payid);
		// 计算余额
		BigDecimal total = BigDecimal.ZERO;
		List<Hosppurse> list = hosppurseMapperCustom.selectHosploginid(hosploginid);
		if (list != null && list.size() > 0) {
			for (Hosppurse hosppurse : list) {
				int typeid = hosppurse.getHosppursetypeid();
				BigDecimal price = hosppurse.getHosppurseamount();
				if (typeid == 2) {
					total = total.subtract(price.abs());
				} else {
					total = total.add(price.abs());
				}
			}
		}
		//type为2时为减少
		if (type==2) {
			total = total.subtract(amount.abs());
			balance = balance.subtract(amount.abs());
			//获取账户余额
			if (amount.compareTo(balance)<0) {
				return DataResult.error("余额不足");
			}
			
			//2为转出
			hosppurserecord.setHosppursetypeid(2);
		}else {
			total = total.add(amount.abs());
			balance = balance.add(amount.abs());
			//1为转入
			hosppurserecord.setHosppursetypeid(1);
		}
		//账户余额
		hosppurserecord.setHosppursebalance(total);
		hosppurserecord.setHosppursetime(new Date());
		boolean purseresult = hosppurseMapper.insertSelective(hosppurserecord)>0;
		Hospinfo hospinforecord = new Hospinfo();
		hospinforecord.setHospid(hospinfo.getHospid());
		hospinforecord.setHosppursebalance(balance);
		boolean inforesult = hospinfoMapper.updateByPrimaryKeySelective(hospinforecord)>0;
		if (inforesult && purseresult) {
			return DataResult.success("账户金额变动成功");
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("账户金额变动失败");
		}
		
	}
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
	/* (non-Javadoc)
	 * @see com.medical.service.iface.hospital.HospitalPurseService#getAliPayAccount(java.lang.Integer)
	 */
	@Override
	public String getAliPayAccount(Integer hosploginid) throws Exception{
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (hospinfo == null) {
			return DataResult.error("账户不存在");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("alipayaccount", hospinfo.getHospalipayaccount());
		map.put("alipayname", hospinfo.getHospalipayname());
		return DataResult.success("获取成功", map);
	}
	/* (non-Javadoc)
	 * @see com.medical.service.iface.hospital.HospitalPurseService#updateAliPayAccount(java.lang.Integer, java.lang.String)
	 */
	@Override
	public String updateAliPayAccount(Integer hosploginid, String alipayaccount,String alipayname) {
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (hospinfo == null) {
			return DataResult.error("账户不存在");
		}
		Hospinfo record = new Hospinfo();
		record.setHospid(hospinfo.getHospid());
		record.setHospalipayaccount(alipayaccount);
		record.setHospalipayname(alipayname);
		boolean result = hospinfoMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("修改成功");
		} else {
			return DataResult.error("修改失败");
		}
	}
	/* (非 Javadoc)  
	* <p>Title: listTradeRecordByOrder</p>  
	* <p>Description: </p>  
	* @param hosploginid
	* @param userorderid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.hospital.HospitalPurseService#listTradeRecordByOrder(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listTradeRecordByOrder(Integer hosploginid, Integer userorderid) throws Exception {
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (hospinfo == null) {
			return DataResult.error("账户不存在");
		}
		List<Map<String, Object>> list = payMapperCustom.selectByLoginIdAndTypeAndOrderId(hosploginid, 3, userorderid);
		return DataResult.success("获取成功", list);
	}
	/* (非 Javadoc)  
	* <p>Title: listTradeRecordByConsultation</p>  
	* <p>Description: </p>  
	* @param hosploginid
	* @param hosporderod
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.hospital.HospitalPurseService#listTradeRecordByConsultation(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listTradeRecordByConsultation(Integer hosploginid, Integer hosporderid) throws Exception {
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (hospinfo == null) {
			return DataResult.error("账户不存在");
		}
		List<Map<String, Object>> list = payMapperCustom.selectByLoginIdAndTypeAndHospOrderId(hosploginid, 3, hosporderid);
		return DataResult.success("获取成功", list);
	}
	

}
