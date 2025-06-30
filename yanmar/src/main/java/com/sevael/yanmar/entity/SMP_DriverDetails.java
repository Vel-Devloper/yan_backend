package com.sevael.yanmar.entity;

import jakarta.persistence.*;

@Entity
@Table(name="smp_driver_details")
public class SMP_DriverDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String driver_name;
	
	private Long phone_no;
	
	private String license_no;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_id") // this will be the foreign key column in the table
	private SMP_SupplierDetails supplier;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}

	public String getLicense_no() {
		return license_no;
	}

	public void setLicense_no(String license_no) {
		this.license_no = license_no;
	}

	public SMP_SupplierDetails getSupplier() {
		return supplier;
	}

	public void setSupplier(SMP_SupplierDetails supplier) {
		this.supplier = supplier;
	}
	
}
