package com.schedulemaster.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schedulemaster.dao.UserDao;
import com.schedulemaster.pojos.User;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDao userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// invoke dao's method
		User user = userRepo.findByUserName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("Email not found !!!!!" ));
		//=> user email exists - user : persistent
		return new CustomUserDetails(user);
	}

}
