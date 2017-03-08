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
		return util.getJSONForObject(venueList);
	}

	@Override
	public String addNewVenue(String venueJson) {
		Venue newVenue = util.getObjectForJSON(venueJson, Venue.class);
		em.persist(newVenue);
		return "{\"message\": \"venue has been successfully added\"}";
	}

	@Override
	public String updateVenue(Long venue_ID, String updatedVenue) {
		Venue updateVenue = util.getObjectForJSON(updatedVenue, Venue.class);
		Venue venue = findVenue(Long.valueOf(venue_ID));
		Long temp_ID = venue.getVenue_ID();
		venue = updateVenue;
		venue.setVenue_ID(temp_ID);
		em.merge(venue);
		return "{\"message\": \"venue has been successfully updated\"}";
	}

	@Override
	public String deleteVenue(Long venue_ID) {
		Venue venue = findVenue(Long.valueOf(venue_ID));
		if(venue != null){
			em.remove(venue);
		}
		return null;
	}
	
	@Override
	public String findVenueByID(Long venue_ID) {
		Venue venue = findVenue(venue_ID);
		return util.getJSONForObject(venue);
	}
	
	public Venue findVenue(Long id){
		return em.find(Venue.class, id);
	}
}