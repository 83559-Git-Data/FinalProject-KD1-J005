package com.schedulemaster.services;

import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.StudentDTO;
import com.schedulemaster.dto.StudentRegistrationDTO;
import com.schedulemaster.pojos.Student;

public interface StudentService {
	public ApiResponse register(StudentRegistrationDTO dto , Long id);

	Student getStudentById(Long id);

	ApiResponse updateStudentById(Long id, StudentDTO studentdto);
	
}
