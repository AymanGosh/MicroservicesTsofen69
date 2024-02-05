package com.tsfn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsfn.beans.Department;
import com.tsfn.repository.DepartmentDAO;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServices {
    
	@Autowired
    private DepartmentDAO DepartmentDAO ;


    public List<Department> getAllDepartments() {
        return DepartmentDAO.getAllDepartments();
    }

    public Optional<Department> getDepartmentById(int id) {
        return DepartmentDAO.getDepartmentById(id);
    }

    public void saveDepartment(Department Department) {
        DepartmentDAO.saveDepartment(Department);
    }

    public void updateDepartment(Department Department) {
        DepartmentDAO.updateDepartment(Department);
    }

    public void deleteDepartment(int id) {
        DepartmentDAO.deleteDepartment(id);
    }
}
