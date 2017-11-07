package com.medical.service.iface.hospital;

import java.util.Map;

public interface HospitalOrderService {

	

	boolean confirmUserOrder(Integer hosploginid, Integer userorderid, Double userorderdeposit,
			String userorderhospprimarydept, String userorderhospseconddept) throws Exception;

	boolean refuseUserOrder(Integer hosploginid, Integer userorderid) throws Exception;

}
