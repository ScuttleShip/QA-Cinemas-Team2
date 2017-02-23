package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Screen {
	
	@Id
	@GeneratedValue
	private long screen_ID;
	private long venue_ID;
	private int numberOfSeats;
	
	public Screen() {
		
	}

	public Screen(long screen_ID, long venue_ID, int numberOfSeats) {
		super();
		this.screen_ID = screen_ID;
		this.venue_ID = venue_ID;
		this.numberOfSeats = numberOfSeats;
	}

	public long getScreen_ID() {
		return screen_ID;
	}

	public void setScreen_ID(long screen_ID) {
		this.screen_ID = screen_ID;
	}

	public long getVenue_ID() {
		return venue_ID;
	}

	public void setVenue_ID(long venue_ID) {
		this.venue_ID = venue_ID;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}





}
