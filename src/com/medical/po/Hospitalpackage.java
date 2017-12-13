package com.medical.po;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.medical.controller.validation.Add;
import com.medical.controller.validation.Update;

public class Hospitalpackage {
	@NotNull(message="套餐id为空",groups= {Update.class})
    private Integer packageid;
    @NotNull(message="医院登录id为空",groups= {Add.class,Update.class})
    private Integer hosploginid;
    @NotBlank(message="套餐名为空",groups= {Add.class})
    private String packagename;
    @NotNull(message="套餐价格为空",groups= {Add.class})
    private BigDecimal packagenumber;
    @NotBlank(message="套餐简介为空",groups= {Add.class})
    private String packageabs;

    private Date packagestime;

    private Date packageetime;

    private Integer packagesustime;

    private Date packagetime;

    private String packageoperatetime;

    public Integer getPackageid() {
        return packageid;
    }

    public void setPackageid(Integer packageid) {
        this.packageid = packageid;
    }

    public Integer getHosploginid() {
        return hosploginid;
    }

    public void setHosploginid(Integer hosploginid) {
        this.hosploginid = hosploginid;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename == null ? null : packagename.trim();
    }

    public BigDecimal getPackagenumber() {
        return packagenumber;
    }

    public void setPackagenumber(BigDecimal packagenumber) {
        this.packagenumber = packagenumber;
    }

    public String getPackageabs() {
        return packageabs;
    }

    public void setPackageabs(String packageabs) {
        this.packageabs = packageabs == null ? null : packageabs.trim();
    }

    public Date getPackagestime() {
        return packagestime;
    }

    public void setPackagestime(Date packagestime) {
        this.packagestime = packagestime;
    }

    public Date getPackageetime() {
        return packageetime;
    }

    public void setPackageetime(Date packageetime) {
        this.packageetime = packageetime;
    }

    public Integer getPackagesustime() {
        return packagesustime;
    }

    public void setPackagesustime(Integer packagesustime) {
        this.packagesustime = packagesustime;
    }

    public Date getPackagetime() {
        return packagetime;
    }

    public void setPackagetime(Date packagetime) {
        this.packagetime = packagetime;
    }

    public String getPackageoperatetime() {
        return packageoperatetime;
    }

    public void setPackageoperatetime(String packageoperatetime) {
        this.packageoperatetime = packageoperatetime == null ? null : packageoperatetime.trim();
    }
}