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
	private String jwt;

	public ApiResponse(String msg) {
		this.msg=msg;
		this.cuurent=LocalDateTime.now();
	}
	
	public ApiResponse(String msg,String jwt) {
		this.msg = msg;
		this.cuurent = LocalDateTime.now();
		this.jwt=jwt;
		
	}
}
