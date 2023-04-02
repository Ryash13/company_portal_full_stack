package com.fullstackproject.constants;

public interface Constants {

	String EID = "EID";
	String NUMBERS = "1234567890";
	
	String EMPLOYEEIDCHECK = "SELECT count(*) FROM FSP_EMPLOYEE where employee_id = ?"; 
}
