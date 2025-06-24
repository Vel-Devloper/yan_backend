package com.sevael.yanmar.dto;

import java.time.LocalDate;

public class AppointResponse {
	private Long id;
    private String message;
    private int request_type;
    private String visitor_email;
    private int appointment_type;
    private LocalDate appointment_date;
    private String formLink;  // New field
    
//	Constructors
	public AppointResponse() {}
	
//	Constructors for Type1 (Includes Email)
	public AppointResponse(Long id,String message,int request_type,String visitor_email,int appointment_type,String formLink,LocalDate appointment_date) {
		this.id = id;
		this.message = message;
		this.request_type = request_type;
		this.visitor_email = visitor_email;
		this.appointment_type = appointment_type;
		this.formLink=formLink; // New field
		this.appointment_date = appointment_date;
		
	}
	
//	Constructors for Type2 (Not Includes Email)
	public AppointResponse(Long id,String message,int request_type,int appointment_type,LocalDate appointment_date) {
		this.id = id;
		this.message = message;
		this.request_type = request_type;
		this.appointment_type = appointment_type;
		this.appointment_date = appointment_date;
		
	}
	
	
//	This Constructor is used to get the details to the front end.
	public AppointResponse(int appointment_type,LocalDate appointment_date) {	
		this.appointment_type = appointment_type;
		this.appointment_date = appointment_date;
	}


//	Getters & Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRequest_type() {
		return request_type;
	}

	public void setRequest_type(int request_type) {
		this.request_type = request_type;
	}

	public String getVisitor_email() {
		return visitor_email;
	}

	public void setVisitor_email(String visitor_email) {
		this.visitor_email = visitor_email;
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

	public String getFormLink() {
		return formLink;
	}

	public void setFormLink(String formLink) {
		this.formLink = formLink;
	}
}
