package com.schedulemaster.services;

import java.time.LocalDate;
import java.util.List;

import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.ScheduleRequestDTO;
import com.schedulemaster.pojos.Faculty;
import com.schedulemaster.pojos.Schedule;

public interface ScheduleService {
	public ApiResponse createNewSchedule(ScheduleRequestDTO dto);

	public List<Schedule> getAllSchedule();

	List<Schedule> getScheduleOfFaculty(Long id);

	public List<Schedule> getAvailableSchedules(LocalDate startDate, LocalDate endDate, Long facultyId, Long courseId, Long moduleId);
}

