package com.medical.po;

public class Hospinfo {
    private Integer hospid;

    private String hospname;

    private String hospadr;

    private String hospphone;

    private String hospabs;

    private String hospgrade;

    private String hospdept;

    private String hospfeature;

    private String hospregdocquacer;

    private String hospregidcard;

    private String hosporgcodecer;

    private String hosppraclicense;

    private String hosplegalcer;

    private Integer hosploginid;

    public Integer getHospid() {
        return hospid;
    }

    public void setHospid(Integer hospid) {
        this.hospid = hospid;
    }

    public String getHospname() {
        return hospname;
    }

    public void setHospname(String hospname) {
        this.hospname = hospname == null ? null : hospname.trim();
    }

    public String getHospadr() {
        return hospadr;
    }

    public void setHospadr(String hospadr) {
        this.hospadr = hospadr == null ? null : hospadr.trim();
    }

    public String getHospphone() {
        return hospphone;
    }

    public void setHospphone(String hospphone) {
        this.hospphone = hospphone == null ? null : hospphone.trim();
    }

    public String getHospabs() {
        return hospabs;
    }

    public void setHospabs(String hospabs) {
        this.hospabs = hospabs == null ? null : hospabs.trim();
    }

    public String getHospgrade() {
        return hospgrade;
    }

    public void setHospgrade(String hospgrade) {
        this.hospgrade = hospgrade == null ? null : hospgrade.trim();
    }

    public String getHospdept() {
        return hospdept;
    }

    public void setHospdept(String hospdept) {
        this.hospdept = hospdept == null ? null : hospdept.trim();
    }

    public String getHospfeature() {
        return hospfeature;
    }

    public void setHospfeature(String hospfeature) {
        this.hospfeature = hospfeature == null ? null : hospfeature.trim();
    }

    public String getHospregdocquacer() {
        return hospregdocquacer;
    }

    public void setHospregdocquacer(String hospregdocquacer) {
        this.hospregdocquacer = hospregdocquacer == null ? null : hospregdocquacer.trim();
    }

    public String getHospregidcard() {
        return hospregidcard;
    }

    public void setHospregidcard(String hospregidcard) {
        this.hospregidcard = hospregidcard == null ? null : hospregidcard.trim();
    }

    public String getHosporgcodecer() {
        return hosporgcodecer;
    }

    public void setHosporgcodecer(String hosporgcodecer) {
        this.hosporgcodecer = hosporgcodecer == null ? null : hosporgcodecer.trim();
    }

    public String getHosppraclicense() {
        return hosppraclicense;
    }

    public void setHosppraclicense(String hosppraclicense) {
        this.hosppraclicense = hosppraclicense == null ? null : hosppraclicense.trim();
    }

    public String getHosplegalcer() {
        return hosplegalcer;
    }

    public void setHosplegalcer(String hosplegalcer) {
        this.hosplegalcer = hosplegalcer == null ? null : hosplegalcer.trim();
    }

    public Integer getHosploginid() {
        return hosploginid;
    }

    public void setHosploginid(Integer hosploginid) {
        this.hosploginid = hosploginid;
    }
}