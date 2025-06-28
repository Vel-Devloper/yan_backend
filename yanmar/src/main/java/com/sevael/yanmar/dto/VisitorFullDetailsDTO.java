package com.sevael.yanmar.dto;

public class VisitorFullDetailsDTO {
	
    private Long userId;
    private String firstname;
    private String lastname;
    private String phone_no;
    private String email;
    private String org_name;
    private String org_address;
    private int proof_type;
    private String proof_id;
    private String photoPath;

    private Long deviceId;
    private String device_name;
    private String device_model;
    private String device_type;

    private Long vehicleId;
    private String vehicle_no;
    private String model;
    private String type;

    private Long appointmentId;
    
    public VisitorFullDetailsDTO() {}
    
    public VisitorFullDetailsDTO(Long userId,String firstname,String lastname,String phone_no,String email,String org_name,String org_address,
 int proof_type, String proof_id, String photoPath, Long deviceId,String device_name,String device_model,String device_type,Long vehicleId,String vehicle_no, 
 String model, String type,Long appointmentId) {
    	this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone_no = phone_no;
        this.email = email;
        this.org_name = org_name;
        this.org_address = org_address;
        this.proof_type = proof_type;
        this.proof_id = proof_id;
        this.photoPath = photoPath;
        this.deviceId = deviceId;
        this.device_name = device_name;
        this.device_model = device_model;
        this.device_type = device_type;
        this.vehicleId = vehicleId;
        this.vehicle_no = vehicle_no;
        this.model = model;
        this.type = type;
        this.appointmentId = appointmentId;
    }
    
    
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
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

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
 
    
}