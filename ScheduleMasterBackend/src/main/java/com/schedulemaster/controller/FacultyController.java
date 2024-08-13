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

import com.schedulemaster.customexception.ApiException;
import com.schedulemaster.dto.AddFacultyDTO;
import com.schedulemaster.dto.AddModule;
import com.schedulemaster.dto.AddModuleDTO;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.LoginDTO;
import com.schedulemaster.dto.UpdateDTO;
import com.schedulemaster.dto.UserRegistertaionDTO;
import com.schedulemaster.exception.AuthenticationException;
import com.schedulemaster.services.FacultyServices;
import com.schedulemaster.services.UserService;

@RestController
//it is the annotation is having mixture of two annotation @RequestBody
//@Controller
//org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/faculty")
public class FacultyController {

	public FacultyController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private FacultyServices facultyService;
	@PostMapping("/profile/{id}")
	public ResponseEntity<?> addFacultyProfile(@RequestBody AddFacultyDTO dto,@PathVariable long id) {
		
		System.out.println("register");
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.addFaculty(dto,id));

		} catch (RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponse("Something went Wrong!!"));
		}
	}
	@PostMapping("/addmodule/{facultyId}")
	public ResponseEntity<?> addModule(@RequestBody AddModule dto,@PathVariable long facultyId) {
		
		System.out.println("register");
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.addModule(dto,facultyId));

		} catch (RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponse("Something went Wrong!!"));
		}
	}
	@GetMapping("module/{id}")
	public ResponseEntity<?> getAllModules(@PathVariable Long id) {
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.getModulesByFacultyId(id));
			

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getFaculty(@PathVariable Long id) {

		try {
			return ResponseEntity.ok(facultyService.getFacultyById(id));
			// here we are using Response entity send the response in body using service
			// reference

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateFacultyDetails (@RequestBody AddFacultyDTO facultyDTO , @PathVariable Long id){
		System.out.println("in update " + id + " " + facultyDTO);
		return ResponseEntity.ok(facultyService.updateFacultyDetails(id, facultyDTO));
	}

	@GetMapping("/allFaculties")
	public ResponseEntity<?> getFaculty() {

		try {
			return ResponseEntity.ok(facultyService.getAllFaculties());

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}
}
