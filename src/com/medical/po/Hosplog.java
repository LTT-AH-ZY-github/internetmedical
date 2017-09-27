package com.medical.po;

import java.util.Date;

public class Hosplog {
    private Integer hosplogid;

    private Date hosplogtime;

    private String hosplogloc;

    private String hosplogbver;

    private String hosplogmac;

    private String hosplogip;

    private Integer hosploginid;

    public Integer getHosplogid() {
        return hosplogid;
    }

    public void setHosplogid(Integer hosplogid) {
        this.hosplogid = hosplogid;
    }

    public Date getHosplogtime() {
        return hosplogtime;
    }

    public void setHosplogtime(Date hosplogtime) {
        this.hosplogtime = hosplogtime;
    }

    public String getHosplogloc() {
        return hosplogloc;
    }

    public void setHosplogloc(String hosplogloc) {
        this.hosplogloc = hosplogloc == null ? null : hosplogloc.trim();
    }

    public String getHosplogbver() {
        return hosplogbver;
    }

    public void setHosplogbver(String hosplogbver) {
        this.hosplogbver = hosplogbver == null ? null : hosplogbver.trim();
    }

    public String getHosplogmac() {
        return hosplogmac;
    }

    public void setHosplogmac(String hosplogmac) {
        this.hosplogmac = hosplogmac == null ? null : hosplogmac.trim();
    }

    public String getHosplogip() {
        return hosplogip;
    }

    public void setHosplogip(String hosplogip) {
        this.hosplogip = hosplogip == null ? null : hosplogip.trim();
    }

    public Integer getHosploginid() {
        return hosploginid;
    }

    public void setHosploginid(Integer hosploginid) {
        this.hosploginid = hosploginid;
    }
}