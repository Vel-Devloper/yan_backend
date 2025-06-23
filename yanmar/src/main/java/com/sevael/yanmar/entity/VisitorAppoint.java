package com.sevael.yanmar.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="core_appointment_request")
public class VisitorAppoint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int appointment_type;
	
	private LocalDate appointment_date;
	
	private String visitor_email;
	
	private int request_type;
	
	private int approval_status;
	
	private String duration;
	
	private int location;
	
	private String purpose;
	
	private int created_by;
	
	@Column(unique = true, nullable = false)
    private String uuidtoken;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAppointment_type() {
		return appointment_type;
	}

	public void setAppointment_type(int appointment_type) {
		this.appointment_type = appointment_type;
	}

	public LocalDate getAppointment_date() {
		return appointment_date;
	}

	public void setAppointment_date(LocalDate appointment_date) {
		this.appointment_date = appointment_date;
	}

	public String getVisitor_email() {
		return visitor_email;
	}

	public void setVisitor_email(String visitor_email) {
		this.visitor_email = visitor_email;
	}

	public int getRequest_type() {
		return request_type;
	}

	public void setRequest_type(int request_type) {
		this.request_type = request_type;
	}

	public int getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(int approval_status) {
		this.approval_status = approval_status;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	
    public int getCreated_by() {
		return created_by;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}


	public String getUuidtoken() {
		return uuidtoken;
	}

	public void setUuidtoken(String uuidtoken) {
		this.uuidtoken = uuidtoken;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
