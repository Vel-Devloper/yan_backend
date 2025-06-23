package com.sevael.yanmar.dto;

import java.time.LocalDate;

public class MaterialAppointResponse {
	private String message;
	private Long id;
	private String supplier_name;
	private int entry_type;
	private LocalDate expec_delivery_date;
	
//	Constructors
	public MaterialAppointResponse() {}
	
	public MaterialAppointResponse(String message,Long id,String supplier_name,int entry_type,
			LocalDate expec_delivery_date) {
		this.message = message;
		this.id = id;
		this.supplier_name = supplier_name;
		this.entry_type = entry_type;
		this.expec_delivery_date = expec_delivery_date;

	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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
	

}
