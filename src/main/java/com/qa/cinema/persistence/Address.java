package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	//attributes
	@Id
	@GeneratedValue
	private int addressId;
	@NotNull
	private String firstLine;
	private String secondLine;
	private String townOrCity;
	private String county;
	@NotNull
	private String postcode;
	
	//Constructors
	public Address(){
		
	}
	public Address(String firstLine, String secondLine, String townCity, String county, String postcode) {
		firstLine = firstLine;
		secondLine = secondLine;
		townCity = townCity;
		county = county;
		postcode = postcode;
	}
	public Address(String firstLine, String postcode) {
		firstLine = firstLine;
		postcode = postcode;
	}
	
	//methods
	public String getFirstLine() {
		return firstLine;
	}
	public void setFirstLine(String firstLine) {
		firstLine = firstLine;
	}
	public String getSecondLine() {
		return secondLine;
	}
	public void setSecondLine(String secondLine) {
		secondLine = secondLine;
	}
	public String getTownOrCity() {
		return townOrCity;
	}
	public void setTownOrCity(String townCity) {
		townCity = townCity;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		county = county;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		postcode = postcode;
	}
	
	

}