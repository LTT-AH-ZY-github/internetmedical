package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

public class Refundrate {
    private Integer id;

    private BigDecimal docfefundrate;

    private BigDecimal hospfefundrate;

    private Integer adminloginid;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getDocfefundrate() {
        return docfefundrate;
    }

    public void setDocfefundrate(BigDecimal docfefundrate) {
        this.docfefundrate = docfefundrate;
    }

    public BigDecimal getHospfefundrate() {
        return hospfefundrate;
    }

    public void setHospfefundrate(BigDecimal hospfefundrate) {
        this.hospfefundrate = hospfefundrate;
    }

    public Integer getAdminloginid() {
        return adminloginid;
    }

    public void setAdminloginid(Integer adminloginid) {
        this.adminloginid = adminloginid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}