package com.sampark.employeeManagement.service;

public class ResourceNotFoundException extends RuntimeException{
	
	public  ResourceNotFoundException(String m)
	{
		super(m);
	}

}
