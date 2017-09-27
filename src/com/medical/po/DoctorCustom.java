package com.medical.po;

import java.util.Date;

public class DoctorCustom extends Doctorinfo{
	private Date doclogintime;
	
	private Integer docloginid;
	
	public Integer getDocloginid() {
		return docloginid;
	}

	public void setDocloginid(Integer docloginid) {
		this.docloginid = docloginid;
	}

	private String docloginlon;

	private String docloginlat;

	private String docloginloc;
	 
	private String distance;
	 
	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Date getDoclogintime() {
		return doclogintime;
	}

	public void setDoclogintime(Date doclogintime) {
		this.doclogintime = doclogintime;
	}

	public String getDocloginlon() {
		return docloginlon;
	}

	public void setDocloginlon(String docloginlon) {
		this.docloginlon = docloginlon;
	}

	public String getDocloginlat() {
		return docloginlat;
	}

	public void setDocloginlat(String docloginlat) {
		this.docloginlat = docloginlat;
	}

	public String getDocloginloc() {
		return docloginloc;
	}

	public void setDocloginloc(String docloginloc) {
		this.docloginloc = docloginloc;
	}
	
}
