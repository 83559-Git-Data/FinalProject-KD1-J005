package com.schedulemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.StudentRegistrationDTO;
import com.schedulemaster.services.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/student")
public class StudentController {

	public StudentController() {
		
	}
	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/profile/{id}")
	public ResponseEntity<?> registerStudentProfile(@RequestBody StudentRegistrationDTO dto ,@PathVariable long id){
		System.out.println("register");
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(studentservice.register(dto,id));
			
		} catch (RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponse("Something went Wrong!!"));
		}
	}
	
}
