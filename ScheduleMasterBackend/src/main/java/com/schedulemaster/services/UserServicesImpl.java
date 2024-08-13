package com.schedulemaster.services;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schedulemaster.customexception.ResourceNotFoundException;
import com.schedulemaster.dao.UserDao;
import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.LoginDTO;
import com.schedulemaster.dto.UpdateDTO;
import com.schedulemaster.dto.UserRegistertaionDTO;
import com.schedulemaster.pojos.User;
import com.schedulemaster.exception.*;


@Service
@Transactional
public class UserServicesImpl implements UserService {
	@Autowired
	
	private UserDao userDao;
	@Autowired
	private ModelMapper map;
	
	@Override
	public ApiResponse register(UserRegistertaionDTO dto) {
		// System.out.println(dto.toString());
		// dto.setRole(dto.getRole().toUpperCase());
		User user = map.map(dto, User.class);
		// The map function in ModelMapper is used to copy values from one object to
		// another based on the mappings defined.
		System.out.println(user.toString());
		User u = userDao.save(user);
		// this is called dao method that is inherited from the JPA Repository
		return u != null ? new ApiResponse("Registration Successfully") : new ApiResponse("Registartion failed!!");
	}

	@Override
	public ApiResponse Login(LoginDTO dto) {
		System.out.println(dto);
		User u = userDao.findByUserNameAndPassword(dto.getUserName(), dto.getPassword())
				.orElseThrow(() -> new RuntimeException("Invalid Email or Password !!!!!!"));
		if (u.isStatus() == true) {
			System.out.println(u.toString());
			return new ApiResponse("Login Successfully");
		}
		else {
			return new ApiResponse("Login failed!!");
		}
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

	@Override
	public ApiResponse deleteUser(Long id) {
		User user = userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
		user.setStatus(false);
		User u = userDao.save(user);
		return new ApiResponse("user is Deleted!");
	}

}
