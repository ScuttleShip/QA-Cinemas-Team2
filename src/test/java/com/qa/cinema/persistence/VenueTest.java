package com.qa.cinema.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;


public class VenueTest {
	
	@Test
	public void testGetAndSetVenue(){
		
		Venue venue = new Venue("Apollo Square");
		venue.setName("Point Prometheus");
		String result = venue.getName();
		assertEquals("Point Prometheus", result);
	}
	
	@Test
	public void constructorTest()
	{
		Venue ven = new Venue("My Cinema");
		assertEquals(ven.getName(), "My Cinema");
		ven = new Venue(null);
		assertEquals(ven.getName(), "");
	}
	
	@Test
	public void getSetIDTest()
	{
		Venue ven = new Venue();
		assertNull(ven.getVenue_ID());
		ven.setVenue_ID(Long.valueOf(1));
		long result = Long.valueOf(ven.getVenue_ID());
		assertEquals(1,result);
	}
}
