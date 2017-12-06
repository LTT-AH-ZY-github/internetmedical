package com.medical.po;

public class Hosplevel {
    private Integer hosplevelid;

    private String hosplevelname;

    public Integer getHosplevelid() {
        return hosplevelid;
    }

    public void setHosplevelid(Integer hosplevelid) {
        this.hosplevelid = hosplevelid;
    }

    public String getHosplevelname() {
        return hosplevelname;
    }

    public void setHosplevelname(String hosplevelname) {
        this.hosplevelname = hosplevelname == null ? null : hosplevelname.trim();
    }
}