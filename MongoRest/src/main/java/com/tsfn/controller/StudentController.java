package com.tsfn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsfn.model.Student;
import com.tsfn.reposiroty.StudentRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/getstudents")
	public ResponseEntity<List<Student>> getAllstudents(@RequestParam(required = false) String name) {
		try {
			List<Student> students = new ArrayList<Student>();

			if (name == null)
				studentRepository.findAll().forEach(students::add);
			else
				studentRepository.findByFirstNameContaining(name).forEach(students::add);

			if (students.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Student> getstudentById(@PathVariable("id") String id) {
		java.util.Optional<Student> studentData = studentRepository.findById(id);

		if (studentData.isPresent()) {
			return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<Student> createstudent(@RequestBody Student student) {
		try {
			Student newstudent = studentRepository.save(student);
			return new ResponseEntity<>(newstudent, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updatestudent(@PathVariable("id") String id, @RequestBody Student student) {
		java.util.Optional<Student> studentData = studentRepository.findById(id);

		if (studentData.isPresent()) {
			Student exstStudent = studentData.get();
			exstStudent.setLastName(student.getLastName());
			exstStudent.setAddress(student.getAddress());
			exstStudent.setFirstName(student.getFirstName());

			return new ResponseEntity<>(studentRepository.save(exstStudent), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deletestudent(@PathVariable("id") String id) {
		try {
			studentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deletall")
	public ResponseEntity<HttpStatus> deleteAllstudents() {
		try {
			studentRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getbyemail")
	public ResponseEntity<List<Student>> findByEmail(String email) {
		try {
			List<Student> students = studentRepository.findByEmail(email);

			if (students.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(students, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
