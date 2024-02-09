package com.tsfn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tsfn.beans.Employee;
import com.tsfn.beans.Gender;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> findEmployeesByName(String name);
	
	
	List<Employee> findEmployeesBySalaryGreaterThan(double salary);
	
	List<Employee> findEmployeesByTasks_Id( int taskID);
	
	List<Employee> findEmployeesByGenderNot(Gender gender);
	
	Optional<Employee> findFirstEmployeeByName(String name);
	
	
	@Query("SELECT e FROM com.tsfn.beans.Employee  e WHERE e.salary BETWEEN :from AND :to")
	List<Employee> findEmployeeBetweenSalary(@Param("from") double from, @Param("to") double to);
}
