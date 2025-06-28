package com.sevael.yanmar.dto;

import java.time.LocalDate;

public class AppointmentDisplayDTO {
	    private String firstname;
	    private LocalDate appointment_date;
//	    private String hostName;
	    private int appointment_type;
	    private LocalDate checkin;
	    private LocalDate checkout;
	    private int approval_status;
	    
	    public AppointmentDisplayDTO() {}
	    
	    public AppointmentDisplayDTO(String firstname,LocalDate appointment_date,int appointment_type,LocalDate checkin,LocalDate checkout,
	    		int approval_status) {
	    	this.firstname=firstname;
	    	this.appointment_date=appointment_date;
	    	this.checkin=checkin;
	    	this.checkout=checkout;
	    	this.approval_status=approval_status;
	    }

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public LocalDate getAppointment_date() {
			return appointment_date;
		}

		public void setAppointment_date(LocalDate appointment_date) {
			this.appointment_date = appointment_date;
		}

		public int getAppointment_type() {
			return appointment_type;
		}

		public void setAppointment_type(int appointment_type) {
			this.appointment_type = appointment_type;
		}

		public LocalDate getCheckin() {
			return checkin;
		}

		public void setCheckin(LocalDate checkin) {
			this.checkin = checkin;
		}

		public LocalDate getCheckout() {
			return checkout;
		}

		public void setCheckout(LocalDate checkout) {
			this.checkout = checkout;
		}

		public int getApproval_status() {
			return approval_status;
		}

		public void setApproval_status(int approval_status) {
			this.approval_status = approval_status;
		}
	    
	
		
}
