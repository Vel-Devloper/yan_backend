package com.sevael.yanmar.entity;

//import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="vehicle_details")
public class VisitorVehicleDetailsForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String vehicle_no;
	
	private String model;
	
	private String type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

//	Entity Relationship
//	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
//	private List<VisitorUserDetailsForm> users;

}
