package com.schedulemaster.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleRequestDTO {
	private LocalDate endDate;
	private LocalDate startDate;
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private String startTime;
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private String endTime;
	private Long courseId;
	private Long facultyId;
	private Long moduleId;
}
