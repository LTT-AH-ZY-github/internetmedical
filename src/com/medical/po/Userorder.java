package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

public class Userorder {
    private Integer userorderid;

    private Integer userorderstateid;

    private Date userorderptime;

    private Integer userorderdocloginid;

    private Integer userorderrecdocloginid;

    private Date userorderrtime;

    private BigDecimal userorderdprice;

    private String userorderappointment;

    private Date userorderetime;

    private Integer userorderactualhospitalizationid;

    private Boolean userorderhstate;

    private Date userorderchosehosptime;

    private Date userorderhospconfirmtime;

    private Date userorderleavehosptime;

    private Integer userorderhospid;

    private BigDecimal userorderdeposit;

    private BigDecimal userordertotaldeposit;

    private BigDecimal userorderhprice;

    private String userorderhospprimarydept;

    private String userorderhospseconddept;

    private Integer userordertpricetype;

    private BigDecimal userordertprice;

    private Integer userorderapricetype;

    private BigDecimal userorderaprice;

    private Integer userorderepricetype;

    private BigDecimal userordereprice;

    private BigDecimal userorderprice;

    private Integer usersickid;

    private Integer userloginid;

    private Date userorderfinishtime;

    public Integer getUserorderid() {
        return userorderid;
    }

    public void setUserorderid(Integer userorderid) {
        this.userorderid = userorderid;
    }

    public Integer getUserorderstateid() {
        return userorderstateid;
    }

    public void setUserorderstateid(Integer userorderstateid) {
        this.userorderstateid = userorderstateid;
    }

    public Date getUserorderptime() {
        return userorderptime;
    }

    public void setUserorderptime(Date userorderptime) {
        this.userorderptime = userorderptime;
    }

    public Integer getUserorderdocloginid() {
        return userorderdocloginid;
    }

    public void setUserorderdocloginid(Integer userorderdocloginid) {
        this.userorderdocloginid = userorderdocloginid;
    }

    public Integer getUserorderrecdocloginid() {
        return userorderrecdocloginid;
    }

    public void setUserorderrecdocloginid(Integer userorderrecdocloginid) {
        this.userorderrecdocloginid = userorderrecdocloginid;
    }

    public Date getUserorderrtime() {
        return userorderrtime;
    }

    public void setUserorderrtime(Date userorderrtime) {
        this.userorderrtime = userorderrtime;
    }

    public BigDecimal getUserorderdprice() {
        return userorderdprice;
    }

    public void setUserorderdprice(BigDecimal userorderdprice) {
        this.userorderdprice = userorderdprice;
    }

    public String getUserorderappointment() {
        return userorderappointment;
    }

    public void setUserorderappointment(String userorderappointment) {
        this.userorderappointment = userorderappointment == null ? null : userorderappointment.trim();
    }

    public Date getUserorderetime() {
        return userorderetime;
    }

    public void setUserorderetime(Date userorderetime) {
        this.userorderetime = userorderetime;
    }

    public Integer getUserorderactualhospitalizationid() {
        return userorderactualhospitalizationid;
    }

    public void setUserorderactualhospitalizationid(Integer userorderactualhospitalizationid) {
        this.userorderactualhospitalizationid = userorderactualhospitalizationid;
    }

    public Boolean getUserorderhstate() {
        return userorderhstate;
    }

    public void setUserorderhstate(Boolean userorderhstate) {
        this.userorderhstate = userorderhstate;
    }

    public Date getUserorderchosehosptime() {
        return userorderchosehosptime;
    }

    public void setUserorderchosehosptime(Date userorderchosehosptime) {
        this.userorderchosehosptime = userorderchosehosptime;
    }

    public Date getUserorderhospconfirmtime() {
        return userorderhospconfirmtime;
    }

    public void setUserorderhospconfirmtime(Date userorderhospconfirmtime) {
        this.userorderhospconfirmtime = userorderhospconfirmtime;
    }

    public Date getUserorderleavehosptime() {
        return userorderleavehosptime;
    }

    public void setUserorderleavehosptime(Date userorderleavehosptime) {
        this.userorderleavehosptime = userorderleavehosptime;
    }

    public Integer getUserorderhospid() {
        return userorderhospid;
    }

    public void setUserorderhospid(Integer userorderhospid) {
        this.userorderhospid = userorderhospid;
    }

    public BigDecimal getUserorderdeposit() {
        return userorderdeposit;
    }

    public void setUserorderdeposit(BigDecimal userorderdeposit) {
        this.userorderdeposit = userorderdeposit;
    }

    public BigDecimal getUserordertotaldeposit() {
        return userordertotaldeposit;
    }

    public void setUserordertotaldeposit(BigDecimal userordertotaldeposit) {
        this.userordertotaldeposit = userordertotaldeposit;
    }

    public BigDecimal getUserorderhprice() {
        return userorderhprice;
    }

    public void setUserorderhprice(BigDecimal userorderhprice) {
        this.userorderhprice = userorderhprice;
    }

    public String getUserorderhospprimarydept() {
        return userorderhospprimarydept;
    }

    public void setUserorderhospprimarydept(String userorderhospprimarydept) {
        this.userorderhospprimarydept = userorderhospprimarydept == null ? null : userorderhospprimarydept.trim();
    }

    public String getUserorderhospseconddept() {
        return userorderhospseconddept;
    }

    public void setUserorderhospseconddept(String userorderhospseconddept) {
        this.userorderhospseconddept = userorderhospseconddept == null ? null : userorderhospseconddept.trim();
    }

    public Integer getUserordertpricetype() {
        return userordertpricetype;
    }

    public void setUserordertpricetype(Integer userordertpricetype) {
        this.userordertpricetype = userordertpricetype;
    }

    public BigDecimal getUserordertprice() {
        return userordertprice;
    }

    public void setUserordertprice(BigDecimal userordertprice) {
        this.userordertprice = userordertprice;
    }

    public Integer getUserorderapricetype() {
        return userorderapricetype;
    }

    public void setUserorderapricetype(Integer userorderapricetype) {
        this.userorderapricetype = userorderapricetype;
    }

    public BigDecimal getUserorderaprice() {
        return userorderaprice;
    }

    public void setUserorderaprice(BigDecimal userorderaprice) {
        this.userorderaprice = userorderaprice;
    }

    public Integer getUserorderepricetype() {
        return userorderepricetype;
    }

    public void setUserorderepricetype(Integer userorderepricetype) {
        this.userorderepricetype = userorderepricetype;
    }

    public BigDecimal getUserordereprice() {
        return userordereprice;
    }

    public void setUserordereprice(BigDecimal userordereprice) {
        this.userordereprice = userordereprice;
    }

    public BigDecimal getUserorderprice() {
        return userorderprice;
    }

    public void setUserorderprice(BigDecimal userorderprice) {
        this.userorderprice = userorderprice;
    }

    public Integer getUsersickid() {
        return usersickid;
    }

    public void setUsersickid(Integer usersickid) {
        this.usersickid = usersickid;
    }

    public Integer getUserloginid() {
        return userloginid;
    }

    public void setUserloginid(Integer userloginid) {
        this.userloginid = userloginid;
    }

    public Date getUserorderfinishtime() {
        return userorderfinishtime;
    }

    public void setUserorderfinishtime(Date userorderfinishtime) {
        this.userorderfinishtime = userorderfinishtime;
    }
}