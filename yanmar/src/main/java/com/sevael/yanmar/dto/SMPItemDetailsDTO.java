package com.sevael.yanmar.dto;

public class SMPItemDetailsDTO {
	private String item_name;
	private int quantity;
	private int unit;
	private int value;
	
	private SMPItemDetailsDTO() {}
	
	private SMPItemDetailsDTO(String item_name,int quantity,int unit,int value) {
		this.item_name = item_name;
		this.quantity = quantity;
		this.unit = unit;
		this.value = value;
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
	
}
