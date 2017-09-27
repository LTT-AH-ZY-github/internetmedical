package com.medical.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.medical.mapper.DoctorinfoMapperCustom;
import com.medical.mapper.DoctortitleMapper;
import com.medical.mapper.HospitaldeptMapper;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.po.DoctorinfoCustom;
import com.medical.po.Doctortitle;
import com.medical.po.HospSearchDocTerm;
import com.medical.po.Hospitaldept;
import com.medical.service.DoctorService;
import com.medical.service.HospitalService;

public class HospitalServiceImpl implements HospitalService{
	@Autowired 
	private HospitaldeptMapperCustom hospitaldeptMapperCustom;
	@Autowired
	private DoctortitleMapper doctortitleMapper;
	@Autowired
	private DoctorinfoMapperCustom doctorinfoMapperCustom;
	
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
	
	

	
	
	
}
