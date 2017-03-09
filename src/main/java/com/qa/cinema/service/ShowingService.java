package com.qa.cinema.service;

import com.qa.cinema.persistence.Showing;

/**
 * @author FWasim
 */
public interface ShowingService {

	String getAllShowings();

	String getAllShowingsByMovieAndDate(Long movieId, String date);

	String getAllMoviesThatHaveUpcomingShowings(Long movie_ID);

	String addNewShowing(String showingJson);

	String updateShowing(Long showingId, String showingJson);

	String deleteShowing(Long showingId);

	Boolean decreaseSeatCount(Long showingId, int numberOfSeatsBooked);
	
	String getAllShowingsAtAVenue(Long venue_ID);

	String getShowingByBookingID(Long bookingID);
	
	Showing findShowingByID(Long id);
	
	String findShowingByIDREST(Long showing_ID);
}
