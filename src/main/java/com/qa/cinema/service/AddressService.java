package com.qa.cinema.service;

public interface AddressService
{
	String listAllAddresses();
	String updateAddress(Long addressId, String addressDetails);
	String createAddress(String addressDetails);
}
