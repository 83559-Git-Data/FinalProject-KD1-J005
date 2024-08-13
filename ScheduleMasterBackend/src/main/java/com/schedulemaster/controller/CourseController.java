package com.schedulemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.schedulemaster.dto.AddModule;
import com.schedulemaster.dto.CourseDTO;
import com.schedulemaster.dto.CourseRegistrationDTO;
import com.schedulemaster.services.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/course")

public class CourseController {

	public CourseController() {

	}

	@Autowired
	private CourseService courseService;

	@PostMapping("/register")

	public ResponseEntity<?> registerCourse(@RequestBody CourseRegistrationDTO dto) {

		System.out.println("register");
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(courseService.register(dto));

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}

	@PostMapping("/addmodule/{courseId}")
	public ResponseEntity<?> addModule(@PathVariable Long courseId, @RequestBody AddModule dto) {

		System.out.println("add Course to module");

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addModule(dto, courseId));

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllCourses() {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(courseService.getAllCourses());
			// here we are using Response entity send the response in body using service
			// reference

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCourses(@PathVariable Long id) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(courseService.getCourseById(id));

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}

	@GetMapping("module/{id}")
	public ResponseEntity<?> getAllModules(@PathVariable Long id) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(courseService.getModulesByCourseId(id));

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCourseDetails(@RequestBody CourseDTO courseDto, @PathVariable Long id) {
		System.out.println("in update " + id + " " + courseDto);
		return ResponseEntity.ok(courseService.updateCourseDetails(id, courseDto));
	}
}
