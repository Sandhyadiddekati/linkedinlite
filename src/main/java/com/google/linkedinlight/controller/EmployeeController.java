package com.google.linkedinlight.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.linkedinlight.entity.Employee;
import com.google.linkedinlight.responsestructure.ResponseStructure;
import com.google.linkedinlight.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@Operation(summary = "To Save an Employee",description="This API is Used to Save an Employee object,this Api Accepts the Request Body of Employee Object which should contains the fields an follows: firstName,lastName,email,phone,password and salary in the requested JSON Object and it shouldn't have id field in it,if id present it performs update operation,if id is not present it perform to save operation")
	
	@PostMapping
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee){
		
		return service.saveEmployee(employee);
	}
	
	@Operation(summary = "To Fetch All Employees",description = "This API is Used to Fetch an Employee Database Table ")
	@ApiResponse(responseCode = "200",description = "Found All Employees")
	@GetMapping
	public ResponseStructure<List<Employee>> findAllEmployees(){
		return service.findAllEmployees();
		
	}
	@Operation(summary = "To Fetch all Active Employyes",description = "This API is Used to Fetch ALL Active  Employees object,this Api Accepts the Request Body of Employee Object which should contains the fields an follows: firstName,lastName,email,phone,password and salary in the requested JSON Object and it shouldn't have id field in it,if id present it performs update operation,if id is not present it perform to find active employee id operation")
	@GetMapping("/status/active")
	public ResponseStructure<List<Employee>> findAllActiveEmployees(){
		return service.findAllActiveEmployees();
	}
	@Operation(summary = "To Fetch All InActive Employees",description = "This API is used to Fetch All InActive Employes")
	@GetMapping("/status/inactive")
	public ResponseStructure<List<Employee>> findAllInActiveEmployee(){
		return service.findAllInActiveEmployees();
	}
	@Operation(summary = "To Fetch An Employee By Id",description = "This API is used to Fetch Employee By Id")
	@GetMapping("/{id}")
	public ResponseStructure<Employee> findEmployeeById(@PathVariable int id){
		return service.findEmployeeById(id);
	}
	@Operation(summary = "To find All Fresher Employyes",description = "This API is used to Fetch All Fresher Employees")
	@GetMapping("/experience/fresher")
	public ResponseStructure<List<Employee>> findAllFresherEmployee(){
		return service.findAllFresherEmployee();
	}
	
	@Scheduled(fixedRate = 2000)
	public void hi() {
		System.out.println("Hi method is invoked in :"+ LocalDateTime.now());
		
	}

}
