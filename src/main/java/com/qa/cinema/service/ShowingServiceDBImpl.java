package com.qa.cinema.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.qa.cinema.persistence.Booking;
import com.qa.cinema.persistence.Movie;
import com.qa.cinema.persistence.Screen;
import com.qa.cinema.persistence.Showing;
import com.qa.cinema.persistence.Venue;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
public class ShowingServiceDBImpl implements ShowingService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;
	
	 private static final Logger LOGGER = Logger.getLogger(ShowingServiceDBImpl.class);


	@Override
	@SuppressWarnings("unchecked")
	public String getAllShowings() {
		Query query = em.createQuery("SELECT s FROM Showing s");
		Collection<Showing> showing = (Collection<Showing>) query.getResultList();
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
		Showing updateShowing = util.getObjectForJSON(updatedShowing, Showing.class);
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
	public Boolean decreaseSeatCount(Long showingId, int numberOfSeatsBooked) {
		Showing showing = findShowing(showingId);
		boolean isShowingUpdated = false;
		int count = showing.getSeatsRemaining();
		if (showing != null && count >= numberOfSeatsBooked) {
			showing.setSeatsRemaining(count - numberOfSeatsBooked);
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
	public String getAllShowingsAtAVenueAndDate(Long venue_ID, String dateSelected) {

		HashMap<String, List<Showing>> listOfMoviesAndShowings = new HashMap<String, List<Showing>>();

		Set<Screen> screensAtVenue = getScreensForVenue(venue_ID);

		List<Showing> showingsAtVenue = new ArrayList<Showing>();

		for (Screen currentScreen : screensAtVenue) {

			showingsAtVenue.addAll(currentScreen.getShowings());

		}

		List<Showing> showingsAtVenueByDate = new ArrayList();
		Date selectedDate = convertStringToDate(dateSelected);

		for (Showing currentShowing : showingsAtVenue) {

			Date showingDate = currentShowing.getDate();

			if (showingDate.equals(selectedDate)) {
				showingsAtVenueByDate.add(currentShowing);
			}

		}

		List<Movie> movies = new ArrayList();

		for (Showing currentShowing : showingsAtVenueByDate) {

			Movie movieForShowing = currentShowing.getMovie();

			if (!(movies.contains(movieForShowing))) {
				movies.add(movieForShowing);
			}

		}

		for (Movie currentMovie : movies) {

			List<Showing> showingsForMovie = new ArrayList<Showing>();

			for (Showing currentShowing : showingsAtVenueByDate) {

				if (currentShowing.getMovie().equals(currentMovie)) {

					showingsForMovie.add(currentShowing);

				}
			}

			Collections.sort(showingsForMovie);

			listOfMoviesAndShowings.put(util.getJSONForObject(currentMovie), showingsForMovie);

		}

		return util.getJSONForObject(listOfMoviesAndShowings);
	}

	@Override
	public String getMovieByShowingID(Long showing_ID) {

		Showing showingForID = findShowing(showing_ID);
		Movie movieForShowing = showingForID.getMovie();

		return util.getJSONForObject(movieForShowing);
	}

	private Set<Screen> getScreensForVenue(Long venue_ID) {
		Query query = em.createQuery("SELECT v FROM Venue v WHERE v.venue_ID = " + venue_ID);
		Venue venue = (Venue) query.getSingleResult();
		return venue.getScreen();

	}

	private Date convertStringToDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// If no date selected return todays date
		Date returnDate = new Date();
		try {
			returnDate = format.parse(date);
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return returnDate;
	}

	private Showing findShowing(Long id) {
		return em.find(Showing.class, id);
	}

	public Showing findShowingByID(Long id) {
		return em.find(Showing.class, id);
	}

	public String findShowingByIDREST(Long id) {
		Showing s = em.find(Showing.class, id);
		return util.getJSONForObject(s);
	}

	public static final String returnMessage(String message) {
		return "{\"message\": \"" + message + "\"}";
	}

	@Override
	public String getShowingByBookingID(Long booking_ID) {

		LOGGER.info(booking_ID);
		Query query = em.createQuery("SELECT b FROM Booking b");
		List<Booking> allBookings = (List<Booking>) query.getResultList();
		Booking newBooking = new Booking();
		
		for (Booking current : allBookings) {
			
			if (current.getBooking_ID().equals(booking_ID)) {
				
				newBooking = current;
				
			}
			
		}
		
		Long showingID = newBooking.getShowing_ID();
		
		Query showingQuery = em.createQuery("SELECT s FROM Showing s where s.showing_ID = " + showingID);
		Showing newShowing = (Showing) showingQuery.getSingleResult();
		
		return util.getJSONForObject(newShowing);
//		Showing specific = new Showing();
//		for (Showing s : showing) {
//			Collection<Booking> bookingsForCurrentShowing = s.getBookings();
//			for (Booking b : bookingsForCurrentShowing) {
//				if (b.getBooking_ID().longValue() == booking_ID.longValue()) {
//					specific = s;
//				}
//			}
//		}
//		LOGGER.info("This is the value of JSON string " +  util.getJSONForObject(single));
//		return util.getJSONForObject(single);

	}
}
