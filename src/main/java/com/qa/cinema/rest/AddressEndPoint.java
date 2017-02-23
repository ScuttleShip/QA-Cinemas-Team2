package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.cinema.service.AddressService;

@Path("/address")
public class AddressEndPoint {

	@Inject
	private AddressService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAddresses() {
		return service.listAllAddresses();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addAddress(String addressDetails) {
		return service.createAddress(addressDetails);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAddress(@PathParam("id") Long addressId, String addressDetails) {
		return service.updateAddress(addressId, addressDetails);
	}
}