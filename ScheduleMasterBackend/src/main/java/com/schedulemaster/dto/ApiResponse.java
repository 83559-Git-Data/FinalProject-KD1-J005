package com.schedulemaster.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ApiResponse {
	private String msg;
	private LocalDateTime cuurent;

	public ApiResponse(String msg) {
		this.msg = msg;
		this.cuurent = LocalDateTime.now();
	}
}
