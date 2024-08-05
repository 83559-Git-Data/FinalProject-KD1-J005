package com.schedulemaster.services;

import javax.validation.Valid;

import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.CourseRegistrationDTO;

public interface CourseService {
	public ApiResponse register(@Valid CourseRegistrationDTO dto);
}