package com.schedulemaster.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schedulemaster.pojos.Schedule;

public interface ScheduleDao extends JpaRepository<Schedule, Long>{

}
