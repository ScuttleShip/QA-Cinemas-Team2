package com.qa.cinema.service;

public interface VenueService{
	
	String getAllVenues();
	String addNewVenue(String venueJson);
	String updateVenue(Long venueID, String updatedVenue);
	String deleteVenue(Long venueID);
}