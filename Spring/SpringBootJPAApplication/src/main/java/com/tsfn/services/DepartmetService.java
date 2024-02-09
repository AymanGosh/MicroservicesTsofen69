package com.tsfn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsfn.beans.Department;
import com.tsfn.repository.DepartmentDAO;

@Service
public class DepartmetService {

	@Autowired
	DepartmentDAO departmentDao ;
	
	
	public void createDepartment (Department department)
	{
		departmentDao.saveDepartment(department);
	}
	
	  public List<Department> getAllDepartments() {
	        return departmentDao.getAllDepartments();
	    }

	  public void updateDepartment(Department Department) {
		  departmentDao.updateDepartment(Department);
	    }

	    public void deleteDepartment(int id) {
	    	departmentDao.deleteDepartment(id);
	    }
	    
	    public Optional<Department> getDepartment(int id) {
	    	return departmentDao.getDepartmentById(id);
	    }
}
