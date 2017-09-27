package com.medical.po;

import org.hibernate.validator.constraints.NotBlank;

public class FamilyinfoCustom extends Familyinfo {
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}