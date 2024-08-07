package com.schedulemaster.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CourseDTO {
	private Long id;
    private String courseName;
    private double fees;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int capacity;
//    private Set<String> moduleNames;

    // Getters and Setters
}
