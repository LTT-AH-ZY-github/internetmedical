package com.medical.service.iface.doctor;

import java.math.BigDecimal;

public interface DoctorConsultationService {
	/**
	 * 获取会诊
	 * @param
	 * @return
	 * 
	 * */
	String listConsultation(Integer docloginid, Integer type, Integer page)throws Exception;
	/**
	 * 获取会诊详情
	 * @param
	 * @return
	 * @throws Exception 
	 * 
	 * */
	String listConsultationDetail(Integer docloginid, Integer hosporderid) throws Exception;
	/**
	 * 确认会诊
	 * @param
	 * @return
	 * @throws Exception 
	 * 
	 * */
	String updateConsultationToConfirm(Integer docloginid, Integer hosporderid, BigDecimal orderdoctorprice,
			Integer orderdoctortpricetype, BigDecimal orderdoctortprice, Integer orderdoctorapricetype,
			BigDecimal orderdoctoraprice, Integer orderdoctorepricetype, BigDecimal orderdoctoreprice) throws Exception;
	/**
	 * 取消会诊
	 * @param
	 * @return
	 * @throws Exception 
	 * 
	 * */
	String updateConsultationToCancel(Integer docloginid, Integer hosporderid) throws Exception;
}
