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
@Table(name="employee_salary")
public class EmployeeSalary 
{
	
	@Id
	@Column(name="emp_id")
	private long empid;
	
	private double salary;
	@Column(name="basic_salary")
	private double basicSalary;
	private double bonus;
	@OneToOne
	@MapsId
	@JoinColumn(name="emp_id", unique=true)
	@JsonIgnore
	private Employee employee;
	
	public EmployeeSalary()
	{
		
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public long getEmpid() {
		return empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}
	
	
	
	

}
