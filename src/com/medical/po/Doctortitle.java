package com.medical.po;

public class Doctortitle {
    private Integer doctitleid;

    private String doctitlename;

    public Integer getDoctitleid() {
        return doctitleid;
    }

    public void setDoctitleid(Integer doctitleid) {
        this.doctitleid = doctitleid;
    }

    public String getDoctitlename() {
        return doctitlename;
    }

    public void setDoctitlename(String doctitlename) {
        this.doctitlename = doctitlename == null ? null : doctitlename.trim();
    }
}