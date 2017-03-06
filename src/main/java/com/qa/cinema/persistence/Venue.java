package com.qa.cinema.persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/** 
 * @author Rupert Langford
 */

@Entity
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long venue_ID;
	
	private String venueImg;
		
	@NotNull
	private String name;
	
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "venue_ID")
	private Set<Screen> screen = new HashSet<Screen>();
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="venue_address_id")
	private Address address;
	
	public Venue(){
	}
	
	public Venue(Long venue_ID, String name, String venueImg) {
		this.venue_ID = venue_ID;
		this.venueImg = venueImg;
		
		if(name != null)
			this.name = name;
		else
			this.name = "";
	}
	
	public Venue(String name) {
		if(name != null)
			this.name = name;
		else
			this.name = "";
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
	
	public String getVenueImg() {
		return venueImg;
	}

	public void setVenueImg(String venueImg) {
		this.venueImg = venueImg;
	}
	
	public Set<Screen> getScreen() {
		return screen;
	}

	public void setScreen(Set<Screen> screen) {
		screen = screen;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
