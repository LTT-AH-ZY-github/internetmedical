package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

public class Hosptitaldeposit {
    private Integer hospdepositid;

    private BigDecimal hospdepositnum;

    private String hospdepositremark;

    private Date hospdeposittime;

    private Integer hosploginid;

    private Integer userloginid;

    public Integer getHospdepositid() {
        return hospdepositid;
    }

    public void setHospdepositid(Integer hospdepositid) {
        this.hospdepositid = hospdepositid;
    }

    public BigDecimal getHospdepositnum() {
        return hospdepositnum;
    }

    public void setHospdepositnum(BigDecimal hospdepositnum) {
        this.hospdepositnum = hospdepositnum;
    }

    public String getHospdepositremark() {
        return hospdepositremark;
    }

    public void setHospdepositremark(String hospdepositremark) {
        this.hospdepositremark = hospdepositremark == null ? null : hospdepositremark.trim();
    }

    public Date getHospdeposittime() {
        return hospdeposittime;
    }

    public void setHospdeposittime(Date hospdeposittime) {
        this.hospdeposittime = hospdeposittime;
    }

    public Integer getHosploginid() {
        return hosploginid;
    }

    public void setHosploginid(Integer hosploginid) {
        this.hosploginid = hosploginid;
    }

    public Integer getUserloginid() {
        return userloginid;
    }

    public void setUserloginid(Integer userloginid) {
        this.userloginid = userloginid;
    }
}