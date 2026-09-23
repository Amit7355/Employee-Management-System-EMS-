package com.sampark.employeeManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sampark.employeeManagement.dto.EmployeeRequest;
import com.sampark.employeeManagement.dto.EmployeeResponseDto;
import com.sampark.employeeManagement.dto.LoginRequest;
import com.sampark.employeeManagement.dto.LoginResponse;
import com.sampark.employeeManagement.dto.TopSalaryResponse;
import com.sampark.employeeManagement.entity.Employee;
import com.sampark.employeeManagement.entity.EmployeeDetails;
import com.sampark.employeeManagement.entity.EmployeeSalary;
import com.sampark.employeeManagement.repository.EmployeeDetailsRepository;
import com.sampark.employeeManagement.repository.EmployeeRepository;
import com.sampark.employeeManagement.repository.EmployeeSalaryRepository;

import jakarta.transaction.Transactional;

@Service 
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final EmployeeDetailsRepository employeeDetailsRepo;
    private final EmployeeSalaryRepository employeeSalaryRepo;

    public EmployeeService(EmployeeRepository employeeRepo,EmployeeDetailsRepository employeeDetailsRepo,EmployeeSalaryRepository employeeSalaryRepo) {
        this.employeeRepo = employeeRepo;
		this.employeeDetailsRepo = employeeDetailsRepo;
		this.employeeSalaryRepo =employeeSalaryRepo;
    }

    @Transactional
    public LoginResponse login(LoginRequest request) {

    	
            // Check email OR phone
    	
            if ((request.getEmail() == null ||
                 request.getEmail().isBlank())
                &&
                (request.getPhoneno() == null ||
                 request.getPhoneno().isBlank())) 
            {

                throw new IllegalArgumentException(
                        "Please enter email or phone");
            } 
    	   
            

            // Check password
            if (request.getPassword() == null ||
                request.getPassword().isBlank()) {

                throw new IllegalArgumentException(
                        "Password cannot be empty");
            }

            // Phone validation
            if (request.getPhoneno() != null &&
                !request.getPhoneno().isBlank()) {

                if (!request.getPhoneno().matches("[6-9][0-9]{9}")) {

                    throw new IllegalArgumentException(
                            "Phone must contain exactly 10 digits");
                }
            }
            
            // Email validation
            if (request.getEmail() != null &&
                !request.getEmail().isBlank()) {

                if (!request.getEmail().contains("@")) {

                    throw new IllegalArgumentException(
                            "Email must contain @");
                }
            }
            // Login
            Employee employee = employeeRepo.login(
                    request.getEmail(),
                    request.getPhoneno(),
                    request.getPassword()
            );

            if (employee == null) {

                throw new IllegalArgumentException(
                        "Invalid email/phone or password");
            }
            

            return new LoginResponse(
                    employee.getEmpid(),
                    employee.getEname(),
                    "Login successful"
            );
    	

        
    }

//    @Transactional
//	public String updateEmployee(long empid, EmployeeRequest employeeReqst) {
//		
//		//Employee employee=employeeRepo.getEmployeeById(empid);
//		if(employee==null)
//		{
//			return "no record";
//		}
//		// Student updated
//		employeeRepo.updateEmployee(empid,employeeReqst.getEname(),employeeReqst.getDepartment(),employeeReqst.getStatus(),employeeReqst.getEmail(),employeeReqst.getPassword(),employeeReqst.getPhoneno());
//		
//		//StudentDetails Updated
//		employeeDetailsRepo.updateEmployeeDetails(empid,employeeReqst.getAddress(),employeeReqst.getPan(),employeeReqst.getGender());
//		
//		//Student Salary updated
//		employeeSalaryRepo.updateEmployeeSalary(empid,employeeReqst.getBasicSalary(),employeeReqst.getBonus());
//		
//		
//		return "Successfully updated";
//	}
    
    @Transactional
    public String updateEmployee(long empid, EmployeeRequest employeeReqst) 
    {
    	
    	Employee employee=employeeRepo.findById(empid)
    			.orElseThrow(()->new RuntimeException("Employee not found"));
    	
    	employee.setEname(employeeReqst.getEname());
    	employee.setDepartment(employeeReqst.getDepartment());
    	employee.setStatus(employeeReqst.getStatus());
    	employee.setEmail(employeeReqst.getEmail());
    	employee.setPassword(employeeReqst.getPassword());
    	employee.setPhoneno(employeeReqst.getPhoneno());
    	
    	employeeRepo.save(employee);
    
    	EmployeeDetails details = employeeDetailsRepo.findById(empid)
    	        .orElseThrow(() -> new RuntimeException("Employee details not found"));

    	details.setAddress(employeeReqst.getAddress());
    	details.setPan(employeeReqst.getPan());
    	details.setGender(employeeReqst.getGender());
    	employeeDetailsRepo.save(details);
    	
    	EmployeeSalary salary=employeeSalaryRepo.findById(empid)
    			.orElseThrow(()->new RuntimeException("Employee salary not found"));
    	salary.setSalary(employeeReqst.getSalary());
    	salary.setBasicSalary(employeeReqst.getBasicSalary());
    	salary.setBonus(employeeReqst.getBonus());
    	
    	employeeSalaryRepo.save(salary);
    	
    	return "Successfully updated";
    }
    

//    @Transactional
//	public String deleteEmployee(long empid) {
//		Employee employee=employeeRepo.getEmployeeById(empid);
//    	//Employee employee=employeeRepo.getEmployeeDetailsByI(empid);
//		EmployeeDetails employeeDetails=employeeDetailsRepo.getEmployeeDetailsById(empid);
//		EmployeeSalary employeeSalary=employeeSalaryRepo.getEmployeeSalaryById(empid);
//		if(employee==null)
//		{
//			return "record not found";
//		}
//		if(employeeDetails==null)
//		{
//			return "rocord employeeDetails Not found";
//		}
//		if(employeeSalary==null)
//		{
//			return "employeeSalary Record Not Found";
//		}
//		long empid1 =employeeDetails.getEmployee().getEmpid();
//		long empid2=employeeSalary.getEmployee().getEmpid();
//		employeeDetailsRepo.deleteEmployeeDetails(empid1);
//		employeeSalaryRepo.deleteEmployeeSalary(empid2);
//		employeeRepo.deleteEmployee(empid);
//		return "employee deleted sucessfully";
//	}
    
    // use Spring data Jpa
    @Transactional
    public String deleteEmployee(long empid)
    {
    	Employee employee=employeeRepo.findById(empid).orElseThrow(()->new RuntimeException("Employee not found"));
    	
    	EmployeeDetails employeeDetails=employeeDetailsRepo.findById(empid).orElseThrow(()->new RuntimeException("Employee Details not found"));
    	
    	EmployeeSalary employeeSalary=employeeSalaryRepo.findById(empid).orElseThrow(()->new RuntimeException("Employee Salary not found"));
    	
    	employeeSalaryRepo.deleteById(empid);
    	employeeDetailsRepo.deleteById(empid);
    	employeeRepo.deleteById(empid);
    	
    	return "employee Deleted";
    }

    // using spring data jpa method
    @Transactional
    public ResponseEntity saveEmployee(List<EmployeeRequest> request1) {

    	Employee savedEmployee=null;
    	for(EmployeeRequest request:request1)
    	{
    		// check email validation 
            if((request.getEmail()==null ||request.getEmail().isBlank() ) || !request.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            {
            	throw new IllegalArgumentException("email cannot be empty or blank and must contain @");
            }
            // email  check duplicate or not
    		if (employeeRepo.existsByEmail(request.getEmail())) {
    		    throw new IllegalArgumentException("Email cannot be duplicate");
    		}
            
            // check phone validation
            if(( request.getPhoneno()==null) || request.getPhoneno().isBlank() || !request.getPhoneno().matches("[6-9][0-9]{9}"))
            {
            	throw new IllegalArgumentException("phone cannot be empty or blank and must contain 10 digit");
            }
            // check phone duplicate or not
    		if(employeeRepo.existsByPhoneno(request.getPhoneno()))
    		{
    			throw new IllegalArgumentException("Phoneno cannot be duplicate");
    		}
    		
    		
        // 1. Create Employee
    
        Employee employee = new Employee();
        employee.setEname(request.getEname());
        employee.setDepartment(request.getDepartment());
        employee.setStatus(request.getStatus());
        employee.setEmail(request.getEmail());
        employee.setPassword(request.getPassword());
        employee.setPhoneno(request.getPhoneno());

        
        // 2. Save Employee
         savedEmployee = employeeRepo.save(employee);
         
         

        // 3. Create EmployeeDetails
        EmployeeDetails details = new EmployeeDetails();

        details.setEmployee(savedEmployee); // employee  as variable in details and saved employee auto insert id.
        
        details.setAddress(request.getAddress());
        details.setPan(request.getPan());
        details.setGender(request.getGender());
        savedEmployee.setEmployeeDetails(details);

        employeeDetailsRepo.save(details);

        // 4. Create EmployeeSalary
        EmployeeSalary salary = new EmployeeSalary();

        salary.setEmployee(savedEmployee);
        salary.setSalary(request.getSalary());
        salary.setBasicSalary(request.getBasicSalary());
        salary.setBonus(request.getBonus());

        savedEmployee.setEmpSalary(salary);
        employeeSalaryRepo.save(salary);
    	}

        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body("SucessFully Inserted data in db and EmpId: "+savedEmployee.getEmpid());
    }

	public List<TopSalaryResponse> getTopSalarytop10salary() {

		return employeeRepo.getTop10SalaryEmployees() ;
	}

	public List<Employee> getAllEmployee() {
		
		return employeeRepo.getAllEmployee();
	}

	public List<EmployeeResponseDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeResponseDto>li =employeeRepo.getAllEmployees();
		if(li==null)
		{
			System.out.print("empty list");
		}
		
		return li;
	}

	public EmployeeResponseDto getEmployeeById(long empid) {
		//Employee employee=employeeRepo.findById(empid).orElseThrow(()->new ResourceNotFoundException("Employee Record not Found based on this id:"));
		
		Employee employee = employeeRepo.findById(empid)
		        .orElseThrow(() ->
		            new ResourceNotFoundException(
		                "Employee record not found with ID: " + empid
		            )
		        );
		
		 EmployeeResponseDto response = new EmployeeResponseDto(
		            employee.getEmpid(),
		            employee.getEname(),
		            employee.getEmail(),
		            employee.getDepartment(),
		            employee.getPhoneno(),
		            employee.getStatus(),
		            employee.getEmployeeDetails().getAddress(),
		            employee.getEmployeeDetails().getPan(),
		            employee.getEmployeeDetails().getGender(),
		            employee.getEmpSalary().getSalary()
		    );

		return response;
	}

	public EmployeeResponseDto getEmployeeByIds(long empid) {
		
		
		return employeeRepo.getEmployeeByIds(empid);
	}

	
}
    
 

	
