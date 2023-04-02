package com.fullstackproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackproject.entities.Employee;
import com.fullstackproject.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployees() {
		return new ResponseEntity<>(service.listAllEmployees(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addNewEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(service.addEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/byEmployeeId/{employeeId}")
	public ResponseEntity<?> getByEmployeeId(@PathVariable("employeeId") String employeeId) {
		return new ResponseEntity<>(service.getEmployeeDetails(employeeId), HttpStatus.OK);
	}

}
