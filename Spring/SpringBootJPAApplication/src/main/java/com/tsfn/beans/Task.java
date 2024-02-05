package com.tsfn.beans;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private int id;
	
	@Column(name = "task_name")
	private String name;
	
	@Column(name = "task_employees")
	@ManyToMany(cascade=  CascadeType.ALL )
	private List<Employee> employees;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id") 
	private Department department;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", employees=" + employees + ", department=" + department + "]";
	}	
}
