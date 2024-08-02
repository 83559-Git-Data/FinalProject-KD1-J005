package com.schedulemaster.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.schedulemaster.pojos.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	
}
