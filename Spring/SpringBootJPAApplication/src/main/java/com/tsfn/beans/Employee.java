package com.tsfn.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	@Enumerated(EnumType.ORDINAL)  // Ordinal - Integer (1,0) , String (M,F)
	private Gender gender ;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name= "depart_id" , nullable = false)
	private Department depart;
	
	@ManyToMany( cascade = CascadeType.ALL )
	private List<Task> tasks;
	
	private String managerName ;

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

	public Department getDepart() {
		return depart;
	}

	public void setDepart(Department depart) {
		this.depart = depart;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}  	

}
