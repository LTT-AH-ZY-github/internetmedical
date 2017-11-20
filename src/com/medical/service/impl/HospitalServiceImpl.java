package com.medical.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.utils.PushToAndroid;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.exception.custom.MyException;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctorlogininfoMapper;
import com.medical.mapper.DoctortitleMapper;
import com.medical.mapper.HospinfoMapperCustom;
import com.medical.mapper.HospitaldeptMapper;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.mapper.HosplogininfoMapper;
import com.medical.mapper.HosporderMapper;
import com.medical.mapper.UserlogininfoMapper;
import com.medical.mapper.UserorderMapper;
import com.medical.mapper.UserorderMapperCustom;
import com.medical.po.Doctorinfo;
import com.medical.po.DoctorinfoCustom;
import com.medical.po.Doctorlogininfo;
import com.medical.po.Doctortitle;
import com.medical.po.HospSearchDocTerm;
import com.medical.po.Hospinfo;
import com.medical.po.Hospitaldept;
import com.medical.po.Hosplogininfo;
import com.medical.po.Hosporder;
import com.medical.po.Userlogininfo;
import com.medical.po.Userorder;
import com.medical.service.DoctorService;
import com.medical.service.HospitalService;
import com.medical.utils.result.DataResult;

public class HospitalServiceImpl implements HospitalService{
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
	
	Logger logger = Logger.getLogger(HospitalService.class);
	@Override
	public List<Hospitaldept> findDept(int id) throws Exception {
		try {
			List<Hospitaldept> list = hospitaldeptMapperCustom.selectByFatherId(id);
			return list;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@Override
	public Map<String, Object> listDoctor(Integer pageNo,Integer pageSize,HospSearchDocTerm hospSearchDocTerm)throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			pageNo = pageNo == null?1:pageNo;
		    pageSize = pageSize == null?3:pageSize;
		    PageHelper.startPage(pageNo, pageSize);
		    /*hospSearchDocTerm.setDoctorTitle(doctorTitle);
		    hospSearchDocTerm.setHospitalLevel(hospitalLevel);*/
		    List<Map<String, Object>> list = doctorinfoMapperCustom.paginationDoctorList(null);
		    //用PageInfo对结果进行包装
		    PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		    if (!list.isEmpty()) {
				map.put("state", "1");
				map.put("data", list);
				map.put("page", page);
			} else {
				map.put("state", "2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("医院获取医生出错"+e);
			map.put("state", "3");
			
		}
		return map;		
	}

	@Override
	public String preorderrequest(Integer docloginid, Integer hosploginid, Double orderhospprice,
			Integer orderhosptpricetype, Double orderhosptprice, Integer orderhospapricetype, Double orderhospaprice,
			Integer orderhospepricetype, Double orderhospeprice) throws Exception {
		Doctorlogininfo doc = doctorlogininfoMapper.selectByPrimaryKey(docloginid);
		if (doc == null) {
			return DataResult.error("创建会诊失败,因医生不存在");
		}
		Hosporder hosporder = new Hosporder();
		hosporder.setDoctorid(docloginid);
		hosporder.setHospid(hosploginid);
		hosporder.setOrderptime(new Date());
		hosporder.setOrderhospprice(new BigDecimal(orderhospprice));
		hosporder.setOrderhosptpricetype(orderhosptpricetype);
		double total = orderhospprice;
		if ("2".equals(orderhosptpricetype)) {
			hosporder.setOrderhosptprice(new BigDecimal(orderhosptprice));
			total += orderhosptprice;
		}
		hosporder.setOrderhospapricetype(orderhospapricetype);
		if ("2".equals(orderhospapricetype)) {
			hosporder.setOrderhospaprice(new BigDecimal(orderhospaprice));
			total += orderhospaprice;
		}
		hosporder.setOrderhospepricetype(orderhosptpricetype);
		if ("2".equals(orderhospepricetype)) {
			hosporder.setOrderhospeprice(new BigDecimal(orderhospeprice));
			total += orderhospeprice;
		}
		hosporder.setOrdertotalhospprice(new BigDecimal(total));
		int result = hosporderMapper.insertSelective(hosporder);
		if (result > 0) {
			Hospinfo hospinfo = hospinfoMapperCustom.selectByHospLoginId(hosploginid);
			String msg = hospinfo.getHospname() + "发送会诊请求";
			String channelid = doctorlogininfoMapper.selectByPrimaryKey(docloginid).getDocloginchannelid();
			boolean pushResult = PushToAndroid.pushMsgToSingleDevice(channelid, "等待确认", msg);
			if (pushResult) {
				return DataResult.success("创建会诊成功，且消息发送成功");
			} else {
				return DataResult.success("创建会诊成功，但消息发送失败");
			}
		} else {
			return DataResult.error("创建会诊失败");
		}

	}
	//医院获取需要住院的病人订单
	@Override
	public Map<String, Object> listUserOrder(Integer hosploginid, Integer type, Integer limit, Integer offset) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			 int pageNo = 1; 
			 if (offset!=0) {
				pageNo =  offset/limit+1;
			 }
			  PageHelper.startPage(pageNo, limit);
			 List<Map<String, Object>> list = userorderMapperCustom.listByHospLoginIdAnType(hosploginid,type);
			 //用PageInfo对结果进行包装
			 PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
			    if (pageInfo.getSize()!=0) {
					map.put("state", "1");
					Map<String, Object> data = new HashMap<String, Object>();
					data.put("rows", pageInfo.getList());
					//总共页数
					data.put("total", pageInfo.getTotal());
					map.put("data", data);
				} else {
					map.put("state", "2");
				}
			
		} catch (Exception e) {
			logger.error("医院获取需要住院的病人订单异常"+e);
			map.put("state", "3");
		}
		return map;
	}

	// 医院确认需要住院的病人订单
	@Override
	public Map<String, Object> confirmUserOrder(Integer hosploginid, Integer userorderid, Double userorderdeposit) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Userorder order = userorderMapper.selectByPrimaryKey(userorderid);
			if (order != null) {
				Integer stateid  = order.getUserorderstateid();
				if (stateid==5) {
					Userorder userorder = new Userorder();
					userorder.setUserorderid(userorderid);
					userorder.setUserorderdeposit(new BigDecimal(userorderdeposit));
					userorder.setUserorderstateid(6);
					int result = userorderMapper.updateByPrimaryKeySelective(userorder);
					if (result > 0) {
						map.put("state", "1");
					}else {
						map.put("state", "2");
					}
				} else {
					//该订单状态不支持确认
					map.put("state", "3");
				}
			}else {
				//该订单不存在
				map.put("state", "4");
			}
			
		} catch (Exception e) {
			logger.error(" 医院确认需要住院的病人订单异常"+e);
			map.put("state", "5");
		}
		return map;
	}
	
	

	
	
	
}
