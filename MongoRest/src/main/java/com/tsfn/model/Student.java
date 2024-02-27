package com.tsfn.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@Document(collection = "students")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	private String id ;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private Gender gender;
	@Indexed(unique = true)
	@NonNull
	private String email; 
	@NonNull
	private Address address; 
	@NonNull
	private List<String> books;
	
}
