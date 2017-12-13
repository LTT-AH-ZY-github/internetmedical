package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.medical.controller.validation.Add;
import com.medical.controller.validation.Del;
import com.medical.controller.validation.Update;
import com.wordnik.swagger.annotations.ApiModel;
@ApiModel
public class Hospitalunitprice {
	@NotNull(message="单价id为空",groups= {Update.class,Del.class})
	private Integer unitpriceid;
    @NotNull(message="医院登录id为空",groups= {Add.class,Update.class,Del.class})
    private Integer hosploginid;
    @NotEmpty(message="单价详情为空",groups= {Add.class})
    private String unitpricename;
    @NotNull(message="价格为空",groups= {Add.class})
    private BigDecimal unitpricenumber;
    @NotEmpty(message="单价详情为空",groups= {Add.class})
    private String unitpriceabs;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date unitpricetime;
    @NotEmpty(message="项目操作时间为空",groups= {Add.class})
    private String unitpriceoperatetime;

    public Integer getUnitpriceid() {
        return unitpriceid;
    }

    public void setUnitpriceid(Integer unitpriceid) {
        this.unitpriceid = unitpriceid;
    }

    public Integer getHosploginid() {
        return hosploginid;
    }

    public void setHosploginid(Integer hosploginid) {
        this.hosploginid = hosploginid;
    }

    public String getUnitpricename() {
        return unitpricename;
    }

    public void setUnitpricename(String unitpricename) {
        this.unitpricename = unitpricename == null ? null : unitpricename.trim();
    }

    public BigDecimal getUnitpricenumber() {
        return unitpricenumber;
    }

    public void setUnitpricenumber(BigDecimal unitpricenumber) {
        this.unitpricenumber = unitpricenumber;
    }

    public String getUnitpriceabs() {
        return unitpriceabs;
    }

    public void setUnitpriceabs(String unitpriceabs) {
        this.unitpriceabs = unitpriceabs == null ? null : unitpriceabs.trim();
    }

    public Date getUnitpricetime() {
        return unitpricetime;
    }

    public void setUnitpricetime(Date unitpricetime) {
        this.unitpricetime = unitpricetime;
    }

    public String getUnitpriceoperatetime() {
        return unitpriceoperatetime;
    }

    public void setUnitpriceoperatetime(String unitpriceoperatetime) {
        this.unitpriceoperatetime = unitpriceoperatetime == null ? null : unitpriceoperatetime.trim();
    }
}