package com.google.linkedinlight.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.linkedinlight.dao.AddressDao;
import com.google.linkedinlight.dao.EmployeeDao;
import com.google.linkedinlight.entity.Address;
import com.google.linkedinlight.entity.Education;
import com.google.linkedinlight.entity.Employee;
import com.google.linkedinlight.responsestructure.ResponseStructure;
import com.google.linkedinlight.util.AddressStatus;
import com.google.linkedinlight.util.EducationStatus;
@Service
public class AddressService {
	@Autowired
  private AddressDao addressDao;
	@Autowired
	private EmployeeDao employeeDao;
  
  
	
	public ResponseStructure<Address> saveAddress(Address address, int eid) {
		Optional<Employee> optional=employeeDao.findEmployeeById(eid);
		if(optional.isEmpty()) {
			//throw new InvalidEmployee();
		}
		Employee employee=optional.get();
		address.setEmployee(employee);
		address=addressDao.saveAddress(address);
		ResponseStructure<Address> structure=new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage("Address saved successfully");
		structure.setBody(address);
		
		
		
		return structure;
	}



	public ResponseStructure<List<Address>> findAllAddresssByEmployeeId(int eid) {
		 List<Address> al=addressDao.findAllAddresses();
			if(al.isEmpty()) {
				//throw new NoAddressException;
			}
			ArrayList<Address> fel= new ArrayList<>();
		
			for(Address addrs:al) {
				Employee emp=addrs.getEmployee();
				
				if(emp.getId()==eid) {
					
					fel.add(addrs);
				}
			}
			if(fel.isEmpty()) {
				//throw new NoEducationFoundException;
			}
			

			ResponseStructure<List<Address>> structure=new ResponseStructure<>();
			structure.setStatus(200);
		    structure.setMessage("All Addresses found Successfully from Employee Id:+eid");
		     structure.setBody(fel);
		return structure;
	}



	public ResponseStructure<Address> setStatusToInactive(int id) {
		Optional<Address> optional=addressDao.findAddressById(id);
		if(optional.isEmpty()) {
			//throw new InvalidEducationIdException;
		}
		Address address=optional.get();
		address.setStatus(AddressStatus.INACTIVE);
		address=addressDao.saveAddress(address);
		ResponseStructure<Address> structure=new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage("Address status updated to in"
				+ "ACTIVE successfuly");
		structure.setBody(address);
		return structure;
	}



	

}
