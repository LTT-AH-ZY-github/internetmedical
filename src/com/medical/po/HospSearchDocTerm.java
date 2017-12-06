package com.medical.po;

public class HospSearchDocTerm {

	// 职称
	private String doctorTitle;

	// 医院等级
	private String hospLevel;

	// 描述
	private String details;

	private Integer province_code;

	private Integer city_code;

	private Integer area_code;

	private Integer One_level_dept;

	private Integer Two_level_dept;

	public String getDoctorTitle() {
		return doctorTitle;
	}

	public void setDoctorTitle(String doctorTitle) {
		this.doctorTitle = doctorTitle;
	}

	

	public String getHospLevel() {
		return hospLevel;
	}

	public void setHospLevel(String hospLevel) {
		this.hospLevel = hospLevel;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getProvince_code() {
		return province_code;
	}

	public void setProvince_code(Integer province_code) {
		this.province_code = province_code;
	}

	public Integer getCity_code() {
		return city_code;
	}

	public void setCity_code(Integer city_code) {
		this.city_code = city_code;
	}

	public Integer getArea_code() {
		return area_code;
	}

	public void setArea_code(Integer area_code) {
		this.area_code = area_code;
	}

	public Integer getOne_level_dept() {
		return One_level_dept;
	}

	public void setOne_level_dept(Integer one_level_dept) {
		One_level_dept = one_level_dept;
	}

	public Integer getTwo_level_dept() {
		return Two_level_dept;
	}

	public void setTwo_level_dept(Integer two_level_dept) {
		Two_level_dept = two_level_dept;
	}

}
