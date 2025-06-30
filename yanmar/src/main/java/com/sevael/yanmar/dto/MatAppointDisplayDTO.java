package com.sevael.yanmar.dto;

import java.time.LocalDate;

public class MatAppointDisplayDTO {
	private String id;
	private String supplier_name;
	private String purpose;
	private LocalDate expec_delivery_date;
	private String driver_name;
	private String item_name;
	private int approval_status;
	
	public MatAppointDisplayDTO( ) {}
	
	public MatAppointDisplayDTO(String supplier_name,String purpose,LocalDate expec_delivery_date,
			String driver_name,String item_name,int approval_status) {
		this.supplier_name=supplier_name;
		this.purpose=purpose;
		this.expec_delivery_date=expec_delivery_date;
		this.driver_name=driver_name;
		this.item_name=item_name;
		this.approval_status=approval_status;
	}
	
	public MatAppointDisplayDTO(Long request_id, String supplier_name, String purpose,
            LocalDate expec_delivery_date, String driver_name,
            String item_name, int approval_status) {
		this.id = request_id != null ? request_id.toString() : null;
		this.supplier_name = supplier_name;
		this.purpose = purpose;
		this.expec_delivery_date = expec_delivery_date;
		this.driver_name = driver_name;
		this.item_name = item_name;
		this.approval_status = approval_status;
		}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public LocalDate getExpec_delivery_date() {
		return expec_delivery_date;
	}

	public void setExpec_delivery_date(LocalDate expec_delivery_date) {
		this.expec_delivery_date = expec_delivery_date;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(int approval_status) {
		this.approval_status = approval_status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
