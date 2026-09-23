package com.sampark.employeeManagement.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import com.sampark.employeeManagement.entity.EmployeeSalary;

public interface EmployeeSalaryRepository
        extends JpaRepository<EmployeeSalary, Long> {

    @Modifying
    @Query(value = """
        INSERT INTO employee_salary
        (employee_id, basic_salary, bonus)
        VALUES (:id, :basicSalary, :bonus)
        """,
        nativeQuery = true)
    int insertSalary(
            @Param("id") Integer id,
            @Param("basicSalary") Double basicSalary,
            @Param("bonus") Double bonus
    );


    @Query(value = """
        SELECT *
        FROM employee_salary
        WHERE emp_id = :empid
        """,
        nativeQuery = true)
    EmployeeSalary getEmployeeSalaryById(@Param("empid") long empid);


    @Modifying
    @Query(value = """
        UPDATE employee_salary
        SET basic_salary = :basicSalary,
            bonus = :bonus,
            salary=:basicSalary+:bonus
        WHERE emp_id = :empid
        """,
        nativeQuery = true)
    int updateEmployeeSalary(
            @Param("empid") long empid,
            @Param("basicSalary") Double basicSalary,
            @Param("bonus") Double bonus
    );


    @Modifying
    @Query(value = """
        DELETE FROM employee_salary
        WHERE employee_id = :id
        """,
        nativeQuery = true)
    int deleteSalary(
            @Param("id") Integer id
    );


    @Modifying
    @Query(value=
    "INSERT INTO employee_salary(emp_id,basic_salary,bonus,salary) VALUES(:empid,:basicSalary,:bonus,:salary)",
    nativeQuery=true)
	int saveEmployeeSalary(@Param("empid")long empid,
			               @Param("basicSalary")double basicSalary,
			               @Param("bonus")double bonus,
			               @Param("salary")double salary);


    @Modifying
    @Query(value=
    "DELETE FROM employee_salary WHERE emp_id=:empid",
    nativeQuery=true)
	int deleteEmployeeSalary(@Param("empid")long empid);


    


}