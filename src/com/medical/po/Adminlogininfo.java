package com.medical.po;

import java.util.Date;

public class Adminlogininfo {
    private Integer adminloginid;

    private String adminloginname;

    private String adminloginpwd;

    private String adminloginpix;

    private String adminlogintoken;

    private Date adminlogintime;

    private String adminloginloc;

    private String adminloginbver;

    private String adminloginmac;

    private String adminloginip;

    private String adminloginsalt;

    private Integer roleid;

    private Date registrationtime;

    public Integer getAdminloginid() {
        return adminloginid;
    }

    public void setAdminloginid(Integer adminloginid) {
        this.adminloginid = adminloginid;
    }

    public String getAdminloginname() {
        return adminloginname;
    }

    public void setAdminloginname(String adminloginname) {
        this.adminloginname = adminloginname == null ? null : adminloginname.trim();
    }

    public String getAdminloginpwd() {
        return adminloginpwd;
    }

    public void setAdminloginpwd(String adminloginpwd) {
        this.adminloginpwd = adminloginpwd == null ? null : adminloginpwd.trim();
    }

    public String getAdminloginpix() {
        return adminloginpix;
    }

    public void setAdminloginpix(String adminloginpix) {
        this.adminloginpix = adminloginpix == null ? null : adminloginpix.trim();
    }

    public String getAdminlogintoken() {
        return adminlogintoken;
    }

    public void setAdminlogintoken(String adminlogintoken) {
        this.adminlogintoken = adminlogintoken == null ? null : adminlogintoken.trim();
    }

    public Date getAdminlogintime() {
        return adminlogintime;
    }

    public void setAdminlogintime(Date adminlogintime) {
        this.adminlogintime = adminlogintime;
    }

    public String getAdminloginloc() {
        return adminloginloc;
    }

    public void setAdminloginloc(String adminloginloc) {
        this.adminloginloc = adminloginloc == null ? null : adminloginloc.trim();
    }

    public String getAdminloginbver() {
        return adminloginbver;
    }

    public void setAdminloginbver(String adminloginbver) {
        this.adminloginbver = adminloginbver == null ? null : adminloginbver.trim();
    }

    public String getAdminloginmac() {
        return adminloginmac;
    }

    public void setAdminloginmac(String adminloginmac) {
        this.adminloginmac = adminloginmac == null ? null : adminloginmac.trim();
    }

    public String getAdminloginip() {
        return adminloginip;
    }

    public void setAdminloginip(String adminloginip) {
        this.adminloginip = adminloginip == null ? null : adminloginip.trim();
    }

    public String getAdminloginsalt() {
        return adminloginsalt;
    }

    public void setAdminloginsalt(String adminloginsalt) {
        this.adminloginsalt = adminloginsalt == null ? null : adminloginsalt.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Date getRegistrationtime() {
        return registrationtime;
    }

    public void setRegistrationtime(Date registrationtime) {
        this.registrationtime = registrationtime;
    }
}