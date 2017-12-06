package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

public class Hosppurse {
    private Integer hosppurseid;

    private Integer hosppursetypeid;

    private BigDecimal hosppurseamount;

    private Date hosppursetime;

    private String hosppurseremark;

    private Integer payid;

    private BigDecimal hosppursebalance;

    private Integer hosploginid;

    public Integer getHosppurseid() {
        return hosppurseid;
    }

    public void setHosppurseid(Integer hosppurseid) {
        this.hosppurseid = hosppurseid;
    }

    public Integer getHosppursetypeid() {
        return hosppursetypeid;
    }

    public void setHosppursetypeid(Integer hosppursetypeid) {
        this.hosppursetypeid = hosppursetypeid;
    }

    public BigDecimal getHosppurseamount() {
        return hosppurseamount;
    }

    public void setHosppurseamount(BigDecimal hosppurseamount) {
        this.hosppurseamount = hosppurseamount;
    }

    public Date getHosppursetime() {
        return hosppursetime;
    }

    public void setHosppursetime(Date hosppursetime) {
        this.hosppursetime = hosppursetime;
    }

    public String getHosppurseremark() {
        return hosppurseremark;
    }

    public void setHosppurseremark(String hosppurseremark) {
        this.hosppurseremark = hosppurseremark == null ? null : hosppurseremark.trim();
    }

    public Integer getPayid() {
        return payid;
    }

    public void setPayid(Integer payid) {
        this.payid = payid;
    }

    public BigDecimal getHosppursebalance() {
        return hosppursebalance;
    }

    public void setHosppursebalance(BigDecimal hosppursebalance) {
        this.hosppursebalance = hosppursebalance;
    }

    public Integer getHosploginid() {
        return hosploginid;
    }

    public void setHosploginid(Integer hosploginid) {
        this.hosploginid = hosploginid;
    }
}