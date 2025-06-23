package com.sevael.yanmar.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "visitorlog")
public class VisitorLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String visitorname;
	
	private LocalDate visitdate;
	
	private String hostname;
	
	private String visittype;
	
	private LocalTime checkintime;
	
	private LocalTime checkouttime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVisitorname() {
		return visitorname;
	}

	public void setVisitorname(String visitorname) {
		this.visitorname = visitorname;
	}

	public LocalDate getVisitdate() {
		return visitdate;
	}

	public void setVisitdate(LocalDate visitdate) {
		this.visitdate = visitdate;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getVisittype() {
		return visittype;
	}

	public void setVisittype(String visittype) {
		this.visittype = visittype;
	}

	public LocalTime getCheckintime() {
		return checkintime;
	}

	public void setCheckintime(LocalTime checkintime) {
		this.checkintime = checkintime;
	}

	public LocalTime getCheckouttime() {
		return checkouttime;
	}

	public void setCheckouttime(LocalTime checkouttime) {
		this.checkouttime = checkouttime;
	}
}
