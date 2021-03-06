package com.medical.service.impl.user;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctoraddressMapper;
import com.medical.mapper.DoctorcalendarMapper;
import com.medical.mapper.DoctorcommentMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.FamilyinfoMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HospitalcommentMapper;
import com.medical.mapper.HosptitaldepositMapper;
import com.medical.mapper.PayMapperCustom;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.Doctoraddress;
import com.medical.po.Doctorcalendar;
import com.medical.po.Doctorcomment;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Hospinfo;
import com.medical.po.Hospitalcomment;
import com.medical.po.Hosptitaldeposit;
import com.medical.po.Pay;
import com.medical.po.Preorder;
import com.medical.po.Userlogininfo;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.service.iface.AbnormalOrderService;
import com.medical.service.iface.CommonTradeService;
import com.medical.service.iface.PayService;
import com.medical.service.iface.SenderNotificationService;
import com.medical.service.iface.doctor.DoctorPurseService;
import com.medical.service.iface.hospital.HospitalPurseService;
import com.medical.service.iface.user.UserOrderService;
import com.medical.utils.MakeRandomNum;
import com.medical.utils.StringReplaceUtil;
import com.medical.utils.TimeUtil;
import com.medical.utils.result.DataResult;
import com.pay.alipay.AliPayNotify;
import com.pay.alipay.AlipayConfig;
import com.pay.alipay.MyAliPay;
import com.pay.wxpay.ConfigUtil;
import com.pay.wxpay.MyWXPay;


import net.sf.json.JSONObject;

/**
 * @author 作者:xyh
 * @date 创建时间：2017年7月18日 上午09:05:48
 * @version 1.0
 */
public class UserOrderServiceImpl implements UserOrderService {

	@Autowired
	private FamilyinfoMapper familyinfoMapper;
	@Autowired
	private UsersickMapper usersickMapper;
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	@Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private UserorderMapper userorderMapper;
	@Autowired
	private UserorderMapperCustom userorderMapperCustom;
	@Autowired
	private DoctorcommentMapper doctorcommentMapper;
	@Autowired
	private HospitalcommentMapper hospitalcommentMapper;
	@Autowired
	private PayMapperCustom payMapperCustom;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private UserlogininfoMapper userloginiinfoMapper;
	@Autowired
	private DoctorlogininfoMapper doctorloginiinfoMapper;
	@Autowired
	private DoctorcalendarMapper doctorcalendarMapper;
	@Autowired
	private DoctoraddressMapper doctoraddressMapper;
	@Autowired
	private HosptitaldepositMapper hosptitaldepositMapper;
	@Autowired 
	private SenderNotificationService senderNotificationService;
	@Autowired
	private CommonTradeService commonTradeService;
	@Autowired
	private PayService payService ;
	@Autowired
	private DoctorPurseService  doctorPurseService;
	@Autowired
	private HospitalPurseService  hospitalPurseService;
	@Autowired 
	private AbnormalOrderService abnormalOrderService;
	
	//生成初始化订单
	public String createInitialOrder(Integer docloginid, Integer userloginid, Integer doccalendarid,Integer flag) throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user == null) {
			return DataResult.error("账户不存在");
		}
		Doctorlogininfo doctor = doctorloginiinfoMapper.selectByPrimaryKey(docloginid);
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctor == null || doctorinfo == null) {
			return DataResult.error("该医生不存在");
		}
		int type = doctor.getDoclogintype();
		if (type != 3) {
			return DataResult.error("该医生账户未审核");
		}
		// 查询处于发布状态的病情
		List<Usersick> lists = usersickMapperCustom.selectByUserLoginIdAndState(userloginid, 2);
		if (lists.size() != 1) {
			if (lists.size() > 1) {
				return DataResult.error("系统错误，发布的病情超过一个");
			} else {
				return DataResult.error("没有发布的病情");
			}
		}
		Doctorcalendar doctorcalendar = doctorcalendarMapper.selectByPrimaryKey(doccalendarid);
		if (doctorcalendar == null) {
			return DataResult.error("该日程不存在");
		}
		int calendardoctor = doctorcalendar.getDocloginid();
		if (docloginid!=calendardoctor) {
			return DataResult.error("该日程不属于该医生");
		}
		// 地址id
		int docaddressid = doctorcalendar.getDoccalendaradressid();
		// 病情信息
		Usersick sick = lists.get(0);
		int usersickid = sick.getUsersickid();
		// 订单信息
		Userorder userorder = new Userorder();
		// 1等待医生确定并完善消息
		userorder.setUserorderstateid(1);
		userorder.setUserorderdocloginid(docloginid);
		// 预约时间
	    String userorderappointment = TimeUtil.dateToStrLong(doctorcalendar.getDoccalendarday()) + " "
						+ doctorcalendar.getDoccalendartime() + " " + doctorcalendar.getDoccalendartimeinterval();
		userorder.setUserorderappointment(userorderappointment);
		// 下单时间
		userorder.setUserorderptime(new Date());
		userorder.setUsersickdesc(sick.getUsersickdesc());
		userorder.setUsersickpic(sick.getUsersickpic());
		userorder.setUsersickprimarydept(sick.getUsersickprimarydept());
		userorder.setUsersickseconddept(sick.getUsersickseconddept());
		// 亲属信息
		userorder.setFamilyname(sick.getFamilyname());
		userorder.setFamilymale(sick.getFamilymale());
		userorder.setFamilyage(sick.getFamilyage());
		// 就诊地址
		Doctoraddress docaddress = doctoraddressMapper.selectByPrimaryKey(docaddressid);
		userorder.setDocaddresslocation(docaddress.getDocaddresslocation());
		userorder.setDocaddressprovince(docaddress.getDocaddressprovince());
		userorder.setDocaddresscity(docaddress.getDocaddresscity());
		userorder.setDocaddressarea(docaddress.getDocaddressarea());
		userorder.setDocaddressother(docaddress.getDocaddressother());
		userorder.setDocaddresslat(docaddress.getDocaddresslat());
		userorder.setDocaddresslon(docaddress.getDocaddresslon());
		if (flag==1) {
			List<Preorder> preorders = preorderMapperCustom.selectByDocIdAndSickId(docloginid, usersickid);
			if (preorders == null || preorders.size() == 0) {
				return DataResult.error("该医生未加入候选");
			}
			// 3是为其他医生推荐的医生
			List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid, 3);
			if (list != null && list.size() == 1) {
				userorder.setUserorderrecdocloginid(list.get(0).getPreorderredocloginid());
			}
			// 删除已生成订单医生的预订单记录
			int delResult = preorderMapperCustom.deleteByDocLoginIdAndUserSickId(docloginid, usersickid);
			if (delResult<=0) {
				return DataResult.error("生成订单失败");
			}
		}else {
			List<Preorder> preorders = preorderMapperCustom.selectByDocIdAndSickId(docloginid, usersickid);
			if (preorders != null && preorders.size() > 0) {
				// 删除已生成订单医生的预订单记录
				int delResult = preorderMapperCustom.deleteByDocLoginIdAndUserSickId(docloginid, usersickid);
				if (delResult<=0) {
					return DataResult.error("生成订单失败");
				}
			}
		}
		userorder.setUsersickid(usersickid);
		userorder.setUserloginid(userloginid);
		// 插入订单
		int result = userorderMapperCustom.insertSelectiveReturnId(userorder);
		Usersick usersick = new Usersick();
		usersick.setUsersickid(usersickid);
		usersick.setUserorderid(userorder.getUserorderid());
		// 3已生成订单
		usersick.setUsersickstateid(3);
		
		// 更新病情信息
		int upResult = usersickMapper.updateByPrimaryKeySelective(usersick);
		if (result > 0 && upResult > 0 ) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("sick_id", usersickid);
			jsonCustormCont.put("user_id", userloginid);
			jsonCustormCont.put("order_id", userorder.getUserorderid());
			jsonCustormCont.put("type", "2");
			senderNotificationService.createMsgUserToDoctor(userloginid, sick.getFamilyname(), docloginid, "等待确认",
					"选择了您", jsonCustormCont);
			return DataResult.success("生成订单成功",userorder.getUserorderid());
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("生成订单失败");
		}

	}
	
	//生成订单
	@Override
	public String createOrder(Integer docloginid, Integer userloginid, Integer doccalendarid) throws Exception {
		String result = createInitialOrder(docloginid, userloginid, doccalendarid,1);
		JSONObject jsonObject = JSONObject.fromObject(result);
		if ("100".equals(jsonObject.get("code").toString())) {
			return DataResult.success("生成订单成功");
		}else {
			return result;
		}
	}
	
	//生成待付款的订单
	@Override
	public String createQuickOrder(Integer docloginid, Integer userloginid, Integer doccalendarid, Integer paytype,String ip)
			throws Exception {

		Doctorlogininfo doctor = doctorloginiinfoMapper.selectByPrimaryKey(docloginid);
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctor == null || doctorinfo == null) {
			return DataResult.error("该医生不存在");
		}
		Doctorcalendar doctorcalendar = doctorcalendarMapper.selectByPrimaryKey(doccalendarid);
		if (doctorcalendar == null) {
			return DataResult.error("该日程不存在");
		}
		BigDecimal totalfee = BigDecimal.ZERO;
		BigDecimal calendarfee = doctorcalendar.getDoccalendarprice();
		if (calendarfee.compareTo(BigDecimal.ZERO) != 0) {
			totalfee = calendarfee;
		} else {
			BigDecimal fee = doctorinfo.getDocprice();
			if (fee.compareTo(BigDecimal.ZERO) != 0) {
				totalfee = fee;
			}
		}
		if (totalfee.compareTo(BigDecimal.ZERO) == 0) {
			return DataResult.error("该医生未设置出诊价格");
		}
		String result = createInitialOrder(docloginid, userloginid, doccalendarid,2);
		JSONObject jsonObject = JSONObject.fromObject(result);
		if ("100".equals(jsonObject.get("code").toString())) {
			int userorderid = (int) jsonObject.get("data");
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			// 2待确认
			userorder.setUserorderstateid(2);
			// 医生出诊价格
			userorder.setUserorderdprice(totalfee);
			// 医生订单总价
			userorder.setUserorderprice(totalfee);
			userorder.setUserorderrtime(new Date());
			int orderresult =userorderMapper.updateByPrimaryKeySelective(userorder);
			if (orderresult<=0) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("生成订单失败");
			}
			String payResult = updateOrderStateToConfirm(userloginid, userorder.getUserorderid(), paytype, ip);
			JSONObject jsonObject2 = JSONObject.fromObject(payResult);
			if ("200".equals(jsonObject2.get("code").toString())) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();	
			}
			return payResult;
		}else {
			return result;
		}

	}
	
	//取消订单
	@Override
	public String updateOrderStateToCancel(Integer userorderid, Integer userloginid) throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		//判断订单是否处于支付中
		boolean isExit = commonTradeService.queryUserOrderIsExit(userorderid);
		if (isExit) {
			return DataResult.error("支付中,不可取消");
		}
		Integer loginid = order.getUserloginid();
		if (userloginid != loginid) {
			return DataResult.error("账号信息不匹配");
		}
		int state = order.getUserorderstateid();
		// 待付款前可取消
		if (state <= 3) {
			//订单信息
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			//与医生订单结束时间
			userorder.setUserorderetime(new Date());
			//整个订单结束时间
			userorder.setUserorderfinishtime(new Date());
			// 16为病人取消订单
			userorder.setUserorderstateid(16);
			//病情信息
			Usersick usersick = new Usersick();
			usersick.setUsersickid(order.getUsersickid());
			// 无订单
			usersick.setUserorderid(0);
			// 已发布
			usersick.setUsersickstateid(2);
			// 更新订单
			int result = userorderMapper.updateByPrimaryKeySelective(userorder);
			// 更新病情信息
			int upResult = usersickMapper.updateByPrimaryKeySelective(usersick);
			if (result > 0 && upResult > 0) {
				JSONObject jsonCustormCont = new JSONObject();
				jsonCustormCont.put("sick_id", order.getUsersickid());
				jsonCustormCont.put("user_id", userloginid);
				jsonCustormCont.put("order_id", userorder.getUserorderid());
				jsonCustormCont.put("type", "2");
				senderNotificationService.createMsgUserToDoctor(userloginid,order.getFamilyname(), order.getUserorderdocloginid(), "通知消息",
						"取消了订单", jsonCustormCont);
				return DataResult.success("取消订单成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("取消订单失败");
			}
		} else {
			return DataResult.error("该状态订单不支持取消");
		}

	}

	//获取订单
	@Override
	public String listOrder(Integer userloginid, Integer page, Integer type) throws Exception{
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = userorderMapperCustom.selectAllInfoByUserLoginId(userloginid, type);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());
	}

	//获取订单详情
	@Override
	public String getOrderDetail(Integer userloginid, Integer userorderid) throws Exception{
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Map<String, Object> resultMap = userorderMapperCustom.selectAllInfoByUserLoginIdAndUserOrderId(userloginid,
				userorderid);
		if (resultMap != null && !resultMap.isEmpty()) {
			return DataResult.success("获取成功", resultMap);
		} else {
			return DataResult.error("订单不存在");
		}
	}

	// 确认订单
	@Override
	public String updateOrderStateToConfirm(Integer userloginid, Integer userorderid, Integer type, String ip)
			throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user == null) {
			return DataResult.error("账户不存在");
		}
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		Integer loginid = order.getUserloginid();
		if (userloginid != loginid) {
			return DataResult.error("账号信息不匹配");
		}
		// 订单锁
		boolean tradestate = commonTradeService.queryUserOrderForCreat(userorderid);
		if (tradestate) {
			return DataResult.error("付款中,请稍后重试");
		}
		// 2订单处于等待病人确定状态
		int state = order.getUserorderstateid();
		if (state != 2) {
			return DataResult.error("该状态不支持确认");
		}
		BigDecimal totalAmount = order.getUserorderprice();
		if (totalAmount.compareTo(BigDecimal.ZERO) == 0) {
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			// 支付完成等待就诊
			userorder.setUserorderstateid(4);
			boolean result = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
			if (result) {
				JSONObject jsonCustormCont = new JSONObject();
				jsonCustormCont.put("user_id", order.getUserloginid());
				jsonCustormCont.put("order_id", order.getUserorderid());
				jsonCustormCont.put("type", "4");
				senderNotificationService.createMsgUserToDoctor(order.getUserloginid(), order.getFamilyname(),
						order.getUserorderdocloginid(), "通知消息", "支付成功", jsonCustormCont);
				// 解除订单锁
				commonTradeService.queryUserOrderForFinish(userorderid);
				return DataResult.success("支付成功");
			} else {
				return DataResult.error("支付失败");
			}

		}
		if (type == 1) {
			//支付宝支付
			return updateOrderStatePayDoctorByAliPay(order);
		} else {
			//微信支付
			return updateOrderStatePayDoctorByWXPay(order, ip);
		}

	}

	// 微信支付医生费用
	@Transactional(rollbackFor = Exception.class)
	private String updateOrderStatePayDoctorByWXPay(Userorder userorder, String ip) throws Exception {
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(userorder.getUserorderdocloginid());
		if (doctorinfo == null) {
			return DataResult.error("医生不存在");
		}
		String boby = "速递医运-用户缴纳医生费用";
		String subject = "缴纳" + doctorinfo.getDocname() + "医生费用";
		BigDecimal totalAmount = userorder.getUserorderprice();
		String prefix = "wud";
		String outTradeNo = MakeRandomNum.getTradeNo(prefix);
		// 回调地址
		String notifyUrl = ConfigUtil.DOCTOR_NOTIFY_URL;
		//插入支付记录
		int payid= payService.updatePayRecordToCreat(userorder.getUserloginid(), userorder.getFamilyname(),
				userorder.getUserorderprice(), userorder.getUserorderdocloginid(), doctorinfo.getDocname(),
				userorder.getUserorderid(), 1, 1, outTradeNo, 2);
		if (payid==0) {
			return DataResult.error("异常错误");
		}
		String result= MyWXPay.wxPrePay(boby, subject, totalAmount, notifyUrl, outTradeNo, ip,"APP");
		JSONObject jsonObject2 = JSONObject.fromObject(result);
		if ("200".equals(jsonObject2.get("code").toString())) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	// 支付宝支付医生费用
		@Transactional(rollbackFor = Exception.class)
		private String updateOrderStatePayDoctorByAliPay(Userorder userorder) throws Exception {
			Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(userorder.getUserorderdocloginid());
			if (doctorinfo==null) {
				return DataResult.error("医生不存在");
			}
			String boby = "速递医运-用户缴纳医生费用";
			String subject = "缴纳" + doctorinfo.getDocname() + "医生费用";
			String totalAmount = userorder.getUserorderprice() + "";
			String prefix = "aud";
			String outTradeNo = MakeRandomNum.getTradeNo(prefix);
			// 回调地址
			String notifyUrl = AlipayConfig.DOCTOR_NOTIFY_URL;
			int payid  = payService.updatePayRecordToCreat(userorder.getUserloginid(), userorder.getFamilyname(), userorder.getUserorderprice(), userorder.getUserorderdocloginid(), doctorinfo.getDocname(), userorder.getUserorderid(), 1, 1, outTradeNo,1);
			if (payid==0) {
				return DataResult.error("异常错误");
			}
			String result = MyAliPay.appGetSign(boby, subject, totalAmount, outTradeNo, notifyUrl);
			return DataResult.success("获取成功", result); 
			
		}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateOrderStatePayDoctorFinishByWXPay(HttpServletRequest request) throws Exception {
		Map<String, String> params = MyWXPay.wxNotify(request);
		if (params==null) {
			return DataResult.error("异常错误");
		}
		// 通信失败
		if ("FAIL".equals(params.get("return_code"))) {
			return DataResult.error("通信失败");
		}
		// 商户订单号
		String out_trade_no = params.get("out_trade_no");
		
		// 微信单号
		String trade_no =  params.get("transaction_id");
		String buyer_logon_id =  params.get("openid");
		String seller_email =  params.get("mch_id");
		String err_code_des=  params.get("err_code_des");
		// 获取交易记录
		Pay pay = payMapperCustom.selectByPayTradeNo(out_trade_no);
		if (pay == null) {
			return DataResult.error("交易不存在");
		}
		// 交易支付失败
		if ("FAIL".equals(params.get("result_code"))) {
			boolean payresult = payService.updatePayRecordToCancle( pay.getPayid(), trade_no,
					buyer_logon_id, seller_email, params.toString(), err_code_des);
			if (payresult) {
				return DataResult.success("支付结束");
			} else {
				return DataResult.error("异常错误");
			}

		}
		return updateAfterPaySuccessForDoctor(pay, params, "Wxpay");
//		
//		// 付款金额
//		String receipt = (String) params.get("total_fee");
//		String receiptamount = new BigDecimal(receipt).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).toString();
//		int userorderid = pay.getPayorderid();
//		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
//		if (order == null) {
//			return DataResult.error("订单不存在");
//		}
//		int state = order.getUserorderstateid();
//		// 订单处于等待病人付款状态
//		if (state == 2) {
//			Userorder userorder = new Userorder();
//			userorder.setUserorderid(userorderid);
//			// 支付完成等待就诊
//			userorder.setUserorderstateid(4);
//			boolean orderresult = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
//			// 交易记录
//			boolean payResult = payService.updatePayRecordToFinish(pay.getPayid(), trade_no,
//					buyer_logon_id, seller_email, params.toString(), new BigDecimal(receiptamount));
//			String name = pay.getPaysendername();
//			// 金额记录
//			String purseResult = doctorPurseService.updateBalance(order.getUserorderdocloginid(), 1,
//					new BigDecimal(receiptamount), "收到病人" + name + "付款", pay.getPayid());
//			JSONObject purseObject = JSONObject.fromObject(purseResult);
//			// 解除订单锁
//			commonTradeService.queryUserOrderForFinish(pay.getPayorderid());
//			if (payResult && "100".equals(purseObject.get("code").toString())
//					&& orderresult) {
//				JSONObject jsonCustormCont = new JSONObject();
//				jsonCustormCont.put("user_id", order.getUserloginid());
//				jsonCustormCont.put("order_id", order.getUserorderid());
//				jsonCustormCont.put("type", "4");
//				senderNotificationService.createMsgUserToDoctor(order.getUserloginid(), order.getFamilyname(),
//						order.getUserorderdocloginid(), "通知消息", "支付成功", jsonCustormCont);
//				return DataResult.success("支付成功");
//			} else {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return DataResult.error("支付失败");
//			}
//		} else  if (state == 16 || state == 15) {
//			//需修改
//			//医生或者病人取消订单
//			// 交易成功，但订单取消，需要退款
//			boolean payResult = payService.updatePayRecordToFinish(pay.getPayid(), trade_no,
//								buyer_logon_id, seller_email, params.toString(), new BigDecimal(receiptamount));
//			String reason =  null;
//			if (state == 15) {
//				reason = "用户取消订单,支付成功";
//			}else {
//				reason = "医生取消订单,支付成功";
//			}
//			boolean result = abnormalOrderService.addAbnormalOrder(userorderid, 1, pay.getPayid(), reason);
//			if (result && payResult) {
//				return DataResult.success("支付完成");
//			}else {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return DataResult.error("异常错误");
//			}
//			
//		}else{
//			
//			return DataResult.success("已支付");
//		}
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateOrderStatePayDoctorFinishByAliPay(Map<String, String[]> requestParams) throws Exception {
		Map<String, String> params = AliPayNotify.aliPayNotify(requestParams);
		// 商户订单号
		String out_trade_no = params.get("out_trade_no");
		
		// 付款金额
		String total_amount = params.get("total_amount");
		//实收金额
		String receip_tamount = params.get("receipt_amount");
		// 支付宝交易号
		String trade_no = params.get("trade_no");
		String buyer_logon_id = params.get("buyer_logon_id");
		String seller_email = params.get("seller_email");
		// 获取交易记录
		Pay pay = payMapperCustom.selectByPayTradeNo(out_trade_no);
		if (pay == null) {
			return DataResult.error("交易不存在");
		}
		if ("TRADE_FINISHED".equals(params.get("trade_status")) || "TRADE_SUCCESS".equals(params.get("trade_status"))) {  
            // 支付成功后执行相关业务  
            return updateAfterPaySuccessForDoctor(pay, params, "Alipay");  
        
		}  else if ("TRADE_CLOSED".equals(params.get("trade_status"))){
        	boolean payresult = payService.updatePayRecordToCancle( pay.getPayid(), trade_no,
					buyer_logon_id, seller_email, params.toString(), "交易失败");
			if (payresult) {
				return DataResult.success("支付结束");
			} else {
				return DataResult.error("异常错误");
			}
		}else {
			return DataResult.error("异常错误");
		}
		
//		int userorderid = pay.getPayorderid();
//		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
//		if (order == null) {
//			return DataResult.error("订单不存在");
//		}
//		int state = order.getUserorderstateid();
//		// 订单处于等待病人付款状态
//		if (state == 2) {
//			Userorder userorder = new Userorder();
//			userorder.setUserorderid(userorderid);
//			// 支付完成等待就诊
//			userorder.setUserorderstateid(4);
//			boolean orderresult = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
//			// int stateid = 3;
//			// if ("TRADE_SUCCESS".equals(params.get("trade_status"))) {
//			// // 3为交易成功
//			// stateid = 3;
//			// } else {
//			// // 4为交易结束，不可退款
//			// stateid = 4;
//			// }
//			// 交易记录
//			boolean payResult = payService.updatePayRecordToFinish( pay.getPayid(), trade_no,
//					buyer_logon_id, seller_email, params.toString(), new BigDecimal(receip_tamount));
//			String name = pay.getPaysendername();
//			// 金额记录
//			String purseResult = doctorPurseService.updateBalance(order.getUserorderdocloginid(), 1,
//					new BigDecimal(total_amount), "收到病人" + name + "付款", pay.getPayid());
//			JSONObject purseObject = JSONObject.fromObject(purseResult);
//			// 解除订单锁
//			commonTradeService.queryUserOrderForFinish(pay.getPayorderid());
//			if (payResult && "100".equals(purseObject.get("code").toString())
//					&& orderresult) {
//				JSONObject jsonCustormCont = new JSONObject();
//				jsonCustormCont.put("user_id", order.getUserloginid());
//				jsonCustormCont.put("order_id", order.getUserorderid());
//				jsonCustormCont.put("type", "4");
//				senderNotificationService.createMsgUserToDoctor(order.getUserloginid(), order.getFamilyname(),
//						order.getUserorderdocloginid(), "通知消息", "支付成功", jsonCustormCont);
//				return DataResult.success("支付成功");
//			} else {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return DataResult.error("支付失败");
//			}
//		} else if (state == 16 || state == 15) {
//			//需修改
//			// 医生或者病人取消订单
//			// 交易成功，但订单取消，需要退款
//			boolean payResult = payService.updatePayRecordToFinish( pay.getPayid(), trade_no,
//					buyer_logon_id, seller_email, params.toString(), new BigDecimal(receip_tamount));
//			String reason =  null;
//			if (state == 15) {
//				reason = "用户取消订单,支付成功";
//			}else {
//				reason = "医生取消订单,支付成功";
//			}
//			boolean result = abnormalOrderService.addAbnormalOrder(userorderid, 1, pay.getPayid(), reason);
//			if (result && payResult) {
//				return DataResult.success("支付完成");
//			}else {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return DataResult.error("异常错误");
//			}
//		} else {
//
//			return DataResult.success("已支付");
//		}
	}
	public String updateAfterPaySuccessForDoctor(Pay pay,Map<String, String> params,String payMethod) throws Exception{  
		
		String trade_no = null;
		// 付款金额
		String total_amount = null;
		//实收金额
		String receip_tamount = null;
		
		String buyer_logon_id = null;
		
		String seller_email = null;
		if ("Alipay".equals(payMethod)) {
			// 付款金额
			total_amount = params.get("total_amount");
			//实收金额
			 receip_tamount = params.get("receipt_amount");
			// 支付宝交易号
			 trade_no = params.get("trade_no");
			 
			 buyer_logon_id = params.get("buyer_logon_id");
			 
			 seller_email = params.get("seller_email");
		}else {
			// 微信单号
			 trade_no = (String) params.get("transaction_id");
			 buyer_logon_id = (String) params.get("openid");
			 seller_email = (String) params.get("mch_id");
			 // 付款金额
			 String receipt = (String) params.get("total_fee");
			 receip_tamount = new BigDecimal(receipt).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).toString();
			 total_amount = receip_tamount;
		}
		int userorderid = pay.getPayorderid();
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		int state = order.getUserorderstateid();
		// 订单处于等待病人付款状态
		if (state == 2) {
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			// 支付完成等待就诊
			userorder.setUserorderstateid(4);
			boolean orderresult = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
			// 交易记录
			boolean payResult = payService.updatePayRecordToFinish( pay.getPayid(), trade_no,
					buyer_logon_id, seller_email, params.toString(), new BigDecimal(receip_tamount));
			String name = pay.getPaysendername();
			// 医生金额记录
//			String purseResult = doctorPurseService.updateBalance(order.getUserorderdocloginid(), 1,
//					new BigDecimal(total_amount), "收到病人" + name + "付款", pay.getPayid());
//			JSONObject purseObject = JSONObject.fromObject(purseResult);
			// 解除订单锁
			commonTradeService.queryUserOrderForFinish(pay.getPayorderid());
			if (payResult && orderresult) {
				JSONObject jsonCustormCont = new JSONObject();
				jsonCustormCont.put("user_id", order.getUserloginid());
				jsonCustormCont.put("order_id", order.getUserorderid());
				jsonCustormCont.put("type", "4");
				senderNotificationService.createMsgUserToDoctor(order.getUserloginid(), order.getFamilyname(),
						order.getUserorderdocloginid(), "通知消息", "支付成功", jsonCustormCont);
				return DataResult.success("支付成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("支付失败");
			}
		} else if (state == 16 || state == 15) {
			//需修改
			// 医生或者病人取消订单
			// 交易成功，但订单取消，需要退款
			boolean payResult = payService.updatePayRecordToFinish( pay.getPayid(), trade_no,
					buyer_logon_id, seller_email, params.toString(), new BigDecimal(receip_tamount));
			String reason =  null;
			if (state == 15) {
				reason = "用户取消订单,支付成功";
			}else {
				reason = "医生取消订单,支付成功";
			}
			boolean result = abnormalOrderService.addAbnormalOrder(userorderid, 1, pay.getPayid(), reason);
			if (result && payResult) {
				return DataResult.success("支付完成");
			}else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("异常错误");
			}
		} else {

			return DataResult.success("已支付");
		}
        
    }  
	
	@Override
	public String updateOrderStatePayHospital(Integer userloginid, Integer userorderid, Integer type,String ip) throws Exception {
		//订单锁
		boolean tradestate = commonTradeService.queryUserOrderForCreat(userorderid);
		if (tradestate) {
			return DataResult.error("付款中,请稍后重试");
		}
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		Integer loginid = order.getUserloginid();
		if (userloginid != loginid) {
			return DataResult.error("账户信息不匹配");
		}
		// 订单处于等待病人确定状态
		int state = order.getUserorderstateid(); 
		if (state != 6) {
			return DataResult.error("该状态不支持确认");
		}
			//押金
			BigDecimal totalAmount = order.getUserorderdeposit();
			if (totalAmount.compareTo(BigDecimal.ZERO) == 0) {
				Userorder userorder = new Userorder();
				userorder.setUserorderid(userorderid);
				// 已缴纳医院押金
				userorder.setUserorderstateid(7);
				userorder.setUserorderactualhospitalizationid(4);
				boolean result = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
				
				//解除订单锁
				commonTradeService.queryUserOrderForFinish(userorderid);
				if (result) {
					JSONObject jsonCustormCont = new JSONObject();
					jsonCustormCont.put("order_id", order.getUserorderid());
					jsonCustormCont.put("type", "5");
					senderNotificationService.createMsgUserToHospital(userloginid,order.getFamilyname(),  order.getUserorderhospid(), "消息通知", "已缴纳押金", jsonCustormCont);
					return DataResult.success("支付成功");
				} else {
					return DataResult.error("支付失败");
				}

			}
			if (type == 1) {
				return updateOrderStatePayHospitalByAlipay(order);
			} else {
				return updateOrderStatePayHospitalByWXPay(order,ip);
			}

		

	}
	// 支付医院费用
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateOrderStatePayHospitalByWXPay(Userorder userorder, String ip) throws Exception {
		Integer hosploginid = userorder.getUserorderhospid();
		Integer userorderid = userorder.getUserorderid();
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		String boby = "速递医运病人费用缴纳";
		String subject = "缴纳" + hospinfo.getHospname() + "押金";
		// 医院押金
		BigDecimal totalAmount = userorder.getUserorderdeposit();
		String prefix = "u" + userorderid + "h";
		String outTradeNo = MakeRandomNum.getTradeNo(prefix);
		// 回调地址
		String notifyUrl = ConfigUtil.HSOP_NOTIFY_URL;
		// 插入支付记录
		int payid = payService.updatePayRecordToCreat(userorder.getUserloginid(), userorder.getFamilyname(),
				totalAmount, hosploginid, hospinfo.getHospname(), userorder.getUserorderid(), 1, 2, outTradeNo, 2);
		if (payid==0) {
			return DataResult.error("异常错误");
		}
		String result= MyWXPay.wxPrePay(boby, subject, totalAmount, notifyUrl, outTradeNo, ip,"APP");
		JSONObject jsonObject2 = JSONObject.fromObject(result);
		if ("200".equals(jsonObject2.get("code").toString())) {
			//出错回滚
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}

	// 支付医院回调
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateOrderStatePayHospitalFinishByWXPay(HttpServletRequest request) throws Exception {
		Map<String, String> params = MyWXPay.wxNotify(request);
		// 通信失败
		if ("FAIL".equals((String) params.get("return_code"))) {
			return DataResult.error("通信失败");
		}
		// 商户订单号
		String out_trade_no = (String) params.get("out_trade_no");
		// 付款金额
		//String receiptamount = (String) params.get("total_fee");
		// 微信单号
		String trade_no = (String) params.get("transaction_id");
		String buyer_logon_id = (String) params.get("openid");
		String seller_email = (String) params.get("mch_id");
		String err_code_des = (String) params.get("err_code_des");
		// 获取交易记录
		Pay pay = payMapperCustom.selectByPayTradeNo(out_trade_no);
		if (pay == null) {
			return DataResult.error("交易不存在");
		}
		// 交易支付失败
		if ("FAIL".equals((String) params.get("result_code"))) {
			// 解除订单锁
			commonTradeService.queryUserOrderForFinish(pay.getPayorderid());
			boolean payresult = payService.updatePayRecordToCancle( pay.getPayid(), trade_no,
					buyer_logon_id, seller_email, params.toString(), err_code_des);
			if (payresult) {
				return DataResult.success("支付结束");
			} else {
				return DataResult.error("异常错误");
			}

		}
		return updateAfterPaySuccessForHosp(pay, params, "WXpay");
//		// 付款金额
//		String receipt = (String) params.get("total_fee");
//		String receiptamount = new BigDecimal(receipt).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).toString();
//		int userorderid = pay.getPayorderid();
//		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
//		if (order == null) {
//			return DataResult.error("订单不存在");
//		}
//		int state = order.getUserorderstateid();
//		int actualhospitalizationid =order.getUserorderactualhospitalizationid();
//		BigDecimal deposit = order.getUserorderdeposit();
//		// 已缴纳的总押金
//		BigDecimal totaldeposit = order.getUserordertotaldeposit().add(deposit);
//		// 订单处于等待病人付医院押金
//		if (state == 6) {
//			Userorder userorder = new Userorder();
//			userorder.setUserorderid(userorderid);
//			// 7为已缴纳押金
//			userorder.setUserorderstateid(7);
//			// 4为已住院(实际住院状态)
//			userorder.setUserorderactualhospitalizationid(4);
//			// 已缴纳的押金
//			userorder.setUserordertotaldeposit(totaldeposit);
//			boolean orderresult = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
//			String sickname = pay.getPaysendername();
//			// 交易记录
//			boolean payresult = payService.updatePayRecordToFinish( pay.getPayid(), trade_no, buyer_logon_id,
//					seller_email, params.toString(), new BigDecimal(receiptamount));
//			// 钱包变动
//			String purseresult = hospitalPurseService.updateBalance(pay.getPayreceiverid(), 1,
//					new BigDecimal(receiptamount), "收到病人" + sickname + "押金", pay.getPayid());
//			JSONObject purseObject = JSONObject.fromObject(purseresult);
//			// 押金记录表
//			Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(order.getUserorderhospid());
//			Hosptitaldeposit hosptitaldeposit = new Hosptitaldeposit();
//			hosptitaldeposit.setHospdepositnum(new BigDecimal(receiptamount));
//			hosptitaldeposit.setHospdepositremark(sickname + "缴纳" + hospinfo.getHospname() + "押金");
//			hosptitaldeposit.setHospdeposittime(new Date());
//			hosptitaldeposit.setHosploginid(order.getUserorderhospid());
//			hosptitaldeposit.setUserloginid(order.getUserloginid());
//			boolean depositresult = hosptitaldepositMapper.insertSelective(hosptitaldeposit) > 0;
//			// 解除订单锁
//			commonTradeService.queryUserOrderForFinish(pay.getPayorderid());
//			if (payresult && "100".equals(purseObject.get("code").toString())
//					&& orderresult && depositresult) {
//				JSONObject jsonCustormCont = new JSONObject();
//				jsonCustormCont.put("order_id", order.getUserorderid());
//				jsonCustormCont.put("type", "5");
//				senderNotificationService.createMsgUserToDoctor(order.getUserloginid(), order.getFamilyname(),
//						order.getUserorderdocloginid(), "通知消息", "支付成功", jsonCustormCont);
//				return DataResult.success("支付成功");
//			} else {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return DataResult.error("支付失败");
//			}
//
//		}else if (state == 9 && (actualhospitalizationid ==2 || actualhospitalizationid ==3)) {
//			// 支付成功，订单取消，需要退款
//			boolean payresult = payService.updatePayRecordToFinish( pay.getPayid(), trade_no, buyer_logon_id,
//								seller_email, params.toString(), new BigDecimal(receiptamount));
//			String reason =  null;
//			if (actualhospitalizationid ==2) {
//				reason = "用户取消订单,支付成功";
//			}else {
//				reason = "医院取消订单,支付成功";
//			}
//			boolean result = abnormalOrderService.addAbnormalOrder(userorderid, 1, pay.getPayid(), reason);
//			if (result && payresult) {
//				return DataResult.success("支付完成");
//			}else {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return DataResult.error("异常错误");
//			}
//		}else {
//			return DataResult.success("已支付");
//		}
		
	}
	// 支付医院费用
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateOrderStatePayHospitalByAlipay(Userorder userorder) throws Exception {
		Integer hosploginid = userorder.getUserorderhospid();
		Integer userorderid = userorder.getUserorderid();
		userorder.getUserloginid();
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		String boby = "速递医运病人费用缴纳";
		String subject = "缴纳" + hospinfo.getHospname() + "押金";
		// 医院押金
		String totalAmount = userorder.getUserorderdeposit() + "";
		String prefix = "u" + userorderid + "h";
		String outTradeNo = MakeRandomNum.getTradeNo(prefix);
		// 回调地址
		String notifyUrl = AlipayConfig.HSOP_NOTIFY_URL;
		int payid  = payService.updatePayRecordToCreat(userorder.getUserloginid(), userorder.getFamilyname(),new BigDecimal(totalAmount),
				hosploginid, hospinfo.getHospname(), userorder.getUserorderid(), 1, 2, outTradeNo,1);
		if (payid==0) {
			return DataResult.error("异常错误");
		}
		String result = MyAliPay.appGetSign(boby, subject, totalAmount, outTradeNo, notifyUrl);
		return DataResult.success("获取成功", result); 
		
   }

	// 支付医院回调
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateOrderStatePayHospitalFinishByAlipay(Map<String, String[]> requestParams) throws Exception {
		Map<String, String> params = AliPayNotify.aliPayNotify(requestParams);
		// 商户订单号
		String out_trade_no = params.get("out_trade_no");
		// 付款金额
		String total_amount = params.get("total_amount");
		//实收金额
		String receip_tamount = params.get("receipt_amount");
		// 支付宝交易号
		String trade_no = params.get("trade_no");
		String buyer_logon_id = params.get("buyer_logon_id");
		String seller_email = params.get("seller_email"); 
		// 附加数据
		// String passback_params = URLDecoder.decode(params.get("passback_params"));
		// 获取交易记录
		Pay pay = payMapperCustom.selectByPayTradeNo(out_trade_no);
		if (pay == null) {
			return DataResult.error("交易不存在");
		}
		// 交易支付失败
		if ("TRADE_CLOSED".equals(params.get("trade_status"))) {
			//解除订单锁
			commonTradeService.queryUserOrderForFinish(pay.getPayorderid());
			boolean payresult  = payService.updatePayRecordToCancle( pay.getPayid(), trade_no, buyer_logon_id,
					seller_email, params.toString(),"交易失败");
			if (payresult) {
				return DataResult.success("支付结束"); 
			}else {
				return DataResult.error("异常错误");
			}
	
		}
		return updateAfterPaySuccessForHosp(pay, params, "Alipay");
//		int userorderid = pay.getPayorderid();
//		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
//		if (order == null) {
//			return DataResult.error("订单不存在");
//		}
//		int state = order.getUserorderstateid();
//		int actualhospitalizationid =order.getUserorderactualhospitalizationid();
//		BigDecimal deposit = order.getUserorderdeposit();
//		// 已缴纳的总押金
//		BigDecimal totaldeposit = order.getUserordertotaldeposit().add(deposit);
//		// 订单处于等待病人付医院押金
//		if (state == 6) {
//			Userorder userorder = new Userorder();
//			userorder.setUserorderid(userorderid);
//			// 7为已缴纳押金
//			userorder.setUserorderstateid(7);
//			//4为已住院(实际住院状态)
//			userorder.setUserorderactualhospitalizationid(4);
//			// 已缴纳的押金
//			userorder.setUserordertotaldeposit(totaldeposit);
//			boolean orderresult = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
//			String sickname = pay.getPaysendername();
////			int stateid = 3;
////			if ("TRADE_SUCCESS".equals(params.get("trade_status"))) {
////			// 3为交易成功
////			  stateid = 3;
////		    } else {
////				// 4为交易结束，不可退款
////		    	stateid = 4;
////			}
//			boolean payresult  = payService.updatePayRecordToFinish( pay.getPayid(), trade_no, buyer_logon_id,
//					seller_email, params.toString(), new BigDecimal(receip_tamount));
//			String purseresult = hospitalPurseService.updateBalance(pay.getPayreceiverid(), 1, new BigDecimal(total_amount), "收到病人"+sickname+"押金", pay.getPayid());
//			JSONObject purseObject = JSONObject.fromObject(purseresult);
//	       //押金记录表
//			Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(order.getUserorderhospid());
//			Hosptitaldeposit hosptitaldeposit = new Hosptitaldeposit();
//			hosptitaldeposit.setHospdepositnum(new BigDecimal(total_amount));
//			hosptitaldeposit.setHospdepositremark(sickname+"缴纳"+hospinfo.getHospname()+"押金");
//			hosptitaldeposit.setHospdeposittime(new Date());
//			hosptitaldeposit.setHosploginid(order.getUserorderhospid());
//			hosptitaldeposit.setUserloginid(order.getUserloginid());
//			boolean depositresult = hosptitaldepositMapper.insertSelective(hosptitaldeposit)>0;
//			//解除订单锁
//			commonTradeService.queryUserOrderForFinish(pay.getPayorderid());
//			if (payresult && "100".equals(purseObject.get("code").toString()) && orderresult && depositresult) {
//				JSONObject jsonCustormCont = new JSONObject();
//				jsonCustormCont.put("order_id", order.getUserorderid());
//				jsonCustormCont.put("type", "5");
//				senderNotificationService.createMsgUserToDoctor(order.getUserloginid(),order.getFamilyname(), 
//						order.getUserorderdocloginid(), "通知消息", "支付成功", jsonCustormCont);
//				return DataResult.success("支付成功");
//			} else {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return DataResult.error("支付失败");
//			}
//		}else if (state == 9 && (actualhospitalizationid ==2 || actualhospitalizationid ==3)) {
//			//需修改
//			// 支付成功，订单取消，需要退款
//			boolean payresult = payService.updatePayRecordToFinish( pay.getPayid(), trade_no, buyer_logon_id,
//								seller_email, params.toString(), new BigDecimal(receip_tamount));
//			String reason =  null;
//			if (actualhospitalizationid ==2) {
//				reason = "用户取消订单,支付成功";
//			}else {
//				reason = "医院取消订单,支付成功";
//			}
//			boolean result = abnormalOrderService.addAbnormalOrder(userorderid, 1, pay.getPayid(), reason);
//			if (result && payresult) {
//				return DataResult.success("支付完成");
//			}else {
//				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//				return DataResult.error("异常错误");
//			}
//		}else {
//			return DataResult.success("已支付");
//		}

	}
	/**
	 * @Title: updateAfterPaySuccessForHosp
	 * @Description: TODO
	 * @return: void
	 * @throws Exception 
	 */
	private String updateAfterPaySuccessForHosp(Pay pay,Map<String, String> params,String payMethod) throws Exception {
		
		String trade_no = null;
		// 付款金额
		String total_amount = null;
		//实收金额
		String receip_tamount = null;
		
		String buyer_logon_id = null;
		
		String seller_email = null;
		if ("Alipay".equals(payMethod)) {
			// 付款金额
			total_amount = params.get("total_amount");
			//实收金额
			 receip_tamount = params.get("receipt_amount");
			// 支付宝交易号
			 trade_no = params.get("trade_no");
			 
			 buyer_logon_id = params.get("buyer_logon_id");
			 
			 seller_email = params.get("seller_email");
		}else {
			// 微信单号
			 trade_no = (String) params.get("transaction_id");
			 buyer_logon_id = (String) params.get("openid");
			 seller_email = (String) params.get("mch_id");
			 // 付款金额
			 String receipt = (String) params.get("total_fee");
			 receip_tamount = new BigDecimal(receipt).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).toString();
			 total_amount = receip_tamount;
		}
		int userorderid = pay.getPayorderid();
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		int state = order.getUserorderstateid();
		int actualhospitalizationid =order.getUserorderactualhospitalizationid();
		BigDecimal deposit = order.getUserorderdeposit();
		// 已缴纳的总押金
		BigDecimal totaldeposit = order.getUserordertotaldeposit().add(deposit);
		// 订单处于等待病人付医院押金
		if (state == 6) {
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			// 7为已缴纳押金
			userorder.setUserorderstateid(7);
			//4为已住院(实际住院状态)
			userorder.setUserorderactualhospitalizationid(4);
			// 已缴纳的押金
			userorder.setUserordertotaldeposit(totaldeposit);
			boolean orderresult = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
			String sickname = pay.getPaysendername();
			boolean payresult  = payService.updatePayRecordToFinish( pay.getPayid(), trade_no, buyer_logon_id,
					seller_email, params.toString(), new BigDecimal(receip_tamount));
//			String purseresult = hospitalPurseService.updateBalance(pay.getPayreceiverid(), 1, new BigDecimal(total_amount), "收到病人"+sickname+"押金", pay.getPayid());
//			JSONObject purseObject = JSONObject.fromObject(purseresult);
	       //押金记录表
			Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(order.getUserorderhospid());
			Hosptitaldeposit hosptitaldeposit = new Hosptitaldeposit();
			hosptitaldeposit.setHospdepositnum(new BigDecimal(total_amount));
			hosptitaldeposit.setHospdepositremark(sickname+"缴纳"+hospinfo.getHospname()+"押金");
			hosptitaldeposit.setHospdeposittime(new Date());
			hosptitaldeposit.setHosploginid(order.getUserorderhospid());
			hosptitaldeposit.setUserloginid(order.getUserloginid());
			boolean depositresult = hosptitaldepositMapper.insertSelective(hosptitaldeposit)>0;
			//解除订单锁
			commonTradeService.queryUserOrderForFinish(pay.getPayorderid());
			if (payresult && orderresult && depositresult) {
				JSONObject jsonCustormCont = new JSONObject();
				jsonCustormCont.put("order_id", order.getUserorderid());
				jsonCustormCont.put("type", "5");
				senderNotificationService.createMsgUserToDoctor(order.getUserloginid(),order.getFamilyname(), 
						order.getUserorderdocloginid(), "通知消息", "支付成功", jsonCustormCont);
				return DataResult.success("支付成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("支付失败");
			}
		}else if (state == 9 && (actualhospitalizationid ==2 || actualhospitalizationid ==3)) {
			//需修改
			// 支付成功，订单取消，需要退款
			boolean payresult = payService.updatePayRecordToFinish( pay.getPayid(), trade_no, buyer_logon_id,
								seller_email, params.toString(), new BigDecimal(receip_tamount));
			String reason =  null;
			if (actualhospitalizationid ==2) {
				reason = "用户取消订单,支付成功";
			}else {
				reason = "医院取消订单,支付成功";
			}
			boolean result = abnormalOrderService.addAbnormalOrder(userorderid, 1, pay.getPayid(), reason);
			if (result && payresult) {
				return DataResult.success("支付完成");
			}else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("异常错误");
			}
		}else {
			return DataResult.success("已支付");
		}

	}
	// 取消住院
	@Override
	public String updateOrderStateToCancelHospital(Integer userloginid, Integer userorderid) throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		if (order.getUserloginid() != userloginid) {
			return DataResult.error("账户信息不匹配");
		}
		//判断订单是否处于支付中
		boolean isExit = commonTradeService.queryUserOrderIsExit(userorderid);
		if (isExit) {
			return DataResult.error("支付中,不可取消");
		}
		int stateid = order.getUserorderstateid();
		//实际住院状态
		int actualhospitalization = order.getUserorderactualhospitalizationid();
		if (stateid > 4 && stateid < 7) {
			//4已住院
			if (actualhospitalization==4) {
				return DataResult.error("住院中订单不可取消");
			}
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			userorder.setUserorderleavehosptime(new Date());
			//整个订单结束时间
			userorder.setUserorderfinishtime(new Date());
			//9为订单结束
			userorder.setUserorderstateid(9);
			//2为需要住院，病人取消
			userorder.setUserorderactualhospitalizationid(2);
			boolean orderResult = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
			Usersick usersick = new Usersick();
			usersick.setUsersickid(order.getUsersickid());
			//4为病情已结束
			usersick.setUsersickstateid(4);
			boolean sickResult = usersickMapper.updateByPrimaryKeySelective(usersick) > 0;
			if (orderResult && sickResult) {
				JSONObject jsonCustormCont = new JSONObject();
				jsonCustormCont.put("order_id", order.getUserorderid());
				jsonCustormCont.put("type", "5");
				senderNotificationService.createMsgUserToHospital(order.getUserloginid(), order.getFamilyname(), order.getUserorderhospid(), "消息通知", "取消住院",
						jsonCustormCont);
				return DataResult.success("取消成功");
			} else {
				return DataResult.error("取消失败");
			}

		} else {
			return DataResult.error("该订单状态不支持该操作");
		}

	}

	// 待修改
	@Override
	public String insertEvaluate(Integer userorderid, Integer userloginid, Integer doccommentservicelevel,
			Integer doccommentprofessionallevel, Integer doccommentpricelevel, String doccommentwords,
			Integer hospcommentservicelevel, Integer hospcommentenvironmenlevel, Integer hospcommentpricelevel,
			String hospcommentwords) throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userorder userorder = userorderMapper.selectByPrimaryKey(userorderid);
		if (userorder == null) {
			return DataResult.error("订单不存在");
		}
		int orderuserloginid = userorder.getUserloginid();
		if (userloginid != orderuserloginid) {
			return DataResult.error("账户信息不匹配");
		}
		int userorderstateid = userorder.getUserorderstateid();
		// 订单结束，可以评价
		if (userorderstateid == 9) {
			int hospitalizationid = userorder.getUserorderactualhospitalizationid();
			int familyid = usersickMapper.selectByPrimaryKey(userorder.getUsersickid()).getFamilyid();
			String name = familyinfoMapper.selectByPrimaryKey(familyid).getFamilyname();
			String username = StringReplaceUtil.userNameReplaceWithStar(name);
			Doctorcomment doctorcomment = new Doctorcomment();
			doctorcomment.setDoccommentpricelevel(doccommentpricelevel);
			doctorcomment.setDoccommentprofessionallevel(doccommentprofessionallevel);
			doctorcomment.setDoccommentservicelevel(doccommentservicelevel);
			doctorcomment.setDoccommentwords(doccommentwords);
			doctorcomment.setUserorderid(userorderid);
			doctorcomment.setUserloginid(userloginid);
			doctorcomment.setDoccommentpatientname(username);
			doctorcomment.setDocloginid(userorder.getUserorderdocloginid());
			doctorcomment.setDoccommenttime(new Date());
			int docResult = doctorcommentMapper.insertSelective(doctorcomment);
			if (docResult <= 0) {
				return DataResult.error("对医生评论失败");
			}
			if (hospitalizationid == 4) {
				Hospitalcomment hospitalcomment = new Hospitalcomment();
				hospitalcomment.setHospcommentenvironmenlevel(hospcommentenvironmenlevel);
				hospitalcomment.setHospcommentpricelevel(hospcommentpricelevel);
				hospitalcomment.setHospcommentservicelevel(hospcommentservicelevel);
				hospitalcomment.setHospcommentwords(hospcommentwords);
				hospitalcomment.setHosploginid(userorder.getUserorderhospid());
				hospitalcomment.setUserloginid(userloginid);
				hospitalcomment.setHospcommentpatientname(username);
				hospitalcomment.setUserorderid(userorderid);
				hospitalcomment.setHospcommenttime(new Date());
				int hospResult = hospitalcommentMapper.insertSelective(hospitalcomment);
				if (hospResult <= 0) {
					// 对医院评论失败
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return DataResult.error("对医院评论失败");
				}

			}
			Userorder order = new Userorder();
			order.setUserorderid(userorderid);
			order.setUserorderstateid(10);
			int userResult = userorderMapper.updateByPrimaryKeySelective(order);
			if (userResult > 0) {
				JSONObject jsonCustormCont = new JSONObject();
				senderNotificationService.createMsgUserToDoctor(userloginid,order.getFamilyname(),  userorder.getUserorderdocloginid(), "消息通知", "已对订单评价", jsonCustormCont);
				if (hospitalizationid == 4) {
					JSONObject jsonCustormCont2 = new JSONObject();
					jsonCustormCont.put("order_id", order.getUserorderid());
					jsonCustormCont.put("type", "5");
					senderNotificationService.createMsgUserToHospital(userloginid,order.getFamilyname(),  userorder.getUserorderhospid(), "消息通知", "已对订单评价", jsonCustormCont2);
				}
				return DataResult.success("评论成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("评论失败");
			}
		} else {
			return DataResult.error("该订单状态不支持评价");

		}

	}

	//申请退款
	@Override
	public String updateToRefund(Integer userorderid, Integer userloginid, String cancelreason) throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userorder userorder = userorderMapper.selectByPrimaryKey(userorderid);
		if (userorder == null) {
			return DataResult.error("订单不存在");
		}
		int orderuser = userorder.getUserloginid();
		if (userloginid != orderuser) {
			return DataResult.error("账户订单不匹配");
		}
		int userorderstate = userorder.getUserorderstateid();
		if (userorderstate!=4) {
			return DataResult.error("该订单不支持退款");
		}
		Userorder record = new Userorder();
		record.setUserorderid(userorderid);	
		record.setUserorderstateid(17);
		record.setCancelreason(cancelreason);
		record.setUserorderetime(new Date());
		boolean result = userorderMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("申请成功");
		}else {
			return DataResult.error("申请失败");
		}
		
	}
	
	
	

}
