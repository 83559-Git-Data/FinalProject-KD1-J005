package com.schedulemaster.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateDTO {
	@NotBlank(message = "first name is required")
	public String firstName;
	@NotBlank(message = "last name is required")
	public String lastName;
}
