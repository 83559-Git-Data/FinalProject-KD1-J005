package com.schedulemaster.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
	//@NotBlank(message = "username can't be blank")
	private String username;
	//@NotBlank(message = "Password is required!")
	private String password;
}
