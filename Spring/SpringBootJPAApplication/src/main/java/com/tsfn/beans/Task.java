package com.tsfn.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {

	@Id    //pk
	@GeneratedValue(strategy = GenerationType.IDENTITY ) 
	@Column(name = "task_id")
	private int id ;
	
	
	@Column(name = "task_name")
	private String name;
	
	@Column(name="task_empls")
	@ManyToMany( fetch =FetchType.EAGER )
	private List<Employee> employees ;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)  // FK
	@JoinColumn(name="id")
	private Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	
}
