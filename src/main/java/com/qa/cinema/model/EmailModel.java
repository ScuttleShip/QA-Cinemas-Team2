package com.qa.cinema.model;

public class EmailModel {
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String cinemaConcerned;
	private StringBuilder message;
	
	public EmailModel() {
		
	}
	
	public EmailModel(String firstName, String lastName, String email, String phone, String cinemaConcerned, String message) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.cinemaConcerned = cinemaConcerned;
		this.message = new StringBuilder();
		composeEmail();
		
	}
	
	private void composeEmail() {
		
		String firstLine = "Email received from " + firstName + " " + lastName;
		String secondLine = "\nPhone Number: " + phone;
		String thirdLine = "\nEmail Address: " + email;
		String fourthLine = "\nRegarding: " + cinemaConcerned;
		String fifthLine = "\nMessage: \n" + message;
		
		this.message.append(firstLine + secondLine + thirdLine + fourthLine + fifthLine);
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCinemaConcerned() {
		return cinemaConcerned;
	}
	public void setCinemaConcerned(String cinemaConcerned) {
		this.cinemaConcerned = cinemaConcerned;
	}
	public StringBuilder getMessage() {
		return message;
	}
	public void setMessage(StringBuilder message) {
		this.message = message;
	}

}
