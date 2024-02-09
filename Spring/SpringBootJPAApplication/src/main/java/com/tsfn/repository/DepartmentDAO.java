package com.tsfn.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
// Bassic JPA example 

import com.tsfn.beans.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class DepartmentDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void saveDepartment(Department department)
	{
		entityManager.persist(department);
	}
	
	public Optional<Department> getDepartmentById(int id)
	{
		return Optional.ofNullable(entityManager.find(Department.class,id));
	}
	
	public void updateDepartment(Department department) {
		entityManager.merge(department);
	}

	public void deleteDepartment(int id) {
		getDepartmentById(id).ifPresent(department -> entityManager.remove(department));
	}
	
	public List<Department> getAllDepartments(){
		return entityManager.createQuery("SELECT d FROM Department d" ,Department.class).getResultList();              //HQL Hibernate Query Language 
	}
}
