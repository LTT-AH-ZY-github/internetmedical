package com.medical.po;

import java.util.Date;

public class Adminlog {
    private Integer adminlogid;

    private Date adminlogtime;

    private String adminlogloc;

    private String adminlogbver;

    private String adminlogmac;

    private String adminlogip;

    private String adminloglon;

    private String adminloglat;

    private Integer adminloginid;

    public Integer getAdminlogid() {
        return adminlogid;
    }

    public void setAdminlogid(Integer adminlogid) {
        this.adminlogid = adminlogid;
    }

    public Date getAdminlogtime() {
        return adminlogtime;
    }

    public void setAdminlogtime(Date adminlogtime) {
        this.adminlogtime = adminlogtime;
    }

    public String getAdminlogloc() {
        return adminlogloc;
    }

    public void setAdminlogloc(String adminlogloc) {
        this.adminlogloc = adminlogloc == null ? null : adminlogloc.trim();
    }

    public String getAdminlogbver() {
        return adminlogbver;
    }

    public void setAdminlogbver(String adminlogbver) {
        this.adminlogbver = adminlogbver == null ? null : adminlogbver.trim();
    }

    public String getAdminlogmac() {
        return adminlogmac;
    }

    public void setAdminlogmac(String adminlogmac) {
        this.adminlogmac = adminlogmac == null ? null : adminlogmac.trim();
    }

    public String getAdminlogip() {
        return adminlogip;
    }

    public void setAdminlogip(String adminlogip) {
        this.adminlogip = adminlogip == null ? null : adminlogip.trim();
    }

    public String getAdminloglon() {
        return adminloglon;
    }

    public void setAdminloglon(String adminloglon) {
        this.adminloglon = adminloglon == null ? null : adminloglon.trim();
    }

    public String getAdminloglat() {
        return adminloglat;
    }

    public void setAdminloglat(String adminloglat) {
        this.adminloglat = adminloglat == null ? null : adminloglat.trim();
    }

    public Integer getAdminloginid() {
        return adminloginid;
    }

    public void setAdminloginid(Integer adminloginid) {
        this.adminloginid = adminloginid;
    }
}