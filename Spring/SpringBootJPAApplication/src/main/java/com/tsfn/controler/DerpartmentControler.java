package com.tsfn.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsfn.beans.Department;
import com.tsfn.services.DepartmetService;

import jakarta.websocket.server.PathParam;

//http://www.glassloader/departmetns/addDepratment
//http://www.glassloader/departmetns/UpdateDepartment
//http://localhost:8080/departmetns/getall
@RestController
//@RequestMapping(value="/departments")
public class DerpartmentControler {
	@Autowired
	DepartmetService departmentService ;
	
	//@RequestMapping(value="/departments/getall" , method = RequestMethod.GET)
	@GetMapping(value="/departments/getall")
	public List<Department> getAllDepartments()
	{
		return departmentService.getAllDepartments();
	}
	//http://www.localhost:8080/departmetns/department/1   pathVariable
	//http://www.localhost:8080/departmetns/department?id=1&name="R&D"   queryParam
	@GetMapping(value= "/departments/department")
	public Optional<Department> getDepartmentByIdByQueryPatram(@RequestParam("id") int id)
	{
		return departmentService.getDepartment(id);
	}
	
	@GetMapping(value= "/departments/department/{id}")
	public Optional<Department> getDepartmentByIdByPathVar(@PathVariable int id)
	{
		return departmentService.getDepartment(id);
	}
	
	
	@PostMapping(value="/departments/add" ,consumes ="application/json")
	public void createDepartment(@RequestBody Department department )
	{
		departmentService.createDepartment(department);
	}

}
