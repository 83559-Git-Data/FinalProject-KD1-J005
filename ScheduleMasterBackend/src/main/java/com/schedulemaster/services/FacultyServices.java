package com.schedulemaster.services;

import com.schedulemaster.dto.AddFacultyDTO;
import com.schedulemaster.dto.ApiResponse;

public interface FacultyServices {

	public ApiResponse addFaculty(AddFacultyDTO dto,Long id);

}
