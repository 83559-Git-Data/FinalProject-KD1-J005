package com.schedulemaster.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schedulemaster.pojos.Student;

public interface StudentDao extends JpaRepository<Student, Long>{
	
}
