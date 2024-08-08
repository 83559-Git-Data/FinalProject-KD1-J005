package com.schedulemaster.services;

import com.schedulemaster.dto.ApiResponse;
import com.schedulemaster.dto.ScheduleRequestDTO;

public interface ScheduleService {
	public ApiResponse createNewSchedule(ScheduleRequestDTO dto);
}
