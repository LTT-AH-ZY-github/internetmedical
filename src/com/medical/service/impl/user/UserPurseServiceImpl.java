/**
 * 
 */
package com.medical.service.impl.user;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.PayMapperCustom;
import com.medical.mapper.UserinfoMapper;
import com.medical.mapper.UserinfoMapperCustom;
import com.medical.mapper.UserpurseMapper;
import com.medical.mapper.UserpurseMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.Userinfo;
import com.medical.service.iface.user.UserPurseService;

import com.medical.utils.result.DataResult;

/**
 * @ClassName:     UserPursueServiceImpl.java
 * @Description:   用户钱包
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月27日 上午11:53:39 
 */
public class UserPurseServiceImpl implements UserPurseService{
	@Autowired
	private UserinfoMapperCustom userinfoMapperCustom;
	@Autowired
	private UserpurseMapperCustom userpurseMapperCustom;
	@Autowired
	private PayMapperCustom payMapperCustom;
	@Autowired
	private UserinfoMapper userinfoMapper;
	
	@Override
	public String getAliPayAccount(Integer userloginid) throws Exception {
		Userinfo userinfo = userinfoMapperCustom.selectByLoginId(userloginid);
		if (userinfo == null) {
			return DataResult.error("账户不存在");
		}
		return DataResult.success("获取成功", userinfo.getUseralipayaccount());
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
	public String listBalanceRecord(Integer userloginid,Integer page) throws Exception {
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = userpurseMapperCustom.selectByUserLoginId(userloginid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			return DataResult.success("获取数据成功", pageInfo.getList());
		} else {
			return DataResult.success("获取数据为空", null);
		}
		
	}
	@Override
	public String listTradeRecord(Integer userloginid,Integer page) throws Exception{
		PageHelper.startPage(page, 5);
		List<Map<String, Object>> list = payMapperCustom.selectByLoginIdAndType(userloginid, 1);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		if (pageInfo != null && !pageInfo.getList().isEmpty()) {
			return DataResult.success("获取数据成功", pageInfo.getList());
		} else {
			return DataResult.success("获取数据为空", null);
		}
	}
	//添加支付宝
		@Override
		public String addAliPayAccount(Integer userloginid ,String alipayaccount) throws Exception{
			Userinfo userinfo = userinfoMapperCustom.selectByLoginId(userloginid);
			if (userinfo==null) {
				return DataResult.error("账号不存在");
			}
			Userinfo record = new Userinfo();
			record.setUserid(userinfo.getUserid());
			record.setUseralipayaccount(alipayaccount);
			boolean result = userinfoMapper.updateByPrimaryKeySelective(record)>0;
			if (result) {
				return DataResult.success("添加成功");	
			} else {
				return DataResult.error("添加失败");
			}
			
		}
}
