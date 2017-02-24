package com.qa.cinema.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.cinema.persistence.Venue;
import com.qa.cinema.service.VenueService;
import com.qa.cinema.service.VenueServiceDBImpl;
import com.qa.cinema.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class VenueServiceTest {

	@InjectMocks
	VenueServiceDBImpl testVenueService;
	
	@Mock
	JSONUtil util;
	
	@Mock
	EntityManager em;
	
	@Mock
	Query query;
	
	@Test
	public void venueServiceTestGetAllVenues(){
		
		List<Venue> venueList = new ArrayList<Venue>();
		
		Venue newVenue = new Venue();
		newVenue.setName("Dionysis Park");
		venueList.add(newVenue);
		
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(venueList);
		Mockito.when(util.getJSONForObject(venueList)).thenReturn(newVenue.getName());
		
		
		String jsonForm = util.getJSONForObject(venueList);
		System.out.println(jsonForm);
		
		String toPassIn = util.getJSONForObject(testVenueService);
		testVenueService.addNewVenue(toPassIn);
		String assertionString = testVenueService.getAllVenues();
		Assert.assertEquals(assertionString, jsonForm);
		
		Mockito.verify(em).createQuery(Mockito.anyString());
	}
	
	@Test
	public void venueServiceTestAddNewVenue(){
		
		List<Venue> venueList = new ArrayList<Venue>();
		
		Venue newVenue = new Venue(testVenueService.addNewVenue("Apollo Square"));
		
		venueList.add(newVenue);
		
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(venueList);
		Mockito.when(util.getJSONForObject(venueList)).thenReturn(newVenue.getName());
		
		String jsonForm = util.getJSONForObject(venueList);
		System.out.println(jsonForm);
		String toPassIn = util.getJSONForObject(venueList);
		testVenueService.addNewVenue(toPassIn);
		String assertionString = testVenueService.getAllVenues();
		Assert.assertEquals(assertionString, jsonForm);
		
		Mockito.verify(em).createQuery(Mockito.anyString());
	}
	
}