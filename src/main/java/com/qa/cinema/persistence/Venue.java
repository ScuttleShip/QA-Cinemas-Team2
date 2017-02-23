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
	private Long venue_ID;
		
	@NotNull
	private String name;

	public Venue(){
		
	}
	
	public Venue(Long venue_ID, String name) {
		super();
		this.venue_ID = venue_ID;
		this.name = name;
	}
	
	public Venue(String name) {
		super();
		this.name = name;
	}

	//Getters and Setters
	public Long getVenue_ID() {
		return venue_ID;
	}

	public void setVenue_ID(Long venue_ID) {
		this.venue_ID = venue_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
