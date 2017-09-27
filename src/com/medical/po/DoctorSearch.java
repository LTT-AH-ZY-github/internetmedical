package com.medical.po;

public class DoctorSearch {
	private Integer pageNo;

	private Integer pageSize;

	private String lat;

	private String lon;

	private String province;

	private String city;

	private String area;

	private String time;

	private String primaryDept;

	private String secondDept;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	

	public String getPrimaryDept() {
		return primaryDept;
	}

	public void setPrimaryDept(String primaryDept) {
		this.primaryDept = primaryDept;
	}

	public String getSecondDept() {
		return secondDept;
	}

	public void setSecondDept(String secondDept) {
		this.secondDept = secondDept;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
