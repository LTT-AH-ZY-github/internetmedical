package com.medical.po;

public class Hospitaldept {
    private Integer hospdeptid;

    private String hospdeptname;

    private String hospdeptabs;

    private Integer hospdeptfatherid;

    private Integer hospdeptischeck;

    private Integer hospdeptsubmitter;

    private Integer hospdeptsubmittertype;

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

    public Integer getHospdeptischeck() {
        return hospdeptischeck;
    }

    public void setHospdeptischeck(Integer hospdeptischeck) {
        this.hospdeptischeck = hospdeptischeck;
    }

    public Integer getHospdeptsubmitter() {
        return hospdeptsubmitter;
    }

    public void setHospdeptsubmitter(Integer hospdeptsubmitter) {
        this.hospdeptsubmitter = hospdeptsubmitter;
    }

    public Integer getHospdeptsubmittertype() {
        return hospdeptsubmittertype;
    }

    public void setHospdeptsubmittertype(Integer hospdeptsubmittertype) {
        this.hospdeptsubmittertype = hospdeptsubmittertype;
    }
}