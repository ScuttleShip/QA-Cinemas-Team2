package com.qa.cinema.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	//attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_ID")
	private Long address_ID;
	
	@NotNull
	private String firstLine;
	private String secondLine;
	private String townOrCity;
	private String county;
	@NotNull
	private String postcode;
	
	public Address(){}
	
	public Address(String firstLine, String secondLine, String townCity, String county, String postcode)
	{
		if(firstLine != null && !firstLine.equals(null))
			this.firstLine = firstLine;
		else
			this.firstLine = "";
		this.secondLine = secondLine;
		this.townOrCity = townCity;
		this.county = county;
		this.postcode = postcode;
	}
	
	public Address(String firstLine, String postcode) {
		if(firstLine != null && !firstLine.equals(null))
			this.firstLine = firstLine;
		else
			this.firstLine = "";
		
		this.postcode = postcode;
	}
	
	public Long getAddress_ID() {
		return address_ID;
	}

	public void setAddress_ID(Long address_ID) {
		this.address_ID = address_ID;
	}
	
	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}
	
	public String getSecondLine() {
		return secondLine;
	}
	
	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}
	
	public String getTownOrCity() {
		return townOrCity;
	}
	
	public void setTownOrCity(String townCity) {
		this.townOrCity = townCity;
	}
	
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
}