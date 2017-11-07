package com.medical.po;

import java.util.Date;

public class Doctorcomment {
    private Integer doccommentid;

    private Integer doccommentfatherid;

    private Integer doccommentgrade;

    private Integer doccommentservicelevel;

    private Integer doccommentprofessionallevel;

    private Integer doccommentpricelevel;

    private String doccommentwords;

    private Integer docloginid;

    private Integer userorderid;

    private Integer userloginid;

    private Date doccommenttime;

    public Integer getDoccommentid() {
        return doccommentid;
    }

    public void setDoccommentid(Integer doccommentid) {
        this.doccommentid = doccommentid;
    }

    public Integer getDoccommentfatherid() {
        return doccommentfatherid;
    }

    public void setDoccommentfatherid(Integer doccommentfatherid) {
        this.doccommentfatherid = doccommentfatherid;
    }

    public Integer getDoccommentgrade() {
        return doccommentgrade;
    }

    public void setDoccommentgrade(Integer doccommentgrade) {
        this.doccommentgrade = doccommentgrade;
    }

    public Integer getDoccommentservicelevel() {
        return doccommentservicelevel;
    }

    public void setDoccommentservicelevel(Integer doccommentservicelevel) {
        this.doccommentservicelevel = doccommentservicelevel;
    }

    public Integer getDoccommentprofessionallevel() {
        return doccommentprofessionallevel;
    }

    public void setDoccommentprofessionallevel(Integer doccommentprofessionallevel) {
        this.doccommentprofessionallevel = doccommentprofessionallevel;
    }

    public Integer getDoccommentpricelevel() {
        return doccommentpricelevel;
    }

    public void setDoccommentpricelevel(Integer doccommentpricelevel) {
        this.doccommentpricelevel = doccommentpricelevel;
    }

    public String getDoccommentwords() {
        return doccommentwords;
    }

    public void setDoccommentwords(String doccommentwords) {
        this.doccommentwords = doccommentwords == null ? null : doccommentwords.trim();
    }

    public Integer getDocloginid() {
        return docloginid;
    }

    public void setDocloginid(Integer docloginid) {
        this.docloginid = docloginid;
    }

    public Integer getUserorderid() {
        return userorderid;
    }

    public void setUserorderid(Integer userorderid) {
        this.userorderid = userorderid;
    }

    public Integer getUserloginid() {
        return userloginid;
    }

    public void setUserloginid(Integer userloginid) {
        this.userloginid = userloginid;
    }

    public Date getDoccommenttime() {
        return doccommenttime;
    }

    public void setDoccommenttime(Date doccommenttime) {
        this.doccommenttime = doccommenttime;
    }
}