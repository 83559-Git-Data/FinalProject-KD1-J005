package com.schedulemaster.services;

import java.util.List;

import com.schedulemaster.dto.AddModuleDTO;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.pojos.Faculty;
import com.schedulemaster.pojos.Module;

public interface ModuleService {
	public ApiResponse addNewModule(AddModuleDTO dto);

	Module getModuleById(Long id);

	ApiResponse updateModuleDetails(Long id, AddModuleDTO moduleDTO);

//	List<Faculty>  getAllFaculties(Long id);	
}
