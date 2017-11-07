package com.medical.mapper;

import com.medical.po.DoctorCustom;
import com.medical.po.Familyinfo;
import com.medical.po.FamilyinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FamilyinfoMapperCustom {
    
    int insertReturnId(Familyinfo record);
    List<Familyinfo> findByUserLoginId(int userLoginId);
    List<Familyinfo>  selectByUserLoginIdAndType(int userLoginId,int familyType);
    List<Familyinfo> selectByUserLoginIdAndInfo(Familyinfo familyinfo);
}