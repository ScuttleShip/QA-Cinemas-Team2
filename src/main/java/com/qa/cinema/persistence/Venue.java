package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;

/**
 * 
 * 
 * @author Rupert Langford
 *
 */

@Entity
public class Venue {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long venueID;
	
	@NotNull
	private Long addressID;
	
	@NotNull
	private String name;

	public Venue(){
		
	}
	
	public Venue(String name) {
		super();
		this.name = name;
	}

	//Getters and Setters
	public Long getVenueID() {
		return venueID;
	}

	public void setVenueID(Long venueID) {
		this.venueID = venueID;
	}

	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
