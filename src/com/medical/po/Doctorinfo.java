package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

public class Doctorinfo {
    private Integer docid;

    private Integer docloginid;

    private String docname;

    private String docmale;

    private Integer docage;

    private String doctitle;

    private String doccardnum;

    private String doccardphoto;

    private Date docbirthdate;

    private String docnation;

    private String dochosp;

    private String hosplevel;

    private String dochospprovince;

    private String dochospcity;

    private String dochosparea;

    private String dochospother;

    private String dochosplon;

    private String dochosplat;

    private String docprimarydept;

    private String docseconddept;

    private String doctitlephoto;

    private String docworkcardphoto;

    private String docqualphoto;

    private String docexpert;

    private String docotherphoto;

    private Boolean docallday;

    private String docabs;

    private String docaddresslocation;

    private String docaddressprovince;

    private String docaddresscity;

    private String docaddressarea;

    private String docaddressother;

    private String docaddresslon;

    private String docaddresslat;

    private String docdept;

    private String docalipayaccount;

    private BigDecimal docpursebalance;

    private String docalipayname;

    private BigDecimal docprice;

    public Integer getDocid() {
        return docid;
    }

    public void setDocid(Integer docid) {
        this.docid = docid;
    }

    public Integer getDocloginid() {
        return docloginid;
    }

    public void setDocloginid(Integer docloginid) {
        this.docloginid = docloginid;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname == null ? null : docname.trim();
    }

    public String getDocmale() {
        return docmale;
    }

    public void setDocmale(String docmale) {
        this.docmale = docmale == null ? null : docmale.trim();
    }

    public Integer getDocage() {
        return docage;
    }

    public void setDocage(Integer docage) {
        this.docage = docage;
    }

    public String getDoctitle() {
        return doctitle;
    }

    public void setDoctitle(String doctitle) {
        this.doctitle = doctitle == null ? null : doctitle.trim();
    }

    public String getDoccardnum() {
        return doccardnum;
    }

    public void setDoccardnum(String doccardnum) {
        this.doccardnum = doccardnum == null ? null : doccardnum.trim();
    }

    public String getDoccardphoto() {
        return doccardphoto;
    }

    public void setDoccardphoto(String doccardphoto) {
        this.doccardphoto = doccardphoto == null ? null : doccardphoto.trim();
    }

    public Date getDocbirthdate() {
        return docbirthdate;
    }

    public void setDocbirthdate(Date docbirthdate) {
        this.docbirthdate = docbirthdate;
    }

    public String getDocnation() {
        return docnation;
    }

    public void setDocnation(String docnation) {
        this.docnation = docnation == null ? null : docnation.trim();
    }

    public String getDochosp() {
        return dochosp;
    }

    public void setDochosp(String dochosp) {
        this.dochosp = dochosp == null ? null : dochosp.trim();
    }

    public String getHosplevel() {
        return hosplevel;
    }

    public void setHosplevel(String hosplevel) {
        this.hosplevel = hosplevel == null ? null : hosplevel.trim();
    }

    public String getDochospprovince() {
        return dochospprovince;
    }

    public void setDochospprovince(String dochospprovince) {
        this.dochospprovince = dochospprovince == null ? null : dochospprovince.trim();
    }

    public String getDochospcity() {
        return dochospcity;
    }

    public void setDochospcity(String dochospcity) {
        this.dochospcity = dochospcity == null ? null : dochospcity.trim();
    }

    public String getDochosparea() {
        return dochosparea;
    }

    public void setDochosparea(String dochosparea) {
        this.dochosparea = dochosparea == null ? null : dochosparea.trim();
    }

    public String getDochospother() {
        return dochospother;
    }

    public void setDochospother(String dochospother) {
        this.dochospother = dochospother == null ? null : dochospother.trim();
    }

    public String getDochosplon() {
        return dochosplon;
    }

    public void setDochosplon(String dochosplon) {
        this.dochosplon = dochosplon == null ? null : dochosplon.trim();
    }

    public String getDochosplat() {
        return dochosplat;
    }

    public void setDochosplat(String dochosplat) {
        this.dochosplat = dochosplat == null ? null : dochosplat.trim();
    }

    public String getDocprimarydept() {
        return docprimarydept;
    }

    public void setDocprimarydept(String docprimarydept) {
        this.docprimarydept = docprimarydept == null ? null : docprimarydept.trim();
    }

    public String getDocseconddept() {
        return docseconddept;
    }

    public void setDocseconddept(String docseconddept) {
        this.docseconddept = docseconddept == null ? null : docseconddept.trim();
    }

    public String getDoctitlephoto() {
        return doctitlephoto;
    }

    public void setDoctitlephoto(String doctitlephoto) {
        this.doctitlephoto = doctitlephoto == null ? null : doctitlephoto.trim();
    }

    public String getDocworkcardphoto() {
        return docworkcardphoto;
    }

    public void setDocworkcardphoto(String docworkcardphoto) {
        this.docworkcardphoto = docworkcardphoto == null ? null : docworkcardphoto.trim();
    }

    public String getDocqualphoto() {
        return docqualphoto;
    }

    public void setDocqualphoto(String docqualphoto) {
        this.docqualphoto = docqualphoto == null ? null : docqualphoto.trim();
    }

    public String getDocexpert() {
        return docexpert;
    }

    public void setDocexpert(String docexpert) {
        this.docexpert = docexpert == null ? null : docexpert.trim();
    }

    public String getDocotherphoto() {
        return docotherphoto;
    }

    public void setDocotherphoto(String docotherphoto) {
        this.docotherphoto = docotherphoto == null ? null : docotherphoto.trim();
    }

    public Boolean getDocallday() {
        return docallday;
    }

    public void setDocallday(Boolean docallday) {
        this.docallday = docallday;
    }

    public String getDocabs() {
        return docabs;
    }

    public void setDocabs(String docabs) {
        this.docabs = docabs == null ? null : docabs.trim();
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

    public String getDocdept() {
        return docdept;
    }

    public void setDocdept(String docdept) {
        this.docdept = docdept == null ? null : docdept.trim();
    }

    public String getDocalipayaccount() {
        return docalipayaccount;
    }

    public void setDocalipayaccount(String docalipayaccount) {
        this.docalipayaccount = docalipayaccount == null ? null : docalipayaccount.trim();
    }

    public BigDecimal getDocpursebalance() {
        return docpursebalance;
    }

    public void setDocpursebalance(BigDecimal docpursebalance) {
        this.docpursebalance = docpursebalance;
    }

    public String getDocalipayname() {
        return docalipayname;
    }

    public void setDocalipayname(String docalipayname) {
        this.docalipayname = docalipayname == null ? null : docalipayname.trim();
    }

    public BigDecimal getDocprice() {
        return docprice;
    }

    public void setDocprice(BigDecimal docprice) {
        this.docprice = docprice;
    }
}