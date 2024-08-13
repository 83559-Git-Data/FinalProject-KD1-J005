package com.schedulemaster.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schedulemaster.pojos.User;

public interface UserDao extends JpaRepository<User, Long>{
	Optional<User> findByUserNameAndPassword  (String username, String password);

	Optional<User> findByUserName(String userName);

}
