package com.qa.cinema.persistence;

import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author FWasim
 *
 */
public class ShowingTest {

	@Test
	public void getSeatsRemainingTest() {
		Showing showing = new Showing(1L, new Date(), new Date(), 50);
		Assert.assertEquals(50, showing.getSeatsRemaining());
	}

	@Test
	public void setSeatsRemainingTest() {
		Showing showing = new Showing();
		showing.setSeatsRemaining(100);
		Assert.assertEquals(100, showing.getSeatsRemaining());
	}

	@Test
	public void getDateTest() {
		Showing showing = new Showing(1L, new Date(), new Date(), 50);
		Assert.assertEquals(new Date(), showing.getDate());
	}

	@Test
	public void setDateTest() {
		Showing showing = new Showing();
		showing.setDate(new Date());
		Assert.assertEquals(new Date(), showing.getDate());
	}

	@Test
	public void getStartTimeTest() {
		Showing showing = new Showing(1L, new Date(), new Date(), 50);
		Assert.assertEquals(new Date().getTime(), showing.getDate().getTime());
	}
	
	@Test
	public void setStartTimeTest() {
		Showing showing = new Showing();
		showing.setDate(new Date());
		Assert.assertEquals(new Date().getTime(), showing.getDate().getTime());
	}
	
	@Test
	public void getSetIDTest()
	{
		Showing showing = new Showing();
		assertNull(showing.getShowing_ID());
		showing.setShowing_ID(Long.valueOf(1));
		long result = Long.valueOf(showing.getShowing_ID());
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void getSetMovieTest()
	{
		Showing showing = new Showing();
		assertNull(showing.getMovie());
		showing.setMovie(new Movie());
		Assert.assertNotNull(showing.getMovie());
	}
	
	@Test
	public void getSetScreenTest()
	{
		Showing showing = new Showing();
		assertNull(showing.getScreen());
		showing.setScreen(new Screen());
		Assert.assertNotNull(showing.getScreen());
	}
}
