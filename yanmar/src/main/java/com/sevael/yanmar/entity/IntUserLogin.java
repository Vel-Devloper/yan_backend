package com.sevael.yanmar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "internal_user")
public class IntUserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	@Column(unique=true)
	private String uniqueid;
	
	private String password;
	
	private long usertype;
	
	private int isactive;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUsertype() {
		return usertype;
	}

	public void setUsertype(long usertype) {
		this.usertype = usertype;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}
	
//	@OneToMany(mappedBy = "core_appointment_request", cascade = CascadeType.ALL)
//    private List<VisitorAppoint> visitorappoint;
//	
}
