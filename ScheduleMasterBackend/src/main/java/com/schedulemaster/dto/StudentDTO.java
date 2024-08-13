
package com.schedulemaster.dto;

import java.time.LocalDate;

import com.schedulemaster.pojos.Course;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {
	private String mobileNumber;
	private String address;
	private String state;
	private String city;
	private String firstName;
	private String lastName;
	
	
}
