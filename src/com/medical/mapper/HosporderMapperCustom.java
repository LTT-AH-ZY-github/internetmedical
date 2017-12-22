package com.medical.mapper;

import com.medical.po.Hosporder;
import com.medical.po.HosporderExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @ClassName:     HosporderMapperCustom.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月28日 下午3:58:27 
 */
public interface HosporderMapperCustom {
	/**
	 * 医生获取不同类型的会诊订单
	 * 
	 * @return
	 * @param
	 * 
	 * */
	List<Map<String, Object>>listByDocLoginIdAndType(Integer docloginid, Integer type);
	/**
	 * 按医生和订单id查询会诊详情
	 * 
	 * @return
	 * @param
	 * 
	 * */
	Map<String, Object> selectAllInfoByDocLoginIdAndHospOrderId(Integer docloginid, Integer hosporderid);
	
	List<Map<String, Object>> selectByHospLoginId(Integer hosploginid, Integer type);
	
	int insertSelectiveReturnId(Hosporder record);
}