package com.schedulemaster.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CourseRegistrationDTO {
	private String courseName;
	private double fees;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private int Capacity;

}
