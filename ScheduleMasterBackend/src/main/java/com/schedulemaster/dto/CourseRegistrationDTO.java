package com.schedulemaster.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseRegistrationDTO {
	private String courseName;
	private double fees;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private int Capacity;
//	private List<String> modules;

}