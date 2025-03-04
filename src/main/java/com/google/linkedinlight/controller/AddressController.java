package com.google.linkedinlight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.linkedinlight.entity.Address;
import com.google.linkedinlight.entity.Education;
import com.google.linkedinlight.responsestructure.ResponseStructure;
import com.google.linkedinlight.service.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	private  AddressService service;
	
	@PostMapping("/addresses/{eid}")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address,@PathVariable int eid ){
		return service.saveAddress(address,eid);
		
	}
	@GetMapping("/employee/{eid}")
     public ResponseStructure<List<Address>> findAllAddressByEmployeeId(@PathVariable int eid){
		return service.findAllAddresssByEmployeeId(eid);
	}
	@PatchMapping("/status/inactive/{id}")
	public ResponseStructure<Address> setStatusToInactive(@PathVariable int id){
		return service.setStatusToInactive(id);
	}
	
	

}
