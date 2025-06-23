package com.sevael.yanmar.dto;

import java.time.LocalDate;

public class MaterialAppointRequest {
	private String supplier_name;
	private String supplier_email;
	private int entry_type;
	private LocalDate expec_delivery_date;
	private int priority_level;
	private String purpose;
	
//	Constructors
	public MaterialAppointRequest() {}
	
	public MaterialAppointRequest(String supplier_name,String supplier_email,int entry_type,
			LocalDate expec_delivery_date,int priority_level,String purpose) {
		this.supplier_name = supplier_name;
		this.supplier_email = supplier_email;
		this.entry_type = entry_type;
		this.expec_delivery_date = expec_delivery_date;
		this.priority_level = priority_level;
		this.purpose = purpose;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_email() {
		return supplier_email;
	}

	public void setSupplier_email(String supplier_email) {
		this.supplier_email = supplier_email;
	}

	public int getEntry_type() {
		return entry_type;
	}

	public void setEntry_type(int entry_type) {
		this.entry_type = entry_type;
	}

	public LocalDate getExpec_delivery_date() {
		return expec_delivery_date;
	}

	public void setExpec_delivery_date(LocalDate expec_delivery_date) {
		this.expec_delivery_date = expec_delivery_date;
	}

	public int getPriority_level() {
		return priority_level;
	}

	public void setPriority_level(int priority_level) {
		this.priority_level = priority_level;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
}
