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
//it is the annotation is having mixture of two annotation @RequestBody
//@Controller
//org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:3000")
//this allows the other platform to run on the current server having port 8080
//org.springframework.web.bind.annotation.CrossOrigin;

@RequestMapping("/course")
//this annotation is mapped the request with the method that come with a client request method
//org.springframework.web.bind.annotation.PostMapping;

//this class handles all the request that come from the client and by using front
//controller they just allow you to map the request with function
public class CourseController {

	public CourseController() {

	}

	@Autowired
	// org.springframework.beans.factory.annotation.Autowired;
	// this annotation allows Spring to resolve and inject collaborating beans into
	// your bean.
	// @Autowired(required = false) //this is annotation is used with argument to
	// make dependency optional
	private CourseService courseService;

	@PostMapping("/register")
	// The @PostMapping annotation is part of the Spring framework and is used
	// to handle HTTP POST requests in Spring MVC. It is a specialized version of
	// the
	// @RequestMapping annotation that acts specifically on HTTP POST requests.
	// The ResponseEntity class in Spring is used to represent the entire HTTP
	// response,
	// including the status code, headers, and body. It is a powerful tool for
	// creating
	// and customizing HTTP responses in your RESTful APIs.
	// The @RequestBody annotation in Spring MVC is used to bind the HTTP request
	// body
	// to a method parameter in a controller. This is particularly useful when you
	// need
	// to handle data sent in the body of an HTTP POST, PUT, or PATCH request, such
	// as JSON or XML data.

	public ResponseEntity<?> registerCourse(@RequestBody CourseRegistrationDTO dto) {
		// dto is genrally used to map the data comming from frontend
		// this data is mapped using Model mapper class map function
		System.out.println("register");
		// System.out.println(dto);

		// there is possibility that it can throw exception so we need to handle here in
		// try catch
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(courseService.register(dto));
			// here we are using Response entity send the response in body using service
			// reference

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}

	@PostMapping("/addmodule/{courseId}")
	public ResponseEntity<?> addModule(@PathVariable Long courseId, @RequestBody AddModule dto) {
		// dto is genrally used to map the data comming from frontend
		// this data is mapped using Model mapper class map function
		System.out.println("add Course to module");
		// System.out.println(dto);

		// there is possibility that it can throw exception so we need to handle here in
		// try catch
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addModule(dto, courseId));
			// here we are using Response entity send the response in body using service
			// reference

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
			// here we are using Response entity send the response in body using service
			// reference

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}

	@GetMapping("module/{id}")
	public ResponseEntity<?> getAllModules(@PathVariable Long id) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(courseService.getModulesByCourseId(id));
			// here we are using Response entity send the response in body using service
			// reference

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
