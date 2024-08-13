package com.schedulemaster.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.schedulemaster.pojos.Schedule;

public interface ScheduleDao extends JpaRepository<Schedule, Long>{
	@Query("SELECT s FROM Schedule s WHERE " +
	           "(s.startDate <= :endDate AND s.endDate >= :startDate) " +
	           "AND (s.faculty.id = :facultyId " +
	           "OR s.course.id = :courseId " +
	           "OR s.module.id = :moduleId)")
	    List<Schedule> findOverlappingSchedules(@Param("startDate") LocalDate startDate,
	    		
	                                            @Param("endDate") LocalDate endDate,
	                                            @Param("facultyId") Long facultyId,
	                                            @Param("courseId") Long courseId,
	                                            @Param("moduleId") Long moduleId);
}
