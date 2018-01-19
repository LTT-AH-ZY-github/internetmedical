/**  
* @Title: AbnormalOrderServiceImpl.java  
* @Package com.medical.service.impl  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2018年1月18日  
* @version V1.0  
*/  
package com.medical.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.medical.mapper.AbnormalorderMapper;
import com.medical.po.Abnormalorder;
import com.medical.service.iface.AbnormalOrderService;


/**
 * @ClassName:     AbnormalOrderServiceImpl.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2018年1月18日 下午3:45:05 
 */
public class AbnormalOrderServiceImpl implements AbnormalOrderService {
	@Autowired
	private AbnormalorderMapper abnormalorderMapper;
	
	@Override
	public boolean addAbnormalOrder(Integer abnormalorderid,Integer abnormalordertype, Integer abnormalorderpayid,String abnormalorderreason) {
		Abnormalorder abnormalorder = new Abnormalorder();
		abnormalorder.setAbnormalordercreattime(new Date());
		abnormalorder.setAbnormalorderid(abnormalorderid);
		abnormalorder.setAbnormalorderissolve(false);
		abnormalorder.setAbnormalorderreason(abnormalorderreason);
		abnormalorder.setAbnormalordertype(abnormalordertype);
		abnormalorder.setAbnormalorderpayid(abnormalorderpayid);
		return abnormalorderMapper.insertSelective(abnormalorder)>0;
	}
	@Override
	public boolean updateAbnormalOrderToEnd(Integer id) {
		Abnormalorder abnormalorder = new Abnormalorder();
		abnormalorder.setId(id);
		abnormalorder.setAbnormalorderendtime(new Date());
		abnormalorder.setAbnormalorderissolve(true);
		return abnormalorderMapper.updateByPrimaryKeySelective(abnormalorder)>0;
	}
	
}
