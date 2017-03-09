package com.qa.cinema.persistence;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Screen {
	
	@Id
	@GeneratedValue
	private long screen_ID;
	
	@OneToMany
	@JoinColumn(name = "screen_ID")
	private Set<Showing> showings = new HashSet<Showing>();
	
	private int numberOfSeats;

	private int screenNumber;
	
	public Screen() {
		
	}

	public Screen(long screen_ID, long venue_ID, int numberOfSeats, int screenNumber) {
		this.screen_ID = screen_ID;
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
}