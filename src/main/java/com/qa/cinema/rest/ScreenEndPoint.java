package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.cinema.service.ScreenService;

@Path("/screen")
public class ScreenEndPoint {
	
	@Inject
	private ScreenService screenService;
	
	@GET
	@Path("/json")
	@Produces ({"application/json"})
	public String getScreensAsJson() {
		return screenService.getAllScreens();
	}

	@POST
	@Path("/json")
	@Produces ({"application/json"})
	public String addNewScreenToDB(String screenJson) {
		return screenService.addNewScreen(screenJson);
	}
	
	@PUT
	@Path("/json/{ID}")
	@Produces ({"application/json"})
	public String replaceScreenOnDB(@PathParam("ID") long screen_ID, String updatedScreen) {
		return screenService.replaceScreen(screen_ID, updatedScreen);
	}
	
	@DELETE
	@Path("/json/{ID}")
	@Produces ({"application/json"})
	public String deleteScreenOnDB(@PathParam("ID") long screen_ID) {
		return screenService.deleteScreen(screen_ID);
	}
}