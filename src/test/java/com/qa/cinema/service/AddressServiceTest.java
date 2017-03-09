package com.qa.cinema.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class AddressServiceTest
{		

	@Test
	public void readaddressTestDB(){
		AddressuService databaseTest = Mockito.mock(AddressServiceDBImpl.class);
		when(databaseTest.listAllAddresses()).thenReturn("List Returned");
		assertEquals(databaseTest.listAllAddresses(), "List Returned");
	}
	
	@Test
	public void createaddressTestDB(){
		AddressuService databaseTest = Mockito.mock(AddressServiceDBImpl.class);
		String newAddress = "{\"address_ID\":1,\"firstLine\":\"22 Test Lane\",\"secondLine\":\" \",\"townOrCity\":\"Test\",\"county\":\"Test\",\"postcode\":\"Test\"}";
		when(databaseTest.listAllAddresses()).thenReturn("List Returned");
		when(databaseTest.createAddress(newAddress)).thenReturn("address Created");
		assertEquals(databaseTest.listAllAddresses(), "List Returned");
		assertEquals(databaseTest.createAddress(newAddress), "address Created");
	}
	
	@Test
	public void updateaddressTestDB(){
		AddressuService databaseTest = Mockito.mock(AddressServiceDBImpl.class);
		String newaddress = "{\"address_ID\":1,\"firstLine\":\"22 Test Lane\",\"secondLine\":\" \",\"townOrCity\":\"Test\",\"county\":\"Test\",\"postcode\":\"Test\"}";
		when(databaseTest.listAllAddresses()).thenReturn("List Returned");
		when(databaseTest.updateAddress(1l, newaddress)).thenReturn("address Updated");
		assertEquals(databaseTest.listAllAddresses(), "List Returned");
		assertEquals(databaseTest.updateAddress(1l, newaddress), "address Updated");
	}
}
