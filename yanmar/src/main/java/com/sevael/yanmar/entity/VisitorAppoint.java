package com.sevael.yanmar.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="core_appointment_request")
public class VisitorAppoint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "appointment_type", referencedColumnName = "id")
	private AppointmentType appointmentType;
//	private int appointment_type;
	
	private LocalDate appointment_date;
	
	private String visitor_email;
	
	private int request_type;
	
	private int approval_status;
	
	private String duration;
	
	private int location;
	
	private String purpose;
	
	private int created_by;
	
	@Column(unique = true, nullable = false,name="uuidtoken")
    private String token;
	
	@OneToMany(mappedBy = "visitorAppoint", cascade = CascadeType.ALL)
	private List<VisitorUserDetailsForm> visitorDetails;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
