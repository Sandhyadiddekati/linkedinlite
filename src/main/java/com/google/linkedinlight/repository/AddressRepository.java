package com.google.linkedinlight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.linkedinlight.entity.Address;

public interface AddressRepository  extends JpaRepository<Address, Integer>{

}
