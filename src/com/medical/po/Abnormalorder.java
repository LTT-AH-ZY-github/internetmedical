package com.medical.po;

import java.util.Date;

public class Abnormalorder {
    private Integer id;

    private Integer abnormalorderid;

    private Integer abnormalorderpayid;

    private Integer abnormalordertype;

    private Date abnormalordercreattime;

    private Date abnormalorderendtime;

    private String abnormalorderreason;

    private Boolean abnormalorderissolve;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAbnormalorderid() {
        return abnormalorderid;
    }

    public void setAbnormalorderid(Integer abnormalorderid) {
        this.abnormalorderid = abnormalorderid;
    }

    public Integer getAbnormalorderpayid() {
        return abnormalorderpayid;
    }

    public void setAbnormalorderpayid(Integer abnormalorderpayid) {
        this.abnormalorderpayid = abnormalorderpayid;
    }

    public Integer getAbnormalordertype() {
        return abnormalordertype;
    }

    public void setAbnormalordertype(Integer abnormalordertype) {
        this.abnormalordertype = abnormalordertype;
    }

    public Date getAbnormalordercreattime() {
        return abnormalordercreattime;
    }

    public void setAbnormalordercreattime(Date abnormalordercreattime) {
        this.abnormalordercreattime = abnormalordercreattime;
    }

    public Date getAbnormalorderendtime() {
        return abnormalorderendtime;
    }

    public void setAbnormalorderendtime(Date abnormalorderendtime) {
        this.abnormalorderendtime = abnormalorderendtime;
    }

    public String getAbnormalorderreason() {
        return abnormalorderreason;
    }

    public void setAbnormalorderreason(String abnormalorderreason) {
        this.abnormalorderreason = abnormalorderreason == null ? null : abnormalorderreason.trim();
    }

    public Boolean getAbnormalorderissolve() {
        return abnormalorderissolve;
    }

    public void setAbnormalorderissolve(Boolean abnormalorderissolve) {
        this.abnormalorderissolve = abnormalorderissolve;
    }
}