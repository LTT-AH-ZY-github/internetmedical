package com.medical.po;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.medical.controller.validation.Add;
import com.medical.controller.validation.Update;

public class Hospitalberth {
	@NotNull(message="床位id为空",groups= {Update.class})
    private Integer hospberthid;
    @NotNull(message="部门id为空",groups= {Add.class})
    private Integer hospberthdeptid;
    @NotBlank(message="床位名为空",groups= {Add.class})
    private String hospberthname;

    private String hospberthabs;
    @NotNull(message="医院登录id为空",groups= {Add.class,Update.class})
    private Integer hosploginid;

    public Integer getHospberthid() {
        return hospberthid;
    }

    public void setHospberthid(Integer hospberthid) {
        this.hospberthid = hospberthid;
    }

    public Integer getHospberthdeptid() {
        return hospberthdeptid;
    }

    public void setHospberthdeptid(Integer hospberthdeptid) {
        this.hospberthdeptid = hospberthdeptid;
    }

    public String getHospberthname() {
        return hospberthname;
    }

    public void setHospberthname(String hospberthname) {
        this.hospberthname = hospberthname == null ? null : hospberthname.trim();
    }

    public String getHospberthabs() {
        return hospberthabs;
    }

    public void setHospberthabs(String hospberthabs) {
        this.hospberthabs = hospberthabs == null ? null : hospberthabs.trim();
    }

    public Integer getHosploginid() {
        return hosploginid;
    }

    public void setHosploginid(Integer hosploginid) {
        this.hosploginid = hosploginid;
    }
}