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
import com.schedulemaster.dto.FacultyAddModule;
import com.schedulemaster.pojos.Faculty;
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
	public ApiResponse assignModuletoFaculty(FacultyAddModule dto,Long id) {
		Faculty faculty=facultyDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Faculty is mot valid"));
		Module module=moduleDao.findByName(dto.getName());
		if(faculty!=null && module!=null) {
			faculty.addModule(module);
		}
		return new ApiResponse("Module is assign to faculty");
	}

}
