package com.schedulemaster.services;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schedulemaster.dao.CourseDao;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.CourseRegistrationDTO;
import com.schedulemaster.pojos.Course;

//for the use of modularity we have implemented interface

@Service
//The @Service annotation in Spring is used to indicate that a class is a "Service" and it is a 
//specialization of the @Component annotation. Service classes typically contain the business 
//logic of your application and are used to handle the processing required by the application, 
//separate from the controller and repository layers.

@Transactional
//The @Transactional annotation in Spring is used to manage transaction boundaries in a 
//declarative way. This annotation can be applied to classes or methods to define the 
//scope of a database transaction. When applied, it ensures that a series of operations
//within the annotated scope are executed within a transaction context.
public class CourseServicesImpl implements CourseService {
	
	@Autowired
	private CourseDao coursedao;
	
	@Autowired
	private ModelMapper map;
	// ModelMapper is a Java library used for object mapping. It helps in mapping
	// data between different object models, which is especially useful in scenarios
	// like mapping between database entities and Data Transfer Objects (DTOs), or
	// between various representations of data in your application. This is commonly
	// used in scenarios involving data transformation and reducing boilerplate
	// code.

	// course registration
	@Override
	public ApiResponse register(CourseRegistrationDTO dto) {
		Course course = map.map(dto, Course.class);
		// The map function in ModelMapper is used to copy values from one object to
		// another based on the mappings defined.
		System.out.println(course.toString());
		Course c = coursedao.save(course);
		return c!=null ? new ApiResponse("Course Registrated Successfully") : new ApiResponse("Course Registration Failed!!");
	}

}
