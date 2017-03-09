package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.cinema.service.ContactUsService;

@Path("/contact")
public class ContactUsEndpoint {
	
	@Inject
	private ContactUsService service;

	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String sendEmail(String messageToSend) {
		return service.sendEmail(messageToSend);
	}
}
