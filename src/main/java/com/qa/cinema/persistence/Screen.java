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

@Entity
public class Screen { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long screen_ID;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "screen_ID")
	private Set<Showing> showings = new HashSet<Showing>();
	
	private Long venue_ID;

	private int numberOfSeats;

	private int screenNumber;
	
	public Screen() {
		
	}

	public Screen(long venue_ID, int numberOfSeats, int screenNumber) {
		this.numberOfSeats = numberOfSeats;
		this.screenNumber = screenNumber;
	}

	public long getScreen_ID() {
		return screen_ID;
	}

	public void setScreen_ID(long screen_ID) {
		this.screen_ID = screen_ID;
	}
	
	public Set<Showing> getShowings() {
		return showings;
	}

	public void setShowings(Set<Showing> showings) {
		this.showings = showings;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	public int getScreenNumber() {
		return screenNumber;
	}

	public void setScreenNumber(int screenNumber) {
		this.screenNumber = screenNumber;
	}
	
	public Long getVenue_ID() {
		return venue_ID;
	}

	public void setVenue_ID(Long venue_ID) {
		this.venue_ID = venue_ID;
	}
}