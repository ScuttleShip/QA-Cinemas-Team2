package com.qa.cinema.persistence;

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
	
	@Test
	public void venueServiceTestUpdatedVenue(){
				
		String testObject = "test";
		Venue fakeVenue = new Venue(1L, "Point Prometheus");
		Venue fakeVenue2 = new Venue(2L, "Smugglers Hideout");
		fakeVenue2.setAddress_ID(new Long(1));
	/*	List<Venue> venueList = new ArrayList<Venue>();
		Venue newVenue = new Venue(testVenueService.addNewVenue("Point Prometheus"));
		venueList.add(newVenue);
		Venue newVenue2 = new Venue(testVenueService.addNewVenue("Smugglers Hideout"));
		*/
		
		Mockito.when(util.getObjectForJSON(testObject, Venue.class)).thenReturn(fakeVenue);
		Mockito.when(testVenueService.findVenue(2L)).thenReturn(fakeVenue2);
		Mockito.doNothing().when(em).persist(fakeVenue2);
		String jsonForm = "{\"message\": \"booking sucessfully updated\"}";
		String assertionString = testVenueService.updateVenue(2L, "Neptunes Bounty");
		Assert.assertEquals(jsonForm, assertionString);
	}
}