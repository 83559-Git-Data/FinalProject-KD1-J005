package com.schedulemaster.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schedulemaster.pojos.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Long>{

}
