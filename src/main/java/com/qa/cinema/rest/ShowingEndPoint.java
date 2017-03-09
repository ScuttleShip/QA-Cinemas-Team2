package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.ShowingService;

/**
 * 
 * @author FWasim
 *
 */
@Path("/showing")
public class ShowingEndPoint {

	@Inject
	private ShowingService showingService;

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getShowingAsJson() {
		return showingService.getAllShowings();
	}
	
	@GET
	@Path("/json/movie/{mid}")
	@Produces({ "application/json" })
	public String  getAllMoviesThatHaveUpcomingShowings(@PathParam("mid") Long movie_ID) {
		return showingService.getAllMoviesThatHaveUpcomingShowings(movie_ID);
	}
	
	@GET
	@Path("/json/venue/{vid}")
	@Produces({ "application/json" })
	public String  getAllShowingsAtAVenue(@PathParam("vid") Long venue_ID) {
		return showingService.getAllShowingsAtAVenue(venue_ID);
	}
	
	@GET
	@Path("/json/showing/{sid}")
	@Produces({ "application/json" })
	public String  getShowingByID(@PathParam("sid") Long showing_ID) {
		return showingService.findShowingByIDREST(showing_ID);
	}

	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewShowing(String showingJson) {
		return showingService.addNewShowing(showingJson);
	}

	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String updateShowing(@PathParam("id") Long showingId,
			String showingJson) {
		return showingService.updateShowing(showingId, showingJson);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteShowing(@PathParam("id") Long showingId){
		return showingService.deleteShowing(showingId);
	}
	
	@GET
	@Path("/json/{booking_ID}")
	@Produces({ "application/json" })
	public String getShowingByBookingID(@PathParam("booking_ID") Long bookingID){
		return showingService.getShowingByBookingID(bookingID);
	}

}