package com.sevael.yanmar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "internal_user")
public class SMP_VendorAttachment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String filepath;
	
	private Long mat_appoint_id;
	
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

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Long getMat_appoint_id() {
		return mat_appoint_id;
	}

	public void setMat_appoint_id(Long mat_appoint_id) {
		this.mat_appoint_id = mat_appoint_id;
	}
	
}