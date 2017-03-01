package com.qa.cinema.service;

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

	Boolean decreaseSeatCount(Long showingId, int count);
	
	String getAllShowingsAtAVenue(Long venue_ID);
}
