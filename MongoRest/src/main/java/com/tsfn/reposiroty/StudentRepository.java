package com.tsfn.reposiroty;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.tsfn.model.Student;
import java.util.List;



public interface StudentRepository extends MongoRepository<Student, String> {
	 List<Student> findByEmail(String email);
	 List<Student> findByFirstNameContaining(String firstName);
}
