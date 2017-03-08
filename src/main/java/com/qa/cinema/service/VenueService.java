package com.qa.cinema.service;

public interface VenueService{
	
	String getAllVenues();
	String addNewVenue(String venueJson);
	String updateVenue(Long venue_ID, String updatedVenue);
	String deleteVenue(Long venue_ID);
	String findVenueByID(Long venue_ID);
}