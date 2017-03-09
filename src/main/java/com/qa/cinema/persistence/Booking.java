package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	private Long booking_ID;
	@NotNull
	private int numberOfSeats;
	@NotNull
	private String customerEmail;

	public Booking(int numberOfSeats, String customerEmail) {
		this.numberOfSeats = numberOfSeats;
		this.customerEmail = customerEmail;
	}

	public Booking() {
		
	}

	public Long getBooking_ID() {
		return booking_ID;
	}

	public void setBooking_ID(Long bookingID) {
		this.booking_ID = bookingID;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
}