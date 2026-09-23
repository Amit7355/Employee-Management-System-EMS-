package com.sampark.employeeManagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampark.employeeManagement.dto.DashBoardResponse;
import com.sampark.employeeManagement.dto.EmployeeRequest;
import com.sampark.employeeManagement.dto.EmployeeResponseDto;
import com.sampark.employeeManagement.dto.LoginRequest;
import com.sampark.employeeManagement.dto.LoginResponse;
import com.sampark.employeeManagement.dto.TopSalaryResponse;
import com.sampark.employeeManagement.entity.Employee;
import com.sampark.employeeManagement.service.DashboardService;
import com.sampark.employeeManagement.service.EmployeeService;

@RestController()
@RequestMapping("api/employee")
public class EmployeeController 
{
	private  final EmployeeService  employeeService;
	private final  DashboardService dashBoardService;


	public EmployeeController(EmployeeService employeeService,DashboardService dashBoardService) {
		this.employeeService = employeeService;
		this.dashBoardService = dashBoardService;
	}
	
	
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest)
	{
		return employeeService.login(loginRequest);
		
	}
	
	@GetMapping("/DashBoard")
	public DashBoardResponse getDashBoard()
	{
		return dashBoardService.getDashboard();
	}
	
	// insert ,update,  delete data
	
	@PostMapping("insert")
	public ResponseEntity saveEmployee(@RequestBody List<EmployeeRequest> employee)
	{
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping("update/{empid}")
	public String updateEmployee(@PathVariable long empid, @RequestBody EmployeeRequest employeeReq )
	{
		return employeeService.updateEmployee(empid,employeeReq);
	}
	
	@DeleteMapping("delete/{empid}")
	public String deleteEmployee(@PathVariable long empid)
	{
		return employeeService.deleteEmployee(empid);
	}

	@GetMapping("top10salary")
	public List<TopSalaryResponse> getTopSalarytop10salary()
	{
		return employeeService.getTopSalarytop10salary();
	}
	
	@GetMapping("fetchAll")
	public List<Employee> getAllEmployee()
	{
		
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("all")
	public List<EmployeeResponseDto> getAllEmployees()
	{
		
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{empid}") // predefined method we used here 
	public EmployeeResponseDto getEmployeeById(@PathVariable long empid)
	{
		return  employeeService.getEmployeeById(empid);
	}
	
	@GetMapping("fetchByid/{empid}")
	public EmployeeResponseDto getEmployeeByIds(@PathVariable long empid)
	{
		return employeeService.getEmployeeByIds(empid);
	}
	
	
}
