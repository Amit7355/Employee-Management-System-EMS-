package com.sampark.employeeManagement.repository;

import java.util.List;

import com.sampark.employeeManagement.dto.EmployeeResponseDto;
import com.sampark.employeeManagement.dto.TopSalaryResponse;
import com.sampark.employeeManagement.entity.Employee;


import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    // =========================
    // LOGIN
    // =========================

 //   @Query(value = """
//        SELECT *
//        FROM employee
//        WHERE
//            ((:email IS NOT NULL AND email = :email) OR
//            (:phoneno IS NOT NULL AND phoneno = :phoneno))
//        AND password = :password
//        AND status = true
//        """,
//        nativeQuery = true)
//        Employee login(
//            @Param("email") String email,
//            @Param("phoneno") String phoneno,
//            @Param("password") String password
//    );

	@Query(value="""
			SELECT * FROM employee WHERE email=:email OR phoneno=:phoneno AND
			password=:password AND status=true
			""",nativeQuery=true)
	Employee login(
          @Param("email") String email,
          @Param("phoneno") String phoneno,
          @Param("password") String password);
	

    // =========================
    // ACTIVE EMPLOYEES
    // =========================

    @Query(value = """
        SELECT count(*)
        FROM employee
        WHERE status = true
        """,
        nativeQuery = true)
    long getActiveEmployees();
    //List<Employee> getActiveEmployees();


    // =========================
    // INACTIVE EMPLOYEES
    // =========================

    @Query(value = """
        SELECT count(*)
        FROM employee
        WHERE status = false
        """,
        nativeQuery = true)
    long getInActiveEmployees();
    //List<Employee> getInactiveEmployees();


    // =========================
    // TOP 10 HIGHEST SALARY
    // =========================

    @Query(value = """
        SELECT
            e.emp_id AS employeeId,
            e.ename AS ename,
            e.email AS email,
            s.basic_salary AS basicSalary,
            s.bonus AS bonus
        FROM employee e
        INNER JOIN employee_salary s
            ON e.emp_id = s.emp_id
        ORDER BY s.basic_salary DESC
        LIMIT 10
        """,
        nativeQuery = true)
    List<TopSalaryResponse> getTop10SalaryEmployees();


    @Modifying
    @Query(value="""
    		Insert INTO employee(ename,department,status,email,password,phoneno) values(:ename,:department,:status,:email,:password,:phoneno)
    		""",nativeQuery=true)
	int saveEmployee(@Param("ename") String ename,
			          @Param("department") String department,
			          @Param("status") boolean status,
			          @Param("email") String email,
			          @Param("password") String password,
			          @Param("phoneno")String phoneno);


	


    // LAst employee it is used when we auto generated 
    @Query(value=
	"SELECT  LAST_INSERT_ID()",
	nativeQuery=true)
    long insertLastEmpId();


   
    @Query(value=
    		"SELECT * FROM employee WHERE emp_id=:empid",
    		nativeQuery=true)
	Employee getEmployeeById(@Param("empid")long empid);


	@Modifying
	 @Query(value="""
	 		UPDATE employee SET ename=:ename, department=:department, status=:status, email=:email, password=:password, phoneno=:phoneno WHERE emp_id=:empid""",
	    		nativeQuery=true)
	int updateEmployee(@Param("empid")long empid, 
			           @Param("ename")String ename,
			           @Param("department")String department,
			           @Param("status")boolean status, 
			           @Param("email")String email, 
			           @Param("password")String password,
			           @Param("phoneno")String phoneno);


	@Modifying
	@Query(value=
	"DELETE FROM employee WHERE emp_id=:empid",
	nativeQuery=true)
	int deleteEmployee(@Param("empid")long empid);


	boolean existsByEmail(String email);




	boolean existsByPhoneno(String phoneno);


	@Query(value="SELECT * FROM employee",nativeQuery=true)
	List<Employee> getAllEmployee();


	@Query(value="""
			SELECT e.emp_id,e.ename,e.email,e.department,e.phoneno,e.status,d.address,d.pan,d.gender,s.salary FROM employee e
		    INNER JOIN employee_details d
		    ON e.emp_id=d.emp_id
            INNER JOIN employee_salary s
            ON e.emp_id = s.emp_id
           """,nativeQuery=true)	
	List<EmployeeResponseDto> getAllEmployees();


	@Query(value="""
			SELECT e.emp_id,e.ename,e.email,e.department,e.phoneno,e.status,d.address,d.pan,d.gender,s.salary 
			FROM employee e
		    INNER JOIN employee_details d
		    ON e.emp_id=d.emp_id
            INNER JOIN employee_salary s
            ON e.emp_id = s.emp_id WHERE e.emp_id=:empid
           """,nativeQuery=true)
	EmployeeResponseDto getEmployeeByIds(@Param("empid")long empid);

	



	


//	@Query(value=
//			"Select count(*)>0 from employee WHERE phoneno=:phoneno",nativeQuery=true)
//	int getUniquePhone(@Param("phoneno")String phoneno);
}
	


