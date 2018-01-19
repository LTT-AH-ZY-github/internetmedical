package com.medical.mapper;

import java.util.List;

import com.medical.po.City;


public interface CityMapperCustom {
    
	/**
     * @Title: selectByParentCode
     * @Description: 医院端根据父id获取城市
     * @param code
     * @return
     * @return: List<City>
     */
    List<City> selectByParentCode(String code);
    //List<City> selectByLevel(int level);

	/**
	 * @Title: selectByCityName
	 * @Description: TODO
	 * @param name
	 * @return
	 * @return: City
	 */
	List<City> selectByCityName(String name);
   
}