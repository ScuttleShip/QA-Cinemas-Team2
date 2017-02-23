package com.qa.cinema.persistence;

import static org.junit.Assert.*;
import org.junit.Test;


public class VenueTest {
	
	@Test
	public void testGetAndSetVenue(){
		
		Venue venue = new Venue("Apollo Square");
		venue.setName("Point Prometheus");
		String result = venue.getName();
		assertEquals("Point Prometheus", result);
	}
}
