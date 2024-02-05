package com.tsfn.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.tsfn.beans.Department;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DepartmentDAO  {

	@PersistenceContext
	private EntityManager entityManager;

	public void saveDepartment(Department Department) {
		entityManager.persist(Department);
	}

	public Optional<Department> getDepartmentById(int id) {
		return Optional.ofNullable(entityManager.find(Department.class, id));
	}

	public List<Department> getAllDepartments() {
		return entityManager.createQuery("SELECT d FROM Department d", Department.class).getResultList();
	}

	public void updateDepartment(Department department) {
		entityManager.merge(department);
	}

	public void deleteDepartment(int id) {
		getDepartmentById(id).ifPresent(department -> entityManager.remove(department));
	}

}
