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

import com.google.linkedinlight.entity.Education;
import com.google.linkedinlight.entity.Employee;
import com.google.linkedinlight.responsestructure.ResponseStructure;
import com.google.linkedinlight.service.EducationService;

import io.swagger.v3.oas.annotations.Operation;
@RestController
@RequestMapping("/educations")
public class EducationController {
	@Autowired
	private EducationService service;
	@Operation(summary = "To save Educution Id",description = "This Api is used to to save Educution Object with help json Object,if it perform To save educution details")
	@PostMapping("/educations/{eid}")
	public ResponseStructure<Education> saveEducation(@RequestBody Education education, @PathVariable int eid){
		return service.saveEducation(education,eid);
	}
	@Operation(summary = "To Find All Educution By EmployeeId",description ="This API is used to find All Educution By Employee Id")
	@GetMapping("/employee/{eid}")
	public ResponseStructure<List<Education>> findAllEducationsByEmployeeId(@PathVariable int eid){
		return service.findAllEducationsByEmployeeId(eid);
	}
	@Operation(summary = "To Find StatusToACTIVE",description = "This API is used to find All Active Employee Object")
	@PatchMapping("/status/active/{id}")
	public ResponseStructure<Education> setStatusToactive(@PathVariable int id){
		return service.setStatusToactive(id);
	}
	@Operation(summary = "To find Fresher Employee Id",description = "This API is used to Find only Fresher Emplyee Id's")
	@GetMapping("/experience/fresher/{id}")
	public ResponseStructure<List<Education>> findAllFresherEmployeeById(@PathVariable int eid){
		return service.findAllFresherEmployeeById(eid);
	
	
	}

}
