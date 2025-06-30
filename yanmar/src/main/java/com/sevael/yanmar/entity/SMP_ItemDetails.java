package com.sevael.yanmar.entity;

import jakarta.persistence.*;

@Entity
@Table(name="smp_item_details")
public class SMP_ItemDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String item_name;
	
	private int quantity;
	
	private int unit;
	
	private int value;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id") // this is the FK column in item_details table
    private SMP_SupplierDetails supplier;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SMP_SupplierDetails getSupplier() {
		return supplier;
	}

	public void setSupplier(SMP_SupplierDetails supplier) {
		this.supplier = supplier;
	}
	
	
}
