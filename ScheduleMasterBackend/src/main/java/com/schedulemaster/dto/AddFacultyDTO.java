package com.schedulemaster.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddFacultyDTO {
	private String panId;
	private LocalDate dob;
	private String address;
	private int currentAge;
	private String mobNo;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;

}
