package com.qa.cinema.service;

import java.util.ArrayList;
import java.util.Date;
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

import com.qa.cinema.persistence.Showing;
import com.qa.cinema.util.JSONUtil;

/**
 * 
 * @author FWasim
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ShowingServiceTest {

	@InjectMocks
	ShowingServiceDBImpl testShowingService = new ShowingServiceDBImpl();

	@Mock
	EntityManager em;

	@Mock
	Query query;

	@Mock
	JSONUtil util;

	@Test
	public void getAllShowingsTest() {
		List<Showing> showingList = new ArrayList<Showing>();

		Showing testShowing = new Showing(1L, new Date(), new Date(), 5);
		showingList.add(testShowing);

		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(showingList);
		Mockito.when(util.getJSONForObject(showingList)).thenReturn("test");

		String jsonForm = util.getJSONForObject(showingList);

		String toPassIn = util.getJSONForObject(testShowing);
		testShowingService.addNewShowing(toPassIn);
		String assertionString = testShowingService.getAllShowings();
		Assert.assertEquals(assertionString, jsonForm);

		Mockito.verify(em).createQuery(Mockito.anyString());
	}

}
