package com.sampark.employeeManagement.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeResponseDto
{
    private long empid;
    private String ename;
    private String email;
    private String department;
    private String phoneno;
    private boolean status;
    private String address;
    private String pan;
    private String gender;
    private double salary;

    public EmployeeResponseDto(long empid, String ename, String email, String department, String phoneno, boolean status, String address, String pan, String gender, double salary) {
        this.empid = empid;
        this.ename = ename;
        this.email = email;
        this.department = department;
        this.phoneno = phoneno;
        this.status = status;
        this.address = address;
        this.pan = pan;
        this.gender = gender;
        this.salary = salary;
        
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

	
    
}
