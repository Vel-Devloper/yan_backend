package com.sevael.yanmar.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="smp_supplier_details")
public class SMP_SupplierDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String supplier_name;
	
	private String supplier_address;
	
	private Long phone_no;
	
	private String email;
	
	private LocalDate entry_date;
	
	private String gstnumber;
	
	private String state;
	
	private String location;
	
	@Column(name = "mat_requestid")
	private Long mat_requestid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getMat_requestid() {
		return mat_requestid;
	}

	public void setMat_requestid(Long mat_requestid) {
		this.mat_requestid = mat_requestid;
	}
	
	
}
