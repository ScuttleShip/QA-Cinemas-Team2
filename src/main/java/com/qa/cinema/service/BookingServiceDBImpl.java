package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




import com.qa.bookstore.model.Book;
import com.qa.cinema.persistence.Booking;
import com.qa.cinema.util.JSONUtil;
import com.qa.cinema.persistence.Booking;

@Stateless
@Default
public class BookingServiceDBImpl {
	
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
		System.out.println("helloooooooooo");
		System.out.println(util.getObjectForJSON(bookingJson, Booking.class));
		Booking newBooking = util.getObjectForJSON(bookingJson, Booking.class);
		em.persist(newBooking);
		return bookingJson;	
	}
	public String replaceBooking(Integer bookingID, String updatedBooking) {
		Booking updateBooking = util.getObjectForJSON(updatedBooking, Booking.class);
		Booking booking = findBooking(new Long(bookingID));
		if(booking != null) {
			booking = updateBooking;
			em.merge(booking);
		}
		return "{\"message\": \"booking sucessfully updated\"}";
	}
	public String deleteBook(Integer bookingId) {
		Booking booking = findBooking(new Long(bookingId));
		if (booking != null) {
			em.remove(booking);
		}
		return "{\"message\": \"booking sucessfully removed\"}";
	}
	private Booking findBooking(Long id) {
		return em.find(Booking.class, id);
	}
}
