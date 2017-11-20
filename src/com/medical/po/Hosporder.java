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

    private String orderstime;

    private BigDecimal orderhospprice;

    private BigDecimal orderdoctorprice;

    private Integer orderhosptpricetype;

    private BigDecimal orderhosptprice;

    private Integer orderdoctortpricetype;

    private BigDecimal orderdoctortprice;

    private Integer orderhospapricetype;

    private BigDecimal orderhospaprice;

    private Integer orderdoctorapricetype;

    private BigDecimal orderdoctoraprice;

    private Integer orderhospepricetype;

    private BigDecimal orderhospeprice;

    private Integer orderdoctorepricetype;

    private BigDecimal orderdoctoreprice;

    private BigDecimal ordertotalhospprice;

    private BigDecimal ordertotaldoctorprice;

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

    public String getOrderstime() {
        return orderstime;
    }

    public void setOrderstime(String orderstime) {
        this.orderstime = orderstime == null ? null : orderstime.trim();
    }

    public BigDecimal getOrderhospprice() {
        return orderhospprice;
    }

    public void setOrderhospprice(BigDecimal orderhospprice) {
        this.orderhospprice = orderhospprice;
    }

    public BigDecimal getOrderdoctorprice() {
        return orderdoctorprice;
    }

    public void setOrderdoctorprice(BigDecimal orderdoctorprice) {
        this.orderdoctorprice = orderdoctorprice;
    }

    public Integer getOrderhosptpricetype() {
        return orderhosptpricetype;
    }

    public void setOrderhosptpricetype(Integer orderhosptpricetype) {
        this.orderhosptpricetype = orderhosptpricetype;
    }

    public BigDecimal getOrderhosptprice() {
        return orderhosptprice;
    }

    public void setOrderhosptprice(BigDecimal orderhosptprice) {
        this.orderhosptprice = orderhosptprice;
    }

    public Integer getOrderdoctortpricetype() {
        return orderdoctortpricetype;
    }

    public void setOrderdoctortpricetype(Integer orderdoctortpricetype) {
        this.orderdoctortpricetype = orderdoctortpricetype;
    }

    public BigDecimal getOrderdoctortprice() {
        return orderdoctortprice;
    }

    public void setOrderdoctortprice(BigDecimal orderdoctortprice) {
        this.orderdoctortprice = orderdoctortprice;
    }

    public Integer getOrderhospapricetype() {
        return orderhospapricetype;
    }

    public void setOrderhospapricetype(Integer orderhospapricetype) {
        this.orderhospapricetype = orderhospapricetype;
    }

    public BigDecimal getOrderhospaprice() {
        return orderhospaprice;
    }

    public void setOrderhospaprice(BigDecimal orderhospaprice) {
        this.orderhospaprice = orderhospaprice;
    }

    public Integer getOrderdoctorapricetype() {
        return orderdoctorapricetype;
    }

    public void setOrderdoctorapricetype(Integer orderdoctorapricetype) {
        this.orderdoctorapricetype = orderdoctorapricetype;
    }

    public BigDecimal getOrderdoctoraprice() {
        return orderdoctoraprice;
    }

    public void setOrderdoctoraprice(BigDecimal orderdoctoraprice) {
        this.orderdoctoraprice = orderdoctoraprice;
    }

    public Integer getOrderhospepricetype() {
        return orderhospepricetype;
    }

    public void setOrderhospepricetype(Integer orderhospepricetype) {
        this.orderhospepricetype = orderhospepricetype;
    }

    public BigDecimal getOrderhospeprice() {
        return orderhospeprice;
    }

    public void setOrderhospeprice(BigDecimal orderhospeprice) {
        this.orderhospeprice = orderhospeprice;
    }

    public Integer getOrderdoctorepricetype() {
        return orderdoctorepricetype;
    }

    public void setOrderdoctorepricetype(Integer orderdoctorepricetype) {
        this.orderdoctorepricetype = orderdoctorepricetype;
    }

    public BigDecimal getOrderdoctoreprice() {
        return orderdoctoreprice;
    }

    public void setOrderdoctoreprice(BigDecimal orderdoctoreprice) {
        this.orderdoctoreprice = orderdoctoreprice;
    }

    public BigDecimal getOrdertotalhospprice() {
        return ordertotalhospprice;
    }

    public void setOrdertotalhospprice(BigDecimal ordertotalhospprice) {
        this.ordertotalhospprice = ordertotalhospprice;
    }

    public BigDecimal getOrdertotaldoctorprice() {
        return ordertotaldoctorprice;
    }

    public void setOrdertotaldoctorprice(BigDecimal ordertotaldoctorprice) {
        this.ordertotaldoctorprice = ordertotaldoctorprice;
    }
}