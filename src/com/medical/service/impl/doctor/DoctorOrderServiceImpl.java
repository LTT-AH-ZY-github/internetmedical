package com.medical.service.impl.doctor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;

import com.baidu.yun.push.utils.PushToAndroid;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctoraddressMapper;
import com.medical.mapper.DoctoraddressMapperCustom;
import com.medical.mapper.DoctorcalendarMapper;
import com.medical.mapper.DoctorcalendarMapperCustom;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogMapper;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.DoctorskdMapper;
import com.medical.mapper.DoctorskdMapperCustom;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.mapper.HosporderMapper;
import com.medical.mapper.HosporderMapperCustom;
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Hosporder;
import com.medical.po.Preorder;
import com.medical.po.Userlogininfo;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.doctor.DoctorAccountService;
import com.medical.service.iface.doctor.DoctorOrderService;
import com.medical.service.iface.hospital.HospitalOrderService;
import com.medical.utils.result.DataResult;
import com.medical.utils.result.DataResult2;
import com.sun.org.apache.regexp.internal.recompile;

import net.sf.json.JSONObject;

public class DoctorOrderServiceImpl implements DoctorOrderService {
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private DoctorlogininfoMapperCustom doctorlogininfoMapperCustom;
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private DoctorlogMapper doctorlogMapper;
	@Autowired
	private DoctorskdMapper doctorskdMapper;
	@Autowired
	private DoctorskdMapperCustom doctorskdMapperCustom;
	@Autowired
	private PreorderMapper preorderMapper;
	@Autowired
	private UserorderMapper userorderMapper;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;

	@Autowired
	private UserlogininfoMapperCustom userlogininfoMapperCustom;

	@Autowired
	private UsersickMapper usersickMapper;
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	@Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private UserorderMapperCustom userorderMapperCustom;

	@Autowired
	private HospitaldeptMapperCustom hospitaldeptMapperCustom;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DoctoraddressMapper doctoraddressMapper;
	@Autowired
	private DoctoraddressMapperCustom doctoraddressMapperCustom;
	@Autowired
	private DoctorcalendarMapper doctorcalendarMapper;
	@Autowired
	private DoctorcalendarMapperCustom doctorcalendarMapperCustom;
	@Autowired
	private DoctorAccountService doctorAccountService;
	@Autowired
	private HosporderMapper hosporderMapper;
	@Autowired
	private HosporderMapperCustom hosporderMapperCustom;

	// 医生抢单
	@Override
	public String creatPreOrder(int usersickid, int docloginid, Double preorderprice) throws Exception {
		Preorder preorder = new Preorder();
		preorder.setPreorderdocloginid(docloginid);
		preorder.setPreorderstate(1);
		if (preorderprice != null) {
			preorder.setPreorderprice(new BigDecimal(preorderprice));
		}
		preorder.setUsersickid(usersickid);
		// 医生抢单
		preorder.setPreordertype(2); 
		//申请时间
		preorder.setPreordertime(new Date());
		// 查询病情信息
		Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
		if (usersick == null) {
			return DataResult.error("病情不存在");
		}
		// 病人登录id
		preorder.setPreorderuserloginid(usersick.getUserloginid());
		List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid, 2);
		if (list.size() >0 ) {
			return DataResult.error("该订单已申请");
		}
		// 插入预订单
		boolean result = preorderMapper.insertSelective(preorder)>0;
		if (result) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("doc_id", docloginid);
			jsonCustormCont.put("sick_id", usersickid);
			jsonCustormCont.put("type", "1");
			String push = commonService.createMsgDoctorToUser(docloginid, usersick.getUserloginid(), "等待确认", "申请了您的病情", jsonCustormCont);
			if ("1".equals(push)) {
				return DataResult.success("申请成功，且消息发送成功");
			} else {
				return DataResult.success("申请成功，但消息发送失败");
			}
		} else {
			return DataResult.error("申请失败");
		}
	}
	
	// 获取已抢订单
	@Override
	public String listGrabOrders(Integer docloginid, Integer pageNo, Integer pageSize) throws Exception{
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = preorderMapperCustom.listByDocLoginId(docloginid);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		if (page!=null && page.getTotal() > 0) {
			
			return DataResult.success("获取数据成功", page.getList());
		} else {
			return DataResult.error("获取数据为空");
		}
	}

	/*// 获取已抢订单详情
	@Override
	public Map<String, Object> getGrabOrderDetail(Integer preOrderId) {
		
		Map<String, Object> map =  preorderMapperCustom.selectAllInfoByPreOrderIdInDoc(preOrderId);
	}*/
		
	// 医生取消抢单
	@Override
	public String deletePreOrder(Integer docloginid, Integer preorderid) throws Exception {
		Preorder preorder = preorderMapper.selectByPrimaryKey(preorderid);
		if (preorder == null) {
			return DataResult.error("无申请记录");
		}
		Integer docLoginId = preorder.getPreorderdocloginid();
		Integer userloginid = preorder.getPreorderuserloginid();
		Integer userSickId = preorder.getUsersickid();
		if (docloginid != docLoginId) {
			return DataResult.error("该申请记录与医生不匹配");
		}
		int result = preorderMapper.deleteByPrimaryKey(preorderid);
		if (result > 0) {
			return DataResult.success("取消申请成功");
			/*String push = commonService.createMsgDoctorToUser(docloginid, userloginid, "等待确认", "申请了您的病情");
			if ("1".equals(push)) {
				return DataResult.success("取消申请成功，且消息发送成功");
			} else {
				return DataResult.success("取消申请成功，但消息发送失败");
			}*/
		} else {
			return DataResult.error("取消申请失败");
			
		}
	}
	
	// 获取选择我的订单
	@Override
	public String listOrderToConfirm(Integer docloginid, Integer pageNo, Integer pageSize) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = userorderMapperCustom.listOrderToConfirmByDocLoginId(docloginid);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		if (page != null && page.getTotal() > 0) {
			// 获取数据成功
			return DataResult.success("获取数据成功", page.getList());

		} else {
			return DataResult.success("获取数据为空", null);
		}

	}
	
	// 获取订单
	@Override
	public String listOrder(Integer docLoginId, Integer type, Integer pageNo, Integer pageSize)
			throws Exception {
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> list = userorderMapperCustom.listByDocLoginIdAndState(docLoginId, type);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		if (page!=null && page.getTotal() > 0) {
			return DataResult.success("获取数据成功", page.getList());
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}

	// 获取订单详情
	@Override
	public String getOrderDetail(Integer docLoginId, Integer userOrderId) {
		Map<String, Object> data = userorderMapperCustom.selectAllInfoByUserOrderId(docLoginId, userOrderId);
		if (data!=null && !data.isEmpty()) {
			return DataResult.success("获取数据成功", data);
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}
	
	
	
	

	@Override
	public Map<String, Object> getDoctorByName(String docname) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, Object>> list = doctorinfoMapperCustom.selectByName(docname);
		if (list.size() > 0) {
			map.put("state", "1");
			map.put("data", list);
		} else {
			map.put("state", "2");
		}

		return map;
	}
		
		//医生拒绝接单并推荐其他
		@Override
		public Map<String, Object> updateOrderToRefuse(Integer docloginid, Integer userorderid, Integer redocloginid) throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();
			
				Userorder userorder = userorderMapper.selectByPrimaryKey(userorderid);
				if (userorder!=null) {
					Integer doc = userorder.getUserorderdocloginid();
					if (docloginid==doc) {
						Integer userorderstateid = userorder.getUserorderstateid();
						Integer usersickid = userorder.getUsersickid();
						if (userorderstateid==1) {
							//订单信息
							Userorder record = new Userorder();
							record.setUserorderid(userorderid);
							if (redocloginid==null) {
								record.setUserorderstateid(13);
							} else {
								record.setUserorderstateid(14);
								Preorder preorder = new Preorder();
								preorder.setUsersickid(usersickid);
								preorder.setPreorderuserloginid(userorder.getUserloginid());
								//医生推荐
								preorder.setPreordertype(3);
								preorder.setPreorderredocloginid(docloginid);
								Userlogininfo userlogininfo = userlogininfoMapper.selectByPrimaryKey(redocloginid);
								if (userlogininfo!=null) {
									preorder.setPreorderdocloginid(redocloginid);
									preorder.setPreordertime(new Date());
									List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(redocloginid, usersickid, 3);
									if (list.size()==0) {
										int preResult = preorderMapper.insertSelective(preorder);
										if (preResult==0) {
											//插入推荐医生失败
											map.put("state", "8");
											return map;
										}
									} else {
										//该医生已被推荐
										map.put("state", "9");
										return map;
									}
								} else {
									//推荐医生不存在
									map.put("state", "10");
									return map;
								}
								
							}
							record.setUserorderetime(new Date());
							Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
							if (usersick!=null) {
								//病情信息
								Usersick sick = new Usersick();
								sick.setUsersickid(usersickid);
								sick.setUsersickstateid(2);
								int orderResult = userorderMapper.updateByPrimaryKeySelective(record);
								int sickResult = usersickMapper.updateByPrimaryKeySelective(sick);
								if (orderResult>0 && sickResult>0 ) {
									JSONObject jsonCustormCont = new JSONObject();
									String msg = null;
									if (redocloginid!=null) {
										
										String name = doctorinfoMapperCustom.selectByDocLoginId(redocloginid).getDocname();
										msg = "拒绝了您的订单并推荐了"+name+"医生";
										jsonCustormCont.put("redoc_id", redocloginid);
									} else {
										msg = "拒绝了您的订单";
									}
									jsonCustormCont.put("accept", false);
									jsonCustormCont.put("doc_id", docloginid);
									jsonCustormCont.put("sick_id", usersickid);
									jsonCustormCont.put("order_id", userorderid);
									jsonCustormCont.put("type", "3");
									String push = commonService.createMsgDoctorToUser(docloginid, userorder.getUserloginid(), "通知消息", msg,jsonCustormCont);
									
									if ("1".equals(push)) {
										map.put("state", "1");
									} else {
										map.put("state", "2");
									}
									
								} else {
									//取消失败，未知错误
									TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
									map.put("state", "3");
								}
								
							} else {
								//病情不存在，取消失败
								map.put("state", "4");
							}
						} else {
							//该状态不支持取消
							map.put("state", "5");
						}
						
					} else {
						//医生与订单不匹配
						map.put("state", "6");
					}
					
				} else {
					//订单不存在
					map.put("state", "7");
				}
			
			
			return map;
		}
		
	// 医生确认
	@Override
	public String updateOrderConfirm(Userorder userorder) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer userorderid = userorder.getUserorderid();
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		// 订单存在
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		// 订单状态
		int stateid = order.getUserorderstateid();
		// 等待医生确认状态
		if (stateid != 1) {
			return DataResult.error("该订单状态不支持确认");
		}
		Userorder record = new Userorder();
		record.setUserorderid(userorder.getUserorderid());
		BigDecimal total = userorder.getUserorderdprice();
		//医生价格
		userorder.setUserorderdprice(userorder.getUserorderdprice());
		System.out.println("交通类型"+userorder.getUserorderapricetype());
		//住宿类型
		int apricetype = userorder.getUserorderapricetype();
		record.setUserorderapricetype(userorder.getUserorderapricetype());
		BigDecimal aprice = userorder.getUserorderaprice();
		// 住宿价格
		if (aprice!= null) {
			record.setUserorderaprice(aprice);
		}
		if (apricetype == 3) {
			total=total.add(aprice);
		}
		
		//交通类型
		int tpricetype = userorder.getUserordertpricetype();
		record.setUserordertpricetype(tpricetype);
		// 交通价格
		BigDecimal tprice = userorder.getUserordertprice();
		if (tprice!=null) {
			record.setUserordertprice(userorder.getUserordertprice());
		}
		if (tpricetype == 3) {
			total=total.add(tprice);
		}
		
		// 餐饮类型
		int epricetype = userorder.getUserorderepricetype();
		record.setUserorderepricetype(epricetype);
		// 餐饮价格
		BigDecimal eprice = userorder.getUserordereprice();
		record.setUserordereprice(eprice);
		if (epricetype == 3) {
			total=total.add(eprice);
		}
		
		record.setUserorderprice(total);
		record.setUserorderstateid(2);
		// 接单时间
		record.setUserorderrtime(new Date());
		int state = userorderMapper.updateByPrimaryKeySelective(record);
		// 确认成功
		if (state > 0) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("accept", true);
			jsonCustormCont.put("doc_id", order.getUserloginid());
			jsonCustormCont.put("sick_id", order.getUsersickid());
			jsonCustormCont.put("order_id", userorderid);
			jsonCustormCont.put("type", "3");
		String result =commonService.createMsgDoctorToUser(order.getUserorderdocloginid(), order.getUserloginid(), "等待确认", "接受了您的订单",jsonCustormCont);
			if ("1".equals(result)) {
				return DataResult.success("确认成功,且消息发送成功");
			} else {
				return DataResult.success("确认成功,但消息发送失败");
			}	
		}else {
			return DataResult.error("确认失败");
		}
	}
	//待修改
		//医生取消订单
		@Override
		public Map<String, Object> updateOrderToCancle(Integer docLoginId, Integer userorderid) throws Exception{
			Map<String, Object> map = new HashMap<String, Object>();
			
				Userorder userorder = userorderMapper.selectByPrimaryKey(userorderid);
				if (userorder!=null) {
					Integer doc = userorder.getUserorderdocloginid();
					if (docLoginId==doc) {
						Integer userorderstateid = userorder.getUserorderstateid();
						Integer usersickid = userorder.getUsersickid();
						if (userorderstateid<4) {
							//订单信息
							Userorder record = new Userorder();
							record.setUserorderid(userorderid);
							record.setUserorderstateid(15);
							record.setUserorderetime(new Date());
							Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
							if (usersick!=null) {
								//病情信息
								Usersick sick = new Usersick();
								sick.setUsersickid(usersickid);
								sick.setUsersickstateid(2);
								int orderResult = userorderMapper.updateByPrimaryKeySelective(record);
								int sickResult = usersickMapper.updateByPrimaryKeySelective(sick);
								if (orderResult>0 && sickResult>0) {
									JSONObject jsonCustormCont = new JSONObject();
									
									String push = commonService.createMsgDoctorToUser(docLoginId, userorder.getUserloginid(), "通知消息", "取消了您订单",jsonCustormCont);
									if ("1".equals(push)) {
										map.put("state", "1");
									} else {
										map.put("state", "2");
									}
									
								} else {
									//取消失败，未知错误
									TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
									map.put("state", "3");
								}
								
							} else {
								//病情不存在，取消失败
								map.put("state", "4");
							}
						} else {
							//该状态不支持取消
							map.put("state", "5");
						}
						
					} else {
						//医生与订单不匹配
						map.put("state", "6");
					}
					
				} else {
					//订单不存在
					map.put("state", "7");
				}
			
			
			return map;
		}
		@Override
		public Map<String, Object> finishOrder(Integer docloginid, Integer userorderid, Boolean userorderhstate,
				Integer userorderhospid) throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();
			
				Userorder order = userorderMapperCustom.selectByDocLoginIdAndUserOrderId(docloginid,userorderid);
				Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
				if (order!=null) {
					Integer userOrderStateId = order.getUserorderstateid();
					//预付款完成,等待医生就诊状态
					if (userOrderStateId==4) {
						if (userorderhstate) {
							Userorder userorder = new Userorder();
							userorder.setUserorderid(userorderid);
							//需要住院，等待医院确认
							userorder.setUserorderstateid(5);
							userorder.setUserorderhospid(userorderhospid);
							userorder.setUserorderchosehosptime(new Date());
							//住院部门默认为医生所在部门
							userorder.setUserorderhospprimarydept(doctorinfo.getDocprimarydept());
							userorder.setUserorderhospseconddept(doctorinfo.getDocseconddept());
							int result = userorderMapper.updateByPrimaryKeySelective(userorder);
							if (result>0) {
								JSONObject jsonCustormCont = new JSONObject();
								jsonCustormCont.put("doc_id", order.getUserloginid());
								jsonCustormCont.put("order_id", userorderid);
								jsonCustormCont.put("type", "5");
								String push = commonService.createMsgDoctorToUser(docloginid, order.getUserloginid(), "通知消息", "就诊已完成,需要住院",jsonCustormCont);
								if ("1".equals(push)) {
									map.put("state", "1");
								} else {
									map.put("state", "2");
								}
							} else {
								//操作失败
								map.put("state", "3");
							}
						} else {
							Userorder userorder = new Userorder();
							userorder.setUserorderid(userorderid);
							userorder.setUserorderetime(new Date());
							userorder.setUserorderstateid(9);
							userorder.setUserorderactualhospitalizationid(1);
							int result = userorderMapper.updateByPrimaryKeySelective(userorder);
							Usersick usersick = new Usersick();
							usersick.setUsersickid(order.getUsersickid());
							//该病情已结束
							usersick.setUsersickstateid(4);
							int sickResult = usersickMapper.updateByPrimaryKeySelective(usersick);
							if (result>0 && sickResult>0) {
								JSONObject jsonCustormCont = new JSONObject();
								jsonCustormCont.put("doc_id", order.getUserloginid());
								jsonCustormCont.put("order_id", userorderid);
								jsonCustormCont.put("type", "5");
								String push = commonService.createMsgDoctorToUser(docloginid, order.getUserloginid(), "通知消息", "就诊已完成,等待评价该医生",jsonCustormCont);
								if ("1".equals(push)) {
									map.put("state", "4");
								} else {
									map.put("state", "5");
								}
							} else {
								//操作失败
								map.put("state", "6");
							}
						}
					} else {
						//该状态不支持该操作
						map.put("state", "7");
					}
					
				} else {
					//订单id跟医生id不匹配
					map.put("state", "8");
				}		
			
			return map;
		}
		//获取历史订单
		@Override
		public String listHistoryOrder(Integer docloginid, Integer page) {
			PageHelper.startPage(page, 5);
			List<Map<String, Object>> list = userorderMapperCustom.listHistortOrderByDocLoginId(docloginid);
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
			if (pageInfo!=null && pageInfo.getTotal() > 0) {
				return DataResult.success("获取数据成功", pageInfo.getList());
			} else {
				return DataResult.success("获取数据为空", null);
			}
			
		}
		
		//获取会诊
		@Override
		public String listConsultation(Integer docloginid, Integer type, Integer page) {
			PageHelper.startPage(page, 5);
			List<Map<String, Object>> list = hosporderMapperCustom.listByDocLoginIdAndType(docloginid,type);
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
			if (pageInfo!=null && pageInfo.getTotal() > 0) {
				return DataResult.success("获取数据成功", pageInfo.getList());
			} else {
				return DataResult.success("获取数据为空", null);
			}
			
		}
		
		//获取会诊详情
		@Override
		public String listConsultationDetail(Integer docloginid, Integer hosporderid) throws Exception{
			Map<String, Object> data = hosporderMapperCustom.selectAllInfoByDocLoginIdAndHospOrderId(docloginid,hosporderid);
			if (data != null && !data.isEmpty()) {
				return DataResult.success("获取成功", data);
			}else {
				return DataResult.success("数据为空", null);
			}
		}
		
		//确认会诊
		@Override
		public String updateConsultationToConfirm(Integer docloginid, Integer hosporderid, BigDecimal orderdoctorprice,
				Integer orderdoctortpricetype, BigDecimal orderdoctortprice, Integer orderdoctorapricetype,
				BigDecimal orderdoctoraprice, Integer orderdoctorepricetype, BigDecimal orderdoctoreprice)
		{
			Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
			if (hosporder == null) {
				return DataResult.error("订单不存在");
			}
			int doctor = hosporder.getDoctorid();
			if (!docloginid.equals(doctor)) {
				return DataResult.error("该订单不属于该医生");
			}
			int state = hosporder.getOrderstate();
			if (state!=1) {
				DataResult.error("该状态不支持确认");
			}
			Hosporder record = new Hosporder();
			record.setHosporderid(hosporderid);
			//2为医生确认订单
			record.setOrderstate(2);
			//医生接单时间
			record.setOrderrtime(new Date());
			record.setOrderdoctorprice(orderdoctorprice);
			BigDecimal total = orderdoctorprice;
			record.setOrderdoctortpricetype(orderdoctortpricetype);
			if (2==orderdoctortpricetype) {
				
				record.setOrderdoctortprice(orderdoctortprice);
				total = total.add(orderdoctortprice);
			}
			record.setOrderdoctorapricetype(orderdoctorapricetype);
			if (2==orderdoctorapricetype) {
				
				record.setOrderdoctoraprice(orderdoctoraprice);
				total = total.add(orderdoctoraprice);
			}
			record.setOrderdoctorepricetype(orderdoctorepricetype);
			if (2==orderdoctorepricetype) {
				
				record.setOrderdoctoreprice(orderdoctoreprice);
				total = total.add(orderdoctoreprice);
			}
			record.setOrdertotaldoctorprice(total);
			boolean result = hosporderMapper.updateByPrimaryKeySelective(record)>0;
			if (result) {
				return DataResult.success("确认成功");
			} else {
				return DataResult.error("确认失败");
			}
		}

		@Override
		public String updateConsultationToCancel(Integer docloginid, Integer hosporderid) {
			Hosporder hosporder = hosporderMapper.selectByPrimaryKey(hosporderid);
			if (hosporder == null) {
				return DataResult.error("订单不存在");
			}
			int doctor = hosporder.getDoctorid();
			if (!docloginid.equals(doctor)) {
				return DataResult.error("该订单不属于该医生");
			}
			int state = hosporder.getOrderstate();
			switch(state){ 
	
				case 4: return DataResult.error("医院已付款，不可取消"); 
			
				case 5: return DataResult.error("该状态不支持取消");
				
				case 6: return DataResult.error("医院已取消订单");
				
				case 7: return DataResult.error("该订单已取消");
			} 
			Hosporder record = new Hosporder();
			record.setHosporderid(hosporderid);
			//5为医生取消订单
			record.setOrderstate(7);
			//订单结束时间
			record.setOrderetime(new Date());
			boolean result = hosporderMapper.updateByPrimaryKeySelective(record)>0;
			if (result) {
				return DataResult.success("取消成功");
			} else {
				return DataResult.error("取消失败");
			}
		}
		//更改病情部门
		@Override
		public String changeDept(Integer docloginid, Integer usersickid, String usersickprimarydept,
				String usersickseconddept) throws Exception {
			Doctorlogininfo doctorlogininfo =  doctorlogininfoMapper.selectByPrimaryKey(docloginid);
			if (doctorlogininfo == null) {
				return DataResult.error("该医生不存在");
			}
			Usersick  usersick = usersickMapper.selectByPrimaryKey(usersickid);
			if (usersick==null) {
				return DataResult.error("病情不存在");
			}
			int userSickStateId = usersick.getUsersickstateid();
			if (usersick!=null && userSickStateId!=2) {
				return DataResult.error("病情状态不允许修改部门");
			}
			Usersick record = new Usersick();
			record.setUsersickid(usersickid);
			record.setUsersickprimarydept(usersickprimarydept);
			record.setUsersickseconddept(usersickseconddept);
			int sickResult = usersickMapperCustom.updateDeptByPrimaryKey(record);
			//1为系统推荐医生
			preorderMapperCustom.deleteByUserSickIdAndPreOrderType(usersickid, 1);
			if (sickResult>0) {
				Map<String, Object> resultMap = commonService.listRecommendDoctors(usersick.getUsersickpic(), usersick.getUsersickprimarydept(), usersick.getUsersickseconddept());
				boolean flag = false;
				if ("1".equals(resultMap.get("state"))) {
					@SuppressWarnings("unchecked")
					List<Doctorinfo> list = (List<Doctorinfo>) resultMap.get("data");
					for (Doctorinfo doctorinfo : list) {
						Preorder preorder = new Preorder();
						preorder.setPreorderdocloginid(doctorinfo.getDocloginid());
						preorder.setUsersickid(usersickid);
						preorder.setPreordertype(1);
						preorder.setPreordertime(new Date());
						int preResult = preorderMapper.insertSelective(preorder);
						if (preResult<=0) {
							flag =true;
							break;
						} 
					}
					if (flag) {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return DataResult.error("更改失败");
					}
					return DataResult.success("更改成功");
				}else {
					
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return DataResult.error("更改失败");
				}
			}else {
				return DataResult.error("更改失败");	
			}
		}

		

		
}
