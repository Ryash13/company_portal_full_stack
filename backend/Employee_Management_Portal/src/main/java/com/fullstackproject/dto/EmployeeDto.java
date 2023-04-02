package com.fullstackproject.dto;

import java.util.Date;

public class EmployeeDto {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String designation;
	private String location;
	private Date joiningDate;
	private String grade;
	
	public EmployeeDto() {
		super();
	}

	public EmployeeDto(String employeeId, String firstName,String lastName, String designation, String location, Date joiningDate,
			String grade) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.location = location;
		this.joiningDate = joiningDate;
		this.grade = grade;
	}

	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", designation=" + designation + ", location=" + location + ", joiningDate=" + joiningDate
				+ ", grade=" + grade + "]";
	}
}
