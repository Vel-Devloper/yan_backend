package com.sevael.yanmar.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="visitor_details")
public class VisitorUserDetailsForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private Long phone_no;
	
	private String org_name;
	
	private String org_address;
	
	private int proof_type;
	
	private String proof_id;
	
	private Long vehicleid;
	
	private Long appointment_id;
	
	private String visitor_row;
//	@ManyToOne
//	@JoinColumn(name = "vehicle_id") // Foreign key in the user table
//	private VisitorVehicleDetailsForm vehicle;
	
	private int approval_status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getOrg_address() {
		return org_address;
	}

	public void setOrg_address(String org_address) {
		this.org_address = org_address;
	}

	public int getProof_type() {
		return proof_type;
	}

	public void setProof_type(int proof_type) {
		this.proof_type = proof_type;
	}

	public String getProof_id() {
		return proof_id;
	}

	public void setProof_id(String proof_id) {
		this.proof_id = proof_id;
	}

	public int getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(int approval_status) {
		this.approval_status = approval_status;
	}
	
	public String getVisitor_row() {
		return visitor_row;
	}

	public void setVisitor_row(String visitor_row) {
		this.visitor_row = visitor_row;
	}
	
//	public VisitorVehicleDetailsForm getVehicle() {
//		return vehicle;
//	}
//
//	public void setVehicle(VisitorVehicleDetailsForm vehicle) {
//		this.vehicle = vehicle;
//	}


	public Long getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(Long appointment_id) {
		this.appointment_id = appointment_id;
	}

	public Long getVehicle_id() {
		return vehicleid;
	}

	public void setVehicle_id(Long vehicle_id) {
		this.vehicleid = vehicle_id;
	}

	@OneToMany(mappedBy = "visitoruserdetailsform", cascade = CascadeType.ALL)
    private List<VisitorDeviceDetailsForm> visitordevicedetails;
	
}
