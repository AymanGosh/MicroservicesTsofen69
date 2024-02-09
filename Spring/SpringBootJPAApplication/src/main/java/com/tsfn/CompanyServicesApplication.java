package com.tsfn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tsfn.beans.Department;
import com.tsfn.beans.Employee;
import com.tsfn.beans.Gender;
import com.tsfn.beans.Task;
import com.tsfn.services.DepartmetService;
import com.tsfn.services.EmployeeService;
import com.tsfn.services.TaskService;

@SpringBootApplication
public class CompanyServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyServicesApplication.class, args);
		
	}

}
