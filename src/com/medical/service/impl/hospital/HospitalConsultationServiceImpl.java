/**
 * 
 */
package com.medical.service.impl.hospital;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Null;

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
import com.medical.mapper.DoctortitleMapper;
import com.medical.mapper.HospinfoMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HospitaldeptMapper;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.mapper.HosplevelMapper;
import com.medical.mapper.HosplogininfoMapper;
import com.medical.mapper.HosporderMapper;
import com.medical.mapper.HosporderMapperCustom;
import com.medical.mapper.PayMapper;
import com.medical.mapper.PayMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.po.City;
import com.medical.po.Doctorcalendar;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Doctorpurse;
import com.medical.po.HospSearchDocTerm;
import com.medical.po.Hospinfo;
import com.medical.po.Hospitaldept;
import com.medical.po.Hosporder;
import com.medical.po.Pay;
import com.medical.po.Userorder;
import com.medical.po.custom.HospSearchDoc;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.hospital.HospitalConsultationService;
import com.medical.utils.TimeUtil;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.DataResult2;
import com.pay.alipay.AliPayNotify;
import com.pay.alipay.GetSign;
import com.pay.alipay.MakeOrderNum;

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
	private CommonService commonService;
	@Autowired
	private PayMapper payMapper;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private PayMapperCustom payMapperCustom;
	@Autowired
	private DoctorpurseMapperCustom doctorpurseMapperCustom;
	@Autowired
	private DoctorpurseMapper doctorpurseMapper;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private HospinfoMapper hospinfoMapper;
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private DoctorcalendarMapperCustom doctorcalendarMapperCustom;
	@Autowired
	private CityMapper cityMapper;
	@Autowired 
	private HospitaldeptMapper hospitaldeptMapper;
	@Autowired
	private DoctorcalendarMapper doctorcalendarMapper;

	
	/* (non-Javadoc)
	 * @see com.medical.service.iface.hospital.HospitalConsultationService#listDoctor(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String listDoctor(Integer pageNo, Integer pageSize, Integer province_code, Integer city_code, Integer area_code,
			String details, String doctortitle, String hosplevel, Integer one_level_dept,
			Integer two_level_dept) {
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
		Doctorlogininfo doc = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doc == null) {
			return DataResult.error("创建会诊失败,因医生不存在");
		}
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
		int result = hosporderMapper.insertSelective(hosporder);
		if (result > 0) {
			JSONObject jsonCustormCont = new JSONObject();
			boolean push = commonService.createMsgHospitalToDoctor(hosploginid, docloginid, "通知", "发送会诊请求",
					jsonCustormCont);
			if (push) {
				return DataResult.success("创建会诊成功，且消息发送成功");
			} else {
				return DataResult.success("创建会诊成功，但消息发送失败");
			}
		} else {
			return DataResult.error("创建会诊失败");
		}

	}

	// 取消会诊
	@Override
	public String cancelConsultation(Integer hosploginid, Integer hosporderid) throws Exception {
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("会诊不存在");
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
			boolean push = commonService.createMsgHospitalToDoctor(hosploginid, hosporder.getDoctorid(), "通知", "发送会诊请求",
					jsonCustormCont);
			if (push) {
				return DataResult.success("创建会诊成功，且消息发送成功");
			} else {
				return DataResult.success("创建会诊成功，但消息发送失败");
			}
		} else {
			return DataResult.error("取消会诊失败");
		}
	}

	/**
	 * 支付医生会诊费用
	 */
	@Override
	public String updateStatePayDoctor(Integer hosploginid, Integer hosporderid, Integer type) throws Exception {
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("会诊不存在");
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
				JSONObject jsonCustormCont = new JSONObject();

				boolean push = commonService.createMsgHospitalToDoctor(hosporder.getHospid(), hosporder.getDoctorid(),
						"消息通知", "已支付会诊费用", jsonCustormCont);
				if (push) {
					return DataResult.success("支付成功,且消息发送成功");
				} else {
					return DataResult.success("支付成功,但消息发送失败");
				}
			} else {
				return DataResult.error("支付失败");
			}

		}
		if (type == 1) {
			return updateStatePayDoctorByAliPay(hosporder);
		} else {
			return updateStatePayDoctorByAliPay(hosporder);
		}

	}

	public String updateStatePayDoctorByAliPay(Hosporder hosporder) throws Exception {
		Integer docloginid = hosporder.getDoctorid();
		Integer hosporderid = hosporder.getHosporderid();
		Integer hosploginid = hosporder.getHospid();
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		String boby = "速递医运医生会诊费用";
		String subject = "缴纳" + doctorinfo.getDocname() + "医生会诊费用";
		String totalAmount = hosporder.getOrdertotaldoctorprice() + "";
		String prefix = "h" + hosporderid + "d";
		String outTradeNo = MakeOrderNum.getTradeNo(prefix);
		// 回调地址
		String notifyUrl = "http://1842719ny8.iok.la:14086/internetmedical/hospital/paydoctorfinishbyalipay";
		String result = GetSign.webGetSign(boby, subject, totalAmount, outTradeNo, notifyUrl);
		Pay pay = new Pay();
		pay.setPaycreattime(new Date());
		// 1为支付宝支付
		pay.setPaymodeid(1);
		pay.setPaybuyerid(hosploginid);
		String hospname = hospinfoMapperCustom.selectByHospLoginId(hosploginid).getHospname();
		pay.setPaybuyername(hospname);
		pay.setPaytotalamount(new BigDecimal(totalAmount));
		pay.setPaysellerid(hosporder.getDoctorid());
		pay.setPaysellername(doctorinfo.getDocname());
		pay.setPayorderid(hosporderid);
		pay.setPaytradeno(outTradeNo);
		// 1为病人支付给医生
		pay.setPaytypeid(1);
		// 1为交易创建，等待买家付款
		pay.setPaystateid(1);
		boolean payResult = payMapper.insertSelective(pay) > 0;
		if (payResult) {
			return DataResult.success("获取数据成功", result);
		} else {
			return DataResult.error("支付失败");
		}
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
		String amount = params.get("buyer_pay_amount");
		// 支付宝交易号
		String trade_no = params.get("trade_no");
		// 附加数据
		// String passback_params = URLDecoder.decode(params.get("passback_params"));
		// 获取交易记录
		Pay pay = payMapperCustom.selectByPayTradeNo(out_trade_no);
		if (pay == null) {
			return DataResult.error("交易不存在");
		}

		// 交易记录信息
		Pay record = new Pay();
		record.setPayid(pay.getPayid());
		record.setPayalipaytradeno(trade_no);
		record.setPayendtime(new Date());
		record.setPayinfo(params.toString());
		record.setPayreceiptamount(new BigDecimal(amount));
		// 交易支付成功
		if ("TRADE_CLOSED".equals(params.get("trade_status"))) {
			// 未付款交易超时关闭，或支付完成后全额退款
			record.setPaystateid(2);
			boolean payResult = payMapper.updateByPrimaryKeySelective(record) > 0;
			if (payResult) {
				return DataResult.success("支付结束");
			} else {
				return DataResult.error("支付失败");
			}
		}

		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(pay.getPayorderid());
		if (hosporder == null) {
			return DataResult.error("订单不存在");
		}
		int stateid = hosporder.getOrderstate();
		int docloginid = hosporder.getDoctorid();
		if (stateid != 2) {
			return DataResult.success("已支付");
		}

		if ("TRADE_SUCCESS".equals(params.get("trade_status"))) {
			// 3为交易成功
			record.setPaystateid(3);
		} else {
			// 4为交易结束，不可退款
			record.setPaystateid(4);
		}

		// 更新交易记录
		boolean payResult = payMapper.updateByPrimaryKeySelective(record) > 0;

		// 会诊订单
		Hosporder HosporderRecord = new Hosporder();
		HosporderRecord.setHosporderid(hosporder.getHosporderid());
		// 3付款完成，等待医生会诊
		HosporderRecord.setOrderstate(3);
		boolean orderResult = hosporderMapper.updateByPrimaryKeySelective(HosporderRecord) > 0;

		// 更新医生钱包
		BigDecimal total = new BigDecimal(amount);
		List<Doctorpurse> list = doctorpurseMapperCustom.selectByDocLoginId(docloginid);
		if (list != null && list.size() > 0) {
			for (Doctorpurse doctorpurse : list) {
				int type = doctorpurse.getDocpursetypeid();
				BigDecimal price = doctorpurse.getDocpurseamount();
				if (type == 2) {
					total = total.subtract(price.abs());
				} else {
					total = total.add(price.abs());
				}
			}
		}

		Doctorpurse doctorpurse = new Doctorpurse();
		doctorpurse.setDocloginid(docloginid);
		doctorpurse.setDocpurseamount(new BigDecimal(amount));
		doctorpurse.setDocpurseremark("收到医院付款");
		doctorpurse.setDocpursetime(new Date());
		// 1为转入
		doctorpurse.setDocpursetypeid(1);
		doctorpurse.setPayid(pay.getPayid());
		doctorpurse.setDocpursebalance(total);
		boolean purseResult = doctorpurseMapper.insertSelective(doctorpurse) > 0;
		// 更新医生余额
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		Doctorinfo doctorinfoRecord = new Doctorinfo();
		doctorinfoRecord.setDocid(doctorinfo.getDocid());
		doctorinfoRecord.setDocpursebalance(total);
		boolean doctorinfoResult = doctorinfoMapper.updateByPrimaryKeySelective(doctorinfoRecord) > 0;

		if (doctorinfoResult && purseResult && payResult && orderResult) {
			JSONObject jsonCustormCont = new JSONObject();
			commonService.createMsgHospitalToDoctor(hosporder.getHospid(), docloginid, "消息通知", "已支付会诊费用",
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
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("会诊不存在");
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
		boolean result = hosporderMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			return DataResult.success("会诊完成成功");
		} else {
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
			return DataResult.success("获取数据成功", map);
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}

	/* (non-Javadoc)
	 * @see com.medical.service.iface.hospital.HospitalConsultationService#listCalendar(java.lang.Integer)
	 */
	@Override
	public String listCalendar(Integer docloginid) {
		List<Map<String, Object>> list =  doctorcalendarMapperCustom.selectAllInfoByDocloginidInUser(docloginid);
		if (list != null && list.size()>0) {
			return DataResult2.success("获取数据成功", list);
		}else {
			return DataResult2.success("获取数据为空", null);
		}
	}

	
}
