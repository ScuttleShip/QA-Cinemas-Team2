package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {
	
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
	

}
