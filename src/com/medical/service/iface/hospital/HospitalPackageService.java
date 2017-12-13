/**  
* @Title: HospitalPackageService.java  
* @Package com.medical.service.iface.hospital  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月11日  
* @version V1.0  
*/  
package com.medical.service.iface.hospital;

import com.medical.po.Hospitalpackage;

/**
 * @ClassName:     HospitalPackageService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月11日 下午8:28:50 
 */
public interface HospitalPackageService {

	/**
	 * @Title: addPackage
	 * @Description: TODO
	 * @param hospitalpackage
	 * @return
	 * @return: String
	 */
	String addPackage(Hospitalpackage hospitalpackage);

	/**
	 * @Title: listPackages
	 * @Description: TODO
	 * @param hosploginid
	 * @param limit
	 * @param offset
	 * @return
	 * @return: String
	 */
	String listPackages(Integer hosploginid, Integer limit, Integer offset);

	/**
	 * @Title: editPackage
	 * @Description: TODO
	 * @param hospitalpackage
	 * @return
	 * @return: String
	 */
	String editPackage(Hospitalpackage hospitalpackage);

	/**
	 * @Title: deletePackage
	 * @Description: TODO
	 * @param hosploginid
	 * @param packageid
	 * @return
	 * @return: String
	 */
	String deletePackage(Integer hosploginid, Integer packageid);

}
