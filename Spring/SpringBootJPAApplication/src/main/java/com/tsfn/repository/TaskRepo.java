package com.tsfn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tsfn.beans.Task;

public interface TaskRepo extends CrudRepository<Task, Integer> {

	@Query("SELECT t FROM Task t JOIN t.employees e WHERE e.name = :empl_name")
	List<Task> findByEmployeeName(@Param("empl_name") String name);

}
