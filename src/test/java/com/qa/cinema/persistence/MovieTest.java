package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {
	Movie testMovie = new Movie();
	@Test
	public void titleSetterTest() {
		testMovie.setTitle("Amit goes wild");
		assertEquals("Amit goes wild", testMovie.getTitle());
	}
	
	@Test
	public void titleGetterTest() {
		assertEquals("Amit goes wild", testMovie.getTitle());
	}
	
	@Test
	public void descriptionSetterTest() {
		testMovie.setDescription("r gonewild");
		assertEquals("r gonewild", testMovie.getDescription());
	}
	
	@Test
	public void descriptionGetterTest() {
		assertEquals("r gonewild", testMovie.getDescription());
	}
	
	@Test
	public void genreSetterTest() {
		testMovie.setGenre("horror");
		assertEquals("horror", testMovie.getGenre());
	}
	
	@Test
	public void genreGetterTest() {
		assertEquals("horror", testMovie.getGenre());
	}
	
	@Test
	public void durationSetterTest() {
		testMovie.setDuration("2:50:50");
		assertTrue("r gonewild".equals(testMovie.getDuration()));
	}
	
	@Test
	public void durationGetterTest() {
		assertTrue("r gonewild".equals(testMovie.getDuration()));
	}
	
	@Test
	public void certificationSetterTest() {
		testMovie.setCertification("r gonewild");
		assertEquals("r gonewild", testMovie.getDescription());
	}
	
	@Test
	public void certificationGetterTest() {
		assertEquals("r gonewild", testMovie.getDescription());
	}
	

}
