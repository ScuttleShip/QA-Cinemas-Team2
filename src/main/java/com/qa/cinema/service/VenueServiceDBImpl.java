package com.qa.cinema.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Venue;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
public class VenueServiceDBImpl implements VenueService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllVenues() {
		Query query = em.createQuery("SELECT v FROM Venue v");
		List<Venue> venueList = (ArrayList<Venue>) query.getResultList();
		//System.out.println(venueList.size());
		return util.getJSONForObject(venueList);
	}

	@Override
	public String addNewVenue(String venueJson) {
		Venue newVenue = util.getObjectForJSON(venueJson, Venue.class);
		em.persist(newVenue);
		return venueJson;
	}

	@Override
	public String updateVenue(Long venueID, String updatedVenue) {
		Venue updateVenue = util.getObjectForJSON(updatedVenue, Venue.class);
		Venue venue = findVenue(new Long(venueID));
		if (venue != null){
			venue = updateVenue;
			em.merge(venue);
		}
		return "{\"message\": \"venue has been successfully updated\"}";
	}

	@Override
	public String deleteVenue(Long venueID) {
		Venue venue = findVenue(new Long(venueID));
		if(venue != null){
			em.remove(venue);
		}
		return null;
	}
	
	public Venue findVenue(Long id){
		return em.find(Venue.class, id);
	}
}

