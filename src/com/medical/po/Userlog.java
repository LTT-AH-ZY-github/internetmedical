package com.medical.po;

import java.util.Date;

public class Userlog {
    private Integer userlogid;

    private Integer userloginid;

    private Date userlogtime;

    private String userloglon;

    private String userloglat;

    private String userlogloc;

    private Integer userlogdev;

    private String userlogbver;

    private String userlogmodel;

    private String userlogpver;

    private String userlogmac;

    private String userlogip;

    public Integer getUserlogid() {
        return userlogid;
    }

    public void setUserlogid(Integer userlogid) {
        this.userlogid = userlogid;
    }

    public Integer getUserloginid() {
        return userloginid;
    }

    public void setUserloginid(Integer userloginid) {
        this.userloginid = userloginid;
    }

    public Date getUserlogtime() {
        return userlogtime;
    }

    public void setUserlogtime(Date userlogtime) {
        this.userlogtime = userlogtime;
    }

    public String getUserloglon() {
        return userloglon;
    }

    public void setUserloglon(String userloglon) {
        this.userloglon = userloglon == null ? null : userloglon.trim();
    }

    public String getUserloglat() {
        return userloglat;
    }

    public void setUserloglat(String userloglat) {
        this.userloglat = userloglat == null ? null : userloglat.trim();
    }

    public String getUserlogloc() {
        return userlogloc;
    }

    public void setUserlogloc(String userlogloc) {
        this.userlogloc = userlogloc == null ? null : userlogloc.trim();
    }

    public Integer getUserlogdev() {
        return userlogdev;
    }

    public void setUserlogdev(Integer userlogdev) {
        this.userlogdev = userlogdev;
    }

    public String getUserlogbver() {
        return userlogbver;
    }

    public void setUserlogbver(String userlogbver) {
        this.userlogbver = userlogbver == null ? null : userlogbver.trim();
    }

    public String getUserlogmodel() {
        return userlogmodel;
    }

    public void setUserlogmodel(String userlogmodel) {
        this.userlogmodel = userlogmodel == null ? null : userlogmodel.trim();
    }

    public String getUserlogpver() {
        return userlogpver;
    }

    public void setUserlogpver(String userlogpver) {
        this.userlogpver = userlogpver == null ? null : userlogpver.trim();
    }

    public String getUserlogmac() {
        return userlogmac;
    }

    public void setUserlogmac(String userlogmac) {
        this.userlogmac = userlogmac == null ? null : userlogmac.trim();
    }

    public String getUserlogip() {
        return userlogip;
    }

    public void setUserlogip(String userlogip) {
        this.userlogip = userlogip == null ? null : userlogip.trim();
    }
}