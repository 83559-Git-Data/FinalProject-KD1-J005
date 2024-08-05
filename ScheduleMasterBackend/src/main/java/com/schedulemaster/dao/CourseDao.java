package com.schedulemaster.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schedulemaster.pojos.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}