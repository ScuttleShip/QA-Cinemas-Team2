package com.qa.cinema.service;

public interface BookingService {


		String getAllBookings();

		String addNewBooking(String bookingJson);

		String replaceBooking(Long booking_ID, String updatedBooking);

		String deleteBooking(Long booking_ID);
	
		String getBookingByBookingID(Long booking_ID);

}
