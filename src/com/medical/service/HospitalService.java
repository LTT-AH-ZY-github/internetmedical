package com.medical.service;

import java.util.List;
import java.util.Map;

import com.medical.po.DoctorCustom;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorinfo;
import com.medical.po.DoctorinfoCustom;
import com.medical.po.Doctortitle;
import com.medical.po.HospSearchDocTerm;
import com.medical.po.Hospitaldept;



public interface HospitalService {

	//查询医院部门
	List<Hospitaldept>  findDept(int id) throws Exception;
	
	//医院获取医生
	
	Map<String, Object> listDoctor(Integer pageNo, Integer pageSize, HospSearchDocTerm hospSearchDocTerm)
			throws Exception;

	String preorderrequest(Integer docloginid, Integer hosploginid, Double orderhospprice, Integer orderhosptpricetype, Double orderhosptprice, Integer orderhospapricetype, Double orderhospaprice, Integer orderhospepricetype, Double orderhospeprice) throws Exception;
	//医院获取需要住院的病人订单
	Map<String, Object> listUserOrder(Integer hosploginid, Integer type, Integer limit, Integer offset);
	//医院确认需要住院的病人订单
	

	Map<String, Object> confirmUserOrder(Integer hosploginid, Integer userorderid, Double userorderdeposit);

	
}
