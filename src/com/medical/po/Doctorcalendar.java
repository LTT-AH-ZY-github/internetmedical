package com.medical.po;

import java.util.Date;

public class Doctorcalendar {
    private Integer doccalendarid;

    private Date doccalendarday;

    private String doccalendartime;

    private String doccalendaraffair;

    private Integer doccalendaradressid;

    private Integer docloginid;

    public Integer getDoccalendarid() {
        return doccalendarid;
    }

    public void setDoccalendarid(Integer doccalendarid) {
        this.doccalendarid = doccalendarid;
    }

    public Date getDoccalendarday() {
        return doccalendarday;
    }

    public void setDoccalendarday(Date doccalendarday) {
        this.doccalendarday = doccalendarday;
    }

    public String getDoccalendartime() {
        return doccalendartime;
    }

    public void setDoccalendartime(String doccalendartime) {
        this.doccalendartime = doccalendartime == null ? null : doccalendartime.trim();
    }

    public String getDoccalendaraffair() {
        return doccalendaraffair;
    }

    public void setDoccalendaraffair(String doccalendaraffair) {
        this.doccalendaraffair = doccalendaraffair == null ? null : doccalendaraffair.trim();
    }

    public Integer getDoccalendaradressid() {
        return doccalendaradressid;
    }

    public void setDoccalendaradressid(Integer doccalendaradressid) {
        this.doccalendaradressid = doccalendaradressid;
    }

    public Integer getDocloginid() {
        return docloginid;
    }

    public void setDocloginid(Integer docloginid) {
        this.docloginid = docloginid;
    }
}