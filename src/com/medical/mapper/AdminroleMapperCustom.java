package com.medical.mapper;

import com.medical.po.Adminrole;
import com.medical.po.AdminroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminroleMapperCustom {
    

    List<Adminrole> selectAll();

    
}