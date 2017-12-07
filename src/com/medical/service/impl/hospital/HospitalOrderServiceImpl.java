package com.medical.service.impl.hospital;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
import com.medical.mapper.PayMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.po.Doctorlogininfo;
import com.medical.po.HospSearchDocTerm;
import com.medical.po.Hospinfo;
import com.medical.po.Hosporder;
import com.medical.po.Pay;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.push.PushToUser;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.hospital.HospitalOrderService;
import com.medical.utils.result.DataResult;
import com.pay.alipay.AliPayNotify;

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
	@Autowired
	private UsersickMapper usersickMapper;
	@Autowired
	private PayMapperCustom payMapperCustom;

/*	@Override
	public String listDoctor(Integer pageNo, Integer pageSize, HospSearchDocTerm hospSearchDocTerm) throws Exception {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = doctorinfoMapperCustom.paginationDoctorListInHosp(hospSearchDocTerm);
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
	}*/

	// 医院获取需要住院的病人订单
	@Override
	public String listUserOrder(Integer hosploginid, Integer type, Integer limit, Integer offset) {

		int pageNo = 1;
		if (offset != 0) {
			pageNo = offset / limit + 1;
		}
		PageHelper.startPage(pageNo, limit);
		List<Map<String, Object>> list = userorderMapperCustom.listByHospLoginIdAnType(hosploginid, type);
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

	// 医院确认需要住院的病人订单
	@Override
	public String confirmUserOrder(Integer hosploginid, Integer userorderid, Double userorderdeposit,
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
				boolean result = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
				if (result) {
					JSONObject jsonCustormCont = new JSONObject();
					boolean push = commonService.createMsgHospitalToUser(hosploginid, order.getUserloginid(), "消息通知",
							"确认了您的订单", jsonCustormCont);
					if (push) {
						return DataResult.success("确认成功,且消息发送成功");
					} else {
						return DataResult.success("确认成功,但消息发送失败");
					}

				} else {
					return DataResult.error("确认失败");
				}

			} else {
				return DataResult.error("该订单状态不支持该操作");

			}

		} else {
			return DataResult.error("该订单不存在");

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
				// 3为需要住院，医院拒绝
				userorder.setUserorderactualhospitalizationid(3);
				boolean result = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
				Usersick usersick = new Usersick();
				usersick.setUsersickid(order.getUsersickid());
				usersick.setUsersickstateid(4);
				boolean sickResult = usersickMapper.updateByPrimaryKeySelective(usersick) > 0;
				if (result && sickResult) {
					JSONObject jsonCustormCont = new JSONObject();
					boolean push = commonService.createMsgHospitalToUser(hosploginid, order.getUserloginid(), "消息通知",
							"拒绝了您的请求", jsonCustormCont);
					if (push) {
						return DataResult.success("操作成功,且消息发送成功");
					} else {
						return DataResult.success("操作成功,但消息发送失败");
					}
				} else {
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
	public String updateUserOrderDeposit(Integer hosploginid, Integer userorderid, BigDecimal userorderdeposit)
			throws Exception {
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("该订单不存在");
		}
		Integer stateid = order.getUserorderstateid();
		if (stateid != 7) {
			return DataResult.error("该订单状态不支持该操作");
		}
		Userorder userorder = new Userorder();
		userorder.setUserorderid(userorderid);
		userorder.setUserorderdeposit(userorderdeposit);
		userorder.setUserorderstateid(6);
		boolean result = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
		if (result) {
			JSONObject jsonCustormCont = new JSONObject();
			boolean push = commonService.createMsgHospitalToUser(hosploginid, order.getUserloginid(), "消息通知", "要求增加押金",
					jsonCustormCont);
			if (push) {
				return DataResult.success("操作成功,且消息发送成功");
			} else {
				return DataResult.success("操作成功,但消息发送失败");
			}
		} else {
			return DataResult.success("操作失败");
		}

	}

	// 结算订单
	@Override
	public String updateUserOrderToSettle(Integer hosploginid, Integer userorderid, BigDecimal userorderhprice) throws Exception {
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("该订单不存在");
		}
		Integer stateid = order.getUserorderstateid();
		if (stateid == 7) {
			BigDecimal price = order.getUserordertotaldeposit();
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			// 住院实际产生的费用
			userorder.setUserorderhprice(userorderhprice);
			if (price.compareTo(userorderhprice)==0) {
				// 9订单结束
				userorder.setUserorderstateid(9);
				Usersick usersick = new Usersick();
				usersick.setUsersickid(order.getUsersickid());
				usersick.setUsersickstateid(4);
				boolean sickResult = usersickMapper.updateByPrimaryKeySelective(usersick) > 0;
				if (!sickResult) {
					return DataResult.error("操作失败");
				}
			}else {
				// 8住院完成，等待结算费用
				userorder.setUserorderstateid(8);
			}
			boolean result = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
			if (result) {
				String msg = null;
				if (price.compareTo(userorderhprice)==0) {
					msg="订单已完成，等待评价";
				}else {
					// 8住院完成，等待结算费用
					msg="住院完成，等待结算费用";
					
				}
				JSONObject jsonCustormCont = new JSONObject();
				boolean push = commonService.createMsgHospitalToUser(hosploginid, order.getUserloginid(),"消息通知", msg, jsonCustormCont);
				if (push) {
					return DataResult.success("操作成功,且消息发送成功");
				} else {
					return DataResult.success("操作成功,但消息发送失败");
				}
				
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("操作失败");
			}
		} else {
			return DataResult.error("该订单状态不支持该操作");
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
				// 订单完成
				userorder.setUserorderstateid(9);
				userorder.setUserorderactualhospitalizationid(4);
				boolean result = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
				Usersick usersick = new Usersick();
				usersick.setUsersickid(order.getUsersickid());
				usersick.setUsersickstateid(4);
				boolean sickResult = usersickMapper.updateByPrimaryKeySelective(usersick) > 0;
				if (result && sickResult) {
					return DataResult.success("操作成功");
				} else {
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return DataResult.error("操作失败");
				}
			} else {
				return DataResult.error("该订单状态不支持该操作");
			}

		} else {
			return DataResult.error("该订单不存在");
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
		hosporder.setOrderstime(orderstime);
		// 等待医生确认
		hosporder.setOrderstate(1);
		// 医生出诊价格
		hosporder.setOrderhospprice(orderhospprice);
		// 交通类型
		hosporder.setOrderhosptpricetype(orderhosptpricetype);
		BigDecimal total = orderhospprice;
		if (orderhosptprice != null) {
			hosporder.setOrderhosptprice(orderhosptprice);
		}
		if (2 == orderhosptpricetype) {
			total = total.add(orderhosptprice);
		}
		// 住宿类型
		hosporder.setOrderhospapricetype(orderhospapricetype);
		if (orderhospaprice != null) {
			hosporder.setOrderhospaprice(orderhospaprice);
		}
		if (2 == orderhospapricetype) {
			total = total.add(orderhospaprice);
		}
		// 餐饮类型
		hosporder.setOrderhospepricetype(orderhosptpricetype);
		if (orderhospeprice != null) {
			hosporder.setOrderhospeprice(orderhospeprice);
		}
		if (2 == orderhospepricetype) {
			total = total.add(orderhospeprice);
		}
		hosporder.setOrdertotalhospprice(total);
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
		// 7为医院取消订单
		record.setOrderstate(7);
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
	public String payDoctor(Integer hosploginid, Integer hosporderid) throws Exception {
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("会诊不存在");
		}
		int orderState = hosporder.getOrderstate();
		if (orderState != 3) {
			return DataResult.error("该会诊状态不支持付款");
		}
		return null;
	}

	/**
	 * 支付医生会诊费用完成
	 */
	@Override
	public String payDoctorFinish(Map<String, String[]> requestParams) throws Exception {
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
		return null;
	}

	// 会诊完成
	@Override
	public String finishConsultation(Integer hosploginid, Integer hosporderid) throws Exception {
		Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
		if (hosporder == null) {
			return DataResult.error("会诊不存在");
		}
		int orderState = hosporder.getOrderstate();
		if (orderState != 4) {
			return DataResult.error("该会诊状态不支持该操作");
		}
		Hosporder record = new Hosporder();
		record.setHosporderid(hosporderid);
		// 5为会诊完成
		record.setOrderstate(5);
		record.setOrderetime(new Date());
		boolean result = hosporderMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			return DataResult.success("会诊完成成功");
		} else {
			return DataResult.error("会诊完成失败");
		}
	}

}
