package com.medical.po;

import java.util.Date;

public class Adminexaminedept {
    private Integer examineid;

    private Integer examinedeptid;

    private String examinedeptname;

    private Byte examinedeptresult;

    private String examinedeptideas;

    private Date examinedepttime;

    public Integer getExamineid() {
        return examineid;
    }

    public void setExamineid(Integer examineid) {
        this.examineid = examineid;
    }

    public Integer getExaminedeptid() {
        return examinedeptid;
    }

    public void setExaminedeptid(Integer examinedeptid) {
        this.examinedeptid = examinedeptid;
    }

    public String getExaminedeptname() {
        return examinedeptname;
    }

    public void setExaminedeptname(String examinedeptname) {
        this.examinedeptname = examinedeptname == null ? null : examinedeptname.trim();
    }

    public Byte getExaminedeptresult() {
        return examinedeptresult;
    }

    public void setExaminedeptresult(Byte examinedeptresult) {
        this.examinedeptresult = examinedeptresult;
    }

    public String getExaminedeptideas() {
        return examinedeptideas;
    }

    public void setExaminedeptideas(String examinedeptideas) {
        this.examinedeptideas = examinedeptideas == null ? null : examinedeptideas.trim();
    }

    public Date getExaminedepttime() {
        return examinedepttime;
    }

    public void setExaminedepttime(Date examinedepttime) {
        this.examinedepttime = examinedepttime;
    }
}