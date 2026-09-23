package com.sampark.employeeManagement.service;

import com.sampark.employeeManagement.dto.DashBoardResponse;
//import com.sampark.employeeManagement.dto.TopSalaryResponse;
//import com.sampark.employeeManagement.entity.Employee;
import com.sampark.employeeManagement.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

//import java.util.List;

@Service
public class DashboardService {

    private final EmployeeRepository employeeRepo;

    public DashboardService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public DashBoardResponse getDashboard() {

       // List<Employee> activeEmployees =employeeRepo.getActiveEmployees();

        //List<Employee> inactiveEmployees =employeeRepo.getInactiveEmployees();
        
       // List<TopSalaryResponse> topSalary =employeeRepo.getTop10SalaryEmployees();

    	long activeEmployees=employeeRepo.getActiveEmployees();   // we can take data from database and put in 
    	long inactiveEmployees=employeeRepo.getInActiveEmployees();
        DashBoardResponse response =new DashBoardResponse(activeEmployees,inactiveEmployees);

//        response.setActiveEmployees(activeEmployees);
//        response.setInactiveEmployees(inactiveEmployees);
     //   response.setTopSalary(topSalary);

        return response;
    }
}
