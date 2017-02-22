package com.qa.cinema.service;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.cinema.util.JSONUtil;
import com.qa.cinema.persistence.Booking;

@RunWith(MockitoJUnitRunner.class)

public class BookingServiceTest {
	@InjectMocks
	BookingServiceDBImpl testBookingService;
	
	@Mock
	JSONUtil util;
	
	@Mock
	EntityManager em;
	
	@Mock
	Query query;
	
	@Test
	public void getAllBookingsTest() {
		
		List<Booking> bookingList = new ArrayList<Booking>();
				
		//FAKE IT TILL YOU MAKE IT
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(bookingList);
		Mockito.when(util.getJSONForObject(bookingList)).thenReturn("test"); //WHENEVER THIS IS CALLED RETURN "test"
		
		//CREATE STRING TO COMPARE TO
		String jsonForm = util.getJSONForObject(bookingList); //THIS WILL EQUAL "test" DUE TO LINE 48
		
		String assertionString = testBookingService.getAllBookings(); // THIS WILL ALSO EQUAL "test"
		
		Assert.assertEquals(assertionString, jsonForm); // "test" EQUALS "test", SCIENCE!!!!
		
		Mockito.verify(em).createQuery(Mockito.anyString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}







