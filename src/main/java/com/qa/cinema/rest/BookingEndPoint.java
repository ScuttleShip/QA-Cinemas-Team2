package com.qa.cinema.rest;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.BookingServiceDBImpl;

@Path("/booking")
public class BookingEndPoint {
	
	@Inject
	private BookingServiceDBImpl bookingService;
	
	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getBookingsAsJson() {
		return bookingService.getAllBookings();
	}
	
	@GET
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String getBookingById(@PathParam("id") Long booking_ID) {
		return bookingService.getBookingById(booking_ID);
	}
	
	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewBooking(String bookingJson) {
		return bookingService.addNewBooking(bookingJson);
	}

//	The customer is not allowed to update their booking after it has been confirmed. Therefore the @PUT method is unused but kept just incase functionality is required in future.	
//	
//	@PUT
//	@Path("/json/{id}")
//	@Produces({ "application/json" })
//	public String replaceBooking(@PathParam("id") Integer ID, String bookingJson){
//		return bookingService.replaceBooking(ID, bookingJson);
//	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteBooking(@PathParam("id") Integer ID){
		return bookingService.deleteBooking(ID);
	}
}
