package com.medical.service.impl.hospital;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medical.mapper.CityMapperCustom;
import com.medical.mapper.DoctortitleMapperCustom;
import com.medical.mapper.HospitaldeptMapperCustom;
import com.medical.mapper.HosplevelMapper;
import com.medical.mapper.HosplevelMapperCustom;
import com.medical.po.City;
import com.medical.po.Doctortitle;
import com.medical.po.Hospitaldept;
import com.medical.po.Hospitalunitprice;
import com.medical.po.Hosplevel;
import com.medical.service.iface.hospital.HospitalHomeService;
import com.medical.utils.result.DataResult;


public class HospitalHomeServiceImpl implements HospitalHomeService {
	@Autowired
	private HospitaldeptMapperCustom hospitaldeptMapperCustom;
	@Autowired
	private CityMapperCustom  CityMapperCustom;
	@Autowired
	private HosplevelMapperCustom  hosplevelMapperCustom;
	@Autowired
	private DoctortitleMapperCustom doctortitleMapperCustom;
	@Override
	public String listCity(String cityparentcode) throws Exception{
		List<City> list = CityMapperCustom.selectByParentCode(cityparentcode);
		return DataResult.success("获取数据成功", list);
	}
	@Override
	public String listDept(Integer hospdeptfatherid) throws Exception{
		List<Hospitaldept> list = hospitaldeptMapperCustom.selectByFatherId(hospdeptfatherid);
		return DataResult.success("获取数据成功", list);
	}
	@Override
	public String listHospLevel() throws Exception{
		List<Hosplevel> list = hosplevelMapperCustom.selectAll();
		return DataResult.success("获取数据成功", list);
	}
	@Override
	public String listDoctorTitle() throws Exception {
		List<Doctortitle> list = doctortitleMapperCustom.selectAll();
		return DataResult.success("获取数据成功", list);
	}
	
}
