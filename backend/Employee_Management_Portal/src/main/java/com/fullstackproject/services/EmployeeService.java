package com.fullstackproject.services;

import com.fullstackproject.dto.EmployeeDto;
import com.fullstackproject.entities.Employee;

import java.util.List;

public interface EmployeeService {
	
	List<EmployeeDto> listAllEmployees();
	Employee updateEmployee(Employee employee);
	boolean deleteEmployee(Long id);
	EmployeeDto addEmployee(Employee employee);
	Employee getEmployeeDetails(String employeeId);
}
