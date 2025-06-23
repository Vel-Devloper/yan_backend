package com.sevael.yanmar.entity;

import jakarta.persistence.*;

@Entity
@Table(name="device_details")
public class VisitorDeviceDetailsForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String device_name;
	
	private String device_model;
	
	private String device_type;
	
	@ManyToOne
    @JoinColumn(name = "visitor_id") // foreign key column
    private VisitorUserDetailsForm visitoruserdetailsform;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public String getDevice_model() {
		return device_model;
	}

	public void setDevice_model(String device_model) {
		this.device_model = device_model;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	
	public VisitorUserDetailsForm getVisitoruserdetailsform() {
	    return visitoruserdetailsform;
	}

	public void setVisitoruserdetailsform(VisitorUserDetailsForm visitoruserdetailsform) {
	    this.visitoruserdetailsform = visitoruserdetailsform;
	}
}
