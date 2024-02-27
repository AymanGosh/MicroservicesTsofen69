package com.tsfn;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tsfn.model.Address;
import com.tsfn.model.Gender;
import com.tsfn.model.Student;
import com.tsfn.reposiroty.StudentRepository;
@SpringBootApplication
public class MongoRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoRestApplication.class, args);

	}/*
		 * CommandLineRunner runner(StudentRepository repository) { return args ->{
		 * 
		 * Address address = new Address(); address.setCountry("ISRAEL");
		 * address.setCity("Haifa"); address.setPostalCode("8357400"); Student student =
		 * new Student("John", "Daglus", Gender.M ,"John.d@gmail.com", address,
		 * List.of("ComputerScience"));
		 * 
		 * repository.save(student); }; }
		 */
}
