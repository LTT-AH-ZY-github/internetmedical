package com.medical.service.impl.hospital;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.baidu.yun.push.utils.PushToAndroid;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import com.medical.po.Doctorlogininfo;
import com.medical.po.HospSearchDocTerm;
import com.medical.po.Hospinfo;
import com.medical.po.Hosporder;
import com.medical.po.Userorder;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.hospital.HospitalOrderService;
import com.medical.utils.result.DataResult;

import net.sf.json.JSONObject;

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
	@Autowired
	private CommonService commonService;
	
	@Override
	public String listDoctor(Integer pageNo, Integer pageSize, HospSearchDocTerm hospSearchDocTerm) throws Exception {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = doctorinfoMapperCustom.paginationDoctorList(null);
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

	// 医院拒绝需要住院的病人订单
	@Override
	public String refuseUserOrder(Integer hosploginid, Integer userorderid) throws Exception {
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order != null) {
			Integer stateid = order.getUserorderstateid();
			if (stateid == 5) {
				Userorder userorder = new Userorder();
				userorder.setUserorderid(userorderid);
				userorder.setUserorderstateid(9);
				//3为需要住院，医院拒绝
				userorder.setUserorderactualhospitalizationid(3);
				boolean result =  userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
				if (result) {
					return DataResult.success("操作成功");
				} else {
					return DataResult.error("操作失败");
				}
			} else {
				return DataResult.error("该订单状态不支持该操作");
			}

		} else {
			return DataResult.error("该订单不存在");
		}

	}
	@Override
	public String updateUserOrderDeposit(Integer hosploginid, Integer userorderid, BigDecimal userorderdeposit) {
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order != null) {
			BigDecimal totalDeposit = order.getUserorderdeposit();
			totalDeposit.add(userorderdeposit);
			Integer stateid = order.getUserorderstateid();
			if (stateid == 7) {
				Userorder userorder = new Userorder();
				userorder.setUserorderid(userorderid);
				userorder.setUserordertotaldeposit(totalDeposit);
				userorder.setUserorderstateid(6);
				boolean result =  userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
				if (result) {
					return DataResult.success("操作成功");
				} else {
					return DataResult.error("操作失败");
				}
			} else {
				return DataResult.error("该订单状态不支持该操作");
			}

		} else {
			return DataResult.error("该订单不存在");
		}
		
	}
	
	
	
	@Override
	public String updateUserOrderToSettle(Integer hosploginid, Integer userorderid, BigDecimal userorderhprice) {
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order != null) {
			
			Integer stateid = order.getUserorderstateid();
			if (stateid == 7) {
				Userorder userorder = new Userorder();
				userorder.setUserorderid(userorderid);
				//住院实际产生的费用
				userorder.setUserorderhprice(userorderhprice);
				//8住院完成，等待结算费用
				userorder.setUserorderstateid(8);
				boolean result =  userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
				if (result) {
					return DataResult.success("操作成功");
				} else {
					return DataResult.error("操作失败");
				}
			} else {
				return DataResult.error("该订单状态不支持该操作");
			}

		} else {
			return DataResult.error("该订单不存在");
		}
		
	}
	
	@Override
	public String updateUserOrderToEnd(Integer hosploginid, Integer userorderid) {
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order != null) {
			
			Integer stateid = order.getUserorderstateid();
			if (stateid == 8) {
				Userorder userorder = new Userorder();
				userorder.setUserorderid(userorderid);
				//订单完成
				userorder.setUserorderstateid(9);
				userorder.setUserorderactualhospitalizationid(4);
				boolean result =  userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
				if (result) {
					return DataResult.success("操作成功");
				} else {
					return DataResult.error("操作失败");
				}
			} else {
				return DataResult.error("该订单状态不支持该操作");
			}

		} else {
			return DataResult.error("该订单不存在");
		}
		
	}
	//创建会诊
	@Override
	public String creatConsultation(Integer docloginid, Integer hosploginid, String orderabs, String orderstime,Double orderhospprice,
			Integer orderhosptpricetype, Double orderhosptprice, Integer orderhospapricetype, Double orderhospaprice,
			Integer orderhospepricetype, Double orderhospeprice) throws Exception {
		Doctorlogininfo doc = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doc == null) {
			return DataResult.error("创建会诊失败,因医生不存在");
		}
		Hosporder hosporder = new Hosporder();
		hosporder.setDoctorid(docloginid);
		hosporder.setOrderabs(orderabs);
		hosporder.setHospid(hosploginid);
		hosporder.setOrderptime(new Date());
		hosporder.setOrderstime(orderstime);
		//等待医生确认
		hosporder.setOrderstate(1);
		hosporder.setOrderhospprice(new BigDecimal(orderhospprice));
		hosporder.setOrderhosptpricetype(orderhosptpricetype);
		double total = orderhospprice;
		if (2==orderhosptpricetype) {
			hosporder.setOrderhosptprice(new BigDecimal(orderhosptprice));
			total += orderhosptprice;
		}
		hosporder.setOrderhospapricetype(orderhospapricetype);
		if (2==orderhospapricetype) {
			hosporder.setOrderhospaprice(new BigDecimal(orderhospaprice));
			total += orderhospaprice;
		}
		hosporder.setOrderhospepricetype(orderhosptpricetype);
		if (2==orderhospepricetype) {
			hosporder.setOrderhospeprice(new BigDecimal(orderhospeprice));
			total += orderhospeprice;
		}
		hosporder.setOrdertotalhospprice(new BigDecimal(total));
		int result = hosporderMapper.insertSelective(hosporder);
		if (result > 0) {
			JSONObject jsonCustormCont = new JSONObject();
			String push = commonService.createMsgHospitalToDoctor(hosploginid, docloginid, "通知", "发送会诊请求", jsonCustormCont);
			if ("1".equals(push)) {
				return DataResult.success("创建会诊成功，且消息发送成功");
			} else {
				return DataResult.success("创建会诊成功，但消息发送失败");
			}
		} else {
			return DataResult.error("创建会诊失败");
		}

	}
	//取消会诊
	@Override
	public String cancelConsultation(Integer hosploginid, Integer hosporderid) {
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("会诊不存在");
		}
		int orderState = hosporder.getOrderstate();
		if (orderState>3) {
			return DataResult.error("该会诊状态不支持取消");
		}
		Hosporder record = new Hosporder();
		record.setHosporderid(hosporderid);
		//7为医院取消订单
		record.setOrderstate(7);
		record.setOrderetime(new Date());
		boolean result = hosporderMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("取消会诊成功");
		}else {
			return DataResult.error("取消会诊失败");
		}
	}
	//会诊完成
	@Override
	public String finishConsultation(Integer hosploginid, Integer hosporderid) throws Exception {
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("会诊不存在");
		}
		int orderState = hosporder.getOrderstate();
		if (orderState!=4) {
			return DataResult.error("该会诊状态不支持该操作");
		}
		Hosporder record = new Hosporder();
		record.setHosporderid(hosporderid);
		//5为会诊完成
		record.setOrderstate(5);
		record.setOrderetime(new Date());
		boolean result = hosporderMapper.updateByPrimaryKeySelective(record)>0;
		if (result) {
			return DataResult.success("会诊完成成功");
		}else {
			return DataResult.error("会诊完成失败");
		}
	}

	

	
}
