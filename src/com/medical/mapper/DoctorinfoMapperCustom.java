package com.medical.mapper;



import java.util.List;
import java.util.Map;
import com.medical.po.DoctorSearch;
import com.medical.po.Doctorinfo;
import com.medical.po.HospSearchDocTerm;
import com.medical.po.custom.HospSearchDoc;




/**
 * @ClassName:     DoctorinfoMapperCustom.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年12月5日 下午2:52:24 
 */
public interface DoctorinfoMapperCustom {
    
	List<Map<String, Object>> selectAllDoctorInAdmin();
	/**
	 * @Title: selectByDocLoginId
	 * @Description: 根据登录Id查询医生
	 * @param docloginid
	 * @return
	 * @return: Doctorinfo
	 */
	Doctorinfo selectByDocLoginId(Integer docloginid);
	
	/**
	 * @Title: findDoctorsInList
	 * @Description: 病人端医生信息列表模式
	 * @param map
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	List<Map<String, Object>> findDoctorsInList(Map<String, Object> map);
	
	/**
	 * @Title: findDoctorInfoInMap
	 * @Description: 病人端医生信息地图模式
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @param arg4
	 * @return
	 * @throws Exception
	 * @return: List<Map<String,Object>>
	 */
	List<Map<String, Object>> findDoctorInfoInMap(double arg1,double arg2,double arg3,double arg4)throws Exception;
	
	/**
	 * @Title: selectByDept
	 * @Description: 病人端推荐医生根据部门获取医生
	 * @param docPrimaryDept
	 * @param docSecondDept
	 * @return
	 * @return: List<Doctorinfo>
	 */
	List<Doctorinfo> selectByDept(String docPrimaryDept,String docSecondDept );
	
	/**
	 * @Title: findDoctorByDocLoginId
	 * @Description: 病人端获取医生详细信息
	 * @param docloginid
	 * @return
	 * @return: Map<String,Object>
	 */
	Map<String, Object> findDoctorByDocLoginId(Integer docloginid);
	
	//List<Map<String, Object>> findDoctorByInfo(DoctorSearch doctorSearch);
	
	/**
	 * @Title: selectFirstInfoByDocLoginId
	 * @Description: 医生端查询自己第一页信息
	 * @param id
	 * @return
	 * @return: Map<String,Object>
	 */
	Map<String, Object> selectFirstInfoByDocLoginId(Integer id);
	
	/**
	 * @Title: selectSecondInfoByDocLoginId
	 * @Description: 医生端查询自己第二页信息
	 * @param id
	 * @return
	 * @return: Map<String,Object>
	 */
	Map<String, Object> selectSecondInfoByDocLoginId(Integer id);
	
	/**
	 * @Title: selectByName
	 * @Description:医生端根据医生姓名获取医生
	 * @param docname
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	List<Map<String, Object>> selectByName(String docname);
	
	/**
	 * @Title: updateInfoByPrimaryKey
	 * @Description: 医生端更新接诊地址位置信息
	 * @param doctorinfo
	 * @return
	 * @return: int
	 */
	int updateInfoByPrimaryKey(Doctorinfo doctorinfo);
	
	
	//Map<String, Object> selectNameAndTitleByDocLoginId(Integer id);
	
	/**
	 * @Title: paginationDoctorListInHosp
	 * @Description: 医院端获取医生
	 * @param hospSearchDocTerm
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	List<Map<String, Object>> paginationDoctorListInHosp(HospSearchDoc hospSearchDoc);
	
	
	
	
	
	/**
	 * @Title: selectInfoByDocLoginIdInAdmin
	 * @Description: 管理员获取医生详细信息
	 * @param docloginid 医生登录id
	 * @return
	 * @return: Map<String,Object>
	 */
	Map<String, Object>selectInfoByDocLoginIdInAdmin(Integer docloginid);
	/**
	 * @Title: selectByParamsInAdmin
	 * @Description: TODO
	 * @param map
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	List<Map<String, Object>> selectByParamsInAdmin(Map<String, Object> map);
	
}