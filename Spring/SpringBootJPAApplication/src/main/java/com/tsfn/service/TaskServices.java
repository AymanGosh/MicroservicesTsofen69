package com.tsfn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsfn.beans.Employee;
import com.tsfn.beans.Task;
import com.tsfn.repository.TaskDAO;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {

    @Autowired
    private TaskDAO taskDao;

    public void saveTask(Task task) {
    	taskDao.saveTask(task);
    }

    public Optional<Task> getTaskById(int id) {
        return taskDao.getTaskById(id);
    }

    public Iterable<Task> getTasks() {
        return taskDao.getAllTasks();
    }

    public void updateTask(Task task) {
    	taskDao.saveTask(task);
    }

    public void deleteTask(int id) {
    	taskDao.deleteTask(id);
    }

    public List<Task> getTaskByEmployee(Employee employee) {
    	
        return taskDao.getTaskByEmployeeName(employee);
    }
}

