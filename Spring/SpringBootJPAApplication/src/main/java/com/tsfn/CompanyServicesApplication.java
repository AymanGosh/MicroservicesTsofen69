package com.tsfn;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.tsfn.beans.Department;
import com.tsfn.beans.Employee;
import com.tsfn.beans.Gender;
import com.tsfn.beans.Task;
import com.tsfn.service.DepartmentServices;
import com.tsfn.service.EmployeeServices;
import com.tsfn.service.TaskServices;

@SpringBootApplication
public class CompanyServicesApplication {
	
    public static void main(String[] args) {
       // SpringApplication.run(CompanyServicesApplication.class, args);
    	ConfigurableApplicationContext ctx=SpringApplication.run(CompanyServicesApplication.class, args);
        // Creating instances
        Department department = new Department();
        Employee employee = new Employee();
        Task task = new Task();
        
        DepartmentServices departmentService = ctx.getBean(DepartmentServices.class); 
        TaskServices taskService = ctx.getBean(TaskServices.class); 
        EmployeeServices employeeService = ctx.getBean(EmployeeServices.class); 
        

        department.setDept_name("R@D");
        departmentService.saveDepartment(department);
        employee.setName("John Doe");
        employee.setSalary(50000.0);
        employee.setGender(Gender.M);
        employee.setDepartment(department);

        // Save employee
        employeeService.saveEmployee(employee);

     //   List<Employee> employees = new ArrayList<>();
      //  employees.add(employee);
        task.setName("Coding");
        //task.setEmployees(employees);
	    taskService.saveTask(task);

	        // Example: Get employee by ID
	        Optional<Employee> retrievedEmployee = employeeService.getEmployeeById(employee.getId());
	        retrievedEmployee.ifPresent(emp -> System.out.println("Retrieved Employee: " + emp));

	        // Example: Get all employees
	       // List<Employee> allEmployees = employeeService.getAllEmployees();
	       // System.out.println("All Employees: " + allEmployees);

	        // Example: Update employee
	        employee.setName("Updated John Doe");
	        employeeService.updateEmployee(employee);

	        // Example: Get employees by department
	       // List<Employee> employeesInITDepartment = employeeService.getEmployeesByDepartment(department.getDept_id());
	      //  System.out.println("Employees in IT Department: " + employeesInITDepartment);

	        // Example: Delete employee
	        //employeeService.deleteEmployee(employee.getId());

	        // Example: Get employees by task name ordered by name descending
	      //  List<Employee> employeesByTaskName = employeeService.getEmployeesByTaskNameOrderedByNameDesc(task);
	      //  System.out.println("Employees by Task Name (Ordered by Name Descending): " + employeesByTaskName);

	        // Cleanup: Delete department
	       // departmentService.deleteDepartment(department.getDept_id());
	}

}
