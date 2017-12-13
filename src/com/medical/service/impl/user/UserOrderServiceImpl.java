package com.medical.service.impl.user;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctoraddressMapper;
import com.medical.mapper.DoctorcalendarMapperCustom;
import com.medical.mapper.DoctorcommentMapper;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctorpurseMapper;
import com.medical.mapper.DoctorpurseMapperCustom;
import com.medical.mapper.FamilyinfoMapper;
import com.medical.mapper.HospinfoMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HospitalcommentMapper;
import com.medical.mapper.HosppurseMapper;
import com.medical.mapper.HosppurseMapperCustom;
import com.medical.mapper.PayMapper;
import com.medical.mapper.PayMapperCustom;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.Doctoraddress;
import com.medical.po.Doctorcalendar;
import com.medical.po.Doctorcomment;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Doctorpurse;
import com.medical.po.Hospinfo;
import com.medical.po.Hospitalcomment;
import com.medical.po.Hosppurse;
import com.medical.po.Pay;
import com.medical.po.Preorder;
import com.medical.po.Userlogininfo;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.po.custom.CalendarParmas;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.SenderNotificationService;
import com.medical.service.iface.user.UserOrderService;
import com.medical.utils.StringReplaceUtil;
import com.medical.utils.result.DataResult;
import com.pay.alipay.AliPayNotify;
import com.pay.alipay.GetSign;
import com.pay.alipay.MakeOrderNum;
import net.sf.json.JSONObject;

/**
 * @author 作者:xyh
 * @date 创建时间：2017年7月18日 上午09:05:48
 * @version 1.0
 */
public class UserOrderServiceImpl implements UserOrderService {

	@Autowired
	private FamilyinfoMapper familyinfoMapper;
	@Autowired
	private UsersickMapper usersickMapper;
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	@Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private UserorderMapper userorderMapper;
	@Autowired
	private UserorderMapperCustom userorderMapperCustom;
	@Autowired
	private DoctorcommentMapper doctorcommentMapper;
	@Autowired
	private HospitalcommentMapper hospitalcommentMapper;
	@Autowired
	private CommonService commonService;
	@Autowired
	private PayMapper payMapper;
	@Autowired
	private PayMapperCustom payMapperCustom;
	@Autowired
	private DoctorpurseMapper doctorpurseMapper;
	@Autowired
	private DoctorpurseMapperCustom doctorpurseMapperCustom;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired
	private HospinfoMapper hospinfoMapper;
	@Autowired
	private HosppurseMapperCustom hosppurseMapperCustom;
	@Autowired
	private HosppurseMapper hosppurseMapper;
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private UserlogininfoMapper userloginiinfoMapper;
	@Autowired
	private DoctorlogininfoMapper doctorloginiinfoMapper;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private DoctorcalendarMapperCustom doctorcalendarMapperCustom;
	@Autowired
	private DoctoraddressMapper doctoraddressMapper;
	@Autowired 
	private SenderNotificationService senderNotificationService;
	
	/* (非 Javadoc)  
	* <p>Title: createOrder</p>  
	* <p>Description: 生成订单</p>  
	* @param docloginid
	* @param userloginid
	* @param userorderappointment
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.user.UserOrderService#createOrder(java.lang.Integer, java.lang.Integer, java.lang.String)  
	*/  
	@Override
	public String createOrder(Integer docloginid, Integer userloginid, String userorderappointment) throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Doctorlogininfo doctor = doctorloginiinfoMapper.selectByPrimaryKey(docloginid);
		if (doctor==null) {
			return DataResult.error("该医生不存在");
		}
		// 查询处于发布状态的病情
		List<Usersick> lists = usersickMapperCustom.selectByUserLoginIdAndState(userloginid, 2);
		if (lists.size() == 1) {
			String[] time = userorderappointment.split(" ");
			CalendarParmas calendarParmas = new CalendarParmas();
			calendarParmas.setId(docloginid);
			calendarParmas.setTime(time[0]);
			calendarParmas.setKey(time[1]);
			List<Doctorcalendar> doctorcalendar =  doctorcalendarMapperCustom.selectByDocloginidAndDayAndTimeInDoc(calendarParmas);
			if (doctorcalendar==null || doctorcalendar.size()==0) {
				return DataResult.error("该日程不存在");
			}
			//地址id
			int docaddressid = doctorcalendar.get(0).getDoccalendaradressid();
			//病情信息
			Usersick sick = lists.get(0);
			int usersickid = sick.getUsersickid();
			// 订单信息
			Userorder userorder = new Userorder();
			userorder.setUserorderdocloginid(docloginid);
			// 预约时间
			userorder.setUserorderappointment(userorderappointment);
			// 下单时间
			userorder.setUserorderptime(new Date());
			userorder.setUsersickdesc(sick.getUsersickdesc());
			userorder.setUsersickpic(sick.getUsersickpic());
			userorder.setUsersickprimarydept(sick.getUsersickprimarydept());
			userorder.setUsersickseconddept(sick.getUsersickseconddept());
			//亲属信息
			userorder.setFamilyname(sick.getFamilyname());
			userorder.setFamilymale(sick.getFamilymale());
			userorder.setFamilyage(sick.getFamilyage());
			// 就诊地址
			Doctoraddress docaddress = doctoraddressMapper.selectByPrimaryKey(docaddressid);
			userorder.setDocaddresslocation(docaddress.getDocaddresslocation());
			userorder.setDocaddressprovince(docaddress.getDocaddressprovince());
			userorder.setDocaddresscity(docaddress.getDocaddresscity());
			userorder.setDocaddressarea(docaddress.getDocaddressarea());
			userorder.setDocaddressother(docaddress.getDocaddressother());
			userorder.setDocaddresslat(docaddress.getDocaddresslat());
			userorder.setDocaddresslon(docaddress.getDocaddresslon());
			List<Preorder> preorders = preorderMapperCustom.selectByDocIdAndSickId(docloginid, usersickid);
			if (preorders == null || preorders.size() == 0) {
				return DataResult.error("该医生未加入候选");
			}
			// 3是为其他医生推荐的医生
			List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid, 3);
			if (list != null && list.size() == 1) {
				userorder.setUserorderrecdocloginid(list.get(0).getPreorderredocloginid());
			}
			// 1等待医生确定并完善消息
			userorder.setUserorderstateid(1);
			userorder.setUsersickid(usersickid);

			userorder.setUserloginid(userloginid);
			// 插入订单
			int result = userorderMapperCustom.insertSelectiveReturnId(userorder);
			Usersick usersick = new Usersick();
			usersick.setUsersickid(usersickid);
			usersick.setUserorderid(userorder.getUserorderid());
			// 3已生成订单
			usersick.setUsersickstateid(3);
			// 删除已生成订单医生的预订单记录
			int delResult = preorderMapperCustom.deleteByDocLoginIdAndUserSickId(docloginid, usersickid);
			// 更新病情信息
			int upResult = usersickMapper.updateByPrimaryKeySelective(usersick);
			if (result > 0 && upResult > 0 && delResult > 0) {
				JSONObject jsonCustormCont = new JSONObject();
				jsonCustormCont.put("doc_id", docloginid);
				jsonCustormCont.put("order_id", userorder.getUserorderid());
				jsonCustormCont.put("type", "2");
				senderNotificationService.createMsgUserToDoctor(userloginid, docloginid, "等待确认", "选择了您",
						jsonCustormCont);
				return DataResult.success("生成订单成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("生成订单失败");
			}

		} else {
			if (lists.size() > 1) {
				return DataResult.error("系统错误，发布的病情超过一个");
			} else {
				return DataResult.error("没有发布的病情");
			}
		}

	}

	/* (非 Javadoc)  
	* <p>Title: updateOrderStateToCancel</p>  
	* <p>Description: 取消医生订单</p>  
	* @param userorderid 订单id
	* @param userloginid 用户登录id
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.user.UserOrderService#updateOrderStateToCancel(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String updateOrderStateToCancel(Integer userorderid, Integer userloginid) throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		Integer loginid = order.getUserloginid();
		if (userloginid != loginid) {
			return DataResult.error("账号信息不匹配");
		}
		int state = order.getUserorderstateid();
		// 待付款前可取消
		if (state <= 3) {
			//订单信息
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			userorder.setUserorderetime(new Date());
			// 16为病人取消订单
			userorder.setUserorderstateid(16);
			//病情信息
			Usersick usersick = new Usersick();
			usersick.setUsersickid(order.getUsersickid());
			// 无订单
			usersick.setUserorderid(0);
			// 已发布
			usersick.setUsersickstateid(2);
			// 更新订单
			int result = userorderMapper.updateByPrimaryKeySelective(userorder);
			// 更新病情信息
			int upResult = usersickMapper.updateByPrimaryKeySelective(usersick);
			if (result > 0 && upResult > 0) {
				JSONObject jsonCustormCont = new JSONObject();
				senderNotificationService.createMsgUserToDoctor(userloginid, order.getUserorderdocloginid(), "通知消息",
						"取消了订单", jsonCustormCont);
				return DataResult.success("取消订单成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("取消订单失败");
			}
		} else {
			return DataResult.error("该状态订单不支持取消");
		}

	}

	/* (非 Javadoc)  
	* <p>Title: listOrders</p>  
	* <p>Description: 获取订单</p>  
	* @param userloginid 用户登录id
	* @param page 当前页
	* @param type 订单类型
	* @return  
	* @see com.medical.service.iface.user.UserOrderService#listOrders(java.lang.Integer, java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listOrders(Integer userloginid, Integer page, Integer type) {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = userorderMapperCustom.selectAllInfoByUserLoginId(userloginid, type);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());
	}

	/* (非 Javadoc)  
	* <p>Title: getOrderDetail</p>  
	* <p>Description:获取完整订单信息 </p>  
	* @param userloginid
	* @param userorderid
	* @return  
	* @see com.medical.service.iface.user.UserOrderService#getOrderDetail(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String getOrderDetail(Integer userloginid, Integer userorderid) {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Map<String, Object> resultMap = userorderMapperCustom.selectAllInfoByUserLoginIdAndUserOrderId(userloginid,
				userorderid);
		if (resultMap != null && !resultMap.isEmpty()) {
			return DataResult.success("获取成功", resultMap);
		} else {
			return DataResult.error("订单不存在");
		}
	}

	// 确认订单
	@Override
	public String updateOrderStateToConfirm(Integer userloginid, Integer userorderid, Integer type) throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		Integer loginid = order.getUserloginid();
		if (userloginid != loginid) {
			return DataResult.error("账号信息不匹配");
		}
		// 2订单处于等待病人确定状态
		int state = order.getUserorderstateid(); 
		if (state == 2) {
			BigDecimal totalAmount = order.getUserorderprice();
			if (totalAmount.compareTo(BigDecimal.ZERO) == 0) {
				Userorder userorder = new Userorder();
				userorder.setUserorderid(userorderid);
				// 支付完成等待就诊
				userorder.setUserorderstateid(4);
				boolean result = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
				if (result) {
					JSONObject jsonCustormCont = new JSONObject();
					senderNotificationService.createMsgUserToDoctor(order.getUserloginid(),
							order.getUserorderdocloginid(), "通知消息", "支付成功", jsonCustormCont);
					return DataResult.success("支付成功");
				} else {
					return DataResult.error("支付失败");
				}

			}
			if (type == 1) {
				return updateOrderStatePayDoctorByAliPay(order);
			} else {
				return updateOrderStatePayDoctorByAliPay(order);
			}

		} else {
			return DataResult.error("该状态不支持确认");
		}

	}
	 
	// 支付医生费用
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateOrderStatePayDoctorByAliPay(Userorder userorder) throws Exception {
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(userorder.getUserorderdocloginid());
		String boby = "速递医运病人费用缴纳";
		String subject = "缴纳" + doctorinfo.getDocname() + "医生费用";
		String totalAmount = userorder.getUserorderprice() + "";
		String prefix = "u" + userorder.getUserorderid() + "d";
		String outTradeNo = MakeOrderNum.getTradeNo(prefix);
		// 回调地址
		String notifyUrl = "http://1842719ny8.iok.la:14086/internetmedical/user/paydoctorfinishbyalipay";
		String result = GetSign.appGetSign(boby, subject, totalAmount, outTradeNo, notifyUrl);
		
		//支付信息
		Pay pay = new Pay();
		pay.setPaycreattime(new Date());
		// 1为支付宝支付
		pay.setPaymodeid(1);
		pay.setPaybuyerid(userorder.getUserloginid());
		//亲属姓名
		pay.setPaybuyername(userorder.getFamilyname());
		pay.setPaytotalamount(new BigDecimal(totalAmount));
		pay.setPaysellerid(userorder.getUserorderdocloginid());
		pay.setPaysellername(doctorinfo.getDocname());
		pay.setPayorderid(userorder.getUserorderid());
		pay.setPaytradeno(outTradeNo);
		// 1为病人支付给医生
		pay.setPaytypeid(1);
		// 1为交易创建，等待买家付款
		pay.setPaystateid(1);
		boolean payResult = payMapper.insertSelective(pay) > 0;
		if (payResult) {
			return DataResult.success("获取成功", result);
		} else {
			return DataResult.error("支付失败");
		}

	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateOrderStatePayDoctorFinishByAliPay(Map<String, String[]> requestParams) throws Exception {
		
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
			int userorderid = pay.getPayorderid();
			Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
			if (order == null) {
				return DataResult.error("订单不存在");
			}
			int state = order.getUserorderstateid();
			// 订单处于等待病人付款状态
			if (state == 2) {

				Userorder userorder = new Userorder();
				userorder.setUserorderid(userorderid);
				// 支付完成等待就诊
				userorder.setUserorderstateid(4);
				int result = userorderMapper.updateByPrimaryKeySelective(userorder);
				if ("TRADE_SUCCESS".equals(params.get("trade_status"))) {
					// 3为交易成功
					record.setPaystateid(3);
				} else {
					// 4为交易结束，不可退款
					record.setPaystateid(4);
				}
				boolean payResult = payMapper.updateByPrimaryKeySelective(record) > 0;
				// 计算余额
				BigDecimal total = new BigDecimal(amount);
				List<Doctorpurse> list = doctorpurseMapperCustom.selectByDocLoginId(order.getUserorderdocloginid());
				if (list != null && list.size() > 0) {
					for (Doctorpurse doctorpurse : list) {
						//type为1时转入2为转出
						int type = doctorpurse.getDocpursetypeid();
						BigDecimal price = doctorpurse.getDocpurseamount();
						if (type == 2) {
							total = total.subtract(price.abs());
						} else {
							total = total.add(price.abs());
						}
					}
				}
				//更新庄账户余额，医生信息表
				Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(order.getUserorderdocloginid());
				Doctorinfo doctorinfoRecord = new Doctorinfo();
				doctorinfoRecord.setDocid(doctorinfo.getDocid());
				doctorinfoRecord.setDocpursebalance(total);
				boolean doctorinfoResult = doctorinfoMapper.updateByPrimaryKeySelective(doctorinfoRecord) > 0;
				
				// 医生钱包
				Doctorpurse doctorpurse = new Doctorpurse();
				doctorpurse.setDocloginid(order.getUserorderdocloginid());
				doctorpurse.setDocpurseamount(new BigDecimal(amount));
				String name = pay.getPaybuyername();
				doctorpurse.setDocpurseremark("收到病人"+name+"付款");
				doctorpurse.setDocpursetime(new Date());
				// 1为转入
				doctorpurse.setDocpursetypeid(1);
				doctorpurse.setPayid(pay.getPayid());
				doctorpurse.setDocpursebalance(total);
				boolean purse = doctorpurseMapper.insertSelective(doctorpurse) > 0;
				preorderMapperCustom.deleteAllByUserSickId(order.getUsersickid());
				if (result > 0 && payResult && purse && doctorinfoResult) {
					JSONObject jsonCustormCont = new JSONObject();
					senderNotificationService.createMsgUserToDoctor(order.getUserloginid(),
							order.getUserorderdocloginid(), "通知消息", "支付成功", jsonCustormCont);
					return DataResult.success("支付成功");
				} else {
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return DataResult.error("支付失败");
				}
			} else if (state>= 4 && state<7) {
				return DataResult.success("已支付");
			} else {
				return DataResult.error("该状态不支持支付");
			}
	}
	
	/*public String updateOrderStateToConfirmHospital(Integer userloginid, Integer userorderid, Integer type) throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		Integer loginid = order.getUserloginid();
		if (userloginid != loginid) {
			return DataResult.error("账户信息不匹配");
		}
		// 订单处于等待病人确定状态
		int state = order.getUserorderstateid(); 
		if (state == 2) {
			BigDecimal totalAmount = order.getUserorderprice();
			if (totalAmount.compareTo(BigDecimal.ZERO) == 0) {
				Userorder userorder = new Userorder();
				userorder.setUserorderid(userorderid);
				// 支付完成等待就诊
				userorder.setUserorderstateid(4);
				boolean result = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
				if (result) {
					JSONObject jsonCustormCont = new JSONObject();
					commonService.createMsgUserToDoctor(order.getUserloginid(),
							order.getUserorderdocloginid(), "通知消息", "支付成功", jsonCustormCont);
					return DataResult.success("支付成功");
				} else {
					return DataResult.error("支付失败");
				}

			}
			if (type == 1) {
				return updateOrderStatePayDoctorByAliPay(order);
			} else {
				return updateOrderStatePayDoctorByAliPay(order);
			}

		} else {
			return DataResult.error("该状态不支持确认");
		}

	}*/
	@Override
	public String updateOrderStatePayHospital(Integer userloginid, Integer userorderid, Integer type) throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		Integer loginid = order.getUserloginid();
		if (userloginid != loginid) {
			return DataResult.error("账户信息不匹配");
		}
		// 订单处于等待病人确定状态
		int state = order.getUserorderstateid(); 
		if (state == 6) {
			//押金
			BigDecimal totalAmount = order.getUserorderdeposit();
			if (totalAmount.compareTo(BigDecimal.ZERO) == 0) {
				Userorder userorder = new Userorder();
				userorder.setUserorderid(userorderid);
				// 已缴纳医院押金
				userorder.setUserorderstateid(7);
				userorder.setUserorderactualhospitalizationid(4);
				boolean result = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
				if (result) {
					JSONObject jsonCustormCont = new JSONObject();
					senderNotificationService.createMsgUserToHospital(userloginid, order.getUserorderhospid(), "消息通知", "已缴纳押金", jsonCustormCont);
					return DataResult.success("支付成功");
				} else {
					return DataResult.error("支付失败");
				}

			}
			if (type == 1) {
				return updateOrderStatePayHospitalByAlipay(order);
			} else {
				return updateOrderStatePayHospitalByAlipay(order);
			}

		} else {
			return DataResult.error("该状态不支持确认");
		}

	}
	
	// 支付医院费用
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateOrderStatePayHospitalByAlipay(Userorder userorder) throws Exception {
		Integer hosploginid = userorder.getUserorderhospid();
		Integer userorderid = userorder.getUserorderid();
		Integer userloginid = userorder.getUserloginid();
		Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
		String boby = "速递医运病人费用缴纳";
		String subject = "缴纳" + hospinfo.getHospname() + "押金";
		// 医院押金
		String totalAmount = userorder.getUserorderdeposit() + "";
		String prefix = "u" + userorderid + "h";
		String outTradeNo = MakeOrderNum.getTradeNo(prefix);
		// 回调地址
		String notifyUrl = "http://1842719ny8.iok.la:14086/internetmedical/user/payhospitalfinishbyalipay";
		String result = GetSign.appGetSign(boby, subject, totalAmount, outTradeNo, notifyUrl);
		Pay pay = new Pay();
		pay.setPaycreattime(new Date());
		// 1为支付宝支付
		pay.setPaymodeid(1);
		pay.setPaybuyerid(userloginid);
		pay.setPaybuyername(userorder.getFamilyname());
		pay.setPaytotalamount(new BigDecimal(totalAmount));
		pay.setPaysellerid(hosploginid);
		pay.setPaysellername(hospinfo.getHospname());
		pay.setPayorderid(userorderid);
		// 服务器生成交易单号
		pay.setPaytradeno(outTradeNo);
		// 2为病人支付给医院
		pay.setPaytypeid(2);
		// 1为交易创建，等待买家付款
		pay.setPaystateid(1);
		boolean payResult = payMapper.insertSelective(pay) > 0;
		if (payResult) {
			return DataResult.success("获取成功", result);
		} else {
			return DataResult.error("支付失败");
		}
	}

	// 支付医院回调
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String updateOrderStatePayHospitalFinishByAlipay(Map<String, String[]> requestParams) throws Exception {
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
		// 返回的支付宝交易单号
		record.setPayalipaytradeno(trade_no);
		record.setPayendtime(new Date());
		record.setPayinfo(params.toString());
		// 实收金额
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
		int userorderid = pay.getPayorderid();
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		int state = order.getUserorderstateid();
		BigDecimal deposit = order.getUserorderdeposit();
		// 已缴纳的总押金
		BigDecimal totaldeposit = order.getUserordertotaldeposit().add(deposit);
		// 订单处于等待病人付医院押金
		if (state == 6) {
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			// 7为已缴纳押金
			userorder.setUserorderstateid(7);
			//4为已住院(实际住院状态)
			userorder.setUserorderactualhospitalizationid(4);
			// 已缴纳的押金
			userorder.setUserordertotaldeposit(totaldeposit);
			boolean orderResult = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
			if ("TRADE_SUCCESS".equals(params.get("trade_status"))) {
				// 3为交易成功
				record.setPaystateid(3);
			} else {
				// 4为交易结束，不可退款
				record.setPaystateid(4);
			}

			boolean payResult = payMapper.updateByPrimaryKeySelective(record) > 0;
			// 计算医院余额,默认为此次实收金额
			BigDecimal total = new BigDecimal(amount);
			List<Hosppurse> list = hosppurseMapperCustom.selectHosploginid(order.getUserorderhospid());
			if (list != null && list.size() > 0) {
				for (Hosppurse doctorpurse : list) {
					int type = doctorpurse.getHosppursetypeid();
					BigDecimal price = doctorpurse.getHosppurseamount();
					if (type == 2) {
						total = total.subtract(price.abs());
					} else {
						total = total.add(price.abs());
					}
				}
			}
			//更新医院余额
			Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(order.getUserorderhospid());
			Hospinfo hospinfoRecord = new Hospinfo();
			hospinfoRecord.setHospid(hospinfo.getHospid());
			hospinfoRecord.setHosppursebalance(total);
			boolean hospinfoResult = hospinfoMapper.updateByPrimaryKeySelective(hospinfoRecord) > 0;
			// 医生钱包
			Hosppurse hosppurse = new Hosppurse();
			hosppurse.setHosploginid(order.getUserorderhospid());
			hosppurse.setHosppurseamount(new BigDecimal(amount));
			String name = pay.getPaybuyername();
			hosppurse.setHosppurseremark("收到病人"+name+"押金");
			hosppurse.setHosppursetime(new Date());
			// 1为转入
			hosppurse.setHosppursetypeid(1);
			hosppurse.setPayid(pay.getPayid());
			hosppurse.setHosppursebalance(total);
			boolean purse = hosppurseMapper.insertSelective(hosppurse) > 0;
			if (orderResult && payResult && purse && hospinfoResult) {
				JSONObject jsonCustormCont = new JSONObject();
				senderNotificationService.createMsgUserToHospital(order.getUserloginid(), order.getUserorderhospid(), "消息通知", "已缴纳押金",
						jsonCustormCont);
				return DataResult.success("支付成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("支付失败");
			}
		} else if (state >= 7) {
			return DataResult.success("已支付");
		} else {
			return DataResult.error("该状态不支持支付");
		}

	}

	// 取消住院
	@Override
	public String updateOrderStateToCancelHospital(Integer userloginid, Integer userorderid) throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		if (order.getUserloginid() != userloginid) {
			return DataResult.error("账户信息不匹配");
		}
		int stateid = order.getUserorderstateid();
		//实际住院状态
		int actualhospitalization = order.getUserorderactualhospitalizationid();
		if (stateid > 4 && stateid < 7) {
			//4已住院
			if (actualhospitalization==4) {
				return DataResult.error("住院中订单不可取消");
			}
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			//9为订单结束
			userorder.setUserorderstateid(9);
			//2为需要住院，病人取消
			userorder.setUserorderactualhospitalizationid(2);
			boolean orderResult = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
			Usersick usersick = new Usersick();
			usersick.setUsersickid(order.getUsersickid());
			//4为病情已结束
			usersick.setUsersickstateid(4);
			boolean sickResult = usersickMapper.updateByPrimaryKeySelective(usersick) > 0;
			if (orderResult && sickResult) {
				JSONObject jsonCustormCont = new JSONObject();
				senderNotificationService.createMsgUserToHospital(order.getUserloginid(), order.getUserorderhospid(), "消息通知", "取消住院",
						jsonCustormCont);
				return DataResult.success("取消成功");
			} else {
				return DataResult.error("取消失败");
			}

		} else {
			return DataResult.error("该订单状态不支持该操作");
		}

	}

	// 待修改
	@Override
	public String insertEvaluate(Integer userorderid, Integer userloginid, Integer doccommentservicelevel,
			Integer doccommentprofessionallevel, Integer doccommentpricelevel, String doccommentwords,
			Integer hospcommentservicelevel, Integer hospcommentenvironmenlevel, Integer hospcommentpricelevel,
			String hospcommentwords) throws Exception {
		Userlogininfo user = userloginiinfoMapper.selectByPrimaryKey(userloginid);
		if (user==null) {
			return DataResult.error("账户不存在");
		}
		Userorder userorder = userorderMapper.selectByPrimaryKey(userorderid);
		if (userorder == null) {
			return DataResult.error("订单不存在");
		}
		int orderuserloginid = userorder.getUserloginid();
		if (userloginid != orderuserloginid) {
			return DataResult.error("账户信息不匹配");
		}
		int userorderstateid = userorder.getUserorderstateid();
		// 订单结束，可以评价
		if (userorderstateid == 9) {
			int hospitalizationid = userorder.getUserorderactualhospitalizationid();
			int familyid = usersickMapper.selectByPrimaryKey(userorder.getUsersickid()).getFamilyid();
			String name = familyinfoMapper.selectByPrimaryKey(familyid).getFamilyname();
			String username = StringReplaceUtil.userNameReplaceWithStar(name);
			Doctorcomment doctorcomment = new Doctorcomment();
			doctorcomment.setDoccommentpricelevel(doccommentpricelevel);
			doctorcomment.setDoccommentprofessionallevel(doccommentprofessionallevel);
			doctorcomment.setDoccommentservicelevel(doccommentservicelevel);
			doctorcomment.setDoccommentwords(doccommentwords);
			doctorcomment.setUserorderid(userorderid);
			doctorcomment.setUserloginid(userloginid);
			doctorcomment.setDoccommentpatientname(username);
			doctorcomment.setDocloginid(userorder.getUserorderdocloginid());
			doctorcomment.setDoccommenttime(new Date());
			int docResult = doctorcommentMapper.insertSelective(doctorcomment);
			if (docResult <= 0) {
				return DataResult.error("对医生评论失败");
			}
			if (hospitalizationid == 4) {
				Hospitalcomment hospitalcomment = new Hospitalcomment();
				hospitalcomment.setHospcommentenvironmenlevel(hospcommentenvironmenlevel);
				hospitalcomment.setHospcommentpricelevel(hospcommentpricelevel);
				hospitalcomment.setHospcommentservicelevel(hospcommentservicelevel);
				hospitalcomment.setHospcommentwords(hospcommentwords);
				hospitalcomment.setHosploginid(userorder.getUserorderhospid());
				hospitalcomment.setUserloginid(userloginid);
				hospitalcomment.setHospcommentpatientname(username);
				hospitalcomment.setUserorderid(userorderid);
				hospitalcomment.setHospcommenttime(new Date());
				int hospResult = hospitalcommentMapper.insertSelective(hospitalcomment);
				if (hospResult <= 0) {
					// 对医院评论失败
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return DataResult.error("对医院评论失败");
				}

			}
			Userorder order = new Userorder();
			order.setUserorderid(userorderid);
			order.setUserorderstateid(10);
			int userResult = userorderMapper.updateByPrimaryKeySelective(order);
			if (userResult > 0) {
				JSONObject jsonCustormCont = new JSONObject();
				senderNotificationService.createMsgUserToDoctor(userloginid, userorder.getUserorderdocloginid(), "消息通知", "已对订单评价", jsonCustormCont);
				if (hospitalizationid == 4) {
					JSONObject jsonCustormCont2 = new JSONObject();
					senderNotificationService.createMsgUserToHospital(userloginid, userorder.getUserorderhospid(), "消息通知", "已对订单评价", jsonCustormCont2);
				}
				return DataResult.success("评论成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("评论失败");
			}
		} else {
			return DataResult.error("该订单状态不支持评价");

		}

	}

}
