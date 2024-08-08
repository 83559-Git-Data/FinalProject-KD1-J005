package com.schedulemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.schedulemaster.dto.ScheduleRequestDTO;
import com.schedulemaster.services.ScheduleService;
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createSchedule(@RequestBody ScheduleRequestDTO dto){
		
		
		try {
			return  ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createNewSchedule(dto));
			// here we are using Response entity send the response in body using service
			// reference

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}
	

}
