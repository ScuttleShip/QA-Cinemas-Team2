package com.qa.cinema.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;




public class AddressServiceTest {
	
	@Test
	public void returnVenueDetailsTest() {
		AddressService databaseTest = Mockito.mock(AddressService.class);
		when(databaseTest.returnVenueDetails("1")).thenReturn("Trev is the best");
		assertEquals(databaseTest.returnVenueDetails("1"), "Trev is the best");
	}
	
	@Test
	public void makeCustomerTest(){
		AddressService databaseTest = Mockito.mock(AddressService.class);
		
	}

}
