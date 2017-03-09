package com.qa.cinema.persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScreenTest {

//	@Test
//	public void getScreen_ID() {
//		
//		Screen testScreen = new Screen();
//		long getScreen_ID = testScreen.getScreen_ID();
//		assertEquals(getScreen_ID, 0);
//	}
	
	@Test
	public void setScreen_ID() {
		
		Screen testScreen = new Screen();
		testScreen.setScreen_ID(1);
		assertEquals(testScreen.getScreen_ID(), 1);
	}
	
	
//	@Test
//	public void getSetVenueID()
//	{
//		Screen testScreen = new Screen();
//		Venue venue = testScreen.getVenue();
//		assertNull(venue);
//		testScreen.setVenue(new Venue());
//		assertNotNull(testScreen.getVenue());
//	}
		
	@Test
	public void getNumberofSeats() {
		
		Screen testScreen = new Screen();
		int getNumberOfSeats = testScreen.getNumberOfSeats();
		assertEquals(getNumberOfSeats, 0);
	}
	
	@Test
	public void setNumberOfSeats() {
		
		Screen testScreen = new Screen();
		testScreen.setNumberOfSeats(1);
		assertEquals(testScreen.getNumberOfSeats(), 1);
	}

}
