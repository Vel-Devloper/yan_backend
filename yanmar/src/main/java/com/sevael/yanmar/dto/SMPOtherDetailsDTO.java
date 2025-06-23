package com.sevael.yanmar.dto;

import java.time.LocalDate;

public class SMPOtherDetailsDTO {
	private String invoice_number;
	private LocalDate invoice_date;
	private Float overall_value;
	private LocalDate mat_due_date;
	private int gate_no;
	
	private SMPOtherDetailsDTO() {}
	
	private SMPOtherDetailsDTO(String invoice_number,LocalDate invoice_date,Float overall_value,int gate_no, LocalDate mat_due_date) {
		this.invoice_number = invoice_number;
		this.invoice_date = invoice_date;
		this.overall_value = overall_value;
		this.mat_due_date = mat_due_date;
		this.gate_no = gate_no;
	}

	public String getInvoice_number() {
		return invoice_number;
	}

	public void setInvoice_number(String invoice_number) {
		this.invoice_number = invoice_number;
	}


	public LocalDate getInvoice_date() {
		return invoice_date;
	}

	public void setInvoice_date(LocalDate invoice_date) {
		this.invoice_date = invoice_date;
	}

	public Float getOverall_value() {
		return overall_value;
	}

	public void setOverall_value(Float overall_value) {
		this.overall_value = overall_value;
	}

	public LocalDate getMat_due_date() {
		return mat_due_date;
	}

	public void setMat_due_date(LocalDate mat_due_date) {
		this.mat_due_date = mat_due_date;
	}

	public int getGate_no() {
		return gate_no;
	}

	public void setGate_no(int gate_no) {
		this.gate_no = gate_no;
	}
	
}
