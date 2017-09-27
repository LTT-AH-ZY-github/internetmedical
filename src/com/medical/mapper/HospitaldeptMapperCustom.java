package com.medical.mapper;

import java.util.List;

import com.medical.po.Hospitaldept;

public interface HospitaldeptMapperCustom {
   

	List<Hospitaldept> selectByFatherId(int id);
	List<Hospitaldept> selectAll();

}