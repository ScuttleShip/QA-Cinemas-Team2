package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Screen {
	
	@Id
	@GeneratedValue
	private long screen_ID;
	
	@ManyToOne
	private Venue venue;
	
	private int numberOfSeats;
	
	public Screen() {
		
	}

	public Screen(long screen_ID, long venue_ID, int numberOfSeats) {
		super();
		this.screen_ID = screen_ID;
		this.numberOfSeats = numberOfSeats;
	}

	public long getScreen_ID() {
		return screen_ID;
	}

	public void setVenue(Venue venue_ID) {
		this.venue = venue_ID;
	}

	public void setScreen_ID(long screen_ID) {
		this.screen_ID = screen_ID;
	}

	public Venue getVenue() {
		return venue;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}





}
