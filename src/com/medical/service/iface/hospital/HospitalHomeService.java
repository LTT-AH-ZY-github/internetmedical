package com.medical.service.iface.hospital;

import java.util.Map;

import com.github.pagehelper.PageInfo;

public interface HospitalHomeService {



	/**
	 * @Title: listCity
	 * @Description: TODO
	 * @param cityparentcode
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listCity(String cityparentcode) throws Exception;

	/**
	 * @Title: listDept
	 * @Description: TODO
	 * @param hospdeptfatherid
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listDept(Integer hospdeptfatherid) throws Exception;

	/**
	 * @Title: listHospLevel
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	String listHospLevel() throws Exception;

	/**
	 * @Title: listDoctorTitle
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	String listDoctorTitle() throws Exception;

	

	

	

}
