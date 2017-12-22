/**  
* @Title: RecommendDoctorService.java  
* @Package com.medical.service.iface  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xyh  
* @date 2017年12月21日  
* @version V1.0  
*/  
package com.medical.service.iface;

/**
 * @ClassName:     RecommendDoctorService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月21日 下午6:33:31 
 */
public interface RecommendDoctorService {

	/**
	 * @Title: addRecommendDoctors
	 * @Description: TODO
	 * @param usersickid
	 * @param userloginid
	 * @param keyWord
	 * @param primaryDept
	 * @param secondDept
	 * @throws Exception
	 * @return: void
	 */
	void addRecommendDoctors(Integer usersickid, Integer userloginid, String keyWord, String primaryDept,
			String secondDept) throws Exception;


	/**
	 * @Title: deleteRecommendDoctor
	 * @Description: TODO
	 * @param usersickid
	 * @param docloginid
	 * @param preordertype
	 * @return
	 * @throws Exception
	 * @return: boolean
	 */
	boolean deleteRecommendDoctor(Integer usersickid, Integer docloginid, Integer preordertype) throws Exception;

}
