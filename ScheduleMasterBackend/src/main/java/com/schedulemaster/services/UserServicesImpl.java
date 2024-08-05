package com.schedulemaster.services;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.schedulemaster.dao.UserDao;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.LoginDTO;
import com.schedulemaster.dto.UpdateDTO;
import com.schedulemaster.dto.UserRegistertaionDTO;
import com.schedulemaster.pojos.User;
import com.schedulemaster.exception.*;

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
public class UserServicesImpl implements UserService {
	// dependencies
	@Autowired
	// org.springframework.beans.factory.annotation.Autowired;
	// this annotation allows Spring to resolve and inject collaborating beans into
	// your bean.
	// @Autowired(required = false) //this is annotation is used with argument to
	// make dependency optional
	private UserDao userDao;
	@Autowired
	private ModelMapper map;
	// ModelMapper is a Java library used for object mapping. It helps in mapping
	// data between different object models, which is especially useful in scenarios
	// like mapping between database entities and Data Transfer Objects (DTOs), or
	// between various representations of data in your application. This is commonly
	// used in scenarios involving data transformation and reducing boilerplate
	// code.

	// Registration API
	@Override
	public ApiResponse register(UserRegistertaionDTO dto) {
		// System.out.println(dto.toString());
		// dto.setRole(dto.getRole().toUpperCase());
		User user = map.map(dto, User.class);
		// The map function in ModelMapper is used to copy values from one object to
		// another based on the mappings defined.
		System.out.println(user.toString());
		User u = userDao.save(user);
		//this is called dao method that is inherited from the JPA Repository
		return u != null ? new ApiResponse("Registration Successfully") : new ApiResponse("Registartion failed!!");
	}

	@Override
	public ApiResponse Login(LoginDTO dto) {
		System.out.println(dto);
		User u = userDao.findByUserNameAndPassword(dto.getUsername(), dto.getPassword())
				.orElseThrow(() -> new RuntimeException("Invalid Email or Password !!!!!!"));
		System.out.println(u.toString());
		return u != null ? new ApiResponse("Login Successfully") : new ApiResponse("Login failed!!");
	}

	@Override
	public ApiResponse UpdateInfo(UpdateDTO dto, Long id) {
		User user = userDao.findById(id).orElseThrow();
		if (user != null) {
			user.setFirstName(dto.getFirstName());
			user.setLastName(dto.getLastName());
			// userDao.save(user); this is also make update in the database if the id will
			// get find and if id will not get found then it will add new record i guess
			userDao.flush();
			return new ApiResponse("information is updated Successfully");
		}
		return new ApiResponse("something went Wrong!");
	}

}
