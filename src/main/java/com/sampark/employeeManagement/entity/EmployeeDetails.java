package com.sampark.employeeManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_details")
public class EmployeeDetails {

	@Id
	@Column(name="emp_id")
	private long empid;
	private String pan;
	private String gender;
	private String address;
	
	
	@OneToOne
	@MapsId
	@JoinColumn(name="emp_id")
	@JsonIgnore()
	private Employee employee;
	

	public EmployeeDetails()
	{
		
	}


	// Getter and Setter
	
	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}




	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public long getEmpid() {
		return empid;
	}


	public void setEmpid(long empid) {
		this.empid = empid;
	}
	
	
	
}
