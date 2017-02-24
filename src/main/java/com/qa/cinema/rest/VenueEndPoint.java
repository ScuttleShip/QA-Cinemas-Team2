package com.qa.cinema.rest;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.VenueService;
import com.qa.cinema.service.VenueServiceDBImpl;

@Path("/venue")
@Default
public class VenueEndPoint {

	@Inject
	private VenueService venueService;
	
	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getVenueAsJson(){
		return venueService.getAllVenues();
		
	}
	
	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewVenueToMap(String venueJson){
		return venueService.addNewVenue(venueJson);
	}
	
	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String updateVenueFromCinema(@PathParam("id")Long id, String venueJson){
		return venueService.updateVenue(id, venueJson);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteVenueFromCinema(@PathParam("id")Long id){
		return venueService.deleteVenue(id);
	}
}