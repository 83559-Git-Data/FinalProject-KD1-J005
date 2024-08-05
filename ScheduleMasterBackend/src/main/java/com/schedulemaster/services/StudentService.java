package com.schedulemaster.services;

import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.StudentRegistrationDTO;

public interface StudentService {
	public ApiResponse register(StudentRegistrationDTO dto , Long id);
}
