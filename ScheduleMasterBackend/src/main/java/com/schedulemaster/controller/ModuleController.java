package com.schedulemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

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
	@GetMapping("/{id}")
	public ResponseEntity<?> getModules(@PathVariable Long id) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(moduleServices.getModuleById(id));
			// here we are using Response entity send the response in body using service
			// reference

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResourceAccessException("Something went Wrong!!"));
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateModuleDetails (@RequestBody AddModuleDTO moduleDTO , @PathVariable Long id){
		System.out.println("in update " + id + " " + moduleDTO);
		return ResponseEntity.ok(moduleServices.updateModuleDetails(id, moduleDTO));
	}
}
