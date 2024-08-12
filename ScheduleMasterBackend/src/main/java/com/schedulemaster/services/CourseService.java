package com.schedulemaster.services;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.schedulemaster.dto.AddModule;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.CourseDTO;
import com.schedulemaster.dto.CourseRegistrationDTO;
import com.schedulemaster.pojos.Course;
import com.schedulemaster.pojos.Module;

public interface CourseService {
	public ApiResponse register(@Valid CourseRegistrationDTO dto);
	
	ApiResponse addModule(AddModule dto,Long courseId);

	public List<CourseDTO> getAllCourses();
	public CourseDTO getCourseById(Long id);

	public List<Module> getModulesByCourseId(Long id);

	ApiResponse updateCourseDetails(Long id, CourseDTO courseDTO);
	}