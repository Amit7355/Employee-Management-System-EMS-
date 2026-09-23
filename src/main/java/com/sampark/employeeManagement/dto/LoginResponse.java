package com.sampark.employeeManagement.dto;

public class LoginResponse {
	
	private long empid;
	private String ename;
	private String message;
	
	public LoginResponse(long empid, String ename, String message) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.message = message;
	}

	public long getEmpid() {
		return empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
