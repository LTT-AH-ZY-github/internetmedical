package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

public class Doctorpurse {
    private Integer docpurseid;

    private Integer docpursetypeid;

    private BigDecimal docpurseamount;

    private Date docpursetime;

    private String docpurseremark;

    private Integer payid;

    private BigDecimal docpursebalance;

    private Integer docloginid;

    public Integer getDocpurseid() {
        return docpurseid;
    }

    public void setDocpurseid(Integer docpurseid) {
        this.docpurseid = docpurseid;
    }

    public Integer getDocpursetypeid() {
        return docpursetypeid;
    }

    public void setDocpursetypeid(Integer docpursetypeid) {
        this.docpursetypeid = docpursetypeid;
    }

    public BigDecimal getDocpurseamount() {
        return docpurseamount;
    }

    public void setDocpurseamount(BigDecimal docpurseamount) {
        this.docpurseamount = docpurseamount;
    }

    public Date getDocpursetime() {
        return docpursetime;
    }

    public void setDocpursetime(Date docpursetime) {
        this.docpursetime = docpursetime;
    }

    public String getDocpurseremark() {
        return docpurseremark;
    }

    public void setDocpurseremark(String docpurseremark) {
        this.docpurseremark = docpurseremark == null ? null : docpurseremark.trim();
    }

    public Integer getPayid() {
        return payid;
    }

    public void setPayid(Integer payid) {
        this.payid = payid;
    }

    public BigDecimal getDocpursebalance() {
        return docpursebalance;
    }

    public void setDocpursebalance(BigDecimal docpursebalance) {
        this.docpursebalance = docpursebalance;
    }

    public Integer getDocloginid() {
        return docloginid;
    }

    public void setDocloginid(Integer docloginid) {
        this.docloginid = docloginid;
    }
}