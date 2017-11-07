package com.medical.service.impl.hospital;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.medical.exception.custom.HospitalOrderException;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctortitleMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.mapper.HosplogininfoMapper;
import com.medical.mapper.HosporderMapper;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.po.Userorder;
import com.medical.service.iface.hospital.HospitalOrderService;

public class HospitalOrderServiceImpl implements HospitalOrderService {
	@Autowired
	private HospitaldeptMapperCustom hospitaldeptMapperCustom;
	@Autowired
	private DoctortitleMapper doctortitleMapper;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private HosporderMapper hosporderMapper;
	@Autowired
	private HosplogininfoMapper hosplogininfoMapper;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private UserorderMapperCustom userorderMapperCustom;
	@Autowired
	private UserorderMapper userorderMapper;

	// 医院确认需要住院的病人订单
	@Override
	public boolean confirmUserOrder(Integer hosploginid, Integer userorderid, Double userorderdeposit,
			String userorderhospprimarydept, String userorderhospseconddept) throws Exception {
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order != null) {
			Integer stateid = order.getUserorderstateid();
			if (stateid == 5) {
				Userorder userorder = new Userorder();
				userorder.setUserorderid(userorderid);
				userorder.setUserorderdeposit(new BigDecimal(userorderdeposit));
				userorder.setUserorderstateid(6);
				userorder.setUserorderhospprimarydept(userorderhospprimarydept);
				userorder.setUserorderhospseconddept(userorderhospseconddept);
				return userorderMapper.updateByPrimaryKeySelective(userorder) > 0;

			} else {
				throw new HospitalOrderException("该订单状态不支持该操作");
			}

		} else {
			throw new HospitalOrderException("该订单不存在");
		}

	}

	// 医院确认需要住院的病人订单
	@Override
	public boolean refuseUserOrder(Integer hosploginid, Integer userorderid) throws Exception {
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order != null) {
			Integer stateid = order.getUserorderstateid();
			if (stateid == 5) {
				Userorder userorder = new Userorder();
				userorder.setUserorderid(userorderid);
				userorder.setUserorderstateid(9);
				return userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
			} else {
				throw new HospitalOrderException("该订单状态不支持该操作");
			}

		} else {
			throw new HospitalOrderException("该订单不存在");
		}

	}

}
