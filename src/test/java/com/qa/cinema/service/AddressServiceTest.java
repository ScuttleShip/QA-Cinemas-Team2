package com.qa.cinema.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.mockito.Mockito;

public class AddressServiceTest
{		
	@Test
	public void readAddressTestMap(){
		AddressService service = new MapAddressService(true);
		String actualJson = service.listAllAddresses();
		String expectedJson = "{\"1\":{\"firstLine\":\"11 Example Street\",\"secondLine\":\"Cool House\",\"townOrCity\":\"Townsville\",\"county\":\"Countyford\",\"postcode\":\"TO11CF\"}}";
		assertEquals(actualJson, expectedJson);
	}
	
	@Test
	public void createaddressTestMap(){
		String actualJson;
		String expectedJson;
		MapAddressService service = new MapAddressService(true);
		actualJson = service.listAllAddresses();
		expectedJson = "{\"1\":{\"firstLine\":\"11 Example Street\",\"secondLine\":\"Cool House\",\"townOrCity\":\"Townsville\",\"county\":\"Countyford\",\"postcode\":\"TO11CF\"}}";
		assertEquals(actualJson,expectedJson);
		String newAddress = "{\"address_ID\":1,\"firstLine\":\"22 Test Lane\",\"secondLine\":\" \",\"townOrCity\":\"Test\",\"county\":\"Test\",\"postcode\":\"Test\"}";
		service.createAddress(newAddress);
		actualJson = service.listAllAddresses();
		expectedJson = "{\"1\":{\"address_ID\":0,\"firstLine\":\"11 Example Street\",\"secondLine\":\"Cool House\",\"townOrCity\":\"Townsville\",\"county\":\"Countyford\",\"postcode\":\"TO11CF\"},\"\"2\":{\"address_ID\":1,\"firstLine\":\"22 Test Lane\",\"secondLine\":\" \",\"townOrCity\":\"Test\",\"county\":\"Test\",\"postcode\":\"Test\"}}";
	}
	
	@Test
	public void updateaddressTestMap(){
		String actualJson;
		String expectedJson;
		MapAddressService service = new MapAddressService(true);
		actualJson = service.listAllAddresses();
		expectedJson = "{\"1\":{\"firstLine\":\"11 Example Street\",\"secondLine\":\"Cool House\",\"townOrCity\":\"Townsville\",\"county\":\"Countyford\",\"postcode\":\"TO11CF\"}}";
		assertEquals(actualJson,expectedJson);
		String newAddress = "{\"address_ID\":1,\"firstLine\":\"22 Test Lane\",\"secondLine\":\" \",\"townOrCity\":\"Test\",\"county\":\"Test\",\"postcode\":\"Test\"}";
		service.updateAddress(1l, newAddress);
		actualJson = service.listAllAddresses();
		expectedJson = "{\"1\":{\"address_ID\":1,\"firstLine\":\"22 Test Lane\",\"secondLine\":\" \",\"townOrCity\":\"Test\",\"county\":\"Test\",\"postcode\":\"Test\"}}";
		assertEquals(actualJson,expectedJson);
	}
	
	@Test
	public void readaddressTestDB(){
		AddressService databaseTest = Mockito.mock(DataBaseAddressService.class);
		when(databaseTest.listAllAddresses()).thenReturn("List Returned");
		assertEquals(databaseTest.listAllAddresses(), "List Returned");
	}
	
	@Test
	public void createaddressTestDB(){
		AddressService databaseTest = Mockito.mock(DataBaseAddressService.class);
		String newAddress = "{\"address_ID\":1,\"firstLine\":\"22 Test Lane\",\"secondLine\":\" \",\"townOrCity\":\"Test\",\"county\":\"Test\",\"postcode\":\"Test\"}";
		when(databaseTest.listAllAddresses()).thenReturn("List Returned");
		when(databaseTest.createAddress(newAddress)).thenReturn("address Created");
		assertEquals(databaseTest.listAllAddresses(), "List Returned");
		assertEquals(databaseTest.createAddress(newAddress), "address Created");
	}
	
	@Test
	public void updateaddressTestDB(){
		AddressService databaseTest = Mockito.mock(DataBaseAddressService.class);
		String newaddress = "{\"address_ID\":1,\"firstLine\":\"22 Test Lane\",\"secondLine\":\" \",\"townOrCity\":\"Test\",\"county\":\"Test\",\"postcode\":\"Test\"}";
		when(databaseTest.listAllAddresses()).thenReturn("List Returned");
		when(databaseTest.updateAddress(1l, newaddress)).thenReturn("address Updated");
		assertEquals(databaseTest.listAllAddresses(), "List Returned");
		assertEquals(databaseTest.updateAddress(1l, newaddress), "address Updated");
	}
}
