package com.schedulemaster.services;

import java.util.List;

import com.schedulemaster.dto.AddFacultyDTO;
import com.schedulemaster.dto.AddModule;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.pojos.Module;

public interface FacultyServices {

	public ApiResponse addFaculty(AddFacultyDTO dto,Long id);
	
	ApiResponse addModule(AddModule dto,Long id);

	public List<Module> getModulesByFacultyId(Long id);
}
