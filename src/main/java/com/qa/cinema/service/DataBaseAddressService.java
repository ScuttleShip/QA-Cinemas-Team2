package com.qa.cinema.service;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.qa.cinema.persistence.Address;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
public class DataBaseAddressService implements AddressService
{
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;
	
	@Override
	public String listAllAddresses()
	{
		Query q = em.createQuery("SELECT a FROM Address a");
		Collection<Address> addresses = (Collection<Address>) q.getResultList();
		return util.getJSONForObject(addresses);
	}

	@Override
	public String updateAddress(Long address_ID, String addressDetails)
	{
		Address update = util.getObjectForJSON(addressDetails, Address.class);
		Address addressInDB = findAddress(new Long (address_ID));
		if (addressInDB != null)
		{
			update.setAddress_ID(addressInDB.getAddress_ID());
			addressInDB = update;
			em.merge(addressInDB);
		}
		return "{\"message\": \"Address sucessfully updated\"}";
	}

	@Override
	public String createAddress(String addressDetails)
	{
		Address newAddress = util.getObjectForJSON(addressDetails, Address.class);
		em.persist(newAddress);
		return "{\"message\": \"Address sucessfully added\"}";
	}
	
	private Address findAddress(Long id)
	{
		return em.find(Address.class, id);
	}
}
