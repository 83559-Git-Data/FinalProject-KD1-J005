package com.schedulemaster.services;

import com.schedulemaster.dto.AddModuleDTO;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.FacultyAddModule;

public interface ModuleService {
	public ApiResponse addNewModule(AddModuleDTO dto);
	public ApiResponse assignModuletoFaculty(FacultyAddModule dto,Long id);
}
