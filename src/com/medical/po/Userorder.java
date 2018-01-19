package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

public class Userorder {
    private Integer userorderid;

    private Integer userorderstateid;

    private Date userorderptime;

    private Integer userorderdocloginid;

    private Integer userorderrecdocloginid;

    private Date userorderrtime;

    private BigDecimal userorderdprice;

    private String userorderappointment;

    private Date userorderetime;

    private Integer userorderactualhospitalizationid;

    private Boolean userorderhstate;

    private Date userorderchosehosptime;

    private Date userorderhospconfirmtime;

    private Date userorderleavehosptime;

    private Integer userorderhospid;

    private BigDecimal userorderdeposit;

    private BigDecimal userordertotaldeposit;

    private BigDecimal userorderhprice;

    private String userorderhospprimarydept;

    private String userorderhospseconddept;

    private Integer userordertpricetype;

    private BigDecimal userordertprice;

    private Integer userorderapricetype;

    private BigDecimal userorderaprice;

    private Integer userorderepricetype;

    private BigDecimal userordereprice;

    private BigDecimal userorderprice;

    private Integer usersickid;

    private Integer userloginid;

    private Date userorderfinishtime;

    private String usersickdesc;

    private String usersickpic;

    private String usersickprimarydept;

    private String usersickseconddept;

    private String familyname;

    private String familymale;

    private Integer familyage;

    private String docaddresslocation;

    private String docaddressprovince;

    private String docaddresscity;

    private String docaddressarea;

    private String docaddressother;

    private String docaddresslon;

    private String docaddresslat;

    private String cancelreason;

    private String auditopinion;

    public Integer getUserorderid() {
        return userorderid;
    }

    public void setUserorderid(Integer userorderid) {
        this.userorderid = userorderid;
    }

    public Integer getUserorderstateid() {
        return userorderstateid;
    }

    public void setUserorderstateid(Integer userorderstateid) {
        this.userorderstateid = userorderstateid;
    }

    public Date getUserorderptime() {
        return userorderptime;
    }

    public void setUserorderptime(Date userorderptime) {
        this.userorderptime = userorderptime;
    }

    public Integer getUserorderdocloginid() {
        return userorderdocloginid;
    }

    public void setUserorderdocloginid(Integer userorderdocloginid) {
        this.userorderdocloginid = userorderdocloginid;
    }

    public Integer getUserorderrecdocloginid() {
        return userorderrecdocloginid;
    }

    public void setUserorderrecdocloginid(Integer userorderrecdocloginid) {
        this.userorderrecdocloginid = userorderrecdocloginid;
    }

    public Date getUserorderrtime() {
        return userorderrtime;
    }

    public void setUserorderrtime(Date userorderrtime) {
        this.userorderrtime = userorderrtime;
    }

    public BigDecimal getUserorderdprice() {
        return userorderdprice;
    }

    public void setUserorderdprice(BigDecimal userorderdprice) {
        this.userorderdprice = userorderdprice;
    }

    public String getUserorderappointment() {
        return userorderappointment;
    }

    public void setUserorderappointment(String userorderappointment) {
        this.userorderappointment = userorderappointment == null ? null : userorderappointment.trim();
    }

    public Date getUserorderetime() {
        return userorderetime;
    }

    public void setUserorderetime(Date userorderetime) {
        this.userorderetime = userorderetime;
    }

    public Integer getUserorderactualhospitalizationid() {
        return userorderactualhospitalizationid;
    }

    public void setUserorderactualhospitalizationid(Integer userorderactualhospitalizationid) {
        this.userorderactualhospitalizationid = userorderactualhospitalizationid;
    }

    public Boolean getUserorderhstate() {
        return userorderhstate;
    }

    public void setUserorderhstate(Boolean userorderhstate) {
        this.userorderhstate = userorderhstate;
    }

    public Date getUserorderchosehosptime() {
        return userorderchosehosptime;
    }

    public void setUserorderchosehosptime(Date userorderchosehosptime) {
        this.userorderchosehosptime = userorderchosehosptime;
    }

    public Date getUserorderhospconfirmtime() {
        return userorderhospconfirmtime;
    }

    public void setUserorderhospconfirmtime(Date userorderhospconfirmtime) {
        this.userorderhospconfirmtime = userorderhospconfirmtime;
    }

    public Date getUserorderleavehosptime() {
        return userorderleavehosptime;
    }

    public void setUserorderleavehosptime(Date userorderleavehosptime) {
        this.userorderleavehosptime = userorderleavehosptime;
    }

    public Integer getUserorderhospid() {
        return userorderhospid;
    }

    public void setUserorderhospid(Integer userorderhospid) {
        this.userorderhospid = userorderhospid;
    }

    public BigDecimal getUserorderdeposit() {
        return userorderdeposit;
    }

    public void setUserorderdeposit(BigDecimal userorderdeposit) {
        this.userorderdeposit = userorderdeposit;
    }

    public BigDecimal getUserordertotaldeposit() {
        return userordertotaldeposit;
    }

    public void setUserordertotaldeposit(BigDecimal userordertotaldeposit) {
        this.userordertotaldeposit = userordertotaldeposit;
    }

    public BigDecimal getUserorderhprice() {
        return userorderhprice;
    }

    public void setUserorderhprice(BigDecimal userorderhprice) {
        this.userorderhprice = userorderhprice;
    }

    public String getUserorderhospprimarydept() {
        return userorderhospprimarydept;
    }

    public void setUserorderhospprimarydept(String userorderhospprimarydept) {
        this.userorderhospprimarydept = userorderhospprimarydept == null ? null : userorderhospprimarydept.trim();
    }

    public String getUserorderhospseconddept() {
        return userorderhospseconddept;
    }

    public void setUserorderhospseconddept(String userorderhospseconddept) {
        this.userorderhospseconddept = userorderhospseconddept == null ? null : userorderhospseconddept.trim();
    }

    public Integer getUserordertpricetype() {
        return userordertpricetype;
    }

    public void setUserordertpricetype(Integer userordertpricetype) {
        this.userordertpricetype = userordertpricetype;
    }

    public BigDecimal getUserordertprice() {
        return userordertprice;
    }

    public void setUserordertprice(BigDecimal userordertprice) {
        this.userordertprice = userordertprice;
    }

    public Integer getUserorderapricetype() {
        return userorderapricetype;
    }

    public void setUserorderapricetype(Integer userorderapricetype) {
        this.userorderapricetype = userorderapricetype;
    }

    public BigDecimal getUserorderaprice() {
        return userorderaprice;
    }

    public void setUserorderaprice(BigDecimal userorderaprice) {
        this.userorderaprice = userorderaprice;
    }

    public Integer getUserorderepricetype() {
        return userorderepricetype;
    }

    public void setUserorderepricetype(Integer userorderepricetype) {
        this.userorderepricetype = userorderepricetype;
    }

    public BigDecimal getUserordereprice() {
        return userordereprice;
    }

    public void setUserordereprice(BigDecimal userordereprice) {
        this.userordereprice = userordereprice;
    }

    public BigDecimal getUserorderprice() {
        return userorderprice;
    }

    public void setUserorderprice(BigDecimal userorderprice) {
        this.userorderprice = userorderprice;
    }

    public Integer getUsersickid() {
        return usersickid;
    }

    public void setUsersickid(Integer usersickid) {
        this.usersickid = usersickid;
    }

    public Integer getUserloginid() {
        return userloginid;
    }

    public void setUserloginid(Integer userloginid) {
        this.userloginid = userloginid;
    }

    public Date getUserorderfinishtime() {
        return userorderfinishtime;
    }

    public void setUserorderfinishtime(Date userorderfinishtime) {
        this.userorderfinishtime = userorderfinishtime;
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

    public String getCancelreason() {
        return cancelreason;
    }

    public void setCancelreason(String cancelreason) {
        this.cancelreason = cancelreason == null ? null : cancelreason.trim();
    }

    public String getAuditopinion() {
        return auditopinion;
    }

    public void setAuditopinion(String auditopinion) {
        this.auditopinion = auditopinion == null ? null : auditopinion.trim();
    }
}