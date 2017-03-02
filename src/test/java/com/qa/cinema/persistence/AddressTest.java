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
		String result = address.getSecondLine();
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
	
	@Test
	public void getSetID() {
		address = new Address();
		assertNull(address.getAddress_ID());
		address.setAddress_ID(Long.valueOf(5));
		long result = Long.valueOf(address.getAddress_ID());
		result = Long.valueOf(address.getAddress_ID());
		assertEquals(5, result);
	}
	
	@Test
	public void constructorTest()
	{
		address = new Address("11 Test Street", "TT1TT1");
		String fl = address.getFirstLine();
		String pc = address.getPostcode();
		assertEquals(fl, "11 Test Street");
		assertEquals(pc, "TT1TT1");
		address = new Address(null, "TT2TT2");
		fl = address.getFirstLine();
		pc = address.getPostcode();
		assertEquals(fl, "");
		assertEquals(pc, "TT2TT2");
		
		address = new Address(null, null, null, null, null);
		fl = address.getFirstLine();
		assertEquals(fl, "");
	}
}