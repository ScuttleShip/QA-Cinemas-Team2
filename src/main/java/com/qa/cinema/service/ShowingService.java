package com.qa.cinema.service;

/**
 * 
 * @author FWasim
 *
 */
public interface ShowingService {

	String getAllShowings();

	String getAllShowingsByMovieAndDate(Long movieId, String date);

	String getAllMoviesThatHaveUpcomingShowings();

	String addNewShowing(String showingJson);

	String updateShowing(Long showingId, String showingJson);

	String deleteShowing(Long showingId);

	Boolean decreaseSeatCount(Long showingId, int count);
}
