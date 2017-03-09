package com.qa.cinema.service;

import static  com.qa.cinema.util.Print.header;
import static  com.qa.cinema.util.Print.print;
import static  com.qa.cinema.util.Print.printBlock;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.cinema.persistence.Address;
import com.qa.cinema.util.JSONUtil;

@ApplicationScoped
@Alternative
public class AddressServiceMapImpl implements AddressuService {
	@Inject
	private JSONUtil converter;
	private Map<Long, Address> data = new HashMap<Long, Address>();
	private long id = 1;
	private final boolean verbose;
	
	public AddressServiceMapImpl(boolean verbose) {	
		this.verbose = verbose;
		converter = new JSONUtil();
		generateDummyData();
	}
	
	@Override
	public String listAllAddresses() {
		log("Returning all addresses");
		String s = converter.getJSONForObject(data);
		log(s);
		log("Addresses Returned");
		return s;
	}

	@Override
	public String updateAddress(Long addressId, String addressDetails) {
		log("Updating Address");
		Address newAddress = converter.getObjectForJSON(addressDetails, Address.class);
		data.put(addressId, newAddress);
		log("Address Updated");
		return "Address Updated";
	}

	@Override
	public String createAddress(String addressDetails) {
		log("Creating address");
		Address newAddress = converter.getObjectForJSON(addressDetails, Address.class);
		data.put(id++, newAddress);
		log("address Created");	
		return "address Created";
	}
	
	private void generateDummyData() {
		log("Generating Data");
		data.put(id++, new Address("11 Example Street", "Cool House", "Townsville", "Countyford", "TO11CF"));
		if(verbose){
			printDataState();
		}
		log("Data Generation Complete");
	}
	
	private void printDataState() {
		print("Data Map Size:"+ data.size());	
		print(header("Data",65));
		
		for(Map.Entry<Long, Address> entry : data.entrySet())
		{
			String id = "|ID:" + entry.getValue().getAddress_ID();
			String fl = "|First Line:" + entry.getValue().getFirstLine();
			String sl = "|Second Line:" + entry.getValue().getSecondLine();
			String to = "|Town:" + entry.getValue().getTownOrCity();
			String co = "|County:" + entry.getValue().getCounty();
			String pc = "|Postcode:" + entry.getValue().getPostcode();
			printBlock(id, fl, sl, to, co, pc, "");
		}
		print(header("",65));
	}
	
	private void log(String input)
	{
		if(verbose){
			print(input);
		}
	}
}