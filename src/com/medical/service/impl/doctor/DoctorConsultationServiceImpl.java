package com.medical.service.impl.doctor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.HosporderMapper;
import com.medical.mapper.HosporderMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Hosporder;
import com.medical.service.iface.CommonTradeService;
import com.medical.service.iface.SenderNotificationService;
import com.medical.service.iface.doctor.DoctorConsultationService;
import com.medical.utils.result.DataResult;
import net.sf.json.JSONObject;

public class DoctorConsultationServiceImpl implements DoctorConsultationService {
	@Autowired
	private HosporderMapper hosporderMapper;
	@Autowired
	private HosporderMapperCustom hosporderMapperCustom;
	@Autowired 
	private SenderNotificationService senderNotificationService;
	@Autowired
	private CommonTradeService commonTradeService;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;

	// 获取会诊
	@Override
	public String listConsultation(Integer docloginid, Integer type, Integer page) throws Exception{
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = hosporderMapperCustom.listByDocLoginIdAndType(docloginid, type);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());

	}

	// 获取会诊详情
	@Override
	public String listConsultationDetail(Integer docloginid, Integer hosporderid) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		Map<String, Object> data = hosporderMapperCustom.selectAllInfoByDocLoginIdAndHospOrderId(docloginid,
				hosporderid);
		if (data != null && !data.isEmpty()) {
			return DataResult.success("获取成功", data);
		} else {
			return DataResult.error("会诊不存在");
		}
	}

	// 确认会诊
	@Override
	public String updateConsultationToConfirm(Integer docloginid, Integer hosporderid, BigDecimal orderdoctorprice,
			Integer orderdoctortpricetype, BigDecimal orderdoctortprice, Integer orderdoctorapricetype,
			BigDecimal orderdoctoraprice, Integer orderdoctorepricetype, BigDecimal orderdoctoreprice) throws Exception {
		
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorlogininfo==null ||doctorinfo==null) {
			return DataResult.error("账号不存在");
		}
		int type = doctorlogininfo.getDoclogintype();
		if (type!=3) {
			return DataResult.error("账户未审核");
		}
		String alipayaccount = doctorinfo.getDocalipayaccount();
		String alipayname = doctorinfo.getDocalipayname();
		if (StringUtils.isBlank(alipayaccount)) {
			return DataResult.error("绑定的支付宝账号为空,不可进行该操作");
		}
		if (StringUtils.isBlank(alipayname)) {
			return DataResult.error("绑定的支付宝账号姓名为空,不可进行该操作");
		}
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("订单不存在");
		}
		int doctor = hosporder.getDoctorid();
		if (!docloginid.equals(doctor)) {
			return DataResult.error("账户信息不匹配");
		}
		int state = hosporder.getOrderstate();
		if (state != 1) {
			return DataResult.error("该状态不支持确认");
		}
		Hosporder record = new Hosporder();
		record.setHosporderid(hosporderid);
		// 2为等待医院确认付款
		record.setOrderstate(2);
		// 医生接单时间
		record.setOrderrtime(new Date());
		// 医生出诊费用
		record.setOrderdoctorprice(orderdoctorprice);
		BigDecimal total = orderdoctorprice;
		
		// 交通
		record.setOrderdoctortpricetype(orderdoctortpricetype);
		if (orderdoctortprice != null) {
			record.setOrderdoctortprice(orderdoctortprice);
		}
		if (2 == orderdoctortpricetype) {
			total = total.add(orderdoctortprice);
		}
		
		// 住宿
		record.setOrderdoctorapricetype(orderdoctorapricetype);
		if (orderdoctoraprice != null) {
			record.setOrderdoctoraprice(orderdoctoraprice);
		}
		if (2 == orderdoctorapricetype) {
			total = total.add(orderdoctoraprice);
		}
		
		// 餐饮
		record.setOrderdoctorepricetype(orderdoctorepricetype);
		if (orderdoctoreprice != null) {
			record.setOrderdoctoreprice(orderdoctoreprice);
		}
		if (2 == orderdoctorepricetype) {
			total = total.add(orderdoctoreprice);
		}
		record.setOrdertotaldoctorprice(total);
		boolean result = hosporderMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("hosp_order_id", hosporderid);
			jsonCustormCont.put("type", "6");
			senderNotificationService.createMsgDoctorToHospital(hosporder.getDoctorid(), hosporder.getHospid(), "消息通知", "确认了会诊",
					jsonCustormCont);
			return DataResult.success("确认成功");
		} else {
			return DataResult.error("确认失败");
		}
	}

	// 取消会诊
	@Override
	public String updateConsultationToCancel(Integer docloginid, Integer hosporderid) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账户不存在");
		}
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("订单不存在");
		}
		int doctor = hosporder.getDoctorid();
	    if (docloginid!=doctor) {
			return DataResult.error("账户信息不匹配");
		}
		//判断订单是否处于支付中
		boolean isExit = commonTradeService.queryHospitalOrderIsExit(hosporderid);
		if (isExit) {
			return DataResult.error("该订单正在支付,请稍后重试");
		}
		int state = hosporder.getOrderstate();
		switch (state) {

		case 4:
			return DataResult.error("医院已付款，不可取消");

		case 5:
			return DataResult.error("该状态不支持取消");

		case 6:
			return DataResult.error("医院已取消订单");

		case 7:
			return DataResult.error("该订单已取消");
		}
		Hosporder record = new Hosporder();
		record.setHosporderid(hosporderid);
		// 7为医生取消订单
		record.setOrderstate(7);
		// 订单结束时间
		record.setOrderetime(new Date());
		boolean result = hosporderMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("hosp_order_id", hosporderid);
			jsonCustormCont.put("type", "6");
			senderNotificationService.createMsgDoctorToHospital(hosporder.getDoctorid(), hosporder.getHospid(), "消息通知", "取消了会诊",
					jsonCustormCont);
			return DataResult.success("取消成功");
		} else {
			return DataResult.error("取消失败");
		} 
	}

}
