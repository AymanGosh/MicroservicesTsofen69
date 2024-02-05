package com.tsfn.beans;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name= "employees")
public class Employee {
	
	@Column(name="empl_id")
	@Id   // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AI Upda
	private int id ;

	@Column(name="empl_name")
	private String name ;
	
	@Column(name="empl_salay")
	private double salary ;
	
	@Enumerated(EnumType.ORDINAL)  //Ordinal = Integer , String =string
	private Gender gender ;
	
    @ManyToOne
    @JoinColumn(name = "dept_id" ,nullable = false)  //FK (jsut for 1:1 or M:1)
	public Department depart;
	
	@ManyToMany(cascade= CascadeType.ALL , fetch = FetchType.EAGER)
	private List<Task> tasks;
	
	
	
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Department getDepartment() {
		return depart;
	}
	public void setDepartment(Department department) {
		this.depart = department;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	//JPA - Java Persistence API -Spring Data JPA (implementation ORM )
	//ORM - Object Relational Mapping 
	
	
	
	
	
	
	
	
	
}
