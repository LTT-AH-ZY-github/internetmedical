package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

public class Hosporder {
    private Integer hosporderid;

    private Integer hospid;

    private Integer doctorid;

    private BigDecimal orderprice;

    private String orderabs;

    private Integer orderstate;

    private Date orderptime;

    private Date orderrtime;

    private Date orderetime;

    private Date orderstime;

    public Integer getHosporderid() {
        return hosporderid;
    }

    public void setHosporderid(Integer hosporderid) {
        this.hosporderid = hosporderid;
    }

    public Integer getHospid() {
        return hospid;
    }

    public void setHospid(Integer hospid) {
        this.hospid = hospid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public BigDecimal getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(BigDecimal orderprice) {
        this.orderprice = orderprice;
    }

    public String getOrderabs() {
        return orderabs;
    }

    public void setOrderabs(String orderabs) {
        this.orderabs = orderabs == null ? null : orderabs.trim();
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }

    public Date getOrderptime() {
        return orderptime;
    }

    public void setOrderptime(Date orderptime) {
        this.orderptime = orderptime;
    }

    public Date getOrderrtime() {
        return orderrtime;
    }

    public void setOrderrtime(Date orderrtime) {
        this.orderrtime = orderrtime;
    }

    public Date getOrderetime() {
        return orderetime;
    }

    public void setOrderetime(Date orderetime) {
        this.orderetime = orderetime;
    }

    public Date getOrderstime() {
        return orderstime;
    }

    public void setOrderstime(Date orderstime) {
        this.orderstime = orderstime;
    }
}