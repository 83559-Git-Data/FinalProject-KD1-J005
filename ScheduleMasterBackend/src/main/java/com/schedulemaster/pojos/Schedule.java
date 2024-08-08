package com.schedulemaster.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="schedules")
public class Schedule extends BaseEntity{
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	@Column(name = "start_time")
	private LocalTime startTime;
	@Column(name = "end_time")
	private LocalTime endTime;
	@OneToOne
	@JoinColumn(name = "course_id")
	private Course course;
	@OneToOne
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;
	@OneToOne
	@JoinColumn(name = "module_id")
	private Module module;	
}
