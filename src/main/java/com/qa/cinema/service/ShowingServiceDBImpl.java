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
import javax.persistence.TemporalType;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;

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
	
	@Override
	public String getAllShowingsAtAVenue(Long venue_ID) {
		return "";
	}

	@Override
	public String getAllShowingsAtAVenue(Long venue_ID, String date){
/*		HashMap<Movie, List<Showing>> movieAndShowings = new HashMap<Movie, List<Showing>>();
		
		List<Movie> allMoviesAtAVenue = getAllMoviesByVenueAndDate(venue_ID, date);
		
		for(Movie mv : allMoviesAtAVenue){
			movieAndShowings.put(mv, getAllShowingsForAMovie(mv.getMovie_ID()));
		}	
		*/
		return util.getJSONForObject(getAllMoviesByVenueAndDate(venue_ID, date));
	}
	
	private HashMap<Movie, List<Showing>> getAllMoviesByVenueAndDate(Long venue_ID, String dateSelected){
		// This "SHOULD" returns a list of movies for a venue. 
		
		HashMap<Movie, List<Showing>> movieAndShowings = new HashMap<Movie, List<Showing>>();
		
		Query query = em.createQuery("SELECT s FROM Showing s");
		
		Collection<Showing> listOfShowings = (Collection<Showing>) query.getResultList();
		
		ArrayList<Movie> listOfMoviesAtVenue = new ArrayList<Movie>();
		ArrayList<Showing> groupShowings = new ArrayList<Showing>();
		
		for(Showing show : listOfShowings){
			if(show.getScreen().getVenue().getVenue_ID().longValue() == venue_ID.longValue()){
				if(!listOfMoviesAtVenue.contains(show.getMovie())){
					listOfMoviesAtVenue.add(show.getMovie());
				}
				for(Movie mv : listOfMoviesAtVenue){
					if(mv.getMovie_ID() == show.getMovie().getMovie_ID()){
						groupShowings.add(show);
					}
					//TODO this needs working on
					movieAndShowings.put(mv, groupShowings);
				}
			}
		}
		return movieAndShowings;
	}
		
	private List<Showing> getAllShowingsForAMovie(Long movie_ID) {
		Query query = em.createQuery("SELECT s FROM Showing s WHERE s.movie = " + movie_ID);	
		return query.getResultList();
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