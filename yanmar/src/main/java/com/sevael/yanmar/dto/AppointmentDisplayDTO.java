package com.sevael.yanmar.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AppointmentDisplayDTO {
		private Long id;
	    private String firstname;
	    private LocalDate appointment_date;
	    private String appointment_type;
	    private LocalDateTime checkin;
	    private LocalDateTime checkout;
	    private int approval_status;
	    
	    public AppointmentDisplayDTO() {}
	    
	    public AppointmentDisplayDTO(Long id,String firstname,LocalDate appointment_date,String appointment_type,LocalDateTime checkin,LocalDateTime checkout,
	    		int approval_status) {
	    	this.id= id;
	    	this.firstname=firstname;
	    	this.appointment_date=appointment_date;
	    	this.appointment_type=appointment_type;
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

	
		public String getAppointment_type() {
			return appointment_type;
		}

		public void setAppointment_type(String appointment_type) {
			this.appointment_type = appointment_type;
		}

		public LocalDateTime getCheckin() {
			return checkin;
		}

		public void setCheckin(LocalDateTime checkin) {
			this.checkin = checkin;
		}

		public LocalDateTime getCheckout() {
			return checkout;
		}

		public void setCheckout(LocalDateTime checkout) {
			this.checkout = checkout;
		}

		public int getApproval_status() {
			return approval_status;
		}

		public void setApproval_status(int approval_status) {
			this.approval_status = approval_status;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
	    
	
		
}
