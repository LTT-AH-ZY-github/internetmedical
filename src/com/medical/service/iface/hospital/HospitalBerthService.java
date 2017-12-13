/**  
* @Title: HospitalBerthService.java  
* @Package com.medical.service.iface.hospital  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月11日  
* @version V1.0  
*/  
package com.medical.service.iface.hospital;

import com.medical.po.Hospitalberth;

/**
 * @ClassName:     HospitalBerthService.java
 * @Description:   医院床位管理接口
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月11日 下午7:19:12 
 */
public interface HospitalBerthService {

	/**
	 * @Title: getBerthNum
	 * @Description: 获取医院床位数
	 * @param hosploginid 医院登录id
	 * @return
	 * @return: String
	 */
	String getBerthNum(Integer hosploginid) throws Exception;

	/**
	 * @Title: getOneBerthNum
	 * @Description: 获取医院指定部门床位数
	 * @param hosploginid
	 * @param hospberthdeptid
	 * @return
	 * @return: String
	 */
	String getOneBerthNum(Integer hosploginid, Integer hospberthdeptid) throws Exception;

	/**
	 * @Title: addHospBerth
	 * @Description: 增加部门
	 * @param hospitalberth
	 * @return
	 * @return: String
	 */
	String addHospBerth(Hospitalberth hospitalberth) throws Exception;

	/**
	 * @Title: deleteHospBerth
	 * @Description: 删除床位
	 * @param hosploginid
	 * @param hospberthid
	 * @return
	 * @return: String
	 */
	String deleteHospBerth(Integer hosploginid, Integer hospberthid) throws Exception; 

}
