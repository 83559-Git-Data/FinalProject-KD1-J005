package com.schedulemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedulemaster.dto.AddModule;
import com.schedulemaster.dto.AddModuleDTO;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.services.ModuleService;

@RestController
@RequestMapping("/module")
public class ModuleController {
	@Autowired
	private ModuleService moduleServices;
	
	public ModuleController() {
		// TODO Auto-generated constructor stub
	}
	@PostMapping("/addmodule")
	public ResponseEntity<?> addModule(@RequestBody AddModuleDTO dto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(moduleServices.addNewModule(dto));
			} catch (RuntimeException e) {
				System.out.println(e);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new ApiResponse(e.getMessage()));
						
		}
	}
	
}
