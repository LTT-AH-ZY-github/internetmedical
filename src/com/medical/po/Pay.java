package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

public class Pay {
    private Integer payid;

    private Integer payorderid;

    private String paytradeno;

    private String payalipaytradeno;

    private String paywxtradeno;

    private BigDecimal paytotalamount;

    private BigDecimal payreceiptamount;

    private Date paycreattime;

    private Date payendtime;

    private Integer paysenderid;

    private Integer payreceiverid;

    private String payreceivername;

    private Integer paytypeid;

    private Integer paystateid;

    private Integer paymodeid;

    private String payremark;

    private String paysendername;

    private String payinfo;

    public Integer getPayid() {
        return payid;
    }

    public void setPayid(Integer payid) {
        this.payid = payid;
    }

    public Integer getPayorderid() {
        return payorderid;
    }

    public void setPayorderid(Integer payorderid) {
        this.payorderid = payorderid;
    }

    public String getPaytradeno() {
        return paytradeno;
    }

    public void setPaytradeno(String paytradeno) {
        this.paytradeno = paytradeno == null ? null : paytradeno.trim();
    }

    public String getPayalipaytradeno() {
        return payalipaytradeno;
    }

    public void setPayalipaytradeno(String payalipaytradeno) {
        this.payalipaytradeno = payalipaytradeno == null ? null : payalipaytradeno.trim();
    }

    public String getPaywxtradeno() {
        return paywxtradeno;
    }

    public void setPaywxtradeno(String paywxtradeno) {
        this.paywxtradeno = paywxtradeno == null ? null : paywxtradeno.trim();
    }

    public BigDecimal getPaytotalamount() {
        return paytotalamount;
    }

    public void setPaytotalamount(BigDecimal paytotalamount) {
        this.paytotalamount = paytotalamount;
    }

    public BigDecimal getPayreceiptamount() {
        return payreceiptamount;
    }

    public void setPayreceiptamount(BigDecimal payreceiptamount) {
        this.payreceiptamount = payreceiptamount;
    }

    public Date getPaycreattime() {
        return paycreattime;
    }

    public void setPaycreattime(Date paycreattime) {
        this.paycreattime = paycreattime;
    }

    public Date getPayendtime() {
        return payendtime;
    }

    public void setPayendtime(Date payendtime) {
        this.payendtime = payendtime;
    }

    public Integer getPaysenderid() {
        return paysenderid;
    }

    public void setPaysenderid(Integer paysenderid) {
        this.paysenderid = paysenderid;
    }

    public Integer getPayreceiverid() {
        return payreceiverid;
    }

    public void setPayreceiverid(Integer payreceiverid) {
        this.payreceiverid = payreceiverid;
    }

    public String getPayreceivername() {
        return payreceivername;
    }

    public void setPayreceivername(String payreceivername) {
        this.payreceivername = payreceivername == null ? null : payreceivername.trim();
    }

    public Integer getPaytypeid() {
        return paytypeid;
    }

    public void setPaytypeid(Integer paytypeid) {
        this.paytypeid = paytypeid;
    }

    public Integer getPaystateid() {
        return paystateid;
    }

    public void setPaystateid(Integer paystateid) {
        this.paystateid = paystateid;
    }

    public Integer getPaymodeid() {
        return paymodeid;
    }

    public void setPaymodeid(Integer paymodeid) {
        this.paymodeid = paymodeid;
    }

    public String getPayremark() {
        return payremark;
    }

    public void setPayremark(String payremark) {
        this.payremark = payremark == null ? null : payremark.trim();
    }

    public String getPaysendername() {
        return paysendername;
    }

    public void setPaysendername(String paysendername) {
        this.paysendername = paysendername == null ? null : paysendername.trim();
    }

    public String getPayinfo() {
        return payinfo;
    }

    public void setPayinfo(String payinfo) {
        this.payinfo = payinfo == null ? null : payinfo.trim();
    }
}