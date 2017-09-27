package com.medical.mapper;

import com.medical.po.City;
import com.medical.po.CityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityMapperCustom {
    
	
    List<City> selectByParentCode(String code);
    List<City> selectByLevel(int level);
   
}