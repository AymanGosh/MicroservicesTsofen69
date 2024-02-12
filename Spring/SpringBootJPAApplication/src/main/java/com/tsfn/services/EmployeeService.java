package com.tsfn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsfn.beans.Department;
import com.tsfn.beans.Employee;
import com.tsfn.beans.Gender;
import com.tsfn.beans.Task;
import com.tsfn.repository.DepartmentDAO;
import com.tsfn.repository.EmployeeRepository;
import com.tsfn.repository.TaskDAO;
import com.tsfn.services.exceptions.DepartmentValidationException;
import com.tsfn.services.exceptions.EmployeeNotFoundException;
import com.tsfn.services.exceptions.EmployeeValidationException;
import com.tsfn.services.exceptions.GetEmployeesException;
import com.tsfn.services.exceptions.TaskCreationException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;
	@Autowired 
	DepartmentDAO departmentDao;
	@Autowired 
	TaskDAO taskDao;

	public Employee saveEmployee(Employee employee) throws EmployeeValidationException {
		if (employee == null)
			throw new EmployeeValidationException("Employee object is null");

		try {
			  // Extract department details from the request
	        Department department = employee.getDepart();
	        
	        // Check if department exists in the database
	        Department fetchedDepartment = getDepartment(department);
	        employee.setDepart(fetchedDepartment);
			return employeeRepo.save(employee);
		}catch (DepartmentValidationException e) {
	        // Catch the DepartmentValidationException and throw it as an EmployeeValidationException
	        throw new EmployeeValidationException(e.getMessage());
	        
		}catch (Exception e) {
			throw new EmployeeValidationException("Error occurred while saving employee");
		}
	}

	private Department getDepartment(Department department) throws DepartmentValidationException {
	    try {
	        Department existingDepartment = departmentDao.findDepartmentByName(department.getName());
	            return existingDepartment;
	    } catch (Exception e) {
	        // Catch any exceptions that occur during the findDepartmentByName method call
	        // and throw a DepartmentValidationException with the appropriate error message
	        throw new DepartmentValidationException("Error while fetching department: " + e.getMessage());
	    }
	}


	public Optional<Employee> getEmployeeById(int id) throws EmployeeNotFoundException {
		// return employeeRepo.findById(id);

		Optional<Employee> employeeOptional = employeeRepo.findById(id);

		if (!employeeOptional.isPresent()) {
			// Employee with the specified ID does not exist
			// You can throw an exception or return an empty Optional
			// Throw custom exception
			throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
			// Or return empty Optional
			// return Optional.empty();
		}

		return employeeOptional;
	}

	public List<Employee> getAllEmployees() throws GetEmployeesException {
		try {
			return (List<Employee>) employeeRepo.findAll();
		} catch (Exception e) {
			throw new GetEmployeesException("Error occurred while retieving the  employees List");
		}
	}

	public void updateEmployee(Employee employee) throws EmployeeValidationException {
	    // Perform validation before updating the employee
	    if (employee == null || employee.getId() == 0) {
	        throw new EmployeeValidationException("Employee Doesnt Exist in the system");
	    }

	    try {
	    	saveEmployee(employee);
		} catch (Exception e) {
			throw new EmployeeValidationException("Error occurred while saving employee");
		}
	    
	    
	}
	

	public void deleteEmployee(int id) throws EmployeeNotFoundException  {
	    // Check if the employee exists before deleting
	    Optional<Employee> optionalEmployee = employeeRepo.findById(id);
	    if (optionalEmployee.isEmpty()) {
	        throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
	    }
	   System.out.println(employeeRepo.count());
	    // If the employee exists, delete it
	    //employeeRepo.deleteById(optionalEmployee.get().getId());
	    employeeRepo.delete(optionalEmployee.get());
	}

	public List<Employee> getEmployeesByName(String name) throws EmployeeValidationException, EmployeeNotFoundException {
	    // Validate the input name
	    if (name == null || name.isEmpty()) {
	        throw new EmployeeValidationException("Name cannot be null or empty");
	    }

	    // Retrieve employees by name from the repository
	    List<Employee> employees = employeeRepo.findEmployeesByName(name);

	    // Check if any employees were found
	    if (employees.isEmpty()) {
	        throw new EmployeeNotFoundException("No employees found with the name: " + name);
	    }

	    return employees;
	}


	public List<Employee> getEmployeesBySalaryBetween(double from, double to) throws EmployeeValidationException, EmployeeNotFoundException {
	    // Validate the salary range
	    if (from < 0 || to < 0 || from > to) {
	        throw new EmployeeValidationException("Invalid salary range");
	    }

	    // Retrieve employees by salary range from the repository
	    List<Employee> employees = employeeRepo.findEmployeeBetweenSalary(from, to);

	    // Check if any employees were found
	    if (employees.isEmpty()) {
	        throw new EmployeeNotFoundException("No employees found with salaries between " + from + " and " + to);
	    }

	    return employees;
	}


	public List<Employee> getEmployeesBySalaryGreaterThan(double salary) throws EmployeeValidationException, EmployeeNotFoundException {
	    // Validate the salary value
	    if (salary < 0) {
	        throw new EmployeeValidationException("Invalid salary value");
	    }

	    // Retrieve employees with salaries greater than the specified value from the repository
	    List<Employee> employees = employeeRepo.findEmployeesBySalaryGreaterThan(salary);

	    // Check if any employees were found
	    if (employees.isEmpty()) {
	        throw new EmployeeNotFoundException("No employees found with salaries greater than " + salary);
	    }

	    return employees;
	}


	public List<Employee> getEmployeesByGenderNot(Gender gender) throws EmployeeValidationException, EmployeeNotFoundException {
	    // Validate the gender value
	    if (gender == null) {
	        throw new EmployeeValidationException("Gender cannot be null");
	    }

	    // Retrieve employees with genders not matching the specified gender from the repository
	    List<Employee> employees = employeeRepo.findEmployeesByGenderNot(gender);

	    // Check if any employees were found
	    if (employees.isEmpty()) {
	        throw new EmployeeNotFoundException("No employees found with gender not equal to " + gender);
	    }

	    return employees;
	}


	public List<Employee> getEmployeesByTaskId(Task task) throws EmployeeValidationException, EmployeeNotFoundException {
	    // Validate the task parameter
	    if (task == null || task.getId() == 0) {
	        throw new EmployeeValidationException("Task cannot be null and must have a valid ID");
	    }

	    // Retrieve employees associated with the specified task ID from the repository
	    List<Employee> employees = employeeRepo.findEmployeesByTasks_Id(task.getId());

	    // Check if any employees were found
	    if (employees.isEmpty()) {
	        throw new EmployeeNotFoundException("No employees found for task with ID: " + task.getId());
	    }

	    return employees;
	}


	public Optional<Employee> getFirstEmployeeWithName(String name) {
		return employeeRepo.findFirstEmployeeByName(name);
	}
	
	public void createTaskForEmployee(Task task, int id) throws EmployeeValidationException, TaskCreationException {
	    // Save the task
	    taskDao.saveTask(task);
	    // Retrieve the updated task from the database
	    Optional<Task> employeeTask = taskDao.getTaskById(task.getId());
	    Optional<Employee> taskEmployee = employeeRepo.findById(id);
	    // Check if the task was successfully saved
	    if (employeeTask.isPresent()) {
	        // Associate the task with the employee
	        List<Task> employeeTasks = taskEmployee.get().getTasks();
	        employeeTasks.add(task); // Add the task to the employee's list of tasks
	        
	        // Save the updated employee with the new task association
	        updateEmployee(taskEmployee.get());
	    } else {
	        // Handle the case where the task was not saved successfully
	        throw new TaskCreationException("Failed to create task for employee: " + taskEmployee.get().getId());
	    }
	}
	
	public void assignTaskToEmployee(int employeeId, int taskId) {
	    // Retrieve the employee and task objects from their repositories
	    Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
	    Optional<Task> taskOptional = taskDao.getTaskById(taskId);
	    
	    // Check if both the employee and task exist
	    if (employeeOptional.isPresent() && taskOptional.isPresent()) {
	        // Get the employee and task objects
	        Employee employee = employeeOptional.get();
	        Task task = taskOptional.get();
	        
	        // Associate the task with the employee
	        List<Task> employeeTasks = employee.getTasks();
	        employeeTasks.add(task);
	        
	        // Save the updated employee object
	        employeeRepo.save(employee);
	    } else {
	        // Handle the case where either the employee or task does not exist
	        throw new EntityNotFoundException("Employee or task not found");
	    }
	}

	
	
}
