package com.medical.service.impl.user;

import java.io.StringReader;
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
import com.medical.po.Doctorcomment;
import com.medical.po.Familyinfo;
import com.medical.po.Hospitalcomment;
import com.medical.po.Preorder;
import com.medical.po.Userorder;
import com.medical.po.Usersick;
import com.medical.service.iface.CommonService;
import com.medical.service.iface.user.UserOrderService;
import com.medical.utils.StringReplaceUtil;
import com.medical.utils.result.DataResult;
import com.sun.org.apache.regexp.internal.recompile;

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
	@Autowired 
	private CommonService commonService;

	// 生成订单
	@Override
	public String createOrder(Integer docloginid, Integer userloginid, String userorderappointment) throws Exception {
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
			if (preorders.size() == 0) {
				return DataResult.error("该医生未加入候选");
			}
			// 3是为其他医生推荐的医生
			List<Preorder> list = preorderMapperCustom.selectByDocLoginIdAndUserSickId(docloginid, usersickid, 3);
			if (list.size() == 1) {
				userorder.setUserorderrecdocloginid(list.get(0).getPreorderredocloginid());
			}
			// 等待医生确定并完善消息
			userorder.setUserorderstateid(1);
			userorder.setUsersickid(usersickid);
			
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
				JSONObject jsonCustormCont = new JSONObject();
				jsonCustormCont.put("doc_id", docloginid);
				jsonCustormCont.put("order_id", userorder.getUserorderid());
				jsonCustormCont.put("type", "2");
				String push = commonService.createMsgUserToDoctor(userloginid, docloginid, "等待确认", "选择了您",jsonCustormCont);
				if ("1".equals(push)) {
					return DataResult.success("生成订单成功,且消息发送成功");
				}else {
					return DataResult.success("生成订单成功,但消息发送失败");
				}
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

	// 取消医生订单
	@Override
	public String updateOrderStateToCancel(Integer userorderid, Integer userloginid) throws Exception {
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		Integer loginid = order.getUserloginid();
		if (userloginid != loginid) {
			return DataResult.error("用户和订单不匹配");
		}
		int state = order.getUserorderstateid();
		//待付款前可取消
		if (state <= 3) {
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
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
				
				return DataResult.success("取消订单成功,且消息发送成功");
				/*String push = commonService.createMsgUserToDoctor(userloginid, order.getUserorderdocloginid(), "通知消息", "取消了订单");
				if ("1".equals(push)) {
					return DataResult.success("取消订单成功,且消息发送成功");
				} else {
					return DataResult.success("取消订单成功,但消息发送失败");
				}*/
			} else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return DataResult.error("取消订单失败");
			}
		} else {
			return DataResult.error("该状态订单不支持取消");
		}

	}

	// 获取订单
	@Override
	public String listOrders(Integer userloginid, Integer page, Integer type) {
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = userorderMapperCustom.selectAllInfoByUserLoginId(userloginid, type);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			return DataResult.success("获取数据成功", pageInfo.getList());
		}else {
			return DataResult.success("获取数据为空", null);
		}
		
		
	}

	// 获取完整订单信息
	@Override
	public Map<String, Object> getOrderDetail(Integer userloginid, Integer userorderid) {
		return userorderMapperCustom.selectAllInfoByUserLoginIdAndUserOrderId(userloginid, userorderid);
	}

	// 确认订单
	@Override
	public String updateOrderStateToConfirm(Integer userloginid, Integer userorderid) throws Exception {
		Userorder user = userorderMapper.selectByPrimaryKey(userorderid);
		if (user == null) {
			return DataResult.error("订单不存在");
		}
		Integer loginid = user.getUserloginid();
		if (userloginid != loginid) {
			return DataResult.error("用户和订单不匹配");
		}
		int state = user.getUserorderstateid();
		// 订单处于等待病人确定状态
		if (state == 2) {
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			// userorder.setUserorderstateid(3); // 待付款
			userorder.setUserorderstateid(4); // 等待就诊
			int result = userorderMapper.updateByPrimaryKeySelective(userorder);
			if (result > 0) {
				JSONObject jsonCustormCont = new JSONObject();
				jsonCustormCont.put("doc_id", user.getUserorderdocloginid());
				jsonCustormCont.put("order_id", user.getUserorderid());
				jsonCustormCont.put("accept", true);
				jsonCustormCont.put("type", "4");
				String push = commonService.createMsgUserToDoctor(userloginid, user.getUserorderdocloginid(), "通知消息", "确认了订单",jsonCustormCont);
				if ("1".equals(push)) {
					return DataResult.success("确认成功,且消息发送成功");
				} else {
					return DataResult.success("确认成功,但消息发送失败");
				}
						
			}else {
				return DataResult.error("确认失败");
				
			} 
		}else {
			return DataResult.error("该状态不支持确认");
					
		}
		
		
	}
	//待修改
	@Override
	public int insertEvaluate(Integer userorderid, Integer userloginid, Integer doccommentservicelevel,
			Integer doccommentprofessionallevel, Integer doccommentpricelevel, String doccommentwords,
			Integer hospcommentservicelevel, Integer hospcommentenvironmenlevel, Integer hospcommentpricelevel,
			String hospcommentwords) throws Exception {

		Userorder userorder = userorderMapperCustom.selectByUserLoginIdAndUserOrderId(userloginid, userorderid);
		if (userorder != null) {
			int userorderstateid = userorder.getUserorderstateid();
			// 订单结束，可以评价
			if (userorderstateid == 9) {
				int hospitalizationid = userorder.getUserorderactualhospitalizationid();
				int familyid = usersickMapper.selectByPrimaryKey(userorder.getUsersickid()).getFamilyid();
				String name = familyinfoMapper.selectByPrimaryKey(familyid).getFamilyname();
				String username =  StringReplaceUtil.userNameReplaceWithStar(name);
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
					// 对医生评论失败
					return 2;
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
					if (docResult <= 0) {
						// 对医院评论失败
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return 3;
					}

				}
				Userorder order = new Userorder();
				order.setUserorderid(userorderid);
				order.setUserorderstateid(10);
				int userResult = userorderMapper.updateByPrimaryKeySelective(order);
				if (userResult > 0) {
					// 评论成功
					return 1;
				} else {
					// 更新订单状态失败
					return 4;
				}
			} else {
				// 该订单状态不支持评价
				return 5;
			}

		} else {
			// 该订单不属于该用户
			return 6;
		}

	}

	public static void main(String[] args) {
		System.out.println(StringReplaceUtil.userNameReplaceWithStar("嘻试试"));
		;
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

	// 支付医院费用
	@Override
	public boolean updateOrderStatePayHospital(Integer userloginid, Integer userorderid) {
		// TODO Auto-generated method stub
		return false;
	}

	// 取消住院
	@Override
	public String updateOrderStateToCancelHospital(Integer userloginid, Integer userorderid) throws Exception {
		Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
		if (order == null) {
			return DataResult.error("订单不存在");
		}
		int user = order.getUserloginid();
		if (user != userloginid) {
			return DataResult.error("该订单不属于该用户");
		}
		int stateid = order.getUserorderstateid();
		if (stateid > 4 && stateid < 7) {
			Userorder userorder = new Userorder();
			userorder.setUserorderid(userorderid);
			userorder.setUserorderstateid(9);
			userorder.setUserorderactualhospitalizationid(2);
			boolean orderResult = userorderMapper.updateByPrimaryKeySelective(userorder) > 0;
			Usersick usersick = new Usersick();
			usersick.setUsersickid(order.getUsersickid());
			usersick.setUsersickstateid(4);
			boolean sickResult = usersickMapper.updateByPrimaryKeySelective(usersick) > 0;
			if (orderResult && sickResult) {
				return DataResult.success("取消成功");
			} else {
				return DataResult.error("取消失败");
			}
			
		} else {
			return DataResult.error("该订单状态不支持该操作");
		}
	
	}
}
