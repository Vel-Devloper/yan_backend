package com.sevael.yanmar.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="smp_other_details")
public class SMP_OtherDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String invoice_number;
	
	private LocalDate invoice_date;
	
	private Float Overall_value;
	
	private LocalDate mat_due_date;
	
	private int gate_no;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return Overall_value;
	}

	public void setOverall_value(Float overall_value) {
		Overall_value = overall_value;
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
