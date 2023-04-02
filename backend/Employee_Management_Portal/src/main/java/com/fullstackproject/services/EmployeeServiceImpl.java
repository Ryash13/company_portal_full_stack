package com.fullstackproject.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fullstackproject.constants.Constants;
import com.fullstackproject.dto.EmployeeDto;
import com.fullstackproject.entities.Employee;
import com.fullstackproject.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	
	@Override
	public List<EmployeeDto> listAllEmployees() {
		LOGGER.info(Instant.now() + " ------ " + "Executing listAllEmployees function");
		List<EmployeeDto> result = new ArrayList<>();
		try {
			List<Employee> employeeList = repository.findAll();
			if(!employeeList.isEmpty()) {
				for(Employee emp : employeeList) {
					EmployeeDto dto = modelMapper.map(emp, EmployeeDto.class);
					result.add(dto);
				}
			}
		} catch(Exception exception) {
			LOGGER.info(Instant.now() + " ------ " + "Error occured Executing listAllEmployees function");
			exception.printStackTrace();
		}
		return result;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		LOGGER.info(Instant.now() + " ------ " + "Executing updateEmployee function");
		Employee result = new Employee();
		try {
			if(!employee.getId().equals(null)) {
				result = repository.save(employee);
			} else {
				LOGGER.error(Instant.now() + " ------ " + "Invalid Employee entity passed");
				throw new Exception("Invalid Employee entity passed");
			}
			
		} catch(Exception exception) {
			LOGGER.info(Instant.now() + " ------ " + "Error occured Executing updateEmployee function");
			exception.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteEmployee(Long id) {
		LOGGER.info(Instant.now() + " ------ " + "Executing deleteEmployee function for id {} ", id);
		boolean result = false;
		try {
			Employee employee = repository.findById(id).orElseThrow(
					() -> new Exception("No Employee found with ID " + id));
			repository.delete(employee);
			result = true;
		} catch(Exception exception) {
			LOGGER.info(Instant.now() + " ------ " + "Error occured Executing deleteEmployee function for id {} ", id);
			exception.printStackTrace();
		}
		return result;
	}

	@Override
	public EmployeeDto addEmployee(Employee employee) {
		LOGGER.info(Instant.now() + " ------ " + "Executing addEmployee function");
		EmployeeDto result = new EmployeeDto();
		try {
			String employeeId = generateEmployeeId();
			employee.setEmployeeId(employeeId);
			repository.save(employee);
			LOGGER.info(Instant.now() + " ----- " + "Mapping Entity into DTO");
			result = modelMapper.map(employee, EmployeeDto.class);
		} catch(Exception exception) {
			LOGGER.info(Instant.now() + " ------ " + "Error occured Executing addEmployee function");
			exception.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Employee getEmployeeDetails(String employeeId) {
		LOGGER.info(Instant.now() + " ------ " + "Executing getEmployeeDetails function for employeeID {} ", employeeId);
		Employee result = new Employee();
		try {
			result = repository.findByEmployeeId(employeeId).orElseThrow(
					() -> new Exception("No Employee found with EmployeeID " + employeeId));
			
		} catch(Exception exception) {
			LOGGER.info(Instant.now() + " ------ " + "Error occured getEmployeeDetails function for employeeID {} ", employeeId);
			exception.printStackTrace();
		}
		return result;
	}
	
	private String generateEmployeeId() {
		StringBuilder builder = new StringBuilder(9);
		builder.append(Constants.EID);
		for(int i=0;i<6;i++) {
			int index = (int) (Constants.NUMBERS.length() * Math.random());
			builder.append(Constants.NUMBERS.charAt(index));
		}
		Integer check = checkEmployeeIdExistance(builder.toString());
		if(check > 0) {
			generateEmployeeId();
		}
		return builder.toString();
	}
	
	private Integer checkEmployeeIdExistance(String employeeId) {
		LOGGER.info(Instant.now() + " ------ " + "Executing checkEmployeeIdExistance function");
		LOGGER.info(Instant.now() + " ------ " + "Executing db script {}", Constants.EMPLOYEEIDCHECK);
		Integer count = (Integer) jdbcTemplate.queryForObject(Constants.EMPLOYEEIDCHECK, Integer.class, new Object[] {employeeId});
		LOGGER.info(Instant.now() + " ------ " + "Script returned value as {}", count);
		return count;
	}

}
