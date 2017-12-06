package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

public class Userpurse {
    private Integer userpurseid;

    private Integer userpursetypeid;

    private BigDecimal userpurseamount;

    private Date userpursetime;

    private String userpurseremark;

    private Integer payid;

    private BigDecimal userpursebalance;

    private Integer userloginid;

    public Integer getUserpurseid() {
        return userpurseid;
    }

    public void setUserpurseid(Integer userpurseid) {
        this.userpurseid = userpurseid;
    }

    public Integer getUserpursetypeid() {
        return userpursetypeid;
    }

    public void setUserpursetypeid(Integer userpursetypeid) {
        this.userpursetypeid = userpursetypeid;
    }

    public BigDecimal getUserpurseamount() {
        return userpurseamount;
    }

    public void setUserpurseamount(BigDecimal userpurseamount) {
        this.userpurseamount = userpurseamount;
    }

    public Date getUserpursetime() {
        return userpursetime;
    }

    public void setUserpursetime(Date userpursetime) {
        this.userpursetime = userpursetime;
    }

    public String getUserpurseremark() {
        return userpurseremark;
    }

    public void setUserpurseremark(String userpurseremark) {
        this.userpurseremark = userpurseremark == null ? null : userpurseremark.trim();
    }

    public Integer getPayid() {
        return payid;
    }

    public void setPayid(Integer payid) {
        this.payid = payid;
    }

    public BigDecimal getUserpursebalance() {
        return userpursebalance;
    }

    public void setUserpursebalance(BigDecimal userpursebalance) {
        this.userpursebalance = userpursebalance;
    }

    public Integer getUserloginid() {
        return userloginid;
    }

    public void setUserloginid(Integer userloginid) {
        this.userloginid = userloginid;
    }
}