package com.medical.service.impl.doctor;


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
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorpurseMapper;
import com.medical.mapper.DoctorpurseMapperCustom;
import com.medical.mapper.PayMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorpurse;
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
	@Autowired
	private DoctorpurseMapper doctorpurseMapper;
	
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
		Map<String, Object> map = new HashMap<>();
		map.put("alipayaccount", doctorinfo.getDocalipayaccount());
		map.put("alipayname", doctorinfo.getDocalipayname());
		return DataResult.success("获取成功",map);
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
	public String updateAliPayAccount(Integer docloginid, String alipayaccount, String alipayname) throws Exception{
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo == null) {
			return DataResult.error("用户不存在");
		}
		Doctorinfo record = new Doctorinfo();
		record.setDocid(doctorinfo.getDocid());
		record.setDocalipayaccount(alipayaccount);
		record.setDocalipayname(alipayname);
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
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public  String updateBalance(Integer docloginid,Integer type,BigDecimal amount,String remark,Integer payid) throws Exception {
		//对象锁
		synchronized (docloginid) {
			Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
			if (doctorinfo == null) {
				return DataResult.error("用户不存在");
			}
			if (type!=1 && type!=2) {
				return DataResult.error("type类型有误");
			}
			if (amount.compareTo(BigDecimal.ZERO) == 0) {
				return DataResult.error("变动金额为零");
			}
			BigDecimal balance = doctorinfo.getDocpursebalance();
			Doctorpurse doctorpurserecord = new Doctorpurse();
			doctorpurserecord.setDocloginid(docloginid);
			doctorpurserecord.setDocpurseamount(amount);
			doctorpurserecord.setDocpurseremark(remark);
			doctorpurserecord.setPayid(payid);
			// 计算余额
			BigDecimal total = BigDecimal.ZERO;
			List<Doctorpurse> list = doctorpurseMapperCustom.selectByDocLoginId(docloginid);
			if (list != null && list.size() > 0) {
				for (Doctorpurse doctorpurse : list) {
					//type为1时转入2为转出
					int typeid = doctorpurse.getDocpursetypeid();
					BigDecimal price = doctorpurse.getDocpurseamount();
					if (typeid == 2) {
						total = total.subtract(price.abs());
					} else {
						total = total.add(price.abs());
					}
				}
			}
			//type为2时为减少
			if (type==2) {
				//获取账户余额
				if (amount.compareTo(balance)>0) {
					return DataResult.error("余额不足");
				}
				total = total.subtract(amount.abs());
				balance = balance.subtract(amount.abs());
				
				
				//2为转出
				doctorpurserecord.setDocpursetypeid(2);
			}else {
				total = total.add(amount.abs());
				balance = balance.add(amount.abs());
				//1为转入
				doctorpurserecord.setDocpursetypeid(1);
			}
			//账户余额
			doctorpurserecord.setDocpursebalance(total);
			doctorpurserecord.setDocpursetime(new Date());
			boolean purseresult = doctorpurseMapper.insertSelective(doctorpurserecord)>0;
			Doctorinfo doctorinforecord = new Doctorinfo();
			doctorinforecord.setDocid(doctorinfo.getDocid());
			doctorinforecord.setDocpursebalance(balance);
			boolean inforesult = doctorinfoMapper.updateByPrimaryKeySelective(doctorinforecord)>0;
			if (inforesult && purseresult) {
				return DataResult.success("账户金额变动成功");
			}else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("账户金额变动失败");
			}
		}
		
		
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

	/* (非 Javadoc)  
	* <p>Title: listTradeRecordByOrder</p>  
	* <p>Description: </p>  
	* @param userloginid
	* @param userorderid
	* @param page
	* @return  
	* @see com.medical.service.iface.doctor.DoctorPurseService#listTradeRecordByOrder(java.lang.Integer, java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listTradeRecordByOrder(Integer docloginid, Integer userorderid) {
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo == null) {
			return DataResult.error("用户不存在");
		}
		List<Map<String, Object>> list = payMapperCustom.selectByLoginIdAndTypeAndOrderId(docloginid,2,userorderid);
		return DataResult.success("获取成功", list);
	}

	/* (非 Javadoc)  
	* <p>Title: listTradeRecordByConsultation</p>  
	* <p>Description: </p>  
	* @param docloginid
	* @param hosporderid
	* @param page
	* @return  
	* @see com.medical.service.iface.doctor.DoctorPurseService#listTradeRecordByConsultation(java.lang.Integer, java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listTradeRecordByConsultation(Integer docloginid, Integer hosporderid) {
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorinfo == null) {
			return DataResult.error("用户不存在");
		}
		List<Map<String, Object>> list = payMapperCustom.selectByLoginIdAndTypeAndHospOrderId(docloginid,2,hosporderid);
		return DataResult.success("获取成功", list);
	}
	
	

}
