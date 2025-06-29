package com.sevael.yanmar.dto;

import java.time.LocalDateTime;

public class VCheckInOutUpdateDTO {
	
	private LocalDateTime checkin;
	private LocalDateTime checkout;

	public LocalDateTime getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDateTime checkin) {
		this.checkin = checkin;
	}

	public LocalDateTime getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDateTime checkout) {
		this.checkout = checkout;
	}
	
}
