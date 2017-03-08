package com.qa.cinema.service;

import com.qa.cinema.persistence.Showing;

/**
 * @author FWasim
 */
public interface ShowingService {

	String getAllShowings();

	String addNewShowing(String showingJson);

	String updateShowing(Long showingId, String showingJson);

	String deleteShowing(Long showingId);

	Boolean decreaseSeatCount(Long showingId, int numberOfSeatsBooked);
	
	String getShowingByBookingID(Long bookingID);
	
	Showing findShowingByID(Long id);

	String getAllShowingsAtAVenueAndDate(Long venue_ID, String dateSelected);
}
