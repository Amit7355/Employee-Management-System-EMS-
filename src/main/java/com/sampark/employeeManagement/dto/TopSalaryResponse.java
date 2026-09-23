package com.sampark.employeeManagement.dto;

public class TopSalaryResponse {

    private long employeeId;
    private String name;
    private String email;
    private Double basicSalary;
    private Double bonus;

    public TopSalaryResponse() {
    }

    public TopSalaryResponse(long employeeId,
                             String name,
                             String email,
                             Double basicSalary,
                             Double bonus) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
}