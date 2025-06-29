package com.sevael.yanmar.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "appointment_type")
public class AppointmentType {

    @Id
    private int id;

    @Column(name = "appointment_type")
    private String appointment_type;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getAppointment_type() {
		return appointment_type;
	}

	public void setAppointment_type(String appointment_type) {
		this.appointment_type = appointment_type;
	}



}