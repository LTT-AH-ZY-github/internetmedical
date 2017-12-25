package com.medical.service.impl.hospital;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.alipay.api.domain.Data;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctortitleMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HospitalberthMapper;
import com.medical.mapper.HospitalberthMapperCustom;
import com.medical.mapper.HospitaldeptMapper;
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
import com.medical.po.Hospitalberth;
import com.medical.po.Hospitaldept;
import com.medical.po.Hosplogininfo;
import com.medical.po.Hosporder;
import com.medical.po.Pay;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.SenderNotificationService;
import com.medical.service.iface.hospital.HospitalOrderService;
import com.medical.utils.result.DataResult;
import com.pay.alipay.AliPayNotify;
import com.push.baidu.PushToUser;

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
	@Autowired
	private HospitalberthMapperCustom hospitalberthMapperCustom;
	@Autowired
	private HospitalberthMapper hospitalberthMapper;
	@Autowired 
	private SenderNotificationService senderNotificationService;

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
	public String listUserOrder(Integer hosploginid, Integer type, Integer limit, Integer offset) throws Exception{

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
	
	/* (非 Javadoc)  
	* <p>Title: getHospBerthNum</p>  
	* <p>Description: </p>  
	* @param hosploginid
	* @param userorderhospprimarydept
	* @param userorderhospseconddept
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.hospital.HospitalOrderService#getHospBerthNum(java.lang.Integer, java.lang.String, java.lang.String)  
	*/  
	@Override
	public String getHospBerthNum(Integer hosploginid, String userorderhospprimarydept, String userorderhospseconddept)
			throws Exception {
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		int hospberthdeptid = 0;
		List<Hospitaldept> primarydeptlist = hospitaldeptMapperCustom.selectByDeptNameAndFatherId(userorderhospprimarydept, "0");
		if (primarydeptlist==null || primarydeptlist.size()==0) {
			return DataResult.error("该一级部门不存在");
		}
		hospberthdeptid = primarydeptlist.get(0).getHospdeptid();
		if (StringUtils.isNotBlank(userorderhospseconddept)) {
			List<Hospitaldept> seconddeptlist = hospitaldeptMapperCustom.selectByDeptNameAndFatherId(userorderhospseconddept, hospberthdeptid+"");
			if (seconddeptlist==null || seconddeptlist.size()==0) {
				return DataResult.error("该二级部门不存在");
			}
			hospberthdeptid = seconddeptlist.get(0).getHospdeptid();
		}
		int conut = hospitalberthMapperCustom.selectCountByHospLoginIdAndHospDerthDeptId(hospberthdeptid, hosploginid);
		Map<String, Object> map = new HashMap<>();
		map.put("number", conut);
		return DataResult.success("获取成功", map);
	}
	
	public String deleteHospBerth(Integer hosploginid ,String userorderhospprimarydept, String userorderhospseconddept)
			throws Exception {
		Hosplogininfo hosplogininfo = hosplogininfoMapper.selectByPrimaryKey(hosploginid);
		if (hosplogininfo==null) {
			return DataResult.error("账号不存在");
		}
		int hospberthdeptid = 0;
		List<Hospitaldept> primarydeptlist = hospitaldeptMapperCustom.selectByDeptNameAndFatherId(userorderhospprimarydept, "0");
		if (primarydeptlist==null || primarydeptlist.size()==0) {
			return DataResult.error("该一级部门不存在");
		}
		hospberthdeptid = primarydeptlist.get(0).getHospdeptid();
		if (StringUtils.isNotBlank(userorderhospseconddept)) {
			List<Hospitaldept> seconddeptlist = hospitaldeptMapperCustom.selectByDeptNameAndFatherId(userorderhospseconddept, hospberthdeptid+"");
			if (seconddeptlist==null || seconddeptlist.size()==0) {
				return DataResult.error("该二级部门不存在");
			}
			hospberthdeptid = seconddeptlist.get(0).getHospdeptid();
		}
		List<Hospitalberth> list = hospitalberthMapperCustom.selectByHospLoginIdAndHospDerthDeptId(hospberthdeptid, hosploginid);
		if (list==null || list.size()==0) {
			return DataResult.error("床位为空");
		}
		Map<String, Object> map = new HashMap<>();
		boolean result = hospitalberthMapper.deleteByPrimaryKey(list.get(0).getHospberthid())>0;
		if (result) {
			return DataResult.success("删除成功");
		}else {
			return DataResult.error("删除成功");
		}
		
	}
	// 医院确认需要住院的病人订单
	@Override
	public String confirmUserOrder(Integer hosploginid, Integer userorderid, Double userorderdeposit,
			String userorderhospprimarydept, String userorderhospseconddept) throws Exception {
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("该订单不存在");
		}
		Integer stateid = order.getUserorderstateid();
		if (stateid != 5) {
			return DataResult.error("该订单状态不支持该操作");
		}
		String delresult= deleteHospBerth(hosploginid, userorderhospprimarydept, userorderhospseconddept);
		JSONObject jsonObject = JSONObject.fromObject(delresult);
		if ("200".equals(jsonObject.get("code"))) {
			return delresult;
		}
		Userorder userorder = new Userorder();
		userorder.setUserorderid(userorderid);
		userorder.setUserorderhospconfirmtime(new Date());
		userorder.setUserorderdeposit(new BigDecimal(userorderdeposit));
		userorder.setUserorderstateid(6);
		userorder.setUserorderhospprimarydept(userorderhospprimarydept);
	    userorder.setUserorderhospseconddept(userorderhospseconddept);
	    boolean result = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
	    if (result) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("order_id", userorderid);
			jsonCustormCont.put("type", "5");
			boolean push = senderNotificationService.createMsgHospitalToUser(hosploginid, order.getUserloginid(), "消息通知",
				"确认了您的订单", jsonCustormCont);
			if (push) {
					return DataResult.success("确认成功,且消息发送成功");
			} else {
					return DataResult.success("确认成功,但消息发送失败");
			}
         } else {
		      return DataResult.error("确认失败");
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
				userorder.setUserorderleavehosptime(new Date());
				//整个订单结束时间
				userorder.setUserorderfinishtime(new Date());
				// 3为需要住院，医院拒绝
				userorder.setUserorderactualhospitalizationid(3);
				boolean result = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
				Usersick usersick = new Usersick();
				usersick.setUsersickid(order.getUsersickid());
				usersick.setUsersickstateid(4);
				boolean sickResult = usersickMapper.updateByPrimaryKeySelective(usersick) > 0;
				if (result && sickResult) {
					JSONObject jsonCustormCont = new JSONObject();
					jsonCustormCont.put("order_id", userorderid);
					jsonCustormCont.put("type", "5");
					boolean push = senderNotificationService.createMsgHospitalToUser(hosploginid, order.getUserloginid(), "消息通知",
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
			jsonCustormCont.put("order_id", userorderid);
			jsonCustormCont.put("type", "5");
			boolean push = senderNotificationService.createMsgHospitalToUser(hosploginid, order.getUserloginid(), "消息通知", "要求增加押金",
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
			if (price.compareTo(userorderhprice)<0) {
				return DataResult.error("实际费用不可大于已缴纳的押金");
			}
			// 住院实际产生的费用
			userorder.setUserorderhprice(userorderhprice);
			//病人离开医院的时间
			userorder.setUserorderleavehosptime(new Date());
			if (price.compareTo(userorderhprice)==0) {
				// 9订单结束
				userorder.setUserorderstateid(9);
				//整个订单结束时间
				userorder.setUserorderfinishtime(new Date());
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
				jsonCustormCont.put("order_id", userorderid);
				jsonCustormCont.put("type", "5");
				boolean push = senderNotificationService.createMsgHospitalToUser(hosploginid, order.getUserloginid(),"消息通知", msg, jsonCustormCont);
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
	public String updateUserOrderToEnd(Integer hosploginid, Integer userorderid) throws Exception{
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


	
	

}
