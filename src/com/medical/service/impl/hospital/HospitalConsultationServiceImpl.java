package com.medical.service.impl.hospital;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.CityMapper;
import com.medical.mapper.DoctorcalendarMapper;
import com.medical.mapper.DoctorcalendarMapperCustom;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctorpurseMapper;
import com.medical.mapper.DoctorpurseMapperCustom;
import com.medical.mapper.HospinfoMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HospitaldeptMapper;
import com.medical.mapper.HosplogininfoMapper;
import com.medical.mapper.HosporderMapper;
import com.medical.mapper.HosporderMapperCustom;
import com.medical.mapper.PayMapper;
import com.medical.mapper.PayMapperCustom;
import com.medical.po.City;
import com.medical.po.Doctorcalendar;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Hospinfo;
import com.medical.po.Hospitaldept;
import com.medical.po.Hosplogininfo;
import com.medical.po.Hosporder;
import com.medical.po.Pay;
import com.medical.po.custom.HospSearchDoc;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.CommonTradeService;
import com.medical.service.iface.PayService;
import com.medical.service.iface.SenderNotificationService;
import com.medical.service.iface.doctor.DoctorPurseService;
import com.medical.service.iface.hospital.HospitalConsultationService;
import com.medical.utils.MakeRandomNum;
import com.medical.utils.TimeUtil;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.DataResult2;
import com.pay.alipay.AliPayNotify;
import com.pay.alipay.AlipayConfig;
import com.pay.alipay.MyAliPay;
import com.pay.wxpay.ConfigUtil;
import com.pay.wxpay.MyWXPay;

import net.sf.json.JSONObject;


/**
 * @ClassName: HospitalConsultationServiceImpl.java
 * @Description: 会诊管理
 * @author xyh
 * @version V1.0
 * @Date 2017年11月27日 下午3:17:20
 */

class HospitalConsultationServiceImpl implements HospitalConsultationService {

	@Autowired
	private HosporderMapper hosporderMapper;
	@Autowired
	private HosporderMapperCustom hosporderMapperCustom;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private PayMapperCustom payMapperCustom;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private DoctorcalendarMapperCustom doctorcalendarMapperCustom;
	@Autowired
	private CityMapper cityMapper;
	@Autowired 
	private HospitaldeptMapper hospitaldeptMapper;
	@Autowired
	private DoctorcalendarMapper doctorcalendarMapper;
	@Autowired 
	private SenderNotificationService senderNotificationService;
	@Autowired
	private CommonTradeService commonTradeService;
	@Autowired
	private DoctorPurseService doctorPurseService;
	@Autowired
	private PayService payService;
	@Autowired
	private PayMapper payMapper;
	@Autowired
	private HosplogininfoMapper hosplogininfoMapper;
	
	/* (non-Javadoc)
	 * @see com.medical.service.iface.hospital.HospitalConsultationService#listDoctor(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String listDoctor(Integer pageNo, Integer pageSize, Integer province_code, Integer city_code, Integer area_code,
			String details, String doctortitle, String hosplevel, Integer one_level_dept,
			Integer two_level_dept)throws Exception {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		String province=null;
		String city=null;
		String area=null;
		String one_level=null;
		String two_level=null;
		if (province_code!=null) {
			City city2 = cityMapper.selectByPrimaryKey(province_code+"");
			if (city2==null) {
				return DataResult.error("当前城市不存在");
			}
			province= city2.getCityname();
		}
		if (city_code!=null) {
			City city2 = cityMapper.selectByPrimaryKey(city_code+"");
			if (city2==null) {
				return DataResult.error("当前城市不存在");
			}
			city= city2.getCityname();
		}
		if (area_code!=null) {
			City city2 = cityMapper.selectByPrimaryKey(area_code+"");
			if (city2==null) {
				return DataResult.error("当前城市不存在");
			}
			area= city2.getCityname();
		}
		if (one_level_dept!=null) {
			Hospitaldept hospitaldept = hospitaldeptMapper.selectByPrimaryKey(one_level_dept);
			if (hospitaldept==null) {
				return DataResult.error("当前部门不存在");
			}
			one_level = hospitaldept.getHospdeptname();
		}
		if (two_level_dept!=null) {
			Hospitaldept hospitaldept = hospitaldeptMapper.selectByPrimaryKey(two_level_dept);
			if (hospitaldept==null) {
				return DataResult.error("当前部门不存在");
			}
			two_level = hospitaldept.getHospdeptname();
		}
		HospSearchDoc hospSearchDoc = new HospSearchDoc();
		hospSearchDoc.setArea_code(area);
		hospSearchDoc.setCity_code(city);
		hospSearchDoc.setDetails(details);
		hospSearchDoc.setDoctorTitle(doctortitle);
		hospSearchDoc.setOne_level_dept(one_level);
		hospSearchDoc.setProvince_code(province);
		hospSearchDoc.setTwo_level_dept(two_level);
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = doctorinfoMapperCustom.paginationDoctorListInHosp(hospSearchDoc);
		// 用PageInfo对结果进行包装
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		if (page != null && !page.getList().isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("BaseData", page.getList());
			// 总共页数
			map.put("allcount", page.getPages());
			// 当前页
			map.put("page", page.getPageNum());
			return DataResult.success("获取数据成功", map);
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}
	// 创建会诊
	@Override
	public String creatConsultation(Integer docloginid, Integer hosploginid, String orderabs, String orderstime,
			BigDecimal orderhospprice, Integer orderhosptpricetype, BigDecimal orderhosptprice,
			Integer orderhospapricetype, BigDecimal orderhospaprice, Integer orderhospepricetype,
			BigDecimal orderhospeprice) throws Exception {
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("该医院账户不存在");
		}
		int type = hosplogininfo.getHosplogintype();
		if (type!=3) {
			return DataResult.error("账户未审核");
		}
		String hospalipayaccount = hospinfo.getHospalipayaccount();
		String hospalipayname = hospinfo.getHospalipayname();
		if (StringUtils.isBlank(hospalipayaccount)) { 
			return DataResult.error("绑定的支付宝账号为空,不可进行该操作");
		}
		if (StringUtils.isBlank(hospalipayname)) {
			return DataResult.error("绑定的支付宝账号姓名为空,不可进行该操作");
		}
		Doctorlogininfo doc = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doc == null  ||doctorinfo==null) {
			return DataResult.error("创建会诊失败,因医生不存在");
		}
		String alipayaccount = doctorinfo.getDocalipayaccount();
		String alipayname = doctorinfo.getDocalipayname();
//		if (StringUtils.isBlank(alipayaccount)) {
//			return DataResult.error("该医生绑定的支付宝账号为空,不可进行该操作");
//		}
//		if (StringUtils.isBlank(alipayname)) {
//			return DataResult.error("该医生绑定的支付宝账号姓名为空,不可进行该操作");
//		}
		Hosporder hosporder = new Hosporder();
		hosporder.setDoctorid(docloginid);
		hosporder.setOrderabs(orderabs);
		hosporder.setHospid(hosploginid);
		hosporder.setOrderptime(new Date());
		Doctorcalendar doctorcalendar = doctorcalendarMapper.selectByPrimaryKey(Integer.parseInt(orderstime));
		if (doctorcalendar==null) {
			return DataResult.error("日程不存在");
		}
		String day = TimeUtil.dateToStrLong(doctorcalendar.getDoccalendarday());
		hosporder.setOrderstime(day+" "+doctorcalendar.getDoccalendartime());
		// 等待医生确认
		hosporder.setOrderstate(1);
		// 医生出诊价格
		hosporder.setOrderhospprice(orderhospprice);
		//hosporder.setOrderdoctorprice(orderhospprice);
		// 交通类型
		hosporder.setOrderhosptpricetype(orderhosptpricetype);
		//hosporder.setOrderdoctortpricetype(orderhosptpricetype);
		BigDecimal total = orderhospprice;
		if (orderhosptprice != null) {
			hosporder.setOrderhosptprice(orderhosptprice);
			//hosporder.setOrderdoctortprice(orderhosptprice);
		}
		if (2 == orderhosptpricetype) {
			total = total.add(orderhosptprice);
		}
		// 住宿类型
		hosporder.setOrderhospapricetype(orderhospapricetype);
		//hosporder.setOrderdoctorapricetype(orderhospapricetype);
		if (orderhospaprice != null) {
			hosporder.setOrderhospaprice(orderhospaprice);
			//hosporder.setOrderdoctoraprice(orderhospaprice);
		}
		if (2 == orderhospapricetype) {
			total = total.add(orderhospaprice);
		}
		// 餐饮类型
		hosporder.setOrderhospepricetype(orderhosptpricetype);
		//hosporder.setOrderdoctorepricetype(orderhosptpricetype);
		if (orderhospeprice != null) {
			hosporder.setOrderhospeprice(orderhospeprice);
			//hosporder.setOrderdoctoreprice(orderhospeprice);
		}
		if (2 == orderhospepricetype) {
			total = total.add(orderhospeprice);
		}
		hosporder.setOrdertotalhospprice(total);
		//hosporder.setOrdertotaldoctorprice(total);
		int result = hosporderMapperCustom.insertSelectiveReturnId(hosporder);
		if (result > 0) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("hosp_order_id", hosporder.getHosporderid());
			jsonCustormCont.put("type", "6");
			senderNotificationService.createMsgHospitalToDoctor(hosploginid, docloginid, "通知", "发送会诊请求",
					jsonCustormCont);
			return DataResult.success("创建会诊成功");
		} else {
			return DataResult.error("创建会诊失败");
		}

	}

	// 取消会诊
	@Override
	public String cancelConsultation(Integer hosploginid, Integer hosporderid) throws Exception {
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账户不存在");
		}
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("会诊不存在");
		}
		int hosp = hosporder.getHospid();
		if (hosploginid!=hosp) {
			return DataResult.error("账户信息不匹配");
		}
		int orderState = hosporder.getOrderstate();
		if (orderState > 3) {
			return DataResult.error("该会诊状态不支持取消");
		}
		Hosporder record = new Hosporder();
		record.setHosporderid(hosporderid);
		// 6为医院取消订单
		record.setOrderstate(6);
		record.setOrderetime(new Date());
		boolean result = hosporderMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("hosp_order_id", hosporder.getHosporderid());
			jsonCustormCont.put("type", "6");
			senderNotificationService.createMsgHospitalToDoctor(hosploginid, hosporder.getDoctorid(), "通知", "发送会诊请求",
					jsonCustormCont);
			return DataResult.success("创建会诊成功");
		} else {
			return DataResult.error("取消会诊失败");
		}
	}

	/**
	 * 支付医生会诊费用
	 */
	@Override
	public String updateStatePayDoctor(Integer hosploginid, Integer hosporderid, Integer type, String ip) throws Exception {
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账户不存在");
		}
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("会诊不存在");
		}
		int hosp = hosporder.getHospid();
		if (hosploginid!=hosp) {
			return DataResult.error("账户信息不匹配");
		}
		//订单锁
		boolean tradestate = commonTradeService.queryHospitalOrderForCreat(hosporderid);
		if (tradestate) {
			return DataResult.error("支付中,请稍后重试");
		}
		int orderState = hosporder.getOrderstate();
		if (orderState != 2) {
			return DataResult.error("该会诊状态不支持付款");
		}
		BigDecimal totalAmount = hosporder.getOrdertotaldoctorprice();
		if (totalAmount.compareTo(BigDecimal.ZERO) == 0) {
			// 会诊订单
			Hosporder HosporderRecord = new Hosporder();
			HosporderRecord.setHosporderid(hosporder.getHosporderid());
			// 3付款完成，等待医生会诊
			HosporderRecord.setOrderstate(3);
			boolean orderResult = hosporderMapper.updateByPrimaryKeySelective(HosporderRecord) > 0;
			if (orderResult) {
				//解除订单锁
				 commonTradeService.queryHospitalOrderForFinish(hosporderid);
				JSONObject jsonCustormCont = new JSONObject();
				jsonCustormCont.put("hosp_order_id", hosporder.getHosporderid());
				jsonCustormCont.put("type", "6");
				senderNotificationService.createMsgHospitalToDoctor(hosporder.getHospid(), hosporder.getDoctorid(),
						"消息通知", "已支付会诊费用", jsonCustormCont);
				return DataResult.success("支付成功");
			} else {
				return DataResult.error("支付失败");
			}

		}
		if (type == 1) {
			return updateStatePayDoctorByAliPay(hosporder);
		} else {
			return updateStatePayDoctorByWXPay(hosporder,ip);
		}

	}
	@Transactional(rollbackFor = Exception.class)
	public String updateStatePayDoctorByWXPay(Hosporder hosporder,String ip) throws Exception {
		Integer docloginid = hosporder.getDoctorid();
		Integer hosporderid = hosporder.getHosporderid();
		Integer hosploginid = hosporder.getHospid();
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		String boby = "速递医运——医生会诊费用";
		String subject = "缴纳" + doctorinfo.getDocname() + "医生会诊费用";
		BigDecimal totalAmount = hosporder.getOrdertotaldoctorprice() ;
		String prefix = "hd";
		String outTradeNo = MakeRandomNum.getTradeNo(prefix);
		// 回调地址
		String notifyUrl = ConfigUtil.WEB_HSOP_NOTIFY_URL;
		String hospname = hospinfoMapperCustom.selectByHospLoginId(hosploginid).getHospname();
		//支付记录
		int payid  = payService.updatePayRecordToCreat(hosploginid, hospname, hosporder.getOrdertotaldoctorprice(), hosporder.getDoctorid(), doctorinfo.getDocname(), 
				hosporderid, 2, 3, outTradeNo,2);
		if (payid==0) {
			return DataResult.error("异常错误");
		}
		String result = MyWXPay.wxPrePay(boby, subject, totalAmount, notifyUrl, outTradeNo, ip,"NATIVE");
		JSONObject jsonObject2 = JSONObject.fromObject(result);
		if ("200".equals(jsonObject2.get("code").toString())) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return result;
		}
		Map<String, String> map=  (Map<String, String>) jsonObject2.get("data");
		map.put("payid",  payid+"");
		return DataResult.success("获取成功", map);
		
   }
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateStatePayDoctorFinishByWXPay(HttpServletRequest request) throws Exception {
		Map<String, String> params = MyWXPay.wxNotify(request);
		// 通信失败
		if ("FAIL".equals((String) params.get("return_code"))) {
			return DataResult.error("通信失败");
		}
		// 商户订单号
		String out_trade_no = (String) params.get("out_trade_no");
		// 微信单号
		String trade_no = (String) params.get("transaction_id");
		String buyer_logon_id = (String) params.get("openid");
		String seller_email = (String) params.get("mch_id");
		String err_code_des = (String) params.get("err_code_des");
		
		// 获取交易记录
		Pay pay = payMapperCustom.selectByPayTradeNo(out_trade_no);
		if (pay == null) {
			return DataResult.error("交易记录不存在");
		}
		Integer hosporderid = pay.getPayorderid();
		// 交易支付失败
		if ("FAIL".equals((String) params.get("result_code"))) {
			// 解除订单锁
			commonTradeService.queryUserOrderForFinish(pay.getPayorderid());
			boolean payresult =  payService.updatePayRecordToCancle(pay.getPayid(), trade_no,
					buyer_logon_id, seller_email, params.toString(), err_code_des);
			if (payresult) {
				return DataResult.success("更新成功");
			}else {
				return DataResult.error("更新失败");
			}
			

		}
		return updateAfterPaySuccess(pay, params, "WXPay");
//		// 付款金额
//		String receipt = (String) params.get("total_fee");
//		String receiptamount = new BigDecimal(receipt).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP).toString();
//		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(pay.getPayorderid());
//		if (hosporder == null) {
//			return DataResult.error("订单不存在");
//		
//		}
//		int state = hosporder.getOrderstate();
//		int docloginid = hosporder.getDoctorid();
//		if (state != 2) {
//			return DataResult.success("已支付");
//			
//		}
//		// 更新交易记录
//		boolean payresult  = payService.updatePayRecordToFinish( pay.getPayid(), trade_no, buyer_logon_id,
//				seller_email,  params.toString(), new BigDecimal(receiptamount));
//        // 会诊订单
//		Hosporder HosporderRecord = new Hosporder();
//		HosporderRecord.setHosporderid(hosporder.getHosporderid());
//		// 3付款完成，等待医生会诊
//		HosporderRecord.setOrderstate(3);
//		boolean orderresult = hosporderMapper.updateByPrimaryKeySelective(HosporderRecord) > 0;
//		String purseresult = doctorPurseService.updateBalance(docloginid, 1, new BigDecimal(receiptamount), "收到医院付款", pay.getPayid());
//		JSONObject purseObject = JSONObject.fromObject(purseresult);
//		//解除订单锁
//		commonTradeService.queryHospitalOrderForFinish(hosporderid);
//		if (payresult && "100".equals(purseObject.get("code").toString()) && orderresult ) {
//			JSONObject jsonCustormCont = new JSONObject();
//			jsonCustormCont.put("hosp_order_id", hosporder.getHosporderid());
//			jsonCustormCont.put("type", "6");
//			senderNotificationService.createMsgHospitalToDoctor(hosporder.getHospid(), docloginid, "消息通知", "已支付会诊费用",
//					jsonCustormCont);
//			return DataResult.success("支付成功");
//		} else {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			return DataResult.error("支付失败");
//		}
	}
	public String updateStatePayDoctorByAliPay(Hosporder hosporder) throws Exception {
		Integer docloginid = hosporder.getDoctorid();
		Integer hosporderid = hosporder.getHosporderid();
		Integer hosploginid = hosporder.getHospid();
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		String boby = "速递医运医生会诊费用";
		String subject = "缴纳" + doctorinfo.getDocname() + "医生会诊费用";
		String totalAmount = hosporder.getOrdertotaldoctorprice() + "";
		String prefix = "hd";
		String outTradeNo = MakeRandomNum.getTradeNo(prefix);
		// 回调地址
		String notifyUrl = AlipayConfig.WEB_HSOP_NOTIFY_URL;
		String hospname = hospinfoMapperCustom.selectByHospLoginId(hosploginid).getHospname();
		//支付记录
		int payid  = payService.updatePayRecordToCreat(hosploginid, hospname, hosporder.getOrdertotaldoctorprice(), hosporder.getDoctorid(), doctorinfo.getDocname(), 
				hosporderid, 2, 3, outTradeNo,1);
		if (payid==0) {
			return DataResult.error("异常错误");
		}
		String result = MyAliPay.webGetSign(boby, subject, totalAmount, outTradeNo, notifyUrl);
		return result;
   }

	/**
	 * 支付医生会诊费用完成
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateStatePayDoctorFinish(Map<String, String[]> requestParams) throws Exception {
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
		int hosporderid = pay.getPayorderid();
		// 交易支付成功
		if ("TRADE_CLOSED".equals(params.get("trade_status"))) {
			
			boolean payresult  = payService.updatePayRecordToCancle( pay.getPayid(), trade_no, 
					buyer_logon_id, seller_email, params.toString(),"交易失败");
			if (payresult) {
				return DataResult.success("支付结束"); 
			}else {
				return DataResult.error("异常错误");
			}
		}
		return updateAfterPaySuccess(pay, params, "Alipay");
//		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(pay.getPayorderid());
//		if (hosporder == null) {
//			return DataResult.error("订单不存在");
//		}
//		int state = hosporder.getOrderstate();
//		int docloginid = hosporder.getDoctorid();
//		if (state != 2) {
//			return DataResult.success("已支付");
//		}
//
//		/*int stateid = 3;
//		if ("TRADE_SUCCESS".equals(params.get("trade_status"))) {
//		// 3为交易成功
//		  stateid = 3;
//	    } else {
//			// 4为交易结束，不可退款
//	    	stateid = 4;
//		}*/
//
//		// 更新交易记录
//		boolean payresult  = payService.updatePayRecordToFinish( pay.getPayid(), trade_no, buyer_logon_id,
//				seller_email,  params.toString(), new BigDecimal(receip_tamount));
//        // 会诊订单
//		Hosporder HosporderRecord = new Hosporder();
//		HosporderRecord.setHosporderid(hosporder.getHosporderid());
//		// 3付款完成，等待医生会诊
//		HosporderRecord.setOrderstate(3);
//		boolean orderresult = hosporderMapper.updateByPrimaryKeySelective(HosporderRecord) > 0;
//		String purseresult = doctorPurseService.updateBalance(docloginid, 1, new BigDecimal(total_amount), "收到医院付款", pay.getPayid());
//		JSONObject purseObject = JSONObject.fromObject(purseresult);
//		//解除订单锁
//		commonTradeService.queryHospitalOrderForFinish(hosporderid);
//		if (payresult && "100".equals(purseObject.get("code").toString()) && orderresult ) {
//			JSONObject jsonCustormCont = new JSONObject();
//			jsonCustormCont.put("hosp_order_id", hosporder.getHosporderid());
//			jsonCustormCont.put("type", "6");
//			senderNotificationService.createMsgHospitalToDoctor(hosporder.getHospid(), docloginid, "消息通知", "已支付会诊费用",
//					jsonCustormCont);
//			return DataResult.success("支付成功");
//		} else {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			return DataResult.error("支付失败");
//		}
	}
	private String updateAfterPaySuccess(Pay pay,Map<String, String> params,String payMethod) throws Exception {
		
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
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(pay.getPayorderid());
		if (hosporder == null) {
			return DataResult.error("订单不存在");
		}
		int state = hosporder.getOrderstate();
		int docloginid = hosporder.getDoctorid();
		if (state != 2) {
			return DataResult.success("已支付");
		}
		// 更新交易记录
		boolean payresult  = payService.updatePayRecordToFinish( pay.getPayid(), trade_no, buyer_logon_id,
				seller_email,  params.toString(), new BigDecimal(receip_tamount));
        // 会诊订单
		Hosporder HosporderRecord = new Hosporder();
		HosporderRecord.setHosporderid(hosporder.getHosporderid());
		// 3付款完成，等待医生会诊
		HosporderRecord.setOrderstate(3);
		boolean orderresult = hosporderMapper.updateByPrimaryKeySelective(HosporderRecord) > 0;
		//String purseresult = doctorPurseService.updateBalance(docloginid, 1, new BigDecimal(total_amount), "收到医院付款", pay.getPayid());
		//JSONObject purseObject = JSONObject.fromObject(purseresult);
		//解除订单锁
		commonTradeService.queryHospitalOrderForFinish(pay.getPayorderid());
		if (payresult &&  orderresult ) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("hosp_order_id", hosporder.getHosporderid());
			jsonCustormCont.put("type", "6");
			senderNotificationService.createMsgHospitalToDoctor(hosporder.getHospid(), docloginid, "消息通知", "已支付会诊费用",
					jsonCustormCont);
			return DataResult.success("支付成功");
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("支付失败");
		}
	
	}
	// 会诊完成
	@Override
	public String updateStateFinishConsultation(Integer hosploginid, Integer hosporderid) throws Exception {
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账户不存在");
		}
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("会诊不存在");
		}
		int hosp = hosporder.getHospid();
		if (hosploginid!=hosp) {
			return DataResult.error("账户信息不匹配");
		}
		int orderState = hosporder.getOrderstate();
		if (orderState != 3) {
			return DataResult.error("该会诊状态不支持该操作");
		}
		Hosporder record = new Hosporder();
		record.setHosporderid(hosporderid);
		// 4为会诊完成
		record.setOrderstate(4);
		record.setOrderetime(new Date());
		String purseresult = doctorPurseService.updateBalance(hosporder.getDoctorid(), 1, 
				hosporder.getOrdertotaldoctorprice(), "收到医院付款", 0);
		JSONObject purseObject = JSONObject.fromObject(purseresult);
		boolean result = hosporderMapper.updateByPrimaryKeySelective(record) > 0;
		if (result && "100".equals(purseObject.get("code").toString())) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("hosp_order_id", hosporder.getHosporderid());
			jsonCustormCont.put("type", "6");
			senderNotificationService.createMsgHospitalToDoctor(hosporder.getHospid(), hosporder.getDoctorid(), "消息通知", "已结束会诊",
					jsonCustormCont);
			return DataResult.success("会诊完成成功");
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("会诊完成失败");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medical.service.iface.hospital.HospitalConsultationService#
	 * listConsultation(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String listConsultation(Integer hosploginid, Integer limit, Integer offset, Integer type) throws Exception {

		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = hosporderMapperCustom.selectByHospLoginId(hosploginid, type);
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

	

	@Override
	public String getPaySate(Integer hosploginid,Integer payid) throws Exception{
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账户不存在");
		}
		Pay pay = payMapper.selectByPrimaryKey(payid);
		if (pay==null ) {
			return DataResult.error("该支付记录不存在");
		}
		return DataResult2.success("获取成功", pay.getPaystateid());
	}
}
