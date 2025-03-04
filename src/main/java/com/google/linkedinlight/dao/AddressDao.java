package com.google.linkedinlight.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.linkedinlight.entity.Address;
import com.google.linkedinlight.repository.AddressRepository;
@Repository
public class AddressDao {
	 @Autowired
     private AddressRepository repository;
	public Address saveAddress(Address address) {
		
		
		return repository.save(address);
	}
	public List<Address> findAllAddresses() {
		
		return repository.findAll();
	}
	public Optional<Address> findAddressById(int id) {
		
		return repository.findById(id);
	}

}
