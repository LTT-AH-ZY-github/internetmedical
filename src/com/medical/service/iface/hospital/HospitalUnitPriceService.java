/**  
* @Title: HospitalUnitPriceService.java  
* @Package com.medical.service.iface.hospital  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月11日  
* @version V1.0  
*/  
package com.medical.service.iface.hospital;

import com.medical.po.Hospitalunitprice;

/**
 * @ClassName:     HospitalUnitPriceService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月11日 下午5:03:04 
 */
public interface HospitalUnitPriceService {

	/**
	 * @Title: creatUnitPrice
	 * @Description: TODO
	 * @param hospitalunitprice
	 * @return
	 * @return: String
	 */
	String creatUnitPrice(Hospitalunitprice hospitalunitprice) throws Exception;

	/**
	 * @Title: listUnitPrice
	 * @Description: TODO
	 * @param hosploginid
	 * @param offset 
	 * @param limit 
	 * @return
	 * @return: String
	 */
	String listUnitPrice(Integer hosploginid, Integer limit, Integer offset) throws Exception;

	/**
	 * @Title: updateUnitPrice
	 * @Description: TODO
	 * @param hospitalunitprice
	 * @return
	 * @return: String
	 */
	String updateUnitPrice(Hospitalunitprice hospitalunitprice) throws Exception; 

	/**
	 * @Title: deleteUnitPrice
	 * @Description: TODO
	 * @param hosploginid
	 * @param unitpriceid
	 * @return
	 * @return: String
	 */
	String deleteUnitPrice(Integer hosploginid, Integer unitpriceid) throws Exception;

}
