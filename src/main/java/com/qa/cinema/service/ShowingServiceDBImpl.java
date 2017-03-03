package com.qa.cinema.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Movie;
import com.qa.cinema.persistence.Showing;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
public class ShowingServiceDBImpl implements ShowingService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@Override
	@SuppressWarnings("unchecked")
	public String getAllShowings() {
		Query query = em.createQuery("SELECT s FROM Showing s");
		Collection<Showing> showing = (Collection<Showing>) query
				.getResultList();
		return util.getJSONForObject(showing);
	}

	@Override
	public String addNewShowing(String showingJson) {
		Showing newShowing = util.getObjectForJSON(showingJson, Showing.class);
		em.persist(newShowing);
		return showingJson;
	}

	@Override
	public String updateShowing(Long showingId, String updatedShowing) {
		Showing updateShowing = util.getObjectForJSON(updatedShowing,
				Showing.class);
		Showing showing = findShowing(showingId);
		if (showing != null) {
			updateShowing.setShowing_ID(showing.getShowing_ID());
			showing = updateShowing;
			em.merge(showing);
			return returnMessage("showing sucessfully updated");
		}
		return returnMessage("the showing was not updated");
	}

	@Override
	public Boolean decreaseSeatCount(Long showingId, int count) {
		Showing showing = findShowing(showingId);
		boolean isShowingUpdated = false;
		if (showing != null && showing.getSeatsRemaining() >= count) {
			showing.setSeatsRemaining(showing.getSeatsRemaining() - count);
			em.merge(showing);
			isShowingUpdated = true;
		}
		return isShowingUpdated;
	}

	@Override
	public String deleteShowing(Long showingId) {
		Showing showing = findShowing(showingId);
		if (showing != null) {
			em.remove(showing);
			return returnMessage("showing successfully removed");
		}
		return returnMessage("the showing was not removed");
	}
	
	private List<Movie> getAllMoviesByVenueAndDate(Long venue_ID, String dateSelected){	
		Query query = em.createQuery("SELECT s FROM Showing s");
		Collection<Showing> listOfShowings = (Collection<Showing>) query.getResultList();
		ArrayList<Movie> listOfMoviesAtVenue = new ArrayList<Movie>();
		for(Showing show : listOfShowings){
			if(show.getScreen().getVenue().getVenue_ID().longValue() == venue_ID.longValue()){
				if(!listOfMoviesAtVenue.contains(show.getMovie())){
					listOfMoviesAtVenue.add(show.getMovie());
				}
			}
		}		
		return listOfMoviesAtVenue;
	}
		
	// Alternative way of getting movies 
	private List<Long> getAllMoviesAtAVenue(Long venue_ID, String dateSelected){
		Query query = em.createQuery("SELECT movie.movie_ID FROM Showing JOIN Screen WHERE venue_ID = " + venue_ID + "");
		List<Long> moveIds = query.getResultList();
		System.out.println(moveIds);
		return moveIds;
	}
	
	@Override
	public String getAllShowingsAtAVenueAndDate(Long venue_ID, String dateSelected){

		HashMap<String, List<String>> listOfMoviesAndShowings = new HashMap<String, List<String>>();
		
		List<Movie> movies = getAllMoviesByVenueAndDate(venue_ID, dateSelected); 
		
		for(Movie movie : movies){
			listOfMoviesAndShowings.put(movie.getTitle(), getShowingsForAMovie(venue_ID, dateSelected, movie.getMovie_ID()));
		}
		
		return util.getJSONForObject(listOfMoviesAndShowings);
	}
	
	private List<String> getShowingsForAMovie(Long venue_ID, String dateSelected, Long movieId){
		Query query = em.createQuery("SELECT s.startTime FROM Showing s JOIN s.screen sc WHERE sc.venue = " + venue_ID + " AND s.movie = " + movieId  + "");
		List<String> listOfStartTimes = query.getResultList();
		return listOfStartTimes;
	}
	
	private Date convertStringToDate(String date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// If no date selected return todays date
		Date returnDate = new Date();
		try {
			returnDate = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return returnDate;
	}

	private Showing findShowing(Long id) {
		return em.find(Showing.class, id);
	}

	public static final String returnMessage(String message) {
		return "{\"message\": \"" + message + "\"}";
	}
}