package com.miguel.model;

import java.util.List;

public class ListItem {

	private String business_hours;

	private String address;
	private String province;
	private String mail;
	private String phone;
	private List<String> pos_code;
	private String latitude;
	private String district;
	private String establishment_id;
	private String longitude;

	public String getBusiness_hours() {
		return business_hours;
	}

	public void setBusiness_hours(String business_hours) {
		this.business_hours = business_hours;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getPos_code() {
		return pos_code;
	}

	public void setPos_code(List<String> pos_code) {
		this.pos_code = pos_code;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getEstablishment_id() {
		return establishment_id;
	}

	public void setEstablishment_id(String establishment_id) {
		this.establishment_id = establishment_id;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "ListItem [business_hours=" + business_hours + ", address=" + address + ", province=" + province
				+ ", mail=" + mail + ", phone=" + phone + ", pos_code=" + pos_code + ", latitude=" + latitude
				+ ", district=" + district + ", establishment_id=" + establishment_id + ", longitude=" + longitude
				+ "]";
	}

}
