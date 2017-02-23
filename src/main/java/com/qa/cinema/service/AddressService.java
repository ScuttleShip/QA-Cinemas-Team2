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
import com.qa.cinema.persistence.Address;
import com.qa.cinema.util.JSONUtil;


public class AddressService {
	
	@Inject
	private EntityManager em;

	@Inject
	private JSONUtil jsonUtil;
	
	public String readAddress(){
		return " ";
	}
	
	@Inject
	public String updateAddress(){
		return " ";
	}
	
	@Inject 
	public String addAddress(){
		return " ";
	}

	

}