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
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Preorder;
import com.medical.po.Userlogininfo;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.doctor.DoctorAccountService;
import com.medical.service.iface.doctor.DoctorOrderService;

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

	// 医生抢单
	@Override
	public Map<String, Object> creatPreOrder(int usersickid, int docloginid, Double preorderprice) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		Preorder preorder = new Preorder();
		preorder.setPreorderdocloginid(docloginid);
		preorder.setPreorderstate(1);
		if (preorderprice != null) {
			preorder.setPreorderprice(new BigDecimal(preorderprice));
		}
		preorder.setUsersickid(usersickid);
		preorder.setPreordertype(2); // 医生抢单
		preorder.setPreordertime(new Date());
		// 查询病情信息
		Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
		if (usersick != null) {
			// 病人登录id
			preorder.setPreorderuserloginid(usersick.getUserloginid());
			List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid, 2);
			if (list.size() == 0) {
				// 插入预订单
				int result = preorderMapper.insertSelective(preorder);
				// 数据插入成功
				if (result > 0) {
					Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(usersick.getUserloginid());
					Doctorinfo doctor = doctorinfoMapperCustom.findDoctorinfoByDocLoginId(docloginid);
					if (user != null && doctor != null) {
						String[] tags = { user.getUserloginphone(), "sick" };
						String title = "通知";
						String msg = doctor.getDocname() + "医生已抢单";
						String sign = "1"; // 医生抢单
						// 消息推送
						Map<String, Object> pushMap = PushToAndroid.PushMsgToSmartTag(tags, title, msg, sign);
						if ("1".equals(pushMap.get("state"))) {
							map.put("state", "1");// 操作成功,且消息发送成功
						} else {
							// 操作成功，但消息推送失败
							map.put("state", "2");
							map.put("msg", pushMap.get("msg"));
						}

					} else {
						map.put("state", "3"); // 操作成功，消息推送获取用户信息获取数据失败，
					}

				} else {
					map.put("state", "4"); // 抢单失败
				}

			} else {
				map.put("state", "5");// 已抢单
			}

		} else {
			map.put("state", "6");// 查询病情失败
		}

		return map;
	}
	
	//获取已抢订单
		@Override
		public Map<String, Object> listGrabOrders(Integer docloginid,Integer pageNo,Integer pageSize) {
			Map<String, Object> map = new HashMap<String, Object>();
			
				PageHelper.startPage(pageNo, pageSize);
				List<Map<String, Object>> list = preorderMapperCustom.listByDocLoginId(docloginid);
				PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
				if (page.getTotal()>0) {
					// 获取数据成功
					map.put("state", "1");
					map.put("data", page.getList());
				} else {
					map.put("state", "2");
				}
			
			
			return map;
		}
		
		//获取已抢订单详情
		@Override
		public Map<String, Object> getGrabOrderDetail(Integer preOrderId) {
			Map<String, Object> map = new HashMap<String, Object>();
		
				Map<String, Object> result = preorderMapperCustom.selectAllInfoByPreOrderIdInDoc(preOrderId);
				if (!result.isEmpty()) {
					map.put("state", "1");// 获取成功
					map.put("data", result);
				} else {
					map.put("state", "2");
				}
			
			return map;
		}
		
		//医生取消抢单
		@Override
		public Map<String, Object> deletePreOrder(Integer docloginid ,Integer preorderid) throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();
			
				Preorder preorder = preorderMapper.selectByPrimaryKey(preorderid);
				if (preorder != null) {
					Integer docLoginId = preorder.getPreorderdocloginid();
					Integer userLoginId = preorder.getPreorderuserloginid();
					Integer userSickId = preorder.getUsersickid();
					if (docloginid== docLoginId) {
						int result = preorderMapper.deleteByPrimaryKey(preorderid);
						if (result > 0) {
							Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(userLoginId);
							Doctorinfo doctor = doctorinfoMapperCustom.findDoctorinfoByDocLoginId(docLoginId);
							if (user != null && doctor != null) {
								String[] tags = { user.getUserloginphone(), "sick" };
								String title = "通知";
								String msg = doctor.getDocname() + "医生已取消抢单";
								String sign = "1"; // 医生抢单
								// 消息推送
								Map<String, Object> pushMap = PushToAndroid.PushMsgToSmartTag(tags, title, msg, sign);
								if ("1".equals(pushMap.get("state"))) {
									map.put("state", "1"); // 操作成功,且消息发送成功
								} else {
									map.put("state", "2");
									map.put("msg", pushMap.get("msg"));// 操作成功，但消息推送失败
								}
								
							} else {
								map.put("state", "3"); // 操作成功，但消息推送失败因获取数据失败
							}
						} else {
							map.put("state", "4");// 取消抢单失败
						}
					} else {
						//预定单与医生信息不符
						map.put("state", "5");
					}
				} else {
					// 预订单id对应数据为空
					map.put("state", "6");
				}

			
			return map;
		}
		
		// 获取订单
		@Override
		public Map<String, Object> listOrder(Integer docLoginId, Integer type,Integer pageNo,Integer pageSize) throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();
			
				PageHelper.startPage(pageNo, pageSize);
				List<Map<String, Object>> list = userorderMapperCustom.listByDocLoginId(docLoginId,type);
				PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
				if (page.getTotal()>0) {
					// 获取数据成功
					
					map.put("state", "1");
					map.put("data", page.getList());
				} else {
					map.put("state", "2");
				}
		
			return map;
		}
		// 获取订单详情
		@Override
		public Map<String, Object> getOrderDetail(Integer docLoginId,Integer userOrderId) {
			Map<String, Object> map = new HashMap<String, Object>();
		
				Map<String, Object> data = userorderMapperCustom.selectAllInfoByUserOrderIdInDoc(docLoginId,userOrderId);
				if (!data.isEmpty()) {
					map.put("state", "1");
					map.put("data", data);
				} else {
					map.put("state", "2");
				}
			
			return map;
		}
		
		@Override
		public Map<String, Object> getHospital(String hospname) {
			Map<String, Object> map = new HashMap<String, Object>();
			String name = "%"+hospname+"%";
		
				List<Map<String, Object>>  data = hospinfoMapperCustom.selectByHospName(name);
				if (data.size()==0) {
					map.put("state", "2");
				} else {
					map.put("state", "1");
					map.put("data", data);
				}
			
			return map;
		}
		
		@Override
		public Map<String, Object> getDoctorByName(String docname) {
			Map<String, Object> map = new HashMap<String, Object>();
			
				List<Map<String, Object>> list = doctorinfoMapperCustom.selectByName(docname);
				if (list.size()>0) {
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
									Doctorinfo doctor  =doctorinfoMapperCustom.findDoctorinfoByDocLoginId(docloginid);
									Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(usersick.getUserloginid());
									if (doctor!=null && user!=null) {
										String[] tags = {user.getUserloginphone(),"sick"};
										String title = "通知";
										String msg = doctor.getDocname()+"医生拒绝该订单";
										String sign = "3"; //等待病人再确认
										//消息推送
										Map<String, Object> push = PushToAndroid.PushMsgToSmartTag(tags, title, msg,sign);
										if ("1".equals(push.get("state"))) {
											//取消订单成功，且消息发送成功
											map.put("state", "1");
										} else {
											//取消订单成功，且消息发送失败
											map.put("state", "2");
											map.put("msg", push.get("msg"));
										}
										
									} else {
										//取消订单成功，且消息发送失败
										map.put("state", "2");
										map.put("msg", "获取用户信息失败");
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
		//医生确认
		@Override
		public Map<String, Object> updateOrderConfirm(Userorder userorder) throws Exception{
			Map<String, Object> map = new HashMap<String, Object>();
				Integer userorderid = userorder.getUserorderid();
				Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
				//订单存在
				if (order!=null) {
					//订单状态
					int stateid = order.getUserorderstateid();
					//等待医生确认状态
					if (stateid==1) {
						userorder.setUserorderstateid(2);
						//接单时间
						userorder.setUserorderrtime(new Date());
						System.out.println("id............."+userorder.getUserloginid());
						userorder.setUserloginid(null);
						int state = userorderMapper.updateByPrimaryKeySelective(userorder);
						//确认成功
						if (state>0) {
							Doctorinfo doctor  =doctorinfoMapperCustom.findDoctorinfoByDocLoginId(order.getUserorderdocloginid());
							Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(order.getUserloginid());
							if (doctor!=null && user!=null) {
								String[] tags = {user.getUserloginphone(),"sick"};
								String title = "通知";
								String msg = doctor.getDocname()+"医生已接单";
								String sign = "2"; //医生已接单 
								// 消息推送
								Map<String, Object> pushMap = PushToAndroid.PushMsgToSmartTag(tags, title, msg, sign);
								if ("1".equals(pushMap.get("state"))) {
									map.put("state", "1"); // 操作成功,且消息发送成功
								} else {
									map.put("state", "2");
									map.put("msg", pushMap.get("msg"));// 操作成功，但消息推送失败
								}
							} else {
								TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
								//获取信息失败
								map.put("state", "3");  
							}
						
						}else {
							//确认失败
							map.put("state", "4");  
						}
					}else {
						//该状态不支持确认
						map.put("state", "5"); 
					}
				}else{
					//id对应订单不存在
					map.put("state", "6");  	
				}
			
			return map;
		}
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
									Doctorinfo doctor  =doctorinfoMapperCustom.findDoctorinfoByDocLoginId(docLoginId);
									Userlogininfo user = userlogininfoMapper.selectByPrimaryKey(usersick.getUserloginid());
									if (doctor!=null && user!=null) {
										String[] tags = {user.getUserloginphone(),"sick"};
										String title = "通知";
										String msg = doctor.getDocname()+"医生取消订单";
										String sign = "3"; //等待病人再确认
										//消息推送
										Map<String, Object> push = PushToAndroid.PushMsgToSmartTag(tags, title, msg,sign);
										if ("1".equals(push.get("state"))) {
											//取消订单成功，且消息发送成功
											map.put("state", "1");
										} else {
											//取消订单成功，且消息发送失败
											map.put("state", "2");
											map.put("msg", push.get("msg"));
										}
										
									} else {
										//取消订单成功，且消息发送失败
										map.put("state", "2");
										map.put("msg", "获取用户信息失败");
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
				Integer userorderhospid) {
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
								map.put("state", "1");
							} else {
								//操作失败
								map.put("state", "2");
							}
						} else {
							Userorder userorder = new Userorder();
							userorder.setUserorderid(userorderid);
							userorder.setUserorderetime(new Date());
							userorder.setUserorderstateid(9);
							int result = userorderMapper.updateByPrimaryKeySelective(userorder);
							Usersick usersick = new Usersick();
							usersick.setUsersickid(order.getUsersickid());
							//该病情已结束
							usersick.setUsersickstateid(4);
							int sickResult = usersickMapper.updateByPrimaryKeySelective(usersick);
							if (result>0 && sickResult>0) {
								map.put("state", "3");
							} else {
								//操作失败
								map.put("state", "4");
							}
						}
					} else {
						//该状态不支持该操作
						map.put("state", "5");
					}
					
				} else {
					//订单id跟医生id不匹配
					map.put("state", "6");
				}		
			
			return map;
		}

		
}
