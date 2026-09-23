package com.sampark.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sampark.employeeManagement.entity.EmployeeDetails;


import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface EmployeeDetailsRepository
        extends JpaRepository<EmployeeDetails, Long> {

    @Modifying
    @Query(value = """
        INSERT INTO employee_details
        (employee_id, address, pan, gender)
        VALUES (:id, :address, :pan, :gender)
        """,
        nativeQuery = true)
    int insertDetails(
            @Param("id") Integer id,
            @Param("address") String address,
            @Param("pan") String pan,
            @Param("gender") String gender
    );


    @Query(value = """
        SELECT *
        FROM employee_details
        WHERE employee_id = :id
        """,
        nativeQuery = true)
    EmployeeDetails getDetails(
            @Param("id") Integer id
    );


    @Modifying
    @Query(value = """
        UPDATE employee_details
        SET address = :address,
            pan = :pan,
            gender = :gender
        WHERE emp_id = :empid
        """,
        nativeQuery = true)
    int updateEmployeeDetails(
            @Param("empid") long empid,
            @Param("address") String address,
            @Param("pan") String pan,
            @Param("gender") String gender
    );


    @Modifying
    @Query(value=
    		"INSERT INTO employee_details(emp_id,address,pan,gender) VALUES(:empid,:address,:pan,:gender)",
    nativeQuery=true)
	int saveEmployeeDetails(
			                @Param("empid") long empid,
			                @Param("address")String address,
			                @Param("pan")String pan,
			                @Param("gender")String gender);


    @Modifying
    @Query(value=
    "DELETE FROM employee_details WHERE emp_id=:empid",
    nativeQuery=true)
	int deleteEmployeeDetails(@Param("empid")long empid);

    @Query(value=
    		"SELECT * FROM employee_details WHERE emp_id=:empid",nativeQuery=true)
	EmployeeDetails getEmployeeDetailsById(@Param("empid")long empid);
}