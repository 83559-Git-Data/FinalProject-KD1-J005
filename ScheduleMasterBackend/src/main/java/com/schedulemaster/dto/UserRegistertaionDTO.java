package com.schedulemaster.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.schedulemaster.pojos.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegistertaionDTO {
	public String firstName;
	//@Column(name = "last_name")
	public String lastName;
	//@Column(name = "username",length = 30,nullable = false ,unique = true)
	public String userName;
	//@Column(name = "password",length = 18,nullable = false)
	public String password;
	//@Column(name = "role")
	//@Enumerated(EnumType.STRING)
	public String role;
}
