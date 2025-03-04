package com.google.linkedinlight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.google.linkedinlight.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
	@Query("select e from Employee e where e.status='ACTIVE'")
	List<Employee> findAllActiveEmployees();

	@Query("select e from Employee e where e.status='INACTIVE'")
	List<Employee> findAllInActiveEmployees();
    
	@Query("select e from Employee e where e.experience='FRESHER'")
	List<Employee> findAllFresherEmployee();

	
	
	
                                        
}
