package com.sevael.yanmar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mat_rejection_type")
public class SMP_MaterialRejection {
	
	@Id
    private int id;

    @Column(name = "rejection_type")
    private String rejection_type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRejection_type() {
		return rejection_type;
	}

	public void setRejection_type(String rejection_type) {
		this.rejection_type = rejection_type;
	}
}