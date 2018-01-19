package com.medical.po;

public class Adminrole {
    private Integer roleid;

    private String rolename;

    private Integer rolemenuid;

    private String roledescription;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Integer getRolemenuid() {
        return rolemenuid;
    }

    public void setRolemenuid(Integer rolemenuid) {
        this.rolemenuid = rolemenuid;
    }

    public String getRoledescription() {
        return roledescription;
    }

    public void setRoledescription(String roledescription) {
        this.roledescription = roledescription == null ? null : roledescription.trim();
    }
}