package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Booking;
import com.qa.cinema.persistence.Showing;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
public class BookingServiceDBImpl {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;
	
	@Inject 
	private ShowingService showing;
  
	public String getAllBookings() {
		Query query = em.createQuery("SELECT e FROM Booking e");
		Collection<Booking> bookings = (Collection<Booking>) query.getResultList();
		return util.getJSONForObject(bookings);
	}

	public String addNewBooking(String bookingJson) {
		Booking newBooking = util.getObjectForJSON(bookingJson, Booking.class);
		int seatsBooked = newBooking.getNumberOfSeats();
		Long showing_ID = newBooking.getShowing_ID();
		
		Boolean bookingConfirmed = showing.decreaseSeatCount(showing_ID, seatsBooked);
		
		if(bookingConfirmed){
			em.merge(newBooking);
			return bookingJson;	
		}else{
			return "{\"message\": \"booking could not be completed, there are only" + showing.findShowingByID(showing_ID).getSeatsRemaining() + "seats remaining \"}";
		}
	}

	// The Customer is not allowed to change a booking after it has been made.
	// So the code below is no longer used but it is being kept, just in case.
	//
	// public String replaceBooking(Integer booking_ID, String updatedBooking) {
	// Booking updateBooking = util.getObjectForJSON(updatedBooking,
	// Booking.class);
	// Booking booking = findBooking(Long.valueOf(booking_ID));
	// if(booking != null) {
	// updateBooking.setBooking_ID(booking.getBooking_ID());
	// booking = updateBooking;
	//
	// em.merge(booking);
	//
	// }
	// return "{\"message\": \"booking sucessfully updated\"}";
	// }

	public String deleteBooking(Integer booking_ID) {
		Booking booking = findBooking(Long.valueOf(booking_ID));
		if (booking != null) {
			em.remove(booking);
		}
		return "{\"message\": \"booking sucessfully removed\"}";
	}

	Booking findBooking(Long id) {
		return em.find(Booking.class, id);
	}
}
