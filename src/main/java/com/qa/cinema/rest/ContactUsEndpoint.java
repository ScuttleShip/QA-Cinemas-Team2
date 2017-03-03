package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.cinema.service.ContactUsService;

@Path("/contact")
public class ContactUsEndpoint {
	
	@Inject
	private ContactUsService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getFirstName(){
		return service.getFirstName();
	}

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getLastName() {
		return service.getLastName();
	}

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getEmail() {
		return service.getEmail();
	}
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getPhone() {
		return service.getPhone();
	}
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getMessage() {
		return service.getMessage();
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String sendEmail(String messageToSend) {
		return service.sendEmail(messageToSend);
	}
}
