package com.schedulemaster.services;

import java.util.List;

import com.schedulemaster.dto.AddFacultyDTO;
import com.schedulemaster.dto.AddModule;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.pojos.Faculty;
import com.schedulemaster.pojos.Module;
import com.schedulemaster.pojos.User;

public interface FacultyServices {

	public ApiResponse addFaculty(AddFacultyDTO dto,Long id);
	
	ApiResponse addModule(AddModule dto,Long id);

	public List<Module> getModulesByFacultyId(Long id);

	Faculty getFacultyById(Long id);

	ApiResponse updateFacultyDetails(Long id, AddFacultyDTO facultyDTO);
}
