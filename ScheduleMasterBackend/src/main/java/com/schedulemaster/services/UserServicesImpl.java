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

@Service
@Transactional
public class UserServicesImpl implements UserService{
	//dependencies
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper map;
	
	//Registration API
	@Override
	public ApiResponse register(UserRegistertaionDTO dto) {
		//System.out.println(dto.toString());
		//dto.setRole(dto.getRole().toUpperCase());
		User user=map.map(dto,User.class);
		System.out.println(user.toString());
		User u=userDao.save(user);
		return u!=null ? new ApiResponse("Registration Successfully"):new ApiResponse("Registartion failed!!");
	}
	@Override
	public ApiResponse Login(LoginDTO dto) {
		System.out.println(dto);
		User u=userDao.findByUserNameAndPassword(dto.getUsername(),dto.getPassword())
				.orElseThrow(()->new RuntimeException("Invalid Email or Password !!!!!!"));
		System.out.println(u.toString());
		return u!= null ? new ApiResponse("Login Successfully"):new ApiResponse("Login failed!!");
	}
	@Override
	public ApiResponse UpdateInfo(UpdateDTO dto, Long id) {
		User user=userDao.findById(id).orElseThrow();
		if(user!=null) {
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		//userDao.save(user); this is also make update in the database if the id will 
		//get find and if id will not get found then it will add new record i guess
		userDao.flush();
		return new ApiResponse("information is updated Successfully");
		}
		return new ApiResponse("something went Wrong!");
	}
	
}
