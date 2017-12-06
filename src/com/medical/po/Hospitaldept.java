package com.medical.po;

public class Hospitaldept {
    private Integer hospdeptid;

    private String hospdeptname;

    private String hospdeptabs;

    private Integer hospdeptfatherid;

    private Boolean hospdeptischeck;

    public Integer getHospdeptid() {
        return hospdeptid;
    }

    public void setHospdeptid(Integer hospdeptid) {
        this.hospdeptid = hospdeptid;
    }

    public String getHospdeptname() {
        return hospdeptname;
    }

    public void setHospdeptname(String hospdeptname) {
        this.hospdeptname = hospdeptname == null ? null : hospdeptname.trim();
    }

    public String getHospdeptabs() {
        return hospdeptabs;
    }

    public void setHospdeptabs(String hospdeptabs) {
        this.hospdeptabs = hospdeptabs == null ? null : hospdeptabs.trim();
    }

    public Integer getHospdeptfatherid() {
        return hospdeptfatherid;
    }

    public void setHospdeptfatherid(Integer hospdeptfatherid) {
        this.hospdeptfatherid = hospdeptfatherid;
    }

    public Boolean getHospdeptischeck() {
        return hospdeptischeck;
    }

    public void setHospdeptischeck(Boolean hospdeptischeck) {
        this.hospdeptischeck = hospdeptischeck;
    }
}