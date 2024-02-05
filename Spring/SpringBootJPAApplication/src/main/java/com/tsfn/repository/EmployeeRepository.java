package com.tsfn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tsfn.beans.Employee;
import com.tsfn.beans.Gender;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT e FROM com.tsfn.beans.Employee e JOIN e.depart d WHERE d.dept_id = :dept_id")
	List<Employee> findEmployeesByDepartment(@Param("dept_id") int dept_id);
	
	List<Employee> findEmployeesByName(String name);
	
	@Query("SELECT e FROM com.tsfn.beans.Employee  e WHERE e.salary BETWEEN :from AND :to")
	List<Employee> findEmployeeBetweenSalary(@Param("from") double from, @Param("to") double to);

	
	List<Employee> findEmployeesBySalaryGreaterThan(double salary);
	
	List<Employee> findEmployeesByGenderNot(Gender gender);
	
	 List<Employee> findEmployeesByTasks_Id(int taskId);
	
	List<Employee> findEmployeesByTasks_NameOrderByNameDesc(String name);
	
	Optional<Employee> findFirstEmployeeByName(String name);
	
	
}
