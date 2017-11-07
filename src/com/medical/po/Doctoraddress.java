package com.medical.po;

public class Doctoraddress {
    private Integer docaddressid;

    private String docaddresslocation;

    private String docaddressprovince;

    private String docaddresscity;

    private String docaddressarea;

    private String docaddressother;

    private String docaddresslon;

    private String docaddresslat;

    private Integer docloginid;

    private Boolean docaddresstype;

    private Boolean docaddresschecked;

    public Integer getDocaddressid() {
        return docaddressid;
    }

    public void setDocaddressid(Integer docaddressid) {
        this.docaddressid = docaddressid;
    }

    public String getDocaddresslocation() {
        return docaddresslocation;
    }

    public void setDocaddresslocation(String docaddresslocation) {
        this.docaddresslocation = docaddresslocation == null ? null : docaddresslocation.trim();
    }

    public String getDocaddressprovince() {
        return docaddressprovince;
    }

    public void setDocaddressprovince(String docaddressprovince) {
        this.docaddressprovince = docaddressprovince == null ? null : docaddressprovince.trim();
    }

    public String getDocaddresscity() {
        return docaddresscity;
    }

    public void setDocaddresscity(String docaddresscity) {
        this.docaddresscity = docaddresscity == null ? null : docaddresscity.trim();
    }

    public String getDocaddressarea() {
        return docaddressarea;
    }

    public void setDocaddressarea(String docaddressarea) {
        this.docaddressarea = docaddressarea == null ? null : docaddressarea.trim();
    }

    public String getDocaddressother() {
        return docaddressother;
    }

    public void setDocaddressother(String docaddressother) {
        this.docaddressother = docaddressother == null ? null : docaddressother.trim();
    }

    public String getDocaddresslon() {
        return docaddresslon;
    }

    public void setDocaddresslon(String docaddresslon) {
        this.docaddresslon = docaddresslon == null ? null : docaddresslon.trim();
    }

    public String getDocaddresslat() {
        return docaddresslat;
    }

    public void setDocaddresslat(String docaddresslat) {
        this.docaddresslat = docaddresslat == null ? null : docaddresslat.trim();
    }

    public Integer getDocloginid() {
        return docloginid;
    }

    public void setDocloginid(Integer docloginid) {
        this.docloginid = docloginid;
    }

    public Boolean getDocaddresstype() {
        return docaddresstype;
    }

    public void setDocaddresstype(Boolean docaddresstype) {
        this.docaddresstype = docaddresstype;
    }

    public Boolean getDocaddresschecked() {
        return docaddresschecked;
    }

    public void setDocaddresschecked(Boolean docaddresschecked) {
        this.docaddresschecked = docaddresschecked;
    }
}