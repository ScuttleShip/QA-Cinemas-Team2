package com.qa.cinema.service;


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
	}
	@Test
	public void addNewBookingTest() {
		String testObject = "test";
		Booking fakeBooking = new Booking(5, "test");
		//FAKE IT TILL YOU MAKE IT
		Mockito.when(util.getObjectForJSON(testObject, Booking.class)).thenReturn(fakeBooking);
		Mockito.doNothing().when(em).persist(fakeBooking);
		//CREATE STRING TO COMPARE TO
		String jsonForm = testObject; //THIS WILL EQUAL "test" DUE TO LINE 48
		String assertionString = testBookingService.addNewBooking(testObject); // THIS WILL ALSO EQUAL "test"
		Assert.assertEquals(assertionString, jsonForm); // "test" EQUALS "test", SCIENCE!!!!
	}
	@Test
	public void replaceBookingTest() {
		String testObject = "test";
		Booking fakeBooking = new Booking(5, "test");
		Booking fakeBooking2 = new Booking(4,"test2");
		//FAKE IT TILL YOU MAKE IT
		Mockito.when(util.getObjectForJSON(testObject, Booking.class)).thenReturn(fakeBooking);
		Mockito.when(testBookingService.findBooking(1L)).thenReturn(fakeBooking2);
		Mockito.doNothing().when(em).persist(fakeBooking2);
		String jsonForm = "{\"message\": \"booking sucessfully updated\"}";
		String assertionString = testBookingService.replaceBooking(1, testObject);
		Assert.assertEquals(jsonForm, assertionString);
	}
	@Test
	public void removeBookingTest() {
		Booking fakeBooking = new Booking(5, "test");
		//FAKE IT TILL YOU MAKE IT
		Mockito.when(testBookingService.findBooking(1L)).thenReturn(fakeBooking);
		Mockito.doNothing().when(em).remove(fakeBooking);
		//CREATE STRING TO COMPARE TO
		String jsonForm = "{\"message\": \"booking sucessfully removed\"}"; //THIS WILL EQUAL "test" DUE TO LINE 48
		String assertionString = testBookingService.deleteBooking(1); // THIS WILL ALSO EQUAL "test"
		Assert.assertEquals(assertionString, jsonForm); // "test" EQUALS "test", SCIENCE!!!!
	}

}