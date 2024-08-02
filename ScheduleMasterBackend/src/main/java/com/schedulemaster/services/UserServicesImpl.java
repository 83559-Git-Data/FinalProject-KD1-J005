package com.schedulemaster.services;

import org.modelmapper.ModelMapper;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.schedulemaster.dao.UserDao;
import com.schedulemaster.dto.ApiResponse;
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
	
	
	
}
