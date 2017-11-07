package com.medical.service.impl.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.baidu.yun.push.utils.PushToAndroid;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.exception.custom.MyException;
import com.medical.mapper.CityMapperCustom;
import com.medical.mapper.DoctorcommentMapper;
import com.medical.mapper.DoctorcommentMapperCustom;
import com.medical.mapper.DoctorinfoMapper;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctorlogininfoMapperCustom;
import com.medical.mapper.DoctorskdMapper;
import com.medical.mapper.DoctorskdMapperCustom;
import com.medical.mapper.FamilyinfoMapper;
import com.medical.mapper.FamilyinfoMapperCustom;
import com.medical.mapper.HospitalcommentMapper;
import com.medical.mapper.PreorderMapper;
import com.medical.mapper.PreorderMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserlogMapper;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserlogininfoMapperCustom;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.mapper.UsersickMapper;
import com.medical.mapper.UsersickMapperCustom;
import com.medical.po.Familyinfo;
import com.medical.po.Preorder;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.service.iface.user.UserOrderService;

import net.sf.json.JSONObject;

/**
 * @author 作者:xyh
 * @date 创建时间：2017年7月18日 上午09:05:48
 * @version 1.0
 */
public class UserOrderServiceImpl implements UserOrderService {
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private UserlogininfoMapper userlogininfoMapper;
	@Autowired
	private UserlogininfoMapperCustom userlogininfoMapperCustom;
	@Autowired
	private UserlogMapper userlogMapper;
	@Autowired
	private FamilyinfoMapper familyinfoMapper;
	@Autowired
	private FamilyinfoMapperCustom familyinfoMapperCustom;
	@Autowired
	private CityMapperCustom cityMapperCustom;
	@Autowired
	private UsersickMapper usersickMapper;
	@Autowired
	private UsersickMapperCustom usersickMapperCustom;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	@Autowired
	private DoctorlogininfoMapperCustom doctorlogininfoMapperCustom;
	@Autowired
	private DoctorinfoMapper doctorinfoMapper;
	@Autowired
	private DoctorlogininfoMapper doctorlogininfoMapper;
	@Autowired
	private DoctorskdMapperCustom doctorskdMapperCustom;
	@Autowired
	private DoctorskdMapper doctorskdMapper;
	@Autowired
	private PreorderMapper preorderMapper;
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
	private DoctorcommentMapperCustom doctorcommentMapperCustom;

	// 生成订单
	@Override
	public boolean createOrder(Integer docloginid, Integer userloginid, String userorderappointment) throws Exception {
		// 查询处于发布状态的病情
		List<Usersick> lists = usersickMapperCustom.selectByUserLoginIdAndState(userloginid, 2);
		if (lists.size() == 1) {
			int usersickid = lists.get(0).getUsersickid();
			// 订单信息
			Userorder userorder = new Userorder();
			userorder.setUserorderdocloginid(docloginid);
			// 预约时间
			userorder.setUserorderappointment(userorderappointment);
			// 下单时间
			userorder.setUserorderptime(new Date());
			List<Preorder> preorders = preorderMapperCustom.selectByDocIdAndSickId(docloginid, usersickid);
			if (preorders.size() != 0) {
				List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid, 3);
				if (list.size() == 1) {
					userorder.setUserorderrecdocloginid(list.get(0).getPreorderredocloginid());
				}
				// 等待医生确定并完善消息
				userorder.setUserorderstateid(1);
				userorder.setUsersickid(usersickid);
				// Usersick user = usersickMapper.selectByPrimaryKey(usersickid);
				userorder.setUserloginid(userloginid);
				// 插入订单
				int result = userorderMapperCustom.insertSelectiveReturnId(userorder);
				Usersick usersick = new Usersick();
				usersick.setUsersickid(usersickid);
				usersick.setUserorderid(userorder.getUserorderid());
				// 已生成订单
				usersick.setUsersickstateid(3);
				// 删除已生成订单医生的预订单记录
				int delResult = preorderMapperCustom.deleteByDocLoginIdAndUserSickId(docloginid, usersickid);
				// 更新病情信息
				int upResult = usersickMapper.updateByPrimaryKeySelective(usersick);
				if (result > 0 && upResult > 0 && delResult > 0) {
					/*
					 * JSONObject jsonCustormCont = new JSONObject();
					 * jsonCustormCont.put("userloginid", userloginid);
					 * jsonCustormCont.put("userorderid", userorder.getUserorderid()); //2为选择医生
					 * jsonCustormCont.put("type", 2); Familyinfo familyinfo =
					 * familyinfoMapper.selectByPrimaryKey(lists.get(0).getFamilyid()); String msg =
					 * familyinfo.getFamilyname()+"选择您就诊"; String channelid =
					 * doctorlogininfoMapper.selectByPrimaryKey(docloginid).getDocloginchannelid();
					 * PushToAndroid.pushMsgToSingleDevice("4179866765074456544", "等待确认订单", msg,
					 * jsonCustormCont);
					 */
					return true;
				} else {
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					return false;
				}
			} else {
				throw new MyException("该医生未加入候选");

			}
		} else {
			if (lists.size() > 1) {
				throw new MyException("系统错误，发布的病情超过一个");

			} else {
				throw new MyException("没有发布的病情");

			}
		}

	}

	// 取消订单
	@Override
	public boolean updateOrderStateToCancel(Integer userOrderId, Integer userLoginId) throws Exception {
		Userorder order = userorderMapper.selectByPrimaryKey(userOrderId);
		if (order != null) {
			Integer loginid = order.getUserloginid();
			if (userLoginId == loginid) {
				int state = order.getUserorderstateid();
				if (state <= 3) {
					Userorder userorder = new Userorder();
					userorder.setUserorderid(userOrderId);
					userorder.setUserorderetime(new Date());
					// 病人取消订单
					userorder.setUserorderstateid(16);
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
						return true;
					} else {
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return false;
					}
				} else {
					throw new MyException("该状态订单不支持取消");
				}
			} else {
				throw new MyException("用户和订单不匹配");
			}

		} else {
			throw new MyException("无对应订单");
		}

	}

	// 获取订单
	@Override
	public PageInfo<Map<String, Object>> listOrders(Integer userloginid, Integer page, Integer type) {

		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = userorderMapperCustom.selectAllInfoByUserLoginId(userloginid, type);
		return new PageInfo<Map<String, Object>>(list);
		/*
		 * if (order.getTotal()>0) { // 获取数据成功 map.put("state", "1"); map.put("data",
		 * order.getList()); } else { map.put("state", "2"); } } catch (Exception e) {
		 * e.printStackTrace(); map.put("state", "3"); } return map; }
		 */
	}

	// 获取完整订单信息
	@Override
	public Map<String, Object> getOrderDetail(Integer userloginid, Integer userorderid) {
		return userorderMapperCustom.selectAllInfoByUserLoginIdAndUserOrderId(userloginid, userorderid);
	}

	// 确认订单
	@Override
	public boolean updateOrderStateToConfirm(Integer userloginid, Integer userorderid) throws Exception {

		Userorder user = userorderMapper.selectByPrimaryKey(userorderid);
		if (user != null) {
			Integer loginid = user.getUserloginid();
			if (userloginid == loginid) {
				int state = user.getUserorderstateid();
				// 订单处于等待病人确定状态
				if (state == 2) {
					Userorder userorder = new Userorder();
					userorder.setUserorderid(userorderid);
					// userorder.setUserorderstateid(3); // 待付款
					userorder.setUserorderstateid(4); // 等待就诊
					int result = userorderMapper.updateByPrimaryKeySelective(userorder);
					if (result > 0) {
						return true;
					} else {
						return false;
					}
				} else {
					throw new MyException("该状态不支持用户确认");
				}
			} else {
				throw new MyException("用户和订单不匹配");
			}
		} else {
			throw new MyException("订单不存在");
		}

	}

	// 支付医生费用
	@Override
	public boolean updateOrderStatePayDoctor(Integer userloginid, Integer userorderid) throws Exception {

		Userorder user = userorderMapper.selectByPrimaryKey(userorderid);
		if (user != null) {
			Integer loginid = user.getUserloginid();
			if (userloginid == loginid) {
				int state = user.getUserorderstateid();
				// 订单处于等待病人确定状态
				if (state == 3) {
					Userorder userorder = new Userorder();
					userorder.setUserorderid(userorderid);
					// 支付完成等待就诊
					userorder.setUserorderstateid(4);
					int result = userorderMapper.updateByPrimaryKeySelective(userorder);
					if (result > 0) {
						return true;
					} else {
						return false;
					}
				} else {
					throw new MyException("该状态不支持支付");
				}
			} else {
				throw new MyException("用户和订单不匹配");
			}
		} else {
			throw new MyException("订单不存在");
		}

	}
	
	//支付医院费用
	@Override
	public boolean updateOrderStatePayHospital(Integer userloginid, Integer userorderid) {
		// TODO Auto-generated method stub
		return false;
	}
}
