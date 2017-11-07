package com.medical.po;

import java.util.Date;

public class Hospitalcomment {
    private Integer hospcommentid;

    private Integer hospcommentfatherid;

    private Integer hospcommentgrade;

    private Integer hospcommentservicelevel;

    private Integer hospcommentenvironmenlevel;

    private Integer hospcommentpricelevel;

    private String hospcommentwords;

    private Integer hosploginid;

    private Integer userorderid;

    private Integer userloginid;

    private Date hospcommenttime;

    public Integer getHospcommentid() {
        return hospcommentid;
    }

    public void setHospcommentid(Integer hospcommentid) {
        this.hospcommentid = hospcommentid;
    }

    public Integer getHospcommentfatherid() {
        return hospcommentfatherid;
    }

    public void setHospcommentfatherid(Integer hospcommentfatherid) {
        this.hospcommentfatherid = hospcommentfatherid;
    }

    public Integer getHospcommentgrade() {
        return hospcommentgrade;
    }

    public void setHospcommentgrade(Integer hospcommentgrade) {
        this.hospcommentgrade = hospcommentgrade;
    }

    public Integer getHospcommentservicelevel() {
        return hospcommentservicelevel;
    }

    public void setHospcommentservicelevel(Integer hospcommentservicelevel) {
        this.hospcommentservicelevel = hospcommentservicelevel;
    }

    public Integer getHospcommentenvironmenlevel() {
        return hospcommentenvironmenlevel;
    }

    public void setHospcommentenvironmenlevel(Integer hospcommentenvironmenlevel) {
        this.hospcommentenvironmenlevel = hospcommentenvironmenlevel;
    }

    public Integer getHospcommentpricelevel() {
        return hospcommentpricelevel;
    }

    public void setHospcommentpricelevel(Integer hospcommentpricelevel) {
        this.hospcommentpricelevel = hospcommentpricelevel;
    }

    public String getHospcommentwords() {
        return hospcommentwords;
    }

    public void setHospcommentwords(String hospcommentwords) {
        this.hospcommentwords = hospcommentwords == null ? null : hospcommentwords.trim();
    }

    public Integer getHosploginid() {
        return hosploginid;
    }

    public void setHosploginid(Integer hosploginid) {
        this.hosploginid = hosploginid;
    }

    public Integer getUserorderid() {
        return userorderid;
    }

    public void setUserorderid(Integer userorderid) {
        this.userorderid = userorderid;
    }

    public Integer getUserloginid() {
        return userloginid;
    }

    public void setUserloginid(Integer userloginid) {
        this.userloginid = userloginid;
    }

    public Date getHospcommenttime() {
        return hospcommenttime;
    }

    public void setHospcommenttime(Date hospcommenttime) {
        this.hospcommenttime = hospcommenttime;
    }
}