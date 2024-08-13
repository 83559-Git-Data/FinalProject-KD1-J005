package com.schedulemaster.pojos;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "students")
public class Student extends BaseEntity{
	
	@Column(name = "mobile_no",length = 15,unique = true)
	private String mobileNumber;
	@Column(name = "address")
	private String address;
	@Column(name = "state",length = 50)
	private String state;
	@Column(name = "city",length = 50)
	private String city;
	@JoinColumn(name = "course_id")
	@ManyToOne
	@JsonIgnore
	private Course course;
	@Column(name = "enrolled_date")
	@CreatedDate	
	private LocalDate enrolledDate;
	@OneToOne
	@JoinColumn(name = "userId")
	private User userId;
}
