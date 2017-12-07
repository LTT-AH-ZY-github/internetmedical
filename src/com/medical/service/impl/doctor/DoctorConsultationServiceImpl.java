package com.medical.service.impl.doctor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.HosporderMapper;
import com.medical.mapper.HosporderMapperCustom;
import com.medical.po.Hosporder;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.doctor.DoctorConsultationService;
import com.medical.utils.result.DataResult;

import net.sf.json.JSONObject;

public class DoctorConsultationServiceImpl implements DoctorConsultationService {
	

	
	@Autowired
	private HosporderMapper hosporderMapper;
	@Autowired
	private HosporderMapperCustom hosporderMapperCustom;
	@Autowired
	private CommonService commonService;

	// 获取会诊
	@Override
	public String listConsultation(Integer docloginid, Integer type, Integer page) throws Exception{
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = hosporderMapperCustom.listByDocLoginIdAndType(docloginid, type);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && pageInfo.getTotal() > 0) {
			return DataResult.success("获取数据成功", pageInfo.getList());
		} else {
			return DataResult.success("获取数据为空", null);
		}

	}

	// 获取会诊详情
	@Override
	public String listConsultationDetail(Integer docloginid, Integer hosporderid) throws Exception {
		Map<String, Object> data = hosporderMapperCustom.selectAllInfoByDocLoginIdAndHospOrderId(docloginid,
				hosporderid);
		if (data != null && !data.isEmpty()) {
			return DataResult.success("获取成功", data);
		} else {
			return DataResult.error("会诊不存在", null);
		}
	}

	// 确认会诊
	@Override
	public String updateConsultationToConfirm(Integer docloginid, Integer hosporderid, BigDecimal orderdoctorprice,
			Integer orderdoctortpricetype, BigDecimal orderdoctortprice, Integer orderdoctorapricetype,
			BigDecimal orderdoctoraprice, Integer orderdoctorepricetype, BigDecimal orderdoctoreprice) throws Exception {
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("订单不存在");
		}
		int doctor = hosporder.getDoctorid();
		if (!docloginid.equals(doctor)) {
			return DataResult.error("该订单不属于该医生");
		}
		int state = hosporder.getOrderstate();
		System.out.println("状态值。。。"+state);
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
			
			boolean push = commonService.createMsgDoctorToHospital(hosporder.getDoctorid(), hosporder.getHospid(), "消息通知", "确认了会诊",
					jsonCustormCont);
			return DataResult.success("确认成功");
		} else {
			return DataResult.error("确认失败");
		}
	}

	// 取消会诊
	@Override
	public String updateConsultationToCancel(Integer docloginid, Integer hosporderid) throws Exception {
		System.out.println("订单id"+hosporderid);
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("订单不存在");
		}
		int doctor = hosporder.getDoctorid();
		System.out.println("医生id"+doctor+"医生"+docloginid);
		if (docloginid!=doctor) {
			return DataResult.error("该订单不属于该医生");
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
			
			boolean push = commonService.createMsgDoctorToHospital(hosporder.getDoctorid(), hosporder.getHospid(), "消息通知", "取消了会诊",
					jsonCustormCont);
			return DataResult.success("取消成功");
		} else {
			return DataResult.error("取消失败");
		}
	}

}
