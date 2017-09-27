package com.medical.po;

import java.util.Date;

public class Hosplogininfo {
    private Integer hosploginid;

    private String hosploginname;

    private String hosploginpwd;

    private String hosplogintoken;

    private Date hosplogintime;

    private String hosploginloc;

    private String hosploginbver;

    private String hosploginmac;

    private String hosploginip;

    private Integer hosplogintype;

    private String hosploginphone;

    private String hosploginpix;

    public Integer getHosploginid() {
        return hosploginid;
    }

    public void setHosploginid(Integer hosploginid) {
        this.hosploginid = hosploginid;
    }

    public String getHosploginname() {
        return hosploginname;
    }

    public void setHosploginname(String hosploginname) {
        this.hosploginname = hosploginname == null ? null : hosploginname.trim();
    }

    public String getHosploginpwd() {
        return hosploginpwd;
    }

    public void setHosploginpwd(String hosploginpwd) {
        this.hosploginpwd = hosploginpwd == null ? null : hosploginpwd.trim();
    }

    public String getHosplogintoken() {
        return hosplogintoken;
    }

    public void setHosplogintoken(String hosplogintoken) {
        this.hosplogintoken = hosplogintoken == null ? null : hosplogintoken.trim();
    }

    public Date getHosplogintime() {
        return hosplogintime;
    }

    public void setHosplogintime(Date hosplogintime) {
        this.hosplogintime = hosplogintime;
    }

    public String getHosploginloc() {
        return hosploginloc;
    }

    public void setHosploginloc(String hosploginloc) {
        this.hosploginloc = hosploginloc == null ? null : hosploginloc.trim();
    }

    public String getHosploginbver() {
        return hosploginbver;
    }

    public void setHosploginbver(String hosploginbver) {
        this.hosploginbver = hosploginbver == null ? null : hosploginbver.trim();
    }

    public String getHosploginmac() {
        return hosploginmac;
    }

    public void setHosploginmac(String hosploginmac) {
        this.hosploginmac = hosploginmac == null ? null : hosploginmac.trim();
    }

    public String getHosploginip() {
        return hosploginip;
    }

    public void setHosploginip(String hosploginip) {
        this.hosploginip = hosploginip == null ? null : hosploginip.trim();
    }

    public Integer getHosplogintype() {
        return hosplogintype;
    }

    public void setHosplogintype(Integer hosplogintype) {
        this.hosplogintype = hosplogintype;
    }

    public String getHosploginphone() {
        return hosploginphone;
    }

    public void setHosploginphone(String hosploginphone) {
        this.hosploginphone = hosploginphone == null ? null : hosploginphone.trim();
    }

    public String getHosploginpix() {
        return hosploginpix;
    }

    public void setHosploginpix(String hosploginpix) {
        this.hosploginpix = hosploginpix == null ? null : hosploginpix.trim();
    }
}