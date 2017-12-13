package com.medical.mapper;

import java.util.List;
import java.util.Map;

import com.medical.po.Hospitaldept;

public interface HospitaldeptMapperCustom {
   

	List<Hospitaldept> selectByFatherId(int id);
	List<Hospitaldept> selectAll();
	List<Hospitaldept> selectByPrimaryDeptAndSecondDeptAndCheck(String primarydept,String seconddept,String check);
	int insertSelectiveReturnId(Hospitaldept hospitaldept);
	
	/**
	 * @Title: selectByCheck
	 * @Description: TODO
	 * @param check
	 * @param i
	 * @return
	 * @return: List<Hospitaldept>
	 */
	List<Map<String, Object>> selectByCheck(Integer check, Integer i);
	List<Map<String, Object>> selectFirstDept();
	List<Hospitaldept> selectByDeptNameAndFatherId(String deptname,String fatherid);
}