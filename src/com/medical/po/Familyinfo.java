package com.medical.po;

public class Familyinfo {
    private Integer familyid;

    private String familyname;

    private String familymale;

    private Integer familyage;

    private Integer userloginid;

    private Boolean familytype;

    public Integer getFamilyid() {
        return familyid;
    }

    public void setFamilyid(Integer familyid) {
        this.familyid = familyid;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname == null ? null : familyname.trim();
    }

    public String getFamilymale() {
        return familymale;
    }

    public void setFamilymale(String familymale) {
        this.familymale = familymale == null ? null : familymale.trim();
    }

    public Integer getFamilyage() {
        return familyage;
    }

    public void setFamilyage(Integer familyage) {
        this.familyage = familyage;
    }

    public Integer getUserloginid() {
        return userloginid;
    }

    public void setUserloginid(Integer userloginid) {
        this.userloginid = userloginid;
    }

    public Boolean getFamilytype() {
        return familytype;
    }

    public void setFamilytype(Boolean familytype) {
        this.familytype = familytype;
    }
}