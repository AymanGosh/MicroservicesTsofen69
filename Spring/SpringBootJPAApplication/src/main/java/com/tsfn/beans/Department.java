package com.tsfn.beans;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="deparment")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )  
	private int dept_id;
	
	private String dept_name;
	
	@OneToMany(mappedBy = "depart"   ,fetch= FetchType.EAGER ,cascade= CascadeType.ALL)
	private Set<Employee> dept_employees; 
	

	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Task> dept_tasks;
	
	
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public Set<Employee> getDept_employees() {
		return dept_employees;
	}
	public void setDept_employees(Set<Employee> dept_employees) {
		this.dept_employees = dept_employees;
	}
	public List<Task> getDept_tasks() {
		return dept_tasks;
	}
	public void setDept_tasks(List<Task> dept_tasks) {
		this.dept_tasks = dept_tasks;
	}

	
	
	
}
