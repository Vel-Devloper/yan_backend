package com.sevael.yanmar.entity;

import jakarta.persistence.*;

@Entity
@Table(name="smp_requester_details")
public class SMP_RequestorDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String requestor_name;
	
	private String department;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id") // this is the FK column in item_details table
    private SMP_SupplierDetails supplier;
	
	
	public SMP_SupplierDetails getSupplier() {
		return supplier;
	}

	public void setSupplier(SMP_SupplierDetails supplier) {
		this.supplier = supplier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestor_name() {
		return requestor_name;
	}

	public void setRequestor_name(String requestor_name) {
		this.requestor_name = requestor_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
