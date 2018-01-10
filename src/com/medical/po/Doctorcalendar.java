package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.medical.controller.validation.Add;
import com.medical.controller.validation.Get;
import com.medical.controller.validation.Update;

public class Doctorcalendar {
	@NotNull(message="日程id为空",groups= {Update.class,Update.class,Get.class})
    private Integer doccalendarid;
	@NotNull(message="时间为空",groups= {Add.class})
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date doccalendarday;
	@NotBlank(message="上下午为空",groups= {Add.class})
    private String doccalendartime;
	
    private String doccalendaraffair;
    @NotNull(message="地址id为空",groups= {Add.class})
    private Integer doccalendaradressid;
    @NotNull(message="医生登录id为空",groups= {Update.class,Update.class,Get.class})

    private Integer docloginid;
    private String doccalendartimeinterval;
    private Boolean doccalendarischeck;

    private String docaddresslocation;

    private String docaddressprovince;

    private String docaddresscity;

    private String docaddressarea;

    private String docaddressother;

    private String docaddresslon;

    private String docaddresslat;

    private BigDecimal doccalendarprice;

    public Integer getDoccalendarid() {
        return doccalendarid;
    }

    public void setDoccalendarid(Integer doccalendarid) {
        this.doccalendarid = doccalendarid;
    }

    public Date getDoccalendarday() {
        return doccalendarday;
    }

    public void setDoccalendarday(Date doccalendarday) {
        this.doccalendarday = doccalendarday;
    }

    public String getDoccalendartime() {
        return doccalendartime;
    }

    public void setDoccalendartime(String doccalendartime) {
        this.doccalendartime = doccalendartime == null ? null : doccalendartime.trim();
    }

    public String getDoccalendartimeinterval() {
        return doccalendartimeinterval;
    }

    public void setDoccalendartimeinterval(String doccalendartimeinterval) {
        this.doccalendartimeinterval = doccalendartimeinterval == null ? null : doccalendartimeinterval.trim();
    }

    public String getDoccalendaraffair() {
        return doccalendaraffair;
    }

    public void setDoccalendaraffair(String doccalendaraffair) {
        this.doccalendaraffair = doccalendaraffair == null ? null : doccalendaraffair.trim();
    }

    public Integer getDoccalendaradressid() {
        return doccalendaradressid;
    }

    public void setDoccalendaradressid(Integer doccalendaradressid) {
        this.doccalendaradressid = doccalendaradressid;
    }

    public Integer getDocloginid() {
        return docloginid;
    }

    public void setDocloginid(Integer docloginid) {
        this.docloginid = docloginid;
    }

    public Boolean getDoccalendarischeck() {
        return doccalendarischeck;
    }

    public void setDoccalendarischeck(Boolean doccalendarischeck) {
        this.doccalendarischeck = doccalendarischeck;
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

    public BigDecimal getDoccalendarprice() {
        return doccalendarprice;
    }

    public void setDoccalendarprice(BigDecimal doccalendarprice) {
        this.doccalendarprice = doccalendarprice;
    }
}