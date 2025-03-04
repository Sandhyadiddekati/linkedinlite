package com.google.linkedinlight.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.linkedinlight.entity.Education;
import com.google.linkedinlight.entity.Employee;
import com.google.linkedinlight.repository.EmployeeRepository;
@Repository
public class EmployeeDao {
    @Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee) {
		
			return repository.save(employee);
		}

	public List<Employee> findAllEmployees() {
		
		return repository.findAll();
	}

	public List<Employee> findAllActiveEmployees() {
		
		return repository.findAllActiveEmployees();
	}

	public Optional<Employee> findEmployeeById(int id) {
	
		return repository.findById(id);
	}

	public List<Employee> findAllInActiveEmployees() {
		
		return repository.findAllInActiveEmployees();
	}

	public List<Employee> findAllFresherEmployee() {

		return repository.findAllFresherEmployee();
	}



	}

	
	

	

		


