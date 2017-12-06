/**
 * 
 */
package com.medical.po.custom.doctor.purse;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName:     Purse.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author          xyh
 * @version         V1.0  
 * @Date           2017年11月28日 上午9:52:11 
 */
public class Purse {
	private Integer docpurseid;
	private Integer docpursetypeid;
	private String pursetypename;
	private BigDecimal docpurseamount;
	private Date docpursetime;
	private Integer payid;
	private BigDecimal docpursebalance;
	public Integer getDocpurseid() {
		return docpurseid;
	}
	public void setDocpurseid(Integer docpurseid) {
		this.docpurseid = docpurseid;
	}
	public Integer getDocpursetypeid() {
		return docpursetypeid;
	}
	public void setDocpursetypeid(Integer docpursetypeid) {
		this.docpursetypeid = docpursetypeid;
	}
	public String getPursetypename() {
		return pursetypename;
	}
	public void setPursetypename(String pursetypename) {
		this.pursetypename = pursetypename;
	}
	public BigDecimal getDocpurseamount() {
		return docpurseamount;
	}
	public void setDocpurseamount(BigDecimal docpurseamount) {
		this.docpurseamount = docpurseamount;
	}
	public Date getDocpursetime() {
		return docpursetime;
	}
	public void setDocpursetime(Date docpursetime) {
		this.docpursetime = docpursetime;
	}
	public Integer getPayid() {
		return payid;
	}
	public void setPayid(Integer payid) {
		this.payid = payid;
	}
	public BigDecimal getDocpursebalance() {
		return docpursebalance;
	}
	public void setDocpursebalance(BigDecimal docpursebalance) {
		this.docpursebalance = docpursebalance;
	}
	
}
