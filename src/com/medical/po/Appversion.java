package com.medical.po;

import java.util.Date;

public class Appversion {
    private Integer id;

    private String appversion;

    private Date apppublishtime;

    private Integer apptype;

    private String appurl;

    private Integer systemtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion == null ? null : appversion.trim();
    }

    public Date getApppublishtime() {
        return apppublishtime;
    }

    public void setApppublishtime(Date apppublishtime) {
        this.apppublishtime = apppublishtime;
    }

    public Integer getApptype() {
        return apptype;
    }

    public void setApptype(Integer apptype) {
        this.apptype = apptype;
    }

    public String getAppurl() {
        return appurl;
    }

    public void setAppurl(String appurl) {
        this.appurl = appurl == null ? null : appurl.trim();
    }

    public Integer getSystemtype() {
        return systemtype;
    }

    public void setSystemtype(Integer systemtype) {
        this.systemtype = systemtype;
    }
}