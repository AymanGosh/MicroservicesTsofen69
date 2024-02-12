package com.tsfn.beans;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "departments")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI - server response on the index value of th id column 
	@Column(name="dept_id")
	private int depart_id ;
	
	@Column(name="dept_name")
	private String name; 
	
	@JsonManagedReference
	@OneToMany(mappedBy = "department" ,fetch = FetchType.EAGER )
	private List<Task> tasks;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "depart" ,fetch = FetchType.EAGER )
	private List<Employee> employees;

	public int getId() {
		return depart_id;
	}

	public void setId(int id) {
		this.depart_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
