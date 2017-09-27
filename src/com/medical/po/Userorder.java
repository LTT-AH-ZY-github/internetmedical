package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

public class Userorder {
    private Integer userorderid;

    private Date userorderptime;

    private Date userorderrtime;

    private Date userorderetime;

    private String userorderappointment;

    private Integer userorderdocloginid;

    private Integer userorderrecdocloginid;

    private Integer userorderstateid;

    private Integer userorderhospid;

    private BigDecimal userorderdprice;

    private Byte userorderhstate;

    private BigDecimal userorderhprice;

    private Integer userordertpricetype;

    private BigDecimal userordertprice;

    private Integer userorderapricetype;

    private BigDecimal userorderaprice;

    private Integer userorderepricetype;

    private BigDecimal userordereprice;

    private BigDecimal userorderprice;

    private BigDecimal userorderdeposit;

    private Integer usersickid;

    private Integer userloginid;

    public Integer getUserorderid() {
        return userorderid;
    }

    public void setUserorderid(Integer userorderid) {
        this.userorderid = userorderid;
    }

    public Date getUserorderptime() {
        return userorderptime;
    }

    public void setUserorderptime(Date userorderptime) {
        this.userorderptime = userorderptime;
    }

    public Date getUserorderrtime() {
        return userorderrtime;
    }

    public void setUserorderrtime(Date userorderrtime) {
        this.userorderrtime = userorderrtime;
    }

    public Date getUserorderetime() {
        return userorderetime;
    }

    public void setUserorderetime(Date userorderetime) {
        this.userorderetime = userorderetime;
    }

    public String getUserorderappointment() {
        return userorderappointment;
    }

    public void setUserorderappointment(String userorderappointment) {
        this.userorderappointment = userorderappointment == null ? null : userorderappointment.trim();
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

    public Integer getUserorderstateid() {
        return userorderstateid;
    }

    public void setUserorderstateid(Integer userorderstateid) {
        this.userorderstateid = userorderstateid;
    }

    public Integer getUserorderhospid() {
        return userorderhospid;
    }

    public void setUserorderhospid(Integer userorderhospid) {
        this.userorderhospid = userorderhospid;
    }

    public BigDecimal getUserorderdprice() {
        return userorderdprice;
    }

    public void setUserorderdprice(BigDecimal userorderdprice) {
        this.userorderdprice = userorderdprice;
    }

    public Byte getUserorderhstate() {
        return userorderhstate;
    }

    public void setUserorderhstate(Byte userorderhstate) {
        this.userorderhstate = userorderhstate;
    }

    public BigDecimal getUserorderhprice() {
        return userorderhprice;
    }

    public void setUserorderhprice(BigDecimal userorderhprice) {
        this.userorderhprice = userorderhprice;
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

    public BigDecimal getUserorderdeposit() {
        return userorderdeposit;
    }

    public void setUserorderdeposit(BigDecimal userorderdeposit) {
        this.userorderdeposit = userorderdeposit;
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
}