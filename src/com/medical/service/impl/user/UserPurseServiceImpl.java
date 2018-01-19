package com.medical.service.impl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.PayMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserpurseMapperCustom;
import com.medical.po.Userinfo;
import com.medical.service.iface.user.UserPurseService;
import com.medical.utils.result.DataResult;

/**
 * @ClassName: UserPursueServiceImpl.java
 * @Description: 用户钱包功能接口实现类
 * @author xyh
 * @version V1.0
 * @Date 2017年11月27日 上午11:53:39
 */
public class UserPurseServiceImpl implements UserPurseService {
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private UserpurseMapperCustom userpurseMapperCustom;
	@Autowired
	private PayMapperCustom payMapperCustom;
	@Autowired
	private UserinfoMapper userinfoMapper;

	//获取用户绑定的支付宝账号
	@Override
	public String getAliPayAccount(Integer userloginid) throws Exception {
		Userinfo userinfo = userinfoMapperCustom.selectByLoginId(userloginid);
		if (userinfo == null) {
			return DataResult.error("账户不存在");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("alipayaccount", userinfo.getUseralipayaccount());
		map.put("alipayname", userinfo.getUseralipayname());
		return DataResult.success("获取成功",map);
	}

	//更新支付宝信息
	@Override
	public String updateAliPayAccount(Integer userloginid, String alipayaccount,String alipayname) throws Exception {
		Userinfo userinfo = userinfoMapperCustom.selectByLoginId(userloginid);
		if (userinfo == null) {
			return DataResult.error("账号不存在");
		}
		Userinfo record = new Userinfo();
		record.setUserid(userinfo.getUserid());
		record.setUseralipayaccount(alipayaccount);
		record.setUseralipayname(alipayname);
		boolean result = userinfoMapper.updateByPrimaryKeySelective(record) > 0;
		if (result) {
			return DataResult.success("更新成功");
		} else {
			return DataResult.error("更新失败");
		}

	}

	/**
	 * @Title: getBalance
	 * @Description: TODO
	 * @return: void
	 * @throws Exception
	 */
	@Override
	public String getBalance(Integer userloginid) throws Exception {
		Userinfo userinfo = userinfoMapperCustom.selectByLoginId(userloginid);
		if (userinfo == null) {
			return DataResult.error("账户不存在");
		}
		return DataResult.success("获取成功", userinfo.getUserpursebalance());
	}
	
	
	/**
	 * @return
	 * @Title: listBalanceRecord
	 * @Description: TODO
	 * @return: void
	 */

	@Override
	public String listBalanceRecord(Integer userloginid, Integer page) throws Exception {
		Userinfo userinfo = userinfoMapperCustom.selectByLoginId(userloginid);
		if (userinfo == null) {
			return DataResult.error("账户不存在");
		}
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = userpurseMapperCustom.selectByUserLoginId(userloginid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			return DataResult.success("获取数据成功", pageInfo.getList());
		} else {
			return DataResult.success("获取数据为空", null);
		}

	}
	
	//获取交易记录
	@Override
	public String listTradeRecord(Integer userloginid, Integer page) throws Exception {
		Userinfo userinfo = userinfoMapperCustom.selectByLoginId(userloginid);
		if (userinfo == null) {
			return DataResult.error("账户不存在");
		}
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = payMapperCustom.selectByLoginIdAndType(userloginid, 1);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return DataResult.success("获取成功", pageInfo.getList());
	}
	
	//按订单获取交易记录
	@Override
	public String listTradeRecordByOrder(Integer userloginid,Integer userorderid) throws Exception {
		Userinfo userinfo = userinfoMapperCustom.selectByLoginId(userloginid);
		if (userinfo == null) {
			return DataResult.error("账户不存在");
		}
		List<Map<String, Object>> list = payMapperCustom.selectByLoginIdAndTypeAndOrderId(userloginid,1,userorderid);
		return DataResult.success("获取成功", list);
	}
}
