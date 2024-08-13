package com.schedulemaster.services;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schedulemaster.customexception.ResourceNotFoundException;
import com.schedulemaster.dao.CourseDao;
import com.schedulemaster.dao.StudentDao;
import com.schedulemaster.dao.UserDao;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.StudentDTO;
import com.schedulemaster.dto.StudentRegistrationDTO;
import com.schedulemaster.exception.AuthenticationException;
import com.schedulemaster.pojos.Course;
import com.schedulemaster.pojos.Role;
import com.schedulemaster.pojos.Student;
import com.schedulemaster.pojos.User;

@Service
@Transactional
public class StudentServicesImpl implements StudentService {
	
	@Autowired
	private StudentDao studentdao;
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private CourseDao coursedao;
	
	@Autowired
	private ModelMapper map;

	@Override
	public ApiResponse register(StudentRegistrationDTO dto, Long id) {
		System.out.println(dto.toString());
		System.out.println(id);
		User user = userdao.findById(id).orElseThrow(()-> new AuthenticationException("User Doesnt exitst"));
		Course c=coursedao.findByCourseName(dto.getCoursename()).orElseThrow(()-> new AuthenticationException("Course Doesnt exitst"));
		if(user.getRole().equals(Role.ROLE_STUDENT)) {
			System.out.println(user.toString());
			Student student = map.map(dto, Student.class);
			System.out.println(student.toString());
			student.setUserId(user);
			student.setCourse(c);
			System.out.println(student.toString());
			Student s = studentdao.save(student);
			return new ApiResponse("Profile updated successfully!!");
		}
		return new ApiResponse("Something failed!!");
	}

	@Override
	public Student getStudentById(Long id) {
		Student student = studentdao.findById(id).orElseThrow(() -> new ResourceNotFoundException("student not found!"));
		return student;
	}

	@Override
	public ApiResponse updateStudentById(Long id, StudentDTO studentdto) {
		Student student = studentdao.findById(id).orElseThrow(() -> new ResourceNotFoundException("student not found!"));
		student.setAddress(studentdto.getAddress());
		student.setCity(studentdto.getCity());
		student.setMobileNumber(studentdto.getMobileNumber());
		student.setState(studentdto.getState());

		User u = userdao.findById(student.getUserId().getId()).orElseThrow(() -> new ResourceNotFoundException("student not found!"));
		u.setFirstName(studentdto.getFirstName());
		u.setLastName(studentdto.getLastName());
		
		
		student.setUserId(u);
		
		Student s = studentdao.save(student);
		
		return s != null ? new ApiResponse("Student Updated Successfully")
				: new ApiResponse("Student Updatation Failed!!");
		
	}
	
	
	
	
	
}
