package com.qa.cinema.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MovieTest {
	
	@Test
	public void getSetMovieID()
	{
		Movie mov = new Movie();
		assertNull(mov.getMovie_ID());
		mov.setMovie_ID(Long.valueOf(1));
		long id = Long.valueOf(mov.getMovie_ID());
		assertEquals(id, 1);
	}
	
	@Test
	public void titleSetterTest() {
		Movie testMovie = new Movie();
		testMovie.setTitle("Amit goes wild");
		assertEquals("Amit goes wild", testMovie.getTitle());
	}
	
	@Test
	public void descriptionSetterTest() {
		Movie testMovie = new Movie();
		testMovie.setDescription("r gonewild");
		assertEquals("r gonewild", testMovie.getDescription());
	}
	
	@Test
	public void genreSetterTest() {
		Movie testMovie = new Movie();
		testMovie.setGenre("horror");
		assertEquals("horror", testMovie.getGenre());
	}
	
	@Test
	public void durationSetterTest() {
		Movie testMovie = new Movie();
		testMovie.setDuration("2:50:50");
		assertTrue("2:50:50".equals(testMovie.getDuration()));
	}
	
	@Test
	public void certificationSetterTest() {
		Movie testMovie = new Movie();
		testMovie.setCertification("pg-13");
		assertEquals("pg-13", testMovie.getCertification());
	}
	
	@Test
	public void constructorTest()
	{
		Movie testMovie = new Movie("Film Name", "it is a film", "Action", "five days", "PG","Link","Img");
		assertEquals(testMovie.getTitle(),"Film Name");
		assertEquals(testMovie.getDescription(),"it is a film");
		assertEquals(testMovie.getGenre(),"Action");
		assertEquals(testMovie.getDuration(),"five days");
		assertEquals(testMovie.getCertification(),"PG");
	}
}
