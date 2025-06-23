package com.sevael.yanmar.dto;

import java.time.LocalDate;

public class SMPSupplierDetailsDTO {
	private String supplier_name;
	private String supplier_address;
	private Long phone_no;
	private String email;
	private LocalDate entry_date;
	private String gstnumber;
	private String state;
	private String location;
	
	public SMPSupplierDetailsDTO(){}
	
	public SMPSupplierDetailsDTO(String supplier_name,String supplier_address,Long phone_no
			,String email,LocalDate entry_date,String gstnumber,String state,String location) {
		this.supplier_name = supplier_name;
		this.supplier_address = supplier_address;
		this.phone_no = phone_no;
		this.email = email;
		this.entry_date = entry_date;
		this.gstnumber = gstnumber;
		this.state = state;
		this.location = location;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_address() {
		return supplier_address;
	}

	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(LocalDate entry_date) {
		this.entry_date = entry_date;
	}

	public String getGstnumber() {
		return gstnumber;
	}

	public void setGstnumber(String gstnumber) {
		this.gstnumber = gstnumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
