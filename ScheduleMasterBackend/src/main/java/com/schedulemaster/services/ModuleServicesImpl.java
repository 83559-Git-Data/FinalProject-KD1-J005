package com.schedulemaster.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schedulemaster.customexception.ResourceNotFoundException;
import com.schedulemaster.dao.FacultyDao;
import com.schedulemaster.dao.ModuleDao;
import com.schedulemaster.dto.AddModuleDTO;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.pojos.Module;
@Service
@Transactional
public class ModuleServicesImpl implements ModuleService{

	@Autowired
	private ModuleDao moduleDao;
	
	@Autowired
	private FacultyDao facultyDao;
	
	@Autowired 
	private ModelMapper map;
	
	@Override
	public ApiResponse addNewModule(AddModuleDTO dto) {
		Module model=map.map(dto, Module.class);
		Module m=moduleDao.save(model);
		return new ApiResponse("new module is added");
	}

	@Override
	public Module getModuleById(Long id) {
		Module module = moduleDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Module is not found!"));
		return module;
	}

	@Override
	public ApiResponse updateModuleDetails(Long id, AddModuleDTO moduleDTO) {
		Module module = moduleDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("module not found!"));
		
		module.setName(moduleDTO.getName());
		module.setHours(moduleDTO.getHours());
		
		Module moduleUpdated = moduleDao.save(module);
		return moduleUpdated != null ? new ApiResponse("Module Updated Successfully")
				: new ApiResponse("Module Updatation Failed!!");
	}



}
