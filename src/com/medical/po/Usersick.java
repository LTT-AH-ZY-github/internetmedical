package com.medical.po;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class Usersick {
    private Integer usersickid;
    
    private String usersickdesc;

    private String usersickpic;

    private String usersickprimarydept;

    private String usersickseconddept;

    private Integer familyid;

    private Integer userorderid;

    private Integer userloginid;

    private Date usersicktime;

    private Integer usersickstateid;

    private Date usersickptime;

    private Boolean usersickisdelete;

    private String familyname;

    private String familymale;

    private Integer familyage;

    public Integer getUsersickid() {
        return usersickid;
    }

    public void setUsersickid(Integer usersickid) {
        this.usersickid = usersickid;
    }

    public String getUsersickdesc() {
        return usersickdesc;
    }

    public void setUsersickdesc(String usersickdesc) {
        this.usersickdesc = usersickdesc == null ? null : usersickdesc.trim();
    }

    public String getUsersickpic() {
        return usersickpic;
    }

    public void setUsersickpic(String usersickpic) {
        this.usersickpic = usersickpic == null ? null : usersickpic.trim();
    }

    public String getUsersickprimarydept() {
        return usersickprimarydept;
    }

    public void setUsersickprimarydept(String usersickprimarydept) {
        this.usersickprimarydept = usersickprimarydept == null ? null : usersickprimarydept.trim();
    }

    public String getUsersickseconddept() {
        return usersickseconddept;
    }

    public void setUsersickseconddept(String usersickseconddept) {
        this.usersickseconddept = usersickseconddept == null ? null : usersickseconddept.trim();
    }

    public Integer getFamilyid() {
        return familyid;
    }

    public void setFamilyid(Integer familyid) {
        this.familyid = familyid;
    }

    public Integer getUserorderid() {
        return userorderid;
    }

    public void setUserorderid(Integer userorderid) {
        this.userorderid = userorderid;
    }

    public Integer getUserloginid() {
        return userloginid;
    }

    public void setUserloginid(Integer userloginid) {
        this.userloginid = userloginid;
    }

    public Date getUsersicktime() {
        return usersicktime;
    }

    public void setUsersicktime(Date usersicktime) {
        this.usersicktime = usersicktime;
    }

    public Integer getUsersickstateid() {
        return usersickstateid;
    }

    public void setUsersickstateid(Integer usersickstateid) {
        this.usersickstateid = usersickstateid;
    }

    public Date getUsersickptime() {
        return usersickptime;
    }

    public void setUsersickptime(Date usersickptime) {
        this.usersickptime = usersickptime;
    }

    public Boolean getUsersickisdelete() {
        return usersickisdelete;
    }

    public void setUsersickisdelete(Boolean usersickisdelete) {
        this.usersickisdelete = usersickisdelete;
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
}