package com.fullstackproject.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "FSP_EMPLOYEE")
public class Employee extends AbstractEntity {
	
	@Column(name = "employee_id", nullable = false, updatable = false, unique = true)
	private String employeeId;
	
	@Column(name= "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "designation", nullable = false)
	private String designation;
	
	@Column(name = "base_location", nullable = false)
	private String location;
	
	@Column(name = "joining_date", nullable = false, updatable = false)
	private Date joiningDate;
	
	@Column(name = "grade", nullable = false)
	private String grade;
	
	@Column(name = "salary", nullable = false)
	private Double salary;
	
	@Column(name = "updated_date")
	@UpdateTimestamp
	private Timestamp updated_date;

	public Employee() {
	}
	
	public Employee(String employeeId, String firstName, String lastName, String designation, String location,
			Date joiningDate, String grade, Double salary,Timestamp updated_date) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.location = location;
		this.joiningDate = joiningDate;
		this.grade = grade;
		this.salary = salary;
		this.updated_date = updated_date;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Timestamp getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Timestamp updated_date) {
		this.updated_date = updated_date;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", designation=" + designation + ", location=" + location + ", joiningDate=" + joiningDate
				+ ", grade=" + grade + ", salary=" + salary + ", updated_date=" + updated_date + "]";
	}
}
