package com.medical.service.iface;

/**
 * @ClassName:     AbnormalOrderService.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2018年1月18日 下午3:44:22 
 */
public interface AbnormalOrderService {

	/**
	 * @Title: addAbnormalOrder
	 * @Description: TODO
	 * @param abnormalorderid
	 * @param abnormalordertype
	 * @param abnormalorderpayid
	 * @param abnormalorderreason
	 * @return
	 * @return: boolean
	 */
	boolean addAbnormalOrder(Integer abnormalorderid, Integer abnormalordertype, Integer abnormalorderpayid,
			String abnormalorderreason);

	/**
	 * @Title: updateAbnormalOrderToEnd
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: boolean
	 */
	boolean updateAbnormalOrderToEnd(Integer id);

}
