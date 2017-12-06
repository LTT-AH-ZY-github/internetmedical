package com.medical.po;

public class Accounttype {
    private Integer accounttypeid;

    private String accounttypename;

    public Integer getAccounttypeid() {
        return accounttypeid;
    }

    public void setAccounttypeid(Integer accounttypeid) {
        this.accounttypeid = accounttypeid;
    }

    public String getAccounttypename() {
        return accounttypename;
    }

    public void setAccounttypename(String accounttypename) {
        this.accounttypename = accounttypename == null ? null : accounttypename.trim();
    }
}