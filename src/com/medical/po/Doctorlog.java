package com.medical.po;

import java.util.Date;

public class Doctorlog {
    private Integer doclogid;

    private Date doclogtime;

    private String docloglon;

    private String docloglat;

    private String doclogloc;

    private Boolean doclogdev;

    private String doclogbver;

    private String doclogmodel;

    private String doclogpver;

    private String doclogmac;

    private String doclogip;

    private Integer docloginid;

    public Integer getDoclogid() {
        return doclogid;
    }

    public void setDoclogid(Integer doclogid) {
        this.doclogid = doclogid;
    }

    public Date getDoclogtime() {
        return doclogtime;
    }

    public void setDoclogtime(Date doclogtime) {
        this.doclogtime = doclogtime;
    }

    public String getDocloglon() {
        return docloglon;
    }

    public void setDocloglon(String docloglon) {
        this.docloglon = docloglon == null ? null : docloglon.trim();
    }

    public String getDocloglat() {
        return docloglat;
    }

    public void setDocloglat(String docloglat) {
        this.docloglat = docloglat == null ? null : docloglat.trim();
    }

    public String getDoclogloc() {
        return doclogloc;
    }

    public void setDoclogloc(String doclogloc) {
        this.doclogloc = doclogloc == null ? null : doclogloc.trim();
    }

    public Boolean getDoclogdev() {
        return doclogdev;
    }

    public void setDoclogdev(Boolean doclogdev) {
        this.doclogdev = doclogdev;
    }

    public String getDoclogbver() {
        return doclogbver;
    }

    public void setDoclogbver(String doclogbver) {
        this.doclogbver = doclogbver == null ? null : doclogbver.trim();
    }

    public String getDoclogmodel() {
        return doclogmodel;
    }

    public void setDoclogmodel(String doclogmodel) {
        this.doclogmodel = doclogmodel == null ? null : doclogmodel.trim();
    }

    public String getDoclogpver() {
        return doclogpver;
    }

    public void setDoclogpver(String doclogpver) {
        this.doclogpver = doclogpver == null ? null : doclogpver.trim();
    }

    public String getDoclogmac() {
        return doclogmac;
    }

    public void setDoclogmac(String doclogmac) {
        this.doclogmac = doclogmac == null ? null : doclogmac.trim();
    }

    public String getDoclogip() {
        return doclogip;
    }

    public void setDoclogip(String doclogip) {
        this.doclogip = doclogip == null ? null : doclogip.trim();
    }

    public Integer getDocloginid() {
        return docloginid;
    }

    public void setDocloginid(Integer docloginid) {
        this.docloginid = docloginid;
    }
}