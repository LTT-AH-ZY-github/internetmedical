package com.medical.mapper;

import com.medical.po.Doctorlogininfo;

public interface DoctorlogininfoMapperCustom {
    int findDocCountByPhone(String phone);
    Doctorlogininfo findDoctorByPP(String phone,String password);
    int insertSelectiveReturnId(Doctorlogininfo doctorlogininfo);
    Doctorlogininfo selectDoctorByPhone(String phone);

}