package com.medical.mapper;

import com.medical.po.Doctorskd;


public interface DoctorskdMapperCustom {
    
    Doctorskd selectByDocLoginId(Integer id);

    
}