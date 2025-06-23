package com.sevael.yanmar.entity;

import jakarta.persistence.*;

@Entity
@Table(name="external_user")
public class ExtUserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String username;
	
	@Column(unique=true)
	private String vendorid;
	
	private String password;
	
	private long isactive;
	
	private String vendor_name;

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

	public String getVendorid() {
		return vendorid;
	}

	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getIsactive() {
		return isactive;
	}

	public void setIsactive(long isactive) {
		this.isactive = isactive;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

}
