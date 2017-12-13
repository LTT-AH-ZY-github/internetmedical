package com.medical.mapper;

import com.medical.po.Hospitalberth;
import com.medical.po.HospitalberthExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @ClassName:     HospitalberthMapperCustom.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月11日 下午7:57:37 
 */
public interface HospitalberthMapperCustom {
	
	
	/**
	 * @Title: selectCountByHospLoginIdAndHospDerthDeptId
	 * @Description: 获取床位数
	 * @param hospberthdeptid 部门id
	 * @param hosploginid 医院登录id
	 * @return
	 * @return: int
	 */
	int selectCountByHospLoginIdAndHospDerthDeptId(Integer hospberthdeptid,Integer hosploginid);
	
	/**
	 * @Title: selectBerthCountByHospLoginId
	 * @Description: 获取床位数
	 * @param hosploginid 医生登录id
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	List<Map<String, Object>> selectBerthCountByHospLoginId(Integer hosploginid);
	
	/**
	 * @Title: selectByHospLoginIdAndHospDerthDeptId
	 * @Description: 获取床位记录
	 * @param hospberthdeptid 部门id
	 * @param hosploginid 医生登录id
	 * @return
	 * @return: List<Hospitalberth>
	 */
	List<Hospitalberth> selectByHospLoginIdAndHospDerthDeptId(Integer hospberthdeptid,Integer hosploginid);

	/**
	 * @Title: insertSelectiveReturnId
	 * @Description: TODO
	 * @param hospitalberth
	 * @return
	 * @return: int
	 */
	int insertSelectiveReturnId(Hospitalberth hospitalberth);
}