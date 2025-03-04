package com.google.linkedinlight.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import com.google.linkedinlight.dao.EmployeeDao;
import com.google.linkedinlight.entity.Employee;
import com.google.linkedinlight.responsestructure.ResponseStructure;

@Service
public class EmployeeService {
	 @Autowired
     private EmployeeDao dao;
	public ResponseStructure<Employee> saveEmployee(Employee employee) {
		
		    employee=dao.saveEmployee(employee);
		    ResponseStructure<Employee> structure= new ResponseStructure<>();
			structure.setStatus(200);
			structure.setMessage("Employee saved successfully");
			structure.setBody(employee);
			
			return structure;
		
		
			}
	
		
	public ResponseStructure<List<Employee>> findAllEmployees() {
		List<Employee> emps=dao.findAllEmployees();
		if(emps.isEmpty()) {
			//throw new NoEmployeeFoundException();
		}
		ResponseStructure<List<Employee>> structure= new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage(" All Employees Found successfully");
		structure.setBody(emps);
		
	
		return structure;
	}
	


	public ResponseStructure<List<Employee>> findAllActiveEmployees() {
   List<Employee> emps=dao.findAllActiveEmployees();
		
		if(emps.isEmpty()) {
			//throw new NoEmployeeFoundException();
		}
		ResponseStructure<List<Employee>> structure= new ResponseStructure<>();
		
		structure.setStatus(200);
		structure.setMessage("Employee found successfully");
		structure.setBody(emps);
		
		return structure;
		
	}


	


	public ResponseStructure<Employee> findEmployeeById(int id) {
		
		Optional<Employee> optional= dao.findEmployeeById(id);
		if(optional.isEmpty()) {
		//	throw new InvalidEmployeeIdException();
			
		}
		ResponseStructure<Employee> structure= new ResponseStructure<>();
		
		Employee employee= optional.get();
		structure.setStatus(200);
		structure.setMessage("Employee found Successfully");
		structure.setBody(employee);
		
		return structure;
	}


	public ResponseStructure<List<Employee>> findAllInActiveEmployees() {
        List<Employee> emps=dao.findAllInActiveEmployees();
		
		if(emps.isEmpty()) {
			//throw new NoEmployeeFoundException();
		}
		ResponseStructure<List<Employee>> structure= new ResponseStructure<>();
		
		structure.setStatus(200);
		structure.setMessage("Employee found successfully");
		structure.setBody(emps);
		
		return structure;
	}


	public ResponseStructure<List<Employee>> findAllFresherEmployee() {
		
		 List<Employee> emps=dao.findAllFresherEmployee();
			
			if(emps.isEmpty()) {
				//throw new NoEmployeeFoundException();
			}
			ResponseStructure<List<Employee>> structure= new ResponseStructure<>();
			
			structure.setStatus(200);
			structure.setMessage("Employee found successfully");
			structure.setBody(emps);
		return structure;
	}


	
	}
	


