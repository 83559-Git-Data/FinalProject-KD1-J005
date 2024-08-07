package com.schedulemaster.services;

import com.schedulemaster.dto.AddModuleDTO;
import com.schedulemaster.dto.ApiResponse;

public interface ModuleService {
	public ApiResponse addNewModule(AddModuleDTO dto);
	
}
