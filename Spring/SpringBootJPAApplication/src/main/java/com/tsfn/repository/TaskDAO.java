package com.tsfn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsfn.beans.Employee;
import com.tsfn.beans.Task;



@Repository
public class TaskDAO {

	@Autowired
	private TaskRepo taskRepo;
	
	public void saveTask(Task Task) {
		taskRepo.save(Task);
	}
	
	public Optional<Task> getTaskById(int id) {
		return taskRepo.findById(id);
	}
	
	public Iterable<Task> getAllTasks() {
		return taskRepo.findAll();
	}
	
	public void updateTask(Task Task) {
		taskRepo.save(Task);
	}

	public void deleteTask(int id) {
		taskRepo.deleteById(id);
	}
	
	public List<Task> getTaskByEmployeeName (Employee employee)
	{
		return taskRepo.findByEmployeeName(employee.getName());
	}
}
