package com.qa.cinema.service;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

import com.google.gson.Gson;


@Path("/venue")
@RequestScoped
public class AddressService {
	@Inject
	private EntityManager em;
	@GET
	@Path("/{venueId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String returnVenueDetails(@PathParam("customer_id") String venue_ID){
		Gson gson = new Gson();
		final List<Venue> listOfVenues= em.createQuery("Select a from Venue v where a.venue_id = " + venue_ID).getResultList();
		String ConvertVenueToJson = gson.toJson(listOfVenues);
		return ConvertVenueToJson;
	}
	

	@POST
	@Path("/{makeVenue}")
	public void makeVenue(@PathParam("makeCustomer") String JsonInput){
		Gson gson = new Gson();
		Venue javaCustomer = gson.fromJson(JsonInput, Venue.class);
		em.persist(javaCustomer);
	}
	

}