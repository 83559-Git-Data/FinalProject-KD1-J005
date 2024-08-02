package com.schedulemaster.services;

import javax.validation.Valid;


import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.UserRegistertaionDTO;

public interface UserService {

	public ApiResponse register(@Valid UserRegistertaionDTO dto);


}
