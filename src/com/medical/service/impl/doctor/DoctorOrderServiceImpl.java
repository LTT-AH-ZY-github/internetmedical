package com.medical.service.impl.doctor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.po.Doctorinfo;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Hospinfo;
import com.medical.po.Preorder;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.service.iface.CommonTradeService;
import com.medical.service.iface.SenderNotificationService;
import com.medical.service.iface.doctor.DoctorOrderService;
import com.medical.service.iface.doctor.DoctorPurseService;
import com.medical.utils.result.DataResult;
import net.sf.json.JSONObject;

/**
 * @ClassName:     DoctorOrderServiceImpl.java
 * @Description:   用户订单功能接口实现类
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月9日 下午10:06:42 
 */
public class DoctorOrderServiceImpl implements DoctorOrderService {
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private PreorderMapper preorderMapper;
	@Autowired
	private UserorderMapper userorderMapper;
	@Autowired
	private UsersickMapper usersickMapper;
	@Autowired
	private PreorderMapperCustom preorderMapperCustom;
	@Autowired
	private UserorderMapperCustom userorderMapperCustom;
	@Autowired
	private HospinfoMapperCustom hospinfoMapperCustom;
	@Autowired 
	private SenderNotificationService senderNotificationService;
	@Autowired
	private CommonTradeService commonTradeService;
	@Autowired
	private DoctorPurseService doctorPurseService;


	/* (非 Javadoc)  
	* <p>Title: creatPreOrder</p>  
	* <p>Description: 医生申请病情</p>  
	* @param usersickid
	* @param docloginid
	* @param preorderprice
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorOrderService#creatPreOrder(java.lang.Integer, java.lang.Integer, java.lang.Double)  
	*/  
	@Override
	public String creatPreOrder(Integer usersickid, Integer docloginid, BigDecimal preorderprice) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (doctorlogininfo==null ||doctorinfo==null) {
			return DataResult.error("用户不存在");
		}
		int type = doctorlogininfo.getDoclogintype();
		if (type!=3) {
			return DataResult.error("账户未审核");
		}
		String alipayaccount = doctorinfo.getDocalipayaccount();
		String alipayname = doctorinfo.getDocalipayname();
//		if (StringUtils.isBlank(alipayaccount)) {
//			return DataResult.error("绑定的支付宝账号为空,不可进行该操作");
//		}
//		if (StringUtils.isBlank(alipayname)) {
//			return DataResult.error("绑定的支付宝账号姓名为空,不可进行该操作");
//		}
		Preorder preorder = new Preorder();
		preorder.setPreorderdocloginid(docloginid);
		preorder.setPreorderstate(1);
		if (preorderprice != null) {
			preorder.setPreorderprice(preorderprice);
		}
		preorder.setUsersickid(usersickid);
		// 2医生抢单
		preorder.setPreordertype(2);
		// 申请时间
		preorder.setPreordertime(new Date());
		// 查询病情信息
		Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
		if (usersick == null) {
			return DataResult.error("病情不存在");
		}
		// 病人登录id
		preorder.setPreorderuserloginid(usersick.getUserloginid());
		List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid, 2);
		if (list.size() > 0) {
			return DataResult.error("该病情已申请");
		}
		// 插入预订单
		boolean result = preorderMapper.insertSelective(preorder) > 0;
		if (result) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("doc_id", docloginid);
			jsonCustormCont.put("sick_id", usersickid);
			jsonCustormCont.put("type", "1");
			senderNotificationService.createMsgDoctorToUser(docloginid, usersick.getUserloginid(), "等待确认", "申请了您的病情",
					jsonCustormCont);
			return DataResult.success("申请成功");
		} else {
			return DataResult.error("申请失败");
		}
	}

	/* (非 Javadoc)  
	* <p>Title: listGrabOrders</p>  
	* <p>Description: 获取已抢订单</p>  
	* @param docloginid
	* @param pageNo
	* @param pageSize
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorOrderService#listGrabOrders(java.lang.Integer, java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listGrabOrders(Integer docloginid, Integer pageNo) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		PageHelper.startPage(pageNo, 5);
		List<Map<String, Object>> list = preorderMapperCustom.listByDocLoginId(docloginid);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", page.getList());
	}

	/* (非 Javadoc)  
	* <p>Title: deletePreOrder</p>  
	* <p>Description:  医生取消抢单</p>  
	* @param docloginid
	* @param preorderid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorOrderService#deletePreOrder(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String deletePreOrder(Integer docloginid, Integer preorderid) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Preorder preorder = preorderMapper.selectByPrimaryKey(preorderid);
		if (preorder == null) {
			return DataResult.error("无申请记录");
		}
		Integer docLoginId = preorder.getPreorderdocloginid();
		Integer userloginid = preorder.getPreorderuserloginid();
		if (docloginid != docLoginId) {
			return DataResult.error("账号信息不匹配");
		}
		int result = preorderMapper.deleteByPrimaryKey(preorderid);
		if (result > 0) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("doc_id", docloginid);
			jsonCustormCont.put("sick_id", preorder.getUsersickid());
			jsonCustormCont.put("type", "1");
			senderNotificationService.createMsgDoctorToUser(docloginid, userloginid, "消息通知", "取消申请了您的病情",
					jsonCustormCont);
			return DataResult.success("取消成功");
		} else {
			return DataResult.error("取消失败");

		}
	}

	/* (非 Javadoc)  
	* <p>Title: listOrderToConfirm</p>  
	* <p>Description: 获取选择我的订单</p>  
	* @param docloginid
	* @param pageNo
	* @param pageSize
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorOrderService#listOrderToConfirm(java.lang.Integer, java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listOrderToConfirm(Integer docloginid, Integer pageNo) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		PageHelper.startPage(pageNo, 5);
		List<Map<String, Object>> list = userorderMapperCustom.listOrderToConfirmByDocLoginId(docloginid);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", page.getList());

	}

	// 获取订单
	
	/* (非 Javadoc)  
	* <p>Title: listOrder</p>  
	* <p>Description: </p>  
	* @param docLoginId
	* @param type
	* @param pageNo
	* @param pageSize
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorOrderService#listOrder(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listOrders(Integer docloginid, Integer type, Integer pageno) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		PageHelper.startPage(pageno, 5);
		List<Map<String, Object>> list = userorderMapperCustom.listByDocLoginIdAndState(docloginid, type);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", page.getList());
	}

	/* (非 Javadoc)  
	* <p>Title: getOrderDetail</p>  
	* <p>Description: 获取订单详情</p>  
	* @param docloginid
	* @param userorderid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorOrderService#getOrderDetail(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String getOrderDetail(Integer docloginid, Integer userorderid) throws Exception{
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Map<String, Object> data = userorderMapperCustom.selectAllInfoByUserOrderId(docloginid, userorderid);
		if (data != null && !data.isEmpty()) {
			return DataResult.success("获取成功", data);
		} else {
			return DataResult.error("订单不存在");
		}
	}

	/* (非 Javadoc)  
	* <p>Title: updateOrderToRefuse</p>  
	* <p>Description:医生拒绝接单(推荐其他医生) </p>  
	* @param docloginid
	* @param userorderid
	* @param redocloginid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorOrderService#updateOrderToRefuse(java.lang.Integer, java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String updateOrderToRefuse(Integer docloginid, Integer userorderid, Integer redocloginid) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Userorder userorder = userorderMapper.selectByPrimaryKey(userorderid);
		if (userorder == null) {
			return DataResult.error("订单不存在");
		}
		Integer doc = userorder.getUserorderdocloginid();
		if (docloginid != doc) {
			return DataResult.error("账号信息不匹配");
		}
		Integer userorderstateid = userorder.getUserorderstateid();
		Integer usersickid = userorder.getUsersickid();
		// 1为等待医生确认
		if (userorderstateid != 1) {
			return DataResult.error("该订单状态不支持拒绝");
		}
		// 订单信息
		Userorder record = new Userorder();
		record.setUserorderid(userorderid);
		record.setUserorderetime(new Date());
		record.setUserorderfinishtime(new Date());
		if (redocloginid == null) {
			// 13为医生未接单
			record.setUserorderstateid(13);
		} else {
			if (docloginid==redocloginid) {
				return DataResult.error("推荐医生不可为自己");
			}
			// 11为医生未接单，推荐其他医生
			record.setUserorderstateid(14);
			// 病情相关医生信息
			Preorder preorder = new Preorder();
			preorder.setUsersickid(usersickid);
			preorder.setPreorderuserloginid(userorder.getUserloginid());
			// 3医生推荐
			preorder.setPreordertype(3);
			preorder.setPreorderredocloginid(docloginid);
			Doctorlogininfo redoctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(redocloginid);
			if (redoctorlogininfo == null) {
				return DataResult.error("推荐医生不存在");
			}
			preorder.setPreorderdocloginid(redocloginid);
			preorder.setPreordertime(new Date());
			List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(redocloginid, usersickid, 3);
			if (list != null && list.size() > 0) {
				return DataResult.error("该医生已被推荐");
			}
			int preResult = preorderMapper.insertSelective(preorder);
			if (preResult == 0) {
				return DataResult.error("推荐医生失败");
			}
		}
        Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
		if (usersick == null) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("病情不存在，取消失败");
		}
		// 病情信息
		Usersick sick = new Usersick();
		sick.setUsersickid(usersickid);
		sick.setUsersickstateid(2);
		int orderResult = userorderMapper.updateByPrimaryKeySelective(record);
		int sickResult = usersickMapper.updateByPrimaryKeySelective(sick);
		if (orderResult > 0 && sickResult > 0) {

			JSONObject jsonCustormCont = new JSONObject();
			String msg = null;
			if (redocloginid != null) {
				String name = doctorinfoMapperCustom.selectByDocLoginId(redocloginid).getDocname();
				msg = "拒绝了您的申请并推荐了" + name + "医生";
				jsonCustormCont.put("redoc_id", redocloginid);
			} else {
				jsonCustormCont.put("redoc_id", 0);
				msg = "拒绝了您的订单";
			}
			jsonCustormCont.put("accept", false);
			jsonCustormCont.put("doc_id", docloginid);
			jsonCustormCont.put("sick_id", usersickid);
			jsonCustormCont.put("order_id", userorderid);
			jsonCustormCont.put("type", "3");
			senderNotificationService.createMsgDoctorToUser(docloginid, userorder.getUserloginid(), "通知消息", msg,
					jsonCustormCont);

			return DataResult.success("取消成功");
		} else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("取消失败");

		}

	}

	/* (非 Javadoc)  
	* <p>Title: updateOrderConfirm</p>  
	* <p>Description:医生确认订单 </p>  
	* @param userorder
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorOrderService#updateOrderConfirm(com.medical.po.Userorder)  
	*/  
	@Override
	public String updateOrderConfirm(Userorder userorder) throws Exception {
		Integer docloginid = userorder.getUserorderdocloginid(); 
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
//		if (StringUtils.isBlank(alipayaccount)) {
//			return DataResult.error("绑定的支付宝账号为空,不可进行该操作");
//		}
//		if (StringUtils.isBlank(alipayname)) {
//			return DataResult.error("绑定的支付宝账号姓名为空,不可进行该操作");
//		}
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
		// 医生价格
		record.setUserorderdprice(userorder.getUserorderdprice());
		// 住宿类型
		int apricetype = userorder.getUserorderapricetype();
		record.setUserorderapricetype(userorder.getUserorderapricetype());
		BigDecimal aprice = userorder.getUserorderaprice();
		// 住宿价格
		if (aprice != null) {
			record.setUserorderaprice(aprice);
		}
		if (apricetype == 3) {
			total = total.add(aprice);
		}

		// 交通类型
		int tpricetype = userorder.getUserordertpricetype();
		record.setUserordertpricetype(tpricetype);
		// 交通价格
		BigDecimal tprice = userorder.getUserordertprice();
		if (tprice != null) {
			record.setUserordertprice(userorder.getUserordertprice());
		}
		if (tpricetype == 3) {
			total = total.add(tprice);
		}

		// 餐饮类型
		int epricetype = userorder.getUserorderepricetype();
		record.setUserorderepricetype(epricetype);
		// 餐饮价格
		BigDecimal eprice = userorder.getUserordereprice();
		record.setUserordereprice(eprice);
		if (epricetype == 3) {
			total = total.add(eprice);
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
			jsonCustormCont.put("redoc_id", 0);
			senderNotificationService.createMsgDoctorToUser(order.getUserorderdocloginid(), order.getUserloginid(),
					"等待确认", "接受了您的订单", jsonCustormCont);
			return DataResult.success("确认成功");
		} else {
			return DataResult.error("确认失败");
		}
	}

	/* (非 Javadoc)  
	* <p>Title: updateOrderToCancle</p>  
	* <p>Description: 医生取消订单</p>  
	* @param docloginid
	* @param userorderid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorOrderService#updateOrderToCancle(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String updateOrderToCancle(Integer docloginid, Integer userorderid) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Userorder userorder = userorderMapper.selectByPrimaryKey(userorderid);
		if (userorder == null) {
			return DataResult.error("该订单不存在");
		}
		Integer doc = userorder.getUserorderdocloginid();
		if (docloginid != doc) {
			return DataResult.error("账号信息不匹配");
		}
		//判断订单是否处于支付中
		boolean isExit = commonTradeService.queryUserOrderIsExit(userorderid);
		if (isExit) {
				return DataResult.error("支付中,不可取消");
		}
		Integer userorderstateid = userorder.getUserorderstateid();
		Integer usersickid = userorder.getUsersickid();
		if (userorderstateid >= 4) {
			return DataResult.error("该订单状态不支付取消");
		}
		// 订单信息
		Userorder record = new Userorder();
		record.setUserorderid(userorderid);
		// 15为医生取消订单
		record.setUserorderstateid(15);
		record.setUserorderetime(new Date());
		//整个订单结束时间
		userorder.setUserorderfinishtime(new Date());
		Usersick usersick = usersickMapper.selectByPrimaryKey(usersickid);
		if (usersick == null) {
			return DataResult.error("病情不存在");
		}
		// 病情信息
		Usersick sick = new Usersick();
		sick.setUsersickid(usersickid);
		sick.setUsersickstateid(2);
		int orderResult = userorderMapper.updateByPrimaryKeySelective(record);
		int sickResult = usersickMapper.updateByPrimaryKeySelective(sick);
		if (orderResult > 0 && sickResult > 0) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("accept", false);
			jsonCustormCont.put("doc_id", userorder.getUserloginid());
			jsonCustormCont.put("sick_id", userorder.getUsersickid());
			jsonCustormCont.put("order_id", userorderid);
			jsonCustormCont.put("type", "3");
			jsonCustormCont.put("redoc_id", 0);
			senderNotificationService.createMsgDoctorToUser(docloginid, userorder.getUserloginid(), "通知消息", "取消了您订单",
					jsonCustormCont);
			return DataResult.success("取消成功");
		} else {
			// 取消失败，未知错误
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return DataResult.error("取消失败");
		}

	}
	
	/* (非 Javadoc)  
	* <p>Title: updateOrderTofinish</p>  
	* <p>Description:结束订单 </p>  
	* @param docloginid
	* @param userorderid
	* @param userorderhstate
	* @param userorderhospid
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorOrderService#finishOrder(java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Integer)  
	*/  
	@Override
	public String updateOrderTofinish(Integer docloginid, Integer userorderid, Boolean userorderhstate,
			Integer userorderhospid) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Userorder order = userorderMapperCustom.selectByDocLoginIdAndUserOrderId(docloginid, userorderid);
		Doctorinfo doctorinfo = doctorinfoMapperCustom.selectByDocLoginId(docloginid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		Integer userOrderStateId = order.getUserorderstateid();
		// 预付款完成,等待医生就诊状态
		if (userOrderStateId != 4) {
			return DataResult.error("该状态不支持该操作");
		}
		// 医生金额记录
		String purseResult = doctorPurseService.updateBalance(order.getUserorderdocloginid(), 1,
				order.getUserorderprice(), "收到病人" + order.getFamilyname() + "付款",0);
		JSONObject purseObject = JSONObject.fromObject(purseResult);
		if ( "200".equals(purseObject.get("code").toString())) {
			return DataResult.error("结束失败，请重试");
		}
		if (userorderhstate) {
			Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(userorderhospid);
			if (hospinfo == null) {
				return DataResult.error("该医院不存在");	
			}
			String alipayaccount = hospinfo.getHospalipayaccount();
			String alipayname = hospinfo.getHospalipayname();
//			if (StringUtils.isBlank(alipayaccount)) {
//				return DataResult.error("该医院绑定的支付宝账号为空,不可进行该操作");
//			}
//			if (StringUtils.isBlank(alipayname)) {
//				return DataResult.error("该医院绑定的支付宝账号姓名为空,不可进行该操作");
//			}
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			// 5需要住院，等待医院确认
			userorder.setUserorderstateid(5);
			userorder.setUserorderhstate(true);
			userorder.setUserorderhospid(userorderhospid);
			//医生之间订单结束时间
			userorder.setUserorderetime(new Date());
			userorder.setUserorderchosehosptime(new Date());
			// 住院部门默认为医生所在部门
			userorder.setUserorderhospprimarydept(doctorinfo.getDocprimarydept());
			userorder.setUserorderhospseconddept(doctorinfo.getDocseconddept());
			int result = userorderMapper.updateByPrimaryKeySelective(userorder);
			if (result > 0) {
				JSONObject jsonCustormCont = new JSONObject();
				jsonCustormCont.put("order_id", userorderid);
				jsonCustormCont.put("type", "5");
				senderNotificationService.createMsgDoctorToUser(docloginid, order.getUserloginid(), "通知消息",
						"就诊已完成,需要住院", jsonCustormCont);
				senderNotificationService.createMsgDoctorToHospital(docloginid,userorderhospid,"通知消息","申请了一个住院订单", jsonCustormCont);
				return DataResult.success("订单结束成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("结束失败");
			}
		} else {
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			userorder.setUserorderetime(new Date());
			//整个订单结束时间
			userorder.setUserorderfinishtime(new Date());
			userorder.setUserorderstateid(9);
			userorder.setUserorderactualhospitalizationid(1);
			int result = userorderMapper.updateByPrimaryKeySelective(userorder);
			Usersick usersick = new Usersick();
			usersick.setUsersickid(order.getUsersickid());
			// 该病情已结束
			usersick.setUsersickstateid(4);
			int sickResult = usersickMapper.updateByPrimaryKeySelective(usersick);
			if (result > 0 && sickResult > 0) {
				JSONObject jsonCustormCont = new JSONObject();
				jsonCustormCont.put("order_id", userorderid);
				jsonCustormCont.put("type", "5");
				senderNotificationService.createMsgDoctorToUser(docloginid, order.getUserloginid(), "通知消息",
						"就诊已完成,等待评价该医生", jsonCustormCont);
				return DataResult.success("订单结束成功");
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("结束失败");
			}
		}

	}

	/* (非 Javadoc)  
	* <p>Title: listHistoryOrder</p>  
	* <p>Description: 获取历史订单</p>  
	* @param docloginid
	* @param page
	* @return
	* @throws Exception  
	* @see com.medical.service.iface.doctor.DoctorOrderService#listHistoryOrder(java.lang.Integer, java.lang.Integer)  
	*/  
	@Override
	public String listHistoryOrder(Integer docloginid, Integer page) throws Exception{
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = userorderMapperCustom.listHistortOrderByDocLoginId(docloginid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());
   }

	//申请退款
	@Override
	public String updateToRefund(Integer userorderid, Integer docloginid, String cancelreason) throws Exception {
		Doctorlogininfo doctorlogininfo = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doctorlogininfo==null) {
			return DataResult.error("账号不存在");
		}
		Userorder order = userorderMapperCustom.selectByDocLoginIdAndUserOrderId(docloginid, userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		int doctor = order.getUserorderdocloginid();
		if (docloginid!=doctor) {
			return DataResult.error("账号订单不匹配");
		}
		int stateid  = order.getUserorderstateid();
		if (stateid!=4) {
			return DataResult.error("该订单不支持退款");
		}
		Userorder userorder = new Userorder();
		userorder.setUserorderid(userorderid);	
		userorder.setUserorderstateid(18);
		userorder.setCancelreason(cancelreason);
		userorder.setUserorderetime(new Date());
		boolean result = userorderMapper.updateByPrimaryKeySelective(userorder)>0;
		if (result) {
			JSONObject jsonCustormCont = new JSONObject();
			jsonCustormCont.put("order_id", userorderid);
			jsonCustormCont.put("type", "5");
			senderNotificationService.createMsgDoctorToUser(docloginid, order.getUserloginid(), "通知消息",
					"申请取消订单，等待管理员审核退款", jsonCustormCont);
			return DataResult.success("申请成功");
		}else {
			return DataResult.success("申请失败");
		}
	}

}
