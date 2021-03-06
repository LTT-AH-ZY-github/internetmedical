/**  
* @Title: CommonTradeService.java  
* @Package com.medical.service.iface  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月15日  
* @version V1.0  
*/  
package com.medical.service.iface;

import java.util.HashMap;
import java.util.Map;

import com.medical.po.Userlogininfo;

/**
 * @ClassName:     CommonTradeService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月15日 下午3:11:10 
 */
public interface CommonTradeService {

	/**
	 * @Title: queryUserFundForUpdate
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: boolean
	 */
	boolean queryUserFundForUpdate(Integer id);

	/**
	 * @Title: queryUserFundForFinish
	 * @Description: TODO
	 * @param id
	 * @return: void
	 */
	void queryUserFundForFinish(Integer id);

	/**
	 * @Title: queryDoctorFundForUpdate
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: boolean
	 */
	boolean queryDoctorFundForUpdate(Integer id);

	/**
	 * @Title: queryDoctorFundForFinish
	 * @Description: TODO
	 * @param id
	 * @return: void
	 */
	void queryDoctorFundForFinish(Integer id);

	/**
	 * @Title: queryHospitalFundForUpdate
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: boolean
	 */
	boolean queryHospitalFundForUpdate(Integer id);

	/**
	 * @Title: queryHospitalFundForFinish
	 * @Description: TODO
	 * @param id
	 * @return: void
	 */
	void queryHospitalFundForFinish(Integer id);

	/**
	 * @Title: queryUserOrderForCreat
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: boolean
	 */
	boolean queryUserOrderForCreat(Integer id);

	/**
	 * @Title: queryUserOrderIsExit
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: boolean
	 */
	boolean queryUserOrderIsExit(Integer id);

	/**
	 * @Title: queryUserOrderForFinish
	 * @Description: TODO
	 * @param id
	 * @return: void
	 */
	void queryUserOrderForFinish(Integer id);

	/**
	 * @Title: queryHospitalOrderForCreat
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: boolean
	 */
	boolean queryHospitalOrderForCreat(Integer id);

	/**
	 * @Title: queryHospitalOrderIsExit
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: boolean
	 */
	boolean queryHospitalOrderIsExit(Integer id);

	/**
	 * @Title: queryHospitalOrderForFinish
	 * @Description: TODO
	 * @param id
	 * @return: void
	 */
	void queryHospitalOrderForFinish(Integer id);

	
	
}
