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
import org.springframework.web.client.ResourceAccessException;

import com.schedulemaster.dto.LoginDTO;
import com.schedulemaster.dto.UpdateDTO;
import com.schedulemaster.dto.UserRegistertaionDTO;
import com.schedulemaster.services.UserService;
@RestController
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/user")
public class UserController {
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserRegistertaionDTO dto){
		System.out.println("register");
//		System.out.println(dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
			.body(userService.register(dto));
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}
	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody LoginDTO dto){
		System.out.println("CONTROLLER "+dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
			.body(userService.Login(dto));
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}
	@PostMapping("/update/{id}")
	public ResponseEntity<?> Updateinfo(@PathVariable Long id,UpdateDTO dto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
			.body(userService.UpdateInfo(dto,id));
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}
}
