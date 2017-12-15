package com.medical.po;

import java.util.Date;

public class Adminexamine {
    private Integer examineid;

    private Integer examinetype;

    private Integer examinetargetid;

    private Boolean examineresult;

    private String examineideas;

    private Date examinetime;

    public Integer getExamineid() {
        return examineid;
    }

    public void setExamineid(Integer examineid) {
        this.examineid = examineid;
    }

    public Integer getExaminetype() {
        return examinetype;
    }

    public void setExaminetype(Integer examinetype) {
        this.examinetype = examinetype;
    }

    public Integer getExaminetargetid() {
        return examinetargetid;
    }

    public void setExaminetargetid(Integer examinetargetid) {
        this.examinetargetid = examinetargetid;
    }

    public Boolean getExamineresult() {
        return examineresult;
    }

    public void setExamineresult(Boolean examineresult) {
        this.examineresult = examineresult;
    }

    public String getExamineideas() {
        return examineideas;
    }

    public void setExamineideas(String examineideas) {
        this.examineideas = examineideas == null ? null : examineideas.trim();
    }

    public Date getExaminetime() {
        return examinetime;
    }

    public void setExaminetime(Date examinetime) {
        this.examinetime = examinetime;
    }
}