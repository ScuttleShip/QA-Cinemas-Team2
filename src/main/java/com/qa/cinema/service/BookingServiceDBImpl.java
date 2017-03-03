package com.qa.cinema.service;

import java.util.ArrayList;
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
public class BookingServiceDBImpl implements BookingService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	public String getAllBookings() {
		Query query = em.createQuery("SELECT e FROM Booking e");
		Collection<Booking> bookings = (Collection<Booking>) query.getResultList();
		return util.getJSONForObject(bookings);
	}
	
	public String addNewBooking(String bookingJson) {
		Booking newBooking = util.getObjectForJSON(bookingJson, Booking.class);
		em.persist(newBooking);
		return bookingJson;	
	}
	
	public String replaceBooking(Long booking_ID, String updatedBooking) {
		Booking updateBooking = util.getObjectForJSON(updatedBooking, Booking.class);
		Booking booking = findBooking(Long.valueOf(booking_ID));
		if(booking != null) {
			updateBooking.setBooking_ID(booking.getBooking_ID());
			booking = updateBooking;
			
			em.merge(booking);
			
		}
		return "{\"message\": \"booking sucessfully updated\"}";
	}
	public String deleteBooking(Long booking_ID) {
		Booking booking = findBooking(Long.valueOf(booking_ID));
		if (booking != null) {
			em.remove(booking);
		}
		return "{\"message\": \"booking sucessfully removed\"}";
	}
	
	public String getBookingByBookingID(Long booking_ID){
		Query query = em.createQuery("SELECT s FROM Booking s");
		Collection<Booking> booking = (Collection<Booking>) query.getResultList();
		Booking specific = new Booking();
		for(Booking s : booking){
			if(s.getBooking_ID().longValue() == booking_ID.longValue()){
				specific = s;
			}
		}
		
		return util.getJSONForObject(specific);
	}
	
	Booking findBooking(Long booking_id) {
		return em.find(Booking.class, booking_id);
	}
}
