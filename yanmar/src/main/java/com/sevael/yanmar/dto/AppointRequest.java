package com.sevael.yanmar.dto;

import java.time.LocalDate;

public class AppointRequest {
	private int appointment_type;
	private String duration;
	private LocalDate appointment_date;
	private String visitor_email;
	private String purpose;
	private int location;
	
//  Constructors
	public AppointRequest() {}
	
//	Constructors for Type1 (Includes Email)
	public AppointRequest(int appointment_type,String duration,
			LocalDate appointment_date,String visitor_email,String purpose,int location) {
		this.appointment_type = appointment_type;
		this.duration = duration;
		this.appointment_date = appointment_date;
		this.visitor_email = visitor_email;
		this.purpose = purpose;
		this.location = location;
	}
	
//	Constructors for Type2 (Not includes Email)
	public AppointRequest(int appointment_type,String duration,
			LocalDate appointment_date,int location) {	
		this.appointment_type = appointment_type;
		this.duration = duration;
		this.appointment_date = appointment_date;
		this.location = location;
	}

//	Getters & Setters
	public int getAppointment_type() {
		return appointment_type;
	}

	public void setAppointment_type(int appointment_type) {
		this.appointment_type = appointment_type;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}
	
}
