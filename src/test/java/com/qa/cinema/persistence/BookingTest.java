package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookingTest {
	
	@Test
	public void testBookingIDSetter() {
		Booking testBook = new Booking(3, "test@test.com");
		testBook.setBooking_ID((long) 2);
		assertEquals(2, testBook.getBooking_ID().longValue());
	}
	
	@Test
	public void numberOfSeatsGetter() {
		Booking testBook = new Booking(3, "test@test.com");
		assertEquals(3, testBook.getNumberOfSeats());
	}
	
	@Test
	public void numberOfSeatsIDSetter() {
		Booking testBook = new Booking(3, "test@test.com");
		testBook.setNumberOfSeats(2);
		assertEquals(2, testBook.getNumberOfSeats());
	}
	
	@Test
	public void customerEmailGetter() {
		Booking testBook = new Booking(3, "test@test.com");
		assertEquals("test@test.com", testBook.getCustomerEmail());
	}
	
	@Test
	public void customerEmailSetter() {
		Booking testBook = new Booking();
		testBook.setCustomerEmail("TEST@TEST.com");
		assertEquals("TEST@TEST.com",testBook.getCustomerEmail());
	}
}
