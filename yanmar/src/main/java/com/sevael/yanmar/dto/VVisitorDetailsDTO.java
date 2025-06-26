package com.sevael.yanmar.dto;

import org.springframework.web.multipart.MultipartFile;

public class VVisitorDetailsDTO {
	private String firstname;
	private String lastname;
	private String email;
	private Long phone_no;
	private String org_name;
	private String org_address;
	private int proof_type;
	private String proof_id;
	private String visitor_row;
	private MultipartFile photoFile;
	
//	Constructors
	public VVisitorDetailsDTO() {}
	
	public VVisitorDetailsDTO(String firstname,String lastname,String email,Long phone_no,String org_name,
			String org_address,int proof_type,String proof_id,String visitor_row,MultipartFile photoFile) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone_no = phone_no;
		this.org_name = org_name;
		this.org_address = org_address;
		this.proof_type = proof_type;
		this.proof_id = proof_id;
		this.visitor_row = visitor_row;
		this.photoFile = photoFile;
	}
	
//	This Constructor is used to get the details to the front end.
	public VVisitorDetailsDTO(String firstname) {
		this.firstname = firstname;
	}

//	Getters & Setters
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

	public String getVisitor_row() {
		return visitor_row;
	}

	public void setVisitor_row(String visitor_row) {
		this.visitor_row = visitor_row;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}
	
	
}
