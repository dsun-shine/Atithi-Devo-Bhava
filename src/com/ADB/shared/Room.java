package com.ADB.shared;

import java.io.Serializable;

public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String bed;
	String service;
	String wifi;
	String price;
	String AC;
	String person;
	String username;
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAC() {
		return AC;
	}
	public void setAC(String aC) {
		this.AC = aC;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
