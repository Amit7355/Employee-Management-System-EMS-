package com.sampark.employeeManagement.dto;

//import java.util.List;

//import com.sampark.employeeManagement.entity.Employee;

public class DashBoardResponse {
	
//	private List<Employee> activeEmployees;
//	private List<Employee> inactiveEmployees;
//	private List<TopSalaryResponse> topSalary;
	private long activeEmployees;
	private long inactiveEmployees;
	public DashBoardResponse()
	{		
		
	}
	
	public DashBoardResponse(long activeEmployees, long inactiveEmployees) 
	{
		this.activeEmployees = activeEmployees;
		this.inactiveEmployees = inactiveEmployees;
		//this.topSalary = topSalary;
	}

	public long getActiveEmployees() {
		return activeEmployees;
	}

	public void setActiveEmployees(long activeEmployees) {
		this.activeEmployees = activeEmployees;
	}

	public long getInactiveEmployees() {
		return inactiveEmployees;
	}

	public void setInactiveEmployees(long inactiveEmployees) {
		this.inactiveEmployees = inactiveEmployees;
	}
	
//	public List<Employee> getActiveEmployees() {
//		return activeEmployees;
//	}
//	public void setActiveEmployees(List<Employee> activeEmployees) {
//		this.activeEmployees = activeEmployees;
//	}
//	public List<Employee> getInactiveEmployees() {
//		return inactiveEmployees;
//	}
//	public void setInactiveEmployees(List<Employee> inactiveEmployees) {
//		this.inactiveEmployees = inactiveEmployees;
//	}
//	public List<TopSalaryResponse> getTopSalary() {
//		return topSalary;
//	}
//	public void setTopSalary(List<TopSalaryResponse> topSalary) {
//		this.topSalary = topSalary;
//	}
//	
	
	
	

}
