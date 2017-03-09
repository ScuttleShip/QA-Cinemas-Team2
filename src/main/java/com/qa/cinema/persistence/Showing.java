package com.qa.cinema.persistence;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author FWasim
 */
@Entity
public class Showing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long showing_ID;

	@OneToMany
	@JoinColumn(name = "showing_ID")
	private Set<Booking> bookings = new HashSet<Booking>();
	
	@ManyToOne
	@JoinColumn(name = "movie_ID")
	private Movie movie;
	
	@Temporal(TemporalType.TIME)
	@NotNull
	private Date startTime;

	@Temporal(TemporalType.DATE)
	@NotNull
	private Date date;

	@NotNull
	private int seatsRemaining;

	public Showing() {

	}

	public Showing(Long showing_ID, Date startTime, Date date,
			int seatsRemaining) {
		this.showing_ID = showing_ID;
		this.startTime = startTime;
		this.date = date;
		this.seatsRemaining = seatsRemaining;
	}

	public Long getShowing_ID() {
		return showing_ID;
	}

	public void setShowing_ID(Long showingID) {
		this.showing_ID = showingID;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSeatsRemaining() {
		return seatsRemaining;
	}

	public void setSeatsRemaining(int seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Showing [showingID=" + showing_ID + ", startTime=" + startTime
				+ ", date=" + date + ", seatsRemaining=" + seatsRemaining + "]";
	}
}