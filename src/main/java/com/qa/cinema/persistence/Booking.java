package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long booking_ID;
	@NotNull
	private int numberOfSeats;
	@NotNull
	private String customerEmail;
	
	private Long showing_ID;

	public Booking(int numberOfSeats, String customerEmail, Long showing_ID) {
		this.numberOfSeats = numberOfSeats;
		this.customerEmail = customerEmail;
		this.showing_ID = showing_ID;
	}

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Long getBooking_ID() {
		return booking_ID;
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
	
	public Long getShowing_ID() {
		return showing_ID;
	}

	public void setShowing_ID(Long showing_ID) {
		this.showing_ID = showing_ID;
	}


}
