package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

public class Preorder {
    private Integer preorderid;

    private Integer usersickid;

    private Integer preordertype;

    private Integer preorderstate;

    private Integer preorderuserloginid;

    private Integer preorderdocloginid;

    private Integer preorderredocloginid;

    private Date preordertime;

    private BigDecimal preorderprice;

    public Integer getPreorderid() {
        return preorderid;
    }

    public void setPreorderid(Integer preorderid) {
        this.preorderid = preorderid;
    }

    public Integer getUsersickid() {
        return usersickid;
    }

    public void setUsersickid(Integer usersickid) {
        this.usersickid = usersickid;
    }

    public Integer getPreordertype() {
        return preordertype;
    }

    public void setPreordertype(Integer preordertype) {
        this.preordertype = preordertype;
    }

    public Integer getPreorderstate() {
        return preorderstate;
    }

    public void setPreorderstate(Integer preorderstate) {
        this.preorderstate = preorderstate;
    }

    public Integer getPreorderuserloginid() {
        return preorderuserloginid;
    }

    public void setPreorderuserloginid(Integer preorderuserloginid) {
        this.preorderuserloginid = preorderuserloginid;
    }

    public Integer getPreorderdocloginid() {
        return preorderdocloginid;
    }

    public void setPreorderdocloginid(Integer preorderdocloginid) {
        this.preorderdocloginid = preorderdocloginid;
    }

    public Integer getPreorderredocloginid() {
        return preorderredocloginid;
    }

    public void setPreorderredocloginid(Integer preorderredocloginid) {
        this.preorderredocloginid = preorderredocloginid;
    }

    public Date getPreordertime() {
        return preordertime;
    }

    public void setPreordertime(Date preordertime) {
        this.preordertime = preordertime;
    }

    public BigDecimal getPreorderprice() {
        return preorderprice;
    }

    public void setPreorderprice(BigDecimal preorderprice) {
        this.preorderprice = preorderprice;
    }
}