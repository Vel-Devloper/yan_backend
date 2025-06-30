package com.sevael.yanmar.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "mat_appointment_reject")
public class SMPAppointReject {
	
	
	@Id
    private int id;

    private LocalTime start_time;
    
    private LocalTime end_time;
    
    private LocalDate modified_date;
    
    private String wharehouse_name;
    
    private String others;
    
    @Column(name = "mat_requestid")
	private Long mat_requestid;
}