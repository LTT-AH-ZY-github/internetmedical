package com.medical.service.impl.admin;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.AdminlogininfoMapper;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorpurseMapper;
import com.medical.mapper.DoctorpurseMapperCustom;
import com.medical.mapper.HospinfoMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HosplogininfoMapperCustom;
import com.medical.mapper.HosppurseMapper;
import com.medical.mapper.HosppurseMapperCustom;
import com.medical.mapper.PayMapper;
import com.medical.mapper.PayMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.po.Adminlogininfo;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorpurse;
import com.medical.po.Hospinfo;
import com.medical.po.Hosppurse;
import com.medical.po.Pay;
import com.medical.po.Userinfo;
import com.medical.po.Userorder;
import com.medical.po.Usersick;

import com.medical.service.iface.CommonService;
import com.medical.service.iface.CommonTradeService;
import com.medical.service.iface.PayService;
import com.medical.service.iface.SenderNotificationService;
import com.medical.service.iface.admin.AdminCheckToFundService;
import com.medical.service.iface.doctor.DoctorPurseService;
import com.medical.service.iface.hospital.HospitalPurseService;
import com.medical.utils.result.DataResult;
import com.pay.alipay.AlipayFund;
import com.pay.alipay.MakeOrderNum;
import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

/**
 * @ClassName:     AdminFundServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月13日 上午11:27:46 
 */
public class AdminCheckToFundServiceImpl implements AdminCheckToFundService {
	
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private HospinfoMapper hospinfoMapper;
	@Autowired
	private AdminlogininfoMapper adminlogininfoMapper;
	@Autowired 
	private DoctorpurseMapperCustom doctorpurseMapperCustom;
	@Autowired 
	private DoctorpurseMapper doctorpurseMapper;
	@Autowired
	private PayMapperCustom payMapperCustom;
	@Autowired
	private HosppurseMapper hosppurseMapper;
	@Autowired
	private HosppurseMapperCustom hosppurseMapperCustom;
	@Autowired
	private UserorderMapper userorderMapper;
	@Autowired
	private UserorderMapperCustom userorderMapperCustom;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private SenderNotificationService senderNotificationService;
	@Autowired 
	private CommonTradeService commonTradeService;
	@Autowired
	private UsersickMapper usersickMapper;
	@Autowired
	private DoctorPurseService doctorPurseService;
	@Autowired
	private HospitalPurseService hospiatlPurseService;
	@Autowired
	private PayService payService;
	
	/* (非 Javadoc)  
	* <p>Title: listDoctorsToFund</p>  
	* <p>Description: </p>  
	* @param adminloginid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.admin.AdminCheckToFundService#listDoctorsToFund(java.lang.Integer)  
	*/  
	@Override
	public String listDoctorsToFund(Integer adminloginid, Integer limit, Integer offset) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = doctorinfoMapperCustom.selectAllDoctorInAdmin();
		// 用PageInfo对结果进行包装
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("rows", pageInfo.getList());
			// 总共页数
			map.put("total", pageInfo.getTotal());
			return DataResult.success("获取成功", map);
		} else {
			return DataResult.success("数据为空", null);
		}
	}
	
	/* (非 Javadoc)  
	* <p>Title: updateFundToDoctor</p>  
	* <p>Description: </p>  
	* @param adminloginid
	* @param docloginid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.admin.AdminCheckToFundService#updateFundToDoctor(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String updateFundToDoctor(Integer adminloginid, Integer docloginid) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (docloginid==null) {
			return DataResult.error("该医生不存在");
		}
		//退款的医生支付宝账号
		String payee_account= doctorinfo.getDocalipayaccount();
		//String payee_account= "pwddhi8634@sandbox.com";
		String  payee_real_name = doctorinfo.getDocalipayname();
		if (StringUtils.isBlank(payee_account)) {
			return DataResult.error("该医生支付宝账号为空");
		}
		if (StringUtils.isBlank(payee_real_name)) {
			return DataResult.error("该医生支付宝账号对应姓名为空");
		}
		//需要退的金额
		BigDecimal accountAmount = doctorinfo.getDocpursebalance();
		if (accountAmount.compareTo(BigDecimal.ZERO) == 0) {
			return DataResult.error("医生账户余额为零不可提现");
		}
		/*boolean tradestate = commonTradeService.queryDoctorFundForUpdate(docloginid);
		if (tradestate) {
			return DataResult.error("退款中,请稍后重试");
		}*/
		String prefix = "df";
		String out_biz_no = MakeOrderNum.getTradeNo(prefix);
		String amount = accountAmount+"";
		String  payer_show_name = doctorinfo.getDocname()+"账户余额提现"; 
		
		String remark=payer_show_name;
		AlipayFundTransToaccountTransferResponse response = AlipayFund.doFund(out_biz_no, payee_account, amount, payer_show_name, payee_real_name, remark);
		updateFundToDoctorFinish(response,payee_account, docloginid, doctorinfo.getDocid(), doctorinfo.getDocname(), adminloginid, doctorinfo.getDocpursebalance());
		if (response.isSuccess()) {
			//解除订单锁定
			//commonTradeService.queryDoctorFundForFinish(adminloginid);
			return DataResult.success("退款成功");
		}else {
			return DataResult.error(response.getSubMsg());
		}
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	public boolean updateFundToDoctorFinish(AlipayFundTransToaccountTransferResponse response,String payee_account,Integer docloginid,Integer docid,String docname,Integer adminloginid,BigDecimal amount) throws Exception {
		System.out.println("调用了");
		payService.updateAlipayRecordToCreat(adminloginid, "管理员", amount, docloginid, 
				docname, 0, 3, 5, response.getOutBizNo());
//		Pay payrecord = new  Pay();
//		payrecord.setPayalipaytradeno(response.getOrderId());
//		//3为退款订单
//		payrecord.setPayordertypeid(3);
//		//收款方支付宝账号
//		payrecord.setPayreceiveraccount(payee_account);
//		payrecord.setPayreceiverid(docloginid);
//		payrecord.setPayreceivername(docname);
//		payrecord.setPaycreattime(new Date());
//		payrecord.setPayinfo(response.getParams().toString());
//		payrecord.setPaymodeid(1);
//		//实收金额
//		payrecord.setPayreceiptamount(amount);
//		payrecord.setPaysenderid(adminloginid);
//		payrecord.setPaysendername("管理员");
//		//应收金额
//		payrecord.setPaytotalamount(amount);
//		payrecord.setPaytradeno(response.getOutBizNo());
//		//0为提现
//		payrecord.setPayorderid(0);
//		//5医生提现
//		payrecord.setPaytypeid(5);
		//请求成功
		Pay pay = payMapperCustom.selectByPayTradeNo(response.getOutBizNo());
		if (pay == null) {
			return false;
		}
		if (response.isSuccess()) {
//			payrecord.setPayremark("交易成功");
//			payrecord.setPayendtime(new Date());
//			payrecord.setPaystateid(3);
//			int payResult = payMapperCustom.insertSelectiveReturnId(payrecord);
			
			String payresult  = payService.updateAlipayRecordToFinish(response.getOutBizNo(), pay.getPayid(), response.getOrderId(), null, payee_account,
					response.getParams().toString(), amount, 3);
			JSONObject jsonObject = JSONObject.fromObject(payresult);
			String purseresult  = doctorPurseService.updateBalance(docloginid, 2, amount, "账户余额提现", pay.getPayid());
			JSONObject purseObject = JSONObject.fromObject(purseresult);
			if ("200".equals(jsonObject.get("code")) || "200".equals(purseObject.get("code"))) {
				System.out.println("调用了");
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return false;
			}
//			//更新账户余额
//			Doctorinfo doctorinforecord = new Doctorinfo();
//			doctorinforecord.setDocid(docid);
//			doctorinforecord.setDocpursebalance(new BigDecimal(0));
//			int result = doctorinfoMapper.updateByPrimaryKeySelective(doctorinforecord);
//			
//			//更新钱包记录
//			Doctorpurse doctorpurserecord = new Doctorpurse();
//			doctorpurserecord.setDocloginid(docloginid);
//			doctorpurserecord.setDocpurseamount(amount);
//			doctorpurserecord.setDocpurseremark("账户余额提现");
//			doctorpurserecord.setDocpursetime(new Date());
//			//2为转出
//			doctorpurserecord.setDocpursetypeid(2);
//			// 计算余额
//			BigDecimal total = new BigDecimal(0);
//			List<Doctorpurse> list = doctorpurseMapperCustom.selectByDocLoginId(docloginid);
//			if (list != null && list.size() > 0) {
//				for (Doctorpurse doctorpurse : list) {
//					//type为1时转入2为转出
//					int type = doctorpurse.getDocpursetypeid();
//					BigDecimal price = doctorpurse.getDocpurseamount();
//					if (type == 2) {
//						total = total.subtract(price.abs());
//					} else {
//						total = total.add(price.abs());
//					}
//				}
//			}
//			total=total.subtract(amount.abs());
//			doctorpurserecord.setPayid(payrecord.getPayid());
//			doctorpurserecord.setDocpursebalance(total);
//			int puerseresult = doctorpurseMapper.insertSelective(doctorpurserecord);
//			if () {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return false;
//			}
		}else {
			
			String payresult  =payService.updateAlipayRecordToCancle(response.getOutBizNo(), pay.getPayid(), response.getOrderId(), null,  payee_account,
					response.getParams().toString(),response.getSubMsg());
			JSONObject jsonObject = JSONObject.fromObject(payresult);
			if ("200".equals(jsonObject.get("code"))) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return false;
			}
//			payrecord.setPayendtime(new Date());
//			payrecord.setPaystateid(2);
//			payrecord.setPayremark(response.getSubMsg());
//			int payResult = payMapperCustom.insertSelectiveReturnId(payrecord);
//			if (payResult<=0 ) {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return false;
//			}
		}
		JSONObject jsonCustormCont = new JSONObject();
		jsonCustormCont.put("type", "7");
	    senderNotificationService.createMsgAdminToDoctor(adminloginid, docloginid, "消息通知", "已审核通过,您的余额提现成功", jsonCustormCont);
		return true;
	}
	
	@Override
	public String updateFundToHospital(Integer adminloginid, Integer hosploginid) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (hospinfo==null) {
			return DataResult.error("该医院不存在");
		}
		BigDecimal accountAmount = hospinfo.getHosppursebalance();
		if (accountAmount.compareTo(BigDecimal.ZERO) == 0) {
			return DataResult.error("医院账户余额为零不可提现");
		}
		boolean tradestate = commonTradeService.queryHospitalFundForUpdate(hosploginid);
		if (tradestate) {
			return DataResult.error("退款中,请稍后重试");
		}
		String prefix = "hf";
		String out_biz_no = MakeOrderNum.getTradeNo(prefix);
		String payee_account= hospinfo.getHospalipayaccount();
		//String payee_account= "pwddhi8634@sandbox.com";
		String  payee_real_name = hospinfo.getHospalipayname();
		if (StringUtils.isBlank(payee_account)) {
			return DataResult.error("该医院支付宝账号为空");
		}
		if (StringUtils.isBlank(payee_real_name)) {
			return DataResult.error("该医院支付宝账号对应姓名为空");
		}
		String amount = accountAmount+"";
		String  payer_show_name = hospinfo.getHospname()+"账户余额提现"; 
		String remark=payer_show_name;
		AlipayFundTransToaccountTransferResponse response = AlipayFund.doFund(out_biz_no, payee_account, amount, payer_show_name, payee_real_name, remark);
		updateFundToHospitalFinish(response, payee_account,hosploginid, hospinfo.getHospid(), hospinfo.getHospname(), adminloginid, hospinfo.getHosppursebalance());
		if (response.isSuccess()) {
			commonTradeService.queryHospitalFundForFinish(hosploginid);
			return DataResult.success("退款成功");
		}else {
			return DataResult.error(response.getSubMsg());
		}
	}
	@Transactional(rollbackFor = Exception.class)
	public boolean updateFundToHospitalFinish(AlipayFundTransToaccountTransferResponse response,String payee_account,Integer hosploginid,Integer hospid,String hospname,Integer adminloginid,BigDecimal amount) throws Exception {
		payService.updateAlipayRecordToCreat(adminloginid, "管理员", amount, hosploginid, 
				hospname, 0, 3, 5, response.getOutBizNo());
		//		Pay payrecord = new  Pay();
//		payrecord.setPayalipaytradeno(response.getOrderId());
//		payrecord.setPaysenderid(hosploginid);
//		payrecord.setPaysendername(hospname);
//		payrecord.setPaycreattime(new Date());
//		payrecord.setPayreceiveraccount(payee_account);
//		payrecord.setPayinfo(response.getBody().toString());
//		payrecord.setPaymodeid(1);
//		payrecord.setPayreceiptamount(amount);
//		//3管理员退款交易
//		payrecord.setPayordertypeid(3);
//		payrecord.setPayreceiverid(adminloginid);
//		payrecord.setPayreceivername("管理员");
//		payrecord.setPaytotalamount(amount);
//		payrecord.setPaytradeno(response.getOutBizNo());
//		payrecord.setPayorderid(0);
//		//6为医院提现
//		payrecord.setPaytypeid(6);
		Pay pay = payMapperCustom.selectByPayTradeNo(response.getOutBizNo());
		if (pay == null) {
			return false;
		}
		if (response.isSuccess()) {
			//新增交易记录
//			payrecord.setPayremark("交易成功");
//			payrecord.setPayendtime(new Date());
//			payrecord.setPaystateid(3);
//			int payResult = payMapperCustom.insertSelectiveReturnId(payrecord);
			String payresult  = payService.updateAlipayRecordToFinish(response.getOutBizNo(), pay.getPayid(), response.getOrderId(), null, payee_account,
					response.getParams().toString(), amount, 3);
			JSONObject jsonObject = JSONObject.fromObject(payresult);
			String purseresult  = hospiatlPurseService.updateBalance(hosploginid, 2, amount, "账户余额提现", pay.getPayid());
			JSONObject purseObject = JSONObject.fromObject(purseresult);
			if ("200".equals(jsonObject.get("code")) || "200".equals(purseObject.get("code"))) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return false;
			}
			//更新医院钱余额
//			Hospinfo hospinforecord = new Hospinfo();
//			hospinforecord.setHospid(hospid);
//			hospinforecord.setHosppursebalance(new BigDecimal(0));
//			int result = hospinfoMapper.updateByPrimaryKeySelective(hospinforecord);
//			//医院钱包变动
//			Hosppurse hosppurse = new Hosppurse();
//			hosppurse.setHosploginid(hosploginid);
//			hosppurse.setHosppurseamount(amount);
//			hosppurse.setHosppurseremark("账户余额提现");
//			hosppurse.setHosppursetime(new Date());
//			BigDecimal total = new BigDecimal(0);
//			List<Hosppurse> list = hosppurseMapperCustom.selectHosploginid(hosploginid);
//			if (list != null && list.size() > 0) {
//				for (Hosppurse doctorpurse : list) {
//					int type = doctorpurse.getHosppursetypeid();
//					BigDecimal price = doctorpurse.getHosppurseamount();
//					if (type == 2) {
//						total = total.subtract(price.abs());
//					} else {
//						total = total.add(price.abs());
//					}
//				}
//			}
//			total=total.subtract(amount.abs());
//			hosppurse.setHosppursebalance(total);
//			//2为转出
//			hosppurse.setHosppursetypeid(2);
//			hosppurse.setPayid(payrecord.getPayid());
//			int purseresult =hosppurseMapper.insertSelective(hosppurse);
			
		}else {
//			payrecord.setPayendtime(new Date());
//			payrecord.setPaystateid(2);
//			payrecord.setPayremark(response.getSubMsg());
//			int payResult = payMapperCustom.insertSelectiveReturnId(payrecord);
//			if (payResult<=0 ) {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return false;
//			}
			String payresult  =payService.updateAlipayRecordToCancle(response.getOutBizNo(), pay.getPayid(), response.getOrderId(), null,  payee_account,
					response.getParams().toString(),response.getSubMsg());
			JSONObject jsonObject = JSONObject.fromObject(payresult);
			if ("200".equals(jsonObject.get("code"))) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return false;
			}
		}
		JSONObject jsonCustormCont = new JSONObject();
		jsonCustormCont.put("type", "7");
		senderNotificationService.createMsgAdminToHospital(adminloginid, hosploginid, "消息通知", "已审核通过,您的余额提现成功", jsonCustormCont);
		return true;
	}
	/* (非 Javadoc)  
	* <p>Title: listhospitalsToFund</p>  
	* <p>Description: </p>  
	* @param adminloginid
	* @param limit
	* @param offset
	* @return  
	* @see com.medical.service.iface.admin.AdminCheckToFundService#listhospitalsToFund(java.lang.Integer, java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listhospitalsToFund(Integer adminloginid, Integer limit, Integer offset) throws Exception{
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = hospinfoMapperCustom.selectAllHospitalInAdmin();
		// 用PageInfo对结果进行包装
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("rows", pageInfo.getList());
			// 总共页数
			map.put("total", pageInfo.getTotal());
			return DataResult.success("获取数据成功", map);
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}
	/* (非 Javadoc)  
	* <p>Title: updateFundToUser</p>  
	* <p>Description: </p>  
	* @param adminloginid
	* @param userorderid
	* @return  
	* @see com.medical.service.iface.admin.AdminCheckToFundService#updateFundToUser(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String updateFundToUser(Integer adminloginid, Integer userorderid) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		Userorder userorder = userorderMapper.selectByPrimaryKey(userorderid);
		if (userorder==null) {
			return DataResult.error("订单不存在");
		}
		int stateid = userorder.getUserorderstateid();
		if (stateid!=8) {
			return DataResult.error("该订单状态不支持该操作");
		}
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(userorder.getUserorderhospid());
		if (hospinfo==null) {
			return DataResult.error("医院不存在");
		}
		boolean tradestate = commonTradeService.queryUserFundForUpdate(userorderid);
		if (tradestate) {
			return DataResult.error("退款中,请稍后重试");
		}
		BigDecimal totaldeposit = userorder.getUserordertotaldeposit();
		BigDecimal actualprice = userorder.getUserorderhprice();
		if (totaldeposit.compareTo(actualprice)<=0) {
			return DataResult.error("押金小于等于实际产出费用，不可退款");
		}
		//需要退的金额
		BigDecimal surplus = totaldeposit.subtract(actualprice);
		BigDecimal hospAmount = hospinfo.getHosppursebalance();
		if (surplus.compareTo(hospAmount)>0) {
			return DataResult.error("医院余额不足");
		}
		Userinfo userinfo = userinfoMapperCustom.selectByLoginId(userorder.getUserloginid());
		if (userinfo==null) {
			return DataResult.error("病人不存在");
		}
		String prefix = "uf";
		String out_biz_no = MakeOrderNum.getTradeNo(prefix);
		String payee_account= userinfo.getUseralipayaccount();
		//String payee_account= "pwddhi8634@sandbox.com";
		String  payee_real_name = userinfo.getUseralipayname();
		if (StringUtils.isBlank(payee_account)) {
			return DataResult.error("该用户支付宝账号为空");
		}
		if (StringUtils.isBlank(payee_real_name)) {
			return DataResult.error("该用户支付宝账号对应姓名为空");
		}
		String amount = surplus+"";
		//String  payer_show_name = userorder.getFamilyname()+"订单结算"; 
		String  payer_show_name = "订单结算";
		String remark=payer_show_name;
		System.out.println("病人姓名"+userorder.getFamilyname());
		AlipayFundTransToaccountTransferResponse response = AlipayFund.doFund(out_biz_no, payee_account, amount, payer_show_name, payee_real_name, remark);
		System.out.println("病人姓名response"+response);
		updateFundToUserFinish(response,payee_account, adminloginid, userorder.getUsersickid(),userorderid, userorder.getUserloginid(), userinfo.getUserid(), userinfo.getUsername(), userorder.getFamilyname(), userorder.getUserorderhospid(), hospinfo.getHospid(),hospinfo.getHospname(), surplus);
		if (response.isSuccess()) {
			commonTradeService.queryUserFundForFinish(userorderid);
			return DataResult.success("退款成功");
		}else {
			return DataResult.error(response.getSubMsg());
		}
	}
	@Transactional(rollbackFor = Exception.class)
	public boolean updateFundToUserFinish(AlipayFundTransToaccountTransferResponse response,String payee_account,Integer adminloginid,Integer usersickid,Integer userorderid,Integer userloginid,Integer userid,String username,String famiyname,Integer hosploginid,Integer hospid,String hospname,BigDecimal amount) throws Exception {
		payService.updateAlipayRecordToCreat(hosploginid, hospname, amount, userloginid,
				famiyname, userorderid, 1, 4, response.getOutBizNo());
		//		Pay payrecord = new  Pay();
//		payrecord.setPayalipaytradeno(response.getOrderId());
//		payrecord.setPayreceiverid(userloginid);
//		payrecord.setPayreceivername(famiyname);
//		payrecord.setPaycreattime(new Date());
//		payrecord.setPayreceiveraccount(payee_account);
//		payrecord.setPayinfo(response.getBody().toString());
//		payrecord.setPaymodeid(1);
//		payrecord.setPayreceiptamount(amount);
//		//1为病人订单
//	    payrecord.setPayordertypeid(1);
//		payrecord.setPaysenderid(hosploginid);
//		payrecord.setPaysendername(hospname);
//		payrecord.setPaytotalamount(amount);
//		payrecord.setPaytradeno(response.getOutBizNo());
//		payrecord.setPayorderid(userorderid);
		//4病人退款
//		payrecord.setPaytypeid(4);
		Pay pay = payMapperCustom.selectByPayTradeNo(response.getOutBizNo());
		if (pay == null) {
			return false;
		}
		if (response.isSuccess()) {
			String payresult  = payService.updateAlipayRecordToFinish(response.getOutBizNo(), pay.getPayid(), response.getOrderId(), null, payee_account,
					response.getParams().toString(), amount, 3);
			JSONObject jsonObject = JSONObject.fromObject(payresult);
			String purseresult  = hospiatlPurseService.updateBalance(hosploginid, 2, amount, famiyname+"病人退款", pay.getPayid());
			JSONObject purseObject = JSONObject.fromObject(purseresult);
			
//			payrecord.setPayremark("交易成功");
//			payrecord.setPayendtime(new Date());
//			payrecord.setPaystateid(3);
//			int payResult = payMapperCustom.insertSelectiveReturnId(payrecord);
//			Hospinfo hospinfo = hospinfoMapper.selectByPrimaryKey(hospid);
//			//变动后账户余额
//			BigDecimal num = hospinfo.getHosppursebalance().subtract(amount.abs());
//			//更新医院账户余额
//			Hospinfo hospinforecord = new Hospinfo();
//			hospinforecord.setHospid(hospid);
//			hospinforecord.setHosppursebalance(num);
//			int result = hospinfoMapper.updateByPrimaryKeySelective(hospinforecord);
//			//医院钱包变动
//			Hosppurse hosppurse = new Hosppurse();
//			hosppurse.setHosploginid(hosploginid);
//			hosppurse.setHosppurseamount(amount);
//			hosppurse.setHosppurseremark(famiyname+"病人退款");
//			hosppurse.setHosppursetime(new Date());
//			BigDecimal total = new BigDecimal(0);
//			List<Hosppurse> list = hosppurseMapperCustom.selectHosploginid(hosploginid);
//			if (list != null && list.size() > 0) {
//				for (Hosppurse doctorpurse : list) {
//					int type = doctorpurse.getHosppursetypeid();
//					BigDecimal price = doctorpurse.getHosppurseamount();
//					if (type == 2) {
//						total = total.subtract(price.abs());
//					} else {
//						total = total.add(price.abs());
//					}
//				}
//			}
//			total=total.subtract(amount.abs());
//			hosppurse.setHosppursebalance(total);
//			//2为转出
//			hosppurse.setHosppursetypeid(2);
//			hosppurse.setPayid(payrecord.getPayid());
//			int purseresult =hosppurseMapper.insertSelective(hosppurse);
			
			//更新订单状态
			Userorder userorderrecord = new Userorder();
			userorderrecord.setUserorderid(userorderid);
			//9为订单完成
			userorderrecord.setUserorderstateid(9);
			userorderrecord.setUserorderfinishtime(new Date());
			int orderresult = userorderMapper.updateByPrimaryKeySelective(userorderrecord);
			//更新病情状态
			Usersick usersick = new Usersick();
			usersick.setUsersickid(usersickid);
			//4病情结束
			usersick.setUsersickstateid(4);
			int sickresult = usersickMapper.updateByPrimaryKeySelective(usersick);
			if ("200".equals(jsonObject.get("code")) || "200".equals(purseObject.get("code")) || orderresult<=0 || sickresult<=0) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return false;
			}
		}else {
			String payresult  =payService.updateAlipayRecordToCancle(response.getOutBizNo(), pay.getPayid(), response.getOrderId(), null,  payee_account,
					response.getParams().toString(),response.getSubMsg());
			JSONObject jsonObject = JSONObject.fromObject(payresult);
			if ("200".equals(jsonObject.get("code"))) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return false;
			}
//			payrecord.setPayendtime(new Date());
//			payrecord.setPaystateid(2);
//			payrecord.setPayremark(response.getSubMsg());
//			int payResult = payMapperCustom.insertSelectiveReturnId(payrecord);
//			if (payResult<=0) {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return false;
//			}
		}
		JSONObject jsonCustormCont = new JSONObject();
		
		senderNotificationService.createMsgAdminToHospital(adminloginid, hosploginid, "消息通知", "已完成订单结算", jsonCustormCont);
		senderNotificationService.createMsgAdminToUser(adminloginid, userloginid, "消息通知", "已完成订单结算", jsonCustormCont);
		return true;
	}
	/* (非 Javadoc)  
	* <p>Title: listOrderToFund</p>  
	* <p>Description: </p>  
	* @param adminloginid
	* @return  
	* @see com.medical.service.iface.admin.AdminCheckToFundService#listOrderToFund(java.lang.Integer)  
	*/  
	@Override
	public String listOrderToFund(Integer adminloginid) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	/* (非 Javadoc)  
	* <p>Title: listOrderToFund</p>  
	* <p>Description: </p>  
	* @param adminloginid
	* @param limit
	* @param offset
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.admin.AdminCheckToFundService#listOrderToFund(java.lang.Integer, java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listOrderToFund(Integer adminloginid, Integer limit, Integer offset) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = userorderMapperCustom.listOrderToFundInAdmin();
		// 用PageInfo对结果进行包装
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("rows", pageInfo.getList());
			// 总共页数
			map.put("total", pageInfo.getTotal());
			return DataResult.success("获取数据成功", map);
		} else {
			return DataResult.success("获取数据为空", null);
		}
		
	}
	
}
