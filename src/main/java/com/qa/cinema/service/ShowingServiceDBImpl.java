package com.qa.cinema.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public String getAllShowingsByMovieAndDate(Long movieID, String date) {
		// TODO This returns all showing by movie and date
		return null;
	}

	@Override
	public String getAllMoviesThatHaveUpcomingShowings(Long movie_ID) {
		// TODO This should display all movies that have upcoming showings
		// within the cinema.
		// To refactor
		Query query = em.createQuery("SELECT s FROM Showing s WHERE s.movie = " + movie_ID);
		Collection<Showing> showing = (Collection<Showing>) query.getResultList();
		return util.getJSONForObject(showing);
	}
	
	public String getAllShowingsAtAVenue(Long venue_ID){
		Query query = em.createQuery("SELECT s FROM Showing s");
		Collection<Showing> showing = (Collection<Showing>) query.getResultList();
		Collection<Showing> specific = (Collection<Showing>) new ArrayList();
		for(Showing s : showing){
			if(s.getScreen().getVenue().getVenue_ID().longValue() == venue_ID.longValue()){
				specific.add(s);
			}
		}
		
		return util.getJSONForObject(specific);
	}

	private Showing findShowing(Long id) {
		return em.find(Showing.class, id);
	}

	public static final String returnMessage(String message) {
		return "{\"message\": \"" + message + "\"}";
	}
}