package com.medical.service.impl.admin;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.AdminlogininfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.PayMapperCustom;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.po.Adminlogininfo;
import com.medical.po.Doctorinfo;
import com.medical.po.Hospinfo;
import com.medical.po.Pay;
import com.medical.po.Userinfo;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.service.iface.CommonTradeService;
import com.medical.service.iface.PayService;
import com.medical.service.iface.SenderNotificationService;
import com.medical.service.iface.admin.AdminCheckToFundService;
import com.medical.service.iface.doctor.DoctorPurseService;
import com.medical.service.iface.hospital.HospitalPurseService;
import com.medical.utils.MakeRandomNum;
import com.medical.utils.result.DataResult;
import com.pay.alipay.MyAliPay;
import com.pay.wxpay.MyWXPay;

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
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private AdminlogininfoMapper adminlogininfoMapper;
	@Autowired
	private PayMapperCustom payMapperCustom;
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
	
	
	/**
	 * 获取需要提现的医生
	 */
	@Override
	public String listDoctorToTransfer(Integer adminloginid, Integer limit, Integer offset) throws Exception {
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
	
	/**
	 * 提现
	 */
	@Override
	public String updateTransferToDoctor(Integer adminloginid, Integer docloginid) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("管理员账户不存在");
		}
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (docloginid==null) {
			return DataResult.error("该医生不存在");
		}
		//退款的医生支付宝账号
		String payee_account= doctorinfo.getDocalipayaccount();
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
		boolean tradestate = commonTradeService.queryDoctorFundForUpdate(docloginid);
		if (tradestate) {
			return DataResult.error("退款中,请稍后重试");
		}
		String out_biz_no = MakeRandomNum.getTradeNo("adt");
		String amount = accountAmount+"";
		String  payer_show_name = "合肥顶岭医疗科技开发有限公司"; 
		String remark=doctorinfo.getDocname()+"账户余额提现";
		int payid = payService.updatePayRecordToCreat(adminloginid, "管理员", accountAmount, docloginid, 
				doctorinfo.getDocname(), 0, 3, 5, out_biz_no,1);
		if (payid==0) {
			return DataResult.error("异常错误");
		}
		AlipayFundTransToaccountTransferResponse response = MyAliPay.doTransfer(out_biz_no, payee_account, payee_real_name, amount, payer_show_name, remark);
		if (response==null) {
			commonTradeService.queryDoctorFundForFinish(adminloginid);
      		return DataResult.success("异常错误");
		}
		boolean result = updateTransferToDoctorFinish(response,out_biz_no,payee_account, docloginid, doctorinfo.getDocid(), doctorinfo.getDocname(), adminloginid, doctorinfo.getDocpursebalance());
		//解除订单锁定
		commonTradeService.queryDoctorFundForFinish(adminloginid);
		if (response.isSuccess()) {
			if (result) {
				return DataResult.success("提现成功");
			}else {
				return DataResult.error("提现成功，本地记录保存失败");
			}
		}else {
			if (result) {
				return DataResult.success("提现失败，原因为："+response.getSubMsg());
			}else {
				return DataResult.error("提现失败，原因为："+response.getSubMsg()+"，且本地记录保存失败");
			}
		}
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	private boolean updateTransferToDoctorFinish(AlipayFundTransToaccountTransferResponse response,String out_biz_no,
			String payee_account,Integer docloginid,Integer docid,String docname,Integer adminloginid,BigDecimal amount) throws Exception {
		Pay pay = payMapperCustom.selectByPayTradeNo(out_biz_no);
		if (pay == null) {
			return false;
		}
		if (response.isSuccess()) {
			boolean payresult  = payService.updatePayRecordToFinish(pay.getPayid(), response.getOrderId(), 
					null, payee_account,response.getParams().toString(), amount);
			String purseresult  = doctorPurseService.updateBalance(docloginid, 2, amount, "账户余额提现", pay.getPayid());
			JSONObject purseObject = JSONObject.fromObject(purseresult);
			if (!payresult || "200".equals(purseObject.get("code"))) {
				  TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return false;
			}
		}else {
			boolean payresult  =payService.updatePayRecordToCancle(pay.getPayid(), response.getOrderId(), null, 
					payee_account,response.getParams().toString(),response.getSubMsg());
			if (!payresult) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return false;
			}
		}
		JSONObject jsonCustormCont = new JSONObject();
		jsonCustormCont.put("type", "7");
	    senderNotificationService.createMsgAdminToDoctor(adminloginid, docloginid, "消息通知", "已审核通过,您的余额提现成功", jsonCustormCont);
		return true;
	}
	
	/**
	 * 获取需要提现的医院
	 */
	
	@Override
	public String listHospitalToTransfer(Integer adminloginid, Integer limit, Integer offset) throws Exception{
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
	
	/**
	 * 医院余额提现
	 */
	@Override
	public String updateTransferToHospital(Integer adminloginid, Integer hosploginid) throws Exception {
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
		String out_biz_no = MakeRandomNum.getTradeNo("aht");
		String payee_account= hospinfo.getHospalipayaccount();
		String  payee_real_name = hospinfo.getHospalipayname();
		if (StringUtils.isBlank(payee_account)) {
			return DataResult.error("该医院支付宝账号为空");
		}
		if (StringUtils.isBlank(payee_real_name)) {
			return DataResult.error("该医院支付宝账号对应姓名为空");
		}
		String amount = accountAmount+"";
		String  payer_show_name = "合肥顶岭医疗科技开发有限公司"; 
		String remark=hospinfo.getHospname()+"账户余额提现";
		int payid = payService.updatePayRecordToCreat(adminloginid, "管理员", accountAmount, hosploginid, 
				hospinfo.getHospname(), 0, 3, 5, out_biz_no,1);
		if (payid==0) {
			return DataResult.success("异常错误");
		}
		AlipayFundTransToaccountTransferResponse response = MyAliPay.doTransfer(out_biz_no, payee_account, payee_real_name, amount, payer_show_name, remark);
		if (response==null) {
			commonTradeService.queryDoctorFundForFinish(adminloginid);
      		return DataResult.success("异常错误");
		}
		boolean result = updateTransferToHospitalFinish(response, out_biz_no,payee_account,hosploginid, hospinfo.getHospid(), hospinfo.getHospname(), adminloginid, hospinfo.getHosppursebalance());
		commonTradeService.queryHospitalFundForFinish(hosploginid);
		if (response.isSuccess()) {
			if (result) {
				return DataResult.success("提现成功");
			}else {
				return DataResult.error("提现成功，本地记录保存失败");
			}
		}else {
			if (result) {
				return DataResult.success("提现失败，原因为："+response.getSubMsg());
			}else {
				return DataResult.error("提现失败，原因为："+response.getSubMsg()+"，且本地记录保存失败");
			}
		}
	}
	@Transactional(rollbackFor = Exception.class)
	private boolean updateTransferToHospitalFinish(AlipayFundTransToaccountTransferResponse response,String out_biz_no,String payee_account,Integer hosploginid,Integer hospid,String hospname,Integer adminloginid,BigDecimal amount) throws Exception {
		Pay pay = payMapperCustom.selectByPayTradeNo(out_biz_no);
		if (pay == null) {
			return false;
		}
		if (response.isSuccess()) {
			boolean payresult  = payService.updatePayRecordToFinish(pay.getPayid(), response.getOrderId(), null, payee_account,
					response.getParams().toString(), amount);
			//更新医院钱余额
			String purseresult  = hospiatlPurseService.updateBalance(hosploginid, 2, amount, "账户余额提现", pay.getPayid());
			JSONObject purseObject = JSONObject.fromObject(purseresult);
			if (!payresult || "200".equals(purseObject.get("code"))) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return false;
			}
			
		}else {
			boolean payresult  =payService.updatePayRecordToCancle(pay.getPayid(), response.getOrderId(), null,  payee_account,
					response.getParams().toString(),response.getSubMsg());
			if (!payresult) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return false;
			}
		}
		JSONObject jsonCustormCont = new JSONObject();
		jsonCustormCont.put("type", "7");
		senderNotificationService.createMsgAdminToHospital(adminloginid, hosploginid, "消息通知", "已审核通过,您的余额提现成功", jsonCustormCont);
		return true;
	}

	/**
	 * 获取需要结算的订单
	 */
	@Override
	public String listOrderToTransfer(Integer adminloginid, Integer limit, Integer offset) throws Exception {
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
	
	/**
	 * 用户结算
	 */
	@Override
	public String updateTransferToUser(Integer adminloginid, Integer userorderid) throws Exception {
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
		boolean tradestate = commonTradeService.queryUserFundForUpdate(userorderid);
		if (tradestate) {
			return DataResult.error("退款中,请稍后重试");
		}
		String prefix = "uf";
		String out_biz_no = MakeRandomNum.getTradeNo(prefix);
		String payee_account= userinfo.getUseralipayaccount();
		String  payee_real_name = userinfo.getUseralipayname();
		if (StringUtils.isBlank(payee_account)) {
			return DataResult.error("该用户支付宝账号为空");
		}
		if (StringUtils.isBlank(payee_real_name)) {
			return DataResult.error("该用户支付宝账号对应姓名为空");
		}
		String amount = surplus+"";
		
		String  payer_show_name = "合肥顶岭医疗科技开发有限公司";
		String remark="订单结算";
		int payid = payService.updatePayRecordToCreat(userorder.getUserorderhospid(), hospinfo.getHospname(), surplus, userorder.getUserloginid(),
				userorder.getFamilyname(), userorderid, 1, 4, out_biz_no,1);
		if (payid==0) {
			return DataResult.success("异常错误");
		}
		AlipayFundTransToaccountTransferResponse response = MyAliPay.doTransfer(out_biz_no, payee_account, payee_real_name, amount, payer_show_name, remark);
		if (response==null) {
			commonTradeService.queryDoctorFundForFinish(adminloginid);
      		return DataResult.success("异常错误");
		}
		boolean result = updateTransferToUserFinish(response,out_biz_no,payee_account, adminloginid,
				userorder.getUsersickid(),userorderid, userorder.getUserloginid(), userinfo.getUserid(),
				userinfo.getUsername(), userorder.getFamilyname(), userorder.getUserorderhospid(), hospinfo.getHospid(),
				hospinfo.getHospname(), surplus);
		commonTradeService.queryUserFundForFinish(userorderid);
		if (response.isSuccess()) {
			if (result) {
				return DataResult.success("结算成功");
			}else {
				return DataResult.error("结算成功，本地记录保存失败");
			}
		}else {
			if (result) {
				return DataResult.success("结算失败，原因为："+response.getSubMsg());
			}else {
				return DataResult.error("结算失败，原因为："+response.getSubMsg()+"，且本地记录保存失败");
			}
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	public boolean updateTransferToUserFinish(AlipayFundTransToaccountTransferResponse response,String out_biz_no,String payee_account,Integer adminloginid,Integer usersickid,Integer userorderid,Integer userloginid,Integer userid,String username,String famiyname,Integer hosploginid,Integer hospid,String hospname,BigDecimal amount) throws Exception {
		Pay pay = payMapperCustom.selectByPayTradeNo(out_biz_no);
		if (pay == null) {
			return false;
		}
		if (response.isSuccess()) {
			
			boolean payresult  = payService.updatePayRecordToFinish(pay.getPayid(), response.getOrderId(), null, payee_account,
					response.getParams().toString(), amount);
			
			String purseresult  = hospiatlPurseService.updateBalance(hosploginid, 2, amount, famiyname+"病人退款", pay.getPayid());
			JSONObject purseObject = JSONObject.fromObject(purseresult);
			//更新订单状态
			Userorder userorderrecord = new Userorder();
			userorderrecord.setUserorderid(userorderid);
			//9为订单完成
			userorderrecord.setUserorderstateid(9);
			userorderrecord.setUserorderfinishtime(new Date());
			boolean orderresult = userorderMapper.updateByPrimaryKeySelective(userorderrecord)>0;
			//更新病情状态
			Usersick usersick = new Usersick();
			usersick.setUsersickid(usersickid);
			//4病情结束
			usersick.setUsersickstateid(4);
			boolean sickresult = usersickMapper.updateByPrimaryKeySelective(usersick)>0;
			if (!payresult || "200".equals(purseObject.get("code").toString()) || !orderresult || !sickresult) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return false;
			}
		} else {
			boolean payresult  =payService.updatePayRecordToCancle(pay.getPayid(), response.getOrderId(), null,  payee_account,
					response.getParams().toString(),response.getSubMsg());
			if (!payresult) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return false;
			}
		}
		JSONObject jsonCustormCont = new JSONObject();
		senderNotificationService.createMsgAdminToHospital(adminloginid, hosploginid, "消息通知", "已完成订单结算", jsonCustormCont);
		senderNotificationService.createMsgAdminToUser(adminloginid, userloginid, "消息通知", "已完成订单结算", jsonCustormCont);
		return true;
	}
	
	
	
	
	

	/**
	 * 获取申请退款的订单
	 */
	@Override
	public String listDoctorOrderToReFund(Integer adminloginid, Integer limit, Integer offset,Integer type) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		Map<String, Integer> key = new HashMap<>();
		key.put("type", type);
		List<Map<String, Object>> list = userorderMapperCustom.listDoctorOrderToReFundInAdmin(key);
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

	/**
	 * @Title: updateReFundToUser
	 * @Description: 审核退款
	 * @param adminloginid
	 * @param userorderid
	 * @param type
	 * @param idea
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@Override
	public String updateReFundToUser(Integer adminloginid, Integer userorderid, Boolean type, String idea) throws Exception {
		if (!type) {
			return DataResult.error("暂不支持不同意");
		}
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		Userorder userorder = userorderMapper.selectByPrimaryKey(userorderid);
		if (userorder==null) {
			return DataResult.error("订单不存在");
		}
		int stateid = userorder.getUserorderstateid();
		if (stateid!=17 && stateid!=18) {
			return DataResult.error("该订单已成功退款");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("orderid", userorder.getUserorderid());
		List<Pay> list = payMapperCustom.selectByParamsInAdmin(map);
		if (list==null || list.size()==0) {
			return DataResult.error("支付记录不存在");
		}
		if (list.size()!=1) {
			return DataResult.error("存在多条支付记录");
		}
		Pay pay = list.get(0);
		int paymodel = pay.getPaymodeid();
		String refund_reason = null;
		if (stateid==17) {
			refund_reason="用户申请退款";
		}else {
			refund_reason="医生申请退款";
		}
		String refund_amount = pay.getPayreceiptamount()+"";
		if (paymodel==1) {
			String out_request_no = MakeRandomNum.getTradeNo("aur");
			 return AlipayToReFund(userorder,pay,pay.getPaytradeno(), pay.getPayalipaytradeno(), refund_amount, refund_reason, out_request_no,idea);
			
		}else {
			String out_request_no = MakeRandomNum.getTradeNo("wur");
			//微信支付
			return WXPayToReFund(userorder, pay, pay.getPaytradeno(), pay.getPayalipaytradeno(), refund_amount, refund_reason, out_request_no, idea);
		}
		
	}
	
	
	
	/**
	 *支付宝退款
	 */
	private String AlipayToReFund(Userorder userorder,Pay pay,String out_trade_no,String trade_no,String refund_amount,String refund_reason ,String out_request_no,String idea) throws Exception {
		int payid  = payService.updatePayRecordToCreat(pay.getPayreceiverid(), pay.getPayreceivername(), pay.getPayreceiptamount(), pay.getPaysenderid(), pay.getPaysendername(), pay.getPayid(), 4, 7, out_request_no, 1);
		if (payid==0) {
			return DataResult.error("异常错误");
		}
		AlipayTradeRefundResponse response= MyAliPay.doReFund( trade_no, refund_amount, refund_reason, out_request_no);
		if (response==null) {
			return DataResult.error("异常错误");
		}
		if (response.isSuccess()) {
			return afterRefundSuccess(userorder, pay, out_trade_no, trade_no, refund_amount, refund_reason, out_request_no, idea, response.getBody());
			
		}else {
			boolean payresult  =payService.updatePayRecordToCancle(payid, pay.getPayid()+"", pay.getPayreceiveraccount(), pay.getPaysenderaccount(),
					response.getParams().toString(),response.getSubMsg());
			if (payresult) {
				return DataResult.success("退款失败,原因为："+response.getSubMsg());
			}else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("退款失败,原因为："+response.getSubMsg()+"，且本地记录修改失败");
			}
		}
		
	}
	/**
	 * @Title: afterRefundSuccess
	 * @Description: TODO
	 * @return: void
	 * @throws Exception 
	 */
	private String afterRefundSuccess(Userorder userorder,Pay pay,String out_trade_no,String trade_no,String refund_amount,String refund_reason ,String out_request_no,String idea,String remark) throws Exception {
		boolean payFinishResult = payService.updatePayRecordToFinish(pay.getPayid(), out_request_no, pay.getPayreceiveraccount(), pay.getPaysenderaccount(), remark, new BigDecimal(refund_amount));
		String purseresult  = doctorPurseService.updateBalance(userorder.getUserorderdocloginid(), 2, pay.getPaytotalamount(), userorder.getFamilyname()+"用户退款", pay.getPayid());
		JSONObject purseObject = JSONObject.fromObject(purseresult);
		//更新订单状态
		Userorder userorderrecord = new Userorder();
		userorderrecord.setUserorderid(userorder.getUserorderid());
		//19退款成功
		userorderrecord.setUserorderstateid(19);
		userorderrecord.setUserorderfinishtime(new Date());
		userorderrecord.setAuditopinion(idea);
		boolean orderresult = userorderMapper.updateByPrimaryKeySelective(userorderrecord)>0;
		//更新病情状态
		Usersick usersick = new Usersick();
		usersick.setUsersickid(userorder.getUsersickid());
		//4病情结束
		usersick.setUsersickstateid(4);
		boolean sickresult = usersickMapper.updateByPrimaryKeySelective(usersick)>0;
		if (!payFinishResult || "200".equals(purseObject.get("code").toString()) || !orderresult || !sickresult) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("退款成功，但本地记录修改失败");
		}else {
			return DataResult.success("操作成功");
		}

	}
	/**
	 *微信退款
	 */
	private String WXPayToReFund(Userorder userorder, Pay pay, String out_trade_no, String trade_no,
			String refund_amount, String refund_reason, String out_request_no, String idea) throws Exception {
		int payid = payService.updatePayRecordToCreat(pay.getPayreceiverid(), pay.getPayreceivername(),
				pay.getPayreceiptamount(), pay.getPaysenderid(), pay.getPaysendername(), pay.getPayid(), 4, 7,
				out_request_no, 1);
		if (payid == 0) {
			return DataResult.error("异常错误");
		}
		Map<String, String> map = MyWXPay.doRefund(trade_no, out_request_no, new BigDecimal(refund_amount),
				new BigDecimal(refund_amount), idea);
		if (map == null) {
			return DataResult.error("异常错误");
		}
		if ("FAIL".equals(map.get("return_code"))) {
			return DataResult.error("通信异常");
		}
		if ("FAIL".equals(map.get("result_code"))) {
			boolean payresult = payService.updatePayRecordToCancle(payid, pay.getPayid() + "",
					pay.getPayreceiveraccount(), pay.getPaysenderaccount(), map.toString(), map.get("err_code_des"));
			if (payresult) {
				return DataResult.success("退款失败,原因为：" + map.get("err_code_des"));
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("退款失败,原因为：" + map.get("err_code_des") + "，且本地记录修改失败");
			}
		}
		return afterRefundSuccess(userorder, pay, out_trade_no, trade_no, refund_amount, refund_reason, out_request_no, idea, map.toString());
//		boolean payFinishResult = payService.updatePayRecordToFinish(payid, out_request_no, pay.getPayreceiveraccount(),
//				pay.getPaysenderaccount(), map.toString(), new BigDecimal(map.get("refund_fee")));
//		String purseresult = doctorPurseService.updateBalance(userorder.getUserorderdocloginid(), 2,
//				pay.getPaytotalamount(), userorder.getFamilyname() + "用户退款", pay.getPayid());
//		JSONObject purseObject = JSONObject.fromObject(purseresult);
//		// 更新订单状态
//		Userorder userorderrecord = new Userorder();
//		userorderrecord.setUserorderid(userorder.getUserorderid());
//		// 19退款成功
//		userorderrecord.setUserorderstateid(19);
//		userorderrecord.setUserorderfinishtime(new Date());
//		userorderrecord.setAuditopinion(idea);
//		boolean orderresult = userorderMapper.updateByPrimaryKeySelective(userorderrecord) > 0;
//		// 更新病情状态
//		Usersick usersick = new Usersick();
//		usersick.setUsersickid(userorder.getUsersickid());
//		// 4病情结束
//		usersick.setUsersickstateid(4);
//		boolean sickresult = usersickMapper.updateByPrimaryKeySelective(usersick) > 0;
//		if (!payFinishResult || "200".equals(purseObject.get("code").toString()) || !orderresult || !sickresult) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			return DataResult.error("退款成功，但本地记录修改失败");
//		} else {
//			return DataResult.success("操作成功");
//		}

	}
	@Override
	public String getAlipayRecord(String out_trade_no ,String trade_no) {
		AlipayTradeQueryResponse response = MyAliPay.doOrderQuery(out_trade_no, trade_no);
		if (response==null) {
			return DataResult.error("查询失败");
		}
		if (response.isSuccess()) {
			Map<String, Object> map = new HashMap<>();
			map.put("trade_no", response.getTradeNo());	
			map.put("out_trade_no", response.getOutTradeNo());
			map.put("buyer_logon_id", response.getBuyerLogonId());
			map.put("trade_status", response.getTradeStatus());
			map.put("total_amount", response.getTotalAmount());
			map.put("receipt_amount", response.getReceiptAmount());
			map.put("buyer_pay_amount", response.getBuyerPayAmount());
			map.put("point_amount", response.getPointAmount());
			map.put("invoice_amount", response.getInvoiceAmount());
			map.put("send_pay_date", response.getSendPayDate());
			map.put("store_id", response.getStoreId());
			map.put("terminal_id", response.getTerminalId());
			map.put("fund_bill_list", response.getFundBillList());
			map.put("store_name", response.getStoreName());
			map.put("buyer_user_id", response.getBuyerUserId());
			map.put("buyer_user_type", response.getBuyerUserType());
			return DataResult.success("查询成功", map);
		}else {
			return DataResult.error("查询失败，原因为："+response.getSubMsg());
		}
		

	}

	/**
	 * 查找支付宝账单
	 */
	@Override
	public String getAlipayBill(Integer adminloginid, String billtype, String billdate) throws Exception {
		Adminlogininfo adminlogininfo = adminlogininfoMapper.selectByPrimaryKey(adminloginid);
		if (adminlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		AlipayDataDataserviceBillDownloadurlQueryResponse response = MyAliPay.downloadBill(billtype, billdate);
		if (response==null) {
			return DataResult.error("获取失败");
		}
		if (response.isSuccess()) {
			return DataResult.success("获取成功", response.getBillDownloadUrl());
		}else {
			return  DataResult.error("获取失败，原因为："+response.getSubMsg());
		}
		
	}
	
	@Override
	public String getWXpayRecord(String out_trade_no ,String trade_no) {
		Map<String, String> response = MyWXPay.getOrderQuery(out_trade_no, trade_no);
		if (response==null) {
			return DataResult.error("查询失败");
		}
		if ("FAIL".equals(response.get("return_code"))) {
			return DataResult.error("查询失败，原因为："+response.get("return_msg"));
		}
		if ("FAIL".equals(response.get("result_code"))) {
			return DataResult.error("查询失败，原因为："+response.get("err_code_des"));
		}	
		return DataResult.success("查询成功", response);
	}
	
	@Override
	public String getWXpayRefundRecord(String out_trade_no,String trade_no,String out_refund_no,String refund_id) {
		Map<String, String> response = MyWXPay.getRefundQuery(out_trade_no, trade_no, out_refund_no, refund_id);
		if (response==null) {
			return DataResult.error("查询失败");
		}
		if ("FAIL".equals(response.get("return_code"))) {
			return DataResult.error("查询失败，原因为："+response.get("return_msg"));
		}
		if ("FAIL".equals(response.get("result_code"))) {
			return DataResult.error("查询失败，原因为："+response.get("err_code_des"));
		}	
		return DataResult.success("查询成功", response);
	}

}
