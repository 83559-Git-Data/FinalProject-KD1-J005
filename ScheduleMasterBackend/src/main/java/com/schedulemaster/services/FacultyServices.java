package com.schedulemaster.services;

import com.schedulemaster.dto.AddFacultyDTO;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.FacultyAddModule;

public interface FacultyServices {

	public ApiResponse addFaculty(AddFacultyDTO dto,Long id);
	
	public ApiResponse addModule(FacultyAddModule module,Long id);
}
