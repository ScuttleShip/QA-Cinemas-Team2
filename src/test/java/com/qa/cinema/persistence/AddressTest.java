package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {
	
	Address address;

	
	@Test
	public void getSetFirstLine() {
		address = new Address();
		address.setFirstLine("Dummy");
		String result = address.getFirstLine();
		assertEquals("Dummy", result);
	}
	
	@Test
	public void getSetSecondLine() {
		address = new Address();
		address.setSecondLine("Dummy");
		String result = address.getFirstLine();
		assertEquals("Dummy", result);
	}
	
	@Test
	public void getSetTownCity() {
		address = new Address();
		address.setTownOrCity("Dummy");
		String result = address.getTownOrCity();
		assertEquals("Dummy", result);
	}
	
	@Test
	public void getSetCounty() {
		address = new Address();
		address.setCounty("Dummy");
		String result = address.getCounty();
		assertEquals("Dummy", result);
	}
	
	@Test
	public void getSetPostcode() {
		address = new Address();
		address.setPostcode("Dummy");
		String result = address.getPostcode();
		assertEquals("Dummy", result);
	}

}