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

}