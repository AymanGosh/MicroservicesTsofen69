package com.tsfn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsfn.beans.Department;
import com.tsfn.beans.Employee;
import com.tsfn.beans.Gender;
import com.tsfn.beans.Task;
import com.tsfn.controller.response.ErrorResponse;
import com.tsfn.controller.response.SuccessResponse;
import com.tsfn.services.EmployeeService;
import com.tsfn.services.exceptions.EmployeeNotFoundException;
import com.tsfn.services.exceptions.EmployeeValidationException;
import com.tsfn.services.exceptions.GetEmployeesException;
import com.tsfn.services.exceptions.TaskCreationException;

@RestController
@RequestMapping("/employees")
public class EmlpoyeeController {

	@Autowired
	private EmployeeService employeeService;

	/*
	 * 1
	 * 
	 * @PostMapping("/add") public Employee addEmployee(@RequestBody Employee
	 * employee) { return employeeService.saveEmployee(employee); }
	 */

	/*
	 * 2
	 * 
	 * @PostMapping("/add") public ResponseEntity<Employee> addEmployee(@RequestBody
	 * Employee employee) { Employee savedEmployee =
	 * employeeService.saveEmployee(employee); return new
	 * ResponseEntity<>(savedEmployee, HttpStatus.CREATED); }
	 */

	/*
	 * 2
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<Employee>
	 * getEmployeeById(@PathVariable int id) { Optional<Employee> employee =
	 * employeeService.getEmployeeById(id); return employee.map(value -> new
	 * ResponseEntity<>(value, HttpStatus.OK)) .orElseGet(() -> new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND)); }
	 */

	/*
	 * 2
	 * 
	 * @GetMapping("/all") public ResponseEntity<List<Employee>> getAllEmployees() {
	 * List<Employee> employees = employeeService.getAllEmployees(); return new
	 * ResponseEntity<>(employees, HttpStatus.OK); }
	 */

	@PostMapping("/create")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
		try {
			Employee savedEmployee = employeeService.saveEmployee(employee);
			return new ResponseEntity<SuccessResponse>(new SuccessResponse("Employee "+savedEmployee.getName()+ "  is created Successfully in the system"), HttpStatus.OK);
		} catch (EmployeeValidationException e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
		try {
			return ResponseEntity.of(employeeService.getEmployeeById(id));
		} catch (EmployeeNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllEmployees() {
		try {
			return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
		} catch (GetEmployeesException e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		try {
			employeeService.updateEmployee(employee);
			return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
		} catch (EmployeeValidationException e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		try {
			employeeService.deleteEmployee(id);
			return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<?> getEmployeesByName(@PathVariable String name) {
		try {
			return new ResponseEntity<>(employeeService.getEmployeesByName(name), HttpStatus.OK);
		} catch (EmployeeValidationException | EmployeeNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/salary/between/{from}/{to}")
	public ResponseEntity<?> getEmployeesBySalaryBetween(@PathVariable double from, @PathVariable double to) {
		try {
			return new ResponseEntity<>(employeeService.getEmployeesBySalaryBetween(from, to), HttpStatus.OK);
		} catch (EmployeeValidationException | EmployeeNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/salary/greaterThan/{salary}")
	public ResponseEntity<?> getEmployeesBySalaryGreaterThan(@PathVariable double salary) {
		try {
			return new ResponseEntity<>(employeeService.getEmployeesBySalaryGreaterThan(salary), HttpStatus.OK);
		} catch (EmployeeValidationException | EmployeeNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/gender/not/{gender}")
	public ResponseEntity<?> getEmployeesByGenderNot(@PathVariable Gender gender) {
		try {
			return new ResponseEntity<>(employeeService.getEmployeesByGenderNot(gender), HttpStatus.OK);
		} catch (EmployeeValidationException | EmployeeNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * @GetMapping("/task/{taskId}") public ResponseEntity<?>
	 * getEmployeesByTaskId(@PathVariable int taskId) { try { Task task = new
	 * Task(); task.setId(taskId); return new
	 * ResponseEntity<>(employeeService.getEmployeesByTaskId(task), HttpStatus.OK);
	 * } catch (EmployeeValidationException | EmployeeNotFoundException e) { return
	 * new ResponseEntity<>(new ErrorResponse(e.getMessage()),
	 * HttpStatus.NOT_FOUND); } }
	 */

	@PostMapping("/task")
	public ResponseEntity<?> getEmployeesByTask(@RequestBody Task task) {
		try {
			if (task == null || task.getId() == 0) {
				throw new EmployeeValidationException("Task ID is required");
			}
			return new ResponseEntity<>(employeeService.getEmployeesByTaskId(task), HttpStatus.OK);
		} catch (EmployeeValidationException | EmployeeNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/firstByName/{name}")
	public ResponseEntity<?> getFirstEmployeeWithName(@PathVariable String name) {
		return ResponseEntity.of(employeeService.getFirstEmployeeWithName(name));
	}
	
	@PostMapping("/createtask/{id}")
    public ResponseEntity<?> createTaskForEmployee(@RequestBody Task task ,@PathVariable int id) {
        try {
            employeeService.createTaskForEmployee(task, id);
            return ResponseEntity.ok("Task created for employee successfully");
        } catch (EmployeeValidationException | TaskCreationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	@PostMapping("/task/{taskId}/assign/employee/{employeeId}")
	public ResponseEntity<?> assignTaskToEmployee(@PathVariable int taskId, @PathVariable int employeeId) {
		employeeService.assignTaskToEmployee(taskId, employeeId);
		return new ResponseEntity<>("Task assigned to employee successfully", HttpStatus.OK);
	}

}
